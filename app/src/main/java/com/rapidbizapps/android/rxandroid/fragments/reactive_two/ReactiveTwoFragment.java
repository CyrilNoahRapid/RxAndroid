package com.rapidbizapps.android.rxandroid.fragments.reactive_two;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.rapidbizapps.android.rxandroid.R;
import com.rapidbizapps.android.rxandroid.fragments.FragmentViewInitializer;

/**
 * A simple {@link Fragment} subclass.
 */
public class ReactiveTwoFragment extends Fragment implements FragmentViewInitializer, ReactiveTwoContract.View {
    private final String TAG = ReactiveTwoFragment.class.getSimpleName();

    private ReactiveTwoContract.Presenter mPresenter;

    private TextView tvGitHubUserFullName;

    public ReactiveTwoFragment() {
        // Required empty public constructor
    }

    public static ReactiveTwoFragment newInstance() {
        return new ReactiveTwoFragment();
    }

    @Override
    public void initPresenter(ReactiveTwoContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_reactive_two, container, false);

        initViews(rootView);                                // Initializing Views.
        mPresenter = new ReactiveTwoPresenter(this);        // Initializing the Presenter.
        mPresenter.getUserDetails("CyrilNoah1");            // Getting user details.

        return rootView;
    }

    @Override
    public void initViews(View v) {
        tvGitHubUserFullName = (TextView) v.findViewById(R.id.tv_reactive_two_github_user_fullname);
    }

    @Override
    public void showFullName(String fullName) {
        tvGitHubUserFullName.setText(fullName);
    }

    @Override
    public void showProgressBar() {

    }

    @Override
    public void dismissProgressBar() {

    }

    @Override
    public void showErrorMessage(String errorMessage) {
        Toast.makeText(getContext(), errorMessage, Toast.LENGTH_LONG).show();
    }
}
