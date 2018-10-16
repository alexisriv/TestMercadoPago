package com.mercadolibre.www.mercadopago.mvp.presenter.activity;

import android.support.v4.app.Fragment;

import com.mercadolibre.www.mercadopago.mvp.core.BaseMVP;
import com.mercadolibre.www.mercadopago.networking.pojo.PayerCost;
import com.mercadolibre.www.mercadopago.networking.pojo.PaymentMethod;

public interface PaymentPresenterI extends BaseMVP.Presenter {

    void loadFragment(Fragment fragment, boolean isBack);

    void buildAlertDialog();

    void setInfo(Object o);
}
