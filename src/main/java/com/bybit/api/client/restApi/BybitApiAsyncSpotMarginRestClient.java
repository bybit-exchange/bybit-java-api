package com.bybit.api.client.restApi;

import com.bybit.api.client.domain.spot.SpotMarginDataRequest;

import java.util.Map;
import com.bybit.api.client.domain.spot.marginTrade.FixedBorrowRequest;
import com.bybit.api.client.domain.spot.marginTrade.RenewFixedBorrowRequest;

public interface BybitApiAsyncSpotMarginRestClient {
    // Spot Endpoints
    // Spot Leverage Token
    void getSpotLeverageTokenInfo(SpotMarginDataRequest spotMarginDataRequest, BybitApiCallback<Object> callback);

    void getSpotLeverageTokenMarket(SpotMarginDataRequest spotMarginDataRequest, BybitApiCallback<Object> callback);

    void purchaseSpotLeverageToken(SpotMarginDataRequest spotMarginDataRequest, BybitApiCallback<Object> callback);

    void redeemSpotLeverageToken(SpotMarginDataRequest spotMarginDataRequest, BybitApiCallback<Object> callback);

    void getSpotLeverageRecords(SpotMarginDataRequest spotMarginDataRequest, BybitApiCallback<Object> callback);

    // Spot Margin UTA
    void getUtaVipSpotMarginTradeData(SpotMarginDataRequest spotMarginDataRequest, BybitApiCallback<Object> callback);

    void setUTASpotMarginTrade(String mode, BybitApiCallback<Object> callback);

    void setUTASpotMarginTradeLeverage(String leverage, BybitApiCallback<Object> callback);


    void setUTASpotMarginTradeAutoRepayMode(Map<String, Object> request, BybitApiCallback<Object> callback);

    void getUTASpotMarginTradeAutoRepayMode(Map<String, Object> request, BybitApiCallback<Object> callback);

    void getUTASpotMarginTradeLeverageState(BybitApiCallback<Object> callback);

    // Spot Margin Normal
    void getNormalVipSpotMarginTradeData(SpotMarginDataRequest spotMarginDataRequest, BybitApiCallback<Object> callback);

    void getNormalSpotMarginTradeCoinInfo(SpotMarginDataRequest spotMarginDataRequest, BybitApiCallback<Object> callback);

    void getNormalSpotMarginTradeBorrowCoinInfo(SpotMarginDataRequest spotMarginDataRequest, BybitApiCallback<Object> callback);

    void getNormalSpotMarginTradeInterestQuota(SpotMarginDataRequest spotMarginDataRequest, BybitApiCallback<Object> callback);

    void getNormalSpotMarginTradeAccountInfo(BybitApiCallback<Object> callback);

    void setNormalSpotToggleMarginTrade(SpotMarginDataRequest spotMarginDataRequest, BybitApiCallback<Object> callback);

    void loanNormalSpotMarginTrade(SpotMarginDataRequest spotMarginDataRequest, BybitApiCallback<Object> callback);

    void repayNormalSpotMarginTrade(SpotMarginDataRequest spotMarginDataRequest, BybitApiCallback<Object> callback);

    default void getNormalSpotMarginTradeBorrowOrders(SpotMarginDataRequest spotMarginDataRequest, BybitApiCallback<Object> callback) {
        throw new UnsupportedOperationException("getNormalSpotMarginTradeBorrowOrders is not implemented by this client");
    }

    default void getNormalSpotMarginTradeRepayOrders(SpotMarginDataRequest spotMarginDataRequest, BybitApiCallback<Object> callback) {
        throw new UnsupportedOperationException("getNormalSpotMarginTradeRepayOrders is not implemented by this client");
    }

    default void getSpotMarginInterestRateHistory(SpotMarginDataRequest spotMarginDataRequest, BybitApiCallback<Object> callback) {
        throw new UnsupportedOperationException("getSpotMarginInterestRateHistory is not implemented by this client");
    }

    default void getPositionTiers(String currency, BybitApiCallback<Object> callback) {
        throw new UnsupportedOperationException("getPositionTiers is not implemented by this client");
    }

    default void getTieredCollateralRatio(String currency, BybitApiCallback<Object> callback) {
        throw new UnsupportedOperationException("getTieredCollateralRatio is not implemented by this client");
    }

    void getSpotMarginTradeCoinState(String currency, BybitApiCallback<Object> callback);

    void getSpotMarginTradeFlexibleAvailableInventory(String currency, BybitApiCallback<Object> callback);

    void getSpotMarginTradeMaxBorrowable(String currency, BybitApiCallback<Object> callback);

    void getSpotMarginTradeRepaymentAvailableAmount(String currency, BybitApiCallback<Object> callback);

    void queryFixedAvailableInventory(String currency, String term, String annualRate, BybitApiCallback<Object> callback);

    void queryFixedBorrowContracts(String orderId, String orderCurrency, String term, String limit, String cursor, BybitApiCallback<Object> callback);

    void queryFixedBorrowOrders(String orderId, String orderCurrency, String state, String term, String limit, String cursor, BybitApiCallback<Object> callback);

    void queryFixedBorrowMarket(String orderCurrency, String term, String orderBy, Long sort, Integer limit, BybitApiCallback<Object> callback);

    void renewFixedBorrow(RenewFixedBorrowRequest renewFixedBorrowRequest, BybitApiCallback<Object> callback);

    void accountFixedBorrow(FixedBorrowRequest fixedBorrowRequest, BybitApiCallback<Object> callback);

    void queryBorrowLiability(String currency, BybitApiCallback<Object> callback);
}
