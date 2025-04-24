package com.bybit.api.client.domain.market.response.tickers;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class SpotTickerEntry extends TickerEntry {
    @JsonProperty("symbol")
    private String symbol;

    @JsonProperty("bid1Price")
    private String bid1Price;

    @JsonProperty("bid1Size")
    private String bid1Size;

    @JsonProperty("ask1Price")
    private String ask1Price;

    @JsonProperty("ask1Size")
    private String ask1Size;

    @JsonProperty("lastPrice")
    private String lastPrice;

    @JsonProperty("prevPrice24h")
    private String prevPrice24h;

    @JsonProperty("price24hPcnt")
    private String price24hPcnt;

    @JsonProperty("highPrice24h")
    private String highPrice24h;

    @JsonProperty("lowPrice24h")
    private String lowPrice24h;

    @JsonProperty("turnover24h")
    private String turnover24h;

    @JsonProperty("volume24h")
    private String volume24h;

    @JsonProperty("usdIndexPrice")
    private String usdIndexPrice;
}
