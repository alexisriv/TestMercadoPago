package com.mercadolibre.www.mercadopago.networking.core;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BaseService {


    private static final String BASE_URL = "https://api.mercadopago.com/v1/";
    public static final String PUBLIC_KEY_TEST = "444a9ef5-8a6b-429f-abdf-587639155d88";
    private static Retrofit retrofit = null;

    public static Retrofit getClient() {
        if (retrofit == null) {
            Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
            retrofit = new Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .baseUrl(BASE_URL)
                    .build();
        }
        return retrofit;
    }

    public static <T> T getInterface(Class<T> tClass) {
        Retrofit retrofit = getClient();
        return retrofit.create(tClass);
    }

    public static String validatePublicKey(String publicKey) {
        return publicKey != null && !publicKey.isEmpty() ? publicKey : PUBLIC_KEY_TEST;
    }
}
