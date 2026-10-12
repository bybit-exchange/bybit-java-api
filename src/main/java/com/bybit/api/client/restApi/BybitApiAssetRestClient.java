package com.bybit.api.client.restApi;

import com.bybit.api.client.domain.asset.request.AssetDataRequest;
import com.bybit.api.client.domain.asset.request.SmallAssetConvertRequest;
import com.bybit.api.client.domain.asset.request.SmallAssetQuoteRequest;
import com.bybit.api.client.domain.asset.request.TransferSubMemberSaveRequest;

public interface BybitApiAssetRestClient {
    // Asset Endpoints
    Object getAssetCoinExchangeRecords(AssetDataRequest coinExchangeRecordsRequest);
    Object getAssetDeliveryRecords(AssetDataRequest deliveryRecordsRequest);
    Object getAssetUSDCSettlementRecords(AssetDataRequest usdcSettlementRequest);
    Object getAssetInfo(AssetDataRequest assetInfoRequest);
    Object getAssetAllCoinsBalance(AssetDataRequest allCoinsBalanceRequest);
    Object getAssetTransferableCoins(AssetDataRequest request);
    Object getAssetSingleCoinBalance(AssetDataRequest singleCoinBalanceRequest);
    Object createAssetInternalTransfer(AssetDataRequest assetInternalTransferRequest);
    Object getAssetTransferSubUidList();
    Object createAssetUniversalTransfer(AssetDataRequest assetUniversalTransferRequest);
    Object getAssetInternalTransferRecords(AssetDataRequest internalTransferRequest);
    Object getAssetUniversalTransferRecords(AssetDataRequest universalTransferRequest);
    Object getAssetAllowedDepositCoinInfo(AssetDataRequest allowedDepositCoinRequest);
    Object setAssetDepositAccount(AssetDataRequest request);
    Object getAssetDepositRecords(AssetDataRequest assetDepositRecordsRequest);
    Object getAssetSubMembersDepositRecords(AssetDataRequest assetDepositRecordsRequest);
    Object getAssetInternalDepositRecords(AssetDataRequest assetDepositRecordsRequest);
    Object getAssetMasterDepositAddress(AssetDataRequest masterDepositRequest);
    Object getAssetSubMemberDepositAddress(AssetDataRequest subDepositRequest);
    Object getAssetCoinInfo(AssetDataRequest request);
    Object getAssetWithdrawalAmount(AssetDataRequest request);
    Object getAssetWithdrawalRecords(AssetDataRequest assetWithdrawRecordsRequest);
    Object cancelAssetWithdraw(AssetDataRequest request);
    Object createAssetWithdraw(AssetDataRequest assetWithdrawRequest);
    // convert coin endpoints
    Object requestQuote(AssetDataRequest assetQuoteRequest);
    Object confirmQuote(String quoteTxId);
    Object confirmQuote(AssetDataRequest assetQuoteRequest);
    Object getConvertCoinList(AssetDataRequest request);
    Object getConvertCoinStatus(AssetDataRequest request);
    Object getConvertCoinHistory(AssetDataRequest request);
    default Object queryFundingDetail(String createTimeFrom, String createTimeTo, Integer limit, String cursor) {
        throw new UnsupportedOperationException("queryFundingDetail is not implemented by this client");
    }

    Object transferSubMemberSave(TransferSubMemberSaveRequest transferSubMemberSaveRequest);

    Object queryWithdrawAddresses(String coin, String chain, Long addressType, Integer limit, String cursor);

    Object getVASPList();

    Object getAssetOverview(String accountType, String memberId, String valuationCurrency);

    Object getPortfolioMargin(String baseCoin);

    Object getTotalMembersAssets(String coin);

    Object smallAssetConvert(SmallAssetConvertRequest smallAssetConvertRequest);

    Object querySmallAssetConvertOrder(String accountType, String quoteId, String cursor, String size, String startTime, String endTime);

    Object querySmallAssetList(String accountType, String fromCoin);

    Object smallAssetQuote(SmallAssetQuoteRequest smallAssetQuoteRequest);
}
