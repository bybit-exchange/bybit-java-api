package com.bybit.api.client.domain.loan.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MaxLoanRequest {
    private String currency;
    private java.util.List<MaxLoanCollateral> collateralList;
}
