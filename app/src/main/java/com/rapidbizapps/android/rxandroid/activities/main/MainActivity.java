package com.rapidbizapps.android.rxandroid.activities;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;

import com.rapidbizapps.android.rxandroid.R;
import com.rapidbizapps.android.rxandroid.fragments.reactive_one.ReactiveOneFragment;


public class MainActivity extends BaseActivity {
    private final String TAG = MainActivity.class.getSimpleName();

    private DrawerLayout dlNavigationDrawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews(); // Initializing Views.

        // Adding a fragment to the Fragment container.
        replaceFragment(R.id.fl_main_fragment_container, ReactiveOneFragment.newInstance());
    }

    @Override
    protected void initViews() {
        dlNavigationDrawer = (DrawerLayout) findViewById(R.id.dl_main_navigation_drawer_layout);
    }
}
