package com.bybit.api.client.domain.strategy.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateStrategyRequest {
    private String category;
    private String symbol;
    private String side;
    private String size;
    private String strategyType;
    private String chaseDistance;
    private Long chasePercentE4;
    private String maxChasePrice;
    private String triggerPrice;
    private Boolean reduceOnly;
    private Long positionIdx;
    private Long leverageType;
    private String positionValue;
    private String subSize;
    private String subPositionValue;
    private Integer orderCount;
    private String limitPrice;
    private Long postOnly;
    private Long duration;
    private Long interval;
    private PovParams povParams;
    private Boolean isRandom;
}
