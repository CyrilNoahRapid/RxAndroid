package com.rapidbizapps.android.rxandroid.usecases.fragments.reactive_three;

import com.rapidbizapps.android.rxandroid.architecture.mvp.BasePresenter;
import com.rapidbizapps.android.rxandroid.architecture.mvp.BaseView;

/**
 * Contract for MVP.
 */

public class ReactiveThreeContract {

    public interface View extends BaseView<Presenter>{
        void expandBottomSheet();
    }

    public interface Presenter extends BasePresenter{
        void clickedExpandBottomSheet();
    }
}
