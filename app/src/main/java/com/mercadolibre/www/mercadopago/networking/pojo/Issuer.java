package com.mercadolibre.www.mercadopago.networking.pojo;

import com.google.gson.annotations.SerializedName;

import io.reactivex.annotations.Nullable;

public class Issuer extends ElementBase {

    @SerializedName("processing_mode")
    private String processingMode;

    public Issuer() {
        super();
    }

    public String getProcessingMode() {
        return processingMode;
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        return obj instanceof String && getTitle().toLowerCase().contains((String) obj);
    }

}
