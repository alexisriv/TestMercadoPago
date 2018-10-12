package com.mercadolibre.www.mercadopago.mvp.presenter.fragment;

import com.mercadolibre.www.mercadopago.mvp.core.CustomFPresenter;
import com.mercadolibre.www.mercadopago.mvp.view.fragment.PaymentMethodFViewI;

public class PaymentMethodFPresenter extends CustomFPresenter<PaymentMethodFViewI> implements PaymentMethodFPresenterI {

    public PaymentMethodFPresenter(PaymentMethodFViewI viewFragment) {
        super(viewFragment);
    }
}
