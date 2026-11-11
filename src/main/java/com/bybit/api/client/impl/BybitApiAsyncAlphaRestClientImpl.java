package com.bybit.api.client.impl;

import com.bybit.api.client.restApi.BybitApiCallback;
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
import com.bybit.api.client.restApi.BybitApiService;
import com.bybit.api.client.restApi.BybitApiAsyncAlphaRestClient;

import static com.bybit.api.client.service.BybitApiServiceGenerator.createService;

public class BybitApiAsyncAlphaRestClientImpl implements BybitApiAsyncAlphaRestClient {
    private final BybitApiService bybitApiService;

    public BybitApiAsyncAlphaRestClientImpl(String apiKey, String secret, String baseUrl, boolean debugMode, long recvWindow, String logOption, String referer) {
        bybitApiService = createService(BybitApiService.class, apiKey, secret, baseUrl, debugMode, recvWindow, logOption, referer);
    }

    @Override
    public void getLPOrderList(LPOrderListRequest lPOrderListRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getLPOrderList(lPOrderListRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getLPPayTokenList(LPPayTokenListRequest lPPayTokenListRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getLPPayTokenList(lPPayTokenListRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getLPPayTokenPrice(LPPayTokenPriceRequest lPPayTokenPriceRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getLPPayTokenPrice(lPPayTokenPriceRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getLPPoolInfo(LPPoolInfoRequest lPPoolInfoRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getLPPoolInfo(lPPoolInfoRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getLPPoolList(LPPoolListRequest lPPoolListRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getLPPoolList(lPPoolListRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getLPPositionList(LPPositionListRequest lPPositionListRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getLPPositionList(lPPositionListRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void executeLPRedeem(LPRedeemRequest lPRedeemRequest, BybitApiCallback<Object> callback) {
        bybitApiService.executeLPRedeem(lPRedeemRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void executeLPStake(LPStakeRequest lPStakeRequest, BybitApiCallback<Object> callback) {
        bybitApiService.executeLPStake(lPStakeRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void executePredictionBuy(PredictionBuyRequest predictionBuyRequest, BybitApiCallback<Object> callback) {
        bybitApiService.executePredictionBuy(predictionBuyRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getPredictionEngineStatus(BybitApiCallback<Object> callback) {
        bybitApiService.getPredictionEngineStatus().enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getPredictionEventDetail(PredictionEventDetailRequest predictionEventDetailRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getPredictionEventDetail(predictionEventDetailRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getPredictionOrderBook(PredictionOrderBookRequest predictionOrderBookRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getPredictionOrderBook(predictionOrderBookRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getPredictionOrderEstimate(PredictionOrderEstimateRequest predictionOrderEstimateRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getPredictionOrderEstimate(predictionOrderEstimateRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getPredictionOrderList(PredictionOrderListRequest predictionOrderListRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getPredictionOrderList(predictionOrderListRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getPredictionPayTokenList(BybitApiCallback<Object> callback) {
        bybitApiService.getPredictionPayTokenList().enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getPredictionPortfolioSummary(GetPredictionPortfolioSummaryRequest getPredictionPortfolioSummaryRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getPredictionPortfolioSummary(getPredictionPortfolioSummaryRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getPredictionPositionHistory(PredictionPositionHistoryRequest predictionPositionHistoryRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getPredictionPositionHistory(predictionPositionHistoryRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getPredictionPositionList(PredictionPositionListRequest predictionPositionListRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getPredictionPositionList(predictionPositionListRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getPredictionPriceHistory(PredictionPriceHistoryRequest predictionPriceHistoryRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getPredictionPriceHistory(predictionPriceHistoryRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void executePredictionSell(PredictionSellRequest predictionSellRequest, BybitApiCallback<Object> callback) {
        bybitApiService.executePredictionSell(predictionSellRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getPredictionSideMarketList(PredictionSideMarketListRequest predictionSideMarketListRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getPredictionSideMarketList(predictionSideMarketListRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getPredictionGroupStageDetail(PredictionGroupStageDetailRequest predictionGroupStageDetailRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getPredictionGroupStageDetail(predictionGroupStageDetailRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getPredictionMatchList(PredictionMatchListRequest predictionMatchListRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getPredictionMatchList(predictionMatchListRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getPredictionTimelineStages(Long eventType, BybitApiCallback<Object> callback) {
        bybitApiService.getPredictionTimelineStages(eventType).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getPredictionTokenPrice(PredictionTokenPriceRequest predictionTokenPriceRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getPredictionTokenPrice(predictionTokenPriceRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getAssetDetail(TradeAssetDetailRequest tradeAssetDetailRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getAssetDetail(tradeAssetDetailRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getAssetList(GetAssetListRequest getAssetListRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getAssetList(getAssetListRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getBizTokenDetails(TradeBizTokenDetailsRequest tradeBizTokenDetailsRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getBizTokenDetails(tradeBizTokenDetailsRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getBizTokenList(TradeBizTokenListRequest tradeBizTokenListRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getBizTokenList(tradeBizTokenListRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getBizTokenPriceList(TradeBizTokenPriceListRequest tradeBizTokenPriceListRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getBizTokenPriceList(tradeBizTokenPriceListRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getOrderList(TradeOrderListRequest tradeOrderListRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getOrderList(tradeOrderListRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getPayTokenList(TradePayTokenListRequest tradePayTokenListRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getPayTokenList(tradePayTokenListRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void executePurchase(TradePurchaseRequest tradePurchaseRequest, BybitApiCallback<Object> callback) {
        bybitApiService.executePurchase(tradePurchaseRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getTradeQuote(TradeQuoteRequest tradeQuoteRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getTradeQuote(tradeQuoteRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void executeRedeem(TradeRedeemRequest tradeRedeemRequest, BybitApiCallback<Object> callback) {
        bybitApiService.executeRedeem(tradeRedeemRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }
}
