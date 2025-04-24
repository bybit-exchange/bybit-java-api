package com.bybit.api.client.restApi;

import com.bybit.api.client.domain.GenericResponse;
import com.bybit.api.client.domain.account.request.AccountDataRequest;
import com.bybit.api.client.domain.account.request.BatchSetCollateralCoinRequest;
import com.bybit.api.client.domain.account.response.WalletBalanceResponse;

public interface BybitApiAccountRestClient {
    // Account endpoints
    GenericResponse<WalletBalanceResponse> getWalletBalance(AccountDataRequest walletBalanceRequest);
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
}
