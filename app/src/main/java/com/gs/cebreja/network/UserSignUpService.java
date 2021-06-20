package com.gs.cebreja.network;

import com.gs.cebreja.model.User;
import com.gs.cebreja.model.UserRequest;
import com.gs.cebreja.network.response.UserLoginResponse;
import com.gs.cebreja.network.response.UserRegisterResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserSignUpService {

    @POST("auth/signup")
    Call<UserRegisterResponse> obterDadosUser(@Body UserRequest user);
}
