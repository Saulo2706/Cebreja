package com.gs.cebreja.network;
import com.gs.cebreja.model.User;
import com.gs.cebreja.network.response.UserLoginResponse;


import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserLoginService {

    @POST("auth/signin")
    Call<UserLoginResponse> obterDadosUser(@Body User user);
}
