package com.bybit.api.client.domain.market.response.fundingRate;

import com.bybit.api.client.constant.BybitApiConstants;
import lombok.Getter;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Getter
public class FundingRateEntry {
    private String symbol;
    private double fundingRate;
    private long fundingRateTimestamp;

    @Override
    public String toString() {
        return new ToStringBuilder(this, BybitApiConstants.TO_STRING_BUILDER_STYLE)
                .append("symbol", symbol)
                .append("fundingRate", fundingRate)
                .append("fundingRateTimestamp", fundingRateTimestamp)
                .toString();
    }
}
