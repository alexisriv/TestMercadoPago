package com.mercadolibre.www.mercadopago.mvp.view.adapter;

import android.support.annotation.NonNull;
import android.view.View;

import com.mercadolibre.www.mercadopago.R;
import com.mercadolibre.www.mercadopago.mvp.model.Item;
import com.mercadolibre.www.mercadopago.mvp.view.adapter.holder.CommonViewHolder;
import com.mercadolibre.www.mercadopago.mvp.view.adapter.holder.ItemHolder;

import java.util.List;

public class ItemAdapter extends CommonAdapter<ItemHolder, Item> {

    private ItemHolder.CustomOnClickListener customOnClickListener;

    public ItemAdapter(List<Item> collection, ItemHolder.CustomOnClickListener customOnClickListener) {
        super(collection, R.layout.item);
        this.customOnClickListener = customOnClickListener;
    }

    @Override
    public ItemHolder getView(View view, int viewType) {
        return new ItemHolder(view, customOnClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull CommonViewHolder itemHolder, int i) {
        super.onBindViewHolder(itemHolder, i);
    }
}
