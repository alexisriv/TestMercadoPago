package com.mercadolibre.www.mercadopago.mvp.core;

public abstract class CustomPresenter<T extends BaseMVP.View> {

    protected T view;

    public CustomPresenter(T view) {
        this.view = view;
        this.view.initView();
    }

}
