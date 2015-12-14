package com.example.shana.androidlesson4_navigationdrawer;

import android.app.Fragment;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Chronometer;

import butterknife.Bind;
import butterknife.BindString;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by shana on 2015/12/14.
 */
public class TimerFragment extends Fragment {
    private static final String TIMER_FRAGMENT_PREF = "TIMER_FRAGMENT_PREF";
    private static final String TIMER_FRAGMENT_PREF_SAVE_TIME = "TIMER_FRAGMENT_PREF_SAVE_TIME";
    private static final String TIMER_FRAGMENT_PREF_IS_RUNNING = "TIMER_FRAGMENT_PREF_IS_RUNNING";
    private long timeWhenStopped = 0;
    @BindString(R.string.start)
    String start;
    @BindString(R.string.stop)
    String stop;
    @Bind(R.id.fragment_timer_chronometer)
    Chronometer chronometer;
    @Bind(R.id.fragment_timer_control_button)
    Button button;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_timer, container, false);
        ButterKnife.bind(this, view);
        restoreData();
        return view;
    }

    private void restoreData() {
        if (loadSharePreferenceIsRunning()) {
            startTimer(loadSharePreferenceTime());
        } else {
            stopTimer(loadSharePreferenceTime());
        }
    }

    @OnClick(R.id.fragment_timer_reset_button)
    void onResetButtonClick() {
        chronometer.setBase(SystemClock.elapsedRealtime());
        stopTimer(0);
    }

    @OnClick(R.id.fragment_timer_control_button)
    void onControlButtClick(){
        if (loadSharePreferenceIsRunning()) {
            stopTimer(SystemClock.elapsedRealtime() - chronometer.getBase());
        } else {
            startTimer(SystemClock.elapsedRealtime() - timeWhenStopped);
        }
    }

    private void startTimer(long beginTime) {
        button.setText(stop);
        saveSharePreferences(beginTime, true);
        chronometer.setBase(beginTime);
        chronometer.start();
    }

    private void stopTimer(long timeWhenStopped) {
        this.timeWhenStopped = timeWhenStopped;
        button.setText(start);
        saveSharePreferences(timeWhenStopped, false);
        chronometer.setBase(SystemClock.elapsedRealtime() - timeWhenStopped);
        chronometer.stop();
    }

    private SharedPreferences getSharePreferences() {
        return getActivity().getSharedPreferences(TIMER_FRAGMENT_PREF, 0);
    }

    private void saveSharePreferences(long time, boolean isRunning) {
        getSharePreferences().edit().putLong(TIMER_FRAGMENT_PREF_SAVE_TIME, time).putBoolean(TIMER_FRAGMENT_PREF_IS_RUNNING, isRunning).commit();
    }

    private long loadSharePreferenceTime() {
        return getSharePreferences().getLong(TIMER_FRAGMENT_PREF_SAVE_TIME, 0);
    }

    private boolean loadSharePreferenceIsRunning() {
        return getSharePreferences().getBoolean(TIMER_FRAGMENT_PREF_IS_RUNNING, false);
    }
}
