package com.gs.cebreja.mapper;

import com.gs.cebreja.model.Beer;
import com.gs.cebreja.model.StringWithId;
import com.gs.cebreja.network.response.BeerItemResponseGeneric;
import com.gs.cebreja.network.response.BeerRankingVoes;

import java.util.ArrayList;
import java.util.List;

public class ItemSelectMapper {
    public static List<StringWithId> deItemParaDominio(List<BeerItemResponseGeneric> listItensGeneric) {
        List<StringWithId> listItem = new ArrayList<>();
        for (BeerItemResponseGeneric beerItemResponseGeneric : listItensGeneric){
            final StringWithId item = new StringWithId(beerItemResponseGeneric.getName(),beerItemResponseGeneric.getId());
            listItem.add(item);
        }

        return listItem;
    }
}
