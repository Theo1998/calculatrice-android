package com.aearphen.calculatrice;

import com.aearphen.calculatrice.data.manager.contract.KeyboardManager;
import com.aearphen.calculatrice.data.manager.impl.KeyboardManagerImpl;
import com.aearphen.calculatrice.data.repository.InputRepository;

import org.jetbrains.annotations.Contract;

/**
 * Created by Aearphen on 26/04/18.
 */
public class CalculatorApplication extends android.app.Application {

    private static CalculatorApplication app;
    private KeyboardManager keyboardManager;
    private InputRepository inputRepository;

    @Contract(pure = true)
    public static CalculatorApplication app() {
        return app;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        initManagers();
        initRepositories();
    }

    private void initManagers() {
        keyboardManager = new KeyboardManagerImpl(this);
    }

    private void initRepositories() {
        inputRepository = new InputRepository(keyboardManager);
    }

    public InputRepository inputRepository() {
        return inputRepository;
    }
}
