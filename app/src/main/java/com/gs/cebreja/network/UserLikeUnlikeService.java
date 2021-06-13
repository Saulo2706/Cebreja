package com.gs.cebreja.network;

import com.gs.cebreja.network.response.LikeUnlikeResponseGeneric;

import retrofit2.Call;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface UserLikeUnlikeService {
    @POST("api/beer/{id}/like")
    Call<LikeUnlikeResponseGeneric> likeCerveja(@Path("id") long id, @Header("Authorization") String token);

    @POST("api/beer/{id}/unlike")
    Call<LikeUnlikeResponseGeneric> unlikeCerveja(@Path("id") long id, @Header("Authorization") String token);
}
