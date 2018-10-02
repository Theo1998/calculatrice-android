package com.aearphen.calculatrice.ui.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.widget.TextView;

import com.aearphen.calculatrice.R;
import com.aearphen.calculatrice.base.activity.BaseActivity;
import com.aearphen.calculatrice.ui.fragment.KeyboardFragment;
import com.aearphen.calculatrice.ui.navigator.HomeNavigator;
import com.aearphen.calculatrice.ui.presenter.HomePresenter;
import com.aearphen.calculatrice.ui.view.HomeView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Aearphen on 06/04/18.
 */
public class HomeActivity extends BaseActivity<HomePresenter> implements HomeView, HomeNavigator.HomeNavigatorListener {

    @BindView(R.id.activity_home_operation_text_view)
    TextView operationTextView;
    @BindView(R.id.activity_home_result_text_view)
    TextView resultTextView;
    @BindView(R.id.activity_home_coordinator_layout)
    CoordinatorLayout coordinatorLayout;

    private HomeNavigator navigator;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initUI();
    }

    private void initUI() {
        ButterKnife.bind(this);
        navigator = new HomeNavigator(getSupportFragmentManager());
        navigator.launchKeyboardFragment(KeyboardFragment.PRIMARY);
    }

    @Override
    protected final HomePresenter initPresenter() {
        return new HomePresenter(this);
    }

    @Override
    public void launchKeyboardFragment(int keyboardType) {

    }

    @Override
    public void launchGraphFragment() {

    }

    @Override
    public void updateResult(String result) {
        resultTextView.setText(result);
    }

    @Override
    public void updateOperation(String operation) {
        operationTextView.setText(operation);
    }

    @Override
    public Context getContext() {
        return this;
    }
}
