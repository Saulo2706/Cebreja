package com.gs.cebreja.network;

import com.gs.cebreja.model.AppreciationBeer;
import com.gs.cebreja.model.User;
import com.gs.cebreja.network.response.AppreciationResponseGeneric;


import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface BeerAppreciationService {
    @POST("api/beer/{id}/appreciate")
    Call<AppreciationResponseGeneric> saveAppreciation(@Path("id") long id, @Header("Authorization") String token, @Body AppreciationBeer appreciationBeer);
}
