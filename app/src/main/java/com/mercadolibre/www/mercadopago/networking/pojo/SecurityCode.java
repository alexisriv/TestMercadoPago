package com.mercadolibre.www.mercadopago.networking.pojo;

import com.google.gson.annotations.SerializedName;

public class SecurityCode {


    private int length;

    @SerializedName("card_location")
    private String cardLocation;

    private String mode;

    public SecurityCode() {
    }

    public int getLength() {
        return length;
    }

    public String getCardLocation() {
        return cardLocation;
    }

    public String getMode() {
        return mode;
    }
}
