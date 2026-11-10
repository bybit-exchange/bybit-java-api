package com.bybit.api.client.impl;

import com.bybit.api.client.restApi.BybitApiCallback;
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
import com.bybit.api.client.restApi.BybitApiAsyncBotRestClient;

import static com.bybit.api.client.service.BybitApiServiceGenerator.createService;

public class BybitApiAsyncBotRestClientImpl implements BybitApiAsyncBotRestClient {
    private final BybitApiService bybitApiService;

    public BybitApiAsyncBotRestClientImpl(String apiKey, String secret, String baseUrl, boolean debugMode, long recvWindow, String logOption, String referer) {
        bybitApiService = createService(BybitApiService.class, apiKey, secret, baseUrl, debugMode, recvWindow, logOption, referer);
    }

    @Override
    public void closeComboBot(CloseBotRequest closeBotRequest, BybitApiCallback<Object> callback) {
        bybitApiService.closeComboBot(closeBotRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void createComboBot(CreateBotRequest createBotRequest, BybitApiCallback<Object> callback) {
        bybitApiService.createComboBot(createBotRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getComboDetail(GetDetailRequest getDetailRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getComboDetail(getDetailRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getComboLimit(GetLimitRequest getLimitRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getComboLimit(getLimitRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getFGridDetail(GetFGridDetailRequest getFGridDetailRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getFGridDetail(getFGridDetailRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void closeFGridBot(FGridBotSingleCloseRequest fGridBotSingleCloseRequest, BybitApiCallback<Object> callback) {
        bybitApiService.closeFGridBot(fGridBotSingleCloseRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void createFGridBot(FGridBotSingleCreateRequest fGridBotSingleCreateRequest, BybitApiCallback<Object> callback) {
        bybitApiService.createFGridBot(fGridBotSingleCreateRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void validateFGridInput(ValidateFGridInputRequest validateFGridInputRequest, BybitApiCallback<Object> callback) {
        bybitApiService.validateFGridInput(validateFGridInputRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void closeFMartBot(CloseFMartBotRequest closeFMartBotRequest, BybitApiCallback<Object> callback) {
        bybitApiService.closeFMartBot(closeFMartBotRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void createFMartBot(CreateFMartBotRequest createFMartBotRequest, BybitApiCallback<Object> callback) {
        bybitApiService.createFMartBot(createFMartBotRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getFMartDetail(GetFMartDetailRequest getFMartDetailRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getFMartDetail(getFMartDetailRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getFMartLimit(GetFMartLimitRequest getFMartLimitRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getFMartLimit(getFMartLimitRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void closeDCABot(CloseDCABotRequest closeDCABotRequest, BybitApiCallback<Object> callback) {
        bybitApiService.closeDCABot(closeDCABotRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void createDCABot(CreateDCABotRequest createDCABotRequest, BybitApiCallback<Object> callback) {
        bybitApiService.createDCABot(createDCABotRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void closeGridBot(CloseGridRequest closeGridRequest, BybitApiCallback<Object> callback) {
        bybitApiService.closeGridBot(closeGridRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void createGridBot(CreateGridBotRequest createGridBotRequest, BybitApiCallback<Object> callback) {
        bybitApiService.createGridBot(createGridBotRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void queryGridDetail(QueryGridDetailRequest queryGridDetailRequest, BybitApiCallback<Object> callback) {
        bybitApiService.queryGridDetail(queryGridDetailRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void validateGridInput(ValidateInputRequest validateInputRequest, BybitApiCallback<Object> callback) {
        bybitApiService.validateGridInput(validateInputRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }
}
