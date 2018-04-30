package com.aearphen.calculatrice.data.manager.contract;

import com.aearphen.calculatrice.data.model.KeyboardInput;

import io.reactivex.Single;

/**
 * Created by Aearphen on 29/04/18.
 */
public interface ComputeManager {
    String TAG = "ComputeManager";

    Single<String> addToBuffer(KeyboardInput input);

    Single<String> computeExpression();

    Single<String> clearBuffer ();

    Single<String> deleteLastElement();
}
