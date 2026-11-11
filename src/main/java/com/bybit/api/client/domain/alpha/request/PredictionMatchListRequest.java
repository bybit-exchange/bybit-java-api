package com.bybit.api.client.domain.alpha.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PredictionMatchListRequest {
    private Integer eventType;
    private Integer status;
    private Long startTime;
    private Long endTime;
    private String stageCode;
    private Integer limit;
    private Integer pageIndex;
}
