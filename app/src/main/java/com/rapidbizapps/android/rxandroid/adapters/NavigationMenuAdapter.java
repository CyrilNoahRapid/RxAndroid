package com.rapidbizapps.android.rxandroid.adapters;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rapidbizapps.android.rxandroid.R;
import com.rapidbizapps.android.rxandroid.usecases.activities.main.MainActivity;
import com.rapidbizapps.android.rxandroid.data.items.NavItem;

import java.util.List;

/**
 * Adapter for handling the items in Navigation Drawer.
 */
public class NavigationMenuAdapter extends RecyclerView.Adapter<NavigationMenuAdapter.NavItemViewHolder> {

    private List<NavItem> navItemList;
    private Context context;
    private NavigationDrawerHandler navigationDrawerHandler;

    public NavigationMenuAdapter(List<NavItem> navItemList, Context context, NavigationDrawerHandler navigationDrawerHandler) {
        this.navItemList = navItemList;
        this.context = context;
        this.navigationDrawerHandler = navigationDrawerHandler;
    }

    @Override
    public NavItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_navigation_drawer, parent, false);
        return new NavItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NavItemViewHolder holder, int position) {
        bindData(holder, position); // Binding data to the Views.
    }

    @Override
    public int getItemCount() {
        return navItemList.size();
    }

    /**
     * Method to bind data to the Views.
     *
     * @param holder ViewHolder.
     * @param pos    Position of the item.
     */
    private void bindData(NavItemViewHolder holder, int pos) {
        // Setting the item name.
        holder.tvNavItemName.setText(navItemList.get(pos).getNavItemName());
        // Setting animation to the TextView.
//        setTextAnimation(holder.tvNavItemName); // TODO: Enable animation if required.
        // Setting the click listener for Fragment replacement.
        holder.tvNavItemName.setOnClickListener(v -> {
            ((MainActivity) context).replaceFragment(R.id.fl_main_fragment_container,
                    navItemList.get(pos).getFragmentToLoad());

            // Closing the Navigation Drawer after inflating the fragment.
            navigationDrawerHandler.closeNavigationDrawer();
        });
    }

    private void setTextAnimation(TextView textView) {
        ObjectAnimator animatorStart = ObjectAnimator.ofPropertyValuesHolder(textView,
                PropertyValuesHolder.ofFloat("scaleX", 2f),
                PropertyValuesHolder.ofFloat("scaleY", 2f));
        ObjectAnimator animatorEnd = ObjectAnimator.ofPropertyValuesHolder(textView,
                PropertyValuesHolder.ofFloat("scaleX", 1f),
                PropertyValuesHolder.ofFloat("scaleY", 1f));

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(1000);
        animatorSet.playSequentially(animatorStart, animatorEnd);
        // Looping the animation.
        animatorSet.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                // Restarting the animation immediately after it ends, to create a loop effect.
                animation.start();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        animatorSet.start();
    }

    /**
     * ViewHolder for NavItems.
     */
    class NavItemViewHolder extends RecyclerView.ViewHolder {
        TextView tvNavItemName;

        NavItemViewHolder(View v) {
            super(v);
            tvNavItemName = (TextView) v.findViewById(R.id.tv_item_navigation_drawer_fragment_name);
        }
    }

    /**
     * Interface to handle the closing of Navigation Drawer on item click.
     */
    public interface NavigationDrawerHandler {
        void closeNavigationDrawer();
    }
}
