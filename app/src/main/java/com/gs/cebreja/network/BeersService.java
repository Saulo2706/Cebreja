package com.gs.cebreja.network;

import com.gs.cebreja.network.response.BeersResult;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface BeersService {

    @GET("movie/popular")
    Call<BeersResult> obterCervejas(@Query("api_key") String chaveApi);
}
