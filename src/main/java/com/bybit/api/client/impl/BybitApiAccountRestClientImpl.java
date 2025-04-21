package com.bybit.api.client.impl;

import com.bybit.api.client.domain.GenericResponse;
import com.bybit.api.client.domain.account.request.AccountDataRequest;
import com.bybit.api.client.domain.account.request.BatchSetCollateralCoinRequest;
import com.bybit.api.client.domain.account.response.WalletBalanceResponse;
import com.bybit.api.client.restApi.BybitApiAccountRestClient;
import com.bybit.api.client.restApi.BybitApiService;
import com.bybit.api.client.service.BybitJsonConverter;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import static com.bybit.api.client.service.BybitApiServiceGenerator.createService;
import static com.bybit.api.client.service.BybitApiServiceGenerator.executeSync;

public class BybitApiAccountRestClientImpl implements BybitApiAccountRestClient {
    private static final ObjectMapper MAPPER = new ObjectMapper();

    private final BybitApiService bybitApiService;
    private final BybitJsonConverter converter = new BybitJsonConverter();

    public BybitApiAccountRestClientImpl(String apiKey, String secret, String baseUrl, boolean debugMode, long recvWindow, String logOption) {
        bybitApiService = createService(BybitApiService.class, apiKey, secret, baseUrl, debugMode, recvWindow, logOption, "");
    }
    // Account endpoints
    @Override
    public GenericResponse<WalletBalanceResponse> getWalletBalance(AccountDataRequest walletBalanceRequest) {
        var result = executeSync(bybitApiService.getWalletBalance(
                walletBalanceRequest.getAccountType() == null ? null : walletBalanceRequest.getAccountType().getAccountTypeValue(),
                walletBalanceRequest.getCoins()
        ));

        return MAPPER.convertValue(result, new TypeReference<GenericResponse<WalletBalanceResponse>>() {});
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
}
