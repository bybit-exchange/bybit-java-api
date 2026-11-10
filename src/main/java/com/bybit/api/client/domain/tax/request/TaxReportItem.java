package com.bybit.api.client.domain.tax.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TaxReportItem {
    private String type;
    private String number;
}
