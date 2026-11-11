package com.bybit.api.client.domain.loan.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FlexibleBorrowRequest {
    private String loanCurrency;
    private String loanAmount;
    private java.util.List<LoanCollateral> collateralList;
}
