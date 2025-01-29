package com.bybit.api.client.domain.market.response.instrumentInfo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;

@JsonPropertyOrder
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
public class InstrumentEntry {
    private String symbol;
    private String baseCoin;
    private String quoteCoin;
    private String status;
    private String contractType;
    private String launchTime;
    private String deliveryTime;
    private String deliveryFeeRate;
    private String priceScale;
    private LeverageFilter leverageFilter;
    private PriceFilter priceFilter;
    private LotSizeFilter lotSizeFilter;
    private Boolean unifiedMarginTrade;
    private Integer fundingInterval;
    private String settleCoin;
    private String copyTrading;
    private String optionsType;
    private String innovation;
    private String marginTrading;
    private String upperFundingRate;
    private String lowerFundingRate;
    private Boolean isPreListing;
    private PreListingInfo preListingInfo;
    private RiskParameters riskParameters;
}
