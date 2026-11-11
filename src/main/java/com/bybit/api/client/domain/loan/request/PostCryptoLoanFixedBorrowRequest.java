package com.bybit.api.client.domain.loan.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PostCryptoLoanFixedBorrowRequest {
    private String orderCurrency;
    private String orderAmount;
    private String annualRate;
    private String term;
    private String autoRepay;
    private java.util.List<LoanCollateral> collateralList;
    private String repayType;
    private String strategyType;
}
