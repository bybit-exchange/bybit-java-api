package com.bybit.api.client.impl;

import com.bybit.api.client.domain.loan.request.CryptoLoanAdjustLtvRequest;
import com.bybit.api.client.domain.loan.request.CryptoLoanBorrowRequest;
import com.bybit.api.client.domain.loan.request.CryptoLoanDataRequest;
import com.bybit.api.client.domain.loan.request.CryptoLoanRepayRequest;
import com.bybit.api.client.restApi.BybitApiAsyncLoanRestClient;
import com.bybit.api.client.restApi.BybitApiCallback;
import com.bybit.api.client.restApi.BybitApiLoanRestClient;
import com.bybit.api.client.restApi.BybitApiService;
import com.bybit.api.client.service.BybitJsonConverter;

import static com.bybit.api.client.service.BybitApiServiceGenerator.createService;
import static com.bybit.api.client.service.BybitApiServiceGenerator.executeSync;
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

public class BybitApiAsyncLoanRestClientImpl implements BybitApiAsyncLoanRestClient {
    private final BybitApiService bybitApiService;
    private final BybitJsonConverter converter = new BybitJsonConverter();

    public BybitApiAsyncLoanRestClientImpl(String apiKey, String secret, String baseUrl, boolean debugMode, long recvWindow, String logOption) {
        bybitApiService = createService(BybitApiService.class, apiKey, secret, baseUrl, debugMode, recvWindow, logOption, "");
    }

    @Override
    public void getCollateralCoins(CryptoLoanDataRequest request, BybitApiCallback<Object> callback) {
        bybitApiService.getCollateralCoins(
                request.getVipLevel() == null ? null : request.getVipLevel().getLevel(),
                request.getCurrency()
        ).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getBorrowableCoins(CryptoLoanDataRequest request, BybitApiCallback<Object> callback) {
        bybitApiService.getBorrowableCoins(
                request.getVipLevel() == null ? null : request.getVipLevel().getLevel(),
                request.getCurrency()
        ).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getAcctMortgageLoanLimit(CryptoLoanDataRequest request, BybitApiCallback<Object> callback) {
        bybitApiService.getAcctMortgageLoanLimit(
                request.getLoanCurrency(),
                request.getCollateralCurrency()
        ).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void borrow(CryptoLoanBorrowRequest borrowRequest, BybitApiCallback<Object> callback) {
        var request = converter.mapToCryptoLoanBorrowRequest(borrowRequest);
        bybitApiService.borrow(request).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void repay(CryptoLoanRepayRequest repayRequest, BybitApiCallback<Object> callback) {
        var request = converter.mapToCryptoLoanRepayRequest(repayRequest);
        bybitApiService.repay(request).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void adjustCollateralAmount(CryptoLoanAdjustLtvRequest adjustLtvRequest, BybitApiCallback<Object> callback) {
        var request = converter.mapToCryptoLoanAdjustLtvRequest(adjustLtvRequest);
        bybitApiService.adjustCollateralAmount(request).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getUnpaidOrders(CryptoLoanDataRequest request, BybitApiCallback<Object> callback) {
        bybitApiService.getUnpaidOrders(
                request.getOrderId(),
                request.getCollateralCurrency(),
                request.getLoanCurrency(),
                request.getLoanTermType() == null ? null : request.getLoanTermType().getTermType(),
                request.getLoanTerm() == null ? null : request.getLoanTerm().getTerm(),
                request.getLimit(),
                request.getCursor()
        ).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getCompletedOrders(CryptoLoanDataRequest request, BybitApiCallback<Object> callback) {
        bybitApiService.getCompletedOrders(
                request.getOrderId(),
                request.getCollateralCurrency(),
                request.getLoanCurrency(),
                request.getLimit(),
                request.getCursor()
        ).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getRepayTransactions(CryptoLoanDataRequest request, BybitApiCallback<Object> callback) {
        bybitApiService.getRepayTransactions(
                request.getOrderId(),
                request.getRepayId(),
                request.getLoanCurrency(),
                request.getLimit(),
                request.getCursor()
        ).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getLtvAdjustmentHistory(CryptoLoanDataRequest request, BybitApiCallback<Object> callback) {
        bybitApiService.getLtvAdjustmentHistory(
                request.getOrderId(),
                request.getAdjustId(),
                request.getCollateralCurrency(),
                request.getLimit(),
                request.getCursor()
        ).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getMaxReduceAmount(CryptoLoanDataRequest request, BybitApiCallback<Object> callback) {
        bybitApiService.getMaxReduceAmount(
                request.getOrderId()
        ).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void postCryptoLoanCommonAdjustLtv(AdjustLtvRequest adjustLtvRequest, BybitApiCallback<Object> callback) {
        bybitApiService.postCryptoLoanCommonAdjustLtv(adjustLtvRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getCryptoLoanCommonAdjustmentHistory(String adjustId, String collateralCurrency, String limit, String cursor, BybitApiCallback<Object> callback) {
        bybitApiService.getCryptoLoanCommonAdjustmentHistory(adjustId, collateralCurrency, limit, cursor).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getCryptoLoanCommonCollateralData(String currency, BybitApiCallback<Object> callback) {
        bybitApiService.getCryptoLoanCommonCollateralData(currency).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getCryptoLoanCommonLoanableData(String currency, String vipLevel, BybitApiCallback<Object> callback) {
        bybitApiService.getCryptoLoanCommonLoanableData(currency, vipLevel).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getCryptoLoanCommonMaxCollateralAmount(String currency, BybitApiCallback<Object> callback) {
        bybitApiService.getCryptoLoanCommonMaxCollateralAmount(currency).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void postCryptoLoanCommonMaxLoan(MaxLoanRequest maxLoanRequest, BybitApiCallback<Object> callback) {
        bybitApiService.postCryptoLoanCommonMaxLoan(maxLoanRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getCryptoLoanCommonPosition(BybitApiCallback<Object> callback) {
        bybitApiService.getCryptoLoanCommonPosition().enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getCryptoLoanFixedAvailableInventory(String currency, String term, String annualRate, BybitApiCallback<Object> callback) {
        bybitApiService.getCryptoLoanFixedAvailableInventory(currency, term, annualRate).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getCryptoLoanFixedBorrowContractInfo(String orderId, String loanId, String orderCurrency, String term, String limit, String cursor, BybitApiCallback<Object> callback) {
        bybitApiService.getCryptoLoanFixedBorrowContractInfo(orderId, loanId, orderCurrency, term, limit, cursor).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void postCryptoLoanFixedBorrowOrderCancel(PostCryptoLoanFixedBorrowOrderCancelRequest postCryptoLoanFixedBorrowOrderCancelRequest, BybitApiCallback<Object> callback) {
        bybitApiService.postCryptoLoanFixedBorrowOrderCancel(postCryptoLoanFixedBorrowOrderCancelRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getCryptoLoanFixedBorrowOrderInfo(String orderId, String orderCurrency, String state, String term, String limit, String cursor, BybitApiCallback<Object> callback) {
        bybitApiService.getCryptoLoanFixedBorrowOrderInfo(orderId, orderCurrency, state, term, limit, cursor).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getCryptoLoanFixedBorrowOrderQuote(String orderCurrency, String term, String orderBy, Long sort, Integer limit, BybitApiCallback<Object> callback) {
        bybitApiService.getCryptoLoanFixedBorrowOrderQuote(orderCurrency, term, orderBy, sort, limit).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void postCryptoLoanFixedBorrow(PostCryptoLoanFixedBorrowRequest postCryptoLoanFixedBorrowRequest, BybitApiCallback<Object> callback) {
        bybitApiService.postCryptoLoanFixedBorrow(postCryptoLoanFixedBorrowRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void postCryptoLoanFixedFullyRepay(PostCryptoLoanFixedFullyRepayRequest postCryptoLoanFixedFullyRepayRequest, BybitApiCallback<Object> callback) {
        bybitApiService.postCryptoLoanFixedFullyRepay(postCryptoLoanFixedFullyRepayRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getCryptoLoanFixedRenewInfo(String orderId, String orderCurrency, String limit, String cursor, BybitApiCallback<Object> callback) {
        bybitApiService.getCryptoLoanFixedRenewInfo(orderId, orderCurrency, limit, cursor).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void postCryptoLoanFixedRenew(PostCryptoLoanFixedRenewRequest postCryptoLoanFixedRenewRequest, BybitApiCallback<Object> callback) {
        bybitApiService.postCryptoLoanFixedRenew(postCryptoLoanFixedRenewRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void postCryptoLoanFixedRepayCollateral(PostCryptoLoanFixedRepayCollateralRequest postCryptoLoanFixedRepayCollateralRequest, BybitApiCallback<Object> callback) {
        bybitApiService.postCryptoLoanFixedRepayCollateral(postCryptoLoanFixedRepayCollateralRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getCryptoLoanFixedRepaymentHistory(String repayId, String loanCurrency, String limit, String cursor, BybitApiCallback<Object> callback) {
        bybitApiService.getCryptoLoanFixedRepaymentHistory(repayId, loanCurrency, limit, cursor).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getCryptoLoanFixedSupplyContractInfo(String orderId, String supplyId, String supplyCurrency, String term, String limit, String cursor, BybitApiCallback<Object> callback) {
        bybitApiService.getCryptoLoanFixedSupplyContractInfo(orderId, supplyId, supplyCurrency, term, limit, cursor).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void postCryptoLoanFixedSupplyOrderCancel(PostCryptoLoanFixedSupplyOrderCancelRequest postCryptoLoanFixedSupplyOrderCancelRequest, BybitApiCallback<Object> callback) {
        bybitApiService.postCryptoLoanFixedSupplyOrderCancel(postCryptoLoanFixedSupplyOrderCancelRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getCryptoLoanFixedSupplyOrderInfo(String orderId, String orderCurrency, String state, String term, String limit, String cursor, BybitApiCallback<Object> callback) {
        bybitApiService.getCryptoLoanFixedSupplyOrderInfo(orderId, orderCurrency, state, term, limit, cursor).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getCryptoLoanFixedSupplyOrderQuote(String orderCurrency, String term, String orderBy, Long sort, Integer limit, BybitApiCallback<Object> callback) {
        bybitApiService.getCryptoLoanFixedSupplyOrderQuote(orderCurrency, term, orderBy, sort, limit).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void postCryptoLoanFixedSupply(PostCryptoLoanFixedSupplyRequest postCryptoLoanFixedSupplyRequest, BybitApiCallback<Object> callback) {
        bybitApiService.postCryptoLoanFixedSupply(postCryptoLoanFixedSupplyRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getCryptoLoanFlexibleAvailableInventory(String currency, BybitApiCallback<Object> callback) {
        bybitApiService.getCryptoLoanFlexibleAvailableInventory(currency).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getCryptoLoanFlexibleBorrowHistory(String orderId, String loanCurrency, String limit, String cursor, BybitApiCallback<Object> callback) {
        bybitApiService.getCryptoLoanFlexibleBorrowHistory(orderId, loanCurrency, limit, cursor).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void postCryptoLoanFlexibleBorrow(FlexibleBorrowRequest flexibleBorrowRequest, BybitApiCallback<Object> callback) {
        bybitApiService.postCryptoLoanFlexibleBorrow(flexibleBorrowRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getCryptoLoanFlexibleOngoingCoin(String loanCurrency, BybitApiCallback<Object> callback) {
        bybitApiService.getCryptoLoanFlexibleOngoingCoin(loanCurrency).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void postCryptoLoanFlexibleRepayCollateral(PostCryptoLoanFlexibleRepayCollateralRequest postCryptoLoanFlexibleRepayCollateralRequest, BybitApiCallback<Object> callback) {
        bybitApiService.postCryptoLoanFlexibleRepayCollateral(postCryptoLoanFlexibleRepayCollateralRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void postCryptoLoanFlexibleRepay(PostCryptoLoanFlexibleRepayRequest postCryptoLoanFlexibleRepayRequest, BybitApiCallback<Object> callback) {
        bybitApiService.postCryptoLoanFlexibleRepay(postCryptoLoanFlexibleRepayRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getCryptoLoanFlexibleRepaymentHistory(String repayId, String loanCurrency, String limit, String cursor, BybitApiCallback<Object> callback) {
        bybitApiService.getCryptoLoanFlexibleRepaymentHistory(repayId, loanCurrency, limit, cursor).enqueue(new BybitApiCallbackAdapter<>(callback));
    }
}
