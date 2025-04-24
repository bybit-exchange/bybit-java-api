package com.bybit.api.domain.trade;

import com.bybit.api.client.domain.CategoryType;
import com.bybit.api.client.domain.trade.request.TradeOrderRequest;
import com.bybit.api.client.restApi.BybitApiTradeRestClient;
import com.bybit.api.client.service.BybitApiClientFactory;
import org.junit.Test;

public class OrderHistoryTest {
    BybitApiTradeRestClient client = BybitApiClientFactory.newInstance(
            System.getProperty("API_KEY", "undefined system property API_KEY")
            , System.getProperty("API_SECRET", "undefined system property API_SECRET")
            , System.getProperty("API_DOMAIN", "undefined system property API_DOMAIN"))
            .newTradeRestClient();

    @Test
    public void Test_GetSpotOrderHistoryWithCursor(){
        var orderHistoryRequest = TradeOrderRequest.builder().category(CategoryType.SPOT)
                .cursor("1659014836933362176%3A1712505980064%2C1659014836933362176%3A1712505980064")
                .limit(1)
                .build();
        var orderResult = client.getOrderHistory(orderHistoryRequest);
        System.out.println(orderResult);
    }
}
// ts 1712507631016
// payload category=spot&cursor=1659014836933362176%3A1712505980064%2C1659014836933362176%3A1712505980064&limit=1'
// paramStr 17125076310168wYkmpLsMg10eNQyPm5000category=spot&cursor=1659014836933362176%3A1712505980064%2C1659014836933362176%3A1712505980064&limit=1
// paramStr 17125100678938wYkmpLsMg10eNQyPm5000category=spot&cursor=1659014836933362176%253A1712505980064%252C1659014836933362176%253A1712505980064&limit=1
// python signature d6ca6db7ccd6b661f901792a77847da17a55f8c1552c431731e52c3f4e2fb85e
// java signature b913fc1d8455650feb64c0279c550d8fd108b99a7493208b4292bfe63e9e667a