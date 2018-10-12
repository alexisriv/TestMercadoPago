package com.mercadolibre.www.mercadopago.mvp.presenter.activity;

import android.support.v4.app.Fragment;

import com.mercadolibre.www.mercadopago.mvp.core.CustomPresenter;
import com.mercadolibre.www.mercadopago.mvp.view.activity.PaymentViewI;

public class PaymentPresenter extends CustomPresenter<PaymentViewI> implements PaymentPresenterI {

    public PaymentPresenter(PaymentViewI view) {
        super(view);
    }

    @Override
    public void onSubscribe() {

    }

    @Override
    public void onUnsubscribe() {

    }

    @Override
    public void loadFragment(Fragment fragment) {
        this.view.managementFragmentView(fragment);
    }
}
