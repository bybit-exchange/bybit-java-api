package com.bybit.api.client.impl;

import com.bybit.api.client.restApi.BybitApiAsyncLendingRestClient;
import com.bybit.api.client.restApi.BybitApiCallback;
import com.bybit.api.client.restApi.BybitApiService;
import com.bybit.api.client.domain.institution.LendingDataRequest;
import com.bybit.api.client.service.BybitJsonConverter;

import static com.bybit.api.client.service.BybitApiServiceGenerator.createService;
import com.bybit.api.client.domain.institution.insLending.RepayLoanRequest;

public class BybitApiAsyncLendingRestClientImpl implements BybitApiAsyncLendingRestClient {
    private final BybitApiService bybitApiService;
    private final BybitJsonConverter converter = new BybitJsonConverter();

    public BybitApiAsyncLendingRestClientImpl(String apiKey, String apiSecret, String baseUrl, boolean debugMode, long recvWindow, String logOption) {
        bybitApiService = createService(BybitApiService.class, apiKey, apiSecret, baseUrl, debugMode, recvWindow, logOption, "");
    }

    // Institution Lending
    @Override
    public void getInsProductInfo(LendingDataRequest lendingDataRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getInsProductInfo(lendingDataRequest.getProductId()).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getInsMarginCoinInfo(LendingDataRequest lendingDataRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getInsMarginCoinInfo(lendingDataRequest.getProductId()).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getInsLoanOrders(LendingDataRequest institutionLoanOrdersRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getInsLoanOrders(institutionLoanOrdersRequest.getOrderId(),
                institutionLoanOrdersRequest.getStartTime(),
                institutionLoanOrdersRequest.getEndTime(),
                institutionLoanOrdersRequest.getLimit()
        ).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getInsRepayOrders(LendingDataRequest institutionRepayOrdersRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getInsRepayOrders(institutionRepayOrdersRequest.getStartTime(),
                institutionRepayOrdersRequest.getEndTime(),
                institutionRepayOrdersRequest.getLimit()
        ).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getInsLoanToValue(BybitApiCallback<Object> callback) {
        bybitApiService.getInsLoanToValue().enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void updateInstitutionLoanUid(LendingDataRequest lendingDataRequest, BybitApiCallback<Object> callback) {
        var updateInsUidRequest = converter.convertToUpdateInsUidRequest(lendingDataRequest);
        bybitApiService.updateInstitutionLoanUid(updateInsUidRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    /*// C2C Lending
    @Override
    public void getC2CLendingCoinInfo(LendingDataRequest lendingDataRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getC2CLendingCoinInfo(lendingDataRequest.getCoin()).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void C2cLendingDepositFunds(LendingDataRequest lendingDataRequest, BybitApiCallback<Object> callback) {
        var depsoitFundRequest = converter.mapToC2CLendingFundRequest(lendingDataRequest);
        bybitApiService.C2cLendingDepositFunds(depsoitFundRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void C2cLendingRedeemFunds(LendingDataRequest lendingDataRequest, BybitApiCallback<Object> callback) {
        var redeemFundRequest = converter.mapToC2CLendingFundRequest(lendingDataRequest);
        bybitApiService.C2cLendingRedeemFunds(redeemFundRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void C2cLendingRedeemCancel(LendingDataRequest lendingDataRequest, BybitApiCallback<Object> callback) {
        var redeemFundCancelRequest = converter.mapToC2CLendingFundRequest(lendingDataRequest);
        bybitApiService.C2cLendingRedeemFunds(redeemFundCancelRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getC2cOrdersRecords(LendingDataRequest c2cOrdersRecordsRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getC2cOrdersRecords(
                c2cOrdersRecordsRequest.getCoin(),
                c2cOrdersRecordsRequest.getOrderId(),
                c2cOrdersRecordsRequest.getStartTime(),
                c2cOrdersRecordsRequest.getEndTime(),
                c2cOrdersRecordsRequest.getLimit(),
                c2cOrdersRecordsRequest.getLendingOrderType() == null ? null : c2cOrdersRecordsRequest.getLendingOrderType().getType()
        ).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getC2CLendingAccountInfo(LendingDataRequest lendingDataRequest, BybitApiCallback<Object> callback) {
        String coin = lendingDataRequest.getCoin();
        bybitApiService.getC2CLendingAccountInfo(coin).enqueue(new BybitApiCallbackAdapter<>(callback));
    }*/

    @Override
    public void insLoanCoinDeltaAmount(String coin, BybitApiCallback<Object> callback) {
        bybitApiService.insLoanCoinDeltaAmount(coin).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void insLoanDelayLiqStatus(BybitApiCallback<Object> callback) {
        bybitApiService.insLoanDelayLiqStatus().enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    @Deprecated
    public void insLoanEnsureTokens(String productId, BybitApiCallback<Object> callback) {
        bybitApiService.insLoanEnsureTokens(productId).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void insLoanRepayLoan(RepayLoanRequest repayLoanRequest, BybitApiCallback<Object> callback) {
        bybitApiService.insLoanRepayLoan(repayLoanRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }
}
