package com.mercadolibre.www.mercadopago.networking.core;

import android.util.Log;

import com.mercadolibre.www.mercadopago.networking.pojo.Error;

import java.lang.annotation.Annotation;
import java.net.UnknownHostException;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Response;

public abstract class CustomObserver<T> implements Observer<Response<T>> {

    private static final String TAG_CLAZZ = CustomObserver.class.getName();
    private T responseModel = null;
    private Error error = null;

    @Override
    public void onSubscribe(Disposable d) {
        Log.d(TAG_CLAZZ, "onSubscribe");
    }

    @Override
    public void onNext(Response<T> tResponse) {
        Log.d(TAG_CLAZZ, "onNext");
        if (!tResponse.isSuccessful()) {
            Log.e(TAG_CLAZZ, "code " + tResponse.code());
            this.converterResponseError(tResponse.code(), tResponse.errorBody());
        } else {
            this.responseModel = tResponse.body();
        }
    }

    @Override
    public void onError(Throwable e) {
        Log.e(TAG_CLAZZ, "onError ".concat(e.getMessage()));
        if (e instanceof UnknownHostException)
            errorResponse(new Error("Server Not Available.", e.getLocalizedMessage()));
        else
            errorResponse(new Error(e.getMessage(), e.getLocalizedMessage()));
    }

    @Override
    public void onComplete() {
        Log.d(TAG_CLAZZ, "onComplete");
        try {
            if (this.responseModel != null) {
                response(this.responseModel);
            } else {
                errorResponse(this.error);
            }
        } catch (Exception e) {
            Log.e(TAG_CLAZZ, "onComplete error " + e.getMessage());
            onError(e);
        }
    }

    //    TODO: code es para especificar los tipos de errores en dado caso las respuestas sean distintas segun el codigo (400, 401, 500) entre otros
    private void converterResponseError(int code, ResponseBody error) {
        Log.d(TAG_CLAZZ, "converterResponseError");
        try {
            Converter<ResponseBody, Error> converter = BaseService.getClient().responseBodyConverter(Error.class, new Annotation[0]);
            this.error = converter.convert(error);
        } catch (Exception e) {
            Log.e(TAG_CLAZZ, "converterResponseError" + e.getMessage());
        }
    }

    public abstract void response(T model);

    public abstract void errorResponse(Error error);
}
