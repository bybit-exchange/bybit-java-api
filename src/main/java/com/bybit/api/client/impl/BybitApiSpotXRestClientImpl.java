package com.bybit.api.client.impl;

import com.bybit.api.client.domain.spotx.request.ActivityLogReqDto;
import com.bybit.api.client.domain.spotx.request.UserHistoryReqDto;
import com.bybit.api.client.restApi.BybitApiService;
import com.bybit.api.client.restApi.BybitApiSpotXRestClient;

import static com.bybit.api.client.service.BybitApiServiceGenerator.createService;
import static com.bybit.api.client.service.BybitApiServiceGenerator.executeSync;

public class BybitApiSpotXRestClientImpl implements BybitApiSpotXRestClient {
    private final BybitApiService bybitApiService;

    public BybitApiSpotXRestClientImpl(String apiKey, String secret, String baseUrl, boolean debugMode, long recvWindow, String logOption, String referer) {
        bybitApiService = createService(BybitApiService.class, apiKey, secret, baseUrl, debugMode, recvWindow, logOption, referer);
    }

    @Override
    public Object getLaunchpoolProjectList(Long status, String activityCoin, String projectId, String cursor, Integer limit) {
        return executeSync(bybitApiService.getLaunchpoolProjectList(status, activityCoin, projectId, cursor, limit));
    }

    @Override
    public Object getLaunchpoolUserActivityLog(ActivityLogReqDto activityLogReqDto) {
        return executeSync(bybitApiService.getLaunchpoolUserActivityLog(activityLogReqDto));
    }

    @Override
    public Object getLaunchpoolUserCurrentStaking() {
        return executeSync(bybitApiService.getLaunchpoolUserCurrentStaking());
    }

    @Override
    public Object getLaunchpoolUserHistory(UserHistoryReqDto userHistoryReqDto) {
        return executeSync(bybitApiService.getLaunchpoolUserHistory(userHistoryReqDto));
    }

    @Override
    public Object getPuzzleProjectList(Long status, String projectId, String activityCoin, String cursor, Integer limit) {
        return executeSync(bybitApiService.getPuzzleProjectList(status, projectId, activityCoin, cursor, limit));
    }

    @Override
    public Object getTokenSplashProjectList(Long status, String projectId, String activityCoin, String cursor, Integer limit) {
        return executeSync(bybitApiService.getTokenSplashProjectList(status, projectId, activityCoin, cursor, limit));
    }

    @Override
    public Object getTokenSplashUserActivityParams(String projectId, String activityCoin) {
        return executeSync(bybitApiService.getTokenSplashUserActivityParams(projectId, activityCoin));
    }
}
