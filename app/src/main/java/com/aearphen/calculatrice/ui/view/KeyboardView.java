package com.aearphen.calculatrice.ui.view;

import com.aearphen.calculatrice.base.view.BaseView;
import com.aearphen.calculatrice.data.model.KeyboardInput;

import java.util.List;

/**
 * Created by Aearphen on 26/04/18.
 */
public interface KeyboardView extends BaseView {
    void updateKeyboad(List<KeyboardInput> keyboardInputs);

    int getCurrentType();
}
