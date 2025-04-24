package com.bybit.api.domain.market;

import com.bybit.api.client.domain.CategoryType;
import com.bybit.api.client.domain.GenericResponse;
import com.bybit.api.client.domain.market.response.tickers.SpotTickerEntry;
import com.bybit.api.client.domain.market.response.tickers.TickerEntry;
import com.bybit.api.client.domain.market.response.tickers.TickersResult;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class SpotTickersResultDeserializerTest {
    @Test
    public void testSpotTickersResultDeserializer()
    {
        final String tickersResultJson = "{\n" +
                "    \"retCode\": 0,\n" +
                "    \"retMsg\": \"OK\",\n" +
                "    \"result\": {\n" +
                "        \"category\": \"spot\",\n" +
                "        \"list\": [\n" +
                "            {\n" +
                "                \"symbol\": \"BTCUSDT\",\n" +
                "                \"bid1Price\": \"29568.9\",\n" +
                "                \"bid1Size\": \"0.019507\",\n" +
                "                \"ask1Price\": \"29598.08\",\n" +
                "                \"ask1Size\": \"0.001179\",\n" +
                "                \"lastPrice\": \"29568.9\",\n" +
                "                \"prevPrice24h\": \"30471.45\",\n" +
                "                \"price24hPcnt\": \"-0.0296\",\n" +
                "                \"highPrice24h\": \"33749.31\",\n" +
                "                \"lowPrice24h\": \"28990.03\",\n" +
                "                \"turnover24h\": \"89120724.98005046\",\n" +
                "                \"volume24h\": \"2865.609609\",\n" +
                "                \"usdIndexPrice\": \"37205.82419726604\"\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    \"retExtInfo\": {},\n" +
                "    \"time\": 1699815314451\n" +
                "}";
        ObjectMapper mapper = new ObjectMapper();
        try {
            var response = mapper.readValue(tickersResultJson, new TypeReference<GenericResponse<TickersResult<SpotTickerEntry>>>() {
            });
            // You can now access the fields of the response
            assertEquals(response.getRetCode(), 0);
            assertEquals(response.getRetMsg(), "OK");
            // Accessing the fields of the result
            TickersResult tickersResult = response.getResult();
            assertEquals(tickersResult.getCategory(), CategoryType.SPOT.getCategoryTypeId());
            assertEquals(tickersResult.getTickerEntries().size(), 1);

            List<SpotTickerEntry> entries = tickersResult.getTickerEntries();
            assertEquals(entries.size(), 1);
            assertEquals(entries.get(0).getBid1Price(), "29568.9");
            assertEquals(entries.get(0).getBid1Size(), "0.019507");
        }catch (IOException e) {
            System.out.println(e.getMessage());
            fail();
        }
    }
}
