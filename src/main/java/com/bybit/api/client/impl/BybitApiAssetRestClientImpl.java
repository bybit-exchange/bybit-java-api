package com.bybit.api.client.impl;

import com.bybit.api.client.restApi.BybitApiAssetRestClient;
import com.bybit.api.client.restApi.BybitApiService;
import com.bybit.api.client.domain.asset.request.AssetDataRequest;
import com.bybit.api.client.domain.asset.request.AssetCancelWithdrawRequest;
import com.bybit.api.client.domain.asset.request.SetAssetDepositAccountRequest;
import com.bybit.api.client.service.BybitJsonConverter;

import java.util.HashMap;
import java.util.Map;

import static com.bybit.api.client.service.BybitApiServiceGenerator.createService;
import static com.bybit.api.client.service.BybitApiServiceGenerator.executeSync;
import com.bybit.api.client.domain.asset.request.SmallAssetConvertRequest;
import com.bybit.api.client.domain.asset.request.SmallAssetQuoteRequest;
import com.bybit.api.client.domain.asset.request.TransferSubMemberSaveRequest;

public class BybitApiAssetRestClientImpl implements BybitApiAssetRestClient {
    private final BybitApiService bybitApiService;
    private final BybitJsonConverter converter = new BybitJsonConverter();

    public BybitApiAssetRestClientImpl(BybitApiService bybitApiService){
        this.bybitApiService = bybitApiService;
    }

    public BybitApiAssetRestClientImpl(String apiKey, String secret, String baseUrl, boolean debugMode, long recvWindow, String logOption) {
        bybitApiService = createService(BybitApiService.class, apiKey, secret, baseUrl, debugMode, recvWindow, logOption, "");
    }

    // Asset Endpoints
    @Override
    public Object getAssetCoinExchangeRecords(AssetDataRequest coinExchangeRecordsRequest) {
        return executeSync(bybitApiService.getAssetCoinExchangeRecords(
                coinExchangeRecordsRequest.getFromCoin(),
                coinExchangeRecordsRequest.getToCoin(),
                coinExchangeRecordsRequest.getLimit(),
                coinExchangeRecordsRequest.getCursor()
        ));
    }

    @Override
    public Object getAssetDeliveryRecords(AssetDataRequest deliveryRecordsRequest) {
        return executeSync(bybitApiService.getAssetDeliveryRecords(
                deliveryRecordsRequest.getCategory() == null ? null : deliveryRecordsRequest.getCategory().getCategoryTypeId(),
                deliveryRecordsRequest.getSymbol(),
                deliveryRecordsRequest.getExpDate(),
                deliveryRecordsRequest.getLimit(),
                deliveryRecordsRequest.getCursor())
        );
    }

    @Override
    public Object getAssetUSDCSettlementRecords(AssetDataRequest usdcSettlementRequest) {
        return executeSync(bybitApiService.getAssetUSDCSettlementRecords(
                usdcSettlementRequest.getCategory() == null ? null : usdcSettlementRequest.getCategory().getCategoryTypeId(),
                usdcSettlementRequest.getSymbol(),
                usdcSettlementRequest.getLimit(),
                usdcSettlementRequest.getCursor())
        );
    }

    @Override
    public Object getAssetInfo(AssetDataRequest assetInfoRequest) {
        return executeSync(bybitApiService.getAssetInfo(
                assetInfoRequest.getAccountType() == null ? null : assetInfoRequest.getAccountType().getAccountTypeValue(),
                assetInfoRequest.getCoin())
        );
    }

    @Override
    public Object getAssetAllCoinsBalance(AssetDataRequest allCoinsBalanceRequest) {
        return executeSync(bybitApiService.getAssetAllCoinsBalance(
                allCoinsBalanceRequest.getAccountType() == null ? null : allCoinsBalanceRequest.getAccountType().getAccountTypeValue(),
                allCoinsBalanceRequest.getMemberId(),
                allCoinsBalanceRequest.getCoin(),
                allCoinsBalanceRequest.getWithBonus() == null ? null : String.valueOf(allCoinsBalanceRequest.getWithBonus().getValue()))
        );
    }

    @Override
    public Object getAssetTransferableCoins(AssetDataRequest request) {
        return executeSync(bybitApiService.getAssetTransferableCoins(
                request.getFromAccountType() == null ? null : request.getFromAccountType().getAccountTypeValue(),
                request.getToAccountType() == null ? null : request.getToAccountType().getAccountTypeValue()));
    }

    @Override
    public Object getAssetSingleCoinBalance(AssetDataRequest singleCoinBalanceRequest) {
        return executeSync(converter.getSingleCoinBalance(bybitApiService, singleCoinBalanceRequest)
        );
    }

    @Override
    public Object createAssetInternalTransfer(AssetDataRequest assetInternalTransferRequest) {
        var request = converter.mapToAssetInternalTransferRequest(assetInternalTransferRequest);
        return executeSync(bybitApiService.createAssetInternalTransfer(request));
    }

    @Override
    public Object getAssetTransferSubUidList() {
        return executeSync(bybitApiService.getAssetTransferSubUidList());
    }

    @Override
    public Object createAssetUniversalTransfer(AssetDataRequest assetUniversalTransferRequest) {
        var request = converter.mapToAssetUniversalTransferRequest(assetUniversalTransferRequest);
        return executeSync(bybitApiService.createAssetUniversalTransfer(request));
    }

    @Override
    public Object getAssetInternalTransferRecords(AssetDataRequest internalTransferRequest) {
        return executeSync(bybitApiService.getAssetInternalTransferRecords(
                internalTransferRequest.getTransferId(),
                internalTransferRequest.getCoin(),
                internalTransferRequest.getTransferStatus() == null ? null : internalTransferRequest.getTransferStatus().getStatus(),
                internalTransferRequest.getStartTime(),
                internalTransferRequest.getEndTime(),
                internalTransferRequest.getLimit(),
                internalTransferRequest.getCursor())
        );
    }

    @Override
    public Object getAssetUniversalTransferRecords(AssetDataRequest universalTransferRequest) {
        return executeSync(bybitApiService.getAssetUniversalTransferRecords(
                universalTransferRequest.getTransferId(),
                universalTransferRequest.getCoin(),
                universalTransferRequest.getTransferStatus() == null ? null : universalTransferRequest.getTransferStatus().getStatus(),
                universalTransferRequest.getStartTime(),
                universalTransferRequest.getEndTime(),
                universalTransferRequest.getLimit(),
                universalTransferRequest.getCursor())
        );
    }

    @Override
    public Object getAssetAllowedDepositCoinInfo(AssetDataRequest allowedDepositCoinRequest) {
        return executeSync(bybitApiService.getAssetAllowedDepositCoinInfo(
                allowedDepositCoinRequest.getCoin(),
                allowedDepositCoinRequest.getChain(),
                allowedDepositCoinRequest.getLimit(),
                allowedDepositCoinRequest.getCursor())
        );
    }

    @Override
    public Object setAssetDepositAccount(AssetDataRequest request) {
        SetAssetDepositAccountRequest setAssetDepositAccountRequest = converter.mapToSetDepositAccountRequest(request);
        return executeSync(bybitApiService.setAssetDepositAccount(setAssetDepositAccountRequest));
    }

    @Override
    public Object getAssetDepositRecords(AssetDataRequest assetDepositRecordsRequest) {
        return executeSync(bybitApiService.getAssetDepositRecords(
                assetDepositRecordsRequest.getCoin(),
                assetDepositRecordsRequest.getStartTime(),
                assetDepositRecordsRequest.getEndTime(),
                assetDepositRecordsRequest.getLimit(),
                assetDepositRecordsRequest.getCursor())
        );
    }

    @Override
    public Object getAssetSubMembersDepositRecords(AssetDataRequest assetDepositRecordsRequest) {
        return executeSync(bybitApiService.getAssetSubMembersDepositRecords(
                assetDepositRecordsRequest.getSubMemberId(),
                assetDepositRecordsRequest.getCoin(),
                assetDepositRecordsRequest.getStartTime(),
                assetDepositRecordsRequest.getEndTime(),
                assetDepositRecordsRequest.getLimit(),
                assetDepositRecordsRequest.getCursor())
        );
    }

    @Override
    public Object getAssetInternalDepositRecords(AssetDataRequest assetDepositRecordsRequest) {
        return executeSync(bybitApiService.getAssetInternalDepositRecords(
                assetDepositRecordsRequest.getCoin(),
                assetDepositRecordsRequest.getStartTime(),
                assetDepositRecordsRequest.getEndTime(),
                assetDepositRecordsRequest.getLimit(),
                assetDepositRecordsRequest.getCursor())
        );
    }

    @Override
    public Object getAssetMasterDepositAddress(AssetDataRequest masterDepositRequest) {
        return executeSync(bybitApiService.getAssetMasterDepositAddress(
                masterDepositRequest.getCoin(),
                masterDepositRequest.getChainType()
        ));
    }

    @Override
    public Object getAssetSubMemberDepositAddress(AssetDataRequest subDepositRequest) {
        return executeSync(bybitApiService.getAssetSubMemberDepositAddress(
                subDepositRequest.getCoin(),
                subDepositRequest.getChainType(),
                subDepositRequest.getSubMemberId()
        ));
    }

    @Override
    public Object getAssetCoinInfo(AssetDataRequest request) {
        return executeSync(bybitApiService.getAssetCoinInfo(request.getCoin()));
    }

    @Override
    public Object getAssetWithdrawalAmount(AssetDataRequest request) {
        return executeSync(bybitApiService.getAssetWithdrawalAmount(request.getCoin()));
    }

    @Override
    public Object getAssetWithdrawalRecords(AssetDataRequest assetWithdrawRecordsRequest) {
        return executeSync(bybitApiService.getAssetWithdrawalRecords(
                assetWithdrawRecordsRequest.getWithdrawID(),
                assetWithdrawRecordsRequest.getCoin(),
                assetWithdrawRecordsRequest.getWithdrawType() == null ? null : assetWithdrawRecordsRequest.getWithdrawType().getValue(),
                assetWithdrawRecordsRequest.getStartTime(),
                assetWithdrawRecordsRequest.getEndTime(),
                assetWithdrawRecordsRequest.getLimit(),
                assetWithdrawRecordsRequest.getCursor()
        ));
    }

    @Override
    public Object cancelAssetWithdraw(AssetDataRequest request) {
        AssetCancelWithdrawRequest assetCancelWithdrawRequest = converter.mapToAssetCancelWithdrawRequest(request);
        return executeSync(bybitApiService.cancelAssetWithdraw(assetCancelWithdrawRequest));
    }

    @Override
    public Object createAssetWithdraw(AssetDataRequest assetWithdrawRequest) {
        var request = converter.mapToAssetWithdrawRequest(assetWithdrawRequest);
        return executeSync(bybitApiService.createAssetWithdraw(request));
    }

    @Override
    public Object requestQuote(AssetDataRequest assetQuoteRequest) {
        var request = converter.mapToAssetQuoteRequest(assetQuoteRequest);
        return executeSync(bybitApiService.requestQuote(request));
    }

    @Override
    public Object confirmQuote(String quoteTxId) {
        Map<String, String> map = new HashMap<>();
        map.put("quoteTxId", quoteTxId);
        return executeSync(bybitApiService.confirmQuote(map));
    }

    @Override
    public Object confirmQuote(AssetDataRequest assetQuoteRequest) {
        var request = converter.mapToAssetConfirmQuoteRequest(assetQuoteRequest);
        return executeSync(bybitApiService.confirmQuote(request));
    }

    @Override
    public Object getConvertCoinList(AssetDataRequest request) {
        return executeSync(bybitApiService.getConvertCoinList(
                request.getCoin(),
                request.getSide(),
                request.getAccountType() == null ? null : request.getAccountType().getAccountTypeValue()));
    }

    @Override
    public Object getConvertCoinStatus(AssetDataRequest request) {
        return executeSync(bybitApiService.getConvertCoinStatus(
                request.getQuoteTxId(),
                request.getAccountType() == null ? null : request.getAccountType().getAccountTypeValue()));
    }

    @Override
    public Object getConvertCoinHistory(AssetDataRequest request) {
        return executeSync(bybitApiService.getConvertCoinHistory(
                request.getAccountType() == null ? null : request.getAccountType().getAccountTypeValue(),
                request.getIndex(),
                request.getLimit()
                ));
    }

    @Override
    public Object queryFundingDetail(String createTimeFrom, String createTimeTo, Integer limit, String cursor) {
        return executeSync(bybitApiService.queryFundingDetail(createTimeFrom, createTimeTo, limit, cursor));
    }

    @Override
    public Object transferSubMemberSave(TransferSubMemberSaveRequest transferSubMemberSaveRequest) {
        return executeSync(bybitApiService.transferSubMemberSave(transferSubMemberSaveRequest));
    }

    @Override
    public Object queryWithdrawAddresses(String coin, String chain, Long addressType, Integer limit, String cursor) {
        return executeSync(bybitApiService.queryWithdrawAddresses(coin, chain, addressType, limit, cursor));
    }

    @Override
    public Object getVASPList() {
        return executeSync(bybitApiService.getVASPList());
    }

    @Override
    public Object getAssetOverview(String accountType, String memberId, String valuationCurrency) {
        return executeSync(bybitApiService.getAssetOverview(accountType, memberId, valuationCurrency));
    }

    @Override
    public Object getPortfolioMargin(String baseCoin) {
        return executeSync(bybitApiService.getPortfolioMargin(baseCoin));
    }

    @Override
    public Object getTotalMembersAssets(String coin) {
        return executeSync(bybitApiService.getTotalMembersAssets(coin));
    }

    @Override
    public Object smallAssetConvert(SmallAssetConvertRequest smallAssetConvertRequest) {
        return executeSync(bybitApiService.smallAssetConvert(smallAssetConvertRequest));
    }

    @Override
    public Object querySmallAssetConvertOrder(String accountType, String quoteId, String cursor, String size, String startTime, String endTime) {
        return executeSync(bybitApiService.querySmallAssetConvertOrder(accountType, quoteId, cursor, size, startTime, endTime));
    }

    @Override
    public Object querySmallAssetList(String accountType, String fromCoin) {
        return executeSync(bybitApiService.querySmallAssetList(accountType, fromCoin));
    }

    @Override
    public Object smallAssetQuote(SmallAssetQuoteRequest smallAssetQuoteRequest) {
        return executeSync(bybitApiService.smallAssetQuote(smallAssetQuoteRequest));
    }
}
