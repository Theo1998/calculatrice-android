package com.aearphen.calculatrice.data.repository;

import com.aearphen.calculatrice.data.manager.contract.ComputeManager;
import com.aearphen.calculatrice.data.manager.contract.KeyboardManager;
import com.aearphen.calculatrice.data.model.KeyboardInput;

import java.util.List;

import io.reactivex.Single;

/**
 * Created by Aearphen on 26/04/18.
 */
public class InputRepository {
    private final KeyboardManager keyboardManager;
    private final ComputeManager computeManager;

    public InputRepository(KeyboardManager keyboardManager, ComputeManager computeManager) {
        this.keyboardManager = keyboardManager;
        this.computeManager = computeManager;
    }

    public Single<List<KeyboardInput>> getPrimaryKeyboard() {
        return Single.just(keyboardManager.getPrimaryKeyboard());
    }

    public Single<String> computeExpression() {
        return computeManager.computeExpression();
    }

    public Single<String> addToBuffer(KeyboardInput input) {
        return computeManager.addToBuffer(input);
    }

    public Single<String> deleteLastElement() {
        return computeManager.deleteLastElement();
    }

    public Single<String> clearAll() {
        return computeManager.clearBuffer();
    }
}
