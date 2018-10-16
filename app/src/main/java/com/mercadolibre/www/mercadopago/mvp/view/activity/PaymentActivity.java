package com.mercadolibre.www.mercadopago.mvp.view.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;

import com.mercadolibre.www.mercadopago.R;
import com.mercadolibre.www.mercadopago.mvp.core.CustomAppCompatActivity;
import com.mercadolibre.www.mercadopago.mvp.core.OnFragmentInteractionListener;
import com.mercadolibre.www.mercadopago.mvp.model.InfoAlert;
import com.mercadolibre.www.mercadopago.mvp.presenter.activity.PaymentPresenter;
import com.mercadolibre.www.mercadopago.mvp.presenter.activity.PaymentPresenterI;
import com.mercadolibre.www.mercadopago.mvp.view.fragment.DialogInfoPayment;
import com.mercadolibre.www.mercadopago.mvp.view.fragment.PaymentFragment;
import com.mercadolibre.www.mercadopago.mvp.view.fragment.PaymentMethodFragment;

public class PaymentActivity extends CustomAppCompatActivity<PaymentPresenterI> implements PaymentViewI, OnFragmentInteractionListener, DialogInfoPayment.SelectedOption {

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
        if (getSupportFragmentManager().findFragmentByTag(fragment.getClass().getName()) == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.fragment, fragment, fragment.getClass().getName())
                    .commit();
        }

    }

    @Override
    public void managementFragmentView(Fragment fragment) {
        if (fragment == null)
            return;
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment, fragment, fragment.getClass().getName());
        fragmentTransaction.addToBackStack(fragment.getClass().getName());
        fragmentTransaction.commit();
    }

    @Override
    public void managementPopBackStack() {
        getSupportFragmentManager().popBackStack(PaymentMethodFragment.class.getName(), FragmentManager.POP_BACK_STACK_INCLUSIVE);
    }

    @Override
    public void showAlertDialog(InfoAlert infoAlert) {
        DialogInfoPayment.newInstance(infoAlert, this)
                .show(getSupportFragmentManager(), "dialog");
    }

    @Override
    public void onPositive() {
        this.presenter.selectedOptionDialog(true);
    }

    @Override
    public void onNegative() {
        this.presenter.selectedOptionDialog(false);
    }

    @Override
    public void clearAmountTextView() {
        ((PaymentFragment) getSupportFragmentManager().getPrimaryNavigationFragment()).clearTextView();
    }

    @Override
    public void setTitleBarView(int idString) {
        getSupportActionBar().setTitle(idString);
    }
}
