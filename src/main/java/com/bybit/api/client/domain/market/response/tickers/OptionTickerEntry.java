package com.bybit.api.client.domain.market.response.tickers;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class OptionTickerEntry extends TickerEntry {
    @JsonProperty("symbol")
    private String symbol;

    @JsonProperty("bid1Price")
    private String bid1Price;

    @JsonProperty("bid1Size")
    private String bid1Size;

    @JsonProperty("bid1Iv")
    private String bid1Iv;

    @JsonProperty("ask1Price")
    private String ask1Price;

    @JsonProperty("ask1Size")
    private String ask1Size;

    @JsonProperty("ask1Iv")
    private String ask1Iv;

    @JsonProperty("lastPrice")
    private String lastPrice;

    @JsonProperty("highPrice24h")
    private String highPrice24h;

    @JsonProperty("lowPrice24h")
    private String lowPrice24h;

    @JsonProperty("markPrice")
    private String  markPrice;

    @JsonProperty("indexPrice")
    private String  indexPrice;

    @JsonProperty("markIv")
    private String  markIv;

    @JsonProperty("underlyingPrice")
    private String  underlyingPrice;

    @JsonProperty("openInterest")
    private String  openInterest;

    @JsonProperty("turnover24h")
    private String turnover24h;

    @JsonProperty("volume24h")
    private String volume24h;

    @JsonProperty("totalVolume")
    private String totalVolume;

    @JsonProperty("totalTurnover")
    private String totalTurnover;

    @JsonProperty("delta")
    private String  delta;

    @JsonProperty("gamma")
    private String  gamma;

    @JsonProperty("vega")
    private String  vega;

    @JsonProperty("theta")
    private String  theta;

    /**
     * 	Predicated delivery price.
     * 	It has a value 30 mins before delivery
     */
    @JsonProperty("predictedDeliveryPrice")
    private String  predictedDeliveryPrice;

    /**
     * 	The change in the last 24 hous
     */
    @JsonProperty("change24h")
    private String  change24h;
}
