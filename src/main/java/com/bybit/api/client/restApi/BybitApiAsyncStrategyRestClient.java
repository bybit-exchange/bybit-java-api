package com.bybit.api.client.restApi;

import com.bybit.api.client.domain.strategy.request.CreateStrategyRequest;
import com.bybit.api.client.domain.strategy.request.StopStrategyRequest;

public interface BybitApiAsyncStrategyRestClient {
    void createStrategy(CreateStrategyRequest createStrategyRequest, BybitApiCallback<Object> callback);

    void queryStrategyOrderList(String strategyId, String status, String symbol, Long beginTimeE0, Long endTimeE0, Integer pageSize, String cursor, String strategyType, BybitApiCallback<Object> callback);

    void queryStrategyList(String strategyId, String status, String symbol, String category, String strategyType, Long beginTimeE0, Long endTimeE0, Integer pageSize, String cursor, BybitApiCallback<Object> callback);

    void stopStrategy(StopStrategyRequest stopStrategyRequest, BybitApiCallback<Object> callback);
}
