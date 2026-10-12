package com.bybit.api.client.restApi;

import com.bybit.api.client.domain.earn.request.AddLiquidityRequest;
import com.bybit.api.client.domain.earn.request.AddMarginRequest;
import com.bybit.api.client.domain.earn.request.ClaimLiquidityInterestRequest;
import com.bybit.api.client.domain.earn.request.ModifyEarnPositionRequest;
import com.bybit.api.client.domain.earn.request.PlaceAdvanceEarnOrderRequest;
import com.bybit.api.client.domain.earn.request.PlaceEarnOrderRequest;
import com.bybit.api.client.domain.earn.request.PlaceFixedTermOrderRequest;
import com.bybit.api.client.domain.earn.request.PlaceRwaOrderRequest;
import com.bybit.api.client.domain.earn.request.PlaceTokenOrderRequest;
import com.bybit.api.client.domain.earn.request.PwmClaimRequest;
import com.bybit.api.client.domain.earn.request.PwmCreateCustomPlanRequest;
import com.bybit.api.client.domain.earn.request.PwmFundTransferRequest;
import com.bybit.api.client.domain.earn.request.PwmInstCreateFundRequest;
import com.bybit.api.client.domain.earn.request.PwmInstCreateInvestmentPlanRequest;
import com.bybit.api.client.domain.earn.request.PwmInstCreateSubAccountRequest;
import com.bybit.api.client.domain.earn.request.PwmInstManageInvestmentPlanRequest;
import com.bybit.api.client.domain.earn.request.PwmInstManageOrderRequest;
import com.bybit.api.client.domain.earn.request.PwmInstSettleProfitRequest;
import com.bybit.api.client.domain.earn.request.PwmInvestMoreRequest;
import com.bybit.api.client.domain.earn.request.PwmRedeemRequest;
import com.bybit.api.client.domain.earn.request.PwmSubscribeRequest;
import com.bybit.api.client.domain.earn.request.RedeemFixedTermRequest;
import com.bybit.api.client.domain.earn.request.ReinvestLiquidityRequest;
import com.bybit.api.client.domain.earn.request.RemoveLiquidityRequest;
import com.bybit.api.client.domain.earn.request.SetFixedTermAutoInvestRequest;
import com.bybit.api.client.domain.earn.request.EditAutoSavingsRequest;

public interface BybitApiAsyncEarnRestClient {
    void addLiquidity(AddLiquidityRequest addLiquidityRequest, BybitApiCallback<Object> callback);

    void addMargin(AddMarginRequest addMarginRequest, BybitApiCallback<Object> callback);

    void claimLiquidityInterest(ClaimLiquidityInterestRequest claimLiquidityInterestRequest, BybitApiCallback<Object> callback);

    void getAdvanceEarnOrder(String category, Long productId, String orderId, String orderLinkId, Long startTime, Long endTime, Integer limit, String cursor, BybitApiCallback<Object> callback);

    void getAdvanceEarnPosition(String category, Long productId, String coin, Integer limit, String cursor, BybitApiCallback<Object> callback);

    void getAdvanceEarnProduct(String category, String coin, String duration, BybitApiCallback<Object> callback);

    void getAdvanceEarnProductExtraInfo(String category, Long productId, BybitApiCallback<Object> callback);

    void getDoubleWinLeverage(Long productId, String initialPrice, String lowerPrice, String upperPrice, BybitApiCallback<Object> callback);

    void getEarnAprHistory(String category, String productId, Long startTime, Long endTime, BybitApiCallback<Object> callback);

    void getEarnHourlyYieldHistory(String category, String productId, Long startTime, Long endTime, Integer limit, String cursor, BybitApiCallback<Object> callback);

    void getEarnOrderHistory(String category, String orderId, String orderLinkId, String productId, Long startTime, Long endTime, Integer limit, String cursor, BybitApiCallback<Object> callback);

    void getEarnPosition(String category, String productId, String coin, BybitApiCallback<Object> callback);

    void getEarnProduct(String category, String coin, BybitApiCallback<Object> callback);

    void getEarnYieldHistory(String category, Long productId, Long startTime, Long endTime, Integer limit, String cursor, BybitApiCallback<Object> callback);

    void getFixedTermOrder(String orderType, String productId, String category, String orderId, Long startTime, Long endTime, Integer limit, String cursor, BybitApiCallback<Object> callback);

    void getFixedTermPosition(String productId, String category, String coin, BybitApiCallback<Object> callback);

    void getFixedTermProduct(String coin, BybitApiCallback<Object> callback);

    void getHoldToEarnProduct(BybitApiCallback<Object> callback);

    void getHoldToEarnYieldHistory(Long timeStart, Long timeEnd, Integer limit, String cursor, BybitApiCallback<Object> callback);

    void getLiquidityMiningLiquidationRecords(String baseCoin, String quoteCoin, Long startTime, Long endTime, Integer limit, String cursor, BybitApiCallback<Object> callback);

    void getLiquidityMiningOrders(String orderId, String orderLinkId, String productId, String orderType, String status, Long startTime, Long endTime, Integer limit, String cursor, BybitApiCallback<Object> callback);

    void getLiquidityMiningPositions(String productId, String baseCoin, BybitApiCallback<Object> callback);

    void getLiquidityMiningProducts(String baseCoin, String quoteCoin, BybitApiCallback<Object> callback);

    void getLiquidityMiningYieldRecords(String baseCoin, String quoteCoin, Long startTime, Long endTime, Integer limit, String cursor, BybitApiCallback<Object> callback);

    void getRwaNavChart(Long productId, Long startTime, Long endTime, BybitApiCallback<Object> callback);

    void getRwaOrderList(String orderId, String orderLinkId, String orderType, Long productId, Long startTime, Long endTime, Integer limit, String cursor, BybitApiCallback<Object> callback);

    void getRwaPositionList(BybitApiCallback<Object> callback);

    void getRwaProductList(String coin, BybitApiCallback<Object> callback);

    void getSmartLeverageRedeemEstAmountList(String category, String positionIds, BybitApiCallback<Object> callback);

    void getTokenDailyYield(String coin, Long startTime, Long endTime, String cursor, Integer limit, BybitApiCallback<Object> callback);

    void getTokenHistoricalApr(String coin, Long range, BybitApiCallback<Object> callback);

    void getTokenHourlyYield(String coin, Long startTime, Long endTime, String cursor, Integer limit, BybitApiCallback<Object> callback);

    void getTokenOrderList(String coin, String orderLinkId, String orderId, String orderType, Long startTime, Long endTime, String cursor, Integer limit, BybitApiCallback<Object> callback);

    void getTokenPosition(String coin, BybitApiCallback<Object> callback);

    void getTokenProduct(String coin, BybitApiCallback<Object> callback);

    void listEarnCoupons(String category, BybitApiCallback<Object> callback);

    void modifyEarnPosition(ModifyEarnPositionRequest modifyEarnPositionRequest, BybitApiCallback<Object> callback);

    void placeAdvanceEarnOrder(PlaceAdvanceEarnOrderRequest placeAdvanceEarnOrderRequest, BybitApiCallback<Object> callback);

    void placeEarnOrder(PlaceEarnOrderRequest placeEarnOrderRequest, BybitApiCallback<Object> callback);

    void placeFixedTermOrder(PlaceFixedTermOrderRequest placeFixedTermOrderRequest, BybitApiCallback<Object> callback);

    void placeRwaOrder(PlaceRwaOrderRequest placeRwaOrderRequest, BybitApiCallback<Object> callback);

    void placeTokenOrder(PlaceTokenOrderRequest placeTokenOrderRequest, BybitApiCallback<Object> callback);

    void pwmAssetTrend(String planId, Long startTime, Long endTime, BybitApiCallback<Object> callback);

    void pwmClaim(PwmClaimRequest pwmClaimRequest, BybitApiCallback<Object> callback);

    void pwmCreateCustomPlan(PwmCreateCustomPlanRequest pwmCreateCustomPlanRequest, BybitApiCallback<Object> callback);

    void pwmFundNav(String fundId, Long startTime, Long endTime, BybitApiCallback<Object> callback);

    void pwmFundTransfer(PwmFundTransferRequest pwmFundTransferRequest, BybitApiCallback<Object> callback);

    void pwmGetNewPlanDetail(String planId, BybitApiCallback<Object> callback);

    void pwmGetPlanDetail(String planId, BybitApiCallback<Object> callback);

    void pwmInstCreateFund(PwmInstCreateFundRequest pwmInstCreateFundRequest, BybitApiCallback<Object> callback);

    void pwmInstCreateInvestmentPlan(PwmInstCreateInvestmentPlanRequest pwmInstCreateInvestmentPlanRequest, BybitApiCallback<Object> callback);

    void pwmInstCreateSubAccount(PwmInstCreateSubAccountRequest pwmInstCreateSubAccountRequest, BybitApiCallback<Object> callback);

    void pwmInstGetInvestmentPlans(String planId, String status, String subscriptionUid, Integer limit, String cursor, BybitApiCallback<Object> callback);

    void pwmInstListFunds(String fundId, String coin, String status, Integer limit, String cursor, BybitApiCallback<Object> callback);

    void pwmInstListOrders(String fundId, String orderType, String status, Long startTime, Long endTime, Integer limit, String cursor, BybitApiCallback<Object> callback);

    void pwmInstManageInvestmentPlan(PwmInstManageInvestmentPlanRequest pwmInstManageInvestmentPlanRequest, BybitApiCallback<Object> callback);

    void pwmInstManageOrder(PwmInstManageOrderRequest pwmInstManageOrderRequest, BybitApiCallback<Object> callback);

    void pwmInstSettleProfit(PwmInstSettleProfitRequest pwmInstSettleProfitRequest, BybitApiCallback<Object> callback);

    void pwmInvestMore(PwmInvestMoreRequest pwmInvestMoreRequest, BybitApiCallback<Object> callback);

    void pwmListInvestmentPlans(String planId, String status, Integer limit, String cursor, BybitApiCallback<Object> callback);

    void pwmListOrder(String planId, String category, String type, String status, Long startTime, Long endTime, Integer limit, String cursor, String orderLinkId, BybitApiCallback<Object> callback);

    void pwmListProductCards(BybitApiCallback<Object> callback);

    void pwmQueryFundTransferResult(String transferId, Long fromUserId, BybitApiCallback<Object> callback);

    void pwmRedeem(PwmRedeemRequest pwmRedeemRequest, BybitApiCallback<Object> callback);

    void pwmSubscribe(PwmSubscribeRequest pwmSubscribeRequest, BybitApiCallback<Object> callback);

    void redeemFixedTerm(RedeemFixedTermRequest redeemFixedTermRequest, BybitApiCallback<Object> callback);

    void reinvestLiquidity(ReinvestLiquidityRequest reinvestLiquidityRequest, BybitApiCallback<Object> callback);

    void removeLiquidity(RemoveLiquidityRequest removeLiquidityRequest, BybitApiCallback<Object> callback);

    void setFixedTermAutoInvest(SetFixedTermAutoInvestRequest setFixedTermAutoInvestRequest, BybitApiCallback<Object> callback);

    void listEarnAutoSavings(java.util.List<Object> coins, BybitApiCallback<Object> callback);

    void editEarnAutoSavings(EditAutoSavingsRequest editAutoSavingsRequest, BybitApiCallback<Object> callback);
}
