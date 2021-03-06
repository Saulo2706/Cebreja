package com.gs.cebreja.network;

import com.gs.cebreja.network.response.BeerRankingResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface BeersRankingService {

    @GET("api/beer")
    Call<BeerRankingResponse> obterCervejas(@Query ("page") long page,@Query("size") long size,@Header("Authorization") String token);

    @GET("api/beer/findByName/{name}")
    Call<BeerRankingResponse> findCervejas(@Path("name") String nome,@Header("Authorization") String token);

}
