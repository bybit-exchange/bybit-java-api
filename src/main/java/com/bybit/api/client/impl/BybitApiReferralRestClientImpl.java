package com.bybit.api.client.impl;

import com.bybit.api.client.domain.referral.request.EmptyCampaignRequest;
import com.bybit.api.client.domain.referral.request.GetReferralCommissionRecordsRequest;
import com.bybit.api.client.domain.referral.request.GetReferralUserIdentityProfileRequest;
import com.bybit.api.client.domain.referral.request.GetReferralUserInvitationsRequest;
import com.bybit.api.client.restApi.BybitApiService;
import com.bybit.api.client.restApi.BybitApiReferralRestClient;

import static com.bybit.api.client.service.BybitApiServiceGenerator.createService;
import static com.bybit.api.client.service.BybitApiServiceGenerator.executeSync;

public class BybitApiReferralRestClientImpl implements BybitApiReferralRestClient {
    private final BybitApiService bybitApiService;

    public BybitApiReferralRestClientImpl(String apiKey, String secret, String baseUrl, boolean debugMode, long recvWindow, String logOption, String referer) {
        bybitApiService = createService(BybitApiService.class, apiKey, secret, baseUrl, debugMode, recvWindow, logOption, referer);
    }

    @Override
    public Object getReferralCampaignRewards(EmptyCampaignRequest emptyCampaignRequest) {
        return executeSync(bybitApiService.getReferralCampaignRewards(emptyCampaignRequest));
    }

    @Override
    public Object getReferralCommissionRecords(GetReferralCommissionRecordsRequest getReferralCommissionRecordsRequest) {
        return executeSync(bybitApiService.getReferralCommissionRecords(getReferralCommissionRecordsRequest));
    }

    @Override
    public Object getReferralUserIdentityProfile(GetReferralUserIdentityProfileRequest getReferralUserIdentityProfileRequest) {
        return executeSync(bybitApiService.getReferralUserIdentityProfile(getReferralUserIdentityProfileRequest));
    }

    @Override
    public Object getReferralUserInvitations(GetReferralUserInvitationsRequest getReferralUserInvitationsRequest) {
        return executeSync(bybitApiService.getReferralUserInvitations(getReferralUserInvitationsRequest));
    }
}
