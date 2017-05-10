package com.rapidbizapps.android.rxandroid.activities;

import android.os.Bundle;

import com.rapidbizapps.android.rxandroid.R;
import com.rapidbizapps.android.rxandroid.fragments.reactive_one.ReactiveOneFragment;


public class MainActivity extends BaseActivity {
    private final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Adding a fragment to the Fragment container.
        addFragment(R.id.fl_main_fragment_container, ReactiveOneFragment.newInstance());
    }


    @Override
    protected void initViews() {
        // TODO: Initialize required Views here.
    }
}
