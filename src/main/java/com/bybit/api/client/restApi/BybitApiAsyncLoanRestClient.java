package com.bybit.api.client.restApi;

import com.bybit.api.client.domain.loan.request.CryptoLoanAdjustLtvRequest;
import com.bybit.api.client.domain.loan.request.CryptoLoanBorrowRequest;
import com.bybit.api.client.domain.loan.request.CryptoLoanDataRequest;
import com.bybit.api.client.domain.loan.request.CryptoLoanRepayRequest;
import com.bybit.api.client.domain.loan.request.AdjustLtvRequest;
import com.bybit.api.client.domain.loan.request.FlexibleBorrowRequest;
import com.bybit.api.client.domain.loan.request.MaxLoanRequest;
import com.bybit.api.client.domain.loan.request.PostCryptoLoanFixedBorrowOrderCancelRequest;
import com.bybit.api.client.domain.loan.request.PostCryptoLoanFixedBorrowRequest;
import com.bybit.api.client.domain.loan.request.PostCryptoLoanFixedFullyRepayRequest;
import com.bybit.api.client.domain.loan.request.PostCryptoLoanFixedRenewRequest;
import com.bybit.api.client.domain.loan.request.PostCryptoLoanFixedRepayCollateralRequest;
import com.bybit.api.client.domain.loan.request.PostCryptoLoanFixedSupplyOrderCancelRequest;
import com.bybit.api.client.domain.loan.request.PostCryptoLoanFixedSupplyRequest;
import com.bybit.api.client.domain.loan.request.PostCryptoLoanFlexibleRepayCollateralRequest;
import com.bybit.api.client.domain.loan.request.PostCryptoLoanFlexibleRepayRequest;

public interface BybitApiAsyncLoanRestClient {
    void getCollateralCoins(CryptoLoanDataRequest request, BybitApiCallback<Object> callback);
    void getBorrowableCoins(CryptoLoanDataRequest request, BybitApiCallback<Object> callback);
    void getAcctMortgageLoanLimit(CryptoLoanDataRequest request, BybitApiCallback<Object> callback);
    void borrow(CryptoLoanBorrowRequest request, BybitApiCallback<Object> callback);
    void repay(CryptoLoanRepayRequest request, BybitApiCallback<Object> callback);
    void adjustCollateralAmount(CryptoLoanAdjustLtvRequest request, BybitApiCallback<Object> callback);
    void getUnpaidOrders(CryptoLoanDataRequest request, BybitApiCallback<Object> callback);
    void getCompletedOrders(CryptoLoanDataRequest request, BybitApiCallback<Object> callback);
    void getRepayTransactions(CryptoLoanDataRequest request, BybitApiCallback<Object> callback);
    void getLtvAdjustmentHistory(CryptoLoanDataRequest request, BybitApiCallback<Object> callback);
    void getMaxReduceAmount(CryptoLoanDataRequest request, BybitApiCallback<Object> callback);

    default void postCryptoLoanCommonAdjustLtv(AdjustLtvRequest adjustLtvRequest, BybitApiCallback<Object> callback) {
        throw new UnsupportedOperationException("postCryptoLoanCommonAdjustLtv is not implemented by this client");
    }

    default void getCryptoLoanCommonAdjustmentHistory(String adjustId, String collateralCurrency, String limit, String cursor, BybitApiCallback<Object> callback) {
        throw new UnsupportedOperationException("getCryptoLoanCommonAdjustmentHistory is not implemented by this client");
    }

    default void getCryptoLoanCommonCollateralData(String currency, BybitApiCallback<Object> callback) {
        throw new UnsupportedOperationException("getCryptoLoanCommonCollateralData is not implemented by this client");
    }

    default void getCryptoLoanCommonLoanableData(String currency, String vipLevel, BybitApiCallback<Object> callback) {
        throw new UnsupportedOperationException("getCryptoLoanCommonLoanableData is not implemented by this client");
    }

    default void getCryptoLoanCommonMaxCollateralAmount(String currency, BybitApiCallback<Object> callback) {
        throw new UnsupportedOperationException("getCryptoLoanCommonMaxCollateralAmount is not implemented by this client");
    }

    default void postCryptoLoanCommonMaxLoan(MaxLoanRequest maxLoanRequest, BybitApiCallback<Object> callback) {
        throw new UnsupportedOperationException("postCryptoLoanCommonMaxLoan is not implemented by this client");
    }

    default void getCryptoLoanCommonPosition(BybitApiCallback<Object> callback) {
        throw new UnsupportedOperationException("getCryptoLoanCommonPosition is not implemented by this client");
    }

    default void getCryptoLoanFixedAvailableInventory(String currency, String term, String annualRate, BybitApiCallback<Object> callback) {
        throw new UnsupportedOperationException("getCryptoLoanFixedAvailableInventory is not implemented by this client");
    }

    default void getCryptoLoanFixedBorrowContractInfo(String orderId, String loanId, String orderCurrency, String term, String limit, String cursor, BybitApiCallback<Object> callback) {
        throw new UnsupportedOperationException("getCryptoLoanFixedBorrowContractInfo is not implemented by this client");
    }

    default void postCryptoLoanFixedBorrowOrderCancel(PostCryptoLoanFixedBorrowOrderCancelRequest postCryptoLoanFixedBorrowOrderCancelRequest, BybitApiCallback<Object> callback) {
        throw new UnsupportedOperationException("postCryptoLoanFixedBorrowOrderCancel is not implemented by this client");
    }

    default void getCryptoLoanFixedBorrowOrderInfo(String orderId, String orderCurrency, String state, String term, String limit, String cursor, BybitApiCallback<Object> callback) {
        throw new UnsupportedOperationException("getCryptoLoanFixedBorrowOrderInfo is not implemented by this client");
    }

    default void getCryptoLoanFixedBorrowOrderQuote(String orderCurrency, String term, String orderBy, Long sort, Integer limit, BybitApiCallback<Object> callback) {
        throw new UnsupportedOperationException("getCryptoLoanFixedBorrowOrderQuote is not implemented by this client");
    }

    default void postCryptoLoanFixedBorrow(PostCryptoLoanFixedBorrowRequest postCryptoLoanFixedBorrowRequest, BybitApiCallback<Object> callback) {
        throw new UnsupportedOperationException("postCryptoLoanFixedBorrow is not implemented by this client");
    }

    default void postCryptoLoanFixedFullyRepay(PostCryptoLoanFixedFullyRepayRequest postCryptoLoanFixedFullyRepayRequest, BybitApiCallback<Object> callback) {
        throw new UnsupportedOperationException("postCryptoLoanFixedFullyRepay is not implemented by this client");
    }

    default void getCryptoLoanFixedRenewInfo(String orderId, String orderCurrency, String limit, String cursor, BybitApiCallback<Object> callback) {
        throw new UnsupportedOperationException("getCryptoLoanFixedRenewInfo is not implemented by this client");
    }

    default void postCryptoLoanFixedRenew(PostCryptoLoanFixedRenewRequest postCryptoLoanFixedRenewRequest, BybitApiCallback<Object> callback) {
        throw new UnsupportedOperationException("postCryptoLoanFixedRenew is not implemented by this client");
    }

    default void postCryptoLoanFixedRepayCollateral(PostCryptoLoanFixedRepayCollateralRequest postCryptoLoanFixedRepayCollateralRequest, BybitApiCallback<Object> callback) {
        throw new UnsupportedOperationException("postCryptoLoanFixedRepayCollateral is not implemented by this client");
    }

    default void getCryptoLoanFixedRepaymentHistory(String repayId, String loanCurrency, String limit, String cursor, BybitApiCallback<Object> callback) {
        throw new UnsupportedOperationException("getCryptoLoanFixedRepaymentHistory is not implemented by this client");
    }

    default void getCryptoLoanFixedSupplyContractInfo(String orderId, String supplyId, String supplyCurrency, String term, String limit, String cursor, BybitApiCallback<Object> callback) {
        throw new UnsupportedOperationException("getCryptoLoanFixedSupplyContractInfo is not implemented by this client");
    }

    default void postCryptoLoanFixedSupplyOrderCancel(PostCryptoLoanFixedSupplyOrderCancelRequest postCryptoLoanFixedSupplyOrderCancelRequest, BybitApiCallback<Object> callback) {
        throw new UnsupportedOperationException("postCryptoLoanFixedSupplyOrderCancel is not implemented by this client");
    }

    default void getCryptoLoanFixedSupplyOrderInfo(String orderId, String orderCurrency, String state, String term, String limit, String cursor, BybitApiCallback<Object> callback) {
        throw new UnsupportedOperationException("getCryptoLoanFixedSupplyOrderInfo is not implemented by this client");
    }

    default void getCryptoLoanFixedSupplyOrderQuote(String orderCurrency, String term, String orderBy, Long sort, Integer limit, BybitApiCallback<Object> callback) {
        throw new UnsupportedOperationException("getCryptoLoanFixedSupplyOrderQuote is not implemented by this client");
    }

    default void postCryptoLoanFixedSupply(PostCryptoLoanFixedSupplyRequest postCryptoLoanFixedSupplyRequest, BybitApiCallback<Object> callback) {
        throw new UnsupportedOperationException("postCryptoLoanFixedSupply is not implemented by this client");
    }

    default void getCryptoLoanFlexibleAvailableInventory(String currency, BybitApiCallback<Object> callback) {
        throw new UnsupportedOperationException("getCryptoLoanFlexibleAvailableInventory is not implemented by this client");
    }

    default void getCryptoLoanFlexibleBorrowHistory(String orderId, String loanCurrency, String limit, String cursor, BybitApiCallback<Object> callback) {
        throw new UnsupportedOperationException("getCryptoLoanFlexibleBorrowHistory is not implemented by this client");
    }

    default void postCryptoLoanFlexibleBorrow(FlexibleBorrowRequest flexibleBorrowRequest, BybitApiCallback<Object> callback) {
        throw new UnsupportedOperationException("postCryptoLoanFlexibleBorrow is not implemented by this client");
    }

    default void getCryptoLoanFlexibleOngoingCoin(String loanCurrency, BybitApiCallback<Object> callback) {
        throw new UnsupportedOperationException("getCryptoLoanFlexibleOngoingCoin is not implemented by this client");
    }

    default void postCryptoLoanFlexibleRepayCollateral(PostCryptoLoanFlexibleRepayCollateralRequest postCryptoLoanFlexibleRepayCollateralRequest, BybitApiCallback<Object> callback) {
        throw new UnsupportedOperationException("postCryptoLoanFlexibleRepayCollateral is not implemented by this client");
    }

    default void postCryptoLoanFlexibleRepay(PostCryptoLoanFlexibleRepayRequest postCryptoLoanFlexibleRepayRequest, BybitApiCallback<Object> callback) {
        throw new UnsupportedOperationException("postCryptoLoanFlexibleRepay is not implemented by this client");
    }

    default void getCryptoLoanFlexibleRepaymentHistory(String repayId, String loanCurrency, String limit, String cursor, BybitApiCallback<Object> callback) {
        throw new UnsupportedOperationException("getCryptoLoanFlexibleRepaymentHistory is not implemented by this client");
    }
}
