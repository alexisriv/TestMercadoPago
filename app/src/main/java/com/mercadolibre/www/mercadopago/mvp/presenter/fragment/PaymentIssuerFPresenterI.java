package com.mercadolibre.www.mercadopago.mvp.presenter.fragment;

import com.mercadolibre.www.mercadopago.networking.pojo.Issuer;

public interface PaymentIssuerFPresenterI extends CommonPaymentFPresenter {

    void loadFragment(Issuer issuer);

    void setParameters(float amount, String idPayment);
}
