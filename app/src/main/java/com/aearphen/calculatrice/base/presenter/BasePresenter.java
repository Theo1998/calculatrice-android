package com.aearphen.calculatrice.base.presenter;


import com.aearphen.calculatrice.base.view.BaseView;

import io.reactivex.disposables.Disposable;

/**
 * Created by aearphen on 05/03/18 and developed on Aearphen_XPS
 */

public abstract class BasePresenter<V extends BaseView> {

    protected final V view;
    protected Disposable disposable;

    protected BasePresenter(final V view) {
        this.view = view;
    }

    /**
     * This method may be called when the presenter view is created, so in the onStart method
     */
    public abstract void onStart();

    /**
     * This method may be called when the presenter view is destroyed
     * Activity => onDestroy method
     * Fragment => onStop method
     */
    public void onStop() {
        if (disposable != null && !disposable.isDisposed()) {
            disposable.dispose();
        }
    }

}
