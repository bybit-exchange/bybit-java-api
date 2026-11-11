package com.bybit.api.client.domain.alpha.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PredictionSellRequest {
    private String tokenId;
    private String size;
    private Long orderType;
    private String slippage;
    private String eventId;
    private String toTokenCode;
}
