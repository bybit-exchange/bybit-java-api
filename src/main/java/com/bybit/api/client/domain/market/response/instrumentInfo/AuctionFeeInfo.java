package com.bybit.api.client.domain.market.response.instrumentInfo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
public class AuctionFeeInfo {
    private String auctionFeeRate;
    private String takerFeeRate;
    private String makerFeeRate;
}
