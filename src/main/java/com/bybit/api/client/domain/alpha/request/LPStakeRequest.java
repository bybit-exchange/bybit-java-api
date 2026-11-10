package com.bybit.api.client.domain.alpha.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LPStakeRequest {
    private Long positionId;
    private String poolAddress;
    private String payTokenAmount;
    private String payTokenCode;
    private String rangeUpper;
    private String rangeLower;
    private String priceUpper;
    private String priceLower;
}
