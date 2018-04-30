package com.aearphen.calculatrice.ui.presenter;

import com.aearphen.calculatrice.CalculatorApplication;
import com.aearphen.calculatrice.R;
import com.aearphen.calculatrice.base.presenter.BasePresenter;
import com.aearphen.calculatrice.data.model.KeyboardInput;
import com.aearphen.calculatrice.data.repository.InputRepository;
import com.aearphen.calculatrice.ui.activity.HomeActivity;
import com.aearphen.calculatrice.ui.module.SnackBarModule;
import com.aearphen.calculatrice.ui.view.HomeView;
import com.aearphen.calculatrice.ui.view.KeyboardView;

import io.reactivex.android.schedulers.AndroidSchedulers;
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
        disposable = inputRepository.getPrimaryKeyboard()
                .doOnError(throwable -> snackBarModule.setError(R.string.error_keyboard_loading))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.computation())
                .subscribe(view::updateKeyboard);
    }

    public void computeInput(KeyboardInput input) {
        ((HomeView) view.getContext()).updateResult("");
        switch (input.getCharacterReference()) {
            case "DEL":
                disposable = inputRepository.deleteLastElement()
                        .subscribeOn(Schedulers.computation())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(((HomeView) view.getContext())::updateOperation);
                break;
            case "AC":
                disposable = inputRepository.clearAll()
                        .subscribeOn(Schedulers.computation())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(s -> ((HomeView) view.getContext()).updateOperation(s));
                break;
            case "Mod":
                break;
            case "=":
                disposable = inputRepository.computeExpression()
                        .subscribeOn(Schedulers.computation())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(s -> ((HomeView) view.getContext()).updateResult(s));
                break;
            default:
                disposable = inputRepository.addToBuffer(input)
                        .subscribeOn(Schedulers.computation())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(s -> ((HomeView) view.getContext()).updateOperation(s));
                break;
        }

    }
}
