package com.bybit.api.client.restApi;

import com.bybit.api.client.domain.alpha.request.GetPredictionPortfolioSummaryRequest;
import com.bybit.api.client.domain.alpha.request.LPOrderListRequest;
import com.bybit.api.client.domain.alpha.request.LPPayTokenPriceRequest;
import com.bybit.api.client.domain.alpha.request.PredictionGroupStageDetailRequest;
import com.bybit.api.client.domain.alpha.request.PredictionMatchListRequest;
import com.bybit.api.client.domain.alpha.request.PredictionOrderBookRequest;
import com.bybit.api.client.domain.alpha.request.PredictionPositionHistoryRequest;
import com.bybit.api.client.domain.alpha.request.PredictionPositionListRequest;
import com.bybit.api.client.domain.alpha.request.PredictionPriceHistoryRequest;
import com.bybit.api.client.domain.alpha.request.PredictionSideMarketListRequest;
import com.bybit.api.client.domain.alpha.request.PredictionTokenPriceRequest;
import com.bybit.api.client.domain.alpha.request.TradeBizTokenPriceListRequest;
import com.bybit.api.client.domain.alpha.request.TradeOrderListRequest;
import com.bybit.api.client.domain.bot.request.CloseBotRequest;
import com.bybit.api.client.domain.bot.request.CloseDCABotRequest;
import com.bybit.api.client.domain.bot.request.CloseFMartBotRequest;
import com.bybit.api.client.domain.bot.request.CloseGridRequest;
import com.bybit.api.client.domain.bot.request.CreateBotRequest;
import com.bybit.api.client.domain.bot.request.CreateDCABotRequest;
import com.bybit.api.client.domain.bot.request.CreateFMartBotRequest;
import com.bybit.api.client.domain.bot.request.CreateGridBotRequest;
import com.bybit.api.client.domain.bot.request.FGridBotSingleCloseRequest;
import com.bybit.api.client.domain.bot.request.FGridBotSingleCreateRequest;
import com.bybit.api.client.domain.bot.request.GetDetailRequest;
import com.bybit.api.client.domain.bot.request.GetFGridDetailRequest;
import com.bybit.api.client.domain.bot.request.GetFMartDetailRequest;
import com.bybit.api.client.domain.bot.request.GetFMartLimitRequest;
import com.bybit.api.client.domain.bot.request.GetLimitRequest;
import com.bybit.api.client.domain.bot.request.QueryGridDetailRequest;
import com.bybit.api.client.domain.loan.request.AdjustLtvRequest;
import com.bybit.api.client.domain.loan.request.FlexibleBorrowRequest;
import com.bybit.api.client.domain.loan.request.MaxLoanRequest;
import com.bybit.api.client.domain.loan.request.PostCryptoLoanFixedBorrowRequest;
import com.bybit.api.client.domain.loan.request.PostCryptoLoanFixedRenewRequest;
import com.bybit.api.client.domain.loan.request.PostCryptoLoanFixedRepayCollateralRequest;
import com.bybit.api.client.domain.loan.request.PostCryptoLoanFixedSupplyOrderCancelRequest;
import com.bybit.api.client.domain.loan.request.PostCryptoLoanFixedSupplyRequest;
import com.bybit.api.client.domain.referral.request.GetReferralCommissionRecordsRequest;
import com.bybit.api.client.domain.referral.request.GetReferralUserInvitationsRequest;
import com.bybit.api.client.domain.strategy.request.CreateStrategyRequest;
import com.bybit.api.client.domain.tax.request.TaxBatchCreateRequest;
import com.bybit.api.client.impl.BybitApiAsyncLoanRestClientImpl;
import com.bybit.api.client.impl.BybitApiLoanRestClientImpl;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class GeneratedRequestContractTest {

    @Test
    public void predictionRequestsMatchDocumentedFields() throws Exception {
        assertFields(PredictionSideMarketListRequest.class,
                "eventId", String.class,
                "sortBy", String.class,
                "marketType", Integer.class,
                "limit", Integer.class,
                "pageIndex", Integer.class);
        assertFields(PredictionPriceHistoryRequest.class,
                "tokenId", String.class,
                "interval", String.class);
        assertFields(PredictionGroupStageDetailRequest.class,
                "eventType", Integer.class,
                "groupName", String.class);
        assertFields(PredictionMatchListRequest.class,
                "eventType", Integer.class,
                "status", Integer.class,
                "startTime", Long.class,
                "endTime", Long.class,
                "stageCode", String.class,
                "limit", Integer.class,
                "pageIndex", Integer.class);
        assertFields(PredictionPositionHistoryRequest.class,
                "tokenId", String.class,
                "eventId", String.class,
                "result", Integer.class,
                "days", Integer.class,
                "limit", Integer.class,
                "pageIndex", Integer.class);
        assertFields(PredictionPositionListRequest.class,
                "tokenId", String.class,
                "eventId", String.class,
                "limit", Integer.class,
                "pageIndex", Integer.class);
        assertFields(GetPredictionPortfolioSummaryRequest.class,
                "eventType", Integer.class);
    }

    @Test
    public void botIdentifiersAndModesUseDocumentedJsonTypes() throws Exception {
        assertFieldType(CloseBotRequest.class, "bot_id", String.class);
        assertNoField(CloseBotRequest.class, "stop_type");
        assertFieldType(GetDetailRequest.class, "bot_id", String.class);
        assertFieldType(FGridBotSingleCloseRequest.class, "bot_id", String.class);
        assertFieldType(GetFGridDetailRequest.class, "bot_id", String.class);
        assertFieldType(CloseFMartBotRequest.class, "bot_id", String.class);
        assertNoField(CloseFMartBotRequest.class, "stop_type");
        assertFieldType(GetFMartDetailRequest.class, "bot_id", String.class);
        assertFieldType(CloseGridRequest.class, "grid_id", String.class);
        assertFieldType(CloseGridRequest.class, "close_mode", String.class);
        assertFieldType(QueryGridDetailRequest.class, "grid_id", String.class);
        assertFieldType(CloseDCABotRequest.class, "bot_id", String.class);
        assertFieldType(CloseDCABotRequest.class, "close_mode", String.class);
        assertFieldType(CreateFMartBotRequest.class, "martingale_mode", Integer.class);
        assertFieldType(CreateFMartBotRequest.class, "auto_cycle_toggle", Integer.class);
        assertFieldType(GetFMartLimitRequest.class, "martingale_mode", Integer.class);

        JsonNode closeJson = serializeBuilt(CloseGridRequest.class,
                values("grid_id", "9007199254740993", "close_mode", "4"));
        assertTrue(closeJson.get("grid_id").isTextual());
        assertTrue(closeJson.get("close_mode").isTextual());

        JsonNode martingaleJson = serializeBuilt(CreateFMartBotRequest.class,
                values("symbol", "BTCUSDT", "martingale_mode", 1, "auto_cycle_toggle", 2));
        assertTrue(martingaleJson.get("martingale_mode").isInt());
        assertTrue(martingaleJson.get("auto_cycle_toggle").isInt());
    }

    @Test
    public void loanBodiesAndPaginationUseDocumentedStringTypes() throws Exception {
        assertFieldType(AdjustLtvRequest.class, "direction", String.class);
        assertFieldType(PostCryptoLoanFixedRepayCollateralRequest.class, "loanId", String.class);
        assertFieldType(PostCryptoLoanFixedSupplyOrderCancelRequest.class, "refundedAccount", String.class);
        assertFieldType(PostCryptoLoanFixedSupplyRequest.class, "availableSource", String.class);

        assertLoanMethod("getCryptoLoanCommonAdjustmentHistory",
                String.class, String.class, String.class, String.class);
        assertLoanMethod("getCryptoLoanFixedBorrowContractInfo",
                String.class, String.class, String.class, String.class, String.class, String.class);
        assertLoanMethod("getCryptoLoanFixedBorrowOrderInfo",
                String.class, String.class, String.class, String.class, String.class, String.class);
        assertLoanMethod("getCryptoLoanFixedRenewInfo",
                String.class, String.class, String.class, String.class);
        assertLoanMethod("getCryptoLoanFixedRepaymentHistory",
                String.class, String.class, String.class, String.class);
        assertLoanMethod("getCryptoLoanFixedSupplyContractInfo",
                String.class, String.class, String.class, String.class, String.class, String.class);
        assertLoanMethod("getCryptoLoanFixedSupplyOrderInfo",
                String.class, String.class, String.class, String.class, String.class, String.class);
        assertLoanMethod("getCryptoLoanFlexibleBorrowHistory",
                String.class, String.class, String.class, String.class);
        assertLoanMethod("getCryptoLoanFlexibleRepaymentHistory",
                String.class, String.class, String.class, String.class);
    }

    @Test
    public void structuredRequestFieldsDoNotExposeObject() throws Exception {
        assertListElementType(LPOrderListRequest.class, "orderStatus", Integer.class);
        assertListElementType(TradeOrderListRequest.class, "orderStatus", Integer.class);
        assertListElementType(LPPayTokenPriceRequest.class, "tokenCode", String.class);
        assertListElementType(PredictionOrderBookRequest.class, "tokenIds", String.class);
        assertListElementType(PredictionTokenPriceRequest.class, "tokenIds", String.class);
        assertGenericType(TradeBizTokenPriceListRequest.class, "tokenAddressInfo",
                "java.util.List<com.bybit.api.client.domain.alpha.request.TradeBizTokenAddressInfo>");
        assertGenericType(CreateBotRequest.class, "symbol_settings",
                "java.util.List<com.bybit.api.client.domain.bot.request.ComboBotSymbolSetting>");
        assertGenericType(GetLimitRequest.class, "symbol_settings",
                "java.util.List<com.bybit.api.client.domain.bot.request.ComboBotSymbolSetting>");
        assertFieldType(CreateDCABotRequest.class, "parameters",
                classForName("com.bybit.api.client.domain.bot.request.DcaBotParameters"));
        assertNoField(CreateDCABotRequest.class, "toolsDiscoveryParameter");
        assertNoField(FGridBotSingleCreateRequest.class, "toolsDiscoveryParameter");
        assertNoField(CreateGridBotRequest.class, "toolsDiscoveryParameter");
        assertGenericType(FlexibleBorrowRequest.class, "collateralList",
                "java.util.List<com.bybit.api.client.domain.loan.request.LoanCollateral>");
        assertGenericType(PostCryptoLoanFixedBorrowRequest.class, "collateralList",
                "java.util.List<com.bybit.api.client.domain.loan.request.LoanCollateral>");
        assertGenericType(PostCryptoLoanFixedRenewRequest.class, "collateralList",
                "java.util.List<com.bybit.api.client.domain.loan.request.LoanCollateral>");
        assertGenericType(MaxLoanRequest.class, "collateralList",
                "java.util.List<com.bybit.api.client.domain.loan.request.MaxLoanCollateral>");
        assertGenericType(GetReferralCommissionRecordsRequest.class, "userIdList",
                "java.util.List<com.bybit.api.client.domain.referral.request.ReferralUserId>");
        assertGenericType(GetReferralUserInvitationsRequest.class, "userIdList",
                "java.util.List<com.bybit.api.client.domain.referral.request.ReferralUserId>");
        assertFieldType(CreateStrategyRequest.class, "povParams",
                classForName("com.bybit.api.client.domain.strategy.request.PovParams"));
        assertGenericType(TaxBatchCreateRequest.class, "items",
                "java.util.List<com.bybit.api.client.domain.tax.request.TaxReportItem>");

        Class<?>[] requestTypes = {
                LPOrderListRequest.class, TradeOrderListRequest.class, LPPayTokenPriceRequest.class,
                PredictionOrderBookRequest.class, PredictionTokenPriceRequest.class,
                TradeBizTokenPriceListRequest.class, CreateBotRequest.class, GetLimitRequest.class,
                CreateDCABotRequest.class, FGridBotSingleCreateRequest.class, CreateGridBotRequest.class,
                FlexibleBorrowRequest.class, PostCryptoLoanFixedBorrowRequest.class,
                PostCryptoLoanFixedRenewRequest.class, MaxLoanRequest.class,
                GetReferralCommissionRecordsRequest.class, GetReferralUserInvitationsRequest.class,
                CreateStrategyRequest.class, TaxBatchCreateRequest.class
        };
        for (Class<?> requestType : requestTypes) {
            for (Field field : requestType.getDeclaredFields()) {
                assertFalse(requestType.getSimpleName() + "." + field.getName() + " must not be Object",
                        field.getType() == Object.class);
                if (field.getGenericType() instanceof ParameterizedType) {
                    ParameterizedType genericType = (ParameterizedType) field.getGenericType();
                    assertFalse(requestType.getSimpleName() + "." + field.getName()
                                    + " must not contain Object elements",
                            Arrays.asList(genericType.getActualTypeArguments()).contains(Object.class));
                }
            }
        }
    }

    private static void assertLoanMethod(String name, Class<?>... parameterTypes) throws Exception {
        assertNotNull(BybitApiLoanRestClient.class.getMethod(name, parameterTypes));
        assertNotNull(BybitApiLoanRestClientImpl.class.getMethod(name, parameterTypes));
        assertNotNull(BybitApiService.class.getMethod(name, parameterTypes));

        Class<?>[] asyncTypes = Arrays.copyOf(parameterTypes, parameterTypes.length + 1);
        asyncTypes[asyncTypes.length - 1] = BybitApiCallback.class;
        assertNotNull(BybitApiAsyncLoanRestClient.class.getMethod(name, asyncTypes));
        assertNotNull(BybitApiAsyncLoanRestClientImpl.class.getMethod(name, asyncTypes));
    }

    private static void assertFields(Class<?> type, Object... nameAndType) {
        Map<String, Class<?>> expected = new LinkedHashMap<>();
        for (int i = 0; i < nameAndType.length; i += 2) {
            expected.put((String) nameAndType[i], (Class<?>) nameAndType[i + 1]);
        }
        Map<String, Class<?>> actual = new LinkedHashMap<>();
        for (Field field : type.getDeclaredFields()) {
            actual.put(field.getName(), field.getType());
        }
        assertEquals(type.getSimpleName() + " fields", expected, actual);
    }

    private static void assertFieldType(Class<?> type, String fieldName, Class<?> expectedType)
            throws Exception {
        assertEquals(type.getSimpleName() + "." + fieldName,
                expectedType, type.getDeclaredField(fieldName).getType());
    }

    private static void assertListElementType(Class<?> type, String fieldName, Class<?> elementType)
            throws Exception {
        assertGenericType(type, fieldName, "java.util.List<" + elementType.getName() + ">");
    }

    private static void assertGenericType(Class<?> type, String fieldName, String expectedType)
            throws Exception {
        assertEquals(type.getSimpleName() + "." + fieldName,
                expectedType, type.getDeclaredField(fieldName).getGenericType().getTypeName());
    }

    private static void assertNoField(Class<?> type, String fieldName) {
        try {
            type.getDeclaredField(fieldName);
            fail(type.getSimpleName() + "." + fieldName + " is not an API request field");
        } catch (NoSuchFieldException expected) {
            // Expected.
        }
    }

    private static JsonNode serializeBuilt(Class<?> type, Map<String, Object> properties)
            throws Exception {
        Object builder = type.getMethod("builder").invoke(null);
        for (Map.Entry<String, Object> entry : properties.entrySet()) {
            Method setter = null;
            for (Method candidate : builder.getClass().getMethods()) {
                if (candidate.getName().equals(entry.getKey())
                        && candidate.getParameterCount() == 1
                        && candidate.getParameterTypes()[0].isInstance(entry.getValue())) {
                    setter = candidate;
                    break;
                }
            }
            assertNotNull(type.getSimpleName() + " builder method " + entry.getKey(), setter);
            setter.invoke(builder, entry.getValue());
        }
        Object request = builder.getClass().getMethod("build").invoke(builder);
        return new ObjectMapper().valueToTree(request);
    }

    private static Map<String, Object> values(Object... keyAndValue) {
        Map<String, Object> values = new LinkedHashMap<>();
        for (int i = 0; i < keyAndValue.length; i += 2) {
            values.put((String) keyAndValue[i], keyAndValue[i + 1]);
        }
        return values;
    }

    private static Class<?> classForName(String name) throws ClassNotFoundException {
        return Class.forName(name);
    }
}
