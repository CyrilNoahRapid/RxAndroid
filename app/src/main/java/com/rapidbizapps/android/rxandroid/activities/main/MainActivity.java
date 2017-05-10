package com.rapidbizapps.android.rxandroid.activities.main;

import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.rapidbizapps.android.rxandroid.R;
import com.rapidbizapps.android.rxandroid.activities.BaseActivity;
import com.rapidbizapps.android.rxandroid.adapters.NavigationMenuAdapter;
import com.rapidbizapps.android.rxandroid.data.items.NavItem;
import com.rapidbizapps.android.rxandroid.fragments.reactive_one.ReactiveOneFragment;

import java.util.List;


public class MainActivity extends BaseActivity implements MainContract.View, NavigationMenuAdapter.NavigationDrawerHandler {
    private final String TAG = MainActivity.class.getSimpleName();

    private MainContract.Presenter mPresenter;

    private DrawerLayout dlNavigationDrawer;
    private RecyclerView rvNavDrawerMenuList;

    @Override
    public void initPresenter(MainContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();                            // Initializing Views.
        mPresenter = new MainPresenter(this);   // Initializing Presenter.

        mPresenter.start();                     // Starting the Presenter.
        mPresenter.setNavItems();               // Setting the Navigation Drawer items.

        // Adding a fragment to the Fragment container.
        replaceFragment(R.id.fl_main_fragment_container, ReactiveOneFragment.newInstance());
    }

    @Override
    protected void initViews() {
        dlNavigationDrawer = (DrawerLayout) findViewById(R.id.dl_main_navigation_drawer_layout);
        rvNavDrawerMenuList = (RecyclerView) findViewById(R.id.rv_main_navigation_drawer);

        rvNavDrawerMenuList.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void populateNavItems(List<NavItem> navItems) {
        NavigationMenuAdapter adapter = new NavigationMenuAdapter(navItems, this, this);
        rvNavDrawerMenuList.setAdapter(adapter);
    }

    @Override
    public void closeNavigationDrawer() {
        dlNavigationDrawer.closeDrawer(GravityCompat.START);
    }
}
