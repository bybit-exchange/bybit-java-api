package com.bybit.api.client.impl;

import com.bybit.api.client.restApi.BybitApiAsyncUserRestClient;
import com.bybit.api.client.restApi.BybitApiCallback;
import com.bybit.api.client.restApi.BybitApiService;
import com.bybit.api.client.domain.preupgrade.PreUpgradeDataRequest;
import com.bybit.api.client.domain.user.UserDataRequest;
import com.bybit.api.client.domain.user.request.DeleteSubMemberV5Request;
import com.bybit.api.client.domain.user.request.SignAgreementRequest;
import com.bybit.api.client.domain.user.request.UserSubMemberRequest;
import com.bybit.api.client.service.BybitJsonConverter;

import static com.bybit.api.client.constant.Helper.listToString;
import static com.bybit.api.client.service.BybitApiServiceGenerator.createService;

/**
 * Implementation of Bybit's REST API using Retrofit with asynchronous/non-blocking method calls.
 */
public class BybitApiAsyncUserRestClientImpl implements BybitApiAsyncUserRestClient {

    private final BybitApiService bybitApiService;
    private final BybitJsonConverter converter = new BybitJsonConverter();

    public BybitApiAsyncUserRestClientImpl(String apiKey, String secret, String baseUrl, boolean debugMode, long recvWindow, String logOption) {
        bybitApiService = createService(BybitApiService.class, apiKey, secret, baseUrl, debugMode, recvWindow, logOption, "");
    }

    // pre upgrade endpoints
    @Override
    public void getPreUpgradeOrderHistory(PreUpgradeDataRequest request, BybitApiCallback<Object> callback) {
        bybitApiService.getPreUpgradeOrderHistory(
                request.getCategory().getCategoryTypeId(),
                request.getSymbol(),
                request.getBaseCoin(),
                request.getOrderId(),
                request.getOrderLinkId(),
                request.getOrderFilter(),
                request.getOrderStatus() == null ? null : request.getOrderStatus().getDescription(),
                request.getStartTime(),
                request.getEndTime(),
                request.getLimit(),
                request.getCursor()
        ).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getPreUpgradeTradeHistory(PreUpgradeDataRequest request, BybitApiCallback<Object> callback) {
        bybitApiService.getPreUpgradeTradeHistory(
                request.getCategory().getCategoryTypeId(),
                request.getSymbol(),
                request.getOrderId(),
                request.getOrderLinkId(),
                request.getBaseCoin(),
                request.getStartTime(),
                request.getEndTime(),
                request.getExecType() == null ? null : request.getExecType().getExecTypeId(),
                request.getLimit(),
                request.getCursor()
        ).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getPreUpgradeClosePnl(PreUpgradeDataRequest request, BybitApiCallback<Object> callback) {
        bybitApiService.getPreUpgradeClosePnl(
                request.getCategory().getCategoryTypeId(),
                request.getSymbol(),
                request.getStartTime(),
                request.getEndTime(),
                request.getLimit(),
                request.getCursor()
        ).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getPreUpgradeTransaction(PreUpgradeDataRequest request, BybitApiCallback<Object> callback) {
        bybitApiService.getPreUpgradeTransaction(
                request.getCategory().getCategoryTypeId(),
                request.getBaseCoin(),
                request.getTransactionType() == null ? null : request.getTransactionType().getTransactionTypeId(),
                request.getStartTime(),
                request.getEndTime(),
                request.getLimit(),
                request.getCursor()
        ).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getPreUpgradeOptionDelivery(PreUpgradeDataRequest request, BybitApiCallback<Object> callback) {
        bybitApiService.getPreUpgradeOptionDelivery(
                request.getCategory().getCategoryTypeId(),
                request.getSymbol(),
                request.getExpDate(),
                request.getLimit(),
                request.getCursor()
        ).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getPreUpgradeUsdcSettlement(PreUpgradeDataRequest request, BybitApiCallback<Object> callback) {
        bybitApiService.getPreUpgradeUsdcSettlement(
                request.getCategory().getCategoryTypeId(),
                request.getSymbol(),
                request.getLimit(),
                request.getCursor()
        ).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    // User endpoints
    @Override
    public void createSubMember(UserDataRequest request, BybitApiCallback<Object> callback) {
        UserSubMemberRequest subUserRequest = converter.mapToCreateSubMemberRequest(request);
        bybitApiService.createSubMember(subUserRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void createSubAPI(UserDataRequest request, BybitApiCallback<Object> callback) {
        var createApiKeyRequest = converter.mapToCreateSubApiRequest(request);
        bybitApiService.createSubAPI(createApiKeyRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getSubUIDList(BybitApiCallback<Object> callback) {
        bybitApiService.getSubUIDList().enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void freezeSubMember(UserDataRequest request, BybitApiCallback<Object> callback) {
        var freezeSubUIDRquest = converter.mapToFreezeSubApiRequest(request);
        bybitApiService.freezeSubMember(freezeSubUIDRquest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getCurrentAPIKeyInfo(BybitApiCallback<Object> callback) {
        bybitApiService.getCurrentAPIKeyInfo().enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getUIDWalletType(UserDataRequest request, BybitApiCallback<Object> callback) {
        bybitApiService.getUIDWalletType(request.getMemberIds() == null ? null : listToString(request.getMemberIds())).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void modifyMasterApiKey(UserDataRequest userDataRequest, BybitApiCallback<Object> callback) {
        var modifyMasterApiKeyRequest = converter.mapToModifyApiKeyRequest(userDataRequest);
        bybitApiService.modifyMasterApiKey(modifyMasterApiKeyRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void modifySubApiKey(UserDataRequest userDataRequest, BybitApiCallback<Object> callback) {
        var modifySubApiKeyRequest = converter.mapToModifyApiKeyRequest(userDataRequest);
        bybitApiService.modifySubApiKey(modifySubApiKeyRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void deleteMasterApiKey(BybitApiCallback<Object> callback) {
        bybitApiService.deleteMasterApiKey().enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void deleteSubApiKey(UserDataRequest userDataRequest, BybitApiCallback<Object> callback) {
        var deleteSubApiKeyRequest = converter.mapToDeleteSubApiKeyRequest(userDataRequest);
        bybitApiService.deleteSubApiKey(deleteSubApiKeyRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getAffiliateUserInfo(UserDataRequest userDataRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getAffiliateUserInfo(userDataRequest.getUid()).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getSubUIDListUnlimited(UserDataRequest subUserRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getSubUIDListUnlimited(
                subUserRequest.getPageSize(),
                subUserRequest.getNextCursor()
        ).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getSubUIDListUnlimited(BybitApiCallback<Object> callback) {
        bybitApiService.getSubUIDListUnlimited().enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getSubAccAllAPIKeyInfo(UserDataRequest subUserRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getSubAccAllAPIKeyInfo(
                subUserRequest.getSubMemberId(),
                subUserRequest.getLimit(),
                subUserRequest.getCursor()
        ).enqueue(new BybitApiCallbackAdapter<>(callback));

    }

    @Override
    public void deleteSubMemberV5(DeleteSubMemberV5Request deleteSubMemberV5Request, BybitApiCallback<Object> callback) {
        bybitApiService.deleteSubMemberV5(deleteSubMemberV5Request).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void queryEscrowSubMembersV5(Long nextCursor, Integer pageSize, BybitApiCallback<Object> callback) {
        bybitApiService.queryEscrowSubMembersV5(nextCursor, pageSize).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void queryReferrals(String cursor, Integer size, String status, BybitApiCallback<Object> callback) {
        bybitApiService.queryReferrals(cursor, size, status).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void signAgreement(SignAgreementRequest signAgreementRequest, BybitApiCallback<Object> callback) {
        bybitApiService.signAgreement(signAgreementRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void queryReferralCode(BybitApiCallback<Object> callback) {
        bybitApiService.queryReferralCode().enqueue(new BybitApiCallbackAdapter<>(callback));
    }
}
