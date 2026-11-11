package com.bybit.api.client.restApi;

import com.bybit.api.client.domain.referral.request.EmptyCampaignRequest;
import com.bybit.api.client.domain.referral.request.GetReferralCommissionRecordsRequest;
import com.bybit.api.client.domain.referral.request.GetReferralUserIdentityProfileRequest;
import com.bybit.api.client.domain.referral.request.GetReferralUserInvitationsRequest;

public interface BybitApiReferralRestClient {
    Object getReferralCampaignRewards(EmptyCampaignRequest emptyCampaignRequest);

    Object getReferralCommissionRecords(GetReferralCommissionRecordsRequest getReferralCommissionRecordsRequest);

    Object getReferralUserIdentityProfile(GetReferralUserIdentityProfileRequest getReferralUserIdentityProfileRequest);

    Object getReferralUserInvitations(GetReferralUserInvitationsRequest getReferralUserInvitationsRequest);
}
