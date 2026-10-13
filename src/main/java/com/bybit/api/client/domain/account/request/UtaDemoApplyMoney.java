package com.bybit.api.client.domain.account.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UtaDemoApplyMoney {
    private String coin;
    private String amountStr;
}
