package com.bybit.api.client.restApi;

import com.bybit.api.client.domain.spotx.request.ActivityLogReqDto;
import com.bybit.api.client.domain.spotx.request.UserHistoryReqDto;

public interface BybitApiSpotXRestClient {
    Object getLaunchpoolProjectList(Long status, String activityCoin, String projectId, String cursor, Integer limit);

    Object getLaunchpoolUserActivityLog(ActivityLogReqDto activityLogReqDto);

    Object getLaunchpoolUserCurrentStaking();

    Object getLaunchpoolUserHistory(UserHistoryReqDto userHistoryReqDto);

    Object getPuzzleProjectList(Long status, String projectId, String activityCoin, String cursor, Integer limit);

    Object getTokenSplashProjectList(Long status, String projectId, String activityCoin, String cursor, Integer limit);

    Object getTokenSplashUserActivityParams(String projectId, String activityCoin);
}
