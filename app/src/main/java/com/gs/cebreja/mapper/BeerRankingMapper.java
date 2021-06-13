package com.gs.cebreja.mapper;

import com.gs.cebreja.model.BeerRanking;
import com.gs.cebreja.network.response.BeerRankingVoes;

import java.util.ArrayList;
import java.util.List;

public class BeerRankingMapper {

    public static List<BeerRanking> listBeerRankingAdd = new ArrayList<>();

    public static List<BeerRanking> deBeerVoesParaDominio(List<BeerRankingVoes> listBeerRankingVoes) {
        List<BeerRanking> listBeerRanking = new ArrayList<>();
        for (BeerRankingVoes beerRankingVoes : listBeerRankingVoes){
            final BeerRanking beerRanking = new BeerRanking(beerRankingVoes.getId(),beerRankingVoes.getName(),beerRankingVoes.getDescription(),beerRankingVoes.getLiked(),beerRankingVoes.getLikes(),beerRankingVoes.getPhotos());
            listBeerRanking.add(beerRanking);
        }
        listBeerRankingAdd = listBeerRanking;
        return listBeerRanking;
    }

    public static List<BeerRanking> deBeerVoesParaDominioAdd(List<BeerRankingVoes> listBeerRankingVoes) {

        for (BeerRankingVoes beerRankingVoes : listBeerRankingVoes){
            final BeerRanking beerRanking = new BeerRanking(beerRankingVoes.getId(),beerRankingVoes.getName(),beerRankingVoes.getDescription(),beerRankingVoes.getLiked(),beerRankingVoes.getLikes(),beerRankingVoes.getPhotos());
            listBeerRankingAdd.add(beerRanking);
        }

        return listBeerRankingAdd;
    }
}
