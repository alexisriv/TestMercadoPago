package com.mercadolibre.www.mercadopago.mvp.view.adapter.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

public abstract class CommonViewHolder<T> extends RecyclerView.ViewHolder implements IBindHolder<T> {

    public CommonViewHolder(View itemView) {
        super(itemView);
    }
}
