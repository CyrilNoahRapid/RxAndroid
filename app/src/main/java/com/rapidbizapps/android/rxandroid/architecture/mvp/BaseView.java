package com.rapidbizapps.android.rxandroid.architecture.mvp;

/**
 * Base View in the MVP architecture.
 */
public interface BaseView<P> {
    void startPresenter(P presenter);
}
