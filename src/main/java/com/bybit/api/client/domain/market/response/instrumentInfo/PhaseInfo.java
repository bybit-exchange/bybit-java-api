package com.bybit.api.client.domain.market.response.instrumentInfo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

@JsonIgnoreProperties(ignoreUnknown = true)

@Getter
public class PhaseInfo {
    private String phase;
    private String startTime;
    private String endTime;
}
