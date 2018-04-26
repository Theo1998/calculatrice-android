package com.aearphen.calculatrice.base.fragment;

import android.content.Context;
import android.support.v4.app.Fragment;

import com.aearphen.calculatrice.base.presenter.BasePresenter;
import com.aearphen.calculatrice.base.view.BaseView;


/**
 * Created by aearphen on 05/03/18 and developed on Aearphen_XPS
 */

public abstract class BaseFragment<P extends BasePresenter> extends Fragment implements BaseView {

    protected P presenter;
    protected Context context;

    @Override
    public void onAttach(final Context context) {
        super.onAttach(context);
        this.context = context;
        presenter = initPresenter();
    }

    @Override
    public void onStart() {
        super.onStart();
        presenter.onStart();
    }

    @Override
    public void onDestroyView() {
        presenter.onStop();
        super.onDestroyView();
    }

    protected abstract P initPresenter();
}
