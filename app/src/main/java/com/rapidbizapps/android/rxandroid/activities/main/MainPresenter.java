package com.rapidbizapps.android.rxandroid.activities.main;

import android.support.annotation.NonNull;

import com.rapidbizapps.android.rxandroid.data.items.NavItem;
import com.rapidbizapps.android.rxandroid.fragments.reactive_one.ReactiveOneFragment;
import com.rapidbizapps.android.rxandroid.fragments.reactive_two.ReactiveTwoFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Main Presenter.
 */
public class MainPresenter implements MainContract.Presenter {

    @NonNull
    private final MainContract.View mView;

    public MainPresenter(@NonNull MainContract.View mView) {
        this.mView = mView;
        mView.initPresenter(this);
    }

    @Override
    public void start() {

    }

    @Override
    public void setNavItems() {
        mView.populateNavItems(getNavItemList());
    }

    /**
     * Method to provide data for the Navigation Drawer items.
     *
     * @return NavItem list.
     */
    private List<NavItem> getNavItemList() {
        List<NavItem> navItems = new ArrayList<>();

        navItems.add(new NavItem("Reactive One", ReactiveOneFragment.newInstance()));
        navItems.add(new NavItem("Reactive Two Content", ReactiveTwoFragment.newInstance()));
        return navItems;
    }
}
