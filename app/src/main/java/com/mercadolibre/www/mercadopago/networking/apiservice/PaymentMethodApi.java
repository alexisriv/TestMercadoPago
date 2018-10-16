package com.mercadolibre.www.mercadopago.networking.apiservice;

import com.mercadolibre.www.mercadopago.networking.pojo.Installment;
import com.mercadolibre.www.mercadopago.networking.pojo.Issuer;
import com.mercadolibre.www.mercadopago.networking.pojo.PaymentMethod;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PaymentMethodApi {

    String PATH_BASE_PAYMENT_METHOD = "payment_methods/";

    @GET(PATH_BASE_PAYMENT_METHOD)
    Observable<Response<List<PaymentMethod>>> getPaymentMethods(@Query("public_key") String publicKey,
                                                                @Query("payment_type_id") String paymentTypeId);

    @GET(PATH_BASE_PAYMENT_METHOD + "card_issuers")
    Observable<Response<List<Issuer>>> getIssuers(@Query("public_key") String publicKey,
                                                  @Query("payment_method_id") String paymentMethodId);

    @GET(PATH_BASE_PAYMENT_METHOD + "installments")
    Observable<Response<List<Installment>>> getInstallments(@Query("public_key") String publicKey,
                                                            @Query("amount") String amount,
                                                            @Query("payment_method_id") String paymentTypeId,
                                                            @Query("issuer.id") String issuerId);

}
