package com.mercadolibre.www.mercadopago.mvp.core;

public interface OnFragmentInteractionListener<T extends BaseMVP.Presenter> {
    T getPresenter();
}
