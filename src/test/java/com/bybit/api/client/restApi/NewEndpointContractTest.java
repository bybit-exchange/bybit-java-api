package com.bybit.api.client.restApi;

import com.bybit.api.client.constant.BybitApiConstants;
import com.bybit.api.client.domain.account.request.UtaDemoApplyMoney;
import com.bybit.api.client.domain.account.request.UtaDemoApplyMoneyRequest;
import com.bybit.api.client.domain.asset.request.SmallAssetQuoteRequest;
import com.bybit.api.client.domain.asset.request.TransferSubMemberSaveRequest;
import com.bybit.api.client.impl.BybitApiAssetRestClientImpl;
import com.bybit.api.client.impl.BybitApiAsyncAssetRestClientImpl;
import com.bybit.api.client.impl.BybitApiAsyncLendingRestClientImpl;
import com.bybit.api.client.impl.BybitApiLendingRestClientImpl;
import com.bybit.api.client.service.BybitApiClientFactory;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;
import retrofit2.http.Headers;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class NewEndpointContractTest {

    private static final Set<String> NEW_METHODS = new HashSet<>(Arrays.asList(
            "getSmpGroup", "getTransactionLogGet", "demoApplyMoney", "getOptionAssetInfo",
            "getPayInfo", "getTradeInfoForAnalysis", "getOptionBaseCoins", "listEarnAutoSavings",
            "editEarnAutoSavings", "transferSubMemberSave", "queryWithdrawAddresses", "getVASPList",
            "getAssetOverview", "getPortfolioMargin", "getTotalMembersAssets", "smallAssetConvert",
            "querySmallAssetConvertOrder", "querySmallAssetList", "smallAssetQuote",
            "getPositionSymbolInfo", "getSpotMarginTradeCoinState",
            "getSpotMarginTradeFlexibleAvailableInventory", "getSpotMarginTradeMaxBorrowable",
            "getSpotMarginTradeRepaymentAvailableAmount", "queryFixedAvailableInventory",
            "queryFixedBorrowContracts", "queryFixedBorrowOrders", "queryFixedBorrowMarket",
            "renewFixedBorrow", "accountFixedBorrow", "queryBorrowLiability", "getSpreadMaxQty",
            "insLoanCoinDeltaAmount", "insLoanDelayLiqStatus", "insLoanEnsureTokens",
            "insLoanRepayLoan", "queryReferralCode"));

    private static final Set<String> SIGNED_METHODS = new HashSet<>(NEW_METHODS);

    static {
        SIGNED_METHODS.remove("getOptionBaseCoins");
    }

    private static final Set<String> BRANCH_PRIVATE_METHODS = new HashSet<>(Arrays.asList(
            "postCryptoLoanCommonAdjustLtv", "getCryptoLoanCommonAdjustmentHistory",
            "getCryptoLoanCommonCollateralData", "getCryptoLoanCommonLoanableData",
            "getCryptoLoanCommonMaxCollateralAmount", "postCryptoLoanCommonMaxLoan",
            "getCryptoLoanCommonPosition", "getCryptoLoanFixedAvailableInventory",
            "getCryptoLoanFixedBorrowContractInfo", "postCryptoLoanFixedBorrowOrderCancel",
            "getCryptoLoanFixedBorrowOrderInfo", "getCryptoLoanFixedBorrowOrderQuote",
            "postCryptoLoanFixedBorrow", "postCryptoLoanFixedFullyRepay",
            "getCryptoLoanFixedRenewInfo", "postCryptoLoanFixedRenew",
            "postCryptoLoanFixedRepayCollateral", "getCryptoLoanFixedRepaymentHistory",
            "getCryptoLoanFixedSupplyContractInfo", "postCryptoLoanFixedSupplyOrderCancel",
            "getCryptoLoanFixedSupplyOrderInfo", "getCryptoLoanFixedSupplyOrderQuote",
            "postCryptoLoanFixedSupply", "getCryptoLoanFlexibleAvailableInventory",
            "getCryptoLoanFlexibleBorrowHistory", "postCryptoLoanFlexibleBorrow",
            "getCryptoLoanFlexibleOngoingCoin", "postCryptoLoanFlexibleRepayCollateral",
            "postCryptoLoanFlexibleRepay", "getCryptoLoanFlexibleRepaymentHistory",
            "closeComboBot", "createComboBot", "getComboDetail", "getComboLimit",
            "getFGridDetail", "closeFGridBot", "createFGridBot", "validateFGridInput",
            "closeFMartBot", "createFMartBot", "getFMartDetail", "getFMartLimit",
            "closeDCABot", "createDCABot", "closeGridBot", "createGridBot",
            "queryGridDetail", "validateGridInput", "createStrategy",
            "queryStrategyOrderList", "queryStrategyList", "stopStrategy", "getLPOrderList",
            "getLPPayTokenList", "getLPPayTokenPrice", "getLPPoolInfo", "getLPPoolList",
            "getLPPositionList", "executeLPRedeem", "executeLPStake",
            "executePredictionBuy", "getPredictionEngineStatus", "getPredictionEventDetail",
            "getPredictionOrderBook", "getPredictionOrderEstimate", "getPredictionOrderList",
            "getPredictionPayTokenList", "getPredictionPortfolioSummary",
            "getPredictionPositionHistory", "getPredictionPositionList",
            "getPredictionPriceHistory", "executePredictionSell",
            "getPredictionSideMarketList", "getPredictionGroupStageDetail",
            "getPredictionMatchList", "getPredictionTimelineStages", "getPredictionTokenPrice",
            "getAssetDetail", "getAssetList", "getBizTokenDetails", "getBizTokenList",
            "getBizTokenPriceList", "getOrderList", "getPayTokenList", "executePurchase",
            "getTradeQuote", "executeRedeem", "getLaunchpoolProjectList",
            "getLaunchpoolUserActivityLog", "getLaunchpoolUserCurrentStaking",
            "getLaunchpoolUserHistory", "getPuzzleProjectList", "getTokenSplashProjectList",
            "getTokenSplashUserActivityParams", "placeStocksOrder", "cancelStocksOrder",
            "getStocksOrderDetail", "getConvertList", "submitConvert", "getConvertDetail",
            "getStocksPositions", "getMarketSession", "getMultiplierList", "getEcOrderHistory",
            "getEcActiveOrders", "getEcPositionInfo", "getEcSettlements", "getEcTradeHistory",
            "queryFixedBorrowPenaltyInterest", "cancelFixedBorrowOrder",
            "getReferralCampaignRewards", "getReferralCommissionRecords",
            "getReferralUserIdentityProfile", "getReferralUserInvitations",
            "batchCreateTaxReports", "batchQueryTaxReports"));

    private static final Set<String> COMPATIBILITY_METHODS = new HashSet<>(Arrays.asList(
            "postCryptoLoanCommonAdjustLtv", "getCryptoLoanCommonAdjustmentHistory",
            "getCryptoLoanCommonCollateralData", "getCryptoLoanCommonLoanableData",
            "getCryptoLoanCommonMaxCollateralAmount", "postCryptoLoanCommonMaxLoan",
            "getCryptoLoanCommonPosition", "getCryptoLoanFixedAvailableInventory",
            "getCryptoLoanFixedBorrowContractInfo", "postCryptoLoanFixedBorrowOrderCancel",
            "getCryptoLoanFixedBorrowOrderInfo", "getCryptoLoanFixedBorrowOrderQuote",
            "postCryptoLoanFixedBorrow", "postCryptoLoanFixedFullyRepay",
            "getCryptoLoanFixedRenewInfo", "postCryptoLoanFixedRenew",
            "postCryptoLoanFixedRepayCollateral", "getCryptoLoanFixedRepaymentHistory",
            "getCryptoLoanFixedSupplyContractInfo", "postCryptoLoanFixedSupplyOrderCancel",
            "getCryptoLoanFixedSupplyOrderInfo", "getCryptoLoanFixedSupplyOrderQuote",
            "postCryptoLoanFixedSupply", "getCryptoLoanFlexibleAvailableInventory",
            "getCryptoLoanFlexibleBorrowHistory", "postCryptoLoanFlexibleBorrow",
            "getCryptoLoanFlexibleOngoingCoin", "postCryptoLoanFlexibleRepayCollateral",
            "postCryptoLoanFlexibleRepay", "getCryptoLoanFlexibleRepaymentHistory",
            "queryFixedBorrowPenaltyInterest", "cancelFixedBorrowOrder"));

    @Test
    public void privateEndpointsDeclareSignedSecurityHeader() {
        int inspected = 0;
        for (Method method : BybitApiService.class.getDeclaredMethods()) {
            if (!SIGNED_METHODS.contains(method.getName())) {
                continue;
            }
            inspected++;
            Headers headers = method.getAnnotation(Headers.class);
            assertTrue(method.getName() + " must declare Retrofit @Headers", headers != null);
            assertTrue(method.getName() + " must require request signing",
                    Arrays.asList(headers.value()).contains(
                            BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER));
        }
        assertEquals("all new private endpoints must be covered", 36, inspected);
    }

    @Test
    public void allCurrentBranchPrivateEndpointsDeclareSignedSecurityHeader() {
        int inspected = 0;
        for (Method method : BybitApiService.class.getDeclaredMethods()) {
            if (!BRANCH_PRIVATE_METHODS.contains(method.getName())) {
                continue;
            }
            inspected++;
            Headers headers = method.getAnnotation(Headers.class);
            assertTrue(method.getName() + " must declare Retrofit @Headers", headers != null);
            assertTrue(method.getName() + " must require request signing",
                    Arrays.asList(headers.value()).contains(
                            BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER));
        }
        assertEquals("all branch private endpoints must be covered", 116, inspected);
    }

    @Test
    public void factoryCreatesAllNewEndpointClients() throws Exception {
        String[] factoryMethods = {
                "newAlphaRestClient", "newAsyncAlphaRestClient",
                "newBotRestClient", "newAsyncBotRestClient",
                "newEventRestClient", "newAsyncEventRestClient",
                "newReferralRestClient", "newAsyncReferralRestClient",
                "newSpotXRestClient", "newAsyncSpotXRestClient",
                "newStocksRestClient", "newAsyncStocksRestClient",
                "newStrategyRestClient", "newAsyncStrategyRestClient",
                "newTaxRestClient", "newAsyncTaxRestClient"
        };
        Class<?>[] clientTypes = {
                BybitApiAlphaRestClient.class, BybitApiAsyncAlphaRestClient.class,
                BybitApiBotRestClient.class, BybitApiAsyncBotRestClient.class,
                BybitApiEventRestClient.class, BybitApiAsyncEventRestClient.class,
                BybitApiReferralRestClient.class, BybitApiAsyncReferralRestClient.class,
                BybitApiSpotXRestClient.class, BybitApiAsyncSpotXRestClient.class,
                BybitApiStocksRestClient.class, BybitApiAsyncStocksRestClient.class,
                BybitApiStrategyRestClient.class, BybitApiAsyncStrategyRestClient.class,
                BybitApiTaxRestClient.class, BybitApiAsyncTaxRestClient.class
        };
        BybitApiClientFactory factory = BybitApiClientFactory.newInstance(
                "test-key", "test-secret", "https://example.com/", "test-referer");

        for (int i = 0; i < factoryMethods.length; i++) {
            Method factoryMethod = BybitApiClientFactory.class.getMethod(factoryMethods[i]);
            assertEquals(clientTypes[i], factoryMethod.getReturnType());
            assertTrue(factoryMethods[i] + " must return its public client interface",
                    clientTypes[i].isInstance(factoryMethod.invoke(factory)));
        }
    }

    @Test
    public void loanAndSpotMarginAdditionsRemainDefaultForImplementerCompatibility() {
        Class<?>[] clientInterfaces = {
                BybitApiLoanRestClient.class, BybitApiAsyncLoanRestClient.class,
                BybitApiSpotMarginRestClient.class, BybitApiAsyncSpotMarginRestClient.class
        };

        int inspected = 0;
        for (Class<?> clientInterface : clientInterfaces) {
            for (Method method : clientInterface.getDeclaredMethods()) {
                if (!COMPATIBILITY_METHODS.contains(method.getName())) {
                    continue;
                }
                inspected++;
                assertTrue(clientInterface.getSimpleName() + "#" + method.getName()
                        + " must be a default method", method.isDefault());
            }
        }
        assertEquals("all compatibility-sensitive additions must be covered", 64, inspected);
    }

    @Test
    public void strategyOrderListUsesLowerCamelQueryNames() {
        BybitApiService service = new Retrofit.Builder()
                .baseUrl("https://example.com/")
                .addConverterFactory(JacksonConverterFactory.create())
                .build()
                .create(BybitApiService.class);

        Call<?> call = service.queryStrategyOrderList(
                "strategy-id", "active", "BTCUSDT", 11L, 22L, 50, "cursor", "dca");
        assertEquals("11", call.request().url().queryParameter("beginTimeE0"));
        assertEquals("22", call.request().url().queryParameter("endTimeE0"));
        assertEquals("dca", call.request().url().queryParameter("strategyType"));
        assertTrue(call.request().url().queryParameter("BeginTimeE0") == null);
        assertTrue(call.request().url().queryParameter("EndTimeE0") == null);
        assertTrue(call.request().url().queryParameter("StrategyType") == null);
    }

    @Test
    public void transferSubMemberIdsUsesArrayShape() throws Exception {
        Field field = TransferSubMemberSaveRequest.class.getDeclaredField("subMemberIds");
        assertEquals(List.class, field.getType());
        assertEquals("java.util.List<java.lang.String>", field.getGenericType().getTypeName());
    }

    @Test
    public void optionBaseCoinsAcceptsCommaSeparatedUnderlyingTypes() throws Exception {
        assertEquals(String.class,
                BybitApiMarketRestClient.class.getMethod("getOptionBaseCoins", String.class)
                        .getParameterTypes()[0]);
        assertEquals(String.class,
                BybitApiService.class.getMethod("getOptionBaseCoins", String.class)
                        .getParameterTypes()[0]);
    }

    @Test
    public void autoSavingsCoinsUseStringElementsAndRepeatedQueryKeys() throws Exception {
        assertEquals("java.util.List<java.lang.String>",
                BybitApiEarnRestClient.class
                        .getMethod("listEarnAutoSavings", List.class)
                        .getGenericParameterTypes()[0].getTypeName());
        assertEquals("java.util.List<java.lang.String>",
                BybitApiAsyncEarnRestClient.class
                        .getMethod("listEarnAutoSavings", List.class, BybitApiCallback.class)
                        .getGenericParameterTypes()[0].getTypeName());
        Method serviceMethod = BybitApiService.class.getMethod("listEarnAutoSavings", List.class);
        assertEquals("java.util.List<java.lang.String>",
                serviceMethod.getGenericParameterTypes()[0].getTypeName());

        BybitApiService service = new Retrofit.Builder()
                .baseUrl("https://example.com/")
                .addConverterFactory(JacksonConverterFactory.create())
                .build()
                .create(BybitApiService.class);
        Call<?> call = (Call<?>) serviceMethod.invoke(service, Arrays.asList("BTC", "ETH"));
        assertEquals(Arrays.asList("BTC", "ETH"),
                call.request().url().queryParameterValues("coins"));
    }

    @Test
    public void requestBeansUseDocumentedElementTypesAndJsonShapes() throws Exception {
        Field fromCoinList = SmallAssetQuoteRequest.class.getDeclaredField("fromCoinList");
        assertEquals("java.util.List<java.lang.String>", fromCoinList.getGenericType().getTypeName());

        Field demoItems = UtaDemoApplyMoneyRequest.class.getDeclaredField("utaDemoApplyMoney");
        assertEquals(
                "java.util.List<com.bybit.api.client.domain.account.request.UtaDemoApplyMoney>",
                demoItems.getGenericType().getTypeName());

        JsonNode quoteJson = new ObjectMapper().valueToTree(SmallAssetQuoteRequest.builder()
                .accountType("eb_convert_uta")
                .fromCoinList(Arrays.asList("BTC", "ETH"))
                .toCoin("USDT")
                .build());
        assertEquals("BTC", quoteJson.get("fromCoinList").get(0).asText());
        assertEquals("ETH", quoteJson.get("fromCoinList").get(1).asText());

        UtaDemoApplyMoney item = UtaDemoApplyMoney.builder()
                .coin("USDT")
                .amountStr("109")
                .build();
        UtaDemoApplyMoneyRequest request = UtaDemoApplyMoneyRequest.builder()
                .adjustType(0L)
                .utaDemoApplyMoney(Arrays.asList(item))
                .build();
        JsonNode demoJson = new ObjectMapper().valueToTree(request);
        assertEquals("USDT", demoJson.get("utaDemoApplyMoney").get(0).get("coin").asText());
        assertEquals("109", demoJson.get("utaDemoApplyMoney").get(0).get("amountStr").asText());
    }

    @Test
    public void obsoleteEndpointsAreMarkedDeprecated() throws Exception {
        assertDeprecated(BybitApiAssetRestClient.class, "transferSubMemberSave",
                TransferSubMemberSaveRequest.class);
        assertDeprecated(BybitApiAsyncAssetRestClient.class, "transferSubMemberSave",
                TransferSubMemberSaveRequest.class, BybitApiCallback.class);
        assertDeprecated(BybitApiAssetRestClientImpl.class, "transferSubMemberSave",
                TransferSubMemberSaveRequest.class);
        assertDeprecated(BybitApiAsyncAssetRestClientImpl.class, "transferSubMemberSave",
                TransferSubMemberSaveRequest.class, BybitApiCallback.class);
        assertDeprecated(BybitApiService.class, "transferSubMemberSave",
                TransferSubMemberSaveRequest.class);

        assertDeprecated(BybitApiLendingRestClient.class, "insLoanEnsureTokens", String.class);
        assertDeprecated(BybitApiAsyncLendingRestClient.class, "insLoanEnsureTokens",
                String.class, BybitApiCallback.class);
        assertDeprecated(BybitApiLendingRestClientImpl.class, "insLoanEnsureTokens", String.class);
        assertDeprecated(BybitApiAsyncLendingRestClientImpl.class, "insLoanEnsureTokens",
                String.class, BybitApiCallback.class);
        assertDeprecated(BybitApiService.class, "insLoanEnsureTokens", String.class);
    }

    private static void assertDeprecated(Class<?> owner, String methodName,
                                         Class<?>... parameterTypes) throws Exception {
        assertTrue(owner.getSimpleName() + "#" + methodName + " must be deprecated",
                owner.getMethod(methodName, parameterTypes).isAnnotationPresent(Deprecated.class));
    }

    @Test
    public void newClientMethodsRemainDefaultForImplementerCompatibility() {
        Class<?>[] clientInterfaces = {
                BybitApiAccountRestClient.class, BybitApiAsyncAccountRestClient.class,
                BybitApiAssetRestClient.class, BybitApiAsyncAssetRestClient.class,
                BybitApiEarnRestClient.class, BybitApiAsyncEarnRestClient.class,
                BybitApiLendingRestClient.class, BybitApiAsyncLendingRestClient.class,
                BybitApiMarketRestClient.class, BybitApiAsyncMarketDataRestClient.class,
                BybitApiPositionRestClient.class, BybitApiAsyncPositionRestClient.class,
                BybitApiSpotMarginRestClient.class, BybitApiAsyncSpotMarginRestClient.class,
                BybitApiSpreadRestClient.class, BybitApiAsyncSpreadRestClient.class,
                BybitApiUserRestClient.class, BybitApiAsyncUserRestClient.class
        };

        int inspected = 0;
        for (Class<?> clientInterface : clientInterfaces) {
            for (Method method : clientInterface.getDeclaredMethods()) {
                if (NEW_METHODS.contains(method.getName())) {
                    inspected++;
                    assertTrue(clientInterface.getSimpleName() + "#" + method.getName()
                            + " must be a default method", method.isDefault());
                }
            }
        }
        assertEquals("all sync and async additions must be covered", 74, inspected);
    }
}
