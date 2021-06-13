package com.gs.cebreja.mapper;

import com.gs.cebreja.model.Beer;
import com.gs.cebreja.network.response.BeerRankingVoes;

import java.util.ArrayList;
import java.util.List;

public class BeerRankingMapper {

    public static List<Beer> listBeerAdd = new ArrayList<>();

    public static List<Beer> deBeerVoesParaDominio(List<BeerRankingVoes> listBeerRankingVoes) {
        List<Beer> listBeer = new ArrayList<>();
        for (BeerRankingVoes beerRankingVoes : listBeerRankingVoes){
            final Beer beer = new Beer(beerRankingVoes.getId(),beerRankingVoes.getName(),beerRankingVoes.getDescription(),beerRankingVoes.getLiked(),beerRankingVoes.getLikes(),beerRankingVoes.getPhotos());
            listBeer.add(beer);
        }
        listBeerAdd = listBeer;
        return listBeer;
    }

    public static List<Beer> deBeerVoesParaDominioAdd(List<BeerRankingVoes> listBeerRankingVoes) {

        for (BeerRankingVoes beerRankingVoes : listBeerRankingVoes){
            final Beer beer = new Beer(beerRankingVoes.getId(),beerRankingVoes.getName(),beerRankingVoes.getDescription(),beerRankingVoes.getLiked(),beerRankingVoes.getLikes(),beerRankingVoes.getPhotos());
            listBeerAdd.add(beer);
        }

        return listBeerAdd;
    }
}
