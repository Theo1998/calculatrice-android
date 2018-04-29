package com.aearphen.calculatrice.ui.misc;

import android.content.Context;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

/**
 * Created by Aearphen on 27/04/18.
 */
public class KeyboardInputTextView extends AppCompatTextView {

    public KeyboardInputTextView(Context context) {
        super(context);
    }

    public KeyboardInputTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public KeyboardInputTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @SuppressWarnings("SuspiciousNameCombination")
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec);
    }
}
