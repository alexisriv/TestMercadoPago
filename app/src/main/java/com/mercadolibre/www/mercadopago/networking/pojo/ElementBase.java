package com.mercadolibre.www.mercadopago.networking.pojo;

import com.google.gson.annotations.SerializedName;

public abstract class ElementBase {

    protected String id;
    protected String name;

    @SerializedName("secure_thumbnail")
    protected String secureThumbnail;

    protected String thumbnail;

    public ElementBase() {
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSecureThumbnail() {
        return secureThumbnail;
    }

    public String getThumbnail() {
        return thumbnail;
    }
}
