package com.mercadolibre.www.mercadopago.mvp.view.activity;

import android.support.v4.app.Fragment;

import com.mercadolibre.www.mercadopago.mvp.core.BaseMVP;
import com.mercadolibre.www.mercadopago.mvp.model.InfoAlert;

public interface PaymentViewI extends BaseMVP.View {
    void initFragmentView();

    void managementFragmentView(Fragment fragment);

    void managementPopBackStack();

    void showAlertDialog(InfoAlert infoAlert);
}
