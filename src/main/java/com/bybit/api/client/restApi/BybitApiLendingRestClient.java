package com.bybit.api.client.restApi;

import com.bybit.api.client.domain.institution.LendingDataRequest;
import com.bybit.api.client.domain.institution.clientLending.ClientLendingFundsRequest;
import com.bybit.api.client.domain.institution.clientLending.ClientLendingOrderRecordsRequest;
import com.bybit.api.client.domain.institution.insLending.RepayLoanRequest;

public interface BybitApiLendingRestClient {
    // Institution Endpoints
    Object getInsProductInfo(LendingDataRequest lendingDataRequest);
    Object getInsMarginCoinInfo(LendingDataRequest lendingDataRequest);
    Object getInsLoanOrders(LendingDataRequest lendingDataRequest);
    Object getInsRepayOrders(LendingDataRequest lendingDataRequest);
    Object getInsLoanToValue();
    Object updateInstitutionLoanUid(LendingDataRequest lendingDataRequest);
    // C2C Endpoints
/*    Object getC2CLendingCoinInfo(LendingDataRequest lendingDataRequest);
    Object C2cLendingDepositFunds(LendingDataRequest lendingDataRequest);
    Object C2cLendingRedeemFunds(LendingDataRequest lendingDataRequest);
    Object C2cLendingRedeemCancel(LendingDataRequest lendingDataRequest);
    Object getC2cOrdersRecords(LendingDataRequest lendingDataRequest);
    Object getC2CLendingAccountInfo(LendingDataRequest lendingDataRequest);*/

    Object insLoanCoinDeltaAmount(String coin);

    Object insLoanDelayLiqStatus();

    Object insLoanEnsureTokens(String productId);

    Object insLoanRepayLoan(RepayLoanRequest repayLoanRequest);
}
