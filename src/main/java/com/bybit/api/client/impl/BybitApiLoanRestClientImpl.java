package com.bybit.api.client.impl;

import com.bybit.api.client.domain.loan.request.CryptoLoanAdjustLtvRequest;
import com.bybit.api.client.domain.loan.request.CryptoLoanBorrowRequest;
import com.bybit.api.client.domain.loan.request.CryptoLoanDataRequest;
import com.bybit.api.client.domain.loan.request.CryptoLoanRepayRequest;
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

public class BybitApiLoanRestClientImpl implements BybitApiLoanRestClient {
    private final BybitApiService bybitApiService;
    private final BybitJsonConverter converter = new BybitJsonConverter();

    public BybitApiLoanRestClientImpl(String apiKey, String secret, String baseUrl, boolean debugMode, long recvWindow, String logOption) {
        bybitApiService = createService(BybitApiService.class, apiKey, secret, baseUrl, debugMode, recvWindow, logOption, "");
    }

    @Override
    public Object getCollateralCoins(CryptoLoanDataRequest request) {
        return executeSync(bybitApiService.getCollateralCoins(
                request.getVipLevel() == null ? null : request.getVipLevel().getLevel(),
                request.getCurrency()
        ));
    }

    @Override
    public Object getBorrowableCoins(CryptoLoanDataRequest request) {
        return executeSync(bybitApiService.getBorrowableCoins(
                request.getVipLevel() == null ? null : request.getVipLevel().getLevel(),
                request.getCurrency()
        ));
    }

    @Override
    public Object getAcctMortgageLoanLimit(CryptoLoanDataRequest request) {
        return executeSync(bybitApiService.getAcctMortgageLoanLimit(
                request.getLoanCurrency(),
                request.getCollateralCurrency()
        ));
    }

    @Override
    public Object borrow(CryptoLoanBorrowRequest borrowRequest) {
        var request = converter.mapToCryptoLoanBorrowRequest(borrowRequest);
        return executeSync(bybitApiService.borrow(request));
    }

    @Override
    public Object repay(CryptoLoanRepayRequest repayRequest) {
        var request = converter.mapToCryptoLoanRepayRequest(repayRequest);
        return executeSync(bybitApiService.repay(request));
    }

    @Override
    public Object adjustCollateralAmount(CryptoLoanAdjustLtvRequest adjustLtvRequest) {
        var request = converter.mapToCryptoLoanAdjustLtvRequest(adjustLtvRequest);
        return executeSync(bybitApiService.adjustCollateralAmount(request));
    }

    @Override
    public Object getUnpaidOrders(CryptoLoanDataRequest request) {
        return executeSync(bybitApiService.getUnpaidOrders(
                request.getOrderId(),
                request.getLoanCurrency(),
                request.getCollateralCurrency(),
                request.getLoanTermType() == null ? null : request.getLoanTermType().getTermType(),
                request.getLoanTerm() == null ? null : request.getLoanTerm().getTerm(),
                request.getLimit(),
                request.getCursor()
        ));
    }

    @Override
    public Object getCompletedOrders(CryptoLoanDataRequest request) {
        return executeSync(bybitApiService.getCompletedOrders(
                request.getOrderId(),
                request.getCollateralCurrency(),
                request.getLoanCurrency(),
                request.getLimit(),
                request.getCursor()
        ));
    }

    @Override
    public Object getRepayTransactions(CryptoLoanDataRequest request) {
        return executeSync(bybitApiService.getRepayTransactions(
                request.getOrderId(),
                request.getRepayId(),
                request.getLoanCurrency(),
                request.getLimit(),
                request.getCursor()
        ));
    }

    @Override
    public Object getLtvAdjustmentHistory(CryptoLoanDataRequest request) {
        return executeSync(bybitApiService.getLtvAdjustmentHistory(
                request.getOrderId(),
                request.getAdjustId(),
                request.getCollateralCurrency(),
                request.getLimit(),
                request.getCursor()
        ));
    }

    @Override
    public Object getMaxReduceAmount(CryptoLoanDataRequest request) {
        return executeSync(bybitApiService.getMaxReduceAmount(
                request.getOrderId()
        ));
    }

    @Override
    public Object postCryptoLoanCommonAdjustLtv(AdjustLtvRequest adjustLtvRequest) {
        return executeSync(bybitApiService.postCryptoLoanCommonAdjustLtv(adjustLtvRequest));
    }

    @Override
    public Object getCryptoLoanCommonAdjustmentHistory(String adjustId, String collateralCurrency, String limit, String cursor) {
        return executeSync(bybitApiService.getCryptoLoanCommonAdjustmentHistory(adjustId, collateralCurrency, limit, cursor));
    }

    @Override
    public Object getCryptoLoanCommonCollateralData(String currency) {
        return executeSync(bybitApiService.getCryptoLoanCommonCollateralData(currency));
    }

    @Override
    public Object getCryptoLoanCommonLoanableData(String currency, String vipLevel) {
        return executeSync(bybitApiService.getCryptoLoanCommonLoanableData(currency, vipLevel));
    }

    @Override
    public Object getCryptoLoanCommonMaxCollateralAmount(String currency) {
        return executeSync(bybitApiService.getCryptoLoanCommonMaxCollateralAmount(currency));
    }

    @Override
    public Object postCryptoLoanCommonMaxLoan(MaxLoanRequest maxLoanRequest) {
        return executeSync(bybitApiService.postCryptoLoanCommonMaxLoan(maxLoanRequest));
    }

    @Override
    public Object getCryptoLoanCommonPosition() {
        return executeSync(bybitApiService.getCryptoLoanCommonPosition());
    }

    @Override
    public Object getCryptoLoanFixedAvailableInventory(String currency, String term, String annualRate) {
        return executeSync(bybitApiService.getCryptoLoanFixedAvailableInventory(currency, term, annualRate));
    }

    @Override
    public Object getCryptoLoanFixedBorrowContractInfo(String orderId, String loanId, String orderCurrency, String term, String limit, String cursor) {
        return executeSync(bybitApiService.getCryptoLoanFixedBorrowContractInfo(orderId, loanId, orderCurrency, term, limit, cursor));
    }

    @Override
    public Object postCryptoLoanFixedBorrowOrderCancel(PostCryptoLoanFixedBorrowOrderCancelRequest postCryptoLoanFixedBorrowOrderCancelRequest) {
        return executeSync(bybitApiService.postCryptoLoanFixedBorrowOrderCancel(postCryptoLoanFixedBorrowOrderCancelRequest));
    }

    @Override
    public Object getCryptoLoanFixedBorrowOrderInfo(String orderId, String orderCurrency, String state, String term, String limit, String cursor) {
        return executeSync(bybitApiService.getCryptoLoanFixedBorrowOrderInfo(orderId, orderCurrency, state, term, limit, cursor));
    }

    @Override
    public Object getCryptoLoanFixedBorrowOrderQuote(String orderCurrency, String term, String orderBy, Long sort, Integer limit) {
        return executeSync(bybitApiService.getCryptoLoanFixedBorrowOrderQuote(orderCurrency, term, orderBy, sort, limit));
    }

    @Override
    public Object postCryptoLoanFixedBorrow(PostCryptoLoanFixedBorrowRequest postCryptoLoanFixedBorrowRequest) {
        return executeSync(bybitApiService.postCryptoLoanFixedBorrow(postCryptoLoanFixedBorrowRequest));
    }

    @Override
    public Object postCryptoLoanFixedFullyRepay(PostCryptoLoanFixedFullyRepayRequest postCryptoLoanFixedFullyRepayRequest) {
        return executeSync(bybitApiService.postCryptoLoanFixedFullyRepay(postCryptoLoanFixedFullyRepayRequest));
    }

    @Override
    public Object getCryptoLoanFixedRenewInfo(String orderId, String orderCurrency, String limit, String cursor) {
        return executeSync(bybitApiService.getCryptoLoanFixedRenewInfo(orderId, orderCurrency, limit, cursor));
    }

    @Override
    public Object postCryptoLoanFixedRenew(PostCryptoLoanFixedRenewRequest postCryptoLoanFixedRenewRequest) {
        return executeSync(bybitApiService.postCryptoLoanFixedRenew(postCryptoLoanFixedRenewRequest));
    }

    @Override
    public Object postCryptoLoanFixedRepayCollateral(PostCryptoLoanFixedRepayCollateralRequest postCryptoLoanFixedRepayCollateralRequest) {
        return executeSync(bybitApiService.postCryptoLoanFixedRepayCollateral(postCryptoLoanFixedRepayCollateralRequest));
    }

    @Override
    public Object getCryptoLoanFixedRepaymentHistory(String repayId, String loanCurrency, String limit, String cursor) {
        return executeSync(bybitApiService.getCryptoLoanFixedRepaymentHistory(repayId, loanCurrency, limit, cursor));
    }

    @Override
    public Object getCryptoLoanFixedSupplyContractInfo(String orderId, String supplyId, String supplyCurrency, String term, String limit, String cursor) {
        return executeSync(bybitApiService.getCryptoLoanFixedSupplyContractInfo(orderId, supplyId, supplyCurrency, term, limit, cursor));
    }

    @Override
    public Object postCryptoLoanFixedSupplyOrderCancel(PostCryptoLoanFixedSupplyOrderCancelRequest postCryptoLoanFixedSupplyOrderCancelRequest) {
        return executeSync(bybitApiService.postCryptoLoanFixedSupplyOrderCancel(postCryptoLoanFixedSupplyOrderCancelRequest));
    }

    @Override
    public Object getCryptoLoanFixedSupplyOrderInfo(String orderId, String orderCurrency, String state, String term, String limit, String cursor) {
        return executeSync(bybitApiService.getCryptoLoanFixedSupplyOrderInfo(orderId, orderCurrency, state, term, limit, cursor));
    }

    @Override
    public Object getCryptoLoanFixedSupplyOrderQuote(String orderCurrency, String term, String orderBy, Long sort, Integer limit) {
        return executeSync(bybitApiService.getCryptoLoanFixedSupplyOrderQuote(orderCurrency, term, orderBy, sort, limit));
    }

    @Override
    public Object postCryptoLoanFixedSupply(PostCryptoLoanFixedSupplyRequest postCryptoLoanFixedSupplyRequest) {
        return executeSync(bybitApiService.postCryptoLoanFixedSupply(postCryptoLoanFixedSupplyRequest));
    }

    @Override
    public Object getCryptoLoanFlexibleAvailableInventory(String currency) {
        return executeSync(bybitApiService.getCryptoLoanFlexibleAvailableInventory(currency));
    }

    @Override
    public Object getCryptoLoanFlexibleBorrowHistory(String orderId, String loanCurrency, String limit, String cursor) {
        return executeSync(bybitApiService.getCryptoLoanFlexibleBorrowHistory(orderId, loanCurrency, limit, cursor));
    }

    @Override
    public Object postCryptoLoanFlexibleBorrow(FlexibleBorrowRequest flexibleBorrowRequest) {
        return executeSync(bybitApiService.postCryptoLoanFlexibleBorrow(flexibleBorrowRequest));
    }

    @Override
    public Object getCryptoLoanFlexibleOngoingCoin(String loanCurrency) {
        return executeSync(bybitApiService.getCryptoLoanFlexibleOngoingCoin(loanCurrency));
    }

    @Override
    public Object postCryptoLoanFlexibleRepayCollateral(PostCryptoLoanFlexibleRepayCollateralRequest postCryptoLoanFlexibleRepayCollateralRequest) {
        return executeSync(bybitApiService.postCryptoLoanFlexibleRepayCollateral(postCryptoLoanFlexibleRepayCollateralRequest));
    }

    @Override
    public Object postCryptoLoanFlexibleRepay(PostCryptoLoanFlexibleRepayRequest postCryptoLoanFlexibleRepayRequest) {
        return executeSync(bybitApiService.postCryptoLoanFlexibleRepay(postCryptoLoanFlexibleRepayRequest));
    }

    @Override
    public Object getCryptoLoanFlexibleRepaymentHistory(String repayId, String loanCurrency, String limit, String cursor) {
        return executeSync(bybitApiService.getCryptoLoanFlexibleRepaymentHistory(repayId, loanCurrency, limit, cursor));
    }
}
