package com.bybit.api.domain.market;

import com.bybit.api.client.domain.GenericResponse;
import com.bybit.api.client.domain.market.response.kline.MarketKlineEntry;
import com.bybit.api.client.domain.market.response.kline.MarketKlineResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class MarketKlineResultDeserializerTest {
    double delta = 1e-6;

    @Test
    public void testMarketKlineResultDeserializer() {
        final String marketKlineResultJson = "{\n" +
                "    \"retCode\": 0,\n" +
                "    \"retMsg\": \"OK\",\n" +
                "    \"result\": {\n" +
                "        \"category\": \"spot\",\n" +
                "        \"symbol\": \"BTCUSDT\",\n" +
                "        \"list\": [\n" +
                "            [\n" +
                "                \"1691971200000\",\n" +
                "                \"28349.56\",\n" +
                "                \"29752.1178\",\n" +
                "                \"18000\",\n" +
                "                \"21335\",\n" +
                "                \"10531.829385\",\n" +
                "                \"290473145.2723997623\"\n" +
                "            ],\n" +
                "            [\n" +
                "                \"1691366400000\",\n" +
                "                \"31847.42\",\n" +
                "                \"31895.5621\",\n" +
                "                \"6331.63\",\n" +
                "                \"28349.56\",\n" +
                "                \"7519.172778\",\n" +
                "                \"188453792.2371207168\"\n" +
                "            ]\n" +
                "        ]\n" +
                "    },\n" +
                "    \"retExtInfo\": {},\n" +
                "    \"time\": 1692481517607\n" +
                "}";

        ObjectMapper mapper = new ObjectMapper();
        try {
            GenericResponse<MarketKlineResult> response = mapper.readValue(marketKlineResultJson, mapper.getTypeFactory().constructParametricType(GenericResponse.class, MarketKlineResult.class));
            // You can now access the fields of the response
            assertEquals(response.getRetCode(), 0);
            assertEquals(response.getRetMsg(), "OK");
            // Accessing the fields of the result
            MarketKlineResult marketKlineResult = response.getResult();
            assertEquals(marketKlineResult.getCategory(), "spot");
            assertEquals(marketKlineResult.getSymbol(), "BTCUSDT");
            List<MarketKlineEntry> entries = marketKlineResult.getMarketKlineEntries();
            assertEquals(entries.size(), 2);
            assertEquals(Optional.of(entries.get(0).getStartTime()).get(), Long.valueOf("1691971200000"));
            assertEquals(entries.get(0).getOpenPrice(), 28349.56, delta);
            assertEquals(entries.get(0).getHighPrice(), 29752.1178, delta);
            assertEquals(entries.get(0).getLowPrice(), 18000.0, delta);
            assertEquals(entries.get(0).getClosePrice(), 21335.0, delta);
            assertEquals(entries.get(0).getVolume(), 10531.829385, delta);
            assertEquals(entries.get(0).getTurnover(), 290473145.2723997623, delta);
            assertEquals(Optional.of(entries.get(1).getStartTime()).get(), Long.valueOf("1691366400000"));
            assertEquals(entries.get(1).getOpenPrice(), 31847.42, delta);
            assertEquals(entries.get(1).getHighPrice(), 31895.5621, delta);
            assertEquals(entries.get(1).getLowPrice(), 6331.63, delta);
            assertEquals(entries.get(1).getClosePrice(), 28349.56, delta);
            assertEquals(entries.get(1).getVolume(), 7519.172778, delta);
            assertEquals(entries.get(1).getTurnover(), 188453792.2371207168, delta);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            fail();
        }
    }
}
