package com.mercadolibre.www.mercadopago.mvp.core;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public abstract class CustomFragment<T extends BaseMVP.FragmentPresenter> extends Fragment implements BaseMVP.FragmentView {

    protected T presenter;

    public View onGenerateView(int id, T presenter, @NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(id, container, false);
        this.presenter = presenter;
        initView(view);
        return view;
    }

    /**
     * @nota execute before setPresenter(T presenter)
     * @param id int layout
     * @param inflater  LayoutInflater
     * @param container ViewGroup
     * @param savedInstanceState Bundle
     * @return view inflate layout
     */
    public View onGenerateView(int id, @NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(id, container, false);
        initView(view);
        return view;
    }

    public void setPresenter(T presenter) {
        this.presenter = presenter;
    }

    public abstract void initView(View view);

    @Override
    public void toastShow(String message, int length) {
        Toast.makeText(getActivity(), message, length).show();
    }

    @Override
    public void toastShow(int message, int length) {
        Toast.makeText(getActivity(), message, length).show();
    }
}
