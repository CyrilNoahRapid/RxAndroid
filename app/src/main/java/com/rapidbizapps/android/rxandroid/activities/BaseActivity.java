package com.rapidbizapps.android.rxandroid.activities;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

/**
 * Parent Activity for all the Activities in the project.
 */
public abstract class BaseActivity extends AppCompatActivity {
    private final String TAG = BaseActivity.class.getSimpleName();

    /**
     * Method to initialize Views within an Activity.
     */
    protected abstract void initViews();

    /**
     * Method to add fragment to a container.
     * @param containerResourceId Resource id of the container.
     * @param fragment Fragment to be added.
     */
    public void addFragment(int containerResourceId, Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(containerResourceId, fragment, fragment.getClass().getSimpleName());
        transaction.addToBackStack(null);
        transaction.commit();
    }

    /**
     * Method to replace current Fragment with new Fragment in the container.
     * @param containerResourceId Resource id of the container.
     * @param fragment Fragment to be added as replacement.
     */
    public void replaceFragment(int containerResourceId, Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(containerResourceId, fragment, fragment.getClass().getSimpleName());
        transaction.commit();
    }
}
