package com.bybit.api.client.restApi;

import com.bybit.api.client.domain.asset.request.AssetDataRequest;
import com.bybit.api.client.domain.asset.request.SmallAssetConvertRequest;
import com.bybit.api.client.domain.asset.request.SmallAssetQuoteRequest;
import com.bybit.api.client.domain.asset.request.TransferSubMemberSaveRequest;

public interface BybitApiAsyncAssetRestClient {
    // Asset Endpoints
    void getAssetCoinExchangeRecords(AssetDataRequest assetDataRequest, BybitApiCallback<Object> callback);
    void getAssetDeliveryRecords(AssetDataRequest deliveryReco, BybitApiCallback<Object> callbackrdsRequest);
    void getAssetUSDCSettlementRecords(AssetDataRequest usdcSettlementRequest, BybitApiCallback<Object> callback);
    void getAssetInfo(AssetDataRequest assetInfoRequest, BybitApiCallback<Object> callback);
    void getAssetAllCoinsBalance(AssetDataRequest allCoinsBalanceRequest, BybitApiCallback<Object> callback);
    void getAssetTransferableCoins(AssetDataRequest request, BybitApiCallback<Object> callback);
    void getAssetSingleCoinBalance(AssetDataRequest singleCoinBalanceRequest, BybitApiCallback<Object> callback);
    void createAssetInternalTransfer(AssetDataRequest assetInternalTransferRequest, BybitApiCallback<Object> callback);
    void getAssetTransferSubUidList(BybitApiCallback<Object> callback);
    void createAssetUniversalTransfer(AssetDataRequest assetUniversalTransferRequest, BybitApiCallback<Object> callback);
    void getAssetInternalTransferRecords(AssetDataRequest internalTransferRequest, BybitApiCallback<Object> callback);
    void getAssetUniversalTransferRecords(AssetDataRequest universalTransferRequest, BybitApiCallback<Object> callback);
    void getAssetAllowedDepositCoinInfo(AssetDataRequest allowedDepositCoinRequest, BybitApiCallback<Object> callback);
    void setAssetDepositAccount(AssetDataRequest request, BybitApiCallback<Object> callback);
    void getAssetDepositRecords(AssetDataRequest assetDepositRecordsRequest, BybitApiCallback<Object> callback);
    void getAssetSubMembersDepositRecords(AssetDataRequest assetDepositRecordsRequest, BybitApiCallback<Object> callback);
    void getAssetInternalDepositRecords(AssetDataRequest assetDepositRecordsRequest, BybitApiCallback<Object> callback);
    void getAssetMasterDepositAddress(AssetDataRequest masterDepositRequest, BybitApiCallback<Object> callback);
    void getAssetSubMemberDepositAddress(AssetDataRequest subDepositRequest, BybitApiCallback<Object> callback);
    void getAssetCoinInfo(AssetDataRequest request, BybitApiCallback<Object> callback);
    void getAssetWithdrawalAmount(AssetDataRequest request, BybitApiCallback<Object> callback);
    void getAssetWithdrawalRecords(AssetDataRequest assetWithdrawRecordsRequest, BybitApiCallback<Object> callback);
    void cancelAssetWithdraw(AssetDataRequest request, BybitApiCallback<Object> callback);
    void createAssetWithdraw(AssetDataRequest assetWithdrawRequest, BybitApiCallback<Object> callback);
    // convert coin endpoints
    void requestQuote(AssetDataRequest assetQuoteRequest,BybitApiCallback<Object> callback);
    void confirmQuote(String quoteTxId, BybitApiCallback<Object> callback);

    void confirmQuote(AssetDataRequest assetQuoteRequest, BybitApiCallback<Object> callback);

    void getConvertCoinList(AssetDataRequest request, BybitApiCallback<Object> callback);
    void getConvertCoinStatus(AssetDataRequest request, BybitApiCallback<Object> callback);
    void getConvertCoinHistory(AssetDataRequest request, BybitApiCallback<Object> callback);

    default void queryFundingDetail(String createTimeFrom, String createTimeTo, Integer limit, String cursor, BybitApiCallback<Object> callback) {
        throw new UnsupportedOperationException("queryFundingDetail is not implemented by this client");
    }

    default void transferSubMemberSave(TransferSubMemberSaveRequest transferSubMemberSaveRequest, BybitApiCallback<Object> callback) {
        throw new UnsupportedOperationException("transferSubMemberSave is not implemented by this client");
    }

    default void queryWithdrawAddresses(String coin, String chain, Long addressType, Integer limit, String cursor, BybitApiCallback<Object> callback) {
        throw new UnsupportedOperationException("queryWithdrawAddresses is not implemented by this client");
    }

    default void getVASPList(BybitApiCallback<Object> callback) {
        throw new UnsupportedOperationException("getVASPList is not implemented by this client");
    }

    default void getAssetOverview(String accountType, String memberId, String valuationCurrency, BybitApiCallback<Object> callback) {
        throw new UnsupportedOperationException("getAssetOverview is not implemented by this client");
    }

    default void getPortfolioMargin(String baseCoin, BybitApiCallback<Object> callback) {
        throw new UnsupportedOperationException("getPortfolioMargin is not implemented by this client");
    }

    default void getTotalMembersAssets(String coin, BybitApiCallback<Object> callback) {
        throw new UnsupportedOperationException("getTotalMembersAssets is not implemented by this client");
    }

    default void smallAssetConvert(SmallAssetConvertRequest smallAssetConvertRequest, BybitApiCallback<Object> callback) {
        throw new UnsupportedOperationException("smallAssetConvert is not implemented by this client");
    }

    default void querySmallAssetConvertOrder(String accountType, String quoteId, String cursor, String size, String startTime, String endTime, BybitApiCallback<Object> callback) {
        throw new UnsupportedOperationException("querySmallAssetConvertOrder is not implemented by this client");
    }

    default void querySmallAssetList(String accountType, String fromCoin, BybitApiCallback<Object> callback) {
        throw new UnsupportedOperationException("querySmallAssetList is not implemented by this client");
    }

    default void smallAssetQuote(SmallAssetQuoteRequest smallAssetQuoteRequest, BybitApiCallback<Object> callback) {
        throw new UnsupportedOperationException("smallAssetQuote is not implemented by this client");
    }
}
