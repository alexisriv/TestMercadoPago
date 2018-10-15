package com.mercadolibre.www.mercadopago.mvp.presenter.fragment;

import com.mercadolibre.www.mercadopago.networking.pojo.PaymentMethod;

public interface PaymentMethodFPresenterI extends CommonPaymentFPresenter {

    void loadFragment(PaymentMethod paymentMethod);
}
