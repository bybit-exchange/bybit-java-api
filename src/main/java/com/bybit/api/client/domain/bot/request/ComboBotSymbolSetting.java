package com.bybit.api.client.domain.bot.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ComboBotSymbolSetting {
    private String symbol;
    private String target_position_percent;
    private Integer side;
}
