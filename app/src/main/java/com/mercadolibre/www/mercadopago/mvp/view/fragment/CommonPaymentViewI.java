package com.mercadolibre.www.mercadopago.mvp.view.fragment;

import com.mercadolibre.www.mercadopago.mvp.core.BaseMVP;
import com.mercadolibre.www.mercadopago.mvp.model.Item;

import java.util.List;

public interface CommonPaymentViewI  extends BaseMVP.FragmentView {

    void setRefreshStatusView(boolean is);

    void setVisibleErrorInView(boolean b);

    void setErrorInView(int idMessage, int idImage);

    void loadItemsView(List<Item> items);
}
