package com.bybit.api.client.restApi;

import com.bybit.api.client.domain.announcement.request.AnnouncementInfoRequest;
import com.bybit.api.client.domain.market.request.MarketDataRequest;

public interface BybitApiAsyncMarketDataRestClient {
    // Market endpoints
    void getServerTime(BybitApiCallback<Object> callback);
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

    default void getAdlAlert(String symbol, BybitApiCallback<Object> callback) {
        throw new UnsupportedOperationException("getAdlAlert is not implemented by this client");
    }

    default void getFeeGroupInfo(String productType, String groupId, BybitApiCallback<Object> callback) {
        throw new UnsupportedOperationException("getFeeGroupInfo is not implemented by this client");
    }

    default void getIndexPriceComponents(String indexName, BybitApiCallback<Object> callback) {
        throw new UnsupportedOperationException("getIndexPriceComponents is not implemented by this client");
    }

    default void getNewDeliveryPrice(String category, String baseCoin, String settleCoin, BybitApiCallback<Object> callback) {
        throw new UnsupportedOperationException("getNewDeliveryPrice is not implemented by this client");
    }

    default void getOrderPriceLimit(String category, String symbol, BybitApiCallback<Object> callback) {
        throw new UnsupportedOperationException("getOrderPriceLimit is not implemented by this client");
    }

    default void getRpiOrderbook(String category, String symbol, Integer limit, BybitApiCallback<Object> callback) {
        throw new UnsupportedOperationException("getRpiOrderbook is not implemented by this client");
    }

    default void getOptionBaseCoins(String underlyingType, BybitApiCallback<Object> callback) {
        throw new UnsupportedOperationException("getOptionBaseCoins is not implemented by this client");
    }
}
