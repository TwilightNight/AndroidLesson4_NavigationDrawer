package com.example.shana.androidlesson4_navigationdrawer;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by shana on 2015/12/14.
 */
public class OtherFragment extends Fragment{
    public static final String OTHER_FRAGMENT_COLOR = "OTHER_FRAGMENT_COLOR";
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = new View(this.getActivity());
        view.setBackgroundColor(Color.parseColor(getArguments().getString(OTHER_FRAGMENT_COLOR)));
        return view;
    }
}
