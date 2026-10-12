package com.bybit.api.client.restApi;

import com.bybit.api.client.domain.spread.request.SpreadDataRequest;
import com.bybit.api.client.domain.spread.request.SpreadOrderRequest;

import java.util.Map;

public interface BybitApiSpreadRestClient {

    Object getSpreadInstrumentsInfo(SpreadDataRequest request);
    Object getSpreadOrderbook(SpreadDataRequest request);
    Object getSpreadTickers(SpreadDataRequest request);
    Object getSpreadRecentTrades(SpreadDataRequest request);

    Object createSpreadOrder(SpreadOrderRequest request);
    Object createSpreadOrder(Map<String, Object> request);
    Object amendSpreadOrder(SpreadOrderRequest request);
    Object amendSpreadOrder(Map<String, Object> request);
    Object cancelSpreadOrder(SpreadOrderRequest request);
    Object cancelSpreadOrder(Map<String, Object> request);
    Object cancelAllSpreadOrders(SpreadDataRequest request);
    Object cancelAllSpreadOrders(Map<String, Object> request);
    Object getSpreadOpenOrders(SpreadDataRequest request);
    Object getSpreadOrderHistory(SpreadDataRequest request);
    Object getSpreadTradeHistory(SpreadDataRequest request);

    Object getSpreadMaxQty(String symbol, String side, String orderPrice);
}
