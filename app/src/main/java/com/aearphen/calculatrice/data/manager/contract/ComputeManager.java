package com.aearphen.calculatrice.data.manager.contract;

import com.aearphen.calculatrice.data.model.KeyboardInput;

import io.reactivex.Single;

/**
 * Created by Aearphen on 29/04/18.
 */
public interface ComputeManager {

    Single<String> addToBuffer(KeyboardInput input);

    Single<String> computeExpression();

    void clearBuffer ();
}
