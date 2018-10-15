package com.mercadolibre.www.mercadopago.networking.pojo;

import com.google.gson.annotations.SerializedName;
import com.mercadolibre.www.mercadopago.mvp.model.Item;

import java.util.List;

public class Installment implements Item {

    @SerializedName("payment_method_id")
    private String paymentMethodId;

    @SerializedName("payment_type_id")
    private String paymentTypeId;

    private Issuer issuer;

    @SerializedName("processing_mode")
    private String processingMode;

    @SerializedName("payer_costs")
    private List<PayerCost> payerCosts;

    public Installment() {
    }

    public String getPaymentMethodId() {
        return paymentMethodId;
    }

    public String getPaymentTypeId() {
        return paymentTypeId;
    }

    public Issuer getIssuer() {
        return issuer;
    }

    public String getProcessingMode() {
        return processingMode;
    }

    public List<PayerCost> getPayerCosts() {
        return payerCosts;
    }

    @Override
    public String getImage() {
        return issuer.getImage();
    }

    @Override
    public String getTitle() {
        return processingMode;
    }
}
