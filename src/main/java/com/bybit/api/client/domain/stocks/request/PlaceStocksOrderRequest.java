package com.bybit.api.client.domain.stocks.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PlaceStocksOrderRequest {
    private String symbol;
    private String quoteToken;
    private String side;
    private String type;
    private String qty;
    private String notional;
    private String limitPrice;
    private String stopPrice;
    private String timeInForce;
    private String tradingSession;
    private Boolean tokenize;
    private Long orderTime;
    private String requestId;
}
