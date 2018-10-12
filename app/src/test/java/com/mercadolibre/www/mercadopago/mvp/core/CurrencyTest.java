package com.mercadolibre.www.mercadopago.mvp.core;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CurrencyTest {
    private static final double DELTA = 1e-15;

    @Test
    public void convertStringToFloatTest() {
        assertEquals(0f, Currency.convertStringToFloat("0"), DELTA);
        assertEquals(0f, Currency.convertStringToFloat("120,0"), DELTA);
        assertEquals(-100f, Currency.convertStringToFloat("-100"), DELTA);
        assertEquals(100.20f, Currency.convertStringToFloat("100.20"), DELTA);
        assertEquals(0f, Currency.convertStringToFloat(null), DELTA);
        assertEquals(0f, Currency.convertStringToFloat(""), DELTA);
        assertEquals(0f, Currency.convertStringToFloat("text"), DELTA);

    }
}
