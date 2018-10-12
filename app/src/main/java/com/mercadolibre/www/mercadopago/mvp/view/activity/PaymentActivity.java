package com.mercadolibre.www.mercadopago.mvp.view.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;

import com.mercadolibre.www.mercadopago.R;
import com.mercadolibre.www.mercadopago.mvp.core.CustomAppCompatActivity;
import com.mercadolibre.www.mercadopago.mvp.core.OnFragmentInteractionListener;
import com.mercadolibre.www.mercadopago.mvp.presenter.activity.PaymentPresenter;
import com.mercadolibre.www.mercadopago.mvp.presenter.activity.PaymentPresenterI;
import com.mercadolibre.www.mercadopago.mvp.view.fragment.PaymentFragment;

public class PaymentActivity extends CustomAppCompatActivity<PaymentPresenterI> implements PaymentViewI, OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        setPresenter(new PaymentPresenter(this));
    }

    @Override
    public void initView() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public void initFragmentView() {
        Fragment fragment = PaymentFragment.getInstance();
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment, fragment, "")
                .commit();
    }

    @Override
    public void managementFragmentView(Fragment fragment) {
        if (fragment == null)
            return;
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
