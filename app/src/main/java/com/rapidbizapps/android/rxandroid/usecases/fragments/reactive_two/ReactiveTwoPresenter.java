package com.rapidbizapps.android.rxandroid.usecases.fragments.reactive_two;

import android.support.annotation.NonNull;

import com.rapidbizapps.android.rxandroid.data.common.DataRefinery;

/**
 * MVP Presenter for Reactive Two Fragment.
 */
public class ReactiveTwoPresenter implements ReactiveTwoContract.Presenter {

    @NonNull
    private final ReactiveTwoContract.View mView;

    public ReactiveTwoPresenter(@NonNull ReactiveTwoContract.View mView) {
        this.mView = mView;
        mView.initPresenter(this);
    }

    @Override
    public void start() {
        // TODO: Write any initial processing code, if required. (12/May/2017).
    }

    @Override
    public void getUserDetails(String username) {
        DataRefinery dataRefinery = new DataRefinery();
        mView.showProgressBar();
        dataRefinery.provideUserFullName(new DataRefinery.DecoratedUserDetailsCallback() {
            @Override
            public void success(String fullName) {
                mView.dismissProgressBar();
                mView.showFullName(fullName);
            }

            @Override
            public void failure(String errorMessage) {
                mView.dismissProgressBar();
                mView.showErrorMessage(errorMessage);
            }
        }, username);
    }
}
