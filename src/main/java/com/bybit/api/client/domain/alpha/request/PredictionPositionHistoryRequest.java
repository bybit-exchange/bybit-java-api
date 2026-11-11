package com.bybit.api.client.domain.alpha.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PredictionPositionHistoryRequest {
    private String tokenId;
    private String eventId;
    private Integer result;
    private Integer days;
    private Integer limit;
    private Integer pageIndex;
}
