package com.bybit.api.client.domain.alpha.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PredictionOrderListRequest {
    private Long status;
    private String tokenId;
    private Integer limit;
    private Integer pageIndex;
    private String eventId;
    private Long side;
    private Long days;
}
