package com.aearphen.calculatrice.data.manager.contract;

import com.aearphen.calculatrice.data.model.KeyboardInput;

import java.util.List;

/**
 * Created by Aearphen on 26/04/18.
 */
public interface KeyboardManager {

    String TAG = "KeyboardManager";

    List<KeyboardInput> getPrimaryKeyboard();

    List<KeyboardInput> getSecondaryKeyboard();
}
