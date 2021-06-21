package com.gs.cebreja.network;


import com.gs.cebreja.network.response.GetListFavoriteResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface BeerFavoriteService {

    @GET("api/beer/favorite")
    Call<List<GetListFavoriteResponse>> getOrders(@Header("Authorization") String token);

}
