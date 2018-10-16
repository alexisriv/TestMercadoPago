package com.mercadolibre.www.mercadopago.networking.service;

import com.mercadolibre.www.mercadopago.networking.apiservice.PaymentMethodApi;
import com.mercadolibre.www.mercadopago.networking.core.BaseService;
import com.mercadolibre.www.mercadopago.networking.core.CustomObserver;
import com.mercadolibre.www.mercadopago.networking.pojo.Error;
import com.mercadolibre.www.mercadopago.networking.pojo.Installment;
import com.mercadolibre.www.mercadopago.networking.pojo.Issuer;
import com.mercadolibre.www.mercadopago.networking.pojo.PaymentMethod;

import java.text.NumberFormat;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class PaymentMethodService {

    private PaymentMethodApi paymentMethodApi = BaseService.getInterface(PaymentMethodApi.class);

    public void getPaymentMethods(String publicKey, final PaymentMethodNetworking paymentMethodNetworking) {
        this.paymentMethodApi.getPaymentMethods(BaseService.validatePublicKey(publicKey))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CustomObserver<List<PaymentMethod>>() {

                    @Override
                    public void response(List<PaymentMethod> model) {
                        paymentMethodNetworking.loadPaymentMethod(model);
                    }

                    @Override
                    public void errorResponse(Error error) {
                        paymentMethodNetworking.loadError(error);
                    }
                });
    }

    public void getIssuers(String publicKey, String paymentMethodId, final PaymentMethodNetworking paymentMethodNetworking) {
        this.paymentMethodApi.getIssuers(BaseService.validatePublicKey(publicKey), paymentMethodId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CustomObserver<List<Issuer>>() {

                    @Override
                    public void response(List<Issuer> model) {
                        paymentMethodNetworking.loadIssuers(model);
                    }

                    @Override
                    public void errorResponse(Error error) {
                        paymentMethodNetworking.loadError(error);
                    }
                });
    }

    public void getInstallments(String publicKey, Float amount, String paymentTypeId, String issuerId, final PaymentMethodNetworking paymentMethodNetworking) {
        this.paymentMethodApi.getInstallments(BaseService.validatePublicKey(publicKey), NumberFormat.getInstance().format(amount).replace(",", ""), paymentTypeId, issuerId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CustomObserver<List<Installment>>() {

                    @Override
                    public void response(List<Installment> model) {
                        paymentMethodNetworking.loadInstallments(model);
                    }

                    @Override
                    public void errorResponse(Error error) {
                        paymentMethodNetworking.loadError(error);
                    }
                });
    }

    public interface PaymentMethodNetworking {

        void loadPaymentMethod(List<PaymentMethod> paymentMethods);

        void loadIssuers(List<Issuer> issuers);

        void loadInstallments(List<Installment> installment);

        void loadError(Error error);
    }
}
