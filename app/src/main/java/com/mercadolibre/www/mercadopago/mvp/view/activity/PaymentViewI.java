package com.mercadolibre.www.mercadopago.mvp.view.activity;

import android.support.v4.app.Fragment;

import com.mercadolibre.www.mercadopago.mvp.core.BaseMVP;

public interface PaymentViewI extends BaseMVP.View {
    void initFragmentView();

    void managementFragmentView(Fragment fragment);

    void managementPopBackStack(Fragment fragment);
}
