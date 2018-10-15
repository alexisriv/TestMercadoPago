package com.mercadolibre.www.mercadopago.mvp.view.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mercadolibre.www.mercadopago.mvp.view.adapter.holder.CommonViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Common class for adapters.
 *
 * @param <T> Type to ViewHolder
 * @param <J> Type to List
 */
public abstract class CommonAdapter<T extends CommonViewHolder, J> extends RecyclerView.Adapter<T> implements ICommonAdapter<T, J> {

    private View view;
    private List<J> _collection = new ArrayList<J>();
    private int rId;

    public CommonAdapter(List<J> collection, int rId) {
        this._collection = collection;
        this.rId = rId;
    }

    public CommonAdapter(List<J> collection) {
        this._collection = collection;
    }

    @NonNull
    @Override
    public T onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        this.view = LayoutInflater.from(parent.getContext()).inflate(rId, parent, false);
        return this.getView(view, viewType);
    }

    @Override
    public void onBindViewHolder(@NonNull CommonViewHolder holder, int position) {
        holder.bind(this.getElement(position), position, getCollection().size());
    }

    @Override
    public int getItemCount() {
        return _collection.size();
    }

    @Override
    public abstract T getView(View view, int viewType);

    @Override
    public J getElement(int i) {
        return this._collection.get(i);
    }

    @Override
    public List<J> getCollection() {
        return _collection;
    }

    @Override
    public void setCollection(List<J> collection) {
        this._collection.clear();
        this._collection = collection;
        this.notifyDataSetChanged();
    }

    @Override
    public void addCollection(List<J> collection) {
        this._collection.addAll(_collection.size(), collection);
        this.notifyDataSetChanged();
    }

    @Override
    public void clearCollection() {
        this._collection.clear();
        this.notifyDataSetChanged();
    }
}
