package com.mercadolibre.www.mercadopago.networking.pojo;

import com.google.gson.annotations.SerializedName;
import com.mercadolibre.www.mercadopago.mvp.model.Item;

import java.util.List;

public class PaymentMethod extends ElementBase {

    @SerializedName("payment_type_id")
    private String paymentTypeId;

    private String status;

    @SerializedName("deferred_capture")
    private String deferredCapture;

    private List<Setting> settings;

    @SerializedName("additional_info_needed")
    private List<String> additionalInfoNeeded;

    @SerializedName("min_allowed_amount")
    private float minAllowedAmount;

    @SerializedName("max_allowed_amount")
    private float maxAllowedAmount;

    public PaymentMethod() {
    }

    public String getPaymentTypeId() {
        return paymentTypeId;
    }

    public String getStatus() {
        return status;
    }

    public String getDeferredCapture() {
        return deferredCapture;
    }

    public List<Setting> getSettings() {
        return settings;
    }

    public List<String> getAdditionalInfoNeeded() {
        return additionalInfoNeeded;
    }

    public float getMinAllowedAmount() {
        return minAllowedAmount;
    }

    public float getMaxAllowedAmount() {
        return maxAllowedAmount;
    }
}
