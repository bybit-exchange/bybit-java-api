package com.bybit.api.client.domain.bot.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DcaBotParameters {
    private Integer frequency_in_second;
    private String quote_coin;
    private java.util.List<DcaBotPair> pairs;
    private String max_invest_amount;
}
