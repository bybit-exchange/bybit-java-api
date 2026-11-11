package com.bybit.api.client.domain.alpha.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TradePurchaseRequest {
    private String fromTokenCode;
    private String fromTokenAmount;
    private String toTokenCode;
    private String slippage;
    private String quoteData;
    private String gas;
    private Long quoteMode;
    private String correctingCode;
    private String tenant;
}
