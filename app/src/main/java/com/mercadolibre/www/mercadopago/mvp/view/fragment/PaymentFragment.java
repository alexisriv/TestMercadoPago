package com.mercadolibre.www.mercadopago.mvp.view.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.mercadolibre.www.mercadopago.R;
import com.mercadolibre.www.mercadopago.mvp.core.CustomFragment;
import com.mercadolibre.www.mercadopago.mvp.presenter.activity.PaymentPresenterI;
import com.mercadolibre.www.mercadopago.mvp.presenter.fragment.PaymentFPresenter;
import com.mercadolibre.www.mercadopago.mvp.presenter.fragment.PaymentFPresenterI;

/**
 * A placeholder fragment containing a simple view.
 */
public class PaymentFragment extends CustomFragment<PaymentFPresenterI> implements PaymentFViewI, View.OnClickListener {

    private Button mButton;
    private EditText mEditText;
    private static PaymentFragment instance = new PaymentFragment();

    public static PaymentFragment getInstance() {
        return instance;
    }

    public PaymentFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return this.onGenerateView(R.layout.fragment_payment, new PaymentFPresenter(this), inflater, container, savedInstanceState);
    }

    @Override
    public void initView(View view) {
        view.findViewById(R.id.confirmationButton).setOnClickListener(this);

        this.mEditText = view.findViewById(R.id.amountEditText);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.confirmationButton:
                this.presenter.validateAmount(this.mEditText.getText().toString());
            default:
                break;
        }
    }

    @Override
    public void nextFragment(Fragment fragment) {
        ((PaymentPresenterI) onFragmentInteractionListener.getPresenter()).loadFragment(fragment);
    }

    @Override
    public void errorView(int idResourceString) {
        mEditText.setError(getResources().getString(idResourceString));
//        Snackbar.make(mEditText, getResources().getString(idResourceString), Snackbar.LENGTH_LONG)
//                .setAction("Action", null).show();
    }
}
