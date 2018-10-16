package com.mercadolibre.www.mercadopago.mvp.view.fragment;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialogFragment;

import com.mercadolibre.www.mercadopago.R;
import com.mercadolibre.www.mercadopago.mvp.model.InfoAlert;

import static com.mercadolibre.www.mercadopago.mvp.core.BundleUtils.KEY_INFO_ALERT;

public class DialogInfoPayment extends AppCompatDialogFragment {

    private InfoAlert infoAlert;

    private static DialogInfoPayment instance;

    public static DialogInfoPayment newInstance(InfoAlert infoAlert) {
        DialogInfoPayment instance = new DialogInfoPayment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(KEY_INFO_ALERT, infoAlert);
        instance.setArguments(bundle);
        return instance;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            this.infoAlert = (InfoAlert) getArguments().getSerializable(KEY_INFO_ALERT);
        }
    }

    public DialogInfoPayment() {
    }


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
//        @SuppressLint("StringFormatMatches")
        String message = getActivity().getResources().getString(R.string.message_info, infoAlert.getPaymentMethod().getName(), infoAlert.getIssuer().getName(), infoAlert.getPayerCost().getRecommendedMessage(), infoAlert.getPayerCost().getTotalAmount());

        builder.setMessage(message)
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dismiss();
                    }
                })
                .setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dismiss();
                    }
                });
        return builder.create();
    }
}
