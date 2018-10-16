package com.mercadolibre.www.mercadopago.mvp.presenter.fragment;

import android.widget.Toast;

import com.mercadolibre.www.mercadopago.R;
import com.mercadolibre.www.mercadopago.mvp.core.CustomFPresenter;
import com.mercadolibre.www.mercadopago.mvp.model.Item;
import com.mercadolibre.www.mercadopago.mvp.view.fragment.PaymentInstallmentFragment;
import com.mercadolibre.www.mercadopago.mvp.view.fragment.PaymentIssuerFViewI;
import com.mercadolibre.www.mercadopago.networking.core.CustomObserver;
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
        List<Item> items = new ArrayList<>();
        if (s == null || s.trim().isEmpty()) {
            this.validateElementEmpty(itemsCopy);
            this.viewFragment.loadItemsView(itemsCopy);
            return;
        }

        for (Item item : itemsCopy) {
            if (item.equals(s.toLowerCase())) {
                items.add(item);
            }
        }
        this.validateElementEmpty(items);
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
        this.validateElementEmpty(items);
        this.viewFragment.setRefreshStatusView(false);
    }

    @Override
    public void loadInstallments(List<Installment> Installment) {

    }

    @Override
    public void loadError(Error error) {
        if (error.getCause() != null && error.getCause().getCode().equalsIgnoreCase(CustomObserver.CAUSE_ERROR_UNK0WN_HOST)) {
            if (itemsCopy == null || itemsCopy.size() == 0)
                this.viewFragment.setErrorInView(R.string.message_default, R.drawable.ic_cloud_off);
            else
                this.viewFragment.toastShow(error.getMessage(), Toast.LENGTH_LONG);
        } else {
            this.viewFragment.toastShow(error.getMessage(), Toast.LENGTH_LONG);
        }
        this.viewFragment.setRefreshStatusView(false);
    }

    @Override
    public void loadFragment(Issuer issuer) {
        this.viewFragment.nextFragment(PaymentInstallmentFragment.newInstance(this.amount, this.idPayment, issuer.getId()));
        this.viewFragment.setInfo(issuer);
    }

    private void validateElementEmpty(List list) {
        if (list.size() == 0) {
            this.viewFragment.setErrorInView(R.string.message_empty_list, R.drawable.ic_bank);
        } else {
            this.viewFragment.setVisibleErrorInView(false);
        }
    }

    @Override
    public void finishFragment() {
        itemsCopy = new ArrayList<>();
    }
}
