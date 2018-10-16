package com.mercadolibre.www.mercadopago.networking.pojo;

public class Error {

    private String message;
    private String error;
    private int status;
    private Cause cause;

    public Error() {
    }

    public Error(String message, String error, Cause cause) {
        this.message = message;
        this.error = error;
        this.cause = cause;
    }

    public String getMessage() {
        return message;
    }

    public String getError() {
        return error;
    }

    public int getStatus() {
        return status;
    }

    public Cause getCause() {
        return cause;
    }
}
