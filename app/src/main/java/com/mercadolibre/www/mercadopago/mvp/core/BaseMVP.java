package com.mercadolibre.www.mercadopago.mvp.core;

import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * Base interface that contains all mvp base interfaces.
 */
public interface BaseMVP {
    /**
     * Base Interface View for all activities.
     */
    interface View {
        /**
         * Method for the initialization of the view and design element.
         */
        void initView();

        /**
         * Method that shows a toast
         *
         * @param message String value
         * @param length  duration to toast length_short, length_long
         */
        void toastShow(String message, int length);

        /**
         * Method that shows a toast
         *
         * @param message value to resource string
         * @param length  duration to toast length_short, length_long
         */
        void toastShow(int message, int length);

        void goActivity(Bundle bundle, Class tClass, boolean isFinish);

        void goActivity(Class tClass, boolean isFinish);

        void goActivity(Class tClass);

    }

    /**
     * Base Interface Presenter for all presenter to activities.
     */
    interface Presenter {
        /**
         * Method for initialization of to services listeners and others,
         * is called in life cycle to activity,
         * specifically in {@link CustomAppCompatActivity#onStart()}
         */
        void onSubscribe();

        /**
         * Method for annul of to services listeners and others,
         * is called in life cycle to activity,
         * specifically in {@link CustomAppCompatActivity#onStop()}}
         */
        void onUnsubscribe();
    }

    /**
     * Base Interface FragmentView for all Fragments
     */
    interface FragmentView {

        /**
         * Method that shows a toast
         *
         * @param message String value
         * @param length  duration to toast length_short, length_long
         */
        void toastShow(String message, int length);

        /**
         * Method that shows a toast
         *
         * @param message value to resource string
         * @param length  duration to toast length_short, length_long
         */
        void toastShow(int message, int length);

        /**
         * Method that call to next fragment
         * @param fragment value that initialized
         */
        void nextFragment(Fragment fragment);
    }

    /**
     * Base Interface FragmentPresenter for all Presenters to Fragments
     */
    interface FragmentPresenter {

    }
}
