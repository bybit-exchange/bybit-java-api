package com.bybit.api.client.domain.spot.marginTrade;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CancelFixedBorrowOrderRequest {
    private String orderId;
}
