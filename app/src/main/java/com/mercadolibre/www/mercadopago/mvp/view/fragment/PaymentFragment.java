package com.mercadolibre.www.mercadopago.mvp.view.fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mercadolibre.www.mercadopago.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class PaymentFragment extends Fragment {

    public PaymentFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_payment, container, false);
    }
}
