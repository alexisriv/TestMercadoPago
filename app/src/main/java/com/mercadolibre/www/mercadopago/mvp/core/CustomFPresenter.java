package com.mercadolibre.www.mercadopago.mvp.core;

public abstract class CustomFPresenter<T extends BaseMVP.FragmentView> {

    protected T viewFragment;

    public CustomFPresenter(T viewFragment) {
        this.viewFragment = viewFragment;
    }
}
