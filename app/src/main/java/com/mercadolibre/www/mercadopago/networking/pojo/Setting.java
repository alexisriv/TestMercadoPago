package com.mercadolibre.www.mercadopago.networking.pojo;

import com.google.gson.annotations.SerializedName;

public class Setting {

    @SerializedName("card_number")
    private CardNumber cardNumber;

    private Bin bin;

    @SerializedName("security_code")
    private SecurityCode securityCode;

    public Setting() {
    }

    public CardNumber getCardNumber() {
        return cardNumber;
    }

    public Bin getBin() {
        return bin;
    }

    public SecurityCode getSecurityCode() {
        return securityCode;
    }
}
