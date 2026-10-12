package com.bybit.api.client.domain.earn.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EditAutoSavingsRequest {
    private String coin;
    private Boolean isSelected;
    private Boolean purchaseImmediately;
}
