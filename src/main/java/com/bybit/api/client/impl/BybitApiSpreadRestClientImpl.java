package com.bybit.api.client.impl;

import com.bybit.api.client.domain.spread.request.SpreadDataRequest;
import com.bybit.api.client.domain.spread.request.SpreadOrderRequest;
import com.bybit.api.client.restApi.BybitApiService;
import com.bybit.api.client.restApi.BybitApiSpreadRestClient;

import java.util.HashMap;
import java.util.Map;

import static com.bybit.api.client.service.BybitApiServiceGenerator.createService;
import static com.bybit.api.client.service.BybitApiServiceGenerator.executeSync;

public class BybitApiSpreadRestClientImpl implements BybitApiSpreadRestClient {
    private final BybitApiService bybitApiService;

    public BybitApiSpreadRestClientImpl(String apiKey, String secret, String baseUrl, boolean debugMode, long recvWindow, String logOption, String referer) {
        bybitApiService = createService(BybitApiService.class, apiKey, secret, baseUrl, debugMode, recvWindow, logOption, referer);
    }

    @Override
    public Object getSpreadInstrumentsInfo(SpreadDataRequest request) {
        return executeSync(bybitApiService.getSpreadInstrumentsInfo(
                request.getBaseCoin(),
                request.getSpreadType(),
                request.getDirection(),
                request.getLimit(),
                request.getCursor()
        ));
    }

    @Override
    public Object getSpreadOrderbook(SpreadDataRequest request) {
        return executeSync(bybitApiService.getSpreadOrderbook(
                request.getSpreadSymbol(),
                request.getLimit()
        ));
    }

    @Override
    public Object getSpreadTickers(SpreadDataRequest request) {
        return executeSync(bybitApiService.getSpreadTickers(
                request.getSpreadSymbol(),
                request.getBaseCoin()
        ));
    }

    @Override
    public Object getSpreadRecentTrades(SpreadDataRequest request) {
        return executeSync(bybitApiService.getSpreadRecentTrades(
                request.getSpreadSymbol(),
                request.getBaseCoin(),
                request.getLimit()
        ));
    }

    @Override
    public Object createSpreadOrder(SpreadOrderRequest request) {
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
        return executeSync(bybitApiService.createSpreadOrder(params));
    }

    @Override
    public Object createSpreadOrder(Map<String, Object> request) {
        return executeSync(bybitApiService.createSpreadOrder(request));
    }

    @Override
    public Object amendSpreadOrder(SpreadOrderRequest request) {
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
        return executeSync(bybitApiService.amendSpreadOrder(params));
    }

    @Override
    public Object amendSpreadOrder(Map<String, Object> request) {
        return executeSync(bybitApiService.amendSpreadOrder(request));
    }

    @Override
    public Object cancelSpreadOrder(SpreadOrderRequest request) {
        Map<String, Object> params = new HashMap<>();
        if (request.getOrderId() != null) {
            params.put("orderId", request.getOrderId());
        }
        if (request.getOrderLinkId() != null) {
            params.put("orderLinkId", request.getOrderLinkId());
        }
        return executeSync(bybitApiService.cancelSpreadOrder(params));
    }

    @Override
    public Object cancelSpreadOrder(Map<String, Object> request) {
        return executeSync(bybitApiService.cancelSpreadOrder(request));
    }

    @Override
    public Object cancelAllSpreadOrders(SpreadDataRequest request) {
        Map<String, Object> params = new HashMap<>();
        if (request.getSpreadSymbol() != null) {
            params.put("spreadSymbol", request.getSpreadSymbol());
        }
        if (request.getBaseCoin() != null) {
            params.put("baseCoin", request.getBaseCoin());
        }
        return executeSync(bybitApiService.cancelAllSpreadOrders(params));
    }

    @Override
    public Object cancelAllSpreadOrders(Map<String, Object> request) {
        return executeSync(bybitApiService.cancelAllSpreadOrders(request));
    }

    @Override
    public Object getSpreadOpenOrders(SpreadDataRequest request) {
        return executeSync(bybitApiService.getSpreadOpenOrders(
                request.getSpreadSymbol(),
                request.getBaseCoin(),
                request.getOrderId(),
                request.getOrderLinkId(),
                request.getLimit(),
                request.getCursor()
        ));
    }

    @Override
    public Object getSpreadOrderHistory(SpreadDataRequest request) {
        return executeSync(bybitApiService.getSpreadOrderHistory(
                request.getSpreadSymbol(),
                request.getBaseCoin(),
                request.getOrderId(),
                request.getOrderLinkId(),
                request.getStartTime(),
                request.getEndTime(),
                request.getLimit(),
                request.getCursor()
        ));
    }

    @Override
    public Object getSpreadTradeHistory(SpreadDataRequest request) {
        return executeSync(bybitApiService.getSpreadTradeHistory(
                request.getSpreadSymbol(),
                request.getBaseCoin(),
                request.getOrderId(),
                request.getStartTime(),
                request.getEndTime(),
                request.getLimit(),
                request.getCursor()
        ));
    }

    @Override
    public Object getSpreadMaxQty(String symbol, String side, String orderPrice) {
        return executeSync(bybitApiService.getSpreadMaxQty(symbol, side, orderPrice));
    }
}
