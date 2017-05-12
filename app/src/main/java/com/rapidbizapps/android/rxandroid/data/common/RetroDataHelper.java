package com.rapidbizapps.android.rxandroid.data.common;

import com.rapidbizapps.android.rxandroid.data.api.RetroApi;
import com.rapidbizapps.android.rxandroid.data.models.User;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Provides required response to the calling classes/
 */
public class RetroDataHelper implements DataConstants {
    private Retrofit retrofit;

    public RetroDataHelper() {
        setupRetro();
    }

    /**
     * Method to get GitHub user retails.
     *
     * @param callback {@link UserResponseCallback}
     * @param username GitHub Username.
     */
    public void getUserDetails(UserResponseCallback callback, String username) {
        RetroApi retroApi = retrofit.create(RetroApi.class);
        Observable<User> gitHubUser = retroApi.getUserDetails(username);
        gitHubUser.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<User>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull User user) {
                        callback.onSuccess(user);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        callback.onFailure(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }


    /**
     * Method to setup Retrofit.
     */
    private void setupRetro() {
        retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build();
    }


    public interface UserResponseCallback {
        void onSuccess(User user);

        void onFailure(Throwable e);
    }
}
