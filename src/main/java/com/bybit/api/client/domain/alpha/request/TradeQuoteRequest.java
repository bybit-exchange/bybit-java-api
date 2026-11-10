package com.bybit.api.client.domain.alpha.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TradeQuoteRequest {
    private Long tradeType;
    private String fromTokenCode;
    private String fromTokenAmount;
    private String toTokenCode;
    private Long quoteMode;
}
