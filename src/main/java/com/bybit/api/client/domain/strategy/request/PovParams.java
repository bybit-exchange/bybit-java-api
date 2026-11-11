package com.bybit.api.client.domain.strategy.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PovParams {
    private String mode;
    private String participationRate;
    private String referenceWindow;
    private Integer depthReference;
}
