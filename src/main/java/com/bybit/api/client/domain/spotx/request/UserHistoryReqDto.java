package com.bybit.api.client.domain.spotx.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserHistoryReqDto {
    private String stakeCoin;
    private String rewardCoin;
    private String startTime;
    private String endTime;
    private Integer pageSize;
    private Long current;
}
