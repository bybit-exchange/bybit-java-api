package com.bybit.api.domain.position;

import com.bybit.api.client.domain.CategoryType;
import com.bybit.api.client.domain.position.request.PositionDataRequest;
import com.bybit.api.client.restApi.BybitApiPositionRestClient;
import com.bybit.api.client.service.BybitApiClientFactory;
import org.junit.Test;

public class PositionListCursorTest {
    BybitApiPositionRestClient client = BybitApiClientFactory.newInstance(
            System.getProperty("API_KEY", "undefined system property API_KEY")
            , System.getProperty("API_SECRET", "undefined system property API_SECRET")
            , System.getProperty("API_DOMAIN", "undefined system property API_DOMAIN"))
            .newPositionRestClient();
    @Test
    public void Test_SwitchPositionMode()
    {
        var positionDataRequest = PositionDataRequest.builder().category(CategoryType.LINEAR).symbol("XRPUSDT").cursor("XRPUSDT%2C1709884800016%2C0").limit(1).build();
        var switchModeResult = client.getPositionInfo(positionDataRequest);
        System.out.println(switchModeResult);
    }
}
