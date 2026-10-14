package com.bybit.api.client.domain.spot.marginTrade;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FixedBorrowRequest {
    private String orderCurrency;
    private String orderAmount;
    private String annualRate;
    private String term;
    private String repayType;
    private String strategyType;
}
