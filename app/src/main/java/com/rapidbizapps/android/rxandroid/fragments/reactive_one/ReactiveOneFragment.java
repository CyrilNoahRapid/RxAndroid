package com.rapidbizapps.android.rxandroid.fragments.reactive_one;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.rapidbizapps.android.rxandroid.R;
import com.rapidbizapps.android.rxandroid.fragments.FragmentViewInitializer;

/**
 * Reactive One fragment to implement two-way data binding sample
 * using RxJava.
 */
public class ReactiveOneFragment extends Fragment implements FragmentViewInitializer {
    private final String TAG = ReactiveOneFragment.class.getSimpleName();

    private EditText etObservable;
    private TextView tvObserver;

    public ReactiveOneFragment() {
        // Required empty public constructor
    }

    public static ReactiveOneFragment newInstance() {
        return new ReactiveOneFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_reactive_one, container, false);

        // Initializing Views.
        initViews(rootView);
        return rootView;
    }

    @Override
    public void initViews(View v) {
        etObservable = (EditText) v.findViewById(R.id.et_reactive_one_text_observable);

    }
}
