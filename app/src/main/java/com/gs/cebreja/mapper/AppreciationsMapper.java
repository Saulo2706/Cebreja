package com.gs.cebreja.mapper;

import com.gs.cebreja.model.Beer;
import com.gs.cebreja.model.UserApreciation;
import com.gs.cebreja.network.response.GetAppreciationResponse;

import java.util.ArrayList;
import java.util.List;

public class AppreciationsMapper {

    public static List<UserApreciation> deApreciationParaDominio(List<GetAppreciationResponse> listAppreciation) {
        List<UserApreciation> listAppreciationLocal = new ArrayList<>();
        for (GetAppreciationResponse beerAppreciation : listAppreciation){
            final UserApreciation apreciation = new UserApreciation(beerAppreciation.getDate(),beerAppreciation.getUser(),beerAppreciation.getScore(),beerAppreciation.getComment());
            listAppreciationLocal.add(apreciation);
        }
        return listAppreciationLocal;
    }

}
