package com.mercadolibre.www.mercadopago.networking.pojo;

import com.google.gson.annotations.SerializedName;

public class Bin {

    private String pattern;

    @SerializedName("installments_pattern")
    private String installmentsPattern;

    @SerializedName("exclusion_pattern")
    private String exclusionPattern;

    public Bin() {
    }

    public String getPattern() {
        return pattern;
    }

    public String getInstallmentsPattern() {
        return installmentsPattern;
    }

    public String getExclusionPattern() {
        return exclusionPattern;
    }
}
