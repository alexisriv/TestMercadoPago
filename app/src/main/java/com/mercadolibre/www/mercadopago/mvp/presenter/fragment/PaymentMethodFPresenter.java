package com.mercadolibre.www.mercadopago.mvp.presenter.fragment;

import android.widget.Toast;

import com.mercadolibre.www.mercadopago.mvp.core.CustomFPresenter;
import com.mercadolibre.www.mercadopago.mvp.model.Item;
import com.mercadolibre.www.mercadopago.mvp.view.fragment.PaymentIssuerFragment;
import com.mercadolibre.www.mercadopago.mvp.view.fragment.PaymentMethodFViewI;
import com.mercadolibre.www.mercadopago.networking.pojo.Error;
import com.mercadolibre.www.mercadopago.networking.pojo.Installment;
import com.mercadolibre.www.mercadopago.networking.pojo.Issuer;
import com.mercadolibre.www.mercadopago.networking.pojo.PaymentMethod;
import com.mercadolibre.www.mercadopago.networking.service.PaymentMethodService;

import java.util.ArrayList;
import java.util.List;

public class PaymentMethodFPresenter extends CustomFPresenter<PaymentMethodFViewI> implements PaymentMethodFPresenterI, PaymentMethodService.PaymentMethodNetworking {

    private PaymentMethodService paymentMethodService;
    private float amount;

    public PaymentMethodFPresenter(PaymentMethodFViewI viewFragment) {
        super(viewFragment);
    }

    @Override
    public void initServices() {
        this.viewFragment.setRefreshStatusView(true);
        this.paymentMethodService = new PaymentMethodService();
        this.paymentMethodService.getPaymentMethods(null, "credit_card", this);

    }

    @Override
    public void setParameters(float amount) {
        this.amount = amount;
    }

    @Override
    public void refresh() {
        this.paymentMethodService.getPaymentMethods(null, "credit_card", this);
    }

    @Override
    public void loadPaymentMethod(List<PaymentMethod> paymentMethods) {
        List<Item> items = new ArrayList<>();
        items.addAll(paymentMethods);
        this.viewFragment.loadItemsView(items);
        this.viewFragment.setRefreshStatusView(false);
    }

    @Override
    public void loadIssuers(List<Issuer> issuers) {

    }

    @Override
    public void loadInstallments(List<Installment> Installment) {

    }

    @Override
    public void loadError(Error error) {
        this.viewFragment.toastShow(error.getMessage(), Toast.LENGTH_LONG);
        this.viewFragment.setRefreshStatusView(false);
    }

    @Override
    public void loadFragment(PaymentMethod paymentMethod) {
        this.viewFragment.nextFragment(PaymentIssuerFragment.newInstance(this.amount, paymentMethod.getId()));
        this.viewFragment.setInfo(paymentMethod);
    }
}
