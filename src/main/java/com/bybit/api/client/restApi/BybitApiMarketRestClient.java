package com.bybit.api.client.restApi;

import com.bybit.api.client.domain.announcement.request.AnnouncementInfoRequest;
import com.bybit.api.client.domain.market.request.MarketDataRequest;

public interface BybitApiMarketRestClient {
    // Market Data
    Object getServerTime();
    Object getMarketLinesData(MarketDataRequest marketKlineRequest);
    Object getMarketPriceLinesData(MarketDataRequest marketKlineRequest);
    Object getIndexPriceLinesData(MarketDataRequest marketKlineRequest);
    Object getPremiumIndexPriceLinesData(MarketDataRequest marketKlineRequest);
    Object getInstrumentsInfo(MarketDataRequest instrumentInfoRequest);
    Object getMarketOrderBook(MarketDataRequest marketOrderBookRequest);
    Object getMarketTickers(MarketDataRequest marketDataTickerRequest);
    Object getFundingHistory(MarketDataRequest fundingHistoryRequest);
    Object getRecentTradeData(MarketDataRequest recentTradeRequest);
    Object getOpenInterest(MarketDataRequest openInterestRequest);
    Object getHistoricalVolatility(MarketDataRequest HistoricalVolatilityRequest);
    Object getInsurance(MarketDataRequest marketDataRequest);
    Object getInsurance();
    Object getRiskLimit(MarketDataRequest marketRiskLimitRequest);
    Object getDeliveryPrice(MarketDataRequest deliveryPriceRequest);
    Object getMarketAccountRatio(MarketDataRequest marketAccountRatioRequest);
    Object getAnnouncementInfo(MarketDataRequest announcementInfoRequest);
    default Object getAdlAlert(String symbol) {
        throw new UnsupportedOperationException("getAdlAlert is not implemented by this client");
    }
    default Object getFeeGroupInfo(String productType, String groupId) {
        throw new UnsupportedOperationException("getFeeGroupInfo is not implemented by this client");
    }
    default Object getIndexPriceComponents(String indexName) {
        throw new UnsupportedOperationException("getIndexPriceComponents is not implemented by this client");
    }
    default Object getNewDeliveryPrice(String category, String baseCoin, String settleCoin) {
        throw new UnsupportedOperationException("getNewDeliveryPrice is not implemented by this client");
    }
    default Object getOrderPriceLimit(String category, String symbol) {
        throw new UnsupportedOperationException("getOrderPriceLimit is not implemented by this client");
    }
    default Object getRpiOrderbook(String category, String symbol, Integer limit) {
        throw new UnsupportedOperationException("getRpiOrderbook is not implemented by this client");
    }

    default Object getOptionBaseCoins(String underlyingType) {
        throw new UnsupportedOperationException("getOptionBaseCoins is not implemented by this client");
    }
}
