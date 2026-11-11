package com.bybit.api.client.restApi;

import com.bybit.api.client.domain.stocks.request.CancelStocksOrderRequest;
import com.bybit.api.client.domain.stocks.request.ConvertSubmitRequest;
import com.bybit.api.client.domain.stocks.request.PlaceStocksOrderRequest;

public interface BybitApiStocksRestClient {
    Object placeStocksOrder(PlaceStocksOrderRequest placeStocksOrderRequest);

    Object cancelStocksOrder(CancelStocksOrderRequest cancelStocksOrderRequest);

    Object getStocksOrderDetail(String orderNo, String requestId);

    Object getConvertList(String symbol);

    Object submitConvert(ConvertSubmitRequest convertSubmitRequest);

    Object getConvertDetail(String orderNo, String requestId);

    Object getStocksPositions(String symbol, Boolean showZero);

    Object getMarketSession(String symbol);

    Object getMultiplierList(String symbol, Long current, Integer pageSize);
}
