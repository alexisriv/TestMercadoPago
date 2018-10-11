package com.mercadolibre.www.mercadopago.networking.pojo;

import com.google.gson.annotations.SerializedName;

public class Issuer extends ElementBase {

    @SerializedName("processing_mode")
    private String processingMode;

    public Issuer() {
        super();
    }

    public String getProcessingMode() {
        return processingMode;
    }

}
