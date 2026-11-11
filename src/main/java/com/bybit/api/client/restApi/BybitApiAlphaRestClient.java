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

public interface BybitApiAlphaRestClient {
    Object getLPOrderList(LPOrderListRequest lPOrderListRequest);

    Object getLPPayTokenList(LPPayTokenListRequest lPPayTokenListRequest);

    Object getLPPayTokenPrice(LPPayTokenPriceRequest lPPayTokenPriceRequest);

    Object getLPPoolInfo(LPPoolInfoRequest lPPoolInfoRequest);

    Object getLPPoolList(LPPoolListRequest lPPoolListRequest);

    Object getLPPositionList(LPPositionListRequest lPPositionListRequest);

    Object executeLPRedeem(LPRedeemRequest lPRedeemRequest);

    Object executeLPStake(LPStakeRequest lPStakeRequest);

    Object executePredictionBuy(PredictionBuyRequest predictionBuyRequest);

    Object getPredictionEngineStatus();

    Object getPredictionEventDetail(PredictionEventDetailRequest predictionEventDetailRequest);

    Object getPredictionOrderBook(PredictionOrderBookRequest predictionOrderBookRequest);

    Object getPredictionOrderEstimate(PredictionOrderEstimateRequest predictionOrderEstimateRequest);

    Object getPredictionOrderList(PredictionOrderListRequest predictionOrderListRequest);

    Object getPredictionPayTokenList();

    Object getPredictionPortfolioSummary(GetPredictionPortfolioSummaryRequest getPredictionPortfolioSummaryRequest);

    Object getPredictionPositionHistory(PredictionPositionHistoryRequest predictionPositionHistoryRequest);

    Object getPredictionPositionList(PredictionPositionListRequest predictionPositionListRequest);

    Object getPredictionPriceHistory(PredictionPriceHistoryRequest predictionPriceHistoryRequest);

    Object executePredictionSell(PredictionSellRequest predictionSellRequest);

    Object getPredictionSideMarketList(PredictionSideMarketListRequest predictionSideMarketListRequest);

    Object getPredictionGroupStageDetail(PredictionGroupStageDetailRequest predictionGroupStageDetailRequest);

    Object getPredictionMatchList(PredictionMatchListRequest predictionMatchListRequest);

    Object getPredictionTimelineStages(Long eventType);

    Object getPredictionTokenPrice(PredictionTokenPriceRequest predictionTokenPriceRequest);

    Object getAssetDetail(TradeAssetDetailRequest tradeAssetDetailRequest);

    Object getAssetList(GetAssetListRequest getAssetListRequest);

    Object getBizTokenDetails(TradeBizTokenDetailsRequest tradeBizTokenDetailsRequest);

    Object getBizTokenList(TradeBizTokenListRequest tradeBizTokenListRequest);

    Object getBizTokenPriceList(TradeBizTokenPriceListRequest tradeBizTokenPriceListRequest);

    Object getOrderList(TradeOrderListRequest tradeOrderListRequest);

    Object getPayTokenList(TradePayTokenListRequest tradePayTokenListRequest);

    Object executePurchase(TradePurchaseRequest tradePurchaseRequest);

    Object getTradeQuote(TradeQuoteRequest tradeQuoteRequest);

    Object executeRedeem(TradeRedeemRequest tradeRedeemRequest);
}
