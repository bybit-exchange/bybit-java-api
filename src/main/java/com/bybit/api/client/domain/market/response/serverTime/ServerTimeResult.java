package com.bybit.api.client.domain.market.response.serverTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ServerTimeResult {
    @JsonProperty("timeSecond")
    private long timeSecond;
    @JsonProperty("timeNano")
    private long timeNano;
}
