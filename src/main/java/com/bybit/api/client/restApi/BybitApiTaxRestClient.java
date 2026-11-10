package com.bybit.api.client.restApi;

import com.bybit.api.client.domain.tax.request.TaxBatchCreateRequest;

public interface BybitApiTaxRestClient {
    Object batchCreateTaxReports(TaxBatchCreateRequest taxBatchCreateRequest);

    Object batchQueryTaxReports(String batchId);
}
