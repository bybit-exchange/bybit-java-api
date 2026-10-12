package com.bybit.api.client.restApi;

import com.bybit.api.client.domain.institution.LendingDataRequest;
import com.bybit.api.client.domain.institution.insLending.RepayLoanRequest;

public interface BybitApiAsyncLendingRestClient {
    // Institution Endpoints
    void getInsProductInfo(LendingDataRequest lendingDataRequest, BybitApiCallback<Object> callback);
    void getInsMarginCoinInfo(LendingDataRequest lendingDataRequest, BybitApiCallback<Object> callback);
    void getInsLoanOrders(LendingDataRequest institutionLoanOrdersRequest, BybitApiCallback<Object> callback);
    void getInsRepayOrders(LendingDataRequest institutionRepayOrdersRequest, BybitApiCallback<Object> callback);
    void getInsLoanToValue(BybitApiCallback<Object> callback);
    void updateInstitutionLoanUid(LendingDataRequest lendingDataRequest, BybitApiCallback<Object> callback);

    // C2C Endpoints
/*    void getC2CLendingCoinInfo(LendingDataRequest lendingDataRequest, BybitApiCallback<Object> callback);
    void C2cLendingDepositFunds(LendingDataRequest lendingDataRequest, BybitApiCallback<Object> callback);
    void C2cLendingRedeemFunds(LendingDataRequest lendingDataRequest, BybitApiCallback<Object> callback);
    void C2cLendingRedeemCancel(LendingDataRequest lendingDataRequest, BybitApiCallback<Object> callback);
    void getC2cOrdersRecords(LendingDataRequest lendingDataRequest, BybitApiCallback<Object> callback);
    void getC2CLendingAccountInfo(LendingDataRequest lendingDataRequest, BybitApiCallback<Object> callback);*/

    default void insLoanCoinDeltaAmount(String coin, BybitApiCallback<Object> callback) {
        throw new UnsupportedOperationException("insLoanCoinDeltaAmount is not implemented by this client");
    }

    default void insLoanDelayLiqStatus(BybitApiCallback<Object> callback) {
        throw new UnsupportedOperationException("insLoanDelayLiqStatus is not implemented by this client");
    }

    default void insLoanEnsureTokens(String productId, BybitApiCallback<Object> callback) {
        throw new UnsupportedOperationException("insLoanEnsureTokens is not implemented by this client");
    }

    default void insLoanRepayLoan(RepayLoanRequest repayLoanRequest, BybitApiCallback<Object> callback) {
        throw new UnsupportedOperationException("insLoanRepayLoan is not implemented by this client");
    }
}
