package com.bybit.api.client.domain.asset.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SmallAssetQuoteRequest {
    private String accountType;
    private String toCoin;
    private List<String> fromCoinList;
}
