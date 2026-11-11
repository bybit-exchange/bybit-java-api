package com.bybit.api.client.restApi;

public interface BybitApiEventRestClient {
    Object getEcOrderHistory(String symbol, String orderId, String orderLinkId, Long startTime, Long endTime, Integer limit, String cursor);

    Object getEcActiveOrders(String symbol, String orderId, String orderLinkId, Integer limit, String cursor);

    Object getEcPositionInfo(String symbol, String baseCoin, String settleCoin, Integer limit, String cursor);

    Object getEcSettlements(String symbol, String orderId, Long startTime, Long endTime, Integer limit, String cursor);

    Object getEcTradeHistory(String symbol, String orderId, String orderLinkId, Long startTime, Long endTime, Integer limit, String cursor);
}
