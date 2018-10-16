package com.mercadolibre.www.mercadopago.mvp.view.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mercadolibre.www.mercadopago.R;
import com.mercadolibre.www.mercadopago.mvp.core.CustomFragment;
import com.mercadolibre.www.mercadopago.mvp.model.Item;
import com.mercadolibre.www.mercadopago.mvp.presenter.activity.PaymentPresenter;
import com.mercadolibre.www.mercadopago.mvp.presenter.activity.PaymentPresenterI;
import com.mercadolibre.www.mercadopago.mvp.presenter.fragment.PaymentMethodFPresenter;
import com.mercadolibre.www.mercadopago.mvp.presenter.fragment.PaymentMethodFPresenterI;
import com.mercadolibre.www.mercadopago.mvp.view.adapter.ItemAdapter;
import com.mercadolibre.www.mercadopago.mvp.view.adapter.holder.ItemHolder;
import com.mercadolibre.www.mercadopago.networking.pojo.PaymentMethod;

import java.util.ArrayList;
import java.util.List;

import static com.mercadolibre.www.mercadopago.mvp.core.BundleUtils.KEY_AMOUNT;

public class PaymentMethodFragment extends CustomFragment<PaymentMethodFPresenterI> implements PaymentMethodFViewI, SwipeRefreshLayout.OnRefreshListener, ItemHolder.CustomOnClickListener<PaymentMethod>, SearchView.OnQueryTextListener {

    private SwipeRefreshLayout mSwipeRefreshLayout;
    private ItemAdapter mAdapter;
    private float amount;
    private TextView messageTextView;
    private ImageView messageIconImageView;

    public PaymentMethodFragment() {
    }

    public static PaymentMethodFragment newInstance(float amount) {
        PaymentMethodFragment fragment = new PaymentMethodFragment();
        Bundle bundle = new Bundle();
        bundle.putFloat(KEY_AMOUNT, amount);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            this.amount = getArguments().getFloat(KEY_AMOUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        return this.onGenerateView(R.layout.fragment_payment_method, new PaymentMethodFPresenter(this), inflater, container, savedInstanceState);
    }

    @Override
    public void initView(View view) {
        ((PaymentPresenter) onFragmentInteractionListener.getPresenter()).loadTitle(R.string.title_type);

        this.messageIconImageView = view.findViewById(R.id.messageIconImageView);
        this.messageTextView = view.findViewById(R.id.messageTextView);

        this.mSwipeRefreshLayout = view.findViewById(R.id.paymentMethodSwipeRefreshLayout);

        RecyclerView recyclerView = view.findViewById(R.id.paymentMethodRecyclerView);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        this.mAdapter = new ItemAdapter(new ArrayList<Item>(), this);
        recyclerView.setAdapter(this.mAdapter);

        this.mSwipeRefreshLayout.setOnRefreshListener(this);

        this.presenter.setParameters(this.amount);
        this.presenter.initServices();
    }

    @Override
    public void nextFragment(Fragment fragment) {
        ((PaymentPresenterI) onFragmentInteractionListener.getPresenter()).loadFragment(fragment, false);
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

    @Override
    public void setInfo(PaymentMethod paymentMethod) {
        ((PaymentPresenterI) onFragmentInteractionListener.getPresenter()).setInfo(paymentMethod);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_search, menu);
        MenuItem menuItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setOnQueryTextListener(this);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onQueryTextSubmit(String s) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {
        this.presenter.filterCollection(s);
        return false;
    }

    @Override
    public void setErrorInView(int idMessage, int idImage) {
        messageIconImageView.setVisibility(View.VISIBLE);
        messageTextView.setVisibility(View.VISIBLE);
        messageIconImageView.setImageResource(idImage);
        messageTextView.setText(idMessage);
    }

    @Override
    public void setVisibleErrorInView(boolean b) {
        int id = b ? View.VISIBLE : View.GONE;
        messageIconImageView.setVisibility(id);
        messageTextView.setVisibility(id);
    }

    @Override
    public void onPause() {
        super.onPause();
        this.presenter.finishFragment();
    }
}
