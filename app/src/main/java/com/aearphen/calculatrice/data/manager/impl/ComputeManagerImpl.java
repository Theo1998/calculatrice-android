package com.aearphen.calculatrice.data.manager.impl;

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
        referenceBuffer.append(input.getCharacterReference());
        expressionToDisplayBuffer.append(input.getCharacterToDisplay());
        return Single.just(expressionToDisplayBuffer.toString());
    }

    @Override
    public Single<String> computeExpression() {
        try {
            Expression expression = new Expression(referenceBuffer.toString());
            Double result = expression.calculate();
            return Single.just(Double.toString(result));
        } catch (Exception e) {
            return Single.error(new Throwable("Error during computing"));
        }
    }

    @Override
    public void clearBuffer() {
        referenceBuffer = new StringBuilder();
        expressionToDisplayBuffer = new StringBuilder();
    }
}
