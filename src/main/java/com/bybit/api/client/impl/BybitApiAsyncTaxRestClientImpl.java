package com.bybit.api.client.impl;

import com.bybit.api.client.restApi.BybitApiCallback;
import com.bybit.api.client.domain.tax.request.TaxBatchCreateRequest;
import com.bybit.api.client.restApi.BybitApiService;
import com.bybit.api.client.restApi.BybitApiAsyncTaxRestClient;

import static com.bybit.api.client.service.BybitApiServiceGenerator.createService;

public class BybitApiAsyncTaxRestClientImpl implements BybitApiAsyncTaxRestClient {
    private final BybitApiService bybitApiService;

    public BybitApiAsyncTaxRestClientImpl(String apiKey, String secret, String baseUrl, boolean debugMode, long recvWindow, String logOption, String referer) {
        bybitApiService = createService(BybitApiService.class, apiKey, secret, baseUrl, debugMode, recvWindow, logOption, referer);
    }

    @Override
    public void batchCreateTaxReports(TaxBatchCreateRequest taxBatchCreateRequest, BybitApiCallback<Object> callback) {
        bybitApiService.batchCreateTaxReports(taxBatchCreateRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void batchQueryTaxReports(String batchId, BybitApiCallback<Object> callback) {
        bybitApiService.batchQueryTaxReports(batchId).enqueue(new BybitApiCallbackAdapter<>(callback));
    }
}
