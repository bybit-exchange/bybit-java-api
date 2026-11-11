package com.bybit.api.client.domain.alpha.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LPOrderListRequest {
    private Long orderType;
    private String tokenCode;
    private java.util.List<Integer> orderStatus;
    private Long days;
    private Integer limit;
    private Integer pageIndex;
    private String poolAddress;
}
