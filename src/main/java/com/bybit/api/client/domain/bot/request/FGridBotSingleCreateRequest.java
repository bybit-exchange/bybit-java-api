package com.bybit.api.client.domain.bot.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FGridBotSingleCreateRequest {
    private String symbol;
    private Long grid_mode;
    private String min_price;
    private String max_price;
    private Long cell_number;
    private String leverage;
    private Long grid_type;
    private String total_investment;
    private String take_profit_per;
    private String stop_loss_per;
    private String entry_price;
    private Long source;
    private Long followed_grid_id;
    private String stop_loss_price;
    private String take_profit_price;
    private Long tp_sl_type;
    private Long block_source;
    private Long create_type;
    private String init_bonus;
    private String business_remark;
    private String trailing_stop_per;
    private String move_up_price;
    private String move_down_price;
    private String channel;
}
