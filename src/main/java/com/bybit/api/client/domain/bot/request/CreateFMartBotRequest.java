package com.bybit.api.client.domain.bot.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateFMartBotRequest {
    private String symbol;
    private Integer martingale_mode;
    private String leverage;
    private String price_float_percent;
    private String add_position_percent;
    private Long add_position_num;
    private String init_margin;
    private String round_tp_percent;
    private Integer auto_cycle_toggle;
    private String sl_percent;
    private String entry_price;
    private String source;
    private Long followed_bot_id;
    private String block_source;
    private String create_type;
    private String init_bonus;
    private String channel;
}
