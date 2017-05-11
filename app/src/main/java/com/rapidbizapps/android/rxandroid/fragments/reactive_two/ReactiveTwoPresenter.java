package com.rapidbizapps.android.rxandroid.fragments.reactive_two;

import android.support.annotation.NonNull;

import com.rapidbizapps.android.rxandroid.data.common.RetroDataHelper;
import com.rapidbizapps.android.rxandroid.data.models.User;

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

    }

    @Override
    public void getUserDetails(String username) {
        RetroDataHelper dataHelper = new RetroDataHelper();
        mView.showProgressBar();
        dataHelper.getUserDetails(new RetroDataHelper.UserResponseCallback() {
            @Override
            public void onSuccess(User user) {
                mView.dismissProgressBar();
                mView.showFullName(user.getName());
            }

            @Override
            public void onFailure(Throwable e) {
                mView.dismissProgressBar();
                mView.showErrorMessage(e.getMessage());
            }
        }, username);
    }
}
