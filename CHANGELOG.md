## 1.6.1 — 2026-10-12

### New Methods (37)
- getSmpGroup
- getTransactionLogGet
- demoApplyMoney
- getOptionAssetInfo
- getPayInfo
- getTradeInfoForAnalysis
- getOptionBaseCoins
- listEarnAutoSavings
- editEarnAutoSavings
- transferSubMemberSave *(deprecated compatibility API)*
- queryWithdrawAddresses
- getVASPList
- getAssetOverview
- getPortfolioMargin
- getTotalMembersAssets
- smallAssetConvert
- querySmallAssetConvertOrder
- querySmallAssetList
- smallAssetQuote
- getPositionSymbolInfo
- getSpotMarginTradeCoinState
- getSpotMarginTradeFlexibleAvailableInventory
- getSpotMarginTradeMaxBorrowable
- getSpotMarginTradeRepaymentAvailableAmount
- queryFixedAvailableInventory
- queryFixedBorrowContracts
- queryFixedBorrowOrders
- queryFixedBorrowMarket
- renewFixedBorrow
- accountFixedBorrow
- queryBorrowLiability
- getSpreadMaxQty
- insLoanCoinDeltaAmount
- insLoanDelayLiqStatus
- insLoanEnsureTokens *(deprecated compatibility API)*
- insLoanRepayLoan
- queryReferralCode

### New Request Beans (8)
- UtaDemoApplyMoneyRequest
- EditAutoSavingsRequest
- TransferSubMemberSaveRequest
- SmallAssetConvertRequest
- SmallAssetQuoteRequest
- RenewFixedBorrowRequest
- FixedBorrowRequest
- RepayLoanRequest

### Deprecated Compatibility APIs
- `transferSubMemberSave` remains callable for compatibility, but transferable sub UIDs no longer require explicit configuration.
- `insLoanEnsureTokens` remains callable for compatibility and is marked deprecated to match its status in the official API documentation.

# Changelog

## 1.6.0 — 2026-08-07

### Fixed — Broker Earnings Info
- `getBrokerEarningData` (`GET /v5/broker/earnings-info`) parameters aligned with the official docs:
  - `startTime` (Long) → `begin` (String, `YYYYMMDD`)
  - `endTime` (Long) → `end` (String, `YYYYMMDD`)
  - Added `uid` (String) — filter earnings by a specific sub UID
  - Javadoc / response fields updated to reflect the latest schema
    (`totalEarningCat`, `markupEarning`, `baseFeeEarning`, `execId`, `CONVERT` bizType)

### Breaking Changes
- `BybitApiService#getBrokerEarningData` signature changed. Callers using
  `BrokerDataRequest#setStartTime` / `setEndTime` for this endpoint must switch to
  the new `begin` / `end` / `uid` fields on `BrokerDataRequest`.
  (`startTime` / `endTime` remain in `BrokerDataRequest` for other broker endpoints.)

## 1.5.0 — 2026-07-09

### Added — New Clients
- BybitApiEarnRestClient / BybitApiAsyncEarnRestClient (69 methods)
- BybitApiFiatRestClient / BybitApiAsyncFiatRestClient (7 methods)
- BybitApiP2pRestClient / BybitApiAsyncP2pRestClient (17 methods)
- New factory methods: `newEarnRestClient` / `newAsyncEarnRestClient` / `newFiatRestClient` / `newAsyncFiatRestClient` / `newP2pRestClient` / `newAsyncP2pRestClient`

### Binary Compatibility
- 30 methods added to existing sync interfaces and 30 methods added to their async counterparts
  (Account/Trade/Market/User/Affiliate/Asset/Broker/Rfq/SpotMargin).
  All new interface methods are declared `default` (throwing `UnsupportedOperationException`)
  so existing downstream implementers remain source- and binary-compatible.

### New Methods (121)
- getAccountInstruments
- getDcpInfo
- getTransferableAmount
- getUserSettings
- manualBorrow
- manualRepay
- noConvertRepay
- oneClickRepay
- setPriceLimit
- getAffiliateSubList
- queryFundingDetail
- queryBrokerAllUidDetails
- queryBrokerCap
- setBrokerApiLimit
- addLiquidity
- addMargin
- claimLiquidityInterest
- getAdvanceEarnOrder
- getAdvanceEarnPosition
- getAdvanceEarnProduct
- getAdvanceEarnProductExtraInfo
- getDoubleWinLeverage
- getEarnAprHistory
- getEarnHourlyYieldHistory
- getEarnOrderHistory
- getEarnPosition
- getEarnProduct
- getEarnYieldHistory
- getFixedTermOrder
- getFixedTermPosition
- getFixedTermProduct
- getHoldToEarnProduct
- getHoldToEarnYieldHistory
- getLiquidityMiningLiquidationRecords
- getLiquidityMiningOrders
- getLiquidityMiningPositions
- getLiquidityMiningProducts
- getLiquidityMiningYieldRecords
- getRwaNavChart
- getRwaOrderList
- getRwaPositionList
- getRwaProductList
- getSmartLeverageRedeemEstAmountList
- getTokenDailyYield
- getTokenHistoricalApr
- getTokenHourlyYield
- getTokenOrderList
- getTokenPosition
- getTokenProduct
- listEarnCoupons
- modifyEarnPosition
- placeAdvanceEarnOrder
- placeEarnOrder
- placeFixedTermOrder
- placeRwaOrder
- placeTokenOrder
- pwmAssetTrend
- pwmClaim
- pwmCreateCustomPlan
- pwmFundNav
- pwmFundTransfer
- pwmGetNewPlanDetail
- pwmGetPlanDetail
- pwmInstCreateFund
- pwmInstCreateInvestmentPlan
- pwmInstCreateSubAccount
- pwmInstGetInvestmentPlans
- pwmInstListFunds
- pwmInstListOrders
- pwmInstManageInvestmentPlan
- pwmInstManageOrder
- pwmInstSettleProfit
- pwmInvestMore
- pwmListInvestmentPlans
- pwmListOrder
- pwmListProductCards
- pwmQueryFundTransferResult
- pwmRedeem
- pwmSubscribe
- redeemFixedTerm
- reinvestLiquidity
- removeLiquidity
- setFixedTermAutoInvest
- applyQuote
- confirmQuote
- getReferencePrice
- queryBalance
- queryCoinList
- queryTrade
- queryTradeHistory
- getAdlAlert
- getFeeGroupInfo
- getIndexPriceComponents
- getNewDeliveryPrice
- getOrderPriceLimit
- getRpiOrderbook
- getAccountInfo
- getAds
- getAllOrders
- getChatMessages
- getCounterpartyUserInfo
- getMyAdDetails
- getMyAds
- getOrderDetail
- getPendingOrders
- getUserPayment
- markOrderAsPaid
- postAd
- releaseAssets
- removeAd
- sendChatMessage
- updateAd
- uploadChatFile
- acceptNonLpQuote
- getPositionTiers
- getTieredCollateralRatio
- preCheckOrder
- deleteSubMemberV5
- queryEscrowSubMembersV5
- queryReferrals
- signAgreement

### New Request Beans (54)
- ManualBorrowRequest
- ManualRepayRequest
- NoConvertRepayRequest
- OneClickRepayRequest
- SetPriceLimitRequest
- SetBrokerApiLimitRequest
- AddLiquidityRequest
- AddMarginRequest
- ClaimLiquidityInterestRequest
- ModifyEarnPositionRequest
- PlaceAdvanceEarnOrderRequest
- PlaceEarnOrderRequest
- PlaceFixedTermOrderRequest
- PlaceRwaOrderRequest
- PlaceTokenOrderRequest
- PwmClaimRequest
- PwmCreateCustomPlanRequest
- PwmFundTransferRequest
- PwmInstCreateFundRequest
- PwmInstCreateInvestmentPlanRequest
- PwmInstCreateSubAccountRequest
- PwmInstManageInvestmentPlanRequest
- PwmInstManageOrderRequest
- PwmInstSettleProfitRequest
- PwmInvestMoreRequest
- PwmRedeemRequest
- PwmSubscribeRequest
- RedeemFixedTermRequest
- ReinvestLiquidityRequest
- RemoveLiquidityRequest
- SetFixedTermAutoInvestRequest
- ApplyQuoteRequest
- ConfirmQuoteV2Request
- GetAccountInfoRequest
- GetAdsRequest
- GetAllOrdersRequest
- GetChatMessagesRequest
- GetCounterpartyUserInfoRequest
- GetMyAdDetailsRequest
- GetMyAdsRequest
- GetOrderDetailRequest
- GetPendingOrdersRequest
- GetUserPaymentRequest
- MarkOrderAsPaidRequest
- PostAdRequest
- ReleaseAssetsRequest
- RemoveAdRequest
- SendChatMessageRequest
- UpdateAdRequest
- AcceptNonLpQuoteRequest
- PreCheckOrderRequest
- DeleteSubMemberV5Request
- SignAgreementRequest
