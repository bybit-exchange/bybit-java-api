package com.bybit.api.client.restApi;

import com.bybit.api.client.domain.spotx.request.ActivityLogReqDto;
import com.bybit.api.client.domain.spotx.request.UserHistoryReqDto;

public interface BybitApiAsyncSpotXRestClient {
    void getLaunchpoolProjectList(Long status, String activityCoin, String projectId, String cursor, Integer limit, BybitApiCallback<Object> callback);

    void getLaunchpoolUserActivityLog(ActivityLogReqDto activityLogReqDto, BybitApiCallback<Object> callback);

    void getLaunchpoolUserCurrentStaking(BybitApiCallback<Object> callback);

    void getLaunchpoolUserHistory(UserHistoryReqDto userHistoryReqDto, BybitApiCallback<Object> callback);

    void getPuzzleProjectList(Long status, String projectId, String activityCoin, String cursor, Integer limit, BybitApiCallback<Object> callback);

    void getTokenSplashProjectList(Long status, String projectId, String activityCoin, String cursor, Integer limit, BybitApiCallback<Object> callback);

    void getTokenSplashUserActivityParams(String projectId, String activityCoin, BybitApiCallback<Object> callback);
}
