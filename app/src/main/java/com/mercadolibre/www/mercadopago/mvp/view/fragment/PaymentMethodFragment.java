package com.mercadolibre.www.mercadopago.mvp.view.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mercadolibre.www.mercadopago.R;
import com.mercadolibre.www.mercadopago.mvp.core.CustomFragment;
import com.mercadolibre.www.mercadopago.mvp.presenter.fragment.PaymentMethodFPresenter;
import com.mercadolibre.www.mercadopago.mvp.presenter.fragment.PaymentMethodFPresenterI;

public class PaymentMethodFragment extends CustomFragment<PaymentMethodFPresenterI> implements PaymentMethodFViewI {

    public PaymentMethodFragment() {
    }

    public static PaymentMethodFragment newInstance() {
        PaymentMethodFragment fragment = new PaymentMethodFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return onGenerateView(R.layout.fragment_payment_method, new PaymentMethodFPresenter(this), inflater, container, savedInstanceState);
    }

    @Override
    public void initView(View view) {
    }

    @Override
    public void nextFragment(Fragment fragment) {

    }
}
