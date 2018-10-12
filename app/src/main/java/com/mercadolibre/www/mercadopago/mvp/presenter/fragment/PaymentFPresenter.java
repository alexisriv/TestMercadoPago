package com.mercadolibre.www.mercadopago.mvp.presenter.fragment;

import com.mercadolibre.www.mercadopago.R;
import com.mercadolibre.www.mercadopago.mvp.core.Currency;
import com.mercadolibre.www.mercadopago.mvp.core.CustomFPresenter;
import com.mercadolibre.www.mercadopago.mvp.view.fragment.PaymentFViewI;

public class PaymentFPresenter extends CustomFPresenter<PaymentFViewI> implements PaymentFPresenterI {

    public PaymentFPresenter(PaymentFViewI viewFragment) {
        super(viewFragment);
    }

    @Override
    public void validateAmount(String amount) {
        float amountAux = Currency.convertStringToFloat(amount);
        if (amountAux == 0) {
            this.viewFragment.errorView(R.string.amount_not_zero);
            return;
        }

        if (amountAux < 0) {
            this.viewFragment.errorView(R.string.amount_not_less_zero);
            return;
        }

//        this.viewFragment.nextFragment();
    }
}
