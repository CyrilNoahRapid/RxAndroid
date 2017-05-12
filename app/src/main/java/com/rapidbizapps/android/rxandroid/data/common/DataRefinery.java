package com.rapidbizapps.android.rxandroid.data.common;

import com.rapidbizapps.android.rxandroid.data.models.User;

/**
 * This class provides necessary response to the calling presenter,
 * by refining the total data and providing necessary data.
 */
public class DataRefinery {

    /**
     * Method to provide Github user's full name.
     * @param callback {@link DecoratedUserDetailsCallback}
     * @param username Github username.
     */
    public void provideUserFullName(DecoratedUserDetailsCallback callback, String username) {
        RetroDataHelper dataHelper = new RetroDataHelper();
        dataHelper.getUserDetails(new RetroDataHelper.UserResponseCallback() {
            @Override
            public void onSuccess(User user) {
                callback.success(user.getName());
            }

            @Override
            public void onFailure(Throwable e) {
                callback.failure(e.getMessage());
            }
        }, username);
    }


    public interface DecoratedUserDetailsCallback {
        void success(String fullName);

        void failure(String errorMessage);
    }
}
