package com.bybit.api.client.domain.alpha.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PredictionBuyRequest {
    private String tokenId;
    private String amount;
    private String payTokenCode;
    private Long orderType;
    private String slippage;
    private String eventId;
}
