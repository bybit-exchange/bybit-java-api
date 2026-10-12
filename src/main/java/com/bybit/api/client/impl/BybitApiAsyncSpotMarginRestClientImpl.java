package com.bybit.api.client.impl;

import com.bybit.api.client.domain.spot.SpotMarginDataRequest;
import com.bybit.api.client.restApi.BybitApiAsyncSpotMarginRestClient;
import com.bybit.api.client.restApi.BybitApiCallback;
import com.bybit.api.client.restApi.BybitApiService;
import com.bybit.api.client.service.BybitJsonConverter;

import java.util.HashMap;
import java.util.Map;

import static com.bybit.api.client.service.BybitApiServiceGenerator.createService;
import com.bybit.api.client.domain.spot.marginTrade.FixedBorrowRequest;
import com.bybit.api.client.domain.spot.marginTrade.RenewFixedBorrowRequest;

/**
 * Implementation of Bybit's REST API using Retrofit with synchronous/blocking
 * method calls.
 */
public class BybitApiAsyncSpotMarginRestClientImpl implements BybitApiAsyncSpotMarginRestClient {
    private final BybitApiService bybitApiService;
    private final BybitJsonConverter converter = new BybitJsonConverter();

    public BybitApiAsyncSpotMarginRestClientImpl(String apiKey, String secret, String baseUrl, boolean debugMode, long recvWindow, String logOption) {
        bybitApiService = createService(BybitApiService.class, apiKey, secret, baseUrl, debugMode, recvWindow, logOption, "");
    }

    // Spots
    // Spot Leverage endpoints
    @Override
    public void getSpotLeverageTokenInfo(SpotMarginDataRequest spotMarginDataRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getSpotLeverageTokenInfo(spotMarginDataRequest.getLtCoin()).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getSpotLeverageTokenMarket(SpotMarginDataRequest spotMarginDataRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getSpotLeverageTokenMarket(spotMarginDataRequest.getLtCoin()).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void purchaseSpotLeverageToken(SpotMarginDataRequest spotMarginDataRequest, BybitApiCallback<Object> callback) {
        var spotLeverageTokenRequest = converter.mapToSpotLeverageTokenRequest(spotMarginDataRequest);
        bybitApiService.purchaseSpotLeverageToken(spotLeverageTokenRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void redeemSpotLeverageToken(SpotMarginDataRequest spotMarginDataRequest, BybitApiCallback<Object> callback) {
        var spotLeverageTokenRequest = converter.mapToSpotLeverageTokenRequest(spotMarginDataRequest);
        bybitApiService.redeemSpotLeverageToken(spotLeverageTokenRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getSpotLeverageRecords(SpotMarginDataRequest spotLeverageOrdersRecordRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getSpotLeverageRecords(
                spotLeverageOrdersRecordRequest.getLtCoin(),
                spotLeverageOrdersRecordRequest.getOrderId(),
                spotLeverageOrdersRecordRequest.getStartTime(),
                spotLeverageOrdersRecordRequest.getEndTime(),
                spotLeverageOrdersRecordRequest.getLimit(),
                spotLeverageOrdersRecordRequest.getLtOrderType(),
                spotLeverageOrdersRecordRequest.getSerialNo())
                .enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    // Spot Margin UTA
    @Override
    public void getUtaVipSpotMarginTradeData(SpotMarginDataRequest utaMarginDataRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getUtaVipSpotMarginTradeData(
                utaMarginDataRequest.getVipLevel() == null ? null : utaMarginDataRequest.getVipLevel().getLevel(),
                utaMarginDataRequest.getCurrency())
                .enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void setUTASpotMarginTrade(String mode, BybitApiCallback<Object> callback) {
        Map<String, String> map = new HashMap<>();
        map.put("spotMarginMode", mode);
        bybitApiService.setUTASpotMarginTrade(map).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void setUTASpotMarginTradeLeverage(String leverage, BybitApiCallback<Object> callback) {
        Map<String, String> map = new HashMap<>();
        map.put("leverage", leverage);
        bybitApiService.setUTASpotMarginTradeLeverage(map).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void setUTASpotMarginTradeAutoRepayMode(Map<String, Object> utaMarginDataRequest, BybitApiCallback<Object> callback) {
        bybitApiService.setUTASpotMarginTradeAutoRepayMode(utaMarginDataRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getUTASpotMarginTradeAutoRepayMode(Map<String, Object> utaMarginDataRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getUTASpotMarginTradeAutoRepayMode(utaMarginDataRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getUTASpotMarginTradeLeverageState(BybitApiCallback<Object> callback) {
        bybitApiService.getUTASpotMarginTradeLeverageState().enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    // Spot Margin Normal
    @Override
    @Deprecated
    public void getNormalVipSpotMarginTradeData(SpotMarginDataRequest normalMarginDataRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getNormalVipSpotMarginTradeData(
                normalMarginDataRequest.getVipLevel() == null ? null : normalMarginDataRequest.getVipLevel().getLevel(),
                normalMarginDataRequest.getCurrency())
                .enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Deprecated
    @Override
    public void getNormalSpotMarginTradeCoinInfo(SpotMarginDataRequest normalMarginDataRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getNormalSpotMarginTradeCoinInfo(normalMarginDataRequest.getCoin()).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    @Deprecated
    public void getNormalSpotMarginTradeBorrowCoinInfo(SpotMarginDataRequest normalMarginDataRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getNormalSpotMarginTradeBorrowCoinInfo(normalMarginDataRequest.getCoin()).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    @Deprecated
    public void getNormalSpotMarginTradeInterestQuota(SpotMarginDataRequest spotMarginDataRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getNormalSpotMarginTradeInterestQuota(spotMarginDataRequest.getCoin()).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    @Deprecated
    public void getNormalSpotMarginTradeAccountInfo(BybitApiCallback<Object> callback) {
        bybitApiService.getNormalSpotMarginTradeAccountInfo().enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    @Deprecated
    public void setNormalSpotToggleMarginTrade(SpotMarginDataRequest spotMarginDataRequest, BybitApiCallback<Object> callback) {
        int switchStatus = spotMarginDataRequest.getSwitchStatus() == null ? 0 : spotMarginDataRequest.getSwitchStatus().getValue();
        bybitApiService.setNormalSpotToggleMarginTrade(switchStatus).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    @Deprecated
    public void loanNormalSpotMarginTrade(SpotMarginDataRequest spotMarginDataRequest, BybitApiCallback<Object> callback) {
        var spotMarginTradeBorrowRequest = converter.mapToSpotMarginBorrowRequest(spotMarginDataRequest);
        bybitApiService.loanNormalSpotMarginTrade(spotMarginTradeBorrowRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    @Deprecated
    public void repayNormalSpotMarginTrade(SpotMarginDataRequest spotMarginDataRequest, BybitApiCallback<Object> callback) {
        var spotMarginTradeRePayRequest = converter.mapToSpotMarginRepayRequest(spotMarginDataRequest);
        bybitApiService.repayNormalSpotMarginTrade(spotMarginTradeRePayRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    @Deprecated
    public void getNormalSpotMarginTradeBorrowOrders(SpotMarginDataRequest spotMarginTradeBorrowOrdersRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getNormalMarginTradeBorrowOrders(
                spotMarginTradeBorrowOrdersRequest.getStartTime(),
                spotMarginTradeBorrowOrdersRequest.getEndTime(),
                spotMarginTradeBorrowOrdersRequest.getCoin(),
                spotMarginTradeBorrowOrdersRequest.getBorrowStatus() == null ? 0 : spotMarginTradeBorrowOrdersRequest.getBorrowStatus().getValue(),
                spotMarginTradeBorrowOrdersRequest.getLimit()
        ).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    @Deprecated
    public void getNormalSpotMarginTradeRepayOrders(SpotMarginDataRequest spotMarginTradeRepayOrdersRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getNormalMarginTradeRepayOrders(
                spotMarginTradeRepayOrdersRequest.getStartTime(),
                spotMarginTradeRepayOrdersRequest.getEndTime(),
                spotMarginTradeRepayOrdersRequest.getCoin(),
                spotMarginTradeRepayOrdersRequest.getLimit()
        ).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getSpotMarginInterestRateHistory(SpotMarginDataRequest spotMarginDataRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getSpotMarginInterestRateHistory(
                spotMarginDataRequest.getCurrency(),
                spotMarginDataRequest.getVipLevel() != null ? spotMarginDataRequest.getVipLevel().getLevel() : null,
                spotMarginDataRequest.getStartTime(),
                spotMarginDataRequest.getEndTime()
        ).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getPositionTiers(String currency, BybitApiCallback<Object> callback) {
        bybitApiService.getPositionTiers(currency).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getTieredCollateralRatio(String currency, BybitApiCallback<Object> callback) {
        bybitApiService.getTieredCollateralRatio(currency).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getSpotMarginTradeCoinState(String currency, BybitApiCallback<Object> callback) {
        bybitApiService.getSpotMarginTradeCoinState(currency).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getSpotMarginTradeFlexibleAvailableInventory(String currency, BybitApiCallback<Object> callback) {
        bybitApiService.getSpotMarginTradeFlexibleAvailableInventory(currency).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getSpotMarginTradeMaxBorrowable(String currency, BybitApiCallback<Object> callback) {
        bybitApiService.getSpotMarginTradeMaxBorrowable(currency).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getSpotMarginTradeRepaymentAvailableAmount(String currency, BybitApiCallback<Object> callback) {
        bybitApiService.getSpotMarginTradeRepaymentAvailableAmount(currency).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void queryFixedAvailableInventory(String currency, String term, String annualRate, BybitApiCallback<Object> callback) {
        bybitApiService.queryFixedAvailableInventory(currency, term, annualRate).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void queryFixedBorrowContracts(String orderId, String orderCurrency, String term, String limit, String cursor, BybitApiCallback<Object> callback) {
        bybitApiService.queryFixedBorrowContracts(orderId, orderCurrency, term, limit, cursor).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void queryFixedBorrowOrders(String orderId, String orderCurrency, String state, String term, String limit, String cursor, BybitApiCallback<Object> callback) {
        bybitApiService.queryFixedBorrowOrders(orderId, orderCurrency, state, term, limit, cursor).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void queryFixedBorrowMarket(String orderCurrency, String term, String orderBy, Long sort, Integer limit, BybitApiCallback<Object> callback) {
        bybitApiService.queryFixedBorrowMarket(orderCurrency, term, orderBy, sort, limit).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void renewFixedBorrow(RenewFixedBorrowRequest renewFixedBorrowRequest, BybitApiCallback<Object> callback) {
        bybitApiService.renewFixedBorrow(renewFixedBorrowRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void accountFixedBorrow(FixedBorrowRequest fixedBorrowRequest, BybitApiCallback<Object> callback) {
        bybitApiService.accountFixedBorrow(fixedBorrowRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void queryBorrowLiability(String currency, BybitApiCallback<Object> callback) {
        bybitApiService.queryBorrowLiability(currency).enqueue(new BybitApiCallbackAdapter<>(callback));
    }
}
