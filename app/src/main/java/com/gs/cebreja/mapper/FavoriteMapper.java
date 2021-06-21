package com.gs.cebreja.mapper;

import com.gs.cebreja.model.Favorite;
import com.gs.cebreja.model.UserApreciation;
import com.gs.cebreja.network.response.GetAppreciationResponse;
import com.gs.cebreja.network.response.GetListFavoriteResponse;

import java.util.ArrayList;
import java.util.List;

public class FavoriteMapper {

    public static List<Favorite> deFavoriteParaDominio(List<GetListFavoriteResponse> listfavorite) {
        List<Favorite> listFavoriteLocal = new ArrayList<>();
        for (GetListFavoriteResponse beerFavorite : listfavorite){
            final Favorite beerFavoriteUnique = new Favorite(beerFavorite.getName(),beerFavorite.getId());
            listFavoriteLocal.add(beerFavoriteUnique);
        }
        return listFavoriteLocal;
    }


}
