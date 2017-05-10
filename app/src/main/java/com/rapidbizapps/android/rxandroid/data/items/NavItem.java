package com.rapidbizapps.android.rxandroid.data.items;

import android.support.v4.app.Fragment;

/**
 * JavaBean for Navigation Drawer items.
 */
public class NavItem {

    private String navItemName;
    private Fragment fragmentToLoad;

    public NavItem(String navItemName, Fragment fragmentToLoad) {
        this.navItemName = navItemName;
        this.fragmentToLoad = fragmentToLoad;
    }

    public String getNavItemName() {
        return navItemName;
    }

    public void setNavItemName(String navItemName) {
        this.navItemName = navItemName;
    }

    public Fragment getFragmentToLoad() {
        return fragmentToLoad;
    }

    public void setFragmentToLoad(Fragment fragmentToLoad) {
        this.fragmentToLoad = fragmentToLoad;
    }
}
