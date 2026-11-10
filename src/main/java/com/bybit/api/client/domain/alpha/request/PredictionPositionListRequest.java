package com.bybit.api.client.domain.alpha.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PredictionPositionListRequest {
    private String tokenId;
    private String eventId;
    private Integer limit;
    private Integer pageIndex;
}
