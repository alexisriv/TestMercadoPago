package com.mercadolibre.www.mercadopago.networking.pojo;

import com.google.gson.annotations.SerializedName;
import com.mercadolibre.www.mercadopago.mvp.model.Item;

public abstract class ElementBase implements Item {

    protected String id;
    protected String name;

    @SerializedName("secure_thumbnail")
    protected String secureThumbnail;

    protected String thumbnail;

    public ElementBase() {
    }

    @Override
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

    @Override
    public String getTitle() {
        return name;
    }

    @Override
    public String getImage() {
        return secureThumbnail;
    }
}
