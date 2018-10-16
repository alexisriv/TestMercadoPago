package com.mercadolibre.www.mercadopago.mvp.view.fragment;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.mercadolibre.www.mercadopago.R;
import com.mercadolibre.www.mercadopago.mvp.core.GlideApp;
import com.mercadolibre.www.mercadopago.mvp.model.InfoAlert;

import java.io.Serializable;

import static com.mercadolibre.www.mercadopago.mvp.core.BundleUtils.KEY_INFO_ALERT;
import static com.mercadolibre.www.mercadopago.mvp.core.BundleUtils.KEY_SELECTED_OPTION;

public class DialogInfoPayment extends AppCompatDialogFragment {

    private InfoAlert infoAlert;
    private SelectedOption selectedOption;

    private static DialogInfoPayment instance;

    public static DialogInfoPayment newInstance(InfoAlert infoAlert, SelectedOption selectedOption) {
        DialogInfoPayment instance = new DialogInfoPayment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(KEY_INFO_ALERT, infoAlert);
        bundle.putSerializable(KEY_SELECTED_OPTION, selectedOption);
        instance.setArguments(bundle);
        return instance;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            this.infoAlert = (InfoAlert) getArguments().getSerializable(KEY_INFO_ALERT);
            this.selectedOption = (SelectedOption) getArguments().getSerializable(KEY_SELECTED_OPTION);
        }
    }

    public DialogInfoPayment() {
    }


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater layoutInflater = getActivity().getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.dialog_info, null);

        this.initView(view);
        builder.setTitle(R.string.title_dialog);
        builder.setView(view)
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        selectedOption.onPositive();
                        dialogInterface.dismiss();
                    }
                }).setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        selectedOption.onNegative();
                        dialogInterface.dismiss();
                    }
                }
        );

        return builder.create();
    }

    private void initView(View view) {
        String message1 = getActivity().getResources().getString(R.string.message_info_1, infoAlert.getPaymentMethod().getName());
        String message2 = getActivity().getResources().getString(R.string.message_info_2, infoAlert.getIssuer().getName());
        String message3 = getActivity().getResources().getString(R.string.message_info_3, infoAlert.getPayerCost().getRecommendedMessage());


        ((TextView) view.findViewById(R.id.paymentMethodTextView)).setText(message1);
        ((TextView) view.findViewById(R.id.institutionTextView)).setText(message2);
        ((TextView) view.findViewById(R.id.payerCostTextView)).setText(message3);


        GlideApp.with(view)
                .load(infoAlert.getPaymentMethod().getSecureThumbnail())
                .into((ImageView) view.findViewById(R.id.paymentMethodImageView));

        GlideApp.with(view)
                .load(infoAlert.getIssuer().getSecureThumbnail())
                .into((ImageView) view.findViewById(R.id.institutionImageView));

    }

    public interface SelectedOption extends Serializable {
        void onPositive();

        void onNegative();
    }
}
