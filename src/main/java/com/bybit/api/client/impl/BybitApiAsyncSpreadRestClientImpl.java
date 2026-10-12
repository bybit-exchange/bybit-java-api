package com.bybit.api.client.impl;

import com.bybit.api.client.domain.spread.request.SpreadDataRequest;
import com.bybit.api.client.domain.spread.request.SpreadOrderRequest;
import com.bybit.api.client.restApi.BybitApiAsyncSpreadRestClient;
import com.bybit.api.client.restApi.BybitApiCallback;
import com.bybit.api.client.restApi.BybitApiService;

import java.util.HashMap;
import java.util.Map;

import static com.bybit.api.client.service.BybitApiServiceGenerator.createService;

public class BybitApiAsyncSpreadRestClientImpl implements BybitApiAsyncSpreadRestClient {
    private final BybitApiService bybitApiService;

    public BybitApiAsyncSpreadRestClientImpl(String apiKey, String secret, String baseUrl, boolean debugMode, long recvWindow, String logOption, String referer) {
        bybitApiService = createService(BybitApiService.class, apiKey, secret, baseUrl, debugMode, recvWindow, logOption, referer);
    }

    @Override
    public void getSpreadInstrumentsInfo(SpreadDataRequest request, BybitApiCallback<Object> callback) {
        bybitApiService.getSpreadInstrumentsInfo(
                request.getBaseCoin(),
                request.getSpreadType(),
                request.getDirection(),
                request.getLimit(),
                request.getCursor()
        ).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getSpreadOrderbook(SpreadDataRequest request, BybitApiCallback<Object> callback) {
        bybitApiService.getSpreadOrderbook(
                request.getSpreadSymbol(),
                request.getLimit()
        ).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getSpreadTickers(SpreadDataRequest request, BybitApiCallback<Object> callback) {
        bybitApiService.getSpreadTickers(
                request.getSpreadSymbol(),
                request.getBaseCoin()
        ).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getSpreadRecentTrades(SpreadDataRequest request, BybitApiCallback<Object> callback) {
        bybitApiService.getSpreadRecentTrades(
                request.getSpreadSymbol(),
                request.getBaseCoin(),
                request.getLimit()
        ).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void createSpreadOrder(SpreadOrderRequest request, BybitApiCallback<Object> callback) {
        Map<String, Object> params = new HashMap<>();
        params.put("spreadSymbol", request.getSpreadSymbol());
        params.put("side", request.getSide() != null ? request.getSide().getTransactionSide() : null);
        params.put("orderType", request.getOrderType());
        params.put("qty", request.getQty());
        params.put("price", request.getPrice());
        if (request.getTimeInForce() != null) {
            params.put("timeInForce", request.getTimeInForce().getDescription());
        }
        if (request.getOrderLinkId() != null) {
            params.put("orderLinkId", request.getOrderLinkId());
        }
        params.values().removeIf(java.util.Objects::isNull);
        bybitApiService.createSpreadOrder(params).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void createSpreadOrder(Map<String, Object> request, BybitApiCallback<Object> callback) {
        bybitApiService.createSpreadOrder(request).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void amendSpreadOrder(SpreadOrderRequest request, BybitApiCallback<Object> callback) {
        Map<String, Object> params = new HashMap<>();
        if (request.getOrderId() != null) {
            params.put("orderId", request.getOrderId());
        }
        if (request.getOrderLinkId() != null) {
            params.put("orderLinkId", request.getOrderLinkId());
        }
        if (request.getQty() != null) {
            params.put("qty", request.getQty());
        }
        if (request.getPrice() != null) {
            params.put("price", request.getPrice());
        }
        bybitApiService.amendSpreadOrder(params).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void amendSpreadOrder(Map<String, Object> request, BybitApiCallback<Object> callback) {
        bybitApiService.amendSpreadOrder(request).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void cancelSpreadOrder(SpreadOrderRequest request, BybitApiCallback<Object> callback) {
        Map<String, Object> params = new HashMap<>();
        if (request.getOrderId() != null) {
            params.put("orderId", request.getOrderId());
        }
        if (request.getOrderLinkId() != null) {
            params.put("orderLinkId", request.getOrderLinkId());
        }
        bybitApiService.cancelSpreadOrder(params).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void cancelSpreadOrder(Map<String, Object> request, BybitApiCallback<Object> callback) {
        bybitApiService.cancelSpreadOrder(request).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void cancelAllSpreadOrders(SpreadDataRequest request, BybitApiCallback<Object> callback) {
        Map<String, Object> params = new HashMap<>();
        if (request.getSpreadSymbol() != null) {
            params.put("spreadSymbol", request.getSpreadSymbol());
        }
        if (request.getBaseCoin() != null) {
            params.put("baseCoin", request.getBaseCoin());
        }
        bybitApiService.cancelAllSpreadOrders(params).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void cancelAllSpreadOrders(Map<String, Object> request, BybitApiCallback<Object> callback) {
        bybitApiService.cancelAllSpreadOrders(request).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getSpreadOpenOrders(SpreadDataRequest request, BybitApiCallback<Object> callback) {
        bybitApiService.getSpreadOpenOrders(
                request.getSpreadSymbol(),
                request.getBaseCoin(),
                request.getOrderId(),
                request.getOrderLinkId(),
                request.getLimit(),
                request.getCursor()
        ).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getSpreadOrderHistory(SpreadDataRequest request, BybitApiCallback<Object> callback) {
        bybitApiService.getSpreadOrderHistory(
                request.getSpreadSymbol(),
                request.getBaseCoin(),
                request.getOrderId(),
                request.getOrderLinkId(),
                request.getStartTime(),
                request.getEndTime(),
                request.getLimit(),
                request.getCursor()
        ).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getSpreadTradeHistory(SpreadDataRequest request, BybitApiCallback<Object> callback) {
        bybitApiService.getSpreadTradeHistory(
                request.getSpreadSymbol(),
                request.getBaseCoin(),
                request.getOrderId(),
                request.getStartTime(),
                request.getEndTime(),
                request.getLimit(),
                request.getCursor()
        ).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getSpreadMaxQty(String symbol, String side, String orderPrice, BybitApiCallback<Object> callback) {
        bybitApiService.getSpreadMaxQty(symbol, side, orderPrice).enqueue(new BybitApiCallbackAdapter<>(callback));
    }
}
