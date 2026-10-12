package com.bybit.api.client.restApi;

import com.bybit.api.client.domain.position.request.BatchMovePositionRequest;
import com.bybit.api.client.domain.position.request.PositionDataRequest;

public interface BybitApiAsyncPositionRestClient {
    // Position endpoints
    void getPositionInfo(PositionDataRequest positionListRequest, BybitApiCallback<Object> callback);
    void setPositionLeverage(PositionDataRequest setLeverageRequest, BybitApiCallback<Object> callback);
    void swithMarginRequest(PositionDataRequest switchMarginRequest, BybitApiCallback<Object> callback);
    void switchPositionMode(PositionDataRequest switchPositionModeRequest, BybitApiCallback<Object> callback);
    @Deprecated
    void setTpslMode(PositionDataRequest setTpSlModeRequest, BybitApiCallback<Object> callback);
    @Deprecated
    void setRiskLimit(PositionDataRequest setRiskLimitRequest, BybitApiCallback<Object> callback);
    void setTradingStop(PositionDataRequest tradingStopRequest, BybitApiCallback<Object> callback);
    void setAutoAddMargin(PositionDataRequest setAutoAddMarginRequest, BybitApiCallback<Object> callback);
    void modifyPositionMargin(PositionDataRequest modifyMarginRequest, BybitApiCallback<Object> callback);
    void getClosePnlList(PositionDataRequest closePnlHistoryRequest, BybitApiCallback<Object> callback);
    void getMovePositionHistory(PositionDataRequest movePositionHistoryRequest, BybitApiCallback<Object> callback);
    void batchMovePositions(BatchMovePositionRequest batchMovePositionRequest, BybitApiCallback<Object> callback);
    void confirmPositionRiskLimit(PositionDataRequest confirmNewRiskLimitRequest, BybitApiCallback<Object> callback);
    void getClosedOptionsPositions(PositionDataRequest closedOptionsPositionsRequest, BybitApiCallback<Object> callback);

    default void getPositionSymbolInfo(String category, String symbol, BybitApiCallback<Object> callback) {
        throw new UnsupportedOperationException("getPositionSymbolInfo is not implemented by this client");
    }
}
