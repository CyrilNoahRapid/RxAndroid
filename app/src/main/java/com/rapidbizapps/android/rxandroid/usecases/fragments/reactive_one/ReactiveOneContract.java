package com.rapidbizapps.android.rxandroid.usecases.fragments.reactive_one;

import com.rapidbizapps.android.rxandroid.architecture.mvp.BasePresenter;
import com.rapidbizapps.android.rxandroid.architecture.mvp.BaseView;

import io.reactivex.Observable;

/**
 * Reactive One contact for MVP View and Presenter.
 */
public class ReactiveOneContract {

    public interface View extends BaseView<Presenter> {
        void showBoundData(String data);

        void showErrorMessage(String errorMessage);
    }

    public interface Presenter extends BasePresenter {
        void bindData(Observable<CharSequence> observable);
    }
}