package com.bybit.api.client.restApi;

import com.bybit.api.client.domain.position.request.BatchMovePositionRequest;
import com.bybit.api.client.domain.position.request.PositionDataRequest;

public interface BybitApiPositionRestClient {
    // Position Data
    Object getPositionInfo(PositionDataRequest positionListRequest);
    Object setPositionLeverage(PositionDataRequest setLeverageRequest);
    Object swithMarginRequest(PositionDataRequest switchMarginRequest);
    Object switchPositionMode(PositionDataRequest switchPositionModeRequest);
    @Deprecated
    Object setTpslMode(PositionDataRequest setTpSlModeRequest);
    @Deprecated
    Object setRiskLimit(PositionDataRequest setRiskLimitRequest);
    Object setTradingStop(PositionDataRequest tradingStopRequest);
    Object setAutoAddMargin(PositionDataRequest setAutoAddMarginRequest);
    Object modifyPositionMargin(PositionDataRequest modifyMarginRequest);
    Object getClosePnlList(PositionDataRequest closePnlHistoryRequest);
    Object getMovePositionHistory(PositionDataRequest movePositionHistoryRequest);
    Object batchMovePositions(BatchMovePositionRequest batchMovePositionRequest);
    Object confirmPositionRiskLimit(PositionDataRequest confirmNewRiskLimitRequest);
    Object getClosedOptionsPositions(PositionDataRequest closedOptionsPositionsRequest);

    Object getPositionSymbolInfo(String category, String symbol);
}
