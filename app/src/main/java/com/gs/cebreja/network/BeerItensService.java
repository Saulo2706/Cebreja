package com.gs.cebreja.network;


import com.gs.cebreja.network.response.BeerItemResponseGeneric;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

public interface BeerItensService {

    @GET("api/beer/{item}")
    Call<List<BeerItemResponseGeneric>> findItem(@Path("item") String item, @Header("Authorization") String token);
}
