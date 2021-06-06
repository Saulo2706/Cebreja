package com.gs.cebreja.mapper;

import com.gs.cebreja.model.Beer;
import com.gs.cebreja.network.response.BeerResponse;

import java.util.ArrayList;
import java.util.List;

public class BeerRankingMapper {

    public static List<Beer> deResponseParaDominio(List<BeerResponse> listBeerResponse) {
        List<Beer> listBeer = new ArrayList<>();

        for (BeerResponse BeerResponse : listBeerResponse){
            final Beer beer = new Beer(BeerResponse.getEmbedded().getVoes().get(1).getName(), BeerResponse.getEmbedded().getVoes().get(1).getDescription());
            listBeer.add(beer);
        }

        return listBeer;
    }
}
