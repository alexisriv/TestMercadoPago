package com.mercadolibre.www.mercadopago.mvp.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.List;

public interface ICommonAdapter<T extends RecyclerView.ViewHolder, J> {

    T getView(View parent, int viewType);

    J getElement(int i);

    List<J> getCollection();

    void setCollection(List<J> collection);

    void addCollection(List<J> collection);

    void clearCollection();
}
