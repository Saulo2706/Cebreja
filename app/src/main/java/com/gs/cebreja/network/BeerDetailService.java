package com.gs.cebreja.network;

import com.gs.cebreja.network.response.BeerResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

public interface BeerDetailService {

    @GET("api/beer/{id}")
    Call<BeerResponse> findCervejas(@Path("id") Long id, @Header("Authorization") String token);

}
