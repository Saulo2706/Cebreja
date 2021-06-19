package com.gs.cebreja.network;

import com.gs.cebreja.network.response.BeerOrderResponse;

import java.io.File;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;


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
                                     @Part("ingredients[0].id") RequestBody idIngredient,
                                     @Part("ingredients[0].name") RequestBody nameIngredient,
                                     @Part MultipartBody.Part photo);

}
