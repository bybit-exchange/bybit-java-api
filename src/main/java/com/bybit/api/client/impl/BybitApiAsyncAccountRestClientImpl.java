package com.bybit.api.client.impl;

import com.bybit.api.client.domain.account.request.BatchSetCollateralCoinRequest;
import com.bybit.api.client.domain.account.request.ManualBorrowRequest;
import com.bybit.api.client.domain.account.request.ManualRepayRequest;
import com.bybit.api.client.domain.account.request.NoConvertRepayRequest;
import com.bybit.api.client.domain.account.request.OneClickRepayRequest;
import com.bybit.api.client.domain.account.request.SetPriceLimitRequest;
import com.bybit.api.client.restApi.BybitApiAsyncAccountRestClient;
import com.bybit.api.client.restApi.BybitApiCallback;
import com.bybit.api.client.restApi.BybitApiService;
import com.bybit.api.client.domain.account.request.AccountDataRequest;
import com.bybit.api.client.service.BybitJsonConverter;

import static com.bybit.api.client.service.BybitApiServiceGenerator.createService;
import com.bybit.api.client.domain.account.request.UtaDemoApplyMoneyRequest;

public class BybitApiAsyncAccountRestClientImpl implements BybitApiAsyncAccountRestClient {
    private final BybitApiService bybitApiService;
    private final BybitJsonConverter converter = new BybitJsonConverter();

    public BybitApiAsyncAccountRestClientImpl(String apiKey, String secret, String baseUrl, boolean debugMode, long recvWindow, String logOption) {
        bybitApiService = createService(BybitApiService.class, apiKey, secret, baseUrl, debugMode, recvWindow, logOption, "");
    }

    // Account Endpoints
    @Override
    public void getWalletBalance(AccountDataRequest walletBalanceRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getWalletBalance(
                walletBalanceRequest.getAccountType().getAccountTypeValue(),
                walletBalanceRequest.getCoins()
        ).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void upgradeAccountToUTA(BybitApiCallback<Object> callback) {
        bybitApiService.upgradeAccountToUTA().enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getAccountBorrowHistory(AccountDataRequest borrowHistoryRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getAccountBorrowHistory(
                borrowHistoryRequest.getCurrency(),
                borrowHistoryRequest.getStartTime(),
                borrowHistoryRequest.getEndTime(),
                borrowHistoryRequest.getLimit(),
                borrowHistoryRequest.getCursor()
        ).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void setAccountCollateralCoin(AccountDataRequest setCollateralCoinRequest, BybitApiCallback<Object> callback) {
        var request = converter.mapToSetCollateralCoinRequest(setCollateralCoinRequest);
        bybitApiService.setAccountCollateralCoin(request).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void batchSetAccountCollateralCoin(BatchSetCollateralCoinRequest batchSetCollateralCoinRequest, BybitApiCallback<Object> callback) {
        bybitApiService.batchSetAccountCollateralCoin(batchSetCollateralCoinRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getAccountCollateralInfo(AccountDataRequest request, BybitApiCallback<Object> callback) {
        bybitApiService.getAccountCollateralInfo(
                request.getCurrency()
        ).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getAccountCoinGeeks(AccountDataRequest request, BybitApiCallback<Object> callback) {
        bybitApiService.getAccountCoinGeeks(request.getBaseCoin()).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getAccountFreeRate(AccountDataRequest getFeeRateRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getAccountFreeRate(
                getFeeRateRequest.getCategory().getCategoryTypeId(),
                getFeeRateRequest.getSymbol(),
                getFeeRateRequest.getBaseCoin()
        ).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getAccountInfo(BybitApiCallback<Object> callback) {
        bybitApiService.getAccountInfo().enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getTransactionLog(AccountDataRequest getTransactionLogRequest, BybitApiCallback<Object> callback) {
        boolean isUta = getTransactionLogRequest.getIsUta() == null || getTransactionLogRequest.getIsUta().isUta();
        if(isUta)
        bybitApiService.getUtaTransactionLog(
                getTransactionLogRequest.getAccountType() == null ? null : getTransactionLogRequest.getAccountType().getAccountTypeValue(),
                getTransactionLogRequest.getCategory() == null ? null : getTransactionLogRequest.getCategory().getCategoryTypeId(),
                getTransactionLogRequest.getCurrency(),
                getTransactionLogRequest.getBaseCoin(),
                getTransactionLogRequest.getTransactionType() == null ? null : getTransactionLogRequest.getTransactionType().getTransactionTypeId(),
                getTransactionLogRequest.getStartTime(),
                getTransactionLogRequest.getEndTime(),
                getTransactionLogRequest.getLimit(),
                getTransactionLogRequest.getCursor()
        ).enqueue(new BybitApiCallbackAdapter<>(callback));
        else
            bybitApiService.getClassicalTransactionLog(
                    getTransactionLogRequest.getAccountType() == null ? null : getTransactionLogRequest.getAccountType().getAccountTypeValue(),
                    getTransactionLogRequest.getCategory() == null ? null : getTransactionLogRequest.getCategory().getCategoryTypeId(),
                    getTransactionLogRequest.getCurrency(),
                    getTransactionLogRequest.getBaseCoin(),
                    getTransactionLogRequest.getTransactionType() == null ? null : getTransactionLogRequest.getTransactionType().getTransactionTypeId(),
                    getTransactionLogRequest.getStartTime(),
                    getTransactionLogRequest.getEndTime(),
                    getTransactionLogRequest.getLimit(),
                    getTransactionLogRequest.getCursor()
            ).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void setAccountMarginMode(AccountDataRequest request, BybitApiCallback<Object> callback) {
        var setMarginMode = converter.mapToSetMarginModeRequest(request);
        bybitApiService.setAccountMarginMode(setMarginMode).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void modifyAccountMMP(AccountDataRequest setMMPRequest, BybitApiCallback<Object> callback) {
        var request = converter.mapToSetMMPRequest(setMMPRequest);
        bybitApiService.modifyAccountMMP(request).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void resetAccountMMP(AccountDataRequest request, BybitApiCallback<Object> callback) {
        var resetMMPRequest = converter.mapToResetMarginModeRequest(request);
        bybitApiService.resetAccountMMP(resetMMPRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getAccountMMPState(AccountDataRequest request, BybitApiCallback<Object> callback) {
        bybitApiService.getAccountMMPState(request.getBaseCoin()).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getAccountSMPGroup(BybitApiCallback<Object> callback) {
        bybitApiService.getAccountSMPGroupId().enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void setAccountSpotHedging(AccountDataRequest request, BybitApiCallback<Object> callback) {
        var setSpotHedging = converter.mapToSetSpotHedgingModeRequest(request);
        bybitApiService.setAccountSpotHedging(setSpotHedging).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getAccountInstruments(String category, String symbol, Integer limit, String cursor, BybitApiCallback<Object> callback) {
        bybitApiService.getAccountInstruments(category, symbol, limit, cursor).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getDcpInfo(BybitApiCallback<Object> callback) {
        bybitApiService.getDcpInfo().enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getTransferableAmount(String coinName, BybitApiCallback<Object> callback) {
        bybitApiService.getTransferableAmount(coinName).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getUserSettings(BybitApiCallback<Object> callback) {
        bybitApiService.getUserSettings().enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void manualBorrow(ManualBorrowRequest manualBorrowRequest, BybitApiCallback<Object> callback) {
        bybitApiService.manualBorrow(manualBorrowRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void manualRepay(ManualRepayRequest manualRepayRequest, BybitApiCallback<Object> callback) {
        bybitApiService.manualRepay(manualRepayRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void noConvertRepay(NoConvertRepayRequest noConvertRepayRequest, BybitApiCallback<Object> callback) {
        bybitApiService.noConvertRepay(noConvertRepayRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void oneClickRepay(OneClickRepayRequest oneClickRepayRequest, BybitApiCallback<Object> callback) {
        bybitApiService.oneClickRepay(oneClickRepayRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void setPriceLimit(SetPriceLimitRequest setPriceLimitRequest, BybitApiCallback<Object> callback) {
        bybitApiService.setPriceLimit(setPriceLimitRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getSmpGroup(BybitApiCallback<Object> callback) {
        bybitApiService.getSmpGroup().enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getTransactionLogGet(String accountType, String category, String currency, String baseCoin, String type, String transSubType, Long startTime, Long endTime, Integer limit, String cursor, BybitApiCallback<Object> callback) {
        bybitApiService.getTransactionLogGet(accountType, category, currency, baseCoin, type, transSubType, startTime, endTime, limit, cursor).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void demoApplyMoney(UtaDemoApplyMoneyRequest utaDemoApplyMoneyRequest, BybitApiCallback<Object> callback) {
        bybitApiService.demoApplyMoney(utaDemoApplyMoneyRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getOptionAssetInfo(BybitApiCallback<Object> callback) {
        bybitApiService.getOptionAssetInfo().enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getPayInfo(String coin, BybitApiCallback<Object> callback) {
        bybitApiService.getPayInfo(coin).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getTradeInfoForAnalysis(String symbol, Long startTime, Long endTime, BybitApiCallback<Object> callback) {
        bybitApiService.getTradeInfoForAnalysis(symbol, startTime, endTime).enqueue(new BybitApiCallbackAdapter<>(callback));
    }
}
