package com.rapidbizapps.android.rxandroid.usecases.fragments.reactive_three;

import android.support.annotation.NonNull;

/**
 * MVP Presenter for Reactive Three Fragment.
 */

public class ReactiveThreePresenter implements ReactiveThreeContract.Presenter {
    private final String TAG = ReactiveThreePresenter.class.getSimpleName();

    @NonNull
    private final ReactiveThreeContract.View mView;

    public ReactiveThreePresenter(@NonNull ReactiveThreeContract.View mView) {
        this.mView = mView;
        this.mView.initPresenter(this);
    }

    @Override
    public void start() {

    }

    @Override
    public void clickedExpandBottomSheet() {
        mView.expandBottomSheet();
    }
}
