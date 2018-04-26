package com.aearphen.calculatrice.data.repository;

import com.aearphen.calculatrice.data.manager.contract.KeyboardManager;
import com.aearphen.calculatrice.data.model.KeyboardInput;

import java.util.List;

import io.reactivex.Single;

/**
 * Created by Aearphen on 26/04/18.
 */
public class InputRepository {
    private final KeyboardManager keyboardManager;

    public InputRepository(KeyboardManager keyboardManager) {
        this.keyboardManager = keyboardManager;
    }

    public Single<List<KeyboardInput>> getPrimaryKeyboard() {
        return Single.just(keyboardManager.getPrimaryKeyboard());
    }
}
