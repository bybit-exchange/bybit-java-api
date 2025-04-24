package com.bybit.api.domain.market;

import com.bybit.api.client.domain.CategoryType;
import com.bybit.api.client.domain.GenericResponse;
import com.bybit.api.client.domain.market.request.MarketDataRequest;
import com.bybit.api.client.domain.market.response.tickers.InverseTickerEntry;
import com.bybit.api.client.domain.market.response.tickers.SpotTickerEntry;
import com.bybit.api.client.domain.market.response.tickers.TickersResult;
import com.bybit.api.client.service.BybitApiClientFactory;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TickerInfoIndexPriceTest {
    @Test
    public void Test_IndexPrice()
    {
        var client = BybitApiClientFactory.newInstance().newAsyncMarketDataRestClient();

        var spotTickerRequest = MarketDataRequest.builder().category(CategoryType.SPOT).symbol("BTCUSDT").build();
        var inverseTickerRequest = MarketDataRequest.builder().category(CategoryType.INVERSE).symbol("BTCUSD").build();
        // spot ticker
        client.getMarketTickers(spotTickerRequest, System.out::println);
        // inverse ticker
        client.getMarketTickers(inverseTickerRequest, System.out::println);
    }

    @Test
    public void Test_IndexPriceSync()
    {
        var client = BybitApiClientFactory.newInstance().newMarketDataRestClient();

        // spot ticker
        var spotTickerRequest = MarketDataRequest.builder().category(CategoryType.SPOT).symbol("BTCUSDT").build();
        GenericResponse<TickersResult<SpotTickerEntry>> spotTickerResponse = client.getMarketTickers(spotTickerRequest);
        assertEquals(0, spotTickerResponse.getRetCode());
        assertEquals("spot", spotTickerResponse.getResult().getCategory());
        assertEquals("BTCUSDT", spotTickerResponse.getResult().getTickerEntries().get(0).getSymbol());

        // inverse ticker
        var inverseTickerRequest = MarketDataRequest.builder().category(CategoryType.INVERSE).symbol("BTCUSD").build();
        GenericResponse<TickersResult<InverseTickerEntry>> inverseTickerResponse = client.getMarketTickers(inverseTickerRequest);
        assertEquals(0, inverseTickerResponse.getRetCode());
        assertEquals("inverse", inverseTickerResponse.getResult().getCategory());
        assertEquals("BTCUSD", inverseTickerResponse.getResult().getTickerEntries().get(0).getSymbol());

        // option ticker
        var optionTickerRequest = MarketDataRequest.builder().category(CategoryType.OPTION).symbol("BTC-30DEC22-18000-C").build();
        GenericResponse<TickersResult<InverseTickerEntry>> optionTickerResponse = client.getMarketTickers(optionTickerRequest);
        assertEquals(0, optionTickerResponse.getRetCode());
        assertEquals("option", optionTickerResponse.getResult().getCategory());
    }
}
