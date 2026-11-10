package com.bybit.api.client.restApi;

import com.bybit.api.client.domain.alpha.request.GetAssetListRequest;
import com.bybit.api.client.domain.alpha.request.GetPredictionPortfolioSummaryRequest;
import com.bybit.api.client.domain.alpha.request.LPOrderListRequest;
import com.bybit.api.client.domain.alpha.request.LPPayTokenListRequest;
import com.bybit.api.client.domain.alpha.request.LPPayTokenPriceRequest;
import com.bybit.api.client.domain.alpha.request.LPPoolInfoRequest;
import com.bybit.api.client.domain.alpha.request.LPPoolListRequest;
import com.bybit.api.client.domain.alpha.request.LPPositionListRequest;
import com.bybit.api.client.domain.alpha.request.LPRedeemRequest;
import com.bybit.api.client.domain.alpha.request.LPStakeRequest;
import com.bybit.api.client.domain.alpha.request.PredictionBuyRequest;
import com.bybit.api.client.domain.alpha.request.PredictionEventDetailRequest;
import com.bybit.api.client.domain.alpha.request.PredictionGroupStageDetailRequest;
import com.bybit.api.client.domain.alpha.request.PredictionMatchListRequest;
import com.bybit.api.client.domain.alpha.request.PredictionOrderBookRequest;
import com.bybit.api.client.domain.alpha.request.PredictionOrderEstimateRequest;
import com.bybit.api.client.domain.alpha.request.PredictionOrderListRequest;
import com.bybit.api.client.domain.alpha.request.PredictionPositionHistoryRequest;
import com.bybit.api.client.domain.alpha.request.PredictionPositionListRequest;
import com.bybit.api.client.domain.alpha.request.PredictionPriceHistoryRequest;
import com.bybit.api.client.domain.alpha.request.PredictionSellRequest;
import com.bybit.api.client.domain.alpha.request.PredictionSideMarketListRequest;
import com.bybit.api.client.domain.alpha.request.PredictionTokenPriceRequest;
import com.bybit.api.client.domain.alpha.request.TradeAssetDetailRequest;
import com.bybit.api.client.domain.alpha.request.TradeBizTokenDetailsRequest;
import com.bybit.api.client.domain.alpha.request.TradeBizTokenListRequest;
import com.bybit.api.client.domain.alpha.request.TradeBizTokenPriceListRequest;
import com.bybit.api.client.domain.alpha.request.TradeOrderListRequest;
import com.bybit.api.client.domain.alpha.request.TradePayTokenListRequest;
import com.bybit.api.client.domain.alpha.request.TradePurchaseRequest;
import com.bybit.api.client.domain.alpha.request.TradeQuoteRequest;
import com.bybit.api.client.domain.alpha.request.TradeRedeemRequest;

public interface BybitApiAsyncAlphaRestClient {
    void getLPOrderList(LPOrderListRequest lPOrderListRequest, BybitApiCallback<Object> callback);

    void getLPPayTokenList(LPPayTokenListRequest lPPayTokenListRequest, BybitApiCallback<Object> callback);

    void getLPPayTokenPrice(LPPayTokenPriceRequest lPPayTokenPriceRequest, BybitApiCallback<Object> callback);

    void getLPPoolInfo(LPPoolInfoRequest lPPoolInfoRequest, BybitApiCallback<Object> callback);

    void getLPPoolList(LPPoolListRequest lPPoolListRequest, BybitApiCallback<Object> callback);

    void getLPPositionList(LPPositionListRequest lPPositionListRequest, BybitApiCallback<Object> callback);

    void executeLPRedeem(LPRedeemRequest lPRedeemRequest, BybitApiCallback<Object> callback);

    void executeLPStake(LPStakeRequest lPStakeRequest, BybitApiCallback<Object> callback);

    void executePredictionBuy(PredictionBuyRequest predictionBuyRequest, BybitApiCallback<Object> callback);

    void getPredictionEngineStatus(BybitApiCallback<Object> callback);

    void getPredictionEventDetail(PredictionEventDetailRequest predictionEventDetailRequest, BybitApiCallback<Object> callback);

    void getPredictionOrderBook(PredictionOrderBookRequest predictionOrderBookRequest, BybitApiCallback<Object> callback);

    void getPredictionOrderEstimate(PredictionOrderEstimateRequest predictionOrderEstimateRequest, BybitApiCallback<Object> callback);

    void getPredictionOrderList(PredictionOrderListRequest predictionOrderListRequest, BybitApiCallback<Object> callback);

    void getPredictionPayTokenList(BybitApiCallback<Object> callback);

    void getPredictionPortfolioSummary(GetPredictionPortfolioSummaryRequest getPredictionPortfolioSummaryRequest, BybitApiCallback<Object> callback);

    void getPredictionPositionHistory(PredictionPositionHistoryRequest predictionPositionHistoryRequest, BybitApiCallback<Object> callback);

    void getPredictionPositionList(PredictionPositionListRequest predictionPositionListRequest, BybitApiCallback<Object> callback);

    void getPredictionPriceHistory(PredictionPriceHistoryRequest predictionPriceHistoryRequest, BybitApiCallback<Object> callback);

    void executePredictionSell(PredictionSellRequest predictionSellRequest, BybitApiCallback<Object> callback);

    void getPredictionSideMarketList(PredictionSideMarketListRequest predictionSideMarketListRequest, BybitApiCallback<Object> callback);

    void getPredictionGroupStageDetail(PredictionGroupStageDetailRequest predictionGroupStageDetailRequest, BybitApiCallback<Object> callback);

    void getPredictionMatchList(PredictionMatchListRequest predictionMatchListRequest, BybitApiCallback<Object> callback);

    void getPredictionTimelineStages(Long eventType, BybitApiCallback<Object> callback);

    void getPredictionTokenPrice(PredictionTokenPriceRequest predictionTokenPriceRequest, BybitApiCallback<Object> callback);

    void getAssetDetail(TradeAssetDetailRequest tradeAssetDetailRequest, BybitApiCallback<Object> callback);

    void getAssetList(GetAssetListRequest getAssetListRequest, BybitApiCallback<Object> callback);

    void getBizTokenDetails(TradeBizTokenDetailsRequest tradeBizTokenDetailsRequest, BybitApiCallback<Object> callback);

    void getBizTokenList(TradeBizTokenListRequest tradeBizTokenListRequest, BybitApiCallback<Object> callback);

    void getBizTokenPriceList(TradeBizTokenPriceListRequest tradeBizTokenPriceListRequest, BybitApiCallback<Object> callback);

    void getOrderList(TradeOrderListRequest tradeOrderListRequest, BybitApiCallback<Object> callback);

    void getPayTokenList(TradePayTokenListRequest tradePayTokenListRequest, BybitApiCallback<Object> callback);

    void executePurchase(TradePurchaseRequest tradePurchaseRequest, BybitApiCallback<Object> callback);

    void getTradeQuote(TradeQuoteRequest tradeQuoteRequest, BybitApiCallback<Object> callback);

    void executeRedeem(TradeRedeemRequest tradeRedeemRequest, BybitApiCallback<Object> callback);
}
