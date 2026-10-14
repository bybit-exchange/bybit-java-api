package com.bybit.api.client.restApi;

import com.bybit.api.client.domain.account.request.AccountDataRequest;
import com.bybit.api.client.domain.account.request.BatchSetCollateralCoinRequest;
import com.bybit.api.client.domain.account.request.ManualBorrowRequest;
import com.bybit.api.client.domain.account.request.ManualRepayRequest;
import com.bybit.api.client.domain.account.request.NoConvertRepayRequest;
import com.bybit.api.client.domain.account.request.OneClickRepayRequest;
import com.bybit.api.client.domain.account.request.SetPriceLimitRequest;
import com.bybit.api.client.domain.account.request.UtaDemoApplyMoneyRequest;

public interface BybitApiAccountRestClient {
    // Account endpoints
    Object getWalletBalance(AccountDataRequest walletBalanceRequest);
    Object upgradeAccountToUTA();
    Object getAccountBorrowHistory(AccountDataRequest borrowHistoryRequest);
    Object setAccountCollateralCoin(AccountDataRequest setCollateralCoinRequest);
    Object batchSetAccountCollateralCoin(BatchSetCollateralCoinRequest batchSetCollateralCoinRequest);
    Object getAccountCollateralInfo(AccountDataRequest request);
    Object getAccountCoinGeeks(AccountDataRequest request);
    Object getAccountFreeRate(AccountDataRequest getFeeRateRequest);
    Object getAccountInfo();
    Object getTransactionLog(AccountDataRequest getTransactionLogRequest);
    Object setAccountMarginMode(AccountDataRequest request);
    Object setAccountSpotHedging(AccountDataRequest request);
    Object modifyAccountMMP(AccountDataRequest setMMPRequest);
    Object resetAccountMMP(AccountDataRequest request);
    Object getAccountMMPState(AccountDataRequest request);
    Object getAccountSMPGroup();

    default Object getAccountInstruments(String category, String symbol, Integer limit, String cursor) {
        throw new UnsupportedOperationException("getAccountInstruments is not implemented by this client");
    }

    default Object getDcpInfo() {
        throw new UnsupportedOperationException("getDcpInfo is not implemented by this client");
    }

    default Object getTransferableAmount(String coinName) {
        throw new UnsupportedOperationException("getTransferableAmount is not implemented by this client");
    }

    default Object getUserSettings() {
        throw new UnsupportedOperationException("getUserSettings is not implemented by this client");
    }

    default Object manualBorrow(ManualBorrowRequest manualBorrowRequest) {
        throw new UnsupportedOperationException("manualBorrow is not implemented by this client");
    }

    default Object manualRepay(ManualRepayRequest manualRepayRequest) {
        throw new UnsupportedOperationException("manualRepay is not implemented by this client");
    }

    default Object noConvertRepay(NoConvertRepayRequest noConvertRepayRequest) {
        throw new UnsupportedOperationException("noConvertRepay is not implemented by this client");
    }

    default Object oneClickRepay(OneClickRepayRequest oneClickRepayRequest) {
        throw new UnsupportedOperationException("oneClickRepay is not implemented by this client");
    }

    default Object setPriceLimit(SetPriceLimitRequest setPriceLimitRequest) {
        throw new UnsupportedOperationException("setPriceLimit is not implemented by this client");
    }

    default Object getSmpGroup() {
        throw new UnsupportedOperationException("getSmpGroup is not implemented by this client");
    }

    default Object getTransactionLogGet(String accountType, String category, String currency, String baseCoin, String type, String transSubType, Long startTime, Long endTime, Integer limit, String cursor) {
        throw new UnsupportedOperationException("getTransactionLogGet is not implemented by this client");
    }

    default Object demoApplyMoney(UtaDemoApplyMoneyRequest utaDemoApplyMoneyRequest) {
        throw new UnsupportedOperationException("demoApplyMoney is not implemented by this client");
    }

    default Object getOptionAssetInfo() {
        throw new UnsupportedOperationException("getOptionAssetInfo is not implemented by this client");
    }

    default Object getPayInfo(String coin) {
        throw new UnsupportedOperationException("getPayInfo is not implemented by this client");
    }

    default Object getTradeInfoForAnalysis(String symbol, Long startTime, Long endTime) {
        throw new UnsupportedOperationException("getTradeInfoForAnalysis is not implemented by this client");
    }
}
