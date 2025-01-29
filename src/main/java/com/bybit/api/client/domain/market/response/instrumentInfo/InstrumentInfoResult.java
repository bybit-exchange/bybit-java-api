package com.bybit.api.client.domain.market.response.instrumentInfo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
public class InstrumentInfoResult {
    @JsonProperty("category")
    private String category;
    @JsonProperty("nextPageCursor")
    private String nextPageCursor;
    @JsonProperty("list")
    private List<InstrumentEntry> instrumentEntries;
}
