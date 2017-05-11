package com.rapidbizapps.android.rxandroid.data.api;

import com.rapidbizapps.android.rxandroid.data.models.User;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * API for Retrofit usage.
 */
public interface RetroApi {

    @GET("user/{username}")
    Observable<User> getUserDetails(@Path("username") String userName);
}
