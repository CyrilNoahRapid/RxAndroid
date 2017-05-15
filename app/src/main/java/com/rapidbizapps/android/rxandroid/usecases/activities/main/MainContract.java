package com.rapidbizapps.android.rxandroid.usecases.activities.main;

import com.rapidbizapps.android.rxandroid.architecture.mvp.BasePresenter;
import com.rapidbizapps.android.rxandroid.architecture.mvp.BaseView;
import com.rapidbizapps.android.rxandroid.data.items.NavItem;

import java.util.List;

/**
 * Main Activity contract for MVP.
 */
public class MainContract {

    public interface View extends BaseView<Presenter> {
        void populateNavItems(List<NavItem> navItems);
    }

    public interface Presenter extends BasePresenter {
        void setNavItems();
    }
}
