package com.rapidbizapps.android.rxandroid.usecases.fragments.reactive_one;

import android.support.annotation.NonNull;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;

/**
 * Reactive One MVP Presnter.
 */
public class ReactiveOnePresenter implements ReactiveOneContract.Presenter {

    @NonNull
    private final ReactiveOneContract.View mView;

    public ReactiveOnePresenter(@NonNull ReactiveOneContract.View view) {
        mView = view;
        mView.initPresenter(this);
    }

    @Override
    public void start() {

    }

    @Override
    public void bindData(Observable<CharSequence> observable) {
        // Mapping the text received from the Observable to the Observer.
        observable.map(new Function<CharSequence, String>() {

            @Override
            public String apply(@io.reactivex.annotations.NonNull CharSequence charSequence) throws Exception {
                return charSequence.toString();
            }
        })
                // Observing the mapped data and sending it to the View.
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(@io.reactivex.annotations.NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@io.reactivex.annotations.NonNull String s) {
                        // Sending the observed data to the View.
                        mView.showBoundData(s);
                    }

                    @Override
                    public void onError(@io.reactivex.annotations.NonNull Throwable e) {
                        // Sending the error message to the View.
                        mView.showErrorMessage(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
}
