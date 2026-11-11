package com.bybit.api.client.impl;

import com.bybit.api.client.domain.tax.request.TaxBatchCreateRequest;
import com.bybit.api.client.restApi.BybitApiService;
import com.bybit.api.client.restApi.BybitApiTaxRestClient;

import static com.bybit.api.client.service.BybitApiServiceGenerator.createService;
import static com.bybit.api.client.service.BybitApiServiceGenerator.executeSync;

public class BybitApiTaxRestClientImpl implements BybitApiTaxRestClient {
    private final BybitApiService bybitApiService;

    public BybitApiTaxRestClientImpl(String apiKey, String secret, String baseUrl, boolean debugMode, long recvWindow, String logOption, String referer) {
        bybitApiService = createService(BybitApiService.class, apiKey, secret, baseUrl, debugMode, recvWindow, logOption, referer);
    }

    @Override
    public Object batchCreateTaxReports(TaxBatchCreateRequest taxBatchCreateRequest) {
        return executeSync(bybitApiService.batchCreateTaxReports(taxBatchCreateRequest));
    }

    @Override
    public Object batchQueryTaxReports(String batchId) {
        return executeSync(bybitApiService.batchQueryTaxReports(batchId));
    }
}
