package com.aearphen.calculatrice.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.Toast;

import com.aearphen.calculatrice.R;
import com.aearphen.calculatrice.base.fragment.BaseFragment;
import com.aearphen.calculatrice.data.model.KeyboardInput;
import com.aearphen.calculatrice.ui.adapter.KeyboardAdapter;
import com.aearphen.calculatrice.ui.listener.SwipeListener;
import com.aearphen.calculatrice.ui.presenter.KeyboardPresenter;
import com.aearphen.calculatrice.ui.view.KeyboardView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Aearphen on 26/04/18.
 */
public class KeyboardFragment extends BaseFragment<KeyboardPresenter> implements KeyboardView {

    public static final int PRIMARY = 0;
    public static final int SECONDARY = 1;
    private static final String BUNDLE_KEY_TYPE = "bundle_key_type";

    @BindView(R.id.fragment_keyboard_gridview)
    GridView keyboardGridView;
    KeyboardAdapter adapter;
    private int currentType = PRIMARY;

    public static KeyboardFragment newInstance(int type) {
        Bundle args = new Bundle();
        args.putInt(BUNDLE_KEY_TYPE, type);
        KeyboardFragment fragment = new KeyboardFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_keyboard, container, false);
        if (getArguments() != null && getArguments().containsKey(BUNDLE_KEY_TYPE)) {
            currentType = getArguments().getInt(BUNDLE_KEY_TYPE);
        }
        ButterKnife.bind(this, view);
        adapter = new KeyboardAdapter(context);
        keyboardGridView.setAdapter(adapter);
        view.setOnTouchListener(new SwipeListener(context) {
            @Override
            protected void onSwipeLeft() {
                Toast.makeText(context, "SwipLeft", Toast.LENGTH_SHORT).show();
            }

            @Override
            protected void onSwipeRight() {
                Toast.makeText(context, "SwipeRight", Toast.LENGTH_SHORT).show();
            }

            @Override
            protected void onSwipeTop() {

            }

            @Override
            protected void onSwipeBottom() {

            }
        });
        return view;
    }

    @Override
    protected KeyboardPresenter initPresenter() {
        return new KeyboardPresenter(this);
    }

    @Override
    public void updateKeyboad(List<KeyboardInput> keyboardInputs) {
        adapter.notifyDataSetChanged(keyboardInputs);
    }

    @Override
    public int getCurrentType() {
        return currentType;
    }
}
