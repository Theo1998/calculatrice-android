package com.aearphen.calculatrice.ui.adapter;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;

import com.aearphen.calculatrice.R;
import com.aearphen.calculatrice.data.model.KeyboardInput;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Aearphen on 26/04/18.
 */
public class KeyboardAdapter extends BaseAdapter {

    private final Context context;
    private final List<KeyboardInput> keyboardInputList;

    public KeyboardAdapter(Context context) {
        this.context = context;
        keyboardInputList = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return keyboardInputList.size();
    }

    @Override
    public Object getItem(int position) {
        return keyboardInputList.get(position).getCharacterReference();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder = new Holder();
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.holder_keyboard_button, parent, false);
        }
        ButterKnife.bind(holder, convertView);
        holder.button.setText(keyboardInputList.get(position).getCharacterToDisplay());
        return convertView;
    }

    public void notifyDataSetChanged(List<KeyboardInput> keyboardInputList) {
        this.keyboardInputList.clear();
        this.keyboardInputList.addAll(keyboardInputList);
        super.notifyDataSetChanged();
    }

    public final class Holder {
        @BindView(R.id.holder_keyboard_root)
        ConstraintLayout root;
        @BindView(R.id.holder_keyboard_button)
        Button button;
    }
}
