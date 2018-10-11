package com.mercadolibre.www.mercadopago.mvp.core;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public abstract class CustomAppCompatActivity<T extends BaseMVP.Presenter> extends AppCompatActivity implements BaseMVP.View {

    protected T presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void setPresenter(T presenter) {
        this.presenter = presenter;
    }

    public T getPresenter() {
        return presenter;
    }

    @Override
    public void toastShow(String message, int length) {
        Toast.makeText(this, message, length).show();
    }

    @Override
    public void toastShow(int message, int length) {
        Toast.makeText(this, message, length).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        this.presenter.onSubscribe();
    }

    @Override
    protected void onStop() {
        super.onStop();
        this.presenter.onUnsubscribe();
    }

    @Override
    public void goActivity(Bundle bundle, Class tClass, boolean isFinish) {
        if (bundle == null)
            goActivity(tClass);
        else {
            Intent intent = new Intent(this, tClass);
            intent.putExtras(bundle);
            startActivity(intent);
        }
        if (isFinish)
            finish();
    }

    @Override
    public void goActivity(Class tClass, boolean isFinish) {
        goActivity(tClass);
        if (isFinish)
            finish();
    }

    public void goActivity(Class tClass) {
        Intent intent = new Intent(this, tClass);
        startActivity(intent);
    }
}
