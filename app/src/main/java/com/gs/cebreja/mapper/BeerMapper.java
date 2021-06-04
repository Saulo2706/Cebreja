package com.gs.cebreja.mapper;

import com.gs.cebreja.model.Beer;
import com.gs.cebreja.network.response.BeersResponse;

import java.util.ArrayList;
import java.util.List;

public class BeerMapper {

    public static List<Beer> deResponseParaDominio(List<BeersResponse> listBeerResponse) {
        List<Beer> listBeer = new ArrayList<>();

        for (BeersResponse beersResponse : listBeerResponse){
            final Beer beer = new Beer(beersResponse.getTituloOriginal(),beersResponse.getDescription(), beersResponse.getCaminhoPoster());
            listBeer.add(beer);
        }

        return listBeer;
    }
}
