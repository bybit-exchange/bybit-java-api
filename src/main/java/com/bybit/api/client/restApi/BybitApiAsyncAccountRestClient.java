package com.bybit.api.client.restApi;

import com.bybit.api.client.domain.account.request.AccountDataRequest;
import com.bybit.api.client.domain.account.request.BatchSetCollateralCoinRequest;
import com.bybit.api.client.domain.account.request.ManualBorrowRequest;
import com.bybit.api.client.domain.account.request.ManualRepayRequest;
import com.bybit.api.client.domain.account.request.NoConvertRepayRequest;
import com.bybit.api.client.domain.account.request.OneClickRepayRequest;
import com.bybit.api.client.domain.account.request.SetPriceLimitRequest;
import com.bybit.api.client.domain.account.request.UtaDemoApplyMoneyRequest;

public interface BybitApiAsyncAccountRestClient {
    // Account endpoints
    void getWalletBalance(AccountDataRequest walletBalanceRequest, BybitApiCallback<Object> callback);
    void upgradeAccountToUTA(BybitApiCallback<Object> callback);
    void getAccountBorrowHistory(AccountDataRequest borrowHistoryRequest, BybitApiCallback<Object> callback);
    void setAccountCollateralCoin(AccountDataRequest setCollateralCoinRequest, BybitApiCallback<Object> callback);
    void batchSetAccountCollateralCoin(BatchSetCollateralCoinRequest batchSetCollateralCoinRequest, BybitApiCallback<Object> callback);
    void getAccountCollateralInfo(AccountDataRequest request, BybitApiCallback<Object> callback);
    void getAccountCoinGeeks(AccountDataRequest request, BybitApiCallback<Object> callback);
    void getAccountFreeRate(AccountDataRequest getFeeRateRequest, BybitApiCallback<Object> callback);
    void getAccountInfo(BybitApiCallback<Object> callback);
    void getTransactionLog(AccountDataRequest getTransactionLogRequest, BybitApiCallback<Object> callback);
    void setAccountMarginMode(AccountDataRequest request, BybitApiCallback<Object> callback);
    void modifyAccountMMP(AccountDataRequest setMMPRequest, BybitApiCallback<Object> callback);
    void resetAccountMMP(AccountDataRequest request, BybitApiCallback<Object> callback);
    void getAccountMMPState(AccountDataRequest request, BybitApiCallback<Object> callback);
    void getAccountSMPGroup(BybitApiCallback<Object> callback);
    void setAccountSpotHedging(AccountDataRequest request, BybitApiCallback<Object> callback);

    default void getAccountInstruments(String category, String symbol, Integer limit, String cursor, BybitApiCallback<Object> callback) {
        throw new UnsupportedOperationException("getAccountInstruments is not implemented by this client");
    }

    default void getDcpInfo(BybitApiCallback<Object> callback) {
        throw new UnsupportedOperationException("getDcpInfo is not implemented by this client");
    }

    default void getTransferableAmount(String coinName, BybitApiCallback<Object> callback) {
        throw new UnsupportedOperationException("getTransferableAmount is not implemented by this client");
    }

    default void getUserSettings(BybitApiCallback<Object> callback) {
        throw new UnsupportedOperationException("getUserSettings is not implemented by this client");
    }

    default void manualBorrow(ManualBorrowRequest manualBorrowRequest, BybitApiCallback<Object> callback) {
        throw new UnsupportedOperationException("manualBorrow is not implemented by this client");
    }

    default void manualRepay(ManualRepayRequest manualRepayRequest, BybitApiCallback<Object> callback) {
        throw new UnsupportedOperationException("manualRepay is not implemented by this client");
    }

    default void noConvertRepay(NoConvertRepayRequest noConvertRepayRequest, BybitApiCallback<Object> callback) {
        throw new UnsupportedOperationException("noConvertRepay is not implemented by this client");
    }

    default void oneClickRepay(OneClickRepayRequest oneClickRepayRequest, BybitApiCallback<Object> callback) {
        throw new UnsupportedOperationException("oneClickRepay is not implemented by this client");
    }

    default void setPriceLimit(SetPriceLimitRequest setPriceLimitRequest, BybitApiCallback<Object> callback) {
        throw new UnsupportedOperationException("setPriceLimit is not implemented by this client");
    }

    default void getSmpGroup(BybitApiCallback<Object> callback) {
        throw new UnsupportedOperationException("getSmpGroup is not implemented by this client");
    }

    default void getTransactionLogGet(String accountType, String category, String currency, String baseCoin, String type, String transSubType, Long startTime, Long endTime, Integer limit, String cursor, BybitApiCallback<Object> callback) {
        throw new UnsupportedOperationException("getTransactionLogGet is not implemented by this client");
    }

    default void demoApplyMoney(UtaDemoApplyMoneyRequest utaDemoApplyMoneyRequest, BybitApiCallback<Object> callback) {
        throw new UnsupportedOperationException("demoApplyMoney is not implemented by this client");
    }

    default void getOptionAssetInfo(BybitApiCallback<Object> callback) {
        throw new UnsupportedOperationException("getOptionAssetInfo is not implemented by this client");
    }

    default void getPayInfo(String coin, BybitApiCallback<Object> callback) {
        throw new UnsupportedOperationException("getPayInfo is not implemented by this client");
    }

    default void getTradeInfoForAnalysis(String symbol, Long startTime, Long endTime, BybitApiCallback<Object> callback) {
        throw new UnsupportedOperationException("getTradeInfoForAnalysis is not implemented by this client");
    }
}
