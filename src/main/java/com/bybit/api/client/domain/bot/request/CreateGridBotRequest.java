package com.bybit.api.client.domain.bot.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateGridBotRequest {
    private String symbol;
    private String max_price;
    private String min_price;
    private String total_investment;
    private Long cell_number;
    private Long followed_grid_id;
    private Long source;
    private String entry_price;
    private String stop_loss_price;
    private String take_profit_price;
    private String base_investment;
    private String quote_investment;
    private Long invest_mode;
    private Long block_source;
    private Long create_type;
    private String ts_percent;
    private Boolean enable_trailing;
    private String limit_up_price;
    private String channel;
}
