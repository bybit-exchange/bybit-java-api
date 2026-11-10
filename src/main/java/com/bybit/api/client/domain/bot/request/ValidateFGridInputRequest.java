package com.bybit.api.client.domain.bot.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ValidateFGridInputRequest {
    private String symbol;
    private Long cell_number;
    private String min_price;
    private String max_price;
    private String leverage;
    private Long grid_type;
    private Long grid_mode;
    private String stop_loss_price;
    private String take_profit_price;
    private Long tp_sl_type;
    private String entry_price;
    private String stop_loss_per;
    private String take_profit_per;
    private String trailing_stop_per;
    private String init_margin;
    private String move_up_price;
    private String move_down_price;
}
