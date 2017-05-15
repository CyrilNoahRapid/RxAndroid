package com.rapidbizapps.android.rxandroid.usecases.fragments;

import android.view.View;

/**
 * Interface to make sure fragments initialize views in a separate method.
 */
public interface FragmentViewInitializer {
    void initViews(View v);
}
