package com.gs.cebreja.network;

import com.gs.cebreja.model.UserRequest;
import com.gs.cebreja.network.response.UserUpdateResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.PUT;

public interface UserUpdateService {
    @PUT("api/user")
    Call<UserUpdateResponse> updateUser(@Header("Authorization") String token, @Body UserRequest user);
}
