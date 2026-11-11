package com.bybit.api.client.domain.referral.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetReferralCommissionRecordsRequest {
    private java.util.List<ReferralUserId> userIdList;
    private String startTime;
    private String endTime;
    private Integer page;
    private Integer pageSize;
    private Long productLine;
}
