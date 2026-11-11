package com.bybit.api.client.impl;

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
import com.bybit.api.client.restApi.BybitApiService;
import com.bybit.api.client.restApi.BybitApiBotRestClient;

import static com.bybit.api.client.service.BybitApiServiceGenerator.createService;
import static com.bybit.api.client.service.BybitApiServiceGenerator.executeSync;

public class BybitApiBotRestClientImpl implements BybitApiBotRestClient {
    private final BybitApiService bybitApiService;

    public BybitApiBotRestClientImpl(String apiKey, String secret, String baseUrl, boolean debugMode, long recvWindow, String logOption, String referer) {
        bybitApiService = createService(BybitApiService.class, apiKey, secret, baseUrl, debugMode, recvWindow, logOption, referer);
    }

    @Override
    public Object closeComboBot(CloseBotRequest closeBotRequest) {
        return executeSync(bybitApiService.closeComboBot(closeBotRequest));
    }

    @Override
    public Object createComboBot(CreateBotRequest createBotRequest) {
        return executeSync(bybitApiService.createComboBot(createBotRequest));
    }

    @Override
    public Object getComboDetail(GetDetailRequest getDetailRequest) {
        return executeSync(bybitApiService.getComboDetail(getDetailRequest));
    }

    @Override
    public Object getComboLimit(GetLimitRequest getLimitRequest) {
        return executeSync(bybitApiService.getComboLimit(getLimitRequest));
    }

    @Override
    public Object getFGridDetail(GetFGridDetailRequest getFGridDetailRequest) {
        return executeSync(bybitApiService.getFGridDetail(getFGridDetailRequest));
    }

    @Override
    public Object closeFGridBot(FGridBotSingleCloseRequest fGridBotSingleCloseRequest) {
        return executeSync(bybitApiService.closeFGridBot(fGridBotSingleCloseRequest));
    }

    @Override
    public Object createFGridBot(FGridBotSingleCreateRequest fGridBotSingleCreateRequest) {
        return executeSync(bybitApiService.createFGridBot(fGridBotSingleCreateRequest));
    }

    @Override
    public Object validateFGridInput(ValidateFGridInputRequest validateFGridInputRequest) {
        return executeSync(bybitApiService.validateFGridInput(validateFGridInputRequest));
    }

    @Override
    public Object closeFMartBot(CloseFMartBotRequest closeFMartBotRequest) {
        return executeSync(bybitApiService.closeFMartBot(closeFMartBotRequest));
    }

    @Override
    public Object createFMartBot(CreateFMartBotRequest createFMartBotRequest) {
        return executeSync(bybitApiService.createFMartBot(createFMartBotRequest));
    }

    @Override
    public Object getFMartDetail(GetFMartDetailRequest getFMartDetailRequest) {
        return executeSync(bybitApiService.getFMartDetail(getFMartDetailRequest));
    }

    @Override
    public Object getFMartLimit(GetFMartLimitRequest getFMartLimitRequest) {
        return executeSync(bybitApiService.getFMartLimit(getFMartLimitRequest));
    }

    @Override
    public Object closeDCABot(CloseDCABotRequest closeDCABotRequest) {
        return executeSync(bybitApiService.closeDCABot(closeDCABotRequest));
    }

    @Override
    public Object createDCABot(CreateDCABotRequest createDCABotRequest) {
        return executeSync(bybitApiService.createDCABot(createDCABotRequest));
    }

    @Override
    public Object closeGridBot(CloseGridRequest closeGridRequest) {
        return executeSync(bybitApiService.closeGridBot(closeGridRequest));
    }

    @Override
    public Object createGridBot(CreateGridBotRequest createGridBotRequest) {
        return executeSync(bybitApiService.createGridBot(createGridBotRequest));
    }

    @Override
    public Object queryGridDetail(QueryGridDetailRequest queryGridDetailRequest) {
        return executeSync(bybitApiService.queryGridDetail(queryGridDetailRequest));
    }

    @Override
    public Object validateGridInput(ValidateInputRequest validateInputRequest) {
        return executeSync(bybitApiService.validateGridInput(validateInputRequest));
    }
}
