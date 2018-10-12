package com.mercadolibre.www.mercadopago.mvp.presenter.activity;

import android.support.v4.app.Fragment;

import com.mercadolibre.www.mercadopago.mvp.core.BaseMVP;

public interface PaymentPresenterI extends BaseMVP.Presenter {
    void loadFragment(Fragment fragment);
}
