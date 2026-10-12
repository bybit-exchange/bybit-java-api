package com.bybit.api.client.restApi;

import com.bybit.api.client.domain.spread.request.SpreadDataRequest;
import com.bybit.api.client.domain.spread.request.SpreadOrderRequest;

import java.util.Map;

public interface BybitApiAsyncSpreadRestClient {

    void getSpreadInstrumentsInfo(SpreadDataRequest request, BybitApiCallback<Object> callback);
    void getSpreadOrderbook(SpreadDataRequest request, BybitApiCallback<Object> callback);
    void getSpreadTickers(SpreadDataRequest request, BybitApiCallback<Object> callback);
    void getSpreadRecentTrades(SpreadDataRequest request, BybitApiCallback<Object> callback);

    void createSpreadOrder(SpreadOrderRequest request, BybitApiCallback<Object> callback);
    void createSpreadOrder(Map<String, Object> request, BybitApiCallback<Object> callback);
    void amendSpreadOrder(SpreadOrderRequest request, BybitApiCallback<Object> callback);
    void amendSpreadOrder(Map<String, Object> request, BybitApiCallback<Object> callback);
    void cancelSpreadOrder(SpreadOrderRequest request, BybitApiCallback<Object> callback);
    void cancelSpreadOrder(Map<String, Object> request, BybitApiCallback<Object> callback);
    void cancelAllSpreadOrders(SpreadDataRequest request, BybitApiCallback<Object> callback);
    void cancelAllSpreadOrders(Map<String, Object> request, BybitApiCallback<Object> callback);
    void getSpreadOpenOrders(SpreadDataRequest request, BybitApiCallback<Object> callback);
    void getSpreadOrderHistory(SpreadDataRequest request, BybitApiCallback<Object> callback);
    void getSpreadTradeHistory(SpreadDataRequest request, BybitApiCallback<Object> callback);

    default void getSpreadMaxQty(String symbol, String side, String orderPrice, BybitApiCallback<Object> callback) {
        throw new UnsupportedOperationException("getSpreadMaxQty is not implemented by this client");
    }
}
