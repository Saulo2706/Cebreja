package com.gs.cebreja.network;

import com.gs.cebreja.network.response.BeerResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface BeersRankingService {

    @GET("api/beer")
    Call<BeerResponse> obterCervejas(@Header("Authorization") String token);

}
