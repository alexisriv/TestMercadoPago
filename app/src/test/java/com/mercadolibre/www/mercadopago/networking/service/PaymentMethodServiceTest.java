package com.mercadolibre.www.mercadopago.networking.service;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.mercadolibre.www.mercadopago.networking.apiservice.PaymentMethodApi;
import com.mercadolibre.www.mercadopago.networking.core.BaseService;
import com.mercadolibre.www.mercadopago.networking.pojo.Installment;
import com.mercadolibre.www.mercadopago.networking.pojo.Issuer;
import com.mercadolibre.www.mercadopago.networking.pojo.PaymentMethod;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.observers.TestObserver;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;

public class PaymentMethodServiceTest {

    private MockWebServer mockWebServer;
    private PaymentMethodApi paymentMethodApi;

    private static final String BASE_URL = "api/";

    @Before
    public void setUp(){
        mockWebServer = new MockWebServer();

        this.paymentMethodApi = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(mockWebServer.url(BASE_URL))
                .build()
                .create(PaymentMethodApi.class);
    }

    @Test
    public void getPaymentMethods() throws InterruptedException {
        TestObserver<Response<List<PaymentMethod>>> testObserver = new TestObserver<>();
        final MockResponse mockResponse = new MockResponse()
                .setResponseCode(HttpURLConnection.HTTP_OK)
                .setBody("[]");

        mockWebServer.enqueue(mockResponse);
        paymentMethodApi.getPaymentMethods(BaseService.validatePublicKey("")).subscribe(testObserver);


        testObserver.awaitTerminalEvent(2, TimeUnit.MILLISECONDS);

        testObserver.assertNoErrors();

        RecordedRequest recordedRequest = mockWebServer.takeRequest();

        assertEquals("/" + BASE_URL + "payment_methods/?public_key=444a9ef5-8a6b-429f-abdf-587639155d88", recordedRequest.getPath());
        assertEquals("GET", recordedRequest.getMethod());
    }

    @Test
    public void getIssuers() throws InterruptedException {
        TestObserver<Response<List<Issuer>>> testObserver = new TestObserver<>();
        final MockResponse mockResponse = new MockResponse()
                .setResponseCode(HttpURLConnection.HTTP_OK)
                .setBody("[]");

        mockWebServer.enqueue(mockResponse);
        paymentMethodApi.getIssuers(BaseService.validatePublicKey(""), "visa").subscribe(testObserver);


        testObserver.awaitTerminalEvent(2, TimeUnit.MILLISECONDS);

        testObserver.assertNoErrors();

        RecordedRequest recordedRequest = mockWebServer.takeRequest();
        assertEquals("/" + BASE_URL + "payment_methods/card_issuers?public_key=444a9ef5-8a6b-429f-abdf-587639155d88&payment_method_id=visa", recordedRequest.getPath());
        assertEquals("GET", recordedRequest.getMethod());
    }

    @Test
    public void getInstallments() throws InterruptedException {
        TestObserver<Response<List<Installment>>> testObserver = new TestObserver<>();
        final MockResponse mockResponse = new MockResponse()
                .setResponseCode(HttpURLConnection.HTTP_OK)
                .setBody("[]");

        mockWebServer.enqueue(mockResponse);
        paymentMethodApi.getInstallments(BaseService.validatePublicKey(""), "500.00", "visa", "hsbc").subscribe(testObserver);


        testObserver.awaitTerminalEvent(2, TimeUnit.MILLISECONDS);

        testObserver.assertNoErrors();

        RecordedRequest recordedRequest = mockWebServer.takeRequest();
        assertEquals("/" + BASE_URL + "payment_methods/installments?public_key=444a9ef5-8a6b-429f-abdf-587639155d88&amount=500.00&payment_method_id=visa&issuer.id=hsbc", recordedRequest.getPath());
        assertEquals("GET", recordedRequest.getMethod());
    }

    @After
    public void tearDown() throws IOException {
        mockWebServer.shutdown();
    }

}
