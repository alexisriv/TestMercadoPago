package com.mercadolibre.www.mercadopago.mvp.view.fragment;

import com.mercadolibre.www.mercadopago.networking.pojo.PayerCost;
import com.mercadolibre.www.mercadopago.networking.pojo.PaymentMethod;

public interface PaymentInstallmentFViewI extends CommonPaymentViewI {

    void showAlertView();

    void setInfo(PayerCost payerCost);

}
