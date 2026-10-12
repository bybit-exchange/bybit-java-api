package com.bybit.api.client.domain.account.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UtaDemoApplyMoneyRequest {
    private Long adjustType;
    private java.util.List<Object> utaDemoApplyMoney;
}
