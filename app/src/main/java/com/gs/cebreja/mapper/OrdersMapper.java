package com.gs.cebreja.mapper;

import com.gs.cebreja.model.OrderSolicitations;
import com.gs.cebreja.model.UserApreciation;
import com.gs.cebreja.network.response.GetAppreciationResponse;
import com.gs.cebreja.network.response.GetBeerOrderResponse;

import java.util.ArrayList;
import java.util.List;

public class OrdersMapper {

    public static List<OrderSolicitations> deOrderParaDominio(List<GetBeerOrderResponse> listOrder) {
        List<OrderSolicitations> listOrderLocal = new ArrayList<>();
        for (GetBeerOrderResponse beerOrder : listOrder){
            final OrderSolicitations order = new OrderSolicitations(beerOrder.getId(),beerOrder.getName(),beerOrder.getWhenChanged(),beerOrder.getPhotos(),beerOrder.getOrderType(),beerOrder.getOrderStatus());
            listOrderLocal.add(order);
        }
        return listOrderLocal;
    }
}
