package com.bybit.api.client.impl;

import com.bybit.api.client.domain.strategy.request.CreateStrategyRequest;
import com.bybit.api.client.domain.strategy.request.StopStrategyRequest;
import com.bybit.api.client.restApi.BybitApiService;
import com.bybit.api.client.restApi.BybitApiStrategyRestClient;

import static com.bybit.api.client.service.BybitApiServiceGenerator.createService;
import static com.bybit.api.client.service.BybitApiServiceGenerator.executeSync;

public class BybitApiStrategyRestClientImpl implements BybitApiStrategyRestClient {
    private final BybitApiService bybitApiService;

    public BybitApiStrategyRestClientImpl(String apiKey, String secret, String baseUrl, boolean debugMode, long recvWindow, String logOption, String referer) {
        bybitApiService = createService(BybitApiService.class, apiKey, secret, baseUrl, debugMode, recvWindow, logOption, referer);
    }

    @Override
    public Object createStrategy(CreateStrategyRequest createStrategyRequest) {
        return executeSync(bybitApiService.createStrategy(createStrategyRequest));
    }

    @Override
    public Object queryStrategyOrderList(String strategyId, String status, String symbol, Long beginTimeE0, Long endTimeE0, Integer pageSize, String cursor, String strategyType) {
        return executeSync(bybitApiService.queryStrategyOrderList(strategyId, status, symbol, beginTimeE0, endTimeE0, pageSize, cursor, strategyType));
    }

    @Override
    public Object queryStrategyList(String strategyId, String status, String symbol, String category, String strategyType, Long beginTimeE0, Long endTimeE0, Integer pageSize, String cursor) {
        return executeSync(bybitApiService.queryStrategyList(strategyId, status, symbol, category, strategyType, beginTimeE0, endTimeE0, pageSize, cursor));
    }

    @Override
    public Object stopStrategy(StopStrategyRequest stopStrategyRequest) {
        return executeSync(bybitApiService.stopStrategy(stopStrategyRequest));
    }
}
