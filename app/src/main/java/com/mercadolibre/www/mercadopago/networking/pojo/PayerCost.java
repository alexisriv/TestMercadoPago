package com.mercadolibre.www.mercadopago.networking.pojo;

import com.google.gson.annotations.SerializedName;
import com.mercadolibre.www.mercadopago.mvp.model.Item;

import java.util.ArrayList;
import java.util.List;

public class PayerCost implements Item {

    private int installments;

    @SerializedName("installment_rate")
    private float installmentRate;

    @SerializedName("discount_rate")
    private float discountRate;

    private List<String> labels = new ArrayList<>();

    @SerializedName("installment_rate_collector")
    private List<String> installmentRateCollector;

    @SerializedName("min_allowed_amount")
    private float minAllowedAmount;

    @SerializedName("max_allowed_amount")
    private float maxAllowedAmount;

    @SerializedName("recommended_message")
    private String recommendedMessage;

    @SerializedName("installment_amount")
    private float installmentAmount;

    @SerializedName("total_amount")
    private float totalAmount;

    public PayerCost() {
    }

    public int getInstallments() {
        return installments;
    }

    public float getInstallmentRate() {
        return installmentRate;
    }

    public float getDiscountRate() {
        return discountRate;
    }

    public List<String> getLabels() {
        return labels;
    }

    public List<String> getInstallmentRateCollector() {
        return installmentRateCollector;
    }

    public float getMinAllowedAmount() {
        return minAllowedAmount;
    }

    public float getMaxAllowedAmount() {
        return maxAllowedAmount;
    }

    public String getRecommendedMessage() {
        return recommendedMessage;
    }

    public float getInstallmentAmount() {
        return installmentAmount;
    }

    public float getTotalAmount() {
        return totalAmount;
    }

    @Override
    public String getTitle() {
        return recommendedMessage;
    }

    @Override
    public String getImage() {
        return "image_default";
    }
}
