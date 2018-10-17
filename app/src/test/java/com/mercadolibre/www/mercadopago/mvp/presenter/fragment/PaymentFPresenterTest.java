package com.mercadolibre.www.mercadopago.mvp.presenter.fragment;

import com.mercadolibre.www.mercadopago.R;
import com.mercadolibre.www.mercadopago.mvp.view.fragment.PaymentFViewI;
import com.mercadolibre.www.mercadopago.mvp.view.fragment.PaymentMethodFragment;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;

public class PaymentFPresenterTest {

    @Mock
    PaymentFViewI paymentFViewI;

    private PaymentFPresenterI paymentFPresenterI;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.paymentFPresenterI = new PaymentFPresenter(paymentFViewI);
    }

    @Test
    public void validateAmount() {

        this.paymentFPresenterI.validateAmount("");
        Mockito.verify(paymentFViewI).errorView(eq(R.string.amount_not_zero));

        this.paymentFPresenterI.validateAmount("-1");
        Mockito.verify(paymentFViewI).errorView(eq(R.string.amount_not_less_zero));


        this.paymentFPresenterI.validateAmount("1");
        Mockito.verify(paymentFViewI).nextFragment(any(PaymentMethodFragment.class));
    }
}