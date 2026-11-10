package com.bybit.api.client.domain.loan.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AdjustLtvRequest {
    private String currency;
    private String amount;
    private String direction;
}
