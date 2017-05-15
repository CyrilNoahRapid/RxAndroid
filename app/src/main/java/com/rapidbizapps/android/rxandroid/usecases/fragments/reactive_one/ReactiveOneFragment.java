package com.rapidbizapps.android.rxandroid.usecases.fragments.reactive_one;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.jakewharton.rxbinding2.widget.RxTextView;
import com.rapidbizapps.android.rxandroid.R;
import com.rapidbizapps.android.rxandroid.usecases.fragments.FragmentViewInitializer;

import io.reactivex.Observable;

/**
 * Reactive One fragment to implement two-way data binding sample
 * using RxJava.
 */
public class ReactiveOneFragment extends Fragment implements FragmentViewInitializer, ReactiveOneContract.View {
    private final String TAG = ReactiveOneFragment.class.getSimpleName();

    private ReactiveOneContract.Presenter mPresenter;

    private EditText etObservable;
    private TextView tvObserver;

    public ReactiveOneFragment() {
        // Required empty public constructor
    }

    public static ReactiveOneFragment newInstance() {
        return new ReactiveOneFragment();
    }

    @Override
    public void initPresenter(ReactiveOneContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_reactive_one, container, false);

        initViews(rootView);                         // Initializing Views.
        mPresenter = new ReactiveOnePresenter(this); // Initializing the Presenter.

        mPresenter.start();                          // Starting the presenter.
        setObservable();                             // Setting the Observable.

        return rootView;
    }

    @Override
    public void initViews(View v) {
        etObservable = (EditText) v.findViewById(R.id.et_reactive_one_text_observable);
        tvObserver = (TextView) v.findViewById(R.id.tv_reactive_one_text_observer);
    }


    @Override
    public void showBoundData(String data) {
        // Setting the observed data to the TextView.
        tvObserver.setText(data);
    }

    @Override
    public void showErrorMessage(String errorMessage) {
        // INFORM: Temporarily showing it as a Toast. (10/May/2017)
        Toast.makeText(getContext(), errorMessage, Toast.LENGTH_LONG).show();
    }

    /**
     * Method to set the EditText as the Observable for two-way binding.
     */
    private void setObservable() {
        // Setting the Observable.
        Observable<CharSequence> observable = RxTextView.textChanges(etObservable);
        mPresenter.bindData(observable);
    }
}
