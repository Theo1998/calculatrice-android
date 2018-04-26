package com.aearphen.calculatrice.ui.presenter;

import android.util.Log;

import com.aearphen.calculatrice.BuildConfig;
import com.aearphen.calculatrice.CalculatorApplication;
import com.aearphen.calculatrice.R;
import com.aearphen.calculatrice.base.presenter.BasePresenter;
import com.aearphen.calculatrice.data.model.KeyboardInput;
import com.aearphen.calculatrice.data.repository.InputRepository;
import com.aearphen.calculatrice.ui.activity.HomeActivity;
import com.aearphen.calculatrice.ui.module.SnackBarModule;
import com.aearphen.calculatrice.ui.view.KeyboardView;

import java.util.List;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Aearphen on 26/04/18.
 */
public class KeyboardPresenter extends BasePresenter<KeyboardView> {

    private static final String TAG = "KeyboardPresenter";

    private final InputRepository inputRepository;
    private final SnackBarModule snackBarModule;

    public KeyboardPresenter(KeyboardView view) {
        super(view);
        inputRepository = CalculatorApplication.app().inputRepository();
        snackBarModule = new SnackBarModule(view.getContext(), ((HomeActivity) view.getContext()).findViewById(R.id.activity_home_coordinator_layout));
    }

    @Override
    public void onStart() {
        inputRepository.getPrimaryKeyboard()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.computation())
                .subscribe(new SingleObserver<List<KeyboardInput>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(List<KeyboardInput> keyboardInputs) {
                        view.updateKeyboad(keyboardInputs);
                        if (BuildConfig.DEBUG) {
                            snackBarModule.setMessage(R.string.debug_nice).show();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (BuildConfig.DEBUG) {
                            Log.e(TAG, "onError: ", e);
                        }
                        snackBarModule.setError(R.string.error_keyboard_loading).show();
                    }
                });
    }

    @Override
    public void onStop() {

    }
}
