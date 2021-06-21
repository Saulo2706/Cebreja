package com.gs.cebreja.network;

import com.gs.cebreja.network.response.BeerItemResponseGeneric;

import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

public class ApiService {
    private static String BASE_URL = "http://54.94.67.112:8080/";
    private static BeersRankingService INSTANCE;
    private static BeerDetailService INSTANCE_BEER;
    private static UserLoginService INSTANCE_LOGIN;
    private static UserSignUpService INSTANCE_REGISTER;
    private static UserUpdateService INSTANCE_UPDATE_USER;
    private static UserLikeUnlikeService INSTANCE_LIKE;
    private static UserFavoriteUnfavoriteService INSTANCE_FAVORITE;
    private static BeerAppreciationService INSTANCE_APPRECIATION;
    private static BeerItensService INSTANCE_ITEM;
    private static ItemServiceGeneric INSTANCE_ITEM_GEN;
    private static BeerUploadService INSTANCE_BEER_UPLOAD;
    private static BeerFavoriteService INSTANCE_BEER_FAVORITE;

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
    public static BeerFavoriteService getInstanceListFavorite(){
        if(INSTANCE_BEER_FAVORITE == null){
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(MoshiConverterFactory.create())
                    .build();

            INSTANCE_BEER_FAVORITE = retrofit.create(BeerFavoriteService.class);
        }

        return INSTANCE_BEER_FAVORITE;
    }

    public static UserSignUpService getInstanceRegister(){
        if(INSTANCE_REGISTER == null){
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(MoshiConverterFactory.create())
                    .build();

            INSTANCE_REGISTER = retrofit.create(UserSignUpService.class);
        }

        return INSTANCE_REGISTER;
    }

    public static UserUpdateService getInstanceUpdateUser(){
        if(INSTANCE_UPDATE_USER == null){
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(MoshiConverterFactory.create())
                    .build();

            INSTANCE_UPDATE_USER = retrofit.create(UserUpdateService.class);
        }

        return INSTANCE_UPDATE_USER;
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

    public static BeerAppreciationService getInstanceAppreciation(){
        if(INSTANCE_APPRECIATION == null){
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(MoshiConverterFactory.create())
                    .build();

            INSTANCE_APPRECIATION = retrofit.create(BeerAppreciationService.class);
        }

        return INSTANCE_APPRECIATION;
    }

    public static BeerItensService getInstanceItem(){
        if(INSTANCE_ITEM == null){
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(MoshiConverterFactory.create())
                    .build();

            INSTANCE_ITEM = retrofit.create(BeerItensService.class);
        }

        return INSTANCE_ITEM;
    }

    public static ItemServiceGeneric getInstanceItemGen(){
        if(INSTANCE_ITEM_GEN == null){
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(MoshiConverterFactory.create())
                    .build();

            INSTANCE_ITEM_GEN = retrofit.create(ItemServiceGeneric.class);
        }

        return INSTANCE_ITEM_GEN;
    }

    public static BeerUploadService getInstanceBeerUpload(){
        if(INSTANCE_BEER_UPLOAD == null){
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(MoshiConverterFactory.create())
                    .build();

            INSTANCE_BEER_UPLOAD = retrofit.create(BeerUploadService.class);
        }

        return INSTANCE_BEER_UPLOAD;
    }




}
