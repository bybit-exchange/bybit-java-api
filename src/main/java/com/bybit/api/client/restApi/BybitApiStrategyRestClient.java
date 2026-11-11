package com.bybit.api.client.restApi;

import com.bybit.api.client.domain.strategy.request.CreateStrategyRequest;
import com.bybit.api.client.domain.strategy.request.StopStrategyRequest;

public interface BybitApiStrategyRestClient {
    Object createStrategy(CreateStrategyRequest createStrategyRequest);

    Object queryStrategyOrderList(String strategyId, String status, String symbol, Long beginTimeE0, Long endTimeE0, Integer pageSize, String cursor, String strategyType);

    Object queryStrategyList(String strategyId, String status, String symbol, String category, String strategyType, Long beginTimeE0, Long endTimeE0, Integer pageSize, String cursor);

    Object stopStrategy(StopStrategyRequest stopStrategyRequest);
}
