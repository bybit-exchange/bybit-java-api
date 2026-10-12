package com.bybit.api.client.domain.institution.insLending;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RepayLoanRequest {
    private String token;
    private String quantity;
}
