package com.bybit.api.client.impl;

import com.bybit.api.client.restApi.BybitApiCallback;
import com.bybit.api.client.domain.stocks.request.CancelStocksOrderRequest;
import com.bybit.api.client.domain.stocks.request.ConvertSubmitRequest;
import com.bybit.api.client.domain.stocks.request.PlaceStocksOrderRequest;
import com.bybit.api.client.restApi.BybitApiService;
import com.bybit.api.client.restApi.BybitApiAsyncStocksRestClient;

import static com.bybit.api.client.service.BybitApiServiceGenerator.createService;

public class BybitApiAsyncStocksRestClientImpl implements BybitApiAsyncStocksRestClient {
    private final BybitApiService bybitApiService;

    public BybitApiAsyncStocksRestClientImpl(String apiKey, String secret, String baseUrl, boolean debugMode, long recvWindow, String logOption, String referer) {
        bybitApiService = createService(BybitApiService.class, apiKey, secret, baseUrl, debugMode, recvWindow, logOption, referer);
    }

    @Override
    public void placeStocksOrder(PlaceStocksOrderRequest placeStocksOrderRequest, BybitApiCallback<Object> callback) {
        bybitApiService.placeStocksOrder(placeStocksOrderRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void cancelStocksOrder(CancelStocksOrderRequest cancelStocksOrderRequest, BybitApiCallback<Object> callback) {
        bybitApiService.cancelStocksOrder(cancelStocksOrderRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getStocksOrderDetail(String orderNo, String requestId, BybitApiCallback<Object> callback) {
        bybitApiService.getStocksOrderDetail(orderNo, requestId).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getConvertList(String symbol, BybitApiCallback<Object> callback) {
        bybitApiService.getConvertList(symbol).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void submitConvert(ConvertSubmitRequest convertSubmitRequest, BybitApiCallback<Object> callback) {
        bybitApiService.submitConvert(convertSubmitRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getConvertDetail(String orderNo, String requestId, BybitApiCallback<Object> callback) {
        bybitApiService.getConvertDetail(orderNo, requestId).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getStocksPositions(String symbol, Boolean showZero, BybitApiCallback<Object> callback) {
        bybitApiService.getStocksPositions(symbol, showZero).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getMarketSession(String symbol, BybitApiCallback<Object> callback) {
        bybitApiService.getMarketSession(symbol).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getMultiplierList(String symbol, Long current, Integer pageSize, BybitApiCallback<Object> callback) {
        bybitApiService.getMultiplierList(symbol, current, pageSize).enqueue(new BybitApiCallbackAdapter<>(callback));
    }
}
