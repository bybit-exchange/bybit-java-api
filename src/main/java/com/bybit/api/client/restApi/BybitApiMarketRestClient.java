package com.bybit.api.client.restApi;

import com.bybit.api.client.domain.GenericResponse;
import com.bybit.api.client.domain.market.request.MarketDataRequest;
import com.bybit.api.client.domain.market.response.fundingRate.FundingRateResult;
import com.bybit.api.client.domain.market.response.tickers.TickerEntry;
import com.bybit.api.client.domain.market.response.tickers.TickersResult;

public interface BybitApiMarketRestClient {
    // Market Data
    Object getServerTime();
    Object getMarketLinesData(MarketDataRequest marketKlineRequest);
    Object getMarketPriceLinesData(MarketDataRequest marketKlineRequest);
    Object getIndexPriceLinesData(MarketDataRequest marketKlineRequest);
    Object getPremiumIndexPriceLinesData(MarketDataRequest marketKlineRequest);
    Object getInstrumentsInfo(MarketDataRequest instrumentInfoRequest);
    Object getMarketOrderBook(MarketDataRequest marketOrderBookRequest);
    <T extends TickerEntry> GenericResponse<TickersResult<T>> getMarketTickers(MarketDataRequest marketDataTickerRequest);
    GenericResponse<FundingRateResult> getFundingHistory(MarketDataRequest fundingHistoryRequest);
    Object getRecentTradeData(MarketDataRequest recentTradeRequest);
    Object getOpenInterest(MarketDataRequest openInterestRequest);
    Object getHistoricalVolatility(MarketDataRequest HistoricalVolatilityRequest);
    Object getInsurance(MarketDataRequest marketDataRequest);
    Object getInsurance();
    Object getRiskLimit(MarketDataRequest marketRiskLimitRequest);
    Object getDeliveryPrice(MarketDataRequest deliveryPriceRequest);
    Object getMarketAccountRatio(MarketDataRequest marketAccountRatioRequest);
    Object getAnnouncementInfo(MarketDataRequest announcementInfoRequest);
}
