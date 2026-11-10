package com.bybit.api.client.restApi;

import com.bybit.api.client.domain.bot.request.CloseBotRequest;
import com.bybit.api.client.domain.bot.request.CloseDCABotRequest;
import com.bybit.api.client.domain.bot.request.CloseFMartBotRequest;
import com.bybit.api.client.domain.bot.request.CloseGridRequest;
import com.bybit.api.client.domain.bot.request.CreateBotRequest;
import com.bybit.api.client.domain.bot.request.CreateDCABotRequest;
import com.bybit.api.client.domain.bot.request.CreateFMartBotRequest;
import com.bybit.api.client.domain.bot.request.CreateGridBotRequest;
import com.bybit.api.client.domain.bot.request.FGridBotSingleCloseRequest;
import com.bybit.api.client.domain.bot.request.FGridBotSingleCreateRequest;
import com.bybit.api.client.domain.bot.request.GetDetailRequest;
import com.bybit.api.client.domain.bot.request.GetFGridDetailRequest;
import com.bybit.api.client.domain.bot.request.GetFMartDetailRequest;
import com.bybit.api.client.domain.bot.request.GetFMartLimitRequest;
import com.bybit.api.client.domain.bot.request.GetLimitRequest;
import com.bybit.api.client.domain.bot.request.QueryGridDetailRequest;
import com.bybit.api.client.domain.bot.request.ValidateFGridInputRequest;
import com.bybit.api.client.domain.bot.request.ValidateInputRequest;

public interface BybitApiBotRestClient {
    Object closeComboBot(CloseBotRequest closeBotRequest);

    Object createComboBot(CreateBotRequest createBotRequest);

    Object getComboDetail(GetDetailRequest getDetailRequest);

    Object getComboLimit(GetLimitRequest getLimitRequest);

    Object getFGridDetail(GetFGridDetailRequest getFGridDetailRequest);

    Object closeFGridBot(FGridBotSingleCloseRequest fGridBotSingleCloseRequest);

    Object createFGridBot(FGridBotSingleCreateRequest fGridBotSingleCreateRequest);

    Object validateFGridInput(ValidateFGridInputRequest validateFGridInputRequest);

    Object closeFMartBot(CloseFMartBotRequest closeFMartBotRequest);

    Object createFMartBot(CreateFMartBotRequest createFMartBotRequest);

    Object getFMartDetail(GetFMartDetailRequest getFMartDetailRequest);

    Object getFMartLimit(GetFMartLimitRequest getFMartLimitRequest);

    Object closeDCABot(CloseDCABotRequest closeDCABotRequest);

    Object createDCABot(CreateDCABotRequest createDCABotRequest);

    Object closeGridBot(CloseGridRequest closeGridRequest);

    Object createGridBot(CreateGridBotRequest createGridBotRequest);

    Object queryGridDetail(QueryGridDetailRequest queryGridDetailRequest);

    Object validateGridInput(ValidateInputRequest validateInputRequest);
}
