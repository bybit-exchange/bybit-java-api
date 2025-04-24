package com.bybit.api.client.domain.account.response;

import com.bybit.api.client.constant.BybitApiConstants;
import lombok.Getter;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.List;

@Getter
public class WalletBalanceEntry {
    /**
     * Account type
     */
    private String accountType;

    /**
     * 	deprecated field
     */
    private String accountLTV;

    /**
     * Account IM rate.
     * You can refer to this Glossary to understand the below fields calculation and mearning
     * - All account wide fields are not applicable to
     * - UTA2.0(isolated margin),
     * - UTA1.0(isolated margin), UTA1.0(CONTRACT),
     * - classic account(SPOT, CONTRACT)
     */
    private String  accountIMRate;

    /**
     * Account MM rate
     */
    private String accountMMRate;

    /**
     * Account total equity (USD)
     */
    private String totalEquity;

    /**
     * Account wallet balance (USD): ∑Asset Wallet Balance By USD value of each asset
     */
    private String totalWalletBalance;

    /**
     * Account margin balance (USD): totalWalletBalance + totalPerpUPL
     */
    private String totalMarginBalance;

    /**
     * Account available balance (USD), Cross Margin: totalMarginBalance - totalInitialMargin
     */
    private String totalAvailableBalance;

    /**
     * Account Perps and Futures unrealised p&l (USD): ∑Each Perp and USDC Futures upl by base coin
     */
    private String totalPerpUPL;

    /**
     * Account initial margin (USD): ∑Asset Total Initial Margin Base Coin
     */
    private String totalInitialMargin;

    /**
     * Account maintenance margin (USD): ∑ Asset Total Maintenance Margin Base Coin
     */
    private String totalMaintenanceMargin;

    private List<WalletBalanceCoin> coin;

    @Override
    public String toString() {
        return new ToStringBuilder(this, BybitApiConstants.TO_STRING_BUILDER_STYLE)
                .append("accountType", accountType)
                .append("totalEquity", totalEquity)
                .append("totalWalletBalance", totalWalletBalance)
                .append("totalMarginBalance", totalMarginBalance)
                .append("totalAvailableBalance", totalAvailableBalance)
                .append("totalPerpUPL", totalPerpUPL)
                .append("totalInitialMargin", totalInitialMargin)
                .append("totalMaintenanceMargin", totalMaintenanceMargin)
                .toString();
    }
}
