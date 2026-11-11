package com.bybit.api.client.impl;

import com.bybit.api.client.restApi.BybitApiCallback;
import com.bybit.api.client.restApi.BybitApiService;
import com.bybit.api.client.restApi.BybitApiAsyncEventRestClient;

import static com.bybit.api.client.service.BybitApiServiceGenerator.createService;

public class BybitApiAsyncEventRestClientImpl implements BybitApiAsyncEventRestClient {
    private final BybitApiService bybitApiService;

    public BybitApiAsyncEventRestClientImpl(String apiKey, String secret, String baseUrl, boolean debugMode, long recvWindow, String logOption, String referer) {
        bybitApiService = createService(BybitApiService.class, apiKey, secret, baseUrl, debugMode, recvWindow, logOption, referer);
    }

    @Override
    public void getEcOrderHistory(String symbol, String orderId, String orderLinkId, Long startTime, Long endTime, Integer limit, String cursor, BybitApiCallback<Object> callback) {
        bybitApiService.getEcOrderHistory(symbol, orderId, orderLinkId, startTime, endTime, limit, cursor).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getEcActiveOrders(String symbol, String orderId, String orderLinkId, Integer limit, String cursor, BybitApiCallback<Object> callback) {
        bybitApiService.getEcActiveOrders(symbol, orderId, orderLinkId, limit, cursor).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getEcPositionInfo(String symbol, String baseCoin, String settleCoin, Integer limit, String cursor, BybitApiCallback<Object> callback) {
        bybitApiService.getEcPositionInfo(symbol, baseCoin, settleCoin, limit, cursor).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getEcSettlements(String symbol, String orderId, Long startTime, Long endTime, Integer limit, String cursor, BybitApiCallback<Object> callback) {
        bybitApiService.getEcSettlements(symbol, orderId, startTime, endTime, limit, cursor).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getEcTradeHistory(String symbol, String orderId, String orderLinkId, Long startTime, Long endTime, Integer limit, String cursor, BybitApiCallback<Object> callback) {
        bybitApiService.getEcTradeHistory(symbol, orderId, orderLinkId, startTime, endTime, limit, cursor).enqueue(new BybitApiCallbackAdapter<>(callback));
    }
}
