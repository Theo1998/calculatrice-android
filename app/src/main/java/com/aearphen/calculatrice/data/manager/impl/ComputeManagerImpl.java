package com.aearphen.calculatrice.data.manager.impl;

import android.util.Log;

import com.aearphen.calculatrice.data.manager.contract.ComputeManager;
import com.aearphen.calculatrice.data.model.KeyboardInput;

import org.mariuszgromada.math.mxparser.Expression;

import io.reactivex.Single;

/**
 * Created by Aearphen on 29/04/18.
 */
public class ComputeManagerImpl implements ComputeManager {

    private StringBuilder referenceBuffer;
    private StringBuilder expressionToDisplayBuffer;

    public ComputeManagerImpl() {
        this.referenceBuffer = new StringBuilder();
        expressionToDisplayBuffer = new StringBuilder();
    }

    @Override
    public Single<String> addToBuffer(KeyboardInput input) {
        Log.d(TAG, "addToBuffer() called with: input = [" + input + "]");
        referenceBuffer.append(input.getCharacterReference());
        expressionToDisplayBuffer.append(input.getCharacterToDisplay());
        return Single.just(expressionToDisplayBuffer.toString());
    }

    @Override
    public Single<String> computeExpression() {
        try {
            Expression expression = new Expression(referenceBuffer.toString());
            Double result = expression.calculate();
            Log.d(TAG, "computeExpression() returned: " + referenceBuffer.toString() + " = " + result);
            return Single.just(Double.toString(result));
        } catch (Exception e) {
            return Single.error(new Throwable("Error during computing"));
        }
    }

    @Override
    public Single<String> clearBuffer() {
        referenceBuffer = new StringBuilder();
        expressionToDisplayBuffer = new StringBuilder();
        return Single.just("");
    }

    @Override
    public Single<String> deleteLastElement() {
        if (referenceBuffer.length() != 0 && expressionToDisplayBuffer.length() != 0) {
            referenceBuffer.deleteCharAt(referenceBuffer.length() - 1);
            expressionToDisplayBuffer.deleteCharAt(expressionToDisplayBuffer.length() - 1);
            return Single.just(expressionToDisplayBuffer.toString());
        } else {
            return clearBuffer();
        }
    }
}
