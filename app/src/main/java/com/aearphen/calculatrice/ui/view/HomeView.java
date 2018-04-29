package com.aearphen.calculatrice.ui.view;

import com.aearphen.calculatrice.base.view.BaseView;

/**
 * Created by Aearphen on 06/04/18.
 */
public interface HomeView extends BaseView {
    void updateResult(String result);

    void updateOperation(String operation);
}
