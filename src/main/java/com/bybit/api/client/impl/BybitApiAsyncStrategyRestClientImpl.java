package com.bybit.api.client.impl;

import com.bybit.api.client.restApi.BybitApiCallback;
import com.bybit.api.client.domain.strategy.request.CreateStrategyRequest;
import com.bybit.api.client.domain.strategy.request.StopStrategyRequest;
import com.bybit.api.client.restApi.BybitApiService;
import com.bybit.api.client.restApi.BybitApiAsyncStrategyRestClient;

import static com.bybit.api.client.service.BybitApiServiceGenerator.createService;

public class BybitApiAsyncStrategyRestClientImpl implements BybitApiAsyncStrategyRestClient {
    private final BybitApiService bybitApiService;

    public BybitApiAsyncStrategyRestClientImpl(String apiKey, String secret, String baseUrl, boolean debugMode, long recvWindow, String logOption, String referer) {
        bybitApiService = createService(BybitApiService.class, apiKey, secret, baseUrl, debugMode, recvWindow, logOption, referer);
    }

    @Override
    public void createStrategy(CreateStrategyRequest createStrategyRequest, BybitApiCallback<Object> callback) {
        bybitApiService.createStrategy(createStrategyRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void queryStrategyOrderList(String strategyId, String status, String symbol, Long beginTimeE0, Long endTimeE0, Integer pageSize, String cursor, String strategyType, BybitApiCallback<Object> callback) {
        bybitApiService.queryStrategyOrderList(strategyId, status, symbol, beginTimeE0, endTimeE0, pageSize, cursor, strategyType).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void queryStrategyList(String strategyId, String status, String symbol, String category, String strategyType, Long beginTimeE0, Long endTimeE0, Integer pageSize, String cursor, BybitApiCallback<Object> callback) {
        bybitApiService.queryStrategyList(strategyId, status, symbol, category, strategyType, beginTimeE0, endTimeE0, pageSize, cursor).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void stopStrategy(StopStrategyRequest stopStrategyRequest, BybitApiCallback<Object> callback) {
        bybitApiService.stopStrategy(stopStrategyRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }
}
