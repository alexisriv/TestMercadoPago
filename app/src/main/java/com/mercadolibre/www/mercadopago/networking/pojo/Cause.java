package com.mercadolibre.www.mercadopago.networking.pojo;

public class Cause {
    private String code;
    private String description;

    public Cause() {
    }

    public Cause(String code, String description) {
        this.code= code;
        this.description= description;

    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
