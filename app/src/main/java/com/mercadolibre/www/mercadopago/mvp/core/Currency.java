package com.mercadolibre.www.mercadopago.mvp.core;

public class Currency {

    private static final String TAG = Currency.class.getName();

    public static float convertStringToFloat(String n) {
        float num = 0;
        try {
            if (n == null || n.isEmpty())
                throw new Exception("n is null or empty");

            num = Float.valueOf(n);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return num;
    }
}
