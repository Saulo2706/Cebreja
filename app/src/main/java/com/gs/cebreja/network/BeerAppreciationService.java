package com.gs.cebreja.network;

import com.gs.cebreja.model.AppreciationBeer;
import com.gs.cebreja.model.User;
import com.gs.cebreja.network.response.AppreciationResponseGeneric;
import com.gs.cebreja.network.response.GetAppreciationResponse;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface BeerAppreciationService {
    @POST("api/beer/{id}/appreciation")
    Call<AppreciationResponseGeneric> saveAppreciation(@Path("id") long id, @Header("Authorization") String token, @Body AppreciationBeer appreciationBeer);

    @GET("api/beer/{id}/appreciation")
    Call<List<GetAppreciationResponse>> getAppreciation(@Path("id") long id, @Header("Authorization") String token);
}
