package com.gs.cebreja.network;

import com.gs.cebreja.network.response.FavoriteUnfavoriteResponseGeneric;

import retrofit2.Call;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface UserFavoriteUnfavoriteService {

    @POST("api/beer/{id}/favorite")
    Call<FavoriteUnfavoriteResponseGeneric> favoriteCerveja(@Path("id") long id, @Header("Authorization") String token);

    @POST("api/beer/{id}/unfavorite")
    Call<FavoriteUnfavoriteResponseGeneric> unfavoriteCerveja(@Path("id") long id, @Header("Authorization") String token);
}
