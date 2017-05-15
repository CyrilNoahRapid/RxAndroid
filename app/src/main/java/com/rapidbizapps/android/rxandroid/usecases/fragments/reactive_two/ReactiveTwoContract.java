package com.rapidbizapps.android.rxandroid.usecases.fragments.reactive_two;

import com.rapidbizapps.android.rxandroid.architecture.mvp.BasePresenter;
import com.rapidbizapps.android.rxandroid.architecture.mvp.BaseView;

/**
 * Reactive Two contract for MVP.
 */
public class ReactiveTwoContract {

    public interface Presenter extends BasePresenter {
        void getUserDetails(String username);
    }

    public interface View extends BaseView<Presenter> {
        void showFullName(String fullName);
        void showProgressBar();
        void dismissProgressBar();
        void showErrorMessage(String errorMessage);
    }
}
