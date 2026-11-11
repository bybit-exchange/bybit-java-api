package com.bybit.api.client.domain.alpha.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PredictionSideMarketListRequest {
    private String eventId;
    private String sortBy;
    private Integer marketType;
    private Integer limit;
    private Integer pageIndex;
}
