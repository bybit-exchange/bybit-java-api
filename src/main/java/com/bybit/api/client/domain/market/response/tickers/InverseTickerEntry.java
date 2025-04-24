package com.bybit.api.client.domain.market.response.tickers;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class InverseTickerEntry extends TickerEntry {
    @JsonProperty("symbol")
    private String symbol;

    @JsonProperty("lastPrice")
    private String lastPrice;

    @JsonProperty("indexPrice")
    private String indexPrice;

    @JsonProperty("markPrice")
    private String markPrice;

    @JsonProperty("prevPrice24h")
    private String prevPrice24h;

    @JsonProperty("price24hPcnt")
    private String price24hPcnt;

    @JsonProperty("highPrice24h")
    private String highPrice24h;

    @JsonProperty("lowPrice24h")
    private String lowPrice24h;

    @JsonProperty("prevPrice1h")
    private String prevPrice1h;

    @JsonProperty("openInterest")
    private String openInterest;

    @JsonProperty("openInterestValue")
    private String openInterestValue;

    @JsonProperty("turnover24h")
    private String turnover24h;

    @JsonProperty("volume24h")
    private String volume24h;

    @JsonProperty("fundingRate")
    private String fundingRate;

    @JsonProperty("nextFundingTime")
    private String nextFundingTime;

    /**
     * Predicated delivery price. It has a value 30 mins before deliver
     */
    @JsonProperty("predictedDeliveryPrice")
    private String predictedDeliveryPrice;

    @JsonProperty("basisRate")
    private String basisRate;

    @JsonProperty("basis")
    private String basis;

    @JsonProperty("deliveryFeeRate")
    private String deliveryFeeRate;

    /**
     * Delivery timestamp (ms), applicable to expired futures only
     */
    @JsonProperty("deliveryTime")
    private String deliveryTime;

    @JsonProperty("ask1Size")
    private String ask1Size;

    @JsonProperty("bid1Price")
    private String bid1Price;

    @JsonProperty("ask1Price")
    private String ask1Price;

    @JsonProperty("bid1Size")
    private String bid1Size;

    /**
     * Estimated pre-market contract open price
     * Meaningless once the market opens
     */
    @JsonProperty("preOpenPrice")
    private String preOpenPrice;

    /**
     * Estimated pre-market contract open qty
     * The value is meaningless once the market opens
     */
    @JsonProperty("preQty")
    private String preQty;

    /**
     * The current pre-market contract phase
     */
    @JsonProperty("curPreListingPhase")
    private String curPreListingPhase;
}
