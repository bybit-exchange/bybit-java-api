package com.bybit.api.client.impl;

import com.bybit.api.client.restApi.BybitApiBrokerRestClient;
import com.bybit.api.client.restApi.BybitApiService;
import com.bybit.api.client.domain.broker.request.BrokerDataRequest;
import com.bybit.api.client.domain.broker.request.SetBrokerApiLimitRequest;
import com.bybit.api.client.service.BybitJsonConverter;

import static com.bybit.api.client.service.BybitApiServiceGenerator.createService;
import static com.bybit.api.client.service.BybitApiServiceGenerator.executeSync;

public class BybitApiBrokerRestClientImpl implements BybitApiBrokerRestClient {
    private final BybitApiService bybitApiService;
    private final BybitJsonConverter converter = new BybitJsonConverter();

    public BybitApiBrokerRestClientImpl(String apiKey, String secret, String baseUrl, boolean debugMode, long recvWindow, String logOption) {
        bybitApiService = createService(BybitApiService.class, apiKey, secret, baseUrl, debugMode, recvWindow, logOption, "");
    }
    // Broker
    @Override
    public Object getBrokerEarningData(BrokerDataRequest brokerDataRequest) {
        return executeSync(bybitApiService.getBrokerEarningData(
                brokerDataRequest.getBizType() == null ? null : brokerDataRequest.getBizType().getType(),
                brokerDataRequest.getBegin(),
                brokerDataRequest.getEnd(),
                brokerDataRequest.getUid(),
                brokerDataRequest.getLimit(),
                brokerDataRequest.getCursor()
        ));
    }

    @Override
    public Object getBrokerAccountInfo() {
        return executeSync(bybitApiService.getBrokerAccountInfo());
    }

    @Override
    public Object getSubAccountsDeposits(BrokerDataRequest brokerDataRequest) {
        return executeSync(bybitApiService.getBrokerSubDeposits(
                brokerDataRequest.getSubMemberId(),
                brokerDataRequest.getCoin(),
                brokerDataRequest.getStartTime(),
                brokerDataRequest.getEndTime(),
                brokerDataRequest.getLimit(),
                brokerDataRequest.getCursor()
        ));
    }

    @Override
    public Object getSubAccountsDeposits() {
        return executeSync(bybitApiService.getBrokerSubDeposits());
    }

    @Override
    public Object getVoucherSpec(BrokerDataRequest voucherSpecRequest) {
        var request = converter.mapToBrokerVoucherSpecRequest(voucherSpecRequest);
        return executeSync(bybitApiService.getVoucherSpec(request));
    }

    @Override
    public Object issueVoucher(BrokerDataRequest issueVoucherRequest) {
        var request = converter.mapToBrokerIssueVoucherRequest(issueVoucherRequest);
        return executeSync(bybitApiService.issueVoucher(request));
    }

    @Override
    public Object getIssuedVoucher(BrokerDataRequest getIssuedVoucherRequest) {
        var request = converter.mapToBrokerGetIssuedVoucherRequest(getIssuedVoucherRequest);
        return executeSync(bybitApiService.getIssuedVoucher(request));
    }

    @Override
    public Object queryBrokerAllUidDetails(String uids, Integer limit, String cursor) {
        return executeSync(bybitApiService.queryBrokerAllUidDetails(uids, limit, cursor));
    }

    @Override
    public Object queryBrokerCap() {
        return executeSync(bybitApiService.queryBrokerCap());
    }

    @Override
    public Object setBrokerApiLimit(SetBrokerApiLimitRequest setBrokerApiLimitRequest) {
        return executeSync(bybitApiService.setBrokerApiLimit(setBrokerApiLimitRequest));
    }
}
