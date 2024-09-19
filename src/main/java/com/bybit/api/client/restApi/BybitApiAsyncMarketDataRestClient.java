package com.bybit.api.client.restApi;

import com.bybit.api.client.domain.GenericResponse;
import com.bybit.api.client.domain.market.request.MarketDataRequest;
import com.bybit.api.client.domain.market.response.serverTime.ServerTimeResult;

public interface BybitApiAsyncMarketDataRestClient {
    // Market endpoints
    void getServerTime(BybitApiCallback<GenericResponse<ServerTimeResult>> callback);
    void getMarketLinesData(MarketDataRequest marketKlineRequest, BybitApiCallback<Object> callback);
    void getMarketPriceLinesData(MarketDataRequest marketKlineRequest, BybitApiCallback<Object> callback);
    void getIndexPriceLinesData(MarketDataRequest marketKlineRequest, BybitApiCallback<Object> callback);
    void getPremiumIndexPriceLinesData(MarketDataRequest marketKlineRequest, BybitApiCallback<Object> callback);
    void getInstrumentsInfo(MarketDataRequest instrumentInfoRequest, BybitApiCallback<Object> callback);
    void getMarketOrderBook(MarketDataRequest marketOrderBookRequest, BybitApiCallback<Object> callback);
    void getMarketTickers(MarketDataRequest marketDataTickerRequest, BybitApiCallback<Object> callback);
    void getFundingHistory(MarketDataRequest fundingHistoryRequest, BybitApiCallback<Object> callback);
    void getRecentTradeData(MarketDataRequest recentTradeRequest, BybitApiCallback<Object> callback);
    void getOpenInterest(MarketDataRequest openInterestRequest, BybitApiCallback<Object> callback);
    void getHistoricalVolatility(MarketDataRequest historicalVolatilityRequest, BybitApiCallback<Object> callback);
    void getInsurance(MarketDataRequest marketDataRequest, BybitApiCallback<Object> callback);
    void getInsurance(BybitApiCallback<Object> callback);
    void getRiskLimit(MarketDataRequest marketRiskLimitRequest, BybitApiCallback<Object> callback);
    void getDeliveryPrice(MarketDataRequest deliveryPriceRequest, BybitApiCallback<Object> callback);
    void getMarketAccountRatio(MarketDataRequest marketAccountRatioRequest, BybitApiCallback<Object> callback);
    void getAnnouncementInfo(MarketDataRequest announcementInfoRequest, BybitApiCallback<Object> callback);
}
