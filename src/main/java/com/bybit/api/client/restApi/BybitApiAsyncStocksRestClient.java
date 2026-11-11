package com.bybit.api.client.restApi;

import com.bybit.api.client.domain.stocks.request.CancelStocksOrderRequest;
import com.bybit.api.client.domain.stocks.request.ConvertSubmitRequest;
import com.bybit.api.client.domain.stocks.request.PlaceStocksOrderRequest;

public interface BybitApiAsyncStocksRestClient {
    void placeStocksOrder(PlaceStocksOrderRequest placeStocksOrderRequest, BybitApiCallback<Object> callback);

    void cancelStocksOrder(CancelStocksOrderRequest cancelStocksOrderRequest, BybitApiCallback<Object> callback);

    void getStocksOrderDetail(String orderNo, String requestId, BybitApiCallback<Object> callback);

    void getConvertList(String symbol, BybitApiCallback<Object> callback);

    void submitConvert(ConvertSubmitRequest convertSubmitRequest, BybitApiCallback<Object> callback);

    void getConvertDetail(String orderNo, String requestId, BybitApiCallback<Object> callback);

    void getStocksPositions(String symbol, Boolean showZero, BybitApiCallback<Object> callback);

    void getMarketSession(String symbol, BybitApiCallback<Object> callback);

    void getMultiplierList(String symbol, Long current, Integer pageSize, BybitApiCallback<Object> callback);
}
