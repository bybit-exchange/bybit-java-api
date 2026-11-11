package com.bybit.api.client.domain.alpha.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LPRedeemRequest {
    private Long positionId;
    private String poolAddress;
    private String dercRatio;
    private String receiveTokenCode;
}
