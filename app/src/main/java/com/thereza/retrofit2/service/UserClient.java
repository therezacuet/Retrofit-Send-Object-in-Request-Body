package com.thereza.retrofit2.service;

import com.thereza.retrofit2.model.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by theReza on 11/17/2017.
 */

public interface UserClient {

    @POST("user")
    Call<User> createAccount (@Body User user);
}
