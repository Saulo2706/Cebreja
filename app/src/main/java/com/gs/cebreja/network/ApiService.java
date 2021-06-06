package com.gs.cebreja.network;

import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

public class ApiService {
    private static String BASE_URL = "http://54.94.67.112:8080/";
    private static BeersRankingService INSTANCE;

    public static BeersRankingService getInstace(){
        if(INSTANCE == null){
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(MoshiConverterFactory.create())
                    .build();

            INSTANCE = retrofit.create(BeersRankingService.class);
        }

        return INSTANCE;
    }





}
