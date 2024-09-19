package com.bybit.api.domain.market;

import com.bybit.api.client.domain.GenericResponse;
import com.bybit.api.client.domain.market.response.fundingRate.FundingRateEntry;
import com.bybit.api.client.domain.market.response.fundingRate.FundingRateResult;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class FundingRateResultDeserializerTest {
    double delta = 1e-6;

    @Test
    public void testFundingRateResultDeserializer()
    {
        final String fundingRateResultJson = "{\n" +
                "    \"retCode\": 0,\n" +
                "    \"retMsg\": \"OK\",\n" +
                "    \"result\": {\n" +
                "        \"category\": \"linear\",\n" +
                "        \"list\": [\n" +
                "            {\n" +
                "                \"symbol\": \"BTCUSDT\",\n" +
                "                \"fundingRate\": \"0.00020343\",\n" +
                "                \"fundingRateTimestamp\": \"1699776000000\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"symbol\": \"BTCUSDT\",\n" +
                "                \"fundingRate\": \"0.0001\",\n" +
                "                \"fundingRateTimestamp\": \"1699747200000\"\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    \"retExtInfo\": {},\n" +
                "    \"time\": 1699802451572\n" +
                "}";
        ObjectMapper mapper = new ObjectMapper();
        try {
            GenericResponse<FundingRateResult> response = mapper.readValue(fundingRateResultJson, new TypeReference<>() {});
            // You can now access the fields of the response
            assertEquals(response.getRetCode(), 0);
            assertEquals(response.getRetMsg(), "OK");
            // Accessing the fields of the result
            FundingRateResult fundingRateResult = response.getResult();
            assertEquals(fundingRateResult.getCategory(), "linear");
            List<FundingRateEntry> entries = fundingRateResult.getFundingRateEntries();
            assertEquals(entries.size(), 2);
            assertEquals(entries.get(0).getSymbol(), "BTCUSDT");
            assertEquals(entries.get(0).getFundingRate(), 0.00020343, delta);
            assertEquals(entries.get(0).getFundingRateTimestamp(), 1699776000000L);
        }catch (IOException e) {
            System.out.println(e.getMessage());
            fail();
        }
    }
}
