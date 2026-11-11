package com.bybit.api.client.domain.alpha.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PredictionOrderEstimateRequest {
    private String tokenId;
    private Long side;
    private String eventId;
    private String amount;
    private Long orderType;
    private String payTokenCode;
}
