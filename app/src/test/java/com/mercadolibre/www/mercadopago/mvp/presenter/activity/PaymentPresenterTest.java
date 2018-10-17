package com.mercadolibre.www.mercadopago.mvp.presenter.activity;

import android.support.v4.app.Fragment;
import android.widget.Toast;

import com.mercadolibre.www.mercadopago.R;
import com.mercadolibre.www.mercadopago.mvp.model.InfoAlert;
import com.mercadolibre.www.mercadopago.mvp.view.activity.PaymentViewI;
import com.mercadolibre.www.mercadopago.networking.pojo.Issuer;
import com.mercadolibre.www.mercadopago.networking.pojo.PayerCost;
import com.mercadolibre.www.mercadopago.networking.pojo.PaymentMethod;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Matchers.eq;

@RunWith(MockitoJUnitRunner.class)
public class PaymentPresenterTest {

    @Mock
    PaymentViewI paymentViewI;

    @Mock
    Fragment fragment;

    @Mock(name = "infoAlert")
    InfoAlert infoAlert;

    private PaymentPresenterI paymentPresenterI;
    private PaymentPresenterI paymentPresenterITest;

    @InjectMocks
    private PaymentPresenter paymentPresenter;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.paymentPresenterI = new PaymentPresenter(paymentViewI);
        this.paymentPresenterITest = paymentPresenter;

    }

    @Test
    public void onSubscribe() {
        this.paymentPresenterI.onSubscribe();
        Mockito.verify(paymentViewI).initFragmentView();
    }

    @Test
    public void onUnsubscribe() {
    }

    @Test
    public void loadFragment() {

        this.paymentPresenterI.loadFragment(null, true);
        Mockito.verify(paymentViewI).managementPopBackStack();

        this.paymentPresenterI.loadFragment(fragment, false);
        Mockito.verify(paymentViewI).managementFragmentView(eq(fragment));
    }

    @Test
    public void buildAlertDialog() {
        paymentPresenterI.buildAlertDialog();
        Mockito.verify(paymentViewI).showAlertDialog(any(InfoAlert.class));
    }

    @Test
    public void setInfo() {
        PaymentMethod paymentMethod = new PaymentMethod();
        this.paymentPresenterITest.setInfo(paymentMethod);
        Mockito.verify(infoAlert).setPaymentMethod(eq(paymentMethod));

        Issuer issuer = new Issuer();
        this.paymentPresenterITest.setInfo(issuer);
        Mockito.verify(infoAlert).setIssuer(eq(issuer));

        PayerCost payerCost = new PayerCost();
        this.paymentPresenterITest.setInfo(payerCost);
        Mockito.verify(infoAlert).setPayerCost(eq(payerCost));

    }

    @Test
    public void selectedOptionDialog() {
        this.paymentPresenterI.selectedOptionDialog(true);
        Mockito.verify(this.paymentViewI).clearAmountTextView();
        Mockito.verify(this.paymentViewI).toastShow(eq(R.string.success), eq(Toast.LENGTH_LONG));

        this.paymentPresenterI.selectedOptionDialog(false);
        Mockito.verify(this.paymentViewI).toastShow(eq(R.string.cancel), eq(Toast.LENGTH_LONG));

    }

    @Test
    public void loadTitle() {
        this.paymentPresenterI.loadTitle(anyInt());
        Mockito.verify(this.paymentViewI).setTitleBarView(anyInt());
    }
}