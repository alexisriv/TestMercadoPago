package com.mercadolibre.www.mercadopago.mvp.presenter.fragment;

import android.widget.Toast;

import com.mercadolibre.www.mercadopago.mvp.core.CustomFPresenter;
import com.mercadolibre.www.mercadopago.mvp.model.Item;
import com.mercadolibre.www.mercadopago.mvp.view.fragment.PaymentInstallmentFragment;
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
    private float amount;
    private String idPayment;
    private List<Item> itemsCopy = new ArrayList<>();


    public PaymentIssuerFPresenter(PaymentIssuerFViewI viewFragment) {
        super(viewFragment);
    }

    @Override
    public void setParameters(float amount, String idPayment) {
        this.amount = amount;
        this.idPayment = idPayment;
    }

    @Override
    public void filterCollection(String s) {
        if (s == null || s.trim().isEmpty()) {
            this.viewFragment.loadItemsView(itemsCopy);
            return;
        }

        List<Item> items = new ArrayList<>();
        for (Item item : itemsCopy) {
            if (item.equals(s.toLowerCase())) {
                items.add(item);
            }
        }
        this.viewFragment.loadItemsView(items);
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
        itemsCopy = items;
        this.viewFragment.loadItemsView(items);
        this.viewFragment.setRefreshStatusView(false);
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
    public void loadFragment(Issuer issuer) {
        this.viewFragment.nextFragment(PaymentInstallmentFragment.newInstance(this.amount, this.idPayment, issuer.getId()));
        this.viewFragment.setInfo(issuer);
    }
}
