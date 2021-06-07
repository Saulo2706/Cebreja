package com.gs.cebreja.network;

import com.gs.cebreja.network.response.BeerRankingResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface BeersRankingService {

    @GET("api/beer")
    Call<BeerRankingResponse> obterCervejas(@Header("Authorization") String token);

}
