package com.bybit.api.client.impl;

import com.bybit.api.client.restApi.BybitApiService;
import com.bybit.api.client.restApi.BybitApiEarnRestClient;
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
import static com.bybit.api.client.service.BybitApiServiceGenerator.executeSync;
import com.bybit.api.client.domain.earn.request.EditAutoSavingsRequest;

public class BybitApiEarnRestClientImpl implements BybitApiEarnRestClient {
    private final BybitApiService bybitApiService;

    public BybitApiEarnRestClientImpl(String apiKey, String secret, String baseUrl, boolean debugMode, long recvWindow, String logOption, String referer) {
        bybitApiService = createService(BybitApiService.class, apiKey, secret, baseUrl, debugMode, recvWindow, logOption, referer);
    }

    @Override
    public Object addLiquidity(AddLiquidityRequest addLiquidityRequest) {
        return executeSync(bybitApiService.addLiquidity(addLiquidityRequest));
    }

    @Override
    public Object addMargin(AddMarginRequest addMarginRequest) {
        return executeSync(bybitApiService.addMargin(addMarginRequest));
    }

    @Override
    public Object claimLiquidityInterest(ClaimLiquidityInterestRequest claimLiquidityInterestRequest) {
        return executeSync(bybitApiService.claimLiquidityInterest(claimLiquidityInterestRequest));
    }

    @Override
    public Object getAdvanceEarnOrder(String category, Long productId, String orderId, String orderLinkId, Long startTime, Long endTime, Integer limit, String cursor) {
        return executeSync(bybitApiService.getAdvanceEarnOrder(category, productId, orderId, orderLinkId, startTime, endTime, limit, cursor));
    }

    @Override
    public Object getAdvanceEarnPosition(String category, Long productId, String coin, Integer limit, String cursor) {
        return executeSync(bybitApiService.getAdvanceEarnPosition(category, productId, coin, limit, cursor));
    }

    @Override
    public Object getAdvanceEarnProduct(String category, String coin, String duration) {
        return executeSync(bybitApiService.getAdvanceEarnProduct(category, coin, duration));
    }

    @Override
    public Object getAdvanceEarnProductExtraInfo(String category, Long productId) {
        return executeSync(bybitApiService.getAdvanceEarnProductExtraInfo(category, productId));
    }

    @Override
    public Object getDoubleWinLeverage(Long productId, String initialPrice, String lowerPrice, String upperPrice) {
        return executeSync(bybitApiService.getDoubleWinLeverage(productId, initialPrice, lowerPrice, upperPrice));
    }

    @Override
    public Object getEarnAprHistory(String category, String productId, Long startTime, Long endTime) {
        return executeSync(bybitApiService.getEarnAprHistory(category, productId, startTime, endTime));
    }

    @Override
    public Object getEarnHourlyYieldHistory(String category, String productId, Long startTime, Long endTime, Integer limit, String cursor) {
        return executeSync(bybitApiService.getEarnHourlyYieldHistory(category, productId, startTime, endTime, limit, cursor));
    }

    @Override
    public Object getEarnOrderHistory(String category, String orderId, String orderLinkId, String productId, Long startTime, Long endTime, Integer limit, String cursor) {
        return executeSync(bybitApiService.getEarnOrderHistory(category, orderId, orderLinkId, productId, startTime, endTime, limit, cursor));
    }

    @Override
    public Object getEarnPosition(String category, String productId, String coin) {
        return executeSync(bybitApiService.getEarnPosition(category, productId, coin));
    }

    @Override
    public Object getEarnProduct(String category, String coin) {
        return executeSync(bybitApiService.getEarnProduct(category, coin));
    }

    @Override
    public Object getEarnYieldHistory(String category, Long productId, Long startTime, Long endTime, Integer limit, String cursor) {
        return executeSync(bybitApiService.getEarnYieldHistory(category, productId, startTime, endTime, limit, cursor));
    }

    @Override
    public Object getFixedTermOrder(String orderType, String productId, String category, String orderId, Long startTime, Long endTime, Integer limit, String cursor) {
        return executeSync(bybitApiService.getFixedTermOrder(orderType, productId, category, orderId, startTime, endTime, limit, cursor));
    }

    @Override
    public Object getFixedTermPosition(String productId, String category, String coin) {
        return executeSync(bybitApiService.getFixedTermPosition(productId, category, coin));
    }

    @Override
    public Object getFixedTermProduct(String coin) {
        return executeSync(bybitApiService.getFixedTermProduct(coin));
    }

    @Override
    public Object getHoldToEarnProduct() {
        return executeSync(bybitApiService.getHoldToEarnProduct());
    }

    @Override
    public Object getHoldToEarnYieldHistory(Long timeStart, Long timeEnd, Integer limit, String cursor) {
        return executeSync(bybitApiService.getHoldToEarnYieldHistory(timeStart, timeEnd, limit, cursor));
    }

    @Override
    public Object getLiquidityMiningLiquidationRecords(String baseCoin, String quoteCoin, Long startTime, Long endTime, Integer limit, String cursor) {
        return executeSync(bybitApiService.getLiquidityMiningLiquidationRecords(baseCoin, quoteCoin, startTime, endTime, limit, cursor));
    }

    @Override
    public Object getLiquidityMiningOrders(String orderId, String orderLinkId, String productId, String orderType, String status, Long startTime, Long endTime, Integer limit, String cursor) {
        return executeSync(bybitApiService.getLiquidityMiningOrders(orderId, orderLinkId, productId, orderType, status, startTime, endTime, limit, cursor));
    }

    @Override
    public Object getLiquidityMiningPositions(String productId, String baseCoin) {
        return executeSync(bybitApiService.getLiquidityMiningPositions(productId, baseCoin));
    }

    @Override
    public Object getLiquidityMiningProducts(String baseCoin, String quoteCoin) {
        return executeSync(bybitApiService.getLiquidityMiningProducts(baseCoin, quoteCoin));
    }

    @Override
    public Object getLiquidityMiningYieldRecords(String baseCoin, String quoteCoin, Long startTime, Long endTime, Integer limit, String cursor) {
        return executeSync(bybitApiService.getLiquidityMiningYieldRecords(baseCoin, quoteCoin, startTime, endTime, limit, cursor));
    }

    @Override
    public Object getRwaNavChart(Long productId, Long startTime, Long endTime) {
        return executeSync(bybitApiService.getRwaNavChart(productId, startTime, endTime));
    }

    @Override
    public Object getRwaOrderList(String orderId, String orderLinkId, String orderType, Long productId, Long startTime, Long endTime, Integer limit, String cursor) {
        return executeSync(bybitApiService.getRwaOrderList(orderId, orderLinkId, orderType, productId, startTime, endTime, limit, cursor));
    }

    @Override
    public Object getRwaPositionList() {
        return executeSync(bybitApiService.getRwaPositionList());
    }

    @Override
    public Object getRwaProductList(String coin) {
        return executeSync(bybitApiService.getRwaProductList(coin));
    }

    @Override
    public Object getSmartLeverageRedeemEstAmountList(String category, String positionIds) {
        return executeSync(bybitApiService.getSmartLeverageRedeemEstAmountList(category, positionIds));
    }

    @Override
    public Object getTokenDailyYield(String coin, Long startTime, Long endTime, String cursor, Integer limit) {
        return executeSync(bybitApiService.getTokenDailyYield(coin, startTime, endTime, cursor, limit));
    }

    @Override
    public Object getTokenHistoricalApr(String coin, Long range) {
        return executeSync(bybitApiService.getTokenHistoricalApr(coin, range));
    }

    @Override
    public Object getTokenHourlyYield(String coin, Long startTime, Long endTime, String cursor, Integer limit) {
        return executeSync(bybitApiService.getTokenHourlyYield(coin, startTime, endTime, cursor, limit));
    }

    @Override
    public Object getTokenOrderList(String coin, String orderLinkId, String orderId, String orderType, Long startTime, Long endTime, String cursor, Integer limit) {
        return executeSync(bybitApiService.getTokenOrderList(coin, orderLinkId, orderId, orderType, startTime, endTime, cursor, limit));
    }

    @Override
    public Object getTokenPosition(String coin) {
        return executeSync(bybitApiService.getTokenPosition(coin));
    }

    @Override
    public Object getTokenProduct(String coin) {
        return executeSync(bybitApiService.getTokenProduct(coin));
    }

    @Override
    public Object listEarnCoupons(String category) {
        return executeSync(bybitApiService.listEarnCoupons(category));
    }

    @Override
    public Object modifyEarnPosition(ModifyEarnPositionRequest modifyEarnPositionRequest) {
        return executeSync(bybitApiService.modifyEarnPosition(modifyEarnPositionRequest));
    }

    @Override
    public Object placeAdvanceEarnOrder(PlaceAdvanceEarnOrderRequest placeAdvanceEarnOrderRequest) {
        return executeSync(bybitApiService.placeAdvanceEarnOrder(placeAdvanceEarnOrderRequest));
    }

    @Override
    public Object placeEarnOrder(PlaceEarnOrderRequest placeEarnOrderRequest) {
        return executeSync(bybitApiService.placeEarnOrder(placeEarnOrderRequest));
    }

    @Override
    public Object placeFixedTermOrder(PlaceFixedTermOrderRequest placeFixedTermOrderRequest) {
        return executeSync(bybitApiService.placeFixedTermOrder(placeFixedTermOrderRequest));
    }

    @Override
    public Object placeRwaOrder(PlaceRwaOrderRequest placeRwaOrderRequest) {
        return executeSync(bybitApiService.placeRwaOrder(placeRwaOrderRequest));
    }

    @Override
    public Object placeTokenOrder(PlaceTokenOrderRequest placeTokenOrderRequest) {
        return executeSync(bybitApiService.placeTokenOrder(placeTokenOrderRequest));
    }

    @Override
    public Object pwmAssetTrend(String planId, Long startTime, Long endTime) {
        return executeSync(bybitApiService.pwmAssetTrend(planId, startTime, endTime));
    }

    @Override
    public Object pwmClaim(PwmClaimRequest pwmClaimRequest) {
        return executeSync(bybitApiService.pwmClaim(pwmClaimRequest));
    }

    @Override
    public Object pwmCreateCustomPlan(PwmCreateCustomPlanRequest pwmCreateCustomPlanRequest) {
        return executeSync(bybitApiService.pwmCreateCustomPlan(pwmCreateCustomPlanRequest));
    }

    @Override
    public Object pwmFundNav(String fundId, Long startTime, Long endTime) {
        return executeSync(bybitApiService.pwmFundNav(fundId, startTime, endTime));
    }

    @Override
    public Object pwmFundTransfer(PwmFundTransferRequest pwmFundTransferRequest) {
        return executeSync(bybitApiService.pwmFundTransfer(pwmFundTransferRequest));
    }

    @Override
    public Object pwmGetNewPlanDetail(String planId) {
        return executeSync(bybitApiService.pwmGetNewPlanDetail(planId));
    }

    @Override
    public Object pwmGetPlanDetail(String planId) {
        return executeSync(bybitApiService.pwmGetPlanDetail(planId));
    }

    @Override
    public Object pwmInstCreateFund(PwmInstCreateFundRequest pwmInstCreateFundRequest) {
        return executeSync(bybitApiService.pwmInstCreateFund(pwmInstCreateFundRequest));
    }

    @Override
    public Object pwmInstCreateInvestmentPlan(PwmInstCreateInvestmentPlanRequest pwmInstCreateInvestmentPlanRequest) {
        return executeSync(bybitApiService.pwmInstCreateInvestmentPlan(pwmInstCreateInvestmentPlanRequest));
    }

    @Override
    public Object pwmInstCreateSubAccount(PwmInstCreateSubAccountRequest pwmInstCreateSubAccountRequest) {
        return executeSync(bybitApiService.pwmInstCreateSubAccount(pwmInstCreateSubAccountRequest));
    }

    @Override
    public Object pwmInstGetInvestmentPlans(String planId, String status, String subscriptionUid, Integer limit, String cursor) {
        return executeSync(bybitApiService.pwmInstGetInvestmentPlans(planId, status, subscriptionUid, limit, cursor));
    }

    @Override
    public Object pwmInstListFunds(String fundId, String coin, String status, Integer limit, String cursor) {
        return executeSync(bybitApiService.pwmInstListFunds(fundId, coin, status, limit, cursor));
    }

    @Override
    public Object pwmInstListOrders(String fundId, String orderType, String status, Long startTime, Long endTime, Integer limit, String cursor) {
        return executeSync(bybitApiService.pwmInstListOrders(fundId, orderType, status, startTime, endTime, limit, cursor));
    }

    @Override
    public Object pwmInstManageInvestmentPlan(PwmInstManageInvestmentPlanRequest pwmInstManageInvestmentPlanRequest) {
        return executeSync(bybitApiService.pwmInstManageInvestmentPlan(pwmInstManageInvestmentPlanRequest));
    }

    @Override
    public Object pwmInstManageOrder(PwmInstManageOrderRequest pwmInstManageOrderRequest) {
        return executeSync(bybitApiService.pwmInstManageOrder(pwmInstManageOrderRequest));
    }

    @Override
    public Object pwmInstSettleProfit(PwmInstSettleProfitRequest pwmInstSettleProfitRequest) {
        return executeSync(bybitApiService.pwmInstSettleProfit(pwmInstSettleProfitRequest));
    }

    @Override
    public Object pwmInvestMore(PwmInvestMoreRequest pwmInvestMoreRequest) {
        return executeSync(bybitApiService.pwmInvestMore(pwmInvestMoreRequest));
    }

    @Override
    public Object pwmListInvestmentPlans(String planId, String status, Integer limit, String cursor) {
        return executeSync(bybitApiService.pwmListInvestmentPlans(planId, status, limit, cursor));
    }

    @Override
    public Object pwmListOrder(String planId, String category, String type, String status, Long startTime, Long endTime, Integer limit, String cursor, String orderLinkId) {
        return executeSync(bybitApiService.pwmListOrder(planId, category, type, status, startTime, endTime, limit, cursor, orderLinkId));
    }

    @Override
    public Object pwmListProductCards() {
        return executeSync(bybitApiService.pwmListProductCards());
    }

    @Override
    public Object pwmQueryFundTransferResult(String transferId, Long fromUserId) {
        return executeSync(bybitApiService.pwmQueryFundTransferResult(transferId, fromUserId));
    }

    @Override
    public Object pwmRedeem(PwmRedeemRequest pwmRedeemRequest) {
        return executeSync(bybitApiService.pwmRedeem(pwmRedeemRequest));
    }

    @Override
    public Object pwmSubscribe(PwmSubscribeRequest pwmSubscribeRequest) {
        return executeSync(bybitApiService.pwmSubscribe(pwmSubscribeRequest));
    }

    @Override
    public Object redeemFixedTerm(RedeemFixedTermRequest redeemFixedTermRequest) {
        return executeSync(bybitApiService.redeemFixedTerm(redeemFixedTermRequest));
    }

    @Override
    public Object reinvestLiquidity(ReinvestLiquidityRequest reinvestLiquidityRequest) {
        return executeSync(bybitApiService.reinvestLiquidity(reinvestLiquidityRequest));
    }

    @Override
    public Object removeLiquidity(RemoveLiquidityRequest removeLiquidityRequest) {
        return executeSync(bybitApiService.removeLiquidity(removeLiquidityRequest));
    }

    @Override
    public Object setFixedTermAutoInvest(SetFixedTermAutoInvestRequest setFixedTermAutoInvestRequest) {
        return executeSync(bybitApiService.setFixedTermAutoInvest(setFixedTermAutoInvestRequest));
    }

    @Override
    public Object listEarnAutoSavings(java.util.List<String> coins) {
        return executeSync(bybitApiService.listEarnAutoSavings(coins));
    }

    @Override
    public Object editEarnAutoSavings(EditAutoSavingsRequest editAutoSavingsRequest) {
        return executeSync(bybitApiService.editEarnAutoSavings(editAutoSavingsRequest));
    }
}
