package com.bybit.api.client.restApi;

import com.bybit.api.client.domain.preupgrade.PreUpgradeDataRequest;
import com.bybit.api.client.domain.user.UserDataRequest;
import com.bybit.api.client.domain.user.request.DeleteSubMemberV5Request;
import com.bybit.api.client.domain.user.request.SignAgreementRequest;

public interface BybitApiUserRestClient {
    // User Data
    Object createSubMember(UserDataRequest subUserRequest);
    Object createSubAPI(UserDataRequest createApiKeyRequest);
    Object getSubUIDList();
    Object freezeSubMember(UserDataRequest freezeSubUIDRequest);
    Object getCurrentAPIKeyInfo();
    Object getUIDWalletType(UserDataRequest userDataRequest);
    Object modifyMasterApiKey(UserDataRequest userDataRequest);
    Object modifySubApiKey(UserDataRequest userDataRequest);
    Object deleteMasterApiKey();
    Object deleteSubApiKey(UserDataRequest userDataRequest);
    Object getAffiliateUserInfo(UserDataRequest userDataRequest);

    // Pre Upgrade
    Object getPreUpgradeOrderHistory(PreUpgradeDataRequest preupgradeOderHistoryRequest);
    Object getPreUpgradeTradeHistory(PreUpgradeDataRequest preUpgradeTradeHistoryRequest);
    Object getPreUpgradeClosePnl(PreUpgradeDataRequest preUpgradeClosePnlRequest);
    Object getPreUpgradeTransaction(PreUpgradeDataRequest preUpgradeTransactionRequest);
    Object getPreUpgradeOptionDelivery(PreUpgradeDataRequest preUpgradeOptionDeliveryRequest);
    Object getPreUpgradeUsdcSettlement(PreUpgradeDataRequest preUpgradeUsdcSettlementRequest);

    Object getSubUIDListUnlimited(UserDataRequest subUserRequest);
    Object getSubUIDListUnlimited();
    Object getSubAccAllAPIKeyInfo(UserDataRequest subUserRequest);

    default Object deleteSubMemberV5(DeleteSubMemberV5Request deleteSubMemberV5Request) {
        throw new UnsupportedOperationException("deleteSubMemberV5 is not implemented by this client");
    }
    default Object queryEscrowSubMembersV5(Long nextCursor, Integer pageSize) {
        throw new UnsupportedOperationException("queryEscrowSubMembersV5 is not implemented by this client");
    }
    default Object queryReferrals(String cursor, Integer size, String status) {
        throw new UnsupportedOperationException("queryReferrals is not implemented by this client");
    }
    default Object signAgreement(SignAgreementRequest signAgreementRequest) {
        throw new UnsupportedOperationException("signAgreement is not implemented by this client");
    }

    default Object queryReferralCode() {
        throw new UnsupportedOperationException("queryReferralCode is not implemented by this client");
    }
}
