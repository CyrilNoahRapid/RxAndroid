package com.rapidbizapps.android.rxandroid.usecases.fragments.reactive_three;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rapidbizapps.android.rxandroid.R;

/**
 * Reactive Three Fragment to experiment with the coordinator layout.
 */
public class ReactiveThreeFragment extends Fragment {
    private final String TAG = ReactiveThreeFragment.class.getSimpleName();

    public ReactiveThreeFragment() {
        // Required empty public constructor
    }

    public static ReactiveThreeFragment newInstance() {
        return new ReactiveThreeFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_reactive_three, container, false);
    }

}
