package com.mercadolibre.www.mercadopago.mvp.presenter.fragment;

import com.mercadolibre.www.mercadopago.mvp.core.BaseMVP;

public interface PaymentFPresenterI extends BaseMVP.FragmentPresenter {

    void validateAmount(String amount);
}
