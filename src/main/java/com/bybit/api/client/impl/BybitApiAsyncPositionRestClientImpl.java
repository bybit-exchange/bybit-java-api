package com.bybit.api.client.impl;

import com.bybit.api.client.domain.position.request.BatchMovePositionRequest;
import com.bybit.api.client.restApi.BybitApiAsyncPositionRestClient;
import com.bybit.api.client.restApi.BybitApiCallback;
import com.bybit.api.client.restApi.BybitApiService;
import com.bybit.api.client.domain.position.request.PositionDataRequest;
import com.bybit.api.client.service.BybitJsonConverter;

import static com.bybit.api.client.service.BybitApiServiceGenerator.createService;

/**
 * Implementation of Bybit's REST API using Retrofit with asynchronous/non-blocking method calls.
 */
public class BybitApiAsyncPositionRestClientImpl implements BybitApiAsyncPositionRestClient {

    private final BybitApiService bybitApiService;
    private final BybitJsonConverter converter = new BybitJsonConverter();

    public BybitApiAsyncPositionRestClientImpl(String apiKey, String secret, String baseUrl, boolean debugMode, long recvWindow, String logOption) {
        bybitApiService = createService(BybitApiService.class, apiKey, secret, baseUrl, debugMode, recvWindow, logOption, "");
    }

    // Position Data
    @Override
    public void getPositionInfo(PositionDataRequest positionListRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getPositionInfo(
                positionListRequest.getCategory().getCategoryTypeId(),
                positionListRequest.getSymbol(),
                positionListRequest.getBaseCoin(),
                positionListRequest.getSettleCoin(),
                positionListRequest.getLimit(),
                positionListRequest.getCursor()
        ).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void setPositionLeverage(PositionDataRequest positionDataRequest, BybitApiCallback<Object> callback) {
        var setLeverageRequest = converter.mapToSetLeverageRequest(positionDataRequest);
        bybitApiService.setPositionLeverage(setLeverageRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void swithMarginRequest(PositionDataRequest positionDataRequest, BybitApiCallback<Object> callback) {
        var switchMarginRequest = converter.mapToSwitchMarginRequest(positionDataRequest);
        bybitApiService.swithMarginRequest(switchMarginRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void switchPositionMode(PositionDataRequest positionDataRequest, BybitApiCallback<Object> callback) {
        var switchPositionModeRequest = converter.mapToSwitchPositionModeRequest(positionDataRequest);
        bybitApiService.switchPositionMode(switchPositionModeRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    @Deprecated
    public void setTpslMode(PositionDataRequest positionDataRequest, BybitApiCallback<Object> callback) {
        var setTpSlModeRequest = converter.mapToSetTpSlModeRequest(positionDataRequest);
        bybitApiService.setTpslMode(setTpSlModeRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    @Deprecated
    public void setRiskLimit(PositionDataRequest positionDataRequest, BybitApiCallback<Object> callback) {
        var setRiskLimitRequest = converter.mapToSetRiskLimitRequest(positionDataRequest);
        bybitApiService.setRiskLimit(setRiskLimitRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void setTradingStop(PositionDataRequest positionDataRequest, BybitApiCallback<Object> callback) {
        var tradingStopRequest = converter.mapToTradingStopRequest(positionDataRequest);
        bybitApiService.setTradingStop(tradingStopRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void setAutoAddMargin(PositionDataRequest positionDataRequest, BybitApiCallback<Object> callback) {
        var setAutoAddMarginRequest = converter.mapToSetAutoAddMarginRequest(positionDataRequest);
        bybitApiService.setAutoAddMargin(setAutoAddMarginRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void modifyPositionMargin(PositionDataRequest positionDataRequest, BybitApiCallback<Object> callback) {
        var modifyMarginRequest = converter.mapToModifyMarginRequest(positionDataRequest);
        bybitApiService.modifyPositionMargin(modifyMarginRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getClosePnlList(PositionDataRequest closePnlHistoryRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getClosePnlList(
                closePnlHistoryRequest.getCategory().getCategoryTypeId(),
                closePnlHistoryRequest.getSymbol(),
                closePnlHistoryRequest.getStartTime(),
                closePnlHistoryRequest.getEndTime(),
                closePnlHistoryRequest.getLimit(),
                closePnlHistoryRequest.getCursor()
        ).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getMovePositionHistory(PositionDataRequest movePositionHistoryRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getMovePositionHistory(
                movePositionHistoryRequest.getCategory().getCategoryTypeId(),
                movePositionHistoryRequest.getSymbol(),
                movePositionHistoryRequest.getStartTime(),
                movePositionHistoryRequest.getEndTime(),
                movePositionHistoryRequest.getStatus() == null ? null : movePositionHistoryRequest.getStatus().getMovePositionStatus(),
                movePositionHistoryRequest.getBlockTradeId(),
                movePositionHistoryRequest.getLimit(),
                movePositionHistoryRequest.getCursor()
        ).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void batchMovePositions(BatchMovePositionRequest batchMovePositionRequest, BybitApiCallback<Object> callback) {
        bybitApiService.batchMovePositions(batchMovePositionRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void confirmPositionRiskLimit(PositionDataRequest positionDataRequest, BybitApiCallback<Object> callback) {
        var confirmNewRiskLimitRequest = converter.mapToConfirmNewRiskLimitRequest(positionDataRequest);
        bybitApiService.confirmPositionRiskLimit(confirmNewRiskLimitRequest).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getClosedOptionsPositions(PositionDataRequest closedOptionsPositionsRequest, BybitApiCallback<Object> callback) {
        bybitApiService.getClosedOptionsPositions(
                closedOptionsPositionsRequest.getCategory().getCategoryTypeId(),
                closedOptionsPositionsRequest.getSymbol(),
                closedOptionsPositionsRequest.getStartTime(),
                closedOptionsPositionsRequest.getEndTime(),
                closedOptionsPositionsRequest.getLimit(),
                closedOptionsPositionsRequest.getCursor()
        ).enqueue(new BybitApiCallbackAdapter<>(callback));
    }

    @Override
    public void getPositionSymbolInfo(String category, String symbol, BybitApiCallback<Object> callback) {
        bybitApiService.getPositionSymbolInfo(category, symbol).enqueue(new BybitApiCallbackAdapter<>(callback));
    }
}
