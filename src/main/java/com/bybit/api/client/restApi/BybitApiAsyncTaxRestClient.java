package com.bybit.api.client.restApi;

import com.bybit.api.client.domain.tax.request.TaxBatchCreateRequest;

public interface BybitApiAsyncTaxRestClient {
    void batchCreateTaxReports(TaxBatchCreateRequest taxBatchCreateRequest, BybitApiCallback<Object> callback);

    void batchQueryTaxReports(String batchId, BybitApiCallback<Object> callback);
}
