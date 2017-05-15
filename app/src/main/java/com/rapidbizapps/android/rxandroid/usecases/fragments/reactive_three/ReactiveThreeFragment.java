package com.rapidbizapps.android.rxandroid.usecases.fragments.reactive_three;


import android.os.Bundle;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v4.app.Fragment;
import android.support.v4.widget.NestedScrollView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.rapidbizapps.android.rxandroid.R;
import com.rapidbizapps.android.rxandroid.usecases.fragments.FragmentViewInitializer;

/**
 * Reactive Three Fragment to experiment with the coordinator layout.
 */
public class ReactiveThreeFragment extends Fragment implements FragmentViewInitializer, ReactiveThreeContract.View,
        View.OnClickListener {
    private final String TAG = ReactiveThreeFragment.class.getSimpleName();

    private ReactiveThreeContract.Presenter mPresenter;
    private BottomSheetBehavior<NestedScrollView> mBottomSheetBehavior;

    private Button btnExpandBottomSheet;
    private NestedScrollView nsvBottomSheet;

    public ReactiveThreeFragment() {
        // Required empty public constructor
    }

    public static ReactiveThreeFragment newInstance() {
        return new ReactiveThreeFragment();
    }

    @Override
    public void initPresenter(ReactiveThreeContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_reactive_three, container, false);

        initViews(rootView);                            // Initializing Views.
        mPresenter = new ReactiveThreePresenter(this);  // Initializing Presenter.
        mPresenter.start();

        return rootView;
    }

    @Override
    public void initViews(View v) {
        btnExpandBottomSheet = (Button) v.findViewById(R.id.btn_reactive_three_expand_bottom_sheet);
        nsvBottomSheet = (NestedScrollView) v.findViewById(R.id.nsv_reactive_three_bottom_sheet);


        mBottomSheetBehavior = BottomSheetBehavior.from(nsvBottomSheet);
    }

    @Override
    public void expandBottomSheet() {
        mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
    }

    @Override
    public void onClick(View v) {
        // Expand the Bottom Sheet.
        if(v == btnExpandBottomSheet) mPresenter.clickedExpandBottomSheet();
    }
}
