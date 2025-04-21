package com.bybit.api.client.domain.account.response;

import com.bybit.api.client.constant.BybitApiConstants;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.List;

/**
 * Obtain wallet balance, query asset information of each currency. By default, currency information with assets or liabilities of 0 is not returned.
 */
@JsonPropertyOrder()
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class WalletBalanceResponse {
    @JsonProperty("list")
    private List< WalletBalanceEntry> list;

    @Override
    public String toString() {
        return new ToStringBuilder(this, BybitApiConstants.TO_STRING_BUILDER_STYLE)
                .append("list", list)
                .toString();
    }
}
