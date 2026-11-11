package com.bybit.api.client.impl;

import com.bybit.api.client.restApi.BybitApiService;
import com.bybit.api.client.restApi.BybitApiEventRestClient;

import static com.bybit.api.client.service.BybitApiServiceGenerator.createService;
import static com.bybit.api.client.service.BybitApiServiceGenerator.executeSync;

public class BybitApiEventRestClientImpl implements BybitApiEventRestClient {
    private final BybitApiService bybitApiService;

    public BybitApiEventRestClientImpl(String apiKey, String secret, String baseUrl, boolean debugMode, long recvWindow, String logOption, String referer) {
        bybitApiService = createService(BybitApiService.class, apiKey, secret, baseUrl, debugMode, recvWindow, logOption, referer);
    }

    @Override
    public Object getEcOrderHistory(String symbol, String orderId, String orderLinkId, Long startTime, Long endTime, Integer limit, String cursor) {
        return executeSync(bybitApiService.getEcOrderHistory(symbol, orderId, orderLinkId, startTime, endTime, limit, cursor));
    }

    @Override
    public Object getEcActiveOrders(String symbol, String orderId, String orderLinkId, Integer limit, String cursor) {
        return executeSync(bybitApiService.getEcActiveOrders(symbol, orderId, orderLinkId, limit, cursor));
    }

    @Override
    public Object getEcPositionInfo(String symbol, String baseCoin, String settleCoin, Integer limit, String cursor) {
        return executeSync(bybitApiService.getEcPositionInfo(symbol, baseCoin, settleCoin, limit, cursor));
    }

    @Override
    public Object getEcSettlements(String symbol, String orderId, Long startTime, Long endTime, Integer limit, String cursor) {
        return executeSync(bybitApiService.getEcSettlements(symbol, orderId, startTime, endTime, limit, cursor));
    }

    @Override
    public Object getEcTradeHistory(String symbol, String orderId, String orderLinkId, Long startTime, Long endTime, Integer limit, String cursor) {
        return executeSync(bybitApiService.getEcTradeHistory(symbol, orderId, orderLinkId, startTime, endTime, limit, cursor));
    }
}
