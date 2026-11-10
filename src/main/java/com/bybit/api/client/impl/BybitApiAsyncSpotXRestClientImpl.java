package com.bybit.api.client.impl;

import com.bybit.api.client.restApi.BybitApiCallback;
import com.bybit.api.client.domain.spotx.request.ActivityLogReqDto;
import com.bybit.api.client.domain.spotx.request.UserHistoryReqDto;
import com.bybit.api.client.restApi.BybitApiService;
import com.bybit.api.client.restApi.BybitApiAsyncSpotXRestClient;

import static com.bybit.api.client.service.BybitApiServiceGenerator.createService;

public class BybitApiAsyncSpotXRestClientImpl implements BybitApiAsyncSpotXRestClient {
    private final BybitApiService bybitApiService;

    public BybitApiAsyncSpotXRestClientImpl(String apiKey, String secret, String baseUrl, boolean debugMode, long recvWindow, String logOption, String referer) {
        bybitApiService = createService(BybitApiService.class, apiKey, secret, baseUrl, debugMode, recvWindow, logOption, referer);
    }

    @Override
    public void getLaunchpoolProjectList(Long status, String activityCoin, String projectId, String cursor, Integer limit, BybitApiCallback<Object> callback) {
        bybitApiService.getLaunchpoolProjectList(status, activityCoin, projectId, cursor, limit).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getLaunchpoolUserActivityLog(ActivityLogReqDto activityLogReqDto, BybitApiCallback<Object> callback) {
        bybitApiService.getLaunchpoolUserActivityLog(activityLogReqDto).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getLaunchpoolUserCurrentStaking(BybitApiCallback<Object> callback) {
        bybitApiService.getLaunchpoolUserCurrentStaking().enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getLaunchpoolUserHistory(UserHistoryReqDto userHistoryReqDto, BybitApiCallback<Object> callback) {
        bybitApiService.getLaunchpoolUserHistory(userHistoryReqDto).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getPuzzleProjectList(Long status, String projectId, String activityCoin, String cursor, Integer limit, BybitApiCallback<Object> callback) {
        bybitApiService.getPuzzleProjectList(status, projectId, activityCoin, cursor, limit).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getTokenSplashProjectList(Long status, String projectId, String activityCoin, String cursor, Integer limit, BybitApiCallback<Object> callback) {
        bybitApiService.getTokenSplashProjectList(status, projectId, activityCoin, cursor, limit).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getTokenSplashUserActivityParams(String projectId, String activityCoin, BybitApiCallback<Object> callback) {
        bybitApiService.getTokenSplashUserActivityParams(projectId, activityCoin).enqueue(new BybitApiCallbackAdapter<>(callback));
    }
}
