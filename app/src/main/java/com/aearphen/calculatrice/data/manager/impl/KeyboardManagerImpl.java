package com.aearphen.calculatrice.data.manager.impl;

import android.content.Context;
import android.support.annotation.ArrayRes;
import android.support.annotation.NonNull;

import com.aearphen.calculatrice.R;
import com.aearphen.calculatrice.data.manager.contract.KeyboardManager;
import com.aearphen.calculatrice.data.model.KeyboardInput;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aearphen on 26/04/18.
 */
public class KeyboardManagerImpl implements KeyboardManager {

    private final Context context;

    public KeyboardManagerImpl(Context context) {
        this.context = context;
    }

    @Override
    public List<KeyboardInput> getPrimaryKeyboard() {
        return getKeyboardInputs(R.array.primary_keyboard_reference, R.array.primary_keyboard_input);
    }

    @Override
    public List<KeyboardInput> getSecondaryKeyboard() {
        return null;
    }

    @NonNull
    private List<KeyboardInput> getKeyboardInputs(@ArrayRes int reference, @ArrayRes int input) {
        String[] referenceArray = context.getResources().getStringArray(reference);
        String[] inputArray = context.getResources().getStringArray(input);
        List<KeyboardInput> keyboardInputs = new ArrayList<>(referenceArray.length);
        for (int i = 0; i < referenceArray.length; i++) {
            keyboardInputs.add(new KeyboardInput(inputArray[i], referenceArray[i]));
        }
        return keyboardInputs;
    }
}
