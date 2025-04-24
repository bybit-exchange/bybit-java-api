package com.bybit.api.client.domain.market.response.tickers;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TickersResult<T extends TickerEntry> {
    @JsonProperty("category")
    private String category;
    @JsonProperty("list")
    private List<T> tickerEntries;
}
