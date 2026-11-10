package com.bybit.api.client.restApi;

public interface BybitApiAsyncEventRestClient {
    void getEcOrderHistory(String symbol, String orderId, String orderLinkId, Long startTime, Long endTime, Integer limit, String cursor, BybitApiCallback<Object> callback);

    void getEcActiveOrders(String symbol, String orderId, String orderLinkId, Integer limit, String cursor, BybitApiCallback<Object> callback);

    void getEcPositionInfo(String symbol, String baseCoin, String settleCoin, Integer limit, String cursor, BybitApiCallback<Object> callback);

    void getEcSettlements(String symbol, String orderId, Long startTime, Long endTime, Integer limit, String cursor, BybitApiCallback<Object> callback);

    void getEcTradeHistory(String symbol, String orderId, String orderLinkId, Long startTime, Long endTime, Integer limit, String cursor, BybitApiCallback<Object> callback);
}
