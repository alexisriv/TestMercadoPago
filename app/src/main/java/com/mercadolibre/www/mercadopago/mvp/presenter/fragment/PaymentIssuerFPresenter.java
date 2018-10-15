package com.mercadolibre.www.mercadopago.mvp.presenter.fragment;

import com.mercadolibre.www.mercadopago.mvp.core.CustomFPresenter;
import com.mercadolibre.www.mercadopago.mvp.model.Item;
import com.mercadolibre.www.mercadopago.mvp.view.fragment.PaymentIssuerFViewI;
import com.mercadolibre.www.mercadopago.networking.pojo.Error;
import com.mercadolibre.www.mercadopago.networking.pojo.Installment;
import com.mercadolibre.www.mercadopago.networking.pojo.Issuer;
import com.mercadolibre.www.mercadopago.networking.pojo.PaymentMethod;
import com.mercadolibre.www.mercadopago.networking.service.PaymentMethodService;

import java.util.ArrayList;
import java.util.List;

public class PaymentIssuerFPresenter extends CustomFPresenter<PaymentIssuerFViewI> implements PaymentIssuerFPresenterI, PaymentMethodService.PaymentMethodNetworking {

    private PaymentMethodService paymentMethodService;
    private String idPayment;

    public PaymentIssuerFPresenter(PaymentIssuerFViewI viewFragment) {
        super(viewFragment);
    }

    @Override
    public void setIdPayment(String idPayment) {
        this.idPayment = idPayment;
    }

    @Override
    public void initServices() {
        this.viewFragment.setRefreshStatusView(true);
        this.paymentMethodService = new PaymentMethodService();
        this.paymentMethodService.getIssuers(null, idPayment, this);
    }

    @Override
    public void refresh() {
        this.paymentMethodService.getIssuers(null, idPayment, this);
    }

    @Override
    public void loadPaymentMethod(List<PaymentMethod> paymentMethods) {

    }

    @Override
    public void loadIssuers(List<Issuer> issuers) {
        List<Item> items = new ArrayList<>();
        items.addAll(issuers);
        this.viewFragment.loadItemsView(items);
        this.viewFragment.setRefreshStatusView(false);
    }

    @Override
    public void loadInstallments(List<Installment> paymentMethods) {

    }

    @Override
    public void loadError(Error error) {

    }
}
