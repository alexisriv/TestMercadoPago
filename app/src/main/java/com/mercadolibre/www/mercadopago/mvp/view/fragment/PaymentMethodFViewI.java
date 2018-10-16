package com.mercadolibre.www.mercadopago.mvp.view.fragment;

import com.mercadolibre.www.mercadopago.networking.pojo.PaymentMethod;

public interface PaymentMethodFViewI extends CommonPaymentViewI {

    void setInfo(PaymentMethod paymentMethod);
}
