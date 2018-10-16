package com.mercadolibre.www.mercadopago.mvp.presenter.fragment;

import android.widget.Toast;

import com.mercadolibre.www.mercadopago.mvp.core.CustomFPresenter;
import com.mercadolibre.www.mercadopago.mvp.model.Item;
import com.mercadolibre.www.mercadopago.mvp.view.fragment.PaymentInstallmentFViewI;
import com.mercadolibre.www.mercadopago.networking.pojo.Error;
import com.mercadolibre.www.mercadopago.networking.pojo.Installment;
import com.mercadolibre.www.mercadopago.networking.pojo.Issuer;
import com.mercadolibre.www.mercadopago.networking.pojo.PayerCost;
import com.mercadolibre.www.mercadopago.networking.pojo.PaymentMethod;
import com.mercadolibre.www.mercadopago.networking.service.PaymentMethodService;

import java.util.ArrayList;
import java.util.List;

public class PaymentInstallmentFPresenter extends CustomFPresenter<PaymentInstallmentFViewI> implements PaymentInstallmentFPresenterI, PaymentMethodService.PaymentMethodNetworking {

    private PaymentMethodService paymentMethodService;
    private float amount;
    private String idPayment, idIssuer;

    public PaymentInstallmentFPresenter(PaymentInstallmentFViewI viewFragment) {
        super(viewFragment);
    }

    @Override
    public void setParameters(float amount, String idPayment, String idIssuer) {
        this.amount = amount;
        this.idPayment = idPayment;
        this.idIssuer = idIssuer;
    }

    @Override
    public void loadFragment(PayerCost payerCost) {
        this.viewFragment.nextFragment(null);
        this.viewFragment.setInfo(payerCost);
        this.viewFragment.showAlertView();
    }

    @Override
    public void initServices() {
        this.viewFragment.setRefreshStatusView(true);
        this.paymentMethodService = new PaymentMethodService();
        this.paymentMethodService.getInstallments(null, amount, idPayment, idIssuer, this);
    }

    @Override
    public void refresh() {
        this.paymentMethodService.getInstallments(null, amount, idPayment, idIssuer, this);
    }

    @Override
    public void loadPaymentMethod(List<PaymentMethod> paymentMethods) {

    }

    @Override
    public void loadIssuers(List<Issuer> issuers) {

    }

    @Override
    public void loadInstallments(List<Installment> installment) {
        List<Item> items = new ArrayList<>();
        if (installment.size() > 0)
            items.addAll(installment.get(0).getPayerCosts());
        this.viewFragment.loadItemsView(items);
        this.viewFragment.setRefreshStatusView(false);
    }

    @Override
    public void loadError(Error error) {
        this.viewFragment.toastShow(error.getMessage(), Toast.LENGTH_LONG);
        this.viewFragment.setRefreshStatusView(false);
    }

}
