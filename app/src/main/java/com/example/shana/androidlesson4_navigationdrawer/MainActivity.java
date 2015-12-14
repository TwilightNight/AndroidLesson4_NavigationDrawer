package com.example.shana.androidlesson4_navigationdrawer;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by shana on 2015/12/14.
 */
public class MainActivity extends AppCompatActivity {
    @Bind(R.id.activity_main_drawer_layout)
    DrawerLayout drawerLayout;
    @Bind(R.id.activity_main_navigation_view)
    NavigationView navigationView;
    @Bind(R.id.activity_main_toolbar)
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setupToolbar();
        setUpNavigationView();
    }

    private void setupToolbar() {
        setSupportActionBar(toolbar);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle( this, drawerLayout, toolbar, R.string.drawer_open , R.string.drawer_close){
        };

        drawerLayout.setDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
    }

    private void setUpNavigationView() {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem selectedItem) {
                changeMenuIconState(selectedItem);
                drawerLayout.closeDrawers();
                return true;
            }
        });
    }

    private void changeMenuIconState(MenuItem selectedItem) {
        for (int position = 0; position < navigationView.getMenu().size(); position++) {
            MenuItem changeStateMenuItem = navigationView.getMenu().getItem(position);
            if (changeStateMenuItem == selectedItem) {
                changeStateMenuItem.setIcon(android.R.drawable.star_on);
            } else {
                changeStateMenuItem.setIcon(android.R.drawable.star_off);
            }
        }
    }
}
