package com.mercadolibre.www.mercadopago.mvp.view.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mercadolibre.www.mercadopago.R;
import com.mercadolibre.www.mercadopago.mvp.core.CustomFragment;
import com.mercadolibre.www.mercadopago.mvp.model.Item;
import com.mercadolibre.www.mercadopago.mvp.presenter.fragment.PaymentMethodFPresenter;
import com.mercadolibre.www.mercadopago.mvp.presenter.fragment.PaymentMethodFPresenterI;
import com.mercadolibre.www.mercadopago.mvp.view.activity.PaymentViewI;
import com.mercadolibre.www.mercadopago.mvp.view.adapter.ItemAdapter;
import com.mercadolibre.www.mercadopago.mvp.view.adapter.holder.ItemHolder;
import com.mercadolibre.www.mercadopago.networking.pojo.PaymentMethod;

import java.util.ArrayList;
import java.util.List;

public class PaymentMethodFragment extends CustomFragment<PaymentMethodFPresenterI> implements PaymentMethodFViewI, SwipeRefreshLayout.OnRefreshListener, ItemHolder.CustomOnClickListener<PaymentMethod> {

    private SwipeRefreshLayout mSwipeRefreshLayout;
    private ItemAdapter mAdapter;

    public PaymentMethodFragment() {
    }

    public static PaymentMethodFragment newInstance() {
        PaymentMethodFragment fragment = new PaymentMethodFragment();
        Bundle bundle = new Bundle();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return this.onGenerateView(R.layout.fragment_payment_method, new PaymentMethodFPresenter(this), inflater, container, savedInstanceState);
    }

    @Override
    public void initView(View view) {
        this.mSwipeRefreshLayout = view.findViewById(R.id.paymentMethodSwipeRefreshLayout);

        RecyclerView recyclerView = view.findViewById(R.id.paymentMethodRecyclerView);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        this.mAdapter = new ItemAdapter(new ArrayList<Item>(), this);
        recyclerView.setAdapter(this.mAdapter);

        this.mSwipeRefreshLayout.setOnRefreshListener(this);
        this.presenter.initServices();
    }

    @Override
    public void nextFragment(Fragment fragment) {
        ((PaymentViewI) onFragmentInteractionListener).managementFragmentView(fragment);
    }

    @Override
    public void onRefresh() {
        this.presenter.refresh();
    }

    @Override
    public void setRefreshStatusView(boolean is) {
        this.mSwipeRefreshLayout.setRefreshing(is);
    }

    @Override
    public void loadItemsView(List<Item> items) {
        this.mAdapter.setCollection(items);
    }


    @Override
    public void onClick(View view, PaymentMethod paymentMethod) {
        this.presenter.loadFragment(paymentMethod);
    }
}
