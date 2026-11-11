package com.bybit.api.client.domain.tax.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TaxBatchCreateRequest {
    private Long startTime;
    private Long endTime;
    private java.util.List<TaxReportItem> items;
    private String sourceInstitution;
    private String exportFileType;
}
