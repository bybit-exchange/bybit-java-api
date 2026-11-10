package com.bybit.api.client.domain.bot.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateBotRequest {
    private String leverage;
    private String init_margin;
    private Long adjust_position_mode;
    private String adjust_position_percent;
    private Long adjust_position_time_interval;
    private java.util.List<ComboBotSymbolSetting> symbol_settings;
    private String sl_percent;
    private String tp_percent;
    private Long source;
    private Long block_source;
    private Long create_type;
    private Long followed_bot_id;
    private String init_bonus;
    private String trailing_stop_percent;
    private String channel;
}
