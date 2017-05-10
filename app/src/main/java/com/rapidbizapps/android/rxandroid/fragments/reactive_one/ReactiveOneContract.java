package com.rapidbizapps.android.rxandroid.fragments.reactive_one;

import com.rapidbizapps.android.rxandroid.architecture.mvp.BaseView;

import io.reactivex.Observable;

/**
 * Reactive One contact for MVP View and Presenter.
 */
public class ReactiveOneContract {

    public interface View extends BaseView<Presenter> {
        void showBoundData(String data);
    }

    public interface Presenter {
        void bindData(Observable<CharSequence> observable);
    }
}