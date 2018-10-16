package com.mercadolibre.www.mercadopago.mvp.presenter.activity;

import android.support.v4.app.Fragment;
import android.widget.Toast;

import com.mercadolibre.www.mercadopago.R;
import com.mercadolibre.www.mercadopago.mvp.core.CustomPresenter;
import com.mercadolibre.www.mercadopago.mvp.model.InfoAlert;
import com.mercadolibre.www.mercadopago.mvp.view.activity.PaymentViewI;
import com.mercadolibre.www.mercadopago.networking.pojo.Issuer;
import com.mercadolibre.www.mercadopago.networking.pojo.PayerCost;
import com.mercadolibre.www.mercadopago.networking.pojo.PaymentMethod;

public class PaymentPresenter extends CustomPresenter<PaymentViewI> implements PaymentPresenterI {

    private InfoAlert infoAlert;

    public PaymentPresenter(PaymentViewI view) {
        super(view);
        this.infoAlert = new InfoAlert();
    }

    @Override
    public void onSubscribe() {
        this.view.initFragmentView();
    }

    @Override
    public void onUnsubscribe() {

    }

    @Override
    public void loadFragment(Fragment fragment, boolean isBack) {
        if (!isBack)
            this.view.managementFragmentView(fragment);
        else
            this.view.managementPopBackStack();

    }

    @Override
    public void buildAlertDialog() {
        this.view.showAlertDialog(this.infoAlert);
    }

    @Override
    public void setInfo(Object o) {
        if (o instanceof PaymentMethod)
            infoAlert.setPaymentMethod((PaymentMethod) o);
        else if (o instanceof Issuer)
            infoAlert.setIssuer((Issuer) o);
        else if (o instanceof PayerCost)
            infoAlert.setPayerCost((PayerCost) o);
    }

    @Override
    public void selectedOptionDialog(boolean b) {
        if (b) {
            this.view.clearAmountTextView();
            this.infoAlert = new InfoAlert();
            this.view.toastShow(R.string.success, Toast.LENGTH_LONG);
        } else {
            this.view.toastShow(R.string.cancel, Toast.LENGTH_LONG);
        }
    }

    @Override
    public void loadTitle(int idString) {
        this.view.setTitleBarView(idString);
    }
}
