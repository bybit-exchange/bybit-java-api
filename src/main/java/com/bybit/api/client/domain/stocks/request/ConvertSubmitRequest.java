package com.bybit.api.client.domain.stocks.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ConvertSubmitRequest {
    private String convertType;
    private String symbol;
    private String inputAmount;
    private String frontMultiplier;
    private String accountType;
    private String requestId;
    private String contractAddr;
    private String flow;
    private String burnScene;
}
