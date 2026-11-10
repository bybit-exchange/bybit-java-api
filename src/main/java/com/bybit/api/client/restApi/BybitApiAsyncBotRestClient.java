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

public interface BybitApiAsyncBotRestClient {
    void closeComboBot(CloseBotRequest closeBotRequest, BybitApiCallback<Object> callback);

    void createComboBot(CreateBotRequest createBotRequest, BybitApiCallback<Object> callback);

    void getComboDetail(GetDetailRequest getDetailRequest, BybitApiCallback<Object> callback);

    void getComboLimit(GetLimitRequest getLimitRequest, BybitApiCallback<Object> callback);

    void getFGridDetail(GetFGridDetailRequest getFGridDetailRequest, BybitApiCallback<Object> callback);

    void closeFGridBot(FGridBotSingleCloseRequest fGridBotSingleCloseRequest, BybitApiCallback<Object> callback);

    void createFGridBot(FGridBotSingleCreateRequest fGridBotSingleCreateRequest, BybitApiCallback<Object> callback);

    void validateFGridInput(ValidateFGridInputRequest validateFGridInputRequest, BybitApiCallback<Object> callback);

    void closeFMartBot(CloseFMartBotRequest closeFMartBotRequest, BybitApiCallback<Object> callback);

    void createFMartBot(CreateFMartBotRequest createFMartBotRequest, BybitApiCallback<Object> callback);

    void getFMartDetail(GetFMartDetailRequest getFMartDetailRequest, BybitApiCallback<Object> callback);

    void getFMartLimit(GetFMartLimitRequest getFMartLimitRequest, BybitApiCallback<Object> callback);

    void closeDCABot(CloseDCABotRequest closeDCABotRequest, BybitApiCallback<Object> callback);

    void createDCABot(CreateDCABotRequest createDCABotRequest, BybitApiCallback<Object> callback);

    void closeGridBot(CloseGridRequest closeGridRequest, BybitApiCallback<Object> callback);

    void createGridBot(CreateGridBotRequest createGridBotRequest, BybitApiCallback<Object> callback);

    void queryGridDetail(QueryGridDetailRequest queryGridDetailRequest, BybitApiCallback<Object> callback);

    void validateGridInput(ValidateInputRequest validateInputRequest, BybitApiCallback<Object> callback);
}
