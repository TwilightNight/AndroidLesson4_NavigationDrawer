package com.example.shana.androidlesson4_navigationdrawer;

import android.app.Fragment;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Chronometer;

import butterknife.BindString;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by shana on 2015/12/14.
 */
public class TimerFragment extends Fragment {
    private static final String TIMER_FRAGMENT_PREF = "TIMER_FRAGMENT_PREF";
    private static final String TIMER_FRAGMENT_PREF_BEGIN_TIME = "TIMER_FRAGMENT_PREF_BEGIN_TIME";
    private long timeWhenStopped = 0;
    @BindString(R.string.start)
    String start;
    @BindString(R.string.stop)
    String stop;
    @OnClick(R.id.fragment_timer_button)
    void onButtonClick(Button button){
        Chronometer chronometer = (Chronometer)getView().findViewById(R.id.fragment_timer_chronometer);
        if (button.getText().toString().equals(stop)) {
            button.setText(start);
            timeWhenStopped = chronometer.getBase() - SystemClock.elapsedRealtime();
            chronometer.stop();
        } else {
            button.setText(stop);
            chronometer.setBase(SystemClock.elapsedRealtime() + timeWhenStopped);
            chronometer.start();
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_timer, container, false);
        ButterKnife.bind(this, view);
        return view;
    }
}
