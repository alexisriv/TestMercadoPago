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
import com.mercadolibre.www.mercadopago.mvp.presenter.activity.PaymentPresenterI;
import com.mercadolibre.www.mercadopago.mvp.presenter.fragment.PaymentInstallmentFPresenter;
import com.mercadolibre.www.mercadopago.mvp.presenter.fragment.PaymentInstallmentFPresenterI;
import com.mercadolibre.www.mercadopago.mvp.view.activity.PaymentViewI;
import com.mercadolibre.www.mercadopago.mvp.view.adapter.ItemAdapter;
import com.mercadolibre.www.mercadopago.mvp.view.adapter.holder.ItemHolder;
import com.mercadolibre.www.mercadopago.networking.pojo.Issuer;
import com.mercadolibre.www.mercadopago.networking.pojo.PayerCost;

import java.util.ArrayList;
import java.util.List;

import static com.mercadolibre.www.mercadopago.mvp.core.BundleUtils.KEY_AMOUNT;
import static com.mercadolibre.www.mercadopago.mvp.core.BundleUtils.KEY_ID_ISSUER;
import static com.mercadolibre.www.mercadopago.mvp.core.BundleUtils.KEY_ID_PAYMENT;


public class PaymentInstallmentFragment extends CustomFragment<PaymentInstallmentFPresenterI> implements PaymentInstallmentFViewI, SwipeRefreshLayout.OnRefreshListener, ItemHolder.CustomOnClickListener<PayerCost> {

    private SwipeRefreshLayout mSwipeRefreshLayout;
    private ItemAdapter mAdapter;
    private float amount;
    private String idPayment, idIssuer;

    public PaymentInstallmentFragment() {
    }

    public static PaymentInstallmentFragment newInstance(float amount, String idPayment, String idIssuer) {
        PaymentInstallmentFragment fragment = new PaymentInstallmentFragment();
        Bundle bundle = new Bundle();
        bundle.putFloat(KEY_AMOUNT, amount);
        bundle.putString(KEY_ID_PAYMENT, idPayment);
        bundle.putString(KEY_ID_ISSUER, idIssuer);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            this.amount = getArguments().getFloat(KEY_AMOUNT);
            this.idPayment = getArguments().getString(KEY_ID_PAYMENT);
            this.idIssuer = getArguments().getString(KEY_ID_ISSUER);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return this.onGenerateView(R.layout.fragment_payment_method, new PaymentInstallmentFPresenter(this), inflater, container, savedInstanceState);
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

        this.presenter.setParameters(this.amount, this.idPayment, this.idIssuer);
        this.presenter.initServices();
    }

    @Override
    public void nextFragment(Fragment fragment) {
        ((PaymentPresenterI) onFragmentInteractionListener.getPresenter()).loadFragment(fragment, true);
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
    public void onClick(View view, PayerCost payerCost) {
        this.presenter.loadFragment(payerCost);
    }
}
