package com.mercadolibre.www.mercadopago.mvp.core;

import android.os.Bundle;

public interface BaseMVP {

    interface View {

        void initView();

        void toastShow(String message, int length);

        void toastShow(int message, int length);

        void goActivity(Bundle bundle, Class tClass, boolean isFinish);

        void goActivity(Class tClass, boolean isFinish);

        void goActivity(Class tClass);

    }

    interface Presenter {

        void onSubscribe();

        void onUnsubscribe();
    }

    interface FragmentView {

        void toastShow(String message, int length);

        void toastShow(int message, int length);
    }

    interface FragmentPresenter {

    }
}
