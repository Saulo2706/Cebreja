package com.gs.cebreja.network;

import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

public class ApiService {

    private static BeersService INSTANCE;

    public static BeersService getInstace(){
        if(INSTANCE == null){
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://api.themoviedb.org/3/")
                    .addConverterFactory(MoshiConverterFactory.create())
                    .build();

            INSTANCE = retrofit.create(BeersService.class);
        }

        return INSTANCE;
    }
}
