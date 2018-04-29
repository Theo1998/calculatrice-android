package com.aearphen.calculatrice.ui.module;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.view.View;

import com.aearphen.calculatrice.R;

/**
 * Created by Aearphen on 26/04/18.
 */
public class SnackBarModule {

    private final Context context;
    private final View baseView;

    public SnackBarModule(Context context, View baseView) {
        this.context = context;
        this.baseView = baseView;
    }

    public Snackbar setMessage(int message) {
        Snackbar snackbar = Snackbar.make(baseView, message, Snackbar.LENGTH_LONG);
        snackbar.getView().setBackgroundColor(context.getResources().getColor(R.color.colorPrimary));
        return snackbar;
    }

    public Snackbar setError(int error) {
        Snackbar snackbar = Snackbar.make(baseView, error, Snackbar.LENGTH_LONG);
        snackbar.getView().setBackgroundColor(context.getResources().getColor(R.color.colorError));
        return snackbar;
    }

}
