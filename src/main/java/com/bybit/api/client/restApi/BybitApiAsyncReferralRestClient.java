package com.bybit.api.client.restApi;

import com.bybit.api.client.domain.referral.request.EmptyCampaignRequest;
import com.bybit.api.client.domain.referral.request.GetReferralCommissionRecordsRequest;
import com.bybit.api.client.domain.referral.request.GetReferralUserIdentityProfileRequest;
import com.bybit.api.client.domain.referral.request.GetReferralUserInvitationsRequest;

public interface BybitApiAsyncReferralRestClient {
    void getReferralCampaignRewards(EmptyCampaignRequest emptyCampaignRequest, BybitApiCallback<Object> callback);

    void getReferralCommissionRecords(GetReferralCommissionRecordsRequest getReferralCommissionRecordsRequest, BybitApiCallback<Object> callback);

    void getReferralUserIdentityProfile(GetReferralUserIdentityProfileRequest getReferralUserIdentityProfileRequest, BybitApiCallback<Object> callback);

    void getReferralUserInvitations(GetReferralUserInvitationsRequest getReferralUserInvitationsRequest, BybitApiCallback<Object> callback);
}
