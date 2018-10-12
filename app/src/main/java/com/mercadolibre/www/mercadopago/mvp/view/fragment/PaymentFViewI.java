package com.mercadolibre.www.mercadopago.mvp.view.fragment;

import android.support.v4.app.Fragment;

import com.mercadolibre.www.mercadopago.mvp.core.BaseMVP;

public interface PaymentFViewI extends BaseMVP.FragmentView {

    void errorView(int idResourceString);

}
