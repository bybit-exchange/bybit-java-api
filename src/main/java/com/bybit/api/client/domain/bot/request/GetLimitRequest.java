package com.bybit.api.client.domain.bot.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetLimitRequest {
    private String leverage;
    private String init_margin;
    private Long adjust_position_mode;
    private String adjust_position_percent;
    private Long adjust_position_time_interval;
    private java.util.List<ComboBotSymbolSetting> symbol_settings;
    private String sl_percent;
    private String tp_percent;
    private Boolean need_to_slippage;
    private String app_name;
    private String trailing_stop_percent;
}
