package com.bybit.api.client.impl;

import com.bybit.api.client.restApi.BybitApiCallback;
import com.bybit.api.client.domain.referral.request.EmptyCampaignRequest;
import com.bybit.api.client.domain.referral.request.GetReferralCommissionRecordsRequest;
import com.bybit.api.client.domain.referral.request.GetReferralUserIdentityProfileRequest;
import com.bybit.api.client.domain.referral.request.GetReferralUserInvitationsRequest;
import com.bybit.api.client.restApi.BybitApiService;
import com.bybit.api.client.restApi.BybitApiAsyncReferralRestClient;

import static com.bybit.api.client.service.BybitApiServiceGenerator.createService;

public class BybitApiAsyncReferralRestClientImpl implements BybitApiAsyncReferralRestClient {
    private final BybitApiService bybitApiService;

    public BybitApiAsyncReferralRestClientImpl(String apiKey, String secret, String baseUrl, boolean debugMode, long recvWindow, String logOption, String referer) {
        bybitApiService = createService(BybitApiService.class, apiKey, secret, baseUrl, debugMode, recvWindow, logOption, referer);
    }

    @Override
    public void getReferralCampaignRewards(EmptyCampaignRequest emptyCampaignRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getReferralCampaignRewards(emptyCampaignRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getReferralCommissionRecords(GetReferralCommissionRecordsRequest getReferralCommissionRecordsRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getReferralCommissionRecords(getReferralCommissionRecordsRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getReferralUserIdentityProfile(GetReferralUserIdentityProfileRequest getReferralUserIdentityProfileRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getReferralUserIdentityProfile(getReferralUserIdentityProfileRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getReferralUserInvitations(GetReferralUserInvitationsRequest getReferralUserInvitationsRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getReferralUserInvitations(getReferralUserInvitationsRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }
}
