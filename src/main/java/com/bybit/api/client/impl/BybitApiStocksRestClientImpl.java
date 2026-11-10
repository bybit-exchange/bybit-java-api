package com.bybit.api.client.impl;

import com.bybit.api.client.domain.stocks.request.CancelStocksOrderRequest;
import com.bybit.api.client.domain.stocks.request.ConvertSubmitRequest;
import com.bybit.api.client.domain.stocks.request.PlaceStocksOrderRequest;
import com.bybit.api.client.restApi.BybitApiService;
import com.bybit.api.client.restApi.BybitApiStocksRestClient;

import static com.bybit.api.client.service.BybitApiServiceGenerator.createService;
import static com.bybit.api.client.service.BybitApiServiceGenerator.executeSync;

public class BybitApiStocksRestClientImpl implements BybitApiStocksRestClient {
    private final BybitApiService bybitApiService;

    public BybitApiStocksRestClientImpl(String apiKey, String secret, String baseUrl, boolean debugMode, long recvWindow, String logOption, String referer) {
        bybitApiService = createService(BybitApiService.class, apiKey, secret, baseUrl, debugMode, recvWindow, logOption, referer);
    }

    @Override
    public Object placeStocksOrder(PlaceStocksOrderRequest placeStocksOrderRequest) {
        return executeSync(bybitApiService.placeStocksOrder(placeStocksOrderRequest));
    }

    @Override
    public Object cancelStocksOrder(CancelStocksOrderRequest cancelStocksOrderRequest) {
        return executeSync(bybitApiService.cancelStocksOrder(cancelStocksOrderRequest));
    }

    @Override
    public Object getStocksOrderDetail(String orderNo, String requestId) {
        return executeSync(bybitApiService.getStocksOrderDetail(orderNo, requestId));
    }

    @Override
    public Object getConvertList(String symbol) {
        return executeSync(bybitApiService.getConvertList(symbol));
    }

    @Override
    public Object submitConvert(ConvertSubmitRequest convertSubmitRequest) {
        return executeSync(bybitApiService.submitConvert(convertSubmitRequest));
    }

    @Override
    public Object getConvertDetail(String orderNo, String requestId) {
        return executeSync(bybitApiService.getConvertDetail(orderNo, requestId));
    }

    @Override
    public Object getStocksPositions(String symbol, Boolean showZero) {
        return executeSync(bybitApiService.getStocksPositions(symbol, showZero));
    }

    @Override
    public Object getMarketSession(String symbol) {
        return executeSync(bybitApiService.getMarketSession(symbol));
    }

    @Override
    public Object getMultiplierList(String symbol, Long current, Integer pageSize) {
        return executeSync(bybitApiService.getMultiplierList(symbol, current, pageSize));
    }
}
