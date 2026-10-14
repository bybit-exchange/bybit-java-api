package com.bybit.api.client.impl;

import com.bybit.api.client.domain.position.request.BatchMovePositionRequest;
import com.bybit.api.client.restApi.BybitApiPositionRestClient;
import com.bybit.api.client.restApi.BybitApiService;
import com.bybit.api.client.domain.position.request.PositionDataRequest;
import com.bybit.api.client.service.BybitJsonConverter;

import static com.bybit.api.client.service.BybitApiServiceGenerator.createService;
import static com.bybit.api.client.service.BybitApiServiceGenerator.executeSync;

public class BybitApiPositionRestClientImpl implements BybitApiPositionRestClient {
    private final BybitApiService bybitApiService;
    private final BybitJsonConverter converter = new BybitJsonConverter();

    public BybitApiPositionRestClientImpl(String apiKey, String secret, String baseUrl, boolean debugMode, long recvWindow, String logOption) {
        bybitApiService = createService(BybitApiService.class, apiKey, secret, baseUrl, debugMode, recvWindow, logOption, "");
    }

    // Position endpoints
    @Override
    public Object getPositionInfo(PositionDataRequest positionListRequest) {
        return executeSync(bybitApiService.getPositionInfo(
                positionListRequest.getCategory().getCategoryTypeId(),
                positionListRequest.getSymbol(),
                positionListRequest.getBaseCoin(),
                positionListRequest.getSettleCoin(),
                positionListRequest.getLimit(),
                positionListRequest.getCursor()
        ));
    }

    @Override
    public Object setPositionLeverage(PositionDataRequest positionDataRequest) {
        var setLeverageRequest = converter.mapToSetLeverageRequest(positionDataRequest);
        return executeSync(bybitApiService.setPositionLeverage(setLeverageRequest));
    }

    @Override
    public Object swithMarginRequest(PositionDataRequest positionDataRequest) {
        var switchMarginRequest = converter.mapToSwitchMarginRequest(positionDataRequest);
        return executeSync(bybitApiService.swithMarginRequest(switchMarginRequest));
    }

    @Override
    public Object switchPositionMode(PositionDataRequest positionDataRequest) {
        var switchPositionModeRequest = converter.mapToSwitchPositionModeRequest(positionDataRequest);
        return executeSync(bybitApiService.switchPositionMode(switchPositionModeRequest));
    }

    @Override
    @Deprecated
    public Object setTpslMode(PositionDataRequest positionDataRequest) {
        var setTpSlModeRequest = converter.mapToSetTpSlModeRequest(positionDataRequest);
        return executeSync(bybitApiService.setTpslMode(setTpSlModeRequest));
    }

    @Override
    @Deprecated
    public Object setRiskLimit(PositionDataRequest positionDataRequest) {
        var setRiskLimitRequest = converter.mapToSetRiskLimitRequest(positionDataRequest);
        return executeSync(bybitApiService.setRiskLimit(setRiskLimitRequest));
    }

    @Override
    public Object setTradingStop(PositionDataRequest positionDataRequest) {
        var tradingStopRequest = converter.mapToTradingStopRequest(positionDataRequest);
        return executeSync(bybitApiService.setTradingStop(tradingStopRequest));
    }

    @Override
    public Object setAutoAddMargin(PositionDataRequest positionDataRequest) {
        var setAutoAddMarginRequest = converter.mapToSetAutoAddMarginRequest(positionDataRequest);
        return executeSync(bybitApiService.setAutoAddMargin(setAutoAddMarginRequest));
    }

    @Override
    public Object modifyPositionMargin(PositionDataRequest positionDataRequest) {
        var modifyMarginRequest = converter.mapToModifyMarginRequest(positionDataRequest);
        return executeSync(bybitApiService.modifyPositionMargin(modifyMarginRequest));
    }

    @Override
    public Object getClosePnlList(PositionDataRequest closePnlHistoryRequest) {
        return executeSync(bybitApiService.getClosePnlList(
                closePnlHistoryRequest.getCategory().getCategoryTypeId(),
                closePnlHistoryRequest.getSymbol(),
                closePnlHistoryRequest.getStartTime(),
                closePnlHistoryRequest.getEndTime(),
                closePnlHistoryRequest.getLimit(),
                closePnlHistoryRequest.getCursor()
        ));
    }

    @Override
    public Object getMovePositionHistory(PositionDataRequest movePositionHistoryRequest) {
        return executeSync(bybitApiService.getMovePositionHistory(
                movePositionHistoryRequest.getCategory().getCategoryTypeId(),
                movePositionHistoryRequest.getSymbol(),
                movePositionHistoryRequest.getStartTime(),
                movePositionHistoryRequest.getEndTime(),
                movePositionHistoryRequest.getStatus() == null ? null : movePositionHistoryRequest.getStatus().getMovePositionStatus(),
                movePositionHistoryRequest.getBlockTradeId(),
                movePositionHistoryRequest.getLimit(),
                movePositionHistoryRequest.getCursor()
        ));
    }

    @Override
    public Object batchMovePositions(BatchMovePositionRequest batchMovePositionRequest) {
        return executeSync(bybitApiService.batchMovePositions(batchMovePositionRequest));
    }

    @Override
    public Object confirmPositionRiskLimit(PositionDataRequest positionDataRequest) {
        var confirmNewRiskLimitRequest = converter.mapToConfirmNewRiskLimitRequest(positionDataRequest);
        return executeSync(bybitApiService.confirmPositionRiskLimit(confirmNewRiskLimitRequest));
    }

    @Override
    public Object getClosedOptionsPositions(PositionDataRequest closedOptionsPositionsRequest) {
        return executeSync(bybitApiService.getClosedOptionsPositions(
                closedOptionsPositionsRequest.getCategory().getCategoryTypeId(),
                closedOptionsPositionsRequest.getSymbol(),
                closedOptionsPositionsRequest.getStartTime(),
                closedOptionsPositionsRequest.getEndTime(),
                closedOptionsPositionsRequest.getLimit(),
                closedOptionsPositionsRequest.getCursor()
        ));
    }

    @Override
    public Object getPositionSymbolInfo(String category, String symbol) {
        return executeSync(bybitApiService.getPositionSymbolInfo(category, symbol));
    }
}
