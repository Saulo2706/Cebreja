package com.gs.cebreja.network;

import com.gs.cebreja.network.response.ApproveOrderResponse;
import com.gs.cebreja.network.response.BeerOrderResponse;
import com.gs.cebreja.network.response.GetBeerOrderDetailedResponse;
import com.gs.cebreja.network.response.GetBeerOrderResponse;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Path;


public interface BeerUploadService {
    @Multipart
    @POST("api/beer/order")
    Call<BeerOrderResponse> saveBeer(@Header("Authorization") String token,
                                     @Part("name") RequestBody name,
                                     @Part("description") RequestBody desc,
                                     @Part("volume") RequestBody volume,
                                     @Part("alcholicPercentage") RequestBody alcholicPercentage,
                                     @Part("brand.id") RequestBody idBrand,
                                     @Part("brand.name") RequestBody nameBrand,
                                     @Part("country.id") RequestBody idCountry,
                                     @Part("country.name") RequestBody nameCountry,
                                     @Part("packing.id") RequestBody idPacking,
                                     @Part("packing.name") RequestBody namePacking,
                                     @Part("type.id") RequestBody idType,
                                     @Part("type.name") RequestBody typeName,
                                     @PartMap HashMap<String,RequestBody> ingredients,
                                     @Part MultipartBody.Part photo);


    @GET("api/beer/order")
    Call <List<GetBeerOrderResponse>> getOrders(@Header("Authorization") String token);

    @GET("api/beer/order/{id}")
    Call <GetBeerOrderDetailedResponse> getOrderDetailed(@Path("id") Long id, @Header("Authorization") String token);

    @POST("api/beer/order/{id}/approve")
    Call <ApproveOrderResponse> postApproveOrder(@Path("id") Long id, @Header("Authorization") String token);

    @POST("api/beer/order/{id}/disapprove")
    Call <ApproveOrderResponse> postDisapproveOrder(@Path("id") Long id, @Header("Authorization") String token);

}
