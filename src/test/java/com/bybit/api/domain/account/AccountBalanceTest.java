package com.bybit.api.domain.account;

import com.bybit.api.client.domain.account.AccountType;
import com.bybit.api.client.domain.account.request.AccountDataRequest;
import com.bybit.api.client.restApi.BybitApiAccountRestClient;
import com.bybit.api.client.service.BybitApiClientFactory;
import org.junit.Ignore;
import org.junit.Test;

public class AccountBalanceTest {
    BybitApiAccountRestClient client = BybitApiClientFactory.newInstance(
            System.getProperty("API_KEY", "undefined system property API_KEY")
            , System.getProperty("API_SECRET", "undefined system property API_SECRET")
            , System.getProperty("API_DOMAIN", "undefined system property API_DOMAIN"))
            .newAccountRestClient();

    @Test
    public void Test_GetAccountBalance() {
        var unifyWalletBalanceRequest = AccountDataRequest.builder().accountType(AccountType.UNIFIED).build();
        var result = client.getWalletBalance(unifyWalletBalanceRequest);
        System.out.println(result);
    }
}
