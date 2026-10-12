package com.bybit.api.client.restApi;

import com.bybit.api.client.constant.BybitApiConstants;
import com.bybit.api.client.domain.asset.request.TransferSubMemberSaveRequest;
import org.junit.Test;
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
