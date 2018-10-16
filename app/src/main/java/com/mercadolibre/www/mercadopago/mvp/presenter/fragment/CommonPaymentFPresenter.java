package com.mercadolibre.www.mercadopago.mvp.presenter.fragment;

import com.mercadolibre.www.mercadopago.mvp.core.BaseMVP;

public interface CommonPaymentFPresenter extends BaseMVP.FragmentPresenter {

    void initServices();

    void refresh();

    void finishFragment();
}
