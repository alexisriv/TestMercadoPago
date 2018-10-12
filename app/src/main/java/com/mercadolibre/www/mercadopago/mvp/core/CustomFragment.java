package com.mercadolibre.www.mercadopago.mvp.core;

import android.content.Context;
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
    protected OnFragmentInteractionListener<BaseMVP.Presenter> onFragmentInteractionListener;

    public View onGenerateView(int id, T presenter, @NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(id, container, false);
        this.presenter = presenter;
        initView(view);
        return view;
    }

    /**
     * @param id                 int layout
     * @param inflater           LayoutInflater
     * @param container          ViewGroup
     * @param savedInstanceState Bundle
     * @return view inflate layout
     * @nota execute before setPresenter(T presenter)
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

    @Override
    public void nextFragment(Fragment fragment) {

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            this.onFragmentInteractionListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        this.onFragmentInteractionListener = null;
    }
}
