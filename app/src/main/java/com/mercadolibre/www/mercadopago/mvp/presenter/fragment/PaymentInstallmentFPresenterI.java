package com.mercadolibre.www.mercadopago.mvp.presenter.fragment;

import com.mercadolibre.www.mercadopago.networking.pojo.PayerCost;

public interface PaymentInstallmentFPresenterI extends CommonPaymentFPresenter {

    void setParameters(float amount, String idPayment, String idIssuer);

    void loadFragment(PayerCost payerCost);
}
