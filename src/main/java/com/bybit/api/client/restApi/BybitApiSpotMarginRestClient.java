package com.bybit.api.client.restApi;

import com.bybit.api.client.domain.spot.SpotMarginDataRequest;

import java.util.Map;
import com.bybit.api.client.domain.spot.marginTrade.FixedBorrowRequest;
import com.bybit.api.client.domain.spot.marginTrade.RenewFixedBorrowRequest;

public interface BybitApiSpotMarginRestClient {
    // Spot Endpoints
    // Spot Leverage Token
    Object getSpotLeverageTokenInfo(SpotMarginDataRequest spotMarginDataRequest);
    Object getSpotLeverageTokenMarket(SpotMarginDataRequest spotMarginDataRequest);
    Object purchaseSpotLeverageToken(SpotMarginDataRequest spotMarginDataRequest);
    Object redeemSpotLeverageToken(SpotMarginDataRequest spotMarginDataRequest);
    Object getSpotLeverageRecords(SpotMarginDataRequest spotMarginDataRequest);

    // Spot Margin UTA
    Object getUtaVipSpotMarginTradeData(SpotMarginDataRequest spotMarginDataRequest);
    Object setUTASpotMarginTrade(String mode);
    Object setUTASpotMarginTradeLeverage(String leverage);
    Object setUTASpotMarginTradeAutoRepayMode(Map<String, Object> request);
    Object getUTASpotMarginTradeAutoRepayMode(Map<String, Object> request);
    Object getUTASpotMarginTradeLeverageState();

    // Spot Margin Normal
    Object getNormalVipSpotMarginTradeData(SpotMarginDataRequest spotMarginDataRequest);
    Object getNormalSpotMarginTradeCoinInfo(SpotMarginDataRequest spotMarginDataRequest);
    Object getNormalSpotMarginTradeBorrowCoinInfo(SpotMarginDataRequest spotMarginDataRequest);
    Object getNormalSpotMarginTradeInterestQuota(SpotMarginDataRequest spotMarginDataRequest);
    Object getNormalSpotMarginTradeAccountInfo();
    Object setNormalSpotToggleMarginTrade(SpotMarginDataRequest spotMarginDataRequest);
    Object loanNormalSpotMarginTrade(SpotMarginDataRequest spotMarginDataRequest);
    Object repayNormalSpotMarginTrade(SpotMarginDataRequest spotMarginDataRequest);
    default Object getNormalSpotMarginTradeBorrowOrders(SpotMarginDataRequest spotMarginDataRequest) {
        throw new UnsupportedOperationException("getNormalSpotMarginTradeBorrowOrders is not implemented by this client");
    }
    default Object getNormalSpotMarginTradeRepayOrders(SpotMarginDataRequest spotMarginDataRequest) {
        throw new UnsupportedOperationException("getNormalSpotMarginTradeRepayOrders is not implemented by this client");
    }
    default Object getSpotMarginInterestRateHistory(SpotMarginDataRequest spotMarginDataRequest) {
        throw new UnsupportedOperationException("getSpotMarginInterestRateHistory is not implemented by this client");
    }
    default Object getPositionTiers(String currency) {
        throw new UnsupportedOperationException("getPositionTiers is not implemented by this client");
    }
    default Object getTieredCollateralRatio(String currency) {
        throw new UnsupportedOperationException("getTieredCollateralRatio is not implemented by this client");
    }

    Object getSpotMarginTradeCoinState(String currency);

    Object getSpotMarginTradeFlexibleAvailableInventory(String currency);

    Object getSpotMarginTradeMaxBorrowable(String currency);

    Object getSpotMarginTradeRepaymentAvailableAmount(String currency);

    Object queryFixedAvailableInventory(String currency, String term, String annualRate);

    Object queryFixedBorrowContracts(String orderId, String orderCurrency, String term, String limit, String cursor);

    Object queryFixedBorrowOrders(String orderId, String orderCurrency, String state, String term, String limit, String cursor);

    Object queryFixedBorrowMarket(String orderCurrency, String term, String orderBy, Long sort, Integer limit);

    Object renewFixedBorrow(RenewFixedBorrowRequest renewFixedBorrowRequest);

    Object accountFixedBorrow(FixedBorrowRequest fixedBorrowRequest);

    Object queryBorrowLiability(String currency);
}
