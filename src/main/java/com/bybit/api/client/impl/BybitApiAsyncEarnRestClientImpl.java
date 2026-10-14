package com.bybit.api.client.impl;

import com.bybit.api.client.restApi.BybitApiCallback;
import com.bybit.api.client.restApi.BybitApiService;
import com.bybit.api.client.restApi.BybitApiAsyncEarnRestClient;
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

import static com.bybit.api.client.service.BybitApiServiceGenerator.createService;
import com.bybit.api.client.domain.earn.request.EditAutoSavingsRequest;

public class BybitApiAsyncEarnRestClientImpl implements BybitApiAsyncEarnRestClient {
    private final BybitApiService bybitApiService;

    public BybitApiAsyncEarnRestClientImpl(String apiKey, String secret, String baseUrl, boolean debugMode, long recvWindow, String logOption, String referer) {
        bybitApiService = createService(BybitApiService.class, apiKey, secret, baseUrl, debugMode, recvWindow, logOption, referer);
    }

    @Override
    public void addLiquidity(AddLiquidityRequest addLiquidityRequest, BybitApiCallback<Object> callback) {
        bybitApiService.addLiquidity(addLiquidityRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void addMargin(AddMarginRequest addMarginRequest, BybitApiCallback<Object> callback) {
        bybitApiService.addMargin(addMarginRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void claimLiquidityInterest(ClaimLiquidityInterestRequest claimLiquidityInterestRequest, BybitApiCallback<Object> callback) {
        bybitApiService.claimLiquidityInterest(claimLiquidityInterestRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getAdvanceEarnOrder(String category, Long productId, String orderId, String orderLinkId, Long startTime, Long endTime, Integer limit, String cursor, BybitApiCallback<Object> callback) {
        bybitApiService.getAdvanceEarnOrder(category, productId, orderId, orderLinkId, startTime, endTime, limit, cursor).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getAdvanceEarnPosition(String category, Long productId, String coin, Integer limit, String cursor, BybitApiCallback<Object> callback) {
        bybitApiService.getAdvanceEarnPosition(category, productId, coin, limit, cursor).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getAdvanceEarnProduct(String category, String coin, String duration, BybitApiCallback<Object> callback) {
        bybitApiService.getAdvanceEarnProduct(category, coin, duration).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getAdvanceEarnProductExtraInfo(String category, Long productId, BybitApiCallback<Object> callback) {
        bybitApiService.getAdvanceEarnProductExtraInfo(category, productId).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getDoubleWinLeverage(Long productId, String initialPrice, String lowerPrice, String upperPrice, BybitApiCallback<Object> callback) {
        bybitApiService.getDoubleWinLeverage(productId, initialPrice, lowerPrice, upperPrice).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getEarnAprHistory(String category, String productId, Long startTime, Long endTime, BybitApiCallback<Object> callback) {
        bybitApiService.getEarnAprHistory(category, productId, startTime, endTime).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getEarnHourlyYieldHistory(String category, String productId, Long startTime, Long endTime, Integer limit, String cursor, BybitApiCallback<Object> callback) {
        bybitApiService.getEarnHourlyYieldHistory(category, productId, startTime, endTime, limit, cursor).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getEarnOrderHistory(String category, String orderId, String orderLinkId, String productId, Long startTime, Long endTime, Integer limit, String cursor, BybitApiCallback<Object> callback) {
        bybitApiService.getEarnOrderHistory(category, orderId, orderLinkId, productId, startTime, endTime, limit, cursor).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getEarnPosition(String category, String productId, String coin, BybitApiCallback<Object> callback) {
        bybitApiService.getEarnPosition(category, productId, coin).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getEarnProduct(String category, String coin, BybitApiCallback<Object> callback) {
        bybitApiService.getEarnProduct(category, coin).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getEarnYieldHistory(String category, Long productId, Long startTime, Long endTime, Integer limit, String cursor, BybitApiCallback<Object> callback) {
        bybitApiService.getEarnYieldHistory(category, productId, startTime, endTime, limit, cursor).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getFixedTermOrder(String orderType, String productId, String category, String orderId, Long startTime, Long endTime, Integer limit, String cursor, BybitApiCallback<Object> callback) {
        bybitApiService.getFixedTermOrder(orderType, productId, category, orderId, startTime, endTime, limit, cursor).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getFixedTermPosition(String productId, String category, String coin, BybitApiCallback<Object> callback) {
        bybitApiService.getFixedTermPosition(productId, category, coin).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getFixedTermProduct(String coin, BybitApiCallback<Object> callback) {
        bybitApiService.getFixedTermProduct(coin).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getHoldToEarnProduct(BybitApiCallback<Object> callback) {
        bybitApiService.getHoldToEarnProduct().enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getHoldToEarnYieldHistory(Long timeStart, Long timeEnd, Integer limit, String cursor, BybitApiCallback<Object> callback) {
        bybitApiService.getHoldToEarnYieldHistory(timeStart, timeEnd, limit, cursor).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getLiquidityMiningLiquidationRecords(String baseCoin, String quoteCoin, Long startTime, Long endTime, Integer limit, String cursor, BybitApiCallback<Object> callback) {
        bybitApiService.getLiquidityMiningLiquidationRecords(baseCoin, quoteCoin, startTime, endTime, limit, cursor).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getLiquidityMiningOrders(String orderId, String orderLinkId, String productId, String orderType, String status, Long startTime, Long endTime, Integer limit, String cursor, BybitApiCallback<Object> callback) {
        bybitApiService.getLiquidityMiningOrders(orderId, orderLinkId, productId, orderType, status, startTime, endTime, limit, cursor).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getLiquidityMiningPositions(String productId, String baseCoin, BybitApiCallback<Object> callback) {
        bybitApiService.getLiquidityMiningPositions(productId, baseCoin).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getLiquidityMiningProducts(String baseCoin, String quoteCoin, BybitApiCallback<Object> callback) {
        bybitApiService.getLiquidityMiningProducts(baseCoin, quoteCoin).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getLiquidityMiningYieldRecords(String baseCoin, String quoteCoin, Long startTime, Long endTime, Integer limit, String cursor, BybitApiCallback<Object> callback) {
        bybitApiService.getLiquidityMiningYieldRecords(baseCoin, quoteCoin, startTime, endTime, limit, cursor).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getRwaNavChart(Long productId, Long startTime, Long endTime, BybitApiCallback<Object> callback) {
        bybitApiService.getRwaNavChart(productId, startTime, endTime).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getRwaOrderList(String orderId, String orderLinkId, String orderType, Long productId, Long startTime, Long endTime, Integer limit, String cursor, BybitApiCallback<Object> callback) {
        bybitApiService.getRwaOrderList(orderId, orderLinkId, orderType, productId, startTime, endTime, limit, cursor).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getRwaPositionList(BybitApiCallback<Object> callback) {
        bybitApiService.getRwaPositionList().enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getRwaProductList(String coin, BybitApiCallback<Object> callback) {
        bybitApiService.getRwaProductList(coin).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getSmartLeverageRedeemEstAmountList(String category, String positionIds, BybitApiCallback<Object> callback) {
        bybitApiService.getSmartLeverageRedeemEstAmountList(category, positionIds).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getTokenDailyYield(String coin, Long startTime, Long endTime, String cursor, Integer limit, BybitApiCallback<Object> callback) {
        bybitApiService.getTokenDailyYield(coin, startTime, endTime, cursor, limit).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getTokenHistoricalApr(String coin, Long range, BybitApiCallback<Object> callback) {
        bybitApiService.getTokenHistoricalApr(coin, range).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getTokenHourlyYield(String coin, Long startTime, Long endTime, String cursor, Integer limit, BybitApiCallback<Object> callback) {
        bybitApiService.getTokenHourlyYield(coin, startTime, endTime, cursor, limit).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getTokenOrderList(String coin, String orderLinkId, String orderId, String orderType, Long startTime, Long endTime, String cursor, Integer limit, BybitApiCallback<Object> callback) {
        bybitApiService.getTokenOrderList(coin, orderLinkId, orderId, orderType, startTime, endTime, cursor, limit).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getTokenPosition(String coin, BybitApiCallback<Object> callback) {
        bybitApiService.getTokenPosition(coin).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getTokenProduct(String coin, BybitApiCallback<Object> callback) {
        bybitApiService.getTokenProduct(coin).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void listEarnCoupons(String category, BybitApiCallback<Object> callback) {
        bybitApiService.listEarnCoupons(category).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void modifyEarnPosition(ModifyEarnPositionRequest modifyEarnPositionRequest, BybitApiCallback<Object> callback) {
        bybitApiService.modifyEarnPosition(modifyEarnPositionRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void placeAdvanceEarnOrder(PlaceAdvanceEarnOrderRequest placeAdvanceEarnOrderRequest, BybitApiCallback<Object> callback) {
        bybitApiService.placeAdvanceEarnOrder(placeAdvanceEarnOrderRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void placeEarnOrder(PlaceEarnOrderRequest placeEarnOrderRequest, BybitApiCallback<Object> callback) {
        bybitApiService.placeEarnOrder(placeEarnOrderRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void placeFixedTermOrder(PlaceFixedTermOrderRequest placeFixedTermOrderRequest, BybitApiCallback<Object> callback) {
        bybitApiService.placeFixedTermOrder(placeFixedTermOrderRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void placeRwaOrder(PlaceRwaOrderRequest placeRwaOrderRequest, BybitApiCallback<Object> callback) {
        bybitApiService.placeRwaOrder(placeRwaOrderRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void placeTokenOrder(PlaceTokenOrderRequest placeTokenOrderRequest, BybitApiCallback<Object> callback) {
        bybitApiService.placeTokenOrder(placeTokenOrderRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void pwmAssetTrend(String planId, Long startTime, Long endTime, BybitApiCallback<Object> callback) {
        bybitApiService.pwmAssetTrend(planId, startTime, endTime).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void pwmClaim(PwmClaimRequest pwmClaimRequest, BybitApiCallback<Object> callback) {
        bybitApiService.pwmClaim(pwmClaimRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void pwmCreateCustomPlan(PwmCreateCustomPlanRequest pwmCreateCustomPlanRequest, BybitApiCallback<Object> callback) {
        bybitApiService.pwmCreateCustomPlan(pwmCreateCustomPlanRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void pwmFundNav(String fundId, Long startTime, Long endTime, BybitApiCallback<Object> callback) {
        bybitApiService.pwmFundNav(fundId, startTime, endTime).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void pwmFundTransfer(PwmFundTransferRequest pwmFundTransferRequest, BybitApiCallback<Object> callback) {
        bybitApiService.pwmFundTransfer(pwmFundTransferRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void pwmGetNewPlanDetail(String planId, BybitApiCallback<Object> callback) {
        bybitApiService.pwmGetNewPlanDetail(planId).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void pwmGetPlanDetail(String planId, BybitApiCallback<Object> callback) {
        bybitApiService.pwmGetPlanDetail(planId).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void pwmInstCreateFund(PwmInstCreateFundRequest pwmInstCreateFundRequest, BybitApiCallback<Object> callback) {
        bybitApiService.pwmInstCreateFund(pwmInstCreateFundRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void pwmInstCreateInvestmentPlan(PwmInstCreateInvestmentPlanRequest pwmInstCreateInvestmentPlanRequest, BybitApiCallback<Object> callback) {
        bybitApiService.pwmInstCreateInvestmentPlan(pwmInstCreateInvestmentPlanRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void pwmInstCreateSubAccount(PwmInstCreateSubAccountRequest pwmInstCreateSubAccountRequest, BybitApiCallback<Object> callback) {
        bybitApiService.pwmInstCreateSubAccount(pwmInstCreateSubAccountRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void pwmInstGetInvestmentPlans(String planId, String status, String subscriptionUid, Integer limit, String cursor, BybitApiCallback<Object> callback) {
        bybitApiService.pwmInstGetInvestmentPlans(planId, status, subscriptionUid, limit, cursor).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void pwmInstListFunds(String fundId, String coin, String status, Integer limit, String cursor, BybitApiCallback<Object> callback) {
        bybitApiService.pwmInstListFunds(fundId, coin, status, limit, cursor).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void pwmInstListOrders(String fundId, String orderType, String status, Long startTime, Long endTime, Integer limit, String cursor, BybitApiCallback<Object> callback) {
        bybitApiService.pwmInstListOrders(fundId, orderType, status, startTime, endTime, limit, cursor).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void pwmInstManageInvestmentPlan(PwmInstManageInvestmentPlanRequest pwmInstManageInvestmentPlanRequest, BybitApiCallback<Object> callback) {
        bybitApiService.pwmInstManageInvestmentPlan(pwmInstManageInvestmentPlanRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void pwmInstManageOrder(PwmInstManageOrderRequest pwmInstManageOrderRequest, BybitApiCallback<Object> callback) {
        bybitApiService.pwmInstManageOrder(pwmInstManageOrderRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void pwmInstSettleProfit(PwmInstSettleProfitRequest pwmInstSettleProfitRequest, BybitApiCallback<Object> callback) {
        bybitApiService.pwmInstSettleProfit(pwmInstSettleProfitRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void pwmInvestMore(PwmInvestMoreRequest pwmInvestMoreRequest, BybitApiCallback<Object> callback) {
        bybitApiService.pwmInvestMore(pwmInvestMoreRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void pwmListInvestmentPlans(String planId, String status, Integer limit, String cursor, BybitApiCallback<Object> callback) {
        bybitApiService.pwmListInvestmentPlans(planId, status, limit, cursor).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void pwmListOrder(String planId, String category, String type, String status, Long startTime, Long endTime, Integer limit, String cursor, String orderLinkId, BybitApiCallback<Object> callback) {
        bybitApiService.pwmListOrder(planId, category, type, status, startTime, endTime, limit, cursor, orderLinkId).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void pwmListProductCards(BybitApiCallback<Object> callback) {
        bybitApiService.pwmListProductCards().enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void pwmQueryFundTransferResult(String transferId, Long fromUserId, BybitApiCallback<Object> callback) {
        bybitApiService.pwmQueryFundTransferResult(transferId, fromUserId).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void pwmRedeem(PwmRedeemRequest pwmRedeemRequest, BybitApiCallback<Object> callback) {
        bybitApiService.pwmRedeem(pwmRedeemRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void pwmSubscribe(PwmSubscribeRequest pwmSubscribeRequest, BybitApiCallback<Object> callback) {
        bybitApiService.pwmSubscribe(pwmSubscribeRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void redeemFixedTerm(RedeemFixedTermRequest redeemFixedTermRequest, BybitApiCallback<Object> callback) {
        bybitApiService.redeemFixedTerm(redeemFixedTermRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void reinvestLiquidity(ReinvestLiquidityRequest reinvestLiquidityRequest, BybitApiCallback<Object> callback) {
        bybitApiService.reinvestLiquidity(reinvestLiquidityRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void removeLiquidity(RemoveLiquidityRequest removeLiquidityRequest, BybitApiCallback<Object> callback) {
        bybitApiService.removeLiquidity(removeLiquidityRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void setFixedTermAutoInvest(SetFixedTermAutoInvestRequest setFixedTermAutoInvestRequest, BybitApiCallback<Object> callback) {
        bybitApiService.setFixedTermAutoInvest(setFixedTermAutoInvestRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void listEarnAutoSavings(java.util.List<String> coins, BybitApiCallback<Object> callback) {
        bybitApiService.listEarnAutoSavings(coins).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void editEarnAutoSavings(EditAutoSavingsRequest editAutoSavingsRequest, BybitApiCallback<Object> callback) {
        bybitApiService.editEarnAutoSavings(editAutoSavingsRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }
}
