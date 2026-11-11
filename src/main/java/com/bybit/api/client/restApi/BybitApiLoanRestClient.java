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

public interface BybitApiLoanRestClient {
    Object getCollateralCoins(CryptoLoanDataRequest request);
    Object getBorrowableCoins(CryptoLoanDataRequest request);
    Object getAcctMortgageLoanLimit(CryptoLoanDataRequest request);
    Object borrow(CryptoLoanBorrowRequest borrowRequest);
    Object repay(CryptoLoanRepayRequest repayRequest);
    Object adjustCollateralAmount(CryptoLoanAdjustLtvRequest adjustLtvRequest);
    Object getUnpaidOrders(CryptoLoanDataRequest request);
    Object getCompletedOrders(CryptoLoanDataRequest request);
    Object getRepayTransactions(CryptoLoanDataRequest request);
    Object getLtvAdjustmentHistory(CryptoLoanDataRequest request);
    Object getMaxReduceAmount(CryptoLoanDataRequest request);

    default Object postCryptoLoanCommonAdjustLtv(AdjustLtvRequest adjustLtvRequest) {
        throw new UnsupportedOperationException("postCryptoLoanCommonAdjustLtv is not implemented by this client");
    }

    default Object getCryptoLoanCommonAdjustmentHistory(String adjustId, String collateralCurrency, String limit, String cursor) {
        throw new UnsupportedOperationException("getCryptoLoanCommonAdjustmentHistory is not implemented by this client");
    }

    default Object getCryptoLoanCommonCollateralData(String currency) {
        throw new UnsupportedOperationException("getCryptoLoanCommonCollateralData is not implemented by this client");
    }

    default Object getCryptoLoanCommonLoanableData(String currency, String vipLevel) {
        throw new UnsupportedOperationException("getCryptoLoanCommonLoanableData is not implemented by this client");
    }

    default Object getCryptoLoanCommonMaxCollateralAmount(String currency) {
        throw new UnsupportedOperationException("getCryptoLoanCommonMaxCollateralAmount is not implemented by this client");
    }

    default Object postCryptoLoanCommonMaxLoan(MaxLoanRequest maxLoanRequest) {
        throw new UnsupportedOperationException("postCryptoLoanCommonMaxLoan is not implemented by this client");
    }

    default Object getCryptoLoanCommonPosition() {
        throw new UnsupportedOperationException("getCryptoLoanCommonPosition is not implemented by this client");
    }

    default Object getCryptoLoanFixedAvailableInventory(String currency, String term, String annualRate) {
        throw new UnsupportedOperationException("getCryptoLoanFixedAvailableInventory is not implemented by this client");
    }

    default Object getCryptoLoanFixedBorrowContractInfo(String orderId, String loanId, String orderCurrency, String term, String limit, String cursor) {
        throw new UnsupportedOperationException("getCryptoLoanFixedBorrowContractInfo is not implemented by this client");
    }

    default Object postCryptoLoanFixedBorrowOrderCancel(PostCryptoLoanFixedBorrowOrderCancelRequest postCryptoLoanFixedBorrowOrderCancelRequest) {
        throw new UnsupportedOperationException("postCryptoLoanFixedBorrowOrderCancel is not implemented by this client");
    }

    default Object getCryptoLoanFixedBorrowOrderInfo(String orderId, String orderCurrency, String state, String term, String limit, String cursor) {
        throw new UnsupportedOperationException("getCryptoLoanFixedBorrowOrderInfo is not implemented by this client");
    }

    default Object getCryptoLoanFixedBorrowOrderQuote(String orderCurrency, String term, String orderBy, Long sort, Integer limit) {
        throw new UnsupportedOperationException("getCryptoLoanFixedBorrowOrderQuote is not implemented by this client");
    }

    default Object postCryptoLoanFixedBorrow(PostCryptoLoanFixedBorrowRequest postCryptoLoanFixedBorrowRequest) {
        throw new UnsupportedOperationException("postCryptoLoanFixedBorrow is not implemented by this client");
    }

    default Object postCryptoLoanFixedFullyRepay(PostCryptoLoanFixedFullyRepayRequest postCryptoLoanFixedFullyRepayRequest) {
        throw new UnsupportedOperationException("postCryptoLoanFixedFullyRepay is not implemented by this client");
    }

    default Object getCryptoLoanFixedRenewInfo(String orderId, String orderCurrency, String limit, String cursor) {
        throw new UnsupportedOperationException("getCryptoLoanFixedRenewInfo is not implemented by this client");
    }

    default Object postCryptoLoanFixedRenew(PostCryptoLoanFixedRenewRequest postCryptoLoanFixedRenewRequest) {
        throw new UnsupportedOperationException("postCryptoLoanFixedRenew is not implemented by this client");
    }

    default Object postCryptoLoanFixedRepayCollateral(PostCryptoLoanFixedRepayCollateralRequest postCryptoLoanFixedRepayCollateralRequest) {
        throw new UnsupportedOperationException("postCryptoLoanFixedRepayCollateral is not implemented by this client");
    }

    default Object getCryptoLoanFixedRepaymentHistory(String repayId, String loanCurrency, String limit, String cursor) {
        throw new UnsupportedOperationException("getCryptoLoanFixedRepaymentHistory is not implemented by this client");
    }

    default Object getCryptoLoanFixedSupplyContractInfo(String orderId, String supplyId, String supplyCurrency, String term, String limit, String cursor) {
        throw new UnsupportedOperationException("getCryptoLoanFixedSupplyContractInfo is not implemented by this client");
    }

    default Object postCryptoLoanFixedSupplyOrderCancel(PostCryptoLoanFixedSupplyOrderCancelRequest postCryptoLoanFixedSupplyOrderCancelRequest) {
        throw new UnsupportedOperationException("postCryptoLoanFixedSupplyOrderCancel is not implemented by this client");
    }

    default Object getCryptoLoanFixedSupplyOrderInfo(String orderId, String orderCurrency, String state, String term, String limit, String cursor) {
        throw new UnsupportedOperationException("getCryptoLoanFixedSupplyOrderInfo is not implemented by this client");
    }

    default Object getCryptoLoanFixedSupplyOrderQuote(String orderCurrency, String term, String orderBy, Long sort, Integer limit) {
        throw new UnsupportedOperationException("getCryptoLoanFixedSupplyOrderQuote is not implemented by this client");
    }

    default Object postCryptoLoanFixedSupply(PostCryptoLoanFixedSupplyRequest postCryptoLoanFixedSupplyRequest) {
        throw new UnsupportedOperationException("postCryptoLoanFixedSupply is not implemented by this client");
    }

    default Object getCryptoLoanFlexibleAvailableInventory(String currency) {
        throw new UnsupportedOperationException("getCryptoLoanFlexibleAvailableInventory is not implemented by this client");
    }

    default Object getCryptoLoanFlexibleBorrowHistory(String orderId, String loanCurrency, String limit, String cursor) {
        throw new UnsupportedOperationException("getCryptoLoanFlexibleBorrowHistory is not implemented by this client");
    }

    default Object postCryptoLoanFlexibleBorrow(FlexibleBorrowRequest flexibleBorrowRequest) {
        throw new UnsupportedOperationException("postCryptoLoanFlexibleBorrow is not implemented by this client");
    }

    default Object getCryptoLoanFlexibleOngoingCoin(String loanCurrency) {
        throw new UnsupportedOperationException("getCryptoLoanFlexibleOngoingCoin is not implemented by this client");
    }

    default Object postCryptoLoanFlexibleRepayCollateral(PostCryptoLoanFlexibleRepayCollateralRequest postCryptoLoanFlexibleRepayCollateralRequest) {
        throw new UnsupportedOperationException("postCryptoLoanFlexibleRepayCollateral is not implemented by this client");
    }

    default Object postCryptoLoanFlexibleRepay(PostCryptoLoanFlexibleRepayRequest postCryptoLoanFlexibleRepayRequest) {
        throw new UnsupportedOperationException("postCryptoLoanFlexibleRepay is not implemented by this client");
    }

    default Object getCryptoLoanFlexibleRepaymentHistory(String repayId, String loanCurrency, String limit, String cursor) {
        throw new UnsupportedOperationException("getCryptoLoanFlexibleRepaymentHistory is not implemented by this client");
    }
}
