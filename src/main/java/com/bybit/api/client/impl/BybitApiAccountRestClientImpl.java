package com.bybit.api.client.impl;

import com.bybit.api.client.domain.account.request.BatchSetCollateralCoinRequest;
import com.bybit.api.client.domain.account.request.ManualBorrowRequest;
import com.bybit.api.client.domain.account.request.ManualRepayRequest;
import com.bybit.api.client.domain.account.request.NoConvertRepayRequest;
import com.bybit.api.client.domain.account.request.OneClickRepayRequest;
import com.bybit.api.client.domain.account.request.SetPriceLimitRequest;
import com.bybit.api.client.restApi.BybitApiAccountRestClient;
import com.bybit.api.client.restApi.BybitApiService;
import com.bybit.api.client.domain.account.request.AccountDataRequest;
import com.bybit.api.client.service.BybitJsonConverter;

import static com.bybit.api.client.service.BybitApiServiceGenerator.createService;
import static com.bybit.api.client.service.BybitApiServiceGenerator.executeSync;
import com.bybit.api.client.domain.account.request.UtaDemoApplyMoneyRequest;

public class BybitApiAccountRestClientImpl implements BybitApiAccountRestClient {
    private final BybitApiService bybitApiService;
    private final BybitJsonConverter converter = new BybitJsonConverter();

    public BybitApiAccountRestClientImpl(String apiKey, String secret, String baseUrl, boolean debugMode, long recvWindow, String logOption) {
        bybitApiService = createService(BybitApiService.class, apiKey, secret, baseUrl, debugMode, recvWindow, logOption, "");
    }
    // Account endpoints
    @Override
    public Object getWalletBalance(AccountDataRequest walletBalanceRequest) {
        return executeSync(bybitApiService.getWalletBalance(
                walletBalanceRequest.getAccountType() == null ? null : walletBalanceRequest.getAccountType().getAccountTypeValue(),
                walletBalanceRequest.getCoins()
        ));
    }

    @Override
    public Object upgradeAccountToUTA() {
        return executeSync(bybitApiService.upgradeAccountToUTA());
    }

    @Override
    public Object getAccountBorrowHistory(AccountDataRequest borrowHistoryRequest) {
        return executeSync(bybitApiService.getAccountBorrowHistory(
                borrowHistoryRequest.getCurrency(),
                borrowHistoryRequest.getStartTime(),
                borrowHistoryRequest.getEndTime(),
                borrowHistoryRequest.getLimit(),
                borrowHistoryRequest.getCursor()
        ));
    }

    @Override
    public Object setAccountCollateralCoin(AccountDataRequest setCollateralCoinRequest) {
        var request = converter.mapToSetCollateralCoinRequest(setCollateralCoinRequest);
        return executeSync(bybitApiService.setAccountCollateralCoin(request));
    }

    @Override
    public Object batchSetAccountCollateralCoin(BatchSetCollateralCoinRequest batchSetCollateralCoinRequest) {
        return executeSync(bybitApiService.batchSetAccountCollateralCoin(batchSetCollateralCoinRequest));
    }

    @Override
    public Object getAccountCollateralInfo(AccountDataRequest request) {
        return executeSync((bybitApiService.getAccountCollateralInfo(
                request.getCurrency()
        )));
    }

    @Override
    public Object getAccountCoinGeeks(AccountDataRequest request) {
        return executeSync((bybitApiService.getAccountCoinGeeks(request.getBaseCoin())));
    }

    @Override
    public Object getAccountFreeRate(AccountDataRequest getFeeRateRequest) {
        return executeSync(bybitApiService.getAccountFreeRate(
                getFeeRateRequest.getCategory().getCategoryTypeId(),
                getFeeRateRequest.getSymbol(),
                getFeeRateRequest.getBaseCoin()
        ));
    }


    @Override
    public Object getAccountInfo() {
        return executeSync(bybitApiService.getAccountInfo());
    }

    @Override
    public Object getTransactionLog(AccountDataRequest getTransactionLogRequest) {
        boolean isUta = getTransactionLogRequest.getIsUta() == null || getTransactionLogRequest.getIsUta().isUta();
        if(isUta)
            return executeSync(bybitApiService.getUtaTransactionLog(
                getTransactionLogRequest.getAccountType() == null ? null : getTransactionLogRequest.getAccountType().getAccountTypeValue(),
                getTransactionLogRequest.getCategory() == null ? null : getTransactionLogRequest.getCategory().getCategoryTypeId(),
                getTransactionLogRequest.getCurrency(),
                getTransactionLogRequest.getBaseCoin(),
                getTransactionLogRequest.getTransactionType() == null ? null : getTransactionLogRequest.getTransactionType().getTransactionTypeId(),
                getTransactionLogRequest.getStartTime(),
                getTransactionLogRequest.getEndTime(),
                getTransactionLogRequest.getLimit(),
                getTransactionLogRequest.getCursor()
        ));
        else
            return executeSync(bybitApiService.getClassicalTransactionLog(
                    getTransactionLogRequest.getAccountType() == null ? null : getTransactionLogRequest.getAccountType().getAccountTypeValue(),
                    getTransactionLogRequest.getCategory() == null ? null : getTransactionLogRequest.getCategory().getCategoryTypeId(),
                    getTransactionLogRequest.getCurrency(),
                    getTransactionLogRequest.getBaseCoin(),
                    getTransactionLogRequest.getTransactionType() == null ? null : getTransactionLogRequest.getTransactionType().getTransactionTypeId(),
                    getTransactionLogRequest.getStartTime(),
                    getTransactionLogRequest.getEndTime(),
                    getTransactionLogRequest.getLimit(),
                    getTransactionLogRequest.getCursor()
            ));
    }


    @Override
    public Object setAccountMarginMode(AccountDataRequest setMarginMode) {
        var request = converter.mapToSetMarginModeRequest(setMarginMode);
        return executeSync(bybitApiService.setAccountMarginMode(request));
    }

    @Override
    public Object setAccountSpotHedging(AccountDataRequest setSpotHedging) {
        var request = converter.mapToSetSpotHedgingModeRequest(setSpotHedging);
        return executeSync(bybitApiService.setAccountSpotHedging(request));
    }

    @Override
    public Object modifyAccountMMP(AccountDataRequest setMMPRequest) {
        var request = converter.mapToSetMMPRequest(setMMPRequest);
        return executeSync(bybitApiService.modifyAccountMMP(request));
    }

    @Override
    public Object resetAccountMMP(AccountDataRequest request) {
        var resetMMPRequest = converter.mapToResetMarginModeRequest(request);
        return executeSync(bybitApiService.resetAccountMMP(resetMMPRequest));
    }

    @Override
    public Object getAccountMMPState(AccountDataRequest request) {
        return executeSync(bybitApiService.getAccountMMPState(request.getBaseCoin()));
    }

    @Override
    public Object getAccountSMPGroup() {
        return executeSync(bybitApiService.getAccountSMPGroupId());
    }

    @Override
    public Object getAccountInstruments(String category, String symbol, Integer limit, String cursor) {
        return executeSync(bybitApiService.getAccountInstruments(category, symbol, limit, cursor));
    }

    @Override
    public Object getDcpInfo() {
        return executeSync(bybitApiService.getDcpInfo());
    }

    @Override
    public Object getTransferableAmount(String coinName) {
        return executeSync(bybitApiService.getTransferableAmount(coinName));
    }

    @Override
    public Object getUserSettings() {
        return executeSync(bybitApiService.getUserSettings());
    }

    @Override
    public Object manualBorrow(ManualBorrowRequest manualBorrowRequest) {
        return executeSync(bybitApiService.manualBorrow(manualBorrowRequest));
    }

    @Override
    public Object manualRepay(ManualRepayRequest manualRepayRequest) {
        return executeSync(bybitApiService.manualRepay(manualRepayRequest));
    }

    @Override
    public Object noConvertRepay(NoConvertRepayRequest noConvertRepayRequest) {
        return executeSync(bybitApiService.noConvertRepay(noConvertRepayRequest));
    }

    @Override
    public Object oneClickRepay(OneClickRepayRequest oneClickRepayRequest) {
        return executeSync(bybitApiService.oneClickRepay(oneClickRepayRequest));
    }

    @Override
    public Object setPriceLimit(SetPriceLimitRequest setPriceLimitRequest) {
        return executeSync(bybitApiService.setPriceLimit(setPriceLimitRequest));
    }

    @Override
    public Object getSmpGroup() {
        return executeSync(bybitApiService.getSmpGroup());
    }

    @Override
    public Object getTransactionLogGet(String accountType, String category, String currency, String baseCoin, String type, String transSubType, Long startTime, Long endTime, Integer limit, String cursor) {
        return executeSync(bybitApiService.getTransactionLogGet(accountType, category, currency, baseCoin, type, transSubType, startTime, endTime, limit, cursor));
    }

    @Override
    public Object demoApplyMoney(UtaDemoApplyMoneyRequest utaDemoApplyMoneyRequest) {
        return executeSync(bybitApiService.demoApplyMoney(utaDemoApplyMoneyRequest));
    }

    @Override
    public Object getOptionAssetInfo() {
        return executeSync(bybitApiService.getOptionAssetInfo());
    }

    @Override
    public Object getPayInfo(String coin) {
        return executeSync(bybitApiService.getPayInfo(coin));
    }

    @Override
    public Object getTradeInfoForAnalysis(String symbol, Long startTime, Long endTime) {
        return executeSync(bybitApiService.getTradeInfoForAnalysis(symbol, startTime, endTime));
    }
}
