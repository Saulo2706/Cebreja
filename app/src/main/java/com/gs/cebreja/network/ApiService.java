package com.gs.cebreja.network;

import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

public class ApiService {
    private static String BASE_URL = "http://54.94.67.112:8080/";
    private static BeersRankingService INSTANCE;
    private static BeerDetailService INSTANCE_BEER;
    private static UserLoginService INSTANCE_LOGIN;
    private static UserLikeUnlikeService INSTANCE_LIKE;
    private static UserFavoriteUnfavoriteService INSTANCE_FAVORITE;

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

    public static UserLoginService getInstaceLogin(){
        if(INSTANCE_LOGIN == null){
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(MoshiConverterFactory.create())
                    .build();

            INSTANCE_LOGIN = retrofit.create(UserLoginService.class);
        }

        return INSTANCE_LOGIN;
    }

    public static UserLikeUnlikeService getInstaceLike(){
        if(INSTANCE_LIKE == null){
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(MoshiConverterFactory.create())
                    .build();

            INSTANCE_LIKE = retrofit.create(UserLikeUnlikeService.class);
        }

        return INSTANCE_LIKE;
    }

    public static BeerDetailService getInstanceBeer(){
        if(INSTANCE_BEER == null){
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(MoshiConverterFactory.create())
                    .build();

            INSTANCE_BEER = retrofit.create(BeerDetailService.class);
        }

        return INSTANCE_BEER;
    }

    public static UserFavoriteUnfavoriteService getInstanceFavorite(){
        if(INSTANCE_FAVORITE == null){
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(MoshiConverterFactory.create())
                    .build();

            INSTANCE_FAVORITE = retrofit.create(UserFavoriteUnfavoriteService.class);
        }

        return INSTANCE_FAVORITE;
    }


}
