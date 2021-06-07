package com.gs.cebreja.mapper;

import com.gs.cebreja.model.Beer;
import com.gs.cebreja.network.response.BeerRankingVoes;

import java.util.ArrayList;
import java.util.List;

public class BeerRankingMapper {

    public static List<Beer> deBeerVoesParaDominio(List<BeerRankingVoes> listBeerRankingVoes) {
        List<Beer> listBeer = new ArrayList<>();

        for (BeerRankingVoes beerRankingVoes : listBeerRankingVoes){
            final Beer beer = new Beer(beerRankingVoes.getName(),beerRankingVoes.getDescription(),beerRankingVoes.getLiked());
            listBeer.add(beer);
        }

        return listBeer;
    }
}
