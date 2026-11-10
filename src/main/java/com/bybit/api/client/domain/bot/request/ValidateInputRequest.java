package com.bybit.api.client.domain.bot.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ValidateInputRequest {
    private String symbol;
    private Long cell_number;
    private String min_price;
    private String max_price;
    private String total_investment;
    private String stop_loss;
    private String take_profit;
    private String entry_price;
    private String base_investment;
    private String quote_investment;
    private Long invest_mode;
    private String ts_percent;
    private Boolean enable_trailing;
    private String limit_up_price;
}
