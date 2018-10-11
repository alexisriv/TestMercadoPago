package com.mercadolibre.www.mercadopago.networking.pojo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Installment {

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
}
