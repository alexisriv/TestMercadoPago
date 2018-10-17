package com.mercadolibre.www.mercadopago.mvp.core;

public class Currency {

    private static final String TAG = Currency.class.getName();

    /**
     * Method for convert string variable to float variable
     * @param n string value at entry
     * @return float type variable that represents the converted number
     */
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
