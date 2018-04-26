package com.aearphen.calculatrice.base.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.aearphen.calculatrice.base.presenter.BasePresenter;
import com.aearphen.calculatrice.base.view.BaseView;

/**
 * Created by aearphen on 05/03/18 and developed on Aearphen_XPS
 */

public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements BaseView {

    protected P presenter;

    @Override
    public void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = initPresenter();
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.onStart();
    }

    @Override
    protected void onStop() {
        presenter.onStop();
        super.onStop();
    }

    protected abstract P initPresenter();


    @Override
    public Context getContext() {
        return this;
    }

}
