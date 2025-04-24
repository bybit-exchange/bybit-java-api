package com.bybit.api.client.domain.account.response;

import com.bybit.api.client.constant.BybitApiConstants;
import lombok.Getter;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Getter
public class WalletBalanceCoin {
    /**
     * Coin name, such as BTC, ETH, USDT, USDC
     */
    private String coin;

    /**
     * Equity of coin
     */
    private String equity;

    /**
     * USD value of coin
     */
    private String usdValue;

    /**
     * Wallet balance of coin
     */
    private String walletBalance;

    /**
     * Available balance for Spot wallet. This is a unique field for Classic SPOT
     */
    private String free;

    /**
     * Locked balance due to the Spot open order
     */
    private String locked;

    /**
     * The spot asset qty that is used to hedge in the portfolio margin, truncate to 8 decimals and "0" by default
     */
    private String spotHedgingQty;

    /**
     * Borrow amount of current coin
     */
    private String borrowAmount;

    /**
     * Note: this field is deprecated for accountType=UNIFIED from 9 Jan, 2025
     *     Transferable balance: you can use Get Transferable Amount (Unified) or Get All Coins Balance instead
     *     Derivatives available balance:
     *     isolated margin: walletBalance - totalPositionIM - totalOrderIM - locked - bonus
     *     cross & portfolio margin: look at field totalAvailableBalance(USD), which needs to be converted into the available balance of accordingly coin through index price
     *     Spot (margin) available balance: refer to Get Borrow Quota (Spot)
     */
    private String availableToWithdraw;

    /**
     * Accrued interest
     */
    private String accruedInterest;

    /**
     * Pre-occupied margin for order. For portfolio margin mode, it returns ""
     */
    private String totalOrderIM;

    /**
     * Sum of initial margin of all positions + Pre-occupied liquidation fee. For portfolio margin mode, it returns ""
     */
    private String totalPositionIM;

    /**
     * Sum of maintenance margin for all positions. For portfolio margin mode, it returns ""
     */
    private String totalPositionMM;

    /**
     * Unrealised P&L
     */
    private String unrealisedPnl;

    /**
     * Cumulative Realised P&L
     */
    private String cumRealisedPnl;

    /**
     * Bonus. This is a unique field for accounType=UNIFIED
     */
    private String bonus;

    /**
     * Whether it can be used as a margin collateral currency (platform), true: YES, false: NO
     * When marginCollateral=false, then collateralSwitch is meaningless
     */
    private boolean marginCollateral;

    /**
     * Whether the collateral is turned on by user (user), true: ON, false: OFF
     * When marginCollateral=true, then collateralSwitch is meaningful
     */
    private boolean collateralSwitch;

    /**
     * deprecated field, always return "". Please refer to availableToBorrow in the Get Collateral Info
     * @deprecated
     */
    private String availableToBorrow;

    @Override
    public String toString() {
        return new ToStringBuilder(this, BybitApiConstants.TO_STRING_BUILDER_STYLE)
                .append("coin", coin)
                .append("equity", equity)
                .append("usdValue", usdValue)
                .append("walletBalance", walletBalance)
                .append("free", free)
                .append("locked", locked)
                .append("spotHedgingQty", spotHedgingQty)
                .append("borrowAmount", borrowAmount)
                .append("availableToWithdraw", availableToWithdraw)
                .toString();
    }
}
