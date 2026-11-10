package com.bybit.api.client.impl;

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
import com.bybit.api.client.restApi.BybitApiAlphaRestClient;

import static com.bybit.api.client.service.BybitApiServiceGenerator.createService;
import static com.bybit.api.client.service.BybitApiServiceGenerator.executeSync;

public class BybitApiAlphaRestClientImpl implements BybitApiAlphaRestClient {
    private final BybitApiService bybitApiService;

    public BybitApiAlphaRestClientImpl(String apiKey, String secret, String baseUrl, boolean debugMode, long recvWindow, String logOption, String referer) {
        bybitApiService = createService(BybitApiService.class, apiKey, secret, baseUrl, debugMode, recvWindow, logOption, referer);
    }

    @Override
    public Object getLPOrderList(LPOrderListRequest lPOrderListRequest) {
        return executeSync(bybitApiService.getLPOrderList(lPOrderListRequest));
    }

    @Override
    public Object getLPPayTokenList(LPPayTokenListRequest lPPayTokenListRequest) {
        return executeSync(bybitApiService.getLPPayTokenList(lPPayTokenListRequest));
    }

    @Override
    public Object getLPPayTokenPrice(LPPayTokenPriceRequest lPPayTokenPriceRequest) {
        return executeSync(bybitApiService.getLPPayTokenPrice(lPPayTokenPriceRequest));
    }

    @Override
    public Object getLPPoolInfo(LPPoolInfoRequest lPPoolInfoRequest) {
        return executeSync(bybitApiService.getLPPoolInfo(lPPoolInfoRequest));
    }

    @Override
    public Object getLPPoolList(LPPoolListRequest lPPoolListRequest) {
        return executeSync(bybitApiService.getLPPoolList(lPPoolListRequest));
    }

    @Override
    public Object getLPPositionList(LPPositionListRequest lPPositionListRequest) {
        return executeSync(bybitApiService.getLPPositionList(lPPositionListRequest));
    }

    @Override
    public Object executeLPRedeem(LPRedeemRequest lPRedeemRequest) {
        return executeSync(bybitApiService.executeLPRedeem(lPRedeemRequest));
    }

    @Override
    public Object executeLPStake(LPStakeRequest lPStakeRequest) {
        return executeSync(bybitApiService.executeLPStake(lPStakeRequest));
    }

    @Override
    public Object executePredictionBuy(PredictionBuyRequest predictionBuyRequest) {
        return executeSync(bybitApiService.executePredictionBuy(predictionBuyRequest));
    }

    @Override
    public Object getPredictionEngineStatus() {
        return executeSync(bybitApiService.getPredictionEngineStatus());
    }

    @Override
    public Object getPredictionEventDetail(PredictionEventDetailRequest predictionEventDetailRequest) {
        return executeSync(bybitApiService.getPredictionEventDetail(predictionEventDetailRequest));
    }

    @Override
    public Object getPredictionOrderBook(PredictionOrderBookRequest predictionOrderBookRequest) {
        return executeSync(bybitApiService.getPredictionOrderBook(predictionOrderBookRequest));
    }

    @Override
    public Object getPredictionOrderEstimate(PredictionOrderEstimateRequest predictionOrderEstimateRequest) {
        return executeSync(bybitApiService.getPredictionOrderEstimate(predictionOrderEstimateRequest));
    }

    @Override
    public Object getPredictionOrderList(PredictionOrderListRequest predictionOrderListRequest) {
        return executeSync(bybitApiService.getPredictionOrderList(predictionOrderListRequest));
    }

    @Override
    public Object getPredictionPayTokenList() {
        return executeSync(bybitApiService.getPredictionPayTokenList());
    }

    @Override
    public Object getPredictionPortfolioSummary(GetPredictionPortfolioSummaryRequest getPredictionPortfolioSummaryRequest) {
        return executeSync(bybitApiService.getPredictionPortfolioSummary(getPredictionPortfolioSummaryRequest));
    }

    @Override
    public Object getPredictionPositionHistory(PredictionPositionHistoryRequest predictionPositionHistoryRequest) {
        return executeSync(bybitApiService.getPredictionPositionHistory(predictionPositionHistoryRequest));
    }

    @Override
    public Object getPredictionPositionList(PredictionPositionListRequest predictionPositionListRequest) {
        return executeSync(bybitApiService.getPredictionPositionList(predictionPositionListRequest));
    }

    @Override
    public Object getPredictionPriceHistory(PredictionPriceHistoryRequest predictionPriceHistoryRequest) {
        return executeSync(bybitApiService.getPredictionPriceHistory(predictionPriceHistoryRequest));
    }

    @Override
    public Object executePredictionSell(PredictionSellRequest predictionSellRequest) {
        return executeSync(bybitApiService.executePredictionSell(predictionSellRequest));
    }

    @Override
    public Object getPredictionSideMarketList(PredictionSideMarketListRequest predictionSideMarketListRequest) {
        return executeSync(bybitApiService.getPredictionSideMarketList(predictionSideMarketListRequest));
    }

    @Override
    public Object getPredictionGroupStageDetail(PredictionGroupStageDetailRequest predictionGroupStageDetailRequest) {
        return executeSync(bybitApiService.getPredictionGroupStageDetail(predictionGroupStageDetailRequest));
    }

    @Override
    public Object getPredictionMatchList(PredictionMatchListRequest predictionMatchListRequest) {
        return executeSync(bybitApiService.getPredictionMatchList(predictionMatchListRequest));
    }

    @Override
    public Object getPredictionTimelineStages(Long eventType) {
        return executeSync(bybitApiService.getPredictionTimelineStages(eventType));
    }

    @Override
    public Object getPredictionTokenPrice(PredictionTokenPriceRequest predictionTokenPriceRequest) {
        return executeSync(bybitApiService.getPredictionTokenPrice(predictionTokenPriceRequest));
    }

    @Override
    public Object getAssetDetail(TradeAssetDetailRequest tradeAssetDetailRequest) {
        return executeSync(bybitApiService.getAssetDetail(tradeAssetDetailRequest));
    }

    @Override
    public Object getAssetList(GetAssetListRequest getAssetListRequest) {
        return executeSync(bybitApiService.getAssetList(getAssetListRequest));
    }

    @Override
    public Object getBizTokenDetails(TradeBizTokenDetailsRequest tradeBizTokenDetailsRequest) {
        return executeSync(bybitApiService.getBizTokenDetails(tradeBizTokenDetailsRequest));
    }

    @Override
    public Object getBizTokenList(TradeBizTokenListRequest tradeBizTokenListRequest) {
        return executeSync(bybitApiService.getBizTokenList(tradeBizTokenListRequest));
    }

    @Override
    public Object getBizTokenPriceList(TradeBizTokenPriceListRequest tradeBizTokenPriceListRequest) {
        return executeSync(bybitApiService.getBizTokenPriceList(tradeBizTokenPriceListRequest));
    }

    @Override
    public Object getOrderList(TradeOrderListRequest tradeOrderListRequest) {
        return executeSync(bybitApiService.getOrderList(tradeOrderListRequest));
    }

    @Override
    public Object getPayTokenList(TradePayTokenListRequest tradePayTokenListRequest) {
        return executeSync(bybitApiService.getPayTokenList(tradePayTokenListRequest));
    }

    @Override
    public Object executePurchase(TradePurchaseRequest tradePurchaseRequest) {
        return executeSync(bybitApiService.executePurchase(tradePurchaseRequest));
    }

    @Override
    public Object getTradeQuote(TradeQuoteRequest tradeQuoteRequest) {
        return executeSync(bybitApiService.getTradeQuote(tradeQuoteRequest));
    }

    @Override
    public Object executeRedeem(TradeRedeemRequest tradeRedeemRequest) {
        return executeSync(bybitApiService.executeRedeem(tradeRedeemRequest));
    }
}
