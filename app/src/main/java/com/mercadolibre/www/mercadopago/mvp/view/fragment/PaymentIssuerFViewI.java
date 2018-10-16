package com.mercadolibre.www.mercadopago.mvp.view.fragment;

import com.mercadolibre.www.mercadopago.networking.pojo.Issuer;

public interface PaymentIssuerFViewI extends CommonPaymentViewI {

    void setInfo(Issuer issuer);
}
