package com.mercadolibre.www.mercadopago.mvp.model;

import com.mercadolibre.www.mercadopago.networking.pojo.Issuer;
import com.mercadolibre.www.mercadopago.networking.pojo.PayerCost;
import com.mercadolibre.www.mercadopago.networking.pojo.PaymentMethod;

import java.io.Serializable;

public class InfoAlert implements Serializable {

    private PaymentMethod paymentMethod;
    private Issuer issuer;
    private PayerCost payerCost;

    public InfoAlert() {
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void setIssuer(Issuer issuer) {
        this.issuer = issuer;
    }

    public void setPayerCost(PayerCost payerCost) {
        this.payerCost = payerCost;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public Issuer getIssuer() {
        return issuer;
    }

    public PayerCost getPayerCost() {
        return payerCost;
    }
}
