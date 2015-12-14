package com.example.shana.androidlesson4_navigationdrawer;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by shana on 2015/12/14.
 */
public class MainActivity extends Activity {
    @Bind(R.id.activity_main_drawer_layout)
    DrawerLayout drawerLayout;
    @Bind(R.id.activity_main_navigation_view)
    NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                drawerLayout.closeDrawers();
                return true;
            }
        });
    }
}
