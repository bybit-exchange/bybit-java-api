package com.bybit.api.client.domain.market.response.instrumentInfo;

import lombok.Getter;

@Getter
public class LotSizeFilter {
    private String maxOrderQty;
    private String minOrderQty;
    private String qtyStep;
    private String postOnlyMaxOrderQty;
    private String basePrecision;
    private String quotePrecision;
    private String minOrderAmt;
    private String maxOrderAmt;
    private String maxMktOrderQty;
    private String minNotionalValue;
}
