package com.bybit.api.client.restApi;

import com.bybit.api.client.constant.BybitApiConstants;
import com.bybit.api.client.domain.GenericResponse;
import com.bybit.api.client.domain.account.request.*;
import com.bybit.api.client.domain.asset.request.*;
import com.bybit.api.client.domain.broker.request.BrokerGetIssuedVoucherRequest;
import com.bybit.api.client.domain.broker.request.BrokerIssueVoucherRequest;
import com.bybit.api.client.domain.broker.request.BrokerVoucherSpecRequest;
import com.bybit.api.client.domain.institution.clientLending.ClientLendingFundsRequest;
import com.bybit.api.client.domain.institution.insLending.UpdateInstitutionLoadUidRequest;
import com.bybit.api.client.domain.market.response.serverTime.ServerTimeResult;
import com.bybit.api.client.domain.position.request.ConfirmNewRiskLimitRequest;
import com.bybit.api.client.domain.position.request.*;
import com.bybit.api.client.domain.spot.leverageToken.SpotLeverageTokenRequest;
import com.bybit.api.client.domain.spot.marginTrade.SpotMarginTradeBorrowRequest;
import com.bybit.api.client.domain.spot.marginTrade.SpotMarginTradeRePayRequest;
import com.bybit.api.client.domain.trade.*;
import com.bybit.api.client.domain.trade.request.*;
import com.bybit.api.client.domain.user.request.CreateSubApiKeyRequest;
import com.bybit.api.client.domain.user.request.FreezeSubUIDRquest;
import com.bybit.api.client.domain.user.request.ModifyApiKeyRequest;
import com.bybit.api.client.domain.user.request.UserSubMemberRequest;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.Map;

/**
 * Bybit's REST API URL mappings and endpoint security configuration.
 */
public interface BybitApiService {
    // Market data endpoints

    /**
     * Get Bybit Server Time
     * <p>
     * https://bybit-exchange.github.io/docs/v5/market/time
     *
     * @return Response Parameters
     * Parameter	Type	Comments
     * timeSecond	string	Bybit server timestamp (sec)
     * timeNano	string	Bybit server timestamp (nano)
     */
    @GET("/v5/market/time")
    Call<GenericResponse<ServerTimeResult>> getServerTime();

    /**
     * Get Kline
     * Query for historical klines (also known as candles/candlesticks). Charts are returned in groups based on the requested interval.
     * <p>
     * Covers: Spot / USDT perpetual / USDC contract / Inverse contract
     * <p>
     * https://bybit-exchange.github.io/docs/v5/market/time
     *
     * @param category true	string	Product type. spot,linear,inverse
     * @param symbol   true	string	Symbol name
     * @param interval true	string	Kline interval. 1,3,5,15,30,60,120,240,360,720,D,M,W
     * @param start    false	integer	The start timestamp (ms)
     * @param end      false	integer	The end timestamp (ms)
     * @param limit    false	integer	Limit for data size per page. [1, 1000]. Default: 200
     * @return Response Parameters
     * * Parameter	Type	Comments
     * * category	string	Product type
     * * symbol	string	Symbol name
     * * list	array
     * * An string array of individual candle
     * * Sort in reverse by startTime
     * * &gt; list[0]: startTime	string	Start time of the candle (ms)
     * * &gt; list[1]: openPrice	string	Open price
     * * &gt; list[2]: highPrice	string	Highest price
     * * &gt; list[3]: lowPrice	string	Lowest price
     * * &gt; list[4]: closePrice	string	Close price. Is the last traded price when the candle is not closed
     * * &gt; list[5]: volume	string	Trade volume. Unit of contract: pieces of contract. Unit of spot: quantity of coins
     * * &gt; list[6]: turnover	string	Turnover. Unit of figure: quantity of quota coin
     */
    @GET("/v5/market/kline")
    Call<Object> getMarketLinesData(@Query("category") String category,
                                    @Query("symbol") String symbol,
                                    @Query("interval") String interval,
                                    @Query("start") Long start,
                                    @Query("end") Long end,
                                    @Query("limit") Integer limit);

    /**
     * Query for historical mark price klines. Charts are returned in groups based on the requested interval.
     * Covers: USDT perpetual / USDC contract / Inverse contract
     * <p>
     * https://bybit-exchange.github.io/docs/v5/market/mark-kline
     *
     * @param category true	string	Product type. spot,linear,inverse
     * @param symbol   true	string	Symbol name
     * @param interval true	string	Kline interval. 1,3,5,15,30,60,120,240,360,720,D,M,W
     * @param start    false	integer	The start timestamp (ms)
     * @param end      false	integer	The end timestamp (ms)
     * @param limit    false	integer	Limit for data size per page. [1, 1000]. Default: 200
     * @return Response Parameters
     * Parameter	Type	Comments
     * category	string	Product type
     * symbol	string	Symbol name
     * list	array
     * An string array of individual candle
     * Sort in reverse by startTime
     * &gt; list[0]: startTime	string	Start time of the candle (ms)
     * &gt; list[1]: openPrice	string	Open price
     * &gt; list[2]: highPrice	string	Highest price
     * &gt; list[3]: lowPrice	string	Lowest price
     * &gt; list[4]: closePrice	string	Close price. Is the last traded price when the candle is not closed
     */
    @GET("/v5/market/mark-price-kline")
    Call<Object> getMarketPriceLinesData(@Query("category") String category,
                                         @Query("symbol") String symbol,
                                         @Query("interval") String interval,
                                         @Query("start") Long start,
                                         @Query("end") Long end,
                                         @Query("limit") Integer limit);

    /**
     * Get Index Price Kline
     * Query for historical index price klines. Charts are returned in groups based on the requested interval.
     * <p>
     * Covers: USDT perpetual / USDC contract / Inverse contract
     * <p>
     * https://bybit-exchange.github.io/docs/v5/market/index-kline
     *
     * @param category true	string	Product type. linear,inverse
     * @param symbol   true	string	Symbol name
     * @param interval true	string	Kline interval. 1,3,5,15,30,60,120,240,360,720,D,M,W
     * @param start    false	integer	The start timestamp (ms)
     * @param end      false	integer	The end timestamp (ms)
     * @param limit    false	integer	Limit for data size per page. [1, 1000]. Default: 200
     * @return Response Parameters
     * Parameter	Type	Comments
     * category	string	Product type
     * symbol	string	Symbol name
     * list	array
     * An string array of individual candle
     * Sort in reverse by startTime
     * &gt; list[0]: startTime	string	Start time of the candle (ms)
     * &gt; list[1]: openPrice	string	Open price
     * &gt; list[2]: highPrice	string	Highest price
     * &gt; list[3]: lowPrice	string	Lowest price
     * &gt; list[4]: closePrice	string	Close price. Is the last traded price when the candle is not closed
     */
    @GET("/v5/market/index-price-kline")
    Call<Object> getIndexPriceLinesData(@Query("category") String category,
                                        @Query("symbol") String symbol,
                                        @Query("interval") String interval,
                                        @Query("start") Long start,
                                        @Query("end") Long end,
                                        @Query("limit") Integer limit);


    /**
     * Get Premium Index Price Kline
     * Query for historical premium index klines. Charts are returned in groups based on the requested interval.
     * <p>
     * Covers: USDT and USDC perpetual
     * <p>
     * https://bybit-exchange.github.io/docs/v5/market/preimum-index-kline
     *
     * @param category true	string	Product type. linear
     * @param symbol   true	string	Symbol name
     * @param interval true	string	Kline interval
     * @param start    false	integer	The start timestamp (ms)
     * @param end      false	integer	The end timestamp (ms)
     * @param limit    false	integer	Limit for data size per page. [1, 1000]. Default: 200
     * @return Response Parameters
     * Parameter	Type	Comments
     * category	string	Product type
     * symbol	string	Symbol name
     * list	array
     * An string array of individual candle
     * Sort in reverse by start
     * &gt; list[0]	string	Start time of the candle (ms)
     * &gt; list[1]	string	Open price
     * &gt; list[2]	string	Highest price
     * &gt; list[3]	string	Lowest price
     * &gt; list[4]	string	Close price. Is the last traded price when the candle is not closed
     */
    @GET("/v5/market/premium-index-price-kline")
    Call<Object> getPremiumIndexPriceLinesData(@Query("category") String category,
                                               @Query("symbol") String symbol,
                                               @Query("interval") String interval,
                                               @Query("start") Long start,
                                               @Query("end") Long end,
                                               @Query("limit") Integer limit);

    /**
     * Get Instruments Info
     * Query for the instrument specification of online trading pairs.
     * <p>
     * Covers: Spot / USDT perpetual / USDC contract / Inverse contract / Option
     * <p>
     * CAUTION
     * Spot does not support pagination, so limit, cursor are invalid.
     * When query by baseCoin, regardless of category=linear or inverse, the result will have USDT perpetual, USDC contract and Inverse contract symbols.
     * <p>
     * https://bybit-exchange.github.io/docs/v5/market/instrument
     *
     * @param category true	string	Product type. spot,linear,inverse,option
     * @param symbol   false	string	Symbol name
     * @param status   false	string	Symbol status filter
     *                 spot/linear/inverse has Trading only
     * @param baseCoin false	string	Base coin. linear,inverse,option only
     *                 For option, it returns BTC by default
     * @param limit    false	integer	Limit for data size per page. [1, 1000]. Default: 500
     * @param cursor   false	string	Cursor. Use the nextPageCursor token from the response to retrieve the next page of the result set
     * @return Response Parameters
     * Linear/Inverse
     * Parameter	Type	Comments
     * category	string	Product type
     * nextPageCursor	string	Cursor. Used to pagination
     * list	array	Object
     * &gt; symbol	string	Symbol name
     * &gt; contractType	string	Contract type
     * &gt; status	string	Instrument status
     * &gt; baseCoin	string	Base coin
     * &gt; quoteCoin	string	Quote coin
     * &gt; launchTime	string	Launch timestamp (ms)
     * &gt; deliveryTime	string	Delivery timestamp (ms)
     * &gt; deliveryFeeRate	string	Delivery fee rate
     * &gt; priceScale	string	Price scale
     * &gt; leverageFilter	Object	Leverage attributes
     * &gt; &gt; minLeverage	string	Minimum leverage
     * &gt; &gt; maxLeverage	string	Maximum leverage
     * &gt; &gt; leverageStep	string	The step to increase/reduce leverage
     * &gt; priceFilter	Object	Price attributes
     * &gt; &gt; minPrice	string	Minimum order price
     * &gt; &gt; maxPrice	string	Maximum order price
     * &gt; &gt; tickSize	string	The step to increase/reduce order price
     * &gt; lotSizeFilter	Object	Size attributes
     * &gt; &gt; maxOrderQty	string	Maximum order quantity
     * &gt; &gt; minOrderQty	string	Minimum order quantity
     * &gt; &gt; qtyStep	string	The step to increase/reduce order quantity
     * &gt; &gt; postOnlyMaxOrderQty	string	Maximum order qty for PostOnly order
     * &gt; unifiedMarginTrade	boolean	Whether to support unified margin trade
     * &gt; fundingInterval	integer	Funding interval (minute)
     * &gt; settleCoin	string	Settle coin
     * &gt; copyTrading	string	Copy trade symbol or not
     * <p>
     * Option
     * Parameter	Type	Comments
     * category	string	Product type
     * nextPageCursor	string	Cursor. Used to pagination
     * list	array	Object
     * &gt; symbol	string	Symbol name
     * &gt; optionsType	string	Option type. Call, Put
     * &gt; status	string	Instrument status
     * &gt; baseCoin	string	Base coin
     * &gt; quoteCoin	string	Quote coin
     * &gt; settleCoin	string	Settle coin
     * &gt; launchTime	string	Launch timestamp (ms)
     * &gt; deliveryTime	string	Delivery timestamp (ms)
     * &gt; deliveryFeeRate	string	Delivery fee rate
     * &gt; priceFilter	Object	Price attributes
     * &gt; &gt; minPrice	string	Minimum order price
     * &gt; &gt; maxPrice	string	Maximum order price
     * &gt; &gt; tickSize	string	The step to increase/reduce order price
     * &gt; lotSizeFilter	Object	Size attributes
     * &gt; &gt; maxOrderQty	string	Maximum order quantity
     * &gt; &gt; minOrderQty	string	Minimum order quantity
     * &gt; &gt; qtyStep	string	The step to increase/reduce order quantity
     * <p>
     * Spot
     * Parameter	Type	Comments
     * category	string	Product type
     * list	array	Object
     * &gt; symbol	string	Symbol name
     * &gt; baseCoin	string	Base coin
     * &gt; quoteCoin	string	Quote coin
     * &gt; innovation	string	Whether or not this is an innovation zone token. 0: false, 1: true
     * &gt; status	string	Instrument status
     * &gt; marginTrading	string	Margin trade symbol or not
     * This is to identify if the symbol support margin trading under different account modes
     * You may find some symbols not supporting margin buy or margin sell, so you need to go to Collateral Info (UTA) or Borrowable Coin (Classic) to check if that coin is borrowable
     * &gt; lotSizeFilter	Object	Size attributes
     * &gt; &gt; basePrecision	string	The precision of base coin
     * &gt; &gt; quotePrecision	string	The precision of quote coin
     * &gt; &gt; minOrderQty	string	Minimum order quantity
     * &gt; &gt; maxOrderQty	string	Maximum order quantity
     * &gt; &gt; minOrderAmt	string	Minimum order amount
     * &gt; &gt; maxOrderAmt	string	Maximum order amount
     * &gt; priceFilter	Object	Price attributes
     * &gt; &gt; tickSize	string	The step to increase/reduce order price
     */
    @GET("/v5/market/instruments-info")
    Call<Object> getInstrumentsInfo(@Query("category") String category, @Query("symbol") String symbol, @Query("status") String status, @Query("baseCoin") String baseCoin,
                                    @Query("limit") Integer limit, @Query("cursor") String cursor);

    /**
     * Get Orderbook
     * Query for orderbook depth data.
     * <p>
     * Covers: Spot / USDT perpetual / USDC contract / Inverse contract / Option
     * <p>
     * future: 200-level of orderbook data
     * spot: 50-level of orderbook data
     * option: 25-level of orderbook data
     * TIP
     * The response is in the snapshot format.
     * <p>
     * https://bybit-exchange.github.io/docs/v5/market/orderbook
     *
     * @param category true	string	Product type. spot, linear, inverse, option
     * @param symbol   true	string	Symbol name
     * @param limit    false	integer	Limit size for each bid and ask
     *                 spot: [1, 200]. Default: 1.
     *                 linear and inverse: [1, 200]. Default: 25.
     *                 option: [1, 25]. Default: 1.
     * @return Response Parameters
     * Parameter	Type	Comments
     * s	string	Symbol name
     * b	array	Bid, buyer. Sort by price desc
     * &gt; b[0]	string	Bid price
     * &gt; b[1]	string	Bid size
     * a	array	Ask, seller. Order by price asc
     * &gt; a[0]	string	Ask price
     * &gt; a[1]	string	Ask size
     * ts	integer	The timestamp (ms) that the system generates the data
     * u	integer	Update ID, is always in sequence
     * For future, it is corresponding to u in the wss 200-level orderbook
     * For spot, it is corresponding to u in the wss 50-level orderbook
     */
    @GET("/v5/market/orderbook")
    Call<Object> getMarketOrderBook(@Query("category") String category, @Query("symbol") String symbol, @Query("limit") Integer limit);

    /**
     * Get Tickers
     * Query for the latest price snapshot, best bid/ask price, and trading volume in the last 24 hours.
     * <p>
     * Covers: Spot / USDT perpetual / USDC contract / Inverse contract / Option
     * <p>
     * TIP
     * If category=option, symbol or baseCoin must be passed.
     * <p>
     * https://bybit-exchange.github.io/docs/v5/market/tickers
     *
     * @param category true	string	Product type. spot,linear,inverse,option
     * @param symbol   false	string	Symbol name
     * @param baseCoin false	string	Base coin. For option only
     * @param expDate  false	string	Expiry date. e.g., 25DEC22. For option only
     * @return Response Parameters
     * Linear/Inverse
     * Parameter	Type	Comments
     * category	string	Product type
     * list	array	Object
     * &gt; symbol	string	Symbol name
     * &gt; lastPrice	string	Last price
     * &gt; indexPrice	string	Index price
     * &gt; markPrice	string	Mark price
     * &gt; prevPrice24h	string	Market price 24 hours ago
     * &gt; price24hPcnt	string	Percentage change of market price relative to 24h
     * &gt; highPrice24h	string	The highest price in the last 24 hours
     * &gt; lowPrice24h	string	The lowest price in the last 24 hours
     * &gt; prevPrice1h	string	Market price an hour ago
     * &gt; openInterest	string	Open interest size
     * &gt; openInterestValue	string	Open interest value
     * &gt; turnover24h	string	Turnover for 24h
     * &gt; volume24h	string	Volume for 24h
     * &gt; fundingRate	string	Funding rate
     * &gt; nextFundingTime	string	Next funding time (ms)
     * &gt; predictedDeliveryPrice	string	Predicated delivery price. It has value when 30 min before delivery
     * &gt; basisRate	string	Basis rate
     * &gt; basis	string	Basis
     * &gt; deliveryFeeRate	string	Delivery fee rate
     * &gt; deliveryTime	string	Delivery timestamp (ms)
     * &gt; ask1Size	string	Best ask size
     * &gt; bid1Price	string	Best bid price
     * &gt; ask1Price	string	Best ask price
     * &gt; bid1Size	string	Best bid size
     * <p>
     * Option
     * Parameter	Type	Comments
     * category	string	Product type
     * list	array	Object
     * &gt; symbol	string	Symbol name
     * &gt; bid1Price	string	Best bid price
     * &gt; bid1Size	string	Best bid size
     * &gt; bid1Iv	string	Best bid iv
     * &gt; ask1Price	string	Best ask price
     * &gt; ask1Size	string	Best ask size
     * &gt; ask1Iv	string	Best ask iv
     * &gt; lastPrice	string	Last price
     * &gt; highPrice24h	string	The highest price in the last 24 hours
     * &gt; lowPrice24h	string	The lowest price in the last 24 hours
     * &gt; markPrice	string	Mark price
     * &gt; indexPrice	string	Index price
     * &gt; markIv	string	Mark price iv
     * &gt; underlyingPrice	string	Underlying price
     * &gt; openInterest	string	Open interest size
     * &gt; turnover24h	string	Turnover for 24h
     * &gt; volume24h	string	Volume for 24h
     * &gt; totalVolume	string	Total volume
     * &gt; totalTurnover	string	Total turnover
     * &gt; delta	string	Delta
     * &gt; gamma	string	Gamma
     * &gt; vega	string	Vega
     * &gt; theta	string	Theta
     * &gt; predictedDeliveryPrice	string	Predicated delivery price. It has value when 30 min before delivery
     * &gt; change24h	string	The change in the last 24 hous
     * <p>
     * Spot
     * Parameter	Type	Comments
     * category	string	Product type
     * list	array	Object
     * &gt; symbol	string	Symbol name
     * &gt; bid1Price	string	Best bid price
     * &gt; bid1Size	string	Best bid size
     * &gt; ask1Price	string	Best ask price
     * &gt; ask1Size	string	Best ask size
     * &gt; lastPrice	string	Last price
     * &gt; prevPrice24h	string	Market price 24 hours ago
     * &gt; price24hPcnt	string	Percentage change of market price relative to 24h
     * &gt; highPrice24h	string	The highest price in the last 24 hours
     * &gt; lowPrice24h	string	The lowest price in the last 24 hours
     * &gt; turnover24h	string	Turnover for 24h
     * &gt; volume24h	string	Volume for 24h
     * &gt; usdIndexPrice	string	USD index price
     * used to calculate USD value of the assets in Unified account
     * non-collateral margin coin returns ""
     */
    @GET("/v5/market/tickers")
    Call<Object> getMarketTickers(@Query("category") String category, @Query("symbol") String symbol, @Query("baseCoin") String baseCoin, @Query("expDate") String expDate);

    /**
     * Get Funding Rate History
     * Query for historical funding rates. Each symbol has a different funding interval. For example, if the interval is 8 hours and the current time is UTC 12, then it returns the last funding rate, which settled at UTC 8.
     * <p>
     * To query the funding rate interval, please refer to the instruments-info endpoint.
     * <p>
     * Covers: USDT and USDC perpetual / Inverse perpetual
     * <p>
     * TIP
     * Passing only startTime returns an error.
     * Passing only endTime returns 200 records up till endTime.
     * Passing neither returns 200 records up till the current time.
     * <p>
     * https://bybit-exchange.github.io/docs/v5/market/history-fund-rate
     *
     * @param category  true	string	Product type. linear,inverse
     * @param symbol    true	string	Symbol name
     * @param startTime false	integer	The start timestamp (ms)
     * @param endTime   false	integer	The end timestamp (ms)
     * @param limit     false	integer	Limit for data size per page. [1, 200]. Default: 200
     * @return Response Parameters
     * Parameter	Type	Comments
     * category	string	Product type
     * list	array	Object
     * &gt; symbol	string	Symbol name
     * &gt; fundingRate	string	Funding rate
     * &gt; fundingRateTimestamp	string	Funding rate timestamp (ms)
     */
    @GET("/v5/market/funding/history")
    Call<Object> getFundingHistory(
            @Query("category") String category,
            @Query("symbol") String symbol,
            @Query("startTime") Long startTime,
            @Query("endTime") Long endTime,
            @Query("limit") Integer limit);

    /**
     * Get Public Recent Trading History
     * Query recent public trading data in Bybit.
     * <p>
     * Covers: Spot / USDT perpetual / USDC contract / Inverse contract / Option
     * <p>
     * You can download archived historical trades here:
     * <p>
     * USDT Perpetual, Inverse Perpetual and Inverse Futures
     * Spot
     * <p>
     * https://bybit-exchange.github.io/docs/v5/market/recent-trade
     *
     * @param category   true	string	Product type. spot,linear,inverse,option
     * @param symbol     false	string	Symbol name
     *                   required for spot/linear/inverse
     *                   optional for option
     * @param baseCoin   false	string	Base coin. For option only. If not passed, return BTC data by default
     * @param optionType false	string	Option type. Call or Put. For option only
     * @param limit      false	integer	Limit for data size per page.
     *                   spot: [1,60], default: 60.
     *                   others: [1,1000], default: 500
     * @return Response Parameters
     * Parameter	Type	Comments
     * category	string	Products category
     * list	array	Object
     * &gt; execId	string	Execution ID
     * &gt; symbol	string	Symbol name
     * &gt; price	string	Trade price
     * &gt; size	string	Trade size
     * &gt; side	string	Side of taker Buy, Sell
     * &gt; time	string	Trade time (ms)
     * &gt; isBlockTrade	boolean	Whether the trade is block trade
     */
    @GET("/v5/market/recent-trade")
    Call<Object> getRecentTradeData(
            @Query("category") String category,
            @Query("symbol") String symbol,
            @Query("baseCoin") String baseCoin,
            @Query("optionType") String optionType,
            @Query("limit") Integer limit);

    /**
     * Get Open Interest
     * Get the open interest of each symbol.
     * <p>
     * Covers: USDT perpetual / USDC contract / Inverse contract
     * <p>
     * INFO
     * Returns single side data
     * The upper limit time you can query is the launch time of the symbol.
     * <p>
     * https://bybit-exchange.github.io/docs/v5/market/open-interest
     *
     * @param category     true	string	Product type. linear,inverse
     * @param symbol       true	string	Symbol name
     * @param intervalTime true	string	Interval time. 5min,15min,30min,1h,4h,1d
     * @param startTime    false	integer	The start timestamp (ms)
     * @param endTime      false	integer	The end timestamp (ms)
     * @param limit        false	integer	Limit for data size per page. [1, 200]. Default: 50
     * @param cursor       false	string	Cursor. Used to paginate
     * @return Response Parameters
     * Parameter	Type	Comments
     * category	string	Product type
     * symbol	string	Symbol name
     * list	array	Object
     * &gt; openInterest	string	Open interest
     * &gt; timestamp	string	The timestamp (ms)
     * nextPageCursor	string	Used to paginate
     */
    @GET("/v5/market/open-interest")
    Call<Object> getOpenInterest(
            @Query("category") String category,
            @Query("symbol") String symbol,
            @Query("intervalTime") String intervalTime,
            @Query("startTime") Long startTime,
            @Query("endTime") Long endTime,
            @Query("limit") Integer limit,
            @Query("cursor") String cursor);

    /**
     * Get Historical Volatility
     * Query option historical volatility
     * <p>
     * Covers: Option
     * <p>
     * INFO
     * The data is hourly.
     * If both startTime and endTime are not specified, it will return the most recent 1 hours worth of data.
     * startTime and endTime are a pair of params. Either both are passed or they are not passed at all.
     * This endpoint can query the last 2 years worth of data, but make sure [endTime - startTime] &le; 30 days.
     * <p>
     * https://bybit-exchange.github.io/docs/v5/market/iv
     *
     * @param category  true	string	Product type. option
     * @param baseCoin  false	string	Base coin. Default: return BTC data
     * @param period    false	integer	Period. If not specified, it will return data with a 7-day average by default
     * @param startTime false	integer	The start timestamp (ms)
     * @param endTime   false	integer	The end timestamp (ms)
     * @return Response Parameters
     * Parameter	Type	Comments
     * category	string	Product type
     * list	array	Object
     * &gt; period	integer	Period
     * &gt; value	string	Volatility
     * &gt; time	string	Timestamp (ms)
     */
    @GET("/v5/market/historical-volatility")
    Call<Object> getHistoricalVolatility(
            @Query("category") String category,
            @Query("baseCoin") String baseCoin,
            @Query("period") Integer period,
            @Query("startTime") Long startTime,
            @Query("endTime") Long endTime);

    /**
     * Get Insurance
     * Query for Bybit insurance pool data (BTC/USDT/USDC etc). The data is updated every 24 hours.
     * <p>
     * https://bybit-exchange.github.io/docs/v5/market/insurance
     *
     * @param coin false	string	coin. Default: return all insurance coins
     * @return Response Parameters
     * Parameter	Type	Comments
     * updatedTime	string	Data updated time (ms)
     * list	array	Object
     * &gt; coin	string	Coin
     * &gt; balance	string	Balance
     * &gt; value	string	USD value
     */
    @GET("/v5/market/insurance")
    Call<Object> getInsurance(@Query("coin") String coin);

    /**
     * Get Insurance
     * Query for Bybit insurance pool data (BTC/USDT/USDC etc). The data is updated every 24 hours.
     * <p>
     * https://bybit-exchange.github.io/docs/v5/market/insurance
     *
     * @return Response Parameters
     * Parameter	Type	Comments
     * updatedTime	string	Data updated time (ms)
     * list	array	Object
     * &gt; coin	string	Coin
     * &gt; balance	string	Balance
     * &gt; value	string	USD value
     */
    @GET("/v5/market/insurance")
    Call<Object> getInsurance();

    /**
     * Get Risk Limit
     * Query for the risk limit.
     * <p>
     * Covers: USDT perpetual / USDC contract / Inverse contract
     * <p>
     * https://bybit-exchange.github.io/docs/v5/market/risk-limit
     *
     * @param category true	string	Product type. linear,inverse
     * @param symbol   false	string	Symbol name
     * @return Response Parameters
     * Parameter	Type	Comments
     * category	string	Product type
     * list	array	Object
     * &gt; id	integer	Risk ID
     * &gt; symbol	string	Symbol name
     * &gt; riskLimitValue	string	Position limit
     * &gt; maintenanceMargin	number	Maintain margin rate
     * &gt; initialMargin	number	Initial margin rate
     * &gt; isLowestRisk	integer	1: true, 0: false
     * &gt; maxLeverage	string	Allowed max leverage
     */
    @GET("/v5/market/risk-limit")
    Call<Object> getRiskLimit(@Query("category") String category,
                              @Query("symbol") String symbol);

    /**
     * Get Delivery Price
     * Get the delivery price.
     * <p>
     * Covers: USDC futures / Inverse futures / Option
     * <p>
     * https://bybit-exchange.github.io/docs/v5/market/delivery-price
     *
     * @param category true	string	Product type. linear, inverse, option
     * @param symbol   false	string	Symbol name
     * @param baseCoin false	string	Base coin. Default: BTC. valid for option only
     * @param limit    false	integer	Limit for data size per page. [1, 200]. Default: 50
     * @param cursor   false	string	Cursor. Use the nextPageCursor token from the response to retrieve the next page of the result set
     * @return Response Parameters
     * Parameter	Type	Comments
     * category	string	Product type
     * list	array	Object
     * &gt; symbol	string	Symbol name
     * &gt; deliveryPrice	string	Delivery price
     * &gt; deliveryTime	string	Delivery timestamp (ms)
     * nextPageCursor	string	Refer to the cursor request parameter
     */
    @GET("/v5/market/delivery-price")
    Call<Object> getDeliveryPrice(@Query("category") String category,
                                  @Query("symbol") String symbol,
                                  @Query("baseCoin") String baseCoin,
                                  @Query("limit") Integer limit,
                                  @Query("cursor") String cursor);

    /**
     * Get Long Short Ratio
     * <p>
     * https://bybit-exchange.github.io/docs/v5/market/long-short-ratio
     *
     * @param category true	string	Product type. linear(USDT Perpetual only),inverse
     * @param symbol   true	string	Symbol name
     * @param period   true	string	Data recording period. 5min, 15min, 30min, 1h, 4h, 4d
     * @param limit    false	integer	Limit for data size per page. [1, 500]. Default: 50
     * @return Response Parameters
     * Parameter	Type	Comments
     * list	array	Object
     * &gt; symbol	string	Symbol name
     * &gt; buyRatio	string	The ratio of users with net long position
     * &gt; sellRatio	string	The ratio of users with net short position
     * &gt; timestamp	string	Timestamp (ms)
     */
    @GET("/v5/market/account-ratio")
    Call<Object> getMarketAccountRatio(@Query("category") String category,
                                       @Query("symbol") String symbol,
                                       @Query("period") String period,
                                       @Query("limit") Integer limit);

    // Trade

    /**
     * Get Order History
     * Query order history. As order creation/cancellation is asynchronous, the data returned from this endpoint may delay. If you want to get real-time order information, you could query this endpoint or rely on the websocket stream (recommended).
     * <p>
     * Unified account covers: Spot / USDT perpetual / USDC contract / Inverse contract / Options
     * Classic account covers: Spot / USDT perpetual / Inverse contract
     * <p>
     * INFO
     * The orders in the last 7 days: supports querying all statuses
     * The orders beyond 7 days: supports querying filled orders
     * You can query by symbol, baseCoin, orderId and orderLinkId, and if you pass multiple params, the system will process them according to this priority: orderId &gt; orderLinkId &gt; symbol &gt; baseCoin.
     * TIP
     * Classic account spot can get final status orders only
     * <p>
     * https://bybit-exchange.github.io/docs/v5/order/order-list
     *
     * @param category    true	string	Product type
     *                    Unified account: spot, linear, inverse, option
     *                    Classic account: spot, linear, inverse
     * @param symbol      false	string	Symbol name
     * @param baseCoin    false	string	Base coin. Unified account - inverse and Classic account does not support this param
     * @param settleCoin  false	string	Settle coin. Unified account - inverse and Classic account does not support this param
     * @param orderId     false	string	Order ID
     * @param orderLinkId false	string	User customised order ID
     * @param orderFilter false	string	Order: active order, StopOrder: conditional order for Futures and Spot, tpslOrder: spot TP/SL order
     *                    Classic spot: return Order active order by default
     *                    Others: all kinds of orders by default
     * @param orderStatus false	string
     *                    Classic spot: invalid
     *                    Others: return all status orders if not passed
     * @param startTime   false	integer	The start timestamp (ms)
     *                    Classic spot is not supported temporarily
     *                    startTime and endTime must be passed together
     *                    If not passed, query the past 7 days data by default
     *                    For each request, startTime and endTime interval should be less then 7 days
     * @param endTime     false	integer	The end timestamp (ms)
     *                    For each request, startTime and endTime interval should be less then 7 days
     * @param limit       false	integer	Limit for data size per page. [1, 50]. Default: 20
     * @param cursor      false	string	Cursor. Use the nextPageCursor token from the response to retrieve the next page of the result set
     * @return Response Parameters
     * Parameter	Type	Comments
     * category	string	Product type
     * list	array	Object
     * &gt; orderId	string	Order ID
     * &gt; orderLinkId	string	User customised order ID
     * &gt; blockTradeId	string	Block trade ID
     * &gt; symbol	string	Symbol name
     * &gt; price	string	Order price
     * &gt; qty	string	Order qty
     * &gt; side	string	Side. Buy,Sell
     * &gt; isLeverage	string	Whether to borrow. Unified spot only. 0: false, 1: true. . Classic spot is not supported, always 0
     * &gt; positionIdx	integer	Position index. Used to identify positions in different position modes
     * &gt; orderStatus	string	Order status
     * &gt; cancelType	string	Cancel type
     * &gt; rejectReason	string	Reject reason. Classic spot is not supported
     * &gt; avgPrice	string	Average filled price. If unfilled, it is ""
     * &gt; leavesQty	string	The remaining qty not executed. Classic spot is not supported
     * &gt; leavesValue	string	The estimated value not executed. Classic spot is not supported
     * &gt; cumExecQty	string	Cumulative executed order qty
     * &gt; cumExecValue	string	Cumulative executed order value. Classic spot is not supported
     * &gt; cumExecFee	string	Cumulative executed trading fee. Classic spot is not supported
     * &gt; timeInForce	string	Time in force
     * &gt; orderType	string	Order type. Market,Limit. For TP/SL order, it means the order type after triggered
     * Block trade Roll Back, Block trade-Limit: Unique enum values for Unified account block trades
     * &gt; stopOrderType	string	Stop order type
     * &gt; orderIv	string	Implied volatility
     * &gt; triggerPrice	string	Trigger price. If stopOrderType=TrailingStop, it is activate price. Otherwise, it is trigger price
     * &gt; takeProfit	string	Take profit price
     * &gt; stopLoss	string	Stop loss price
     * &gt; tpslMode	string	TP/SL mode, Full: entire position for TP/SL. Partial: partial position tp/sl. Spot does not have this field, and Option returns always ""
     * &gt; tpLimitPrice	string	The limit order price when take profit price is triggered
     * &gt; slLimitPrice	string	The limit order price when stop loss price is triggered
     * &gt; tpTriggerBy	string	The price type to trigger take profit
     * &gt; slTriggerBy	string	The price type to trigger stop loss
     * &gt; triggerDirection	integer	Trigger direction. 1: rise, 2: fall
     * &gt; triggerBy	string	The price type of trigger price
     * &gt; lastPriceOnCreated	string	Last price when place the order
     * &gt; reduceOnly	boolean	Reduce only. true means reduce position size
     * &gt; closeOnTrigger	boolean	Close on trigger. What is a close on trigger order?
     * &gt; placeType	string	Place type, option used. iv, price
     * &gt; smpType	string	SMP execution type
     * &gt; smpGroup	integer	Smp group ID. If the UID has no group, it is 0 by default
     * &gt; smpOrderId	string	The counterparty's orderID which triggers this SMP execution
     * &gt; createdTime	string	Order created timestamp (ms)
     * &gt; updatedTime	string	Order updated timestamp (ms)
     * nextPageCursor	string	Refer to the cursor request parameter
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/v5/order/history")
    Call<Object> getOrderHistory(@Query("category") String category,
                                       @Query("symbol") String symbol,
                                       @Query("baseCoin") String baseCoin,
                                       @Query("settleCoin") String settleCoin,
                                       @Query("orderId") String orderId,
                                       @Query("orderLinkId") String orderLinkId,
                                       @Query("orderFilter") String orderFilter,
                                       @Query("orderStatus") OrderStatus orderStatus,
                                       @Query("startTime") Long startTime,
                                       @Query("endTime") Long endTime,
                                       @Query("limit") Integer limit,
                                       @Query("cursor") String cursor);

    /**
     * Get Borrow Quota (Spot)
     * Query the qty and amount of borrowable coins in spot account.
     * <p>
     * Covers: Spot (Unified Account)
     * <p>
     * https://bybit-exchange.github.io/docs/v5/order/spot-borrow-quota
     *
     * @param category true	string	Product type. spot
     * @param symbol   true	string	Symbol name
     * @param side     true	string	Transaction side. Buy,Sell
     * @return Response Parameters
     * Parameter	Type	Comments
     * symbol	string	Symbol name
     * side	string	Side
     * maxTradeQty	string	The maximum base coin qty can be traded
     * If spot margin trade on and symbol is margin trading pair, it returns available balance + max.borrowable amount
     * Otherwise, it returns actual balance
     * maxTradeAmount	string	The maximum quote coin amount can be traded
     * If spot margin trade on and symbol is margin trading pair, it returns available balance + max.borrowable amount
     * Otherwise, it returns actual balance
     * borrowCoin	string	Borrow coin
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/v5/order/spot-borrow-check")
    Call<Object> getBorrowQuota(@Query("category") String category,
                                @Query("symbol") String symbol,
                                @Query("side") String side);

    /**
     * Get Open Orders
     * Query unfilled or partially filled orders in real-time. To query older order records, please use the order history interface.
     * <p>
     * Unified account covers: Spot / USDT perpetual / USDC contract / Inverse contract / Options
     * Classic account covers: Spot / USDT perpetual / Inverse contract
     * <p>
     * TIP
     * It also supports querying filled, cancelled, and rejected orders which occurred in last 10 minutes (check the openOnly param). At most, 500 orders will be returned.
     * You can query by symbol, baseCoin, orderId and orderLinkId, and if you pass multiple params, the system will process them according to this priority: orderId &gt; orderLinkId &gt; symbol &gt; baseCoin.
     * The records are sorted by the createdTime from newest to oldest.
     * INFO
     * Classic account spot trade can return open orders only
     * <p>
     * https://bybit-exchange.github.io/docs/v5/order/open-order
     *
     * @param category    true	string	Product type
     *                    Unified account: spot, linear, inverse, option
     *                    Classic account: spot, linear, inverse
     * @param symbol      false	string	Symbol name. For linear, either symbol, baseCoin, settleCoin is required
     * @param baseCoin    false	string	Base coin. Supports linear, inverse and option. For option. Return all option open orders if not passed
     * @param settleCoin  false	string	Settle coin
     *                    linear: either symbol, baseCoin or settleCoin is required
     *                    spot: invalid
     * @param orderId     false	string	Order ID
     * @param orderLinkId false	string	User customised order ID
     * @param openOnly    false	integer
     *                    Unified account and Classic account: 0(default) - query open orders only
     *                    Unified account - spot / linear / option: 1
     *                    Unified account - inverse and Classic account - linear / inverse: 2
     *                    return cancelled, rejected or totally filled orders by last 10 minutes, A maximum of 500 records are kept under each account. If the Bybit service is restarted due to an update, this part of the data will be cleared and accumulated again, but the order records will still be queried in order history
     *                    Classic spot: not supported, return open orders only
     * @param orderFilter false	string	Order: active order, StopOrder: conditional order for Futures and Spot, tpslOrder: spot TP/SL order
     *                    Classic spot: return Order active order by default
     *                    Others: all kinds of orders by default
     * @param limit       false	integer	Limit for data size per page. [1, 50]. Default: 20
     * @param cursor      false	string	Cursor. Use the nextPageCursor token from the response to retrieve the next page of the result set
     * @return Response Parameters
     * Parameter	Type	Comments
     * category	string	Product type
     * nextPageCursor	string	Refer to the cursor request parameter
     * list	array	Object
     * &gt; orderId	string	Order ID
     * &gt; orderLinkId	string	User customised order ID
     * &gt; blockTradeId	string	Paradigm block trade ID
     * &gt; symbol	string	Symbol name
     * &gt; price	string	Order price
     * &gt; qty	string	Order qty
     * &gt; side	string	Side. Buy,Sell
     * &gt; isLeverage	string	Whether to borrow. Unified spot only. 0: false, 1: true. . Classic spot is not supported, always 0
     * &gt; positionIdx	integer	Position index. Used to identify positions in different position modes.
     * &gt; orderStatus	string	Order status
     * &gt; cancelType	string	Cancel type
     * &gt; rejectReason	string	Reject reason. Classic spot is not supported
     * &gt; avgPrice	string	Average filled price. If unfilled, it is "0"
     * &gt; leavesQty	string	The remaining qty not executed. Classic spot is not supported
     * &gt; leavesValue	string	The estimated value not executed. Classic spot is not supported
     * &gt; cumExecQty	string	Cumulative executed order qty
     * &gt; cumExecValue	string	Cumulative executed order value. Classic spot is not supported
     * &gt; cumExecFee	string	Cumulative executed trading fee. Classic spot is not supported
     * &gt; timeInForce	string	Time in force
     * &gt; orderType	string	Order type. Market,Limit. For TP/SL order, it means the order type after triggered
     * &gt; stopOrderType	string	Stop order type
     * &gt; orderIv	string	Implied volatility
     * &gt; triggerPrice	string	Trigger price. If stopOrderType=TrailingStop, it is activate price. Otherwise, it is trigger price
     * &gt; takeProfit	string	Take profit price
     * &gt; stopLoss	string	Stop loss price
     * &gt; tpslMode	string	TP/SL mode, Full: entire position for TP/SL. Partial: partial position tp/sl. Spot does not have this field, and Option returns always ""
     * &gt; tpLimitPrice	string	The limit order price when take profit price is triggered
     * &gt; slLimitPrice	string	The limit order price when stop loss price is triggered
     * &gt; tpTriggerBy	string	The price type to trigger take profit
     * &gt; slTriggerBy	string	The price type to trigger stop loss
     * &gt; triggerDirection	integer	Trigger direction. 1: rise, 2: fall
     * &gt; triggerBy	string	The price type of trigger price
     * &gt; lastPriceOnCreated	string	Last price when place the order
     * &gt; reduceOnly	boolean	Reduce only. true means reduce position size
     * &gt; closeOnTrigger	boolean	Close on trigger. What is a close on trigger order?
     * &gt; placeType	string	Place type, option used. iv, price
     * &gt; smpType	string	SMP execution type
     * &gt; smpGroup	integer	Smp group ID. If the UID has no group, it is 0 by default
     * &gt; smpOrderId	string	The counterparty's orderID which triggers this SMP execution
     * &gt; createdTime	string	Order created timestamp (ms)
     * &gt; updatedTime	string	Order updated timestamp (ms)
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/v5/order/realtime")
    Call<Object> getOpenOrders(@Query("category") String category,
                               @Query("symbol") String symbol,
                               @Query("baseCoin") String baseCoin,
                               @Query("settleCoin") String settleCoin,
                               @Query("orderId") String orderId,
                               @Query("orderLinkId") String orderLinkId,
                               @Query("openOnly") Integer openOnly,
                               @Query("orderFilter") String orderFilter,
                               @Query("limit") Integer limit,
                               @Query("cursor") String cursor);

    /**
     * New, PartiallyFilled, Untriggered orders are not returned. Please use V5 Get Open Orders
     * (https://bybit-exchange.github.io/docs/v5/order/open-order) instead
     * Affected account: Unified Trading Account(including Pro)
     *
     * @param category
     * @param symbol
     * @param orderId
     * @param orderLinkId
     * @param baseCoin
     * @param startTime
     * @param endTime
     * @param execType
     * @param limit
     * @param cursor
     * @return
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/v5/execution/list")
    Call<Object> getTradeHistory(@Query("category") String category,
                                 @Query("symbol") String symbol,
                                 @Query("orderId") String orderId,
                                 @Query("orderLinkId") String orderLinkId,
                                 @Query("baseCoin") String baseCoin,
                                 @Query("startTime") Long startTime,
                                 @Query("endTime") Long endTime,
                                 @Query("execType") String execType,
                                 @Query("limit") Integer limit,
                                 @Query("cursor") String cursor);

    /**
     * Set Disconnect Cancel All
     * Covers: Option (Unified Account)
     * <p>
     * INFO
     * What is Disconnection Protect (DCP)?
     * Based on the websocket private connection and heartbeat mechanism, Bybit provides disconnection protection function. The timing starts from the first disconnection. If the Bybit server does not receive the reconnection from the client for more than 10 (default) seconds and resumes the heartbeat "ping", then the client is in the state of "disconnection protect", all active option orders of the client will be cancelled automatically. If within 10 seconds, the client reconnects and resumes the heartbeat "ping", the timing will be reset and restarted at the next disconnection.
     * <p>
     * How to enable DCP
     * If you need to turn it on/off, you can contact your client manager for consultation and application. The default time window is 10 seconds.
     * <p>
     * Applicable
     * Effective for options only.
     * <p>
     * TIP
     * After the request is successfully sent, the system needs a certain time to take effect. It is recommended to query or set again after 10 seconds
     * <p>
     * You can use this endpoint to get your current DCP configuration.
     * Your private websocket connection must subscribe "dcp" topic in order to trigger DCP successfully
     * <p>
     * https://bybit-exchange.github.io/docs/v5/order/dcp
     *
     * @param setDcpRequest timeWindow	true	integer	Disconnection timing window time. [3, 300], unit: second
     * @return Response Parameters
     * None
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/v5/order/disconnected-cancel-all")
    Call<Object> setDisconnectCancelAllTime(@Body SetDcpRequest setDcpRequest);

    /**
     * Place Order
     * This endpoint supports to create the order for spot, spot margin, USDT perpetual, USDC perpetual, USDC futures, inverse futures and options.
     * <p>
     * Unified account covers: Spot / USDT perpetual / USDC contract / Inverse contract / Options
     * Classic account covers: Spot / USDT perpetual / Inverse contract
     * <p>
     * INFO
     * Supported order type (orderType):
     * Limit order: orderType=Limit, it is necessary to specify order qty and price.
     * <p>
     * Market order: orderType=Market, execute at the best price in the Bybit market until the transaction is completed. When selecting a market order, the `price` is empty. In the futures trading system, in order to protect the serious slippage of the market order, the Bybit trading system will convert the market order into a limit order for matching. will be cancelled. The slippage threshold refers to the percentage that the order price deviates from the latest transaction price. The current threshold is set to 3% for BTC contracts and 5% for other contracts.
     * Supported timeInForce strategy:
     * GTC
     * IOC
     * FOK
     * PostOnly: If the order would be filled immediately when submitted, it will be cancelled. The purpose of this is to protect your order during the submission process. If the matching system cannot entrust the order to the order book due to price changes on the market, it will be cancelled. For the PostOnly order type, the quantity that can be submitted in a single order is more than other types of orders, please refer to the parameter lotSizeFilter &gt; postOnlyMaxOrderQty in the instruments-info endpoint.
     * <p>
     * How to create conditional order:
     * When submitting an order, if triggerPrice is set, the order will be automatically converted into a conditional order. In addition, the conditional order does not occupy the margin. If the margin is insufficient after the conditional order is triggered, the order will be cancelled.
     * <p>
     * Take profit / Stop loss: You can set TP/SL while placing orders. Besides, you could modify the position's TP/SL.
     * <p>
     * Order quantity: The quantity of perpetual contracts you are going to buy/sell. For the order quantity, Bybit only supports positive number at present.
     * <p>
     * Order price: Place a limit order, this parameter is required. If you have position, the price should be higher than the liquidation price. For the minimum unit of the price change, please refer to the priceFilter &gt; tickSize field in the instruments-info endpoint.
     * <p>
     * orderLinkId: You can customize the active order ID. We can link this ID to the order ID in the system. Once the active order is successfully created, we will send the unique order ID in the system to you. Then, you can use this order ID to cancel active orders, and if both orderId and orderLinkId are entered in the parameter input, Bybit will prioritize the orderId to process the corresponding order. Meanwhile, your customized order ID should be no longer than 36 characters and should be unique.
     * <p>
     * Open orders up limit:
     * Futures: Each account can hold a maximum of 500 active orders simultaneously. This is contract-specific, so the following situation is allowed: the same account can hold 300 BTCUSD active orders and 280 ETHUSD active orders at the same time. For conditional orders, each account can hold a maximum of 10 active orders simultaneously. When the upper limit of orders is reached, you can still place orders with parameters of reduceOnly or closeOnTrigger.
     * Spot: 500 orders in total, including a maximum of 30 open TP/SL orders, a maximum of 30 open conditional orders
     * Option: a maximum of 100 open orders
     * <p>
     * Rate limit:
     * Please refer to rate limit table. If you need to raise the rate limit, please contact your client manager or submit an application via here
     * <p>
     * Risk control limit notice:
     * Bybit will monitor on your API requests. When the total number of orders of a single user (aggregated the number of orders across main account and sub-accounts) within a day (UTC 0 - UTC 24) exceeds a certain upper limit, the platform will reserve the right to remind, warn, and impose necessary restrictions. Customers who use API default to acceptance of these terms and have the obligation to cooperate with adjustments.
     * <p>
     * TIP
     * To margin trade on spot on a normal account, you need to go here to borrow margin first.
     * <p>
     * https://bybit-exchange.github.io/docs/v5/order/create-order#http-request
     *
     * @param placeOrderRequest category	true	string	Product type
     *                          Unified account: spot, linear, inverse, option
     *                          Classic account: spot, linear, inverse
     *                          symbol	true	string	Symbol name
     *                          isLeverage	false	integer	Whether to borrow. Valid for Unified spot only. 0(default): false then spot trading, 1: true then margin trading
     *                          side	true	string	Buy, Sell
     *                          orderType	true	string	Market, Limit
     *                          qty	true	string	Order quantity.
     *                          For Spot Market Buy order, please note that qty should be quote curreny amount, and make sure it satisfies quotePrecision in Spot instrument spec
     *                          For other cases, please make sure the input qty is the multiples of minOrderQty from instrument info endpoint
     *                          In particular, for Futures and  Perps, if you pass qty="0", you can close the whole position of current symbol
     *                          price	false	string	Order price
     *                          Market order will ignore this field
     *                          Please check the min price and price precision from instrument info endpoint
     *                          If you have position, price needs to be better than liquidation price
     *                          triggerDirection	false	integer	Conditional order param. Used to identify the expected direction of the conditional order.
     *                          1: triggered when market price rises to triggerPrice
     *                          2: triggered when market price falls to triggerPrice
     *                          Valid for linear and  inverse
     *                          orderFilter	false	string	If it is not passed, Order by default.
     *                          Order
     *                          tpslOrder: Spot TP/SL order, the assets are occupied even before the order is triggered
     *                          StopOrder: Spot conditional order, the assets will not be occupied until the price of the underlying asset reaches the trigger price, and the required assets will be occupied after the Conditional order is triggered
     *                          Valid for spot only
     *                          triggerPrice	false	string  For Perps and  Futures, it is the conditional order trigger price. If you expect the price to rise to trigger your conditional order, make sure:
     *                          triggerPrice &gt; market price
     *                          Else, triggerPrice &lt; market price
     *                          For spot, it is the TP/SL and Conditional order trigger price
     *                          triggerBy	false	string	Trigger price type, Conditional order param for Perps and  Futures. LastPrice, IndexPrice, MarkPrice
     *                          Valid for linear and  inverse
     *                          orderIv	false	string	Implied volatility. option only. Pass the real value, e.g for 10%, 0.1 should be passed. orderIv has a higher priority when price is passed as well
     *                          timeInForce	false	string	Time in force
     *                          Market order will use IOC directly
     *                          If not passed, GTC is used by default
     *                          positionIdx	false	integer	Used to identify positions in different position modes. Under hedge-mode, this param is required (USDT perps and  Inverse contracts have hedge mode)
     *                          0: one-way mode
     *                          1: hedge-mode Buy side
     *                          2: hedge-mode Sell side
     *                          orderLinkId	false	string	User customised order ID. A max of 36 characters. Combinations of numbers, letters (upper and lower cases), dashes, and underscores are supported.
     *                          Futures and  Perps: orderLinkId rules:
     *                          optional param
     *                          always unique
     *                          option orderLinkId rules:
     *                          required param
     *                          always unique
     *                          takeProfit	false	string	Take profit price, valid for linear and  inverse
     *                          stopLoss	false	string	Stop loss price, valid for linear and  inverse
     *                          tpTriggerBy	false	string	The price type to trigger take profit. MarkPrice, IndexPrice, default: LastPrice. Valid for linear and  inverse
     *                          slTriggerBy	false	string	The price type to trigger stop loss. MarkPrice, IndexPrice, default: LastPrice. Valid for linear and  inverse
     *                          reduceOnly	false	boolean	What is a reduce-only order? true means your position can only reduce in size if this order is triggered.
     *                          You must specify it as true when you are about to close/reduce the position
     *                          When reduceOnly is true, take profit/stop loss cannot be set
     *                          Valid for linear, inverse and  option
     *                          closeOnTrigger	false	boolean	What is a close on trigger order? For a closing order. It can only reduce your position, not increase it. If the account has insufficient available balance when the closing order is triggered, then other active orders of similar contracts will be cancelled or reduced. It can be used to ensure your stop loss reduces your position regardless of current available margin.
     *                          Valid for linear and  inverse
     *                          smpType	false	string	Smp execution type. What is SMP?
     *                          mmp	false	boolean	Market maker protection. option only. true means set the order as a market maker protection order. What is mmp?
     *                          tpslMode	false	string	TP/SL mode
     *                          Full: entire position for TP/SL. Then, tpOrderType or slOrderType must be Market
     *                          Partial: partial position tp/sl. Limit TP/SL order are supported. Note: When create limit tp/sl, tpslMode is required and it must be Partial
     *                          Valid for linear and  inverse
     *                          tpLimitPrice	false	string	The limit order price when take profit price is triggered. Only works when tpslMode=Partial and tpOrderType=Limit.
     *                          Valid for linear and  inverse
     *                          slLimitPrice	false	string	The limit order price when stop loss price is triggered. Only works when tpslMode=Partial and slOrderType=Limit.
     *                          Valid for linear and  inverse
     *                          tpOrderType	false	string	The order type when take profit is triggered. Market(default), Limit. For tpslMode=Full, it only supports tpOrderType=Market.
     *                          Valid for linear and  inverse
     *                          slOrderType	false	string	The order type when stop loss is triggered. Market(default), Limit. For tpslMode=Full, it only supports slOrderType=Market.
     *                          Valid for linear and  inverse
     * @return Response Parameters
     * Parameter	Type	Comments
     * orderId	string	Order ID
     * orderLinkId	string	User customised order ID
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/v5/order/create")
    Call<Object> createOrder(@Body PlaceOrderRequest placeOrderRequest);

    /**
     * Batch Place Order
     * Covers: Option (UTA, UTA Pro) / USDT Perpetual, UDSC Perpetual, USDC Futures (UTA Pro)
     * <p>
     * TIP
     * This endpoint allows you to place more than one order in a single request.
     * <p>
     * Make sure you have sufficient funds in your account when placing an order. Once an order is placed, according to the funds required by the order, the funds in your account will be frozen by the corresponding amount during the life cycle of the order.
     * A maximum of 20 orders (option) and  10 orders (linear) can be placed per request. The returned data list is divided into two lists. The first list indicates whether or not the order creation was successful and the second list details the created order information. The structure of the two lists are completely consistent.
     * INFO
     * Check the rate limit instruction when category=linear here
     * Risk control limit notice:
     * Bybit will monitor on your API requests. When the total number of orders of a single user (aggregated the number of orders across main account and sub-accounts) within a day (UTC 0 - UTC 24) exceeds a certain upper limit, the platform will reserve the right to remind, warn, and impose necessary restrictions. Customers who use API default to acceptance of these terms and have the obligation to cooperate with adjustments.
     * <p>
     * https://bybit-exchange.github.io/docs/v5/order/batch-place
     *
     * @param placeBatchOrderRequest category	true	string	Product type. linear, option
     *                               request	true	array	Object
     *                               &gt;  symbol	true	string	Symbol name
     *                               &gt;  side	true	string	Buy, Sell
     *                               &gt;  orderType	true	string	Market, Limit
     *                               &gt;  qty	true	string	Order quantity
     *                               In particular, for linear, if you pass qty="0", you can close the whole position of current symbol
     *                               &gt;  price	false	string	Order price
     *                               Market order will ignore this field
     *                               Please check the min price and price precision from instrument info endpoint
     *                               If you have position, price needs to be better than liquidation price
     *                               &gt;  triggerDirection	false	integer	Conditional order param. Used to identify the expected direction of the conditional order.
     *                               1: triggered when market price rises to triggerPrice
     *                               2: triggered when market price falls to triggerPrice
     *                               Valid for linear
     *                               &gt;  triggerPrice	false	string  For futures, it is the conditional order trigger price. If you expect the price to rise to trigger your conditional order, make sure:
     *                               triggerPrice  &gt;  market price
     *                               Else, triggerPrice &lt; market price
     *                               &gt;  triggerBy	false	string	Conditional order param. Trigger price type. LastPrice, IndexPrice, MarkPrice
     *                               &gt;  orderIv	false	string	Implied volatility. option only. Pass the real value, e.g for 10%, 0.1 should be passed. orderIv has a higher priority when price is passed as well
     *                               &gt;  timeInForce	false	string	Time in force
     *                               Market order will use IOC directly
     *                               If not passed, GTC is used by default
     *                               &gt;  positionIdx	false	integer	Used to identify positions in different position modes. Under hedge-mode, this param is required (USDT perps have hedge mode)
     *                               0: one-way mode
     *                               1: hedge-mode Buy side
     *                               2: hedge-mode Sell side
     *                               &gt;  orderLinkId	false	string	User customised order ID. A max of 36 characters. Combinations of numbers, letters (upper and lower cases), dashes, and underscores are supported.
     *                               Futures and Perps: orderLinkId rules:
     *                               optional param
     *                               always unique
     *                               option orderLinkId rules:
     *                               required param
     *                               always unique
     *                               &gt;  takeProfit	false	string	Take profit price, valid for linear
     *                               &gt;  stopLoss	false	string	Stop loss price, valid for linear
     *                               &gt;  tpTriggerBy	false	string	The price type to trigger take profit. MarkPrice, IndexPrice, default: LastPrice.
     *                               Valid for linear
     *                               &gt;  slTriggerBy	false	string	The price type to trigger stop loss. MarkPrice, IndexPrice, default: LastPrice
     *                               Valid for linear
     *                               &gt;  reduceOnly	false	boolean	What is a reduce-only order? true means your position can only reduce in size if this order is triggered.
     *                               You must specify it as true when you are about to close/reduce the position
     *                               When reduceOnly is true, take profit/stop loss cannot be set
     *                               Valid for linear, and option
     *                               &gt;  closeOnTrigger	false	boolean	What is a close on trigger order? For a closing order. It can only reduce your position, not increase it. If the account has insufficient available balance when the closing order is triggered, then other active orders of similar contracts will be cancelled or reduced. It can be used to ensure your stop loss reduces your position regardless of current available margin.
     *                               Valid for linear
     *                               &gt;  smpType	false	string	Smp execution type. What is SMP?
     *                               &gt;  mmp	false	boolean	Market maker protection. option only. true means set the order as a market maker protection order. What is mmp?
     *                               &gt;  tpslMode	false	string	TP/SL mode
     *                               Full: entire position for TP/SL. Then, tpOrderType or slOrderType must be Market
     *                               Partial: partial position tp/sl. Limit TP/SL order are supported. Note: When create limit tp/sl, tpslMode is required and it must be Partial
     *                               Valid for linear
     *                               &gt;  tpLimitPrice	false	string	The limit order price when take profit price is triggered. Only works when tpslMode=Partial and tpOrderType=Limit
     *                               Valid for linear
     *                               &gt;  slLimitPrice	false	string	The limit order price when stop loss price is triggered. Only works when tpslMode=Partial and slOrderType=Limit
     *                               Valid for linear
     *                               &gt;  tpOrderType	false	string	The order type when take profit is triggered. Market(default), Limit. For tpslMode=Full, it only supports tpOrderType=Market
     *                               Valid for linear
     *                               &gt;  slOrderType	false	string	The order type when stop loss is triggered. Market(default), Limit. For tpslMode=Full, it only supports slOrderType=Market
     *                               Valid for linear
     * @return Response Parameters
     * Parameter	Type	Comments
     * result	Object
     * &gt; list	array	Object
     * &gt; &gt; category	string	Product type
     * &gt; &gt; symbol	string	Symbol name
     * &gt; &gt; orderId	string	Order ID
     * &gt; &gt; orderLinkId	string	User customised order ID
     * &gt; &gt; createAt	string	Order created time (ms)
     * retExtInfo	Object
     * &gt; list	array	Object
     * &gt; &gt; code	number	Success/error code
     * &gt; &gt; msg	string	Success/error message
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/v5/order/create-batch")
    Call<Object> createBatchOrder(@Body PlaceBatchOrderRequest placeBatchOrderRequest);

    /**
     * Cancel Order
     * Unified account covers: Spot / USDT perpetual / USDC contract / Inverse contract / Options
     * Classic account covers: Spot / USDT perpetual / Inverse contract
     * <p>
     * IMPORTANT
     * You must specify orderId or orderLinkId to cancel the order.
     * If orderId and orderLinkId do not match, the system will process orderId first.
     * You can only cancel unfilled or partially filled orders.
     * <p>
     * https://bybit-exchange.github.io/docs/v5/order/cancel-order
     *
     * @param cancelOrderRequest category    true	string	Product type
     *                           Unified account: spot, linear, inverse, option
     *                           Classic account: spot, linear, inverse
     *                           symbol	true	string	Symbol name
     *                           orderId	false	string	Order ID. Either orderId or orderLinkId is required
     *                           orderLinkId	false	string	User customised order ID. Either orderId or orderLinkId is required
     *                           orderFilter	false	string	Valid for spot only. Order,tpslOrder,StopOrder. If not passed, Order by default
     * @return Response Parameters
     * * Parameter	Type	Comments
     * * orderId	string	Order ID
     * * orderLinkId	string	User customised order ID
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/v5/order/cancel")
    Call<Object> cancelOrder(@Body CancelOrderRequest cancelOrderRequest);

    /**
     * Batch Cancel Order
     * This endpoint allows you to cancel more than one open order in a single request.
     * <p>
     * Covers: Option (UTA, UTA Pro) / USDT Perpetual, UDSC Perpetual, USDC Futures (UTA Pro)
     * <p>
     * IMPORTANT
     * You must specify orderId or orderLinkId.
     * If orderId and orderLinkId is not matched, the system will process orderId first.
     * You can cancel unfilled or partially filled orders.
     * A maximum of 20 orders (option) and  10 orders (linear) can be cancelled per request.
     * <p>
     * https://bybit-exchange.github.io/docs/v5/order/batch-cancel#http-request
     *
     * @param cancelBatchOrderRequest category	true	string	Product type. linear, option
     *                                request	true	array	Object
     *                                &gt; symbol	true	string	Symbol name
     *                                &gt; orderId	false	string	Order ID. Either orderId or orderLinkId is required
     *                                &gt; orderLinkId	false	string	User customised order ID. Either orderId or orderLinkId is required
     * @return Response Parameters
     * Parameter	Type	Comments
     * result	Object
     * &gt; list	array	Object
     * &gt; &gt; category	string	Product type
     * &gt; &gt; symbol	string	Symbol name
     * &gt; &gt; orderId	string	Order ID
     * &gt; &gt; orderLinkId	string	User customised order ID
     * retExtInfo	Object
     * &gt; list	array	Object
     * &gt; &gt; code	number	Success/error code
     * &gt; &gt; msg	string	Success/error message
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/v5/order/cancel-batch")
    Call<Object> cancelBatchOrder(@Body CancelBatchOrderRequest cancelBatchOrderRequest);

    /**
     * Cancel All Orders
     * Cancel all open orders
     * <p>
     * Unified account covers: Spot / USDT perpetual / USDC contract / Inverse contract / Options
     * Classic account covers: Spot / USDT perpetual / Inverse contract
     * <p>
     * INFO
     * Support cancel orders by symbol/baseCoin/settleCoin. If you pass multiple of these params, the system will process one of param, which priority is symbol &gt; baseCoin &gt; settleCoin.
     * NOTE: category=option, you can cancel all option open orders without passing any of those three params. However, for linear and inverse, you must specify one of those three params.
     * NOTE: category=spot, you can cancel all spot open orders (normal order by default) without passing other params.
     * <p>
     * https://bybit-exchange.github.io/docs/v5/order/cancel-all
     *
     * @param cancelAllOrdersRequest category    true	string	Product type
     *                               Unified account: spot, linear, inverse, option
     *                               Classic account: spot, linear, inverse
     *                               symbol	false	string	Symbol name. linear and inverse: Required if not passing baseCoin or settleCoin
     *                               baseCoin    false	string	Base coin
     *                               linear and inverse(Classic account): If cancel all by baseCoin, it will cancel all linear and inverse orders. Required if not passing symbol or settleCoin
     *                               linear and inverse(Unified account): If cancel all by baseCoin, it will cancel all corresponding category orders. Required if not passing symbol or settleCoin
     *                               Classic spot: invalid
     *                               settleCoin    false	string	Settle coin
     *                               linear and inverse: Required if not passing symbol or baseCoin
     *                               Does not support spot
     *                               orderFilter    false	string
     *                               category=spot, you can pass Order, tpslOrder, StopOrder. If not passed, Order by default
     *                               category=linear or inverse, you can pass Order, StopOrder. If not passed, all kinds of orders will be cancelled, like active order, conditional order, TP/SL order and trailing stop order
     *                               category=option, you can pass Order. No matter it is passed or not, always cancel all orders
     *                               stopOrderType    false	string	Stop order type, Stop
     *                               Only used for category=linear or inverse and orderFilter=StopOrder,you can cancel conditional orders except TP/SL order and Trailing stop orders with this param
     * @return Response Parameters
     * Linear/Inverse/Option
     * Parameter	Type	Comments
     * list	array	Object
     * &gt; orderId	string	Order ID
     * &gt; orderLinkId	string	User customised order ID
     * <p>
     * Spot
     * Parameter	Type	Comments
     * success	string	1: success, 0: fail
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/v5/order/cancel-all")
    Call<Object> cancelAllOrder(@Body CancelAllOrdersRequest cancelAllOrdersRequest);

    /**
     * Amend Order
     * Unified account covers: USDT perpetual / USDC contract / Inverse contract / Option
     * Classic account covers: USDT perpetual / Inverse contract
     * <p>
     * IMPORTANT
     * You can only modify unfilled or partially filled orders.
     * <p>
     * https://bybit-exchange.github.io/docs/v5/order/amend-order
     *
     * @param amendOrderRequest category    true	string	Product type
     *                          Unified account: linear, inverse, option
     *                          Classic account: linear, inverse. Please note that category is not involved with business logic
     *                          symbol	true	string	Symbol name
     *                          orderId	false	string	Order ID. Either orderId or orderLinkId is required
     *                          orderLinkId	false	string	User customised order ID. Either orderId or orderLinkId is required
     *                          orderIv	false	string	Implied volatility. option only. Pass the real value, e.g for 10%, 0.1 should be passed
     *                          triggerPrice    false	string	If you expect the price to rise to trigger your conditional order, make sure:
     *                          triggerPrice &gt; market price
     *                          Else, triggerPrice &lt;  market price
     *                          qty	false	string	Order quantity after modification. Do not pass it if not modify the qty
     *                          price	false	string	Order price after modification. Do not pass it if not modify the price
     *                          takeProfit	false	string	Take profit price after modification. If pass "0", it means cancel the existing take profit of the order. Do not pass it if you do not want to modify the take profit
     *                          stopLoss	false	string	Stop loss price after modification. If pass "0", it means cancel the existing stop loss of the order. Do not pass it if you do not want to modify the stop loss
     *                          tpTriggerBy	false	string	The price type to trigger take profit. When set a take profit, this param is required if no initial value for the order
     *                          slTriggerBy	false	string	The price type to trigger stop loss. When set a take profit, this param is required if no initial value for the order
     *                          triggerBy	false	string	Trigger price type
     *                          tpLimitPrice	false	string	Limit order price when take profit is triggered. Only working when original order sets partial limit tp/sl
     *                          slLimitPrice	false	string	Limit order price when stop loss is triggered. Only working when original order sets partial limit tp/sl
     * @return Response Parameters
     * Parameter	Type	Comments
     * orderId	string	Order ID
     * orderLinkId	string	User customised order ID
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/v5/order/amend")
    Call<Object> amendOrder(@Body AmendOrderRequest amendOrderRequest);

    /**
     * BBatch Amend Order
     * Covers: Option (UTA, UTA Pro) / USDT Perpetual, UDSC Perpetual, USDC Futures (UTA Pro)
     * <p>
     * TIP
     * This endpoint allows you to amend more than one open order in a single request.
     * <p>
     * You can modify unfilled or partially filled orders. Conditional orders are not supported.
     * A maximum of 20 orders (option) and  10 orders (linear) can be amended per request.
     * <p>
     * https://bybit-exchange.github.io/docs/v5/order/batch-amend
     *
     * @param batchOrderRequest category	true	string	Product type. linear, option
     *                          request	true	array	Object
     *                          &gt; symbol	true	string	Symbol name
     *                          &gt; orderId	false	string	Order ID. Either orderId or orderLinkId is required
     *                          &gt; orderLinkId	false	string	User customised order ID. Either orderId or orderLinkId is required
     *                          &gt; orderIv	false	string	Implied volatility. option only. Pass the real value, e.g for 10%, 0.1 should be passed
     *                          &gt; triggerPrice	false	string	If you expect the price to rise to trigger your conditional order, make sure:
     *                          triggerPrice &gt; market price
     *                          Else, triggerPrice &lt; market price
     *                          &gt; qty	false	string	Order quantity after modification. Do not pass it if not modify the qty
     *                          &gt; price	false	string	Order price after modification. Do not pass it if not modify the price
     *                          &gt; takeProfit	false	string	Take profit price after modification. If pass "0", it means cancel the existing take profit of the order. Do not pass it if you do not want to modify the take profit
     *                          &gt; stopLoss	false	string	Stop loss price after modification. If pass "0", it means cancel the existing stop loss of the order. Do not pass it if you do not want to modify the stop loss
     *                          &gt; tpTriggerBy	false	string	The price type to trigger take profit. When set a take profit, this param is required if no initial value for the order
     *                          &gt; slTriggerBy	false	string	The price type to trigger stop loss. When set a take profit, this param is required if no initial value for the order
     *                          &gt; triggerBy	false	string	Trigger price type
     *                          &gt; tpLimitPrice	false	string	Limit order price when take profit is triggered. Only working when original order sets partial limit tp/sl
     *                          &gt; slLimitPrice	false	string	Limit order price when stop loss is triggered. Only working when original order sets partial limit tp/sl
     * @return Response Parameters
     * Parameter	Type	Comments
     * result	Object
     * &gt;list	array	Object
     * &gt;&gt; category	string	Product type
     * &gt;&gt; symbol	string	Symbol name
     * &gt;&gt; orderId	string	Order ID
     * &gt;&gt; orderLinkId	string	User customised order ID
     * retExtInfo	Object
     * &gt;list	array	Object
     * &gt;&gt; code	number	Success/error code
     * &gt;&gt; msg	string	Success/error message
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/v5/order/amend-batch")
    Call<Object> amendBatchOrder(@Body AmendBatchOrderRequest batchOrderRequest);

    // User

    /**
     * Get API Key Information
     * Get the information of the api key. Use the api key pending to be checked to call the endpoint. Both master and sub user's api key are applicable.
     * <p>
     * TIP
     * Any permission can access this endpoint.
     * <p>
     * https://bybit-exchange.github.io/docs/v5/user/apikey-info
     *
     * @return Response Parameters
     * Parameter	Type	Comments
     * id	string	Unique ID. Internal use
     * note	string	The remark
     * apiKey	string	Api key
     * readOnly	integer	0：Read and Write. 1：Read only
     * secret	string	Always ""
     * permissions	Object	The types of permission
     * &gt; ContractTrade	array	Permission of contract trade
     * &gt; Spot	array	Permission of spot
     * &gt; Wallet	array	Permission of wallet
     * &gt; Options	array	Permission of USDC Contract. It supports trade option and USDC perpetual.
     * &gt; Derivatives	array	Permission of derivatives
     * &gt; CopyTrading	array	Permission of copytrade. Not applicable to subaccount, always []
     * &gt; BlockTrade	array	Permission of blocktrade. Not applicable to subaccount, always []
     * &gt; Exchange	array	Permission of exchange
     * &gt; NFT	array	Permission of NFT. Not applicable to sub account, always []
     * ips	array	IP bound
     * type	integer	The type of api key. 1：personal, 2：connected to the third-party app
     * deadlineDay	integer	The remaining valid days of api key. Only for those api key with no IP bound or the password has been changed
     * expiredAt	datetime	The expiry day of the api key. Only for those api key with no IP bound or the password has been changed
     * createdAt	datetime	The create day of the api key
     * unified	integer	Whether the account to which the api key belongs is a unified margin account. 0：regular account; 1：unified margin account
     * uta	integer	Whether the account to which the account upgrade to unified trade account. 0：regular account; 1：unified trade account
     * userID	integer	User ID
     * inviterID	integer	Inviter ID (the UID of the account which invited this account to the platform)
     * vipLevel	string	VIP Level
     * mktMakerLevel	string	Market maker level
     * affiliateID	integer	Affiliate Id. 0 represents that there is no binding relationship.
     * rsaPublicKey	string	Rsa public key
     * isMaster	boolean	If this api key belongs to master account or not
     * parentUid	string	The main account uid. Returns "0" when the endpoint is called by main account
     * kycLevel	string	Personal account kyc level. LEVEL_DEFAULT, LEVEL_1， LEVEL_2
     * kycRegion	string	Personal account kyc region
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/v5/user/query-api")
    Call<Object> getCurrentAPIKeyInfo();

    /**
     * Get Sub UID List
     * Get all sub UID of master account. Use master user's api key only.
     * <p>
     * TIP
     * The API key must have one of the below permissions in order to call this endpoint..
     * <p>
     * master API key: "Account Transfer", "Subaccount Transfer", "Withdrawal"
     * <p>
     * https://bybit-exchange.github.io/docs/v5/user/subuid-list
     *
     * @return Response Parameters
     * Parameter	Type	Comments
     * subMembers	array	Object
     * &gt; uid	string	Sub user Id
     * &gt; username	string	Username
     * &gt; memberType	integer	1: normal sub account, 6: custodial sub account
     * &gt; status	integer	The status of the user account
     * 1: normal
     * 2: login banned
     * 4: frozen
     * &gt; accountMode	integer	The account mode of the user account
     * 1: classic account
     * 2: UMA
     * 3: UTA
     * &gt; remark	string	The remark
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/v5/user/query-sub-members")
    Call<Object> getSubUIDList();

    /**
     * Get Sub UID List (Unlimited)
     * This API is applicable to the client who has over 10k sub accounts. Use master user's api key only.
     *
     * tip
     * The API key must have one of the below permissions in order to call this endpoint..
     *
     * master API key: "Account Transfer", "Subaccount Transfer", "Withdrawal"
     * https://bybit-exchange.github.io/docs/v5/user/page-subuid
     * HTTP Request
     * GET /v5/user/submembers
     * @param pageSize false	string	Data size per page. Return up to 100 records per request
     * @param nextCursor false	string	Cursor. Use the nextCursor token from the response to retrieve the next page of the result set
     * @return Response Parameters
     * Parameter	Type	Comments
     * subMembers	array	Object
     * &gt; uid	string	Sub user Id
     * &gt; username	string	Username
     * &gt; memberType	integer	1: standard sub account, 6: custodial sub account
     * &gt; status	integer	The status of the user account
     * 1: normal
     * 2: login banned
     * 4: frozen
     * &gt; accountMode	integer	The account mode of the user account
     * 1: Classic Account
     * 3: Unified Trading Account
     * &gt; remark	string	The remark
     * nextCursor	string	The next page cursor value. "0" means no more pages
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/v5/user/submembers")
    Call<Object> getSubUIDListUnlimited(@Query("pageSize") String pageSize,
                                        @Query("nextCursor") String nextCursor);

    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/v5/user/submembers")
    Call<Object> getSubUIDListUnlimited();

    /**
     * Get Sub Account All API Keys
     * Query all api keys information of a sub UID.
     *
     * tip
     * Any permission can access this endpoint
     * Only master account can call this endpoint
     * HTTP Request
     * GET /v5/user/sub-apikeys
     * https://bybit-exchange.github.io/docs/v5/user/list-sub-apikeys
     * @param subMemberId	true	string	Sub UID
     * @param limit	false	integer	Limit for data size per page. [1, 20]. Default: 20
     * @param cursor	false	string	Cursor. Use the nextPageCursor token from the response to retrieve the next page of the result set
     * @return Response Parameters
     * Parameter	Type	Comments
     * result	array	Object
     * &gt; id	string	Unique ID. Internal use
     * &gt; ips	array string	IP bound
     * &gt; apiKey	string	Api key
     * &gt; note	string	The remark
     * &gt; status	integer	1: permanent, 2: expired, 3: within the validity period, 4: expires soon (less than 7 days)
     * &gt; expiredAt	datetime	The expiry day of the api key. Only for those api key with no IP bound or the password has been changed
     * &gt; createdAt	datetime	The create day of the api key
     * &gt; type	integer	The type of api key. 1：personal, 2：connected to the third-party app
     * &gt; permissions	Object	The types of permission
     * &gt;&gt; ContractTrade	array	Permission of contract trade Order, Position
     * &gt;&gt; Spot	array	Permission of spot SpotTrade
     * &gt;&gt; Wallet	array	Permission of wallet AccountTransfer, SubMemberTransferList
     * &gt;&gt; Options	array	Permission of USDC Contract. It supports trade option and USDC perpetual. OptionsTrade
     * &gt;&gt; Derivatives	array	Unified account api key have this permission by default. DerivativesTrade
     * &gt;&gt; CopyTrading	array	Always [], Master Trader uses "Contract" permission to start Copytrading
     * &gt;&gt; BlockTrade	array	Permission of blocktrade. Not applicable to subaccount, always []
     * &gt;&gt; Exchange	array	Permission of exchange ExchangeHistory
     * &gt;&gt; NFT	array	Permission of NFT. Not applicable to sub account, always []
     * &gt;&gt; Affiliate	array	Permission of Affiliate. Not applicable to sub account, always []
     * &gt; secret	string	Always "******"
     * &gt; readOnly	boolean	true, false
     * &gt; deadlineDay	integer	The remaining valid days of api key. Only for those api key with no IP bound or the password has been changed
     * &gt; flag	string	Api key type
     * nextPageCursor	string	Refer to the cursor request parameter
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/v5/user/sub-apikeys")
    Call<Object> getSubAccAllAPIKeyInfo(
            @Query("subMemberId") String subMemberId,
            @Query("limit") Integer limit,
            @Query("cursor") String cursor);

    /**
     * Get UID Wallet Type
     * Get available wallet types for the master account or sub account
     * <p>
     * TIP
     * Master api key: you can get master account and appointed sub account available wallet types, and support up to 200 sub UID in one request.
     * Sub api key: you can get its own available wallet types
     * PRACTICE
     * "FUND" - If you never deposit or transfer capital into it, this wallet type will not be shown in the array, but your account indeed has this wallet.
     * <p>
     * ["SPOT","OPTION","FUND","CONTRACT"] : Classic account and Funding wallet was operated before
     * ["SPOT","OPTION","CONTRACT"] : Classic account and Funding wallet is never operated
     * ["SPOT","UNIFIED","FUND","CONTRACT"] : UMA account and Funding wallet was operated before. (No UMA account after we forced upgrade to UTA)
     * ["SPOT","UNIFIED","CONTRACT"] : UMA account and Funding wallet is never operated. (No UMA account after we forced upgrade to UTA)
     * ["UNIFIED""FUND","CONTRACT"] : UTA account and Funding wallet was operated before.
     * ["UNIFIED","CONTRACT"] : UTA account and Funding wallet is never operated.
     * <p>
     * https://bybit-exchange.github.io/docs/v5/user/wallet-type
     *
     * @param memberIds false	string
     *                  Query itself wallet types when not passed
     *                  When use master api key to query sub UID, master UID data is always returned in the top of the array
     *                  Multiple sub UID are supported, separated by commas
     *                  This param is ignored when you use sub account api key
     * @return Response Parameters
     * Parameter	Type	Comments
     * accounts	array	Object
     * &gt; uid	string	Master/Sub user Id
     * &gt; accountType	array	Wallets array. SPOT, CONTRACT, FUND, OPTION, UNIFIED. Please check above practice to understand the value
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/v5/user/get-member-type")
    Call<Object> getUIDWalletType(@Query("memberIds") String memberIds);

    /**
     * Get Affiliate User Info
     * This API is used for affiliate to get their users information
     * <p>
     * TIP
     * Use master UID only
     * The api key can only have "Affiliate" permission
     * The transaction volume and deposit amount are the total amount of the user done on Bybit, and have nothing to do with commission settlement. Any transaction volume data related to commission settlement is subject to the Affiliate Portal.
     * <p>
     * https://bybit-exchange.github.io/docs/v5/user/affiliate-info
     *
     * @param uid true	string	The master account UID of affiliate's client
     * @return Response Parameters
     * Parameter	Type	Comments
     * uid	string	UID
     * vipLevel	string	VIP level
     * takerVol30Day	string	Taker volume in last 30 days (USDT). All volume related attributes below includes Derivatives, Option, Spot volume
     * makerVol30Day	string	Maker volume in last 30 days (USDT)
     * tradeVol30Day	string	Total trading volume in last 30 days (USDT)
     * depositAmount30Day	string	Deposit amount in last 30 days (USDT)
     * takerVol365Day	string	Taker volume in the past year (USDT)
     * makerVol365Day	string	Maker volume in the past year (USDT)
     * tradeVol365Day	string	Total trading volume in the past year (USDT)
     * depositAmount365Day	string	Total deposit amount in the past year (USDT)
     * totalWalletBalance	string	Wallet balance range
     * 1: less than 100 USDT value
     * 2: [100, 250) USDT value
     * 3: [250, 500) USDT value
     * 4: greater than 500 USDT value
     * depositUpdateTime	string	The update date time (UTC) of deposit data
     * volUpdateTime	string	The update date of volume data time (UTC)
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/v5/user/aff-customer-info")
    Call<Object> getAffiliateUserInfo(@Query("uid") String uid);

    /**
     * Create Sub UID
     * Create a new sub user id. Use master user's api key only.
     * <p>
     * TIP
     * The API key must have one of the below permissions in order to call this endpoint..
     * <p>
     * master API key: "Account Transfer", "Subaccount Transfer", "Withdrawal"
     * <p>
     * https://bybit-exchange.github.io/docs/v5/user/create-subuid#http-request
     *
     * @param userSubMemberRequest username	true	string	Give a username of the new sub user id.
     *                             6-16 characters, must include both numbers and letters.
     *                             cannot be the same as the exist or deleted one.
     *                             password	false	string	Set the password for the new sub user id.
     *                             8-30 characters, must include numbers, upper and lowercase letters.
     *                             memberType	true	integer	1: normal sub account, 6: custodial sub account
     *                             switch	false	integer 0: turn off quick login (default)
     *                             1: turn on quick login.
     *                             isUta	false	boolean true: create UTA account
     *                             false(default): create classic account
     *                             note	false	string	Set a remark
     * @return Response Parameters
     * Parameter	Type	Comments
     * uid	string	Sub user Id
     * username	string	Give a username of the new sub user id.
     * 6-16 characters, must include both numbers and letters.
     * cannot be the same as the exist or deleted one.
     * memberType	integer	1: normal sub account, 6: custodial sub account
     * status	integer	The status of the user account
     * 1: normal
     * 2: login banned
     * 4: frozen
     * remark	string	The remark
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/v5/user/create-sub-member")
    Call<Object> createSubMember(@Body UserSubMemberRequest userSubMemberRequest);

    /**
     * Create Sub UID API Key
     * To create new API key for those newly created sub UID. Use master user's api key only.
     * <p>
     * TIP
     * The API key must have one of the below permissions in order to call this endpoint..
     * <p>
     * master API key: "Account Transfer", "Subaccount Transfer", "Withdrawal"
     * <p>
     * https://bybit-exchange.github.io/docs/v5/user/create-subuid-apikey#http-request
     *
     * @param createSubApiKeyRequest subuid	true	integer	Sub user Id
     *                            note	false	string	Set a remark
     *                            readOnly	true	integer	0：Read and Write. 1：Read only
     *                            ips	false	string	Set the IP bind. example: "192.168.0.1,192.168.0.2"note:
     *                            don't pass ips or pass with "*" means no bind
     *                            No ip bound api key will be invalid after 90 days
     *                            api key without IP bound will be invalid after 7 days once the account password is changed
     *                            permissions	true	Object	Tick the types of permission.
     *                            one of below types must be passed, otherwise the error is thrown
     *                            &gt; ContractTrade	false	array	Contract Trade. ["Order","Position"]
     *                            &gt; Spot	false	array	Spot Trade. ["SpotTrade"]
     *                            &gt; Wallet	false	array	Wallet. ["AccountTransfer","SubMemberTransferList"]
     *                            &gt; Options	false	array	USDC Contract. ["OptionsTrade"]
     *                            &gt; Derivatives	false	array	This param is depreciated because system will automatically add this permission according to your account is UTA or Classic
     *                            &gt; Exchange	false	array	Exchange. ["ExchangeHistory"]
     *                            &gt; CopyTrading	false	array	Copytrade. ["CopyTrading"]
     * @return Response Parameters
     * Parameter	Type	Comments
     * id	string	Unique id. Internal used
     * note	string	The remark
     * apiKey	string	Api key
     * readOnly	integer	0：Read and Write. 1：Read only
     * secret	string	The secret paired with api key.
     * The secret can't be queried by GET api. Please keep it properly
     * permissions	Object	The types of permission
     * &gt; ContractTrade	array	Permisson of contract trade
     * &gt; Spot	array	Permisson of spot
     * &gt; Wallet	array	Permisson of wallet
     * &gt; Options	array	Permission of USDC Contract. It supports trade option and usdc perpetual.
     * &gt; Derivatives	array	Permission of Unified account
     * &gt; CopyTrading	array	Permission of copytrade
     * &gt; BlockTrade	array	Permission of blocktrade. Not applicable to sub account, always []
     * &gt; Exchange	array	Permission of exchange
     * &gt; NFT	array	Permission of NFT. Not applicable to sub account, always []
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/v5/user/create-sub-api")
    Call<Object> createSubAPI(@Body CreateSubApiKeyRequest createSubApiKeyRequest);

    /**
     * Modify Master API Key
     * Modify the settings of master api key. Use the api key pending to be modified to call the endpoint. Use master user's api key only.
     * <p>
     * TIP
     * The API key must have one of the below permissions in order to call this endpoint..
     * <p>
     * master API key: "Account Transfer", "Subaccount Transfer", "Withdrawal"
     * INFO
     * Only the api key that calls this interface can be modified
     * <p>
     * https://bybit-exchange.github.io/docs/v5/user/modify-master-apikey#http-request
     *
     * @param modifyMasterApiKeyRequest readOnly	false	integer	0 (default)：Read and Write. 1：Read only
     *                                  ips	false	string	Set the IP bind. example: "192.168.0.1,192.168.0.2"note:
     *                                  don't pass ips or pass with "*" means no bind
     *                                  No ip bound api key will be invalid after 90 days
     *                                  api key will be invalid after 7 days once the account password is changed
     *                                  permissions	false	Object	Tick the types of permission. Don't send this param if you don't want to change the permission
     *                                  &gt; ContractTrade	false	array	Contract Trade. ["Order","Position"]
     *                                  &gt; Spot	false	array	Spot Trade. ["SpotTrade"]
     *                                  &gt; Wallet	false	array	Wallet. ["AccountTransfer","SubMemberTransfer"]
     *                                  &gt; Options	false	array	USDC Contract. ["OptionsTrade"]
     *                                  &gt; Derivatives	false	array	This param is depreciated because system will automatically add this permission according to your account is UTA or Classic
     *                                  &gt; CopyTrading	false	array	Copytrade. ["CopyTrading"]
     *                                  &gt; BlockTrade	false	array	Blocktrade. ["BlockTrade"]
     *                                  &gt; Exchange	false	array	Exchange. ["ExchangeHistory"]
     *                                  &gt; NFT	false	array	NFT. ["NFTQueryProductList"]
     *                                  &gt; Affiliate	false	array	Affiliate. ["Affiliate"]
     *                                  This permission is only useful for affiliate
     *                                  If you need this permission, make sure you remove all other permissions
     * @return Response Parameters
     * Parameter	Type	Comments
     * id	string	Unique id. Internal used
     * note	string	The remark
     * apiKey	string	Api key
     * readOnly	integer	0：Read and Write. 1：Read only
     * secret	string	Always ""
     * permissions	Object	The types of permission
     * &gt; ContractTrade	array	Permisson of contract trade
     * &gt; Spot	array	Permisson of spot
     * &gt; Wallet	array	Permisson of wallet
     * &gt; Options	array	Permission of USDC Contract. It supports trade option and usdc perpetual.
     * &gt; Derivatives	array	Permission of Unified account
     * &gt; CopyTrading	array	Permission of copytrade. Not applicable to sub account, always []
     * &gt; BlockTrade	array	Permission of blocktrade. Not applicable to sub account, always []
     * &gt; Exchange	array	Permission of exchange
     * &gt; NFT	array	Permission of NFT. Not applicable to sub account, always []
     * ips	array	IP bound
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/v5/user/update-api")
    Call<Object> modifyMasterApiKey(@Body ModifyApiKeyRequest modifyMasterApiKeyRequest);

    /**
     * Modify Sub API Key
     * Modify the settings of sub api key. Use the sub account api key pending to be modified to call the endpoint or use master account api key to manage its sub account api key.
     * <p>
     * TIP
     * The API key must have one of the below permissions in order to call this endpoint
     * <p>
     * sub API key: "Account Transfer", "Sub Member Transfer"
     * master API Key: "Account Transfer", "Sub Member Transfer", "Withdrawal"
     * <p>
     * https://bybit-exchange.github.io/docs/v5/user/modify-sub-apikey#http-request
     *
     * @param modifysubApiKeyRequest apikey	false	string	Sub account api key
     *                               You must pass this param when you use master account manage sub account api key settings
     *                               If you use corresponding sub uid api key call this endpoint, apikey param cannot be passed, otherwise throwing an error
     *                               readOnly	false	integer	0 (default)：Read and Write. 1：Read only
     *                               ips	false	string	Set the IP bind. example: "192.168.0.1,192.168.0.2"note:
     *                               don't pass ips or pass with "*" means no bind
     *                               No ip bound api key will be invalid after 90 days
     *                               api key will be invalid after 7 days once the account password is changed
     *                               permissions	false	Object	Tick the types of permission. Don't send this param if you don't want to change the permission
     *                               &gt; ContractTrade	false	array	Contract Trade. ["Order","Position"]
     *                               &gt; Spot	false	array	Spot Trade. ["SpotTrade"]
     *                               &gt; Wallet	false	array	Wallet. ["AccountTransfer", "SubMemberTransferList"]
     *                               &gt; Options	false	array	USDC Contract. ["OptionsTrade"]
     *                               &gt; Derivatives	false	array	This param is depreciated because system will automatically add this permission according to your account is UTA or Classic
     *                               &gt; Exchange	false	array	Exchange. ["ExchangeHistory"]
     *                               &gt; CopyTrading	false	array	Copytrade. ["CopyTrading"]
     * @return Response Parameters
     * Parameter	Type	Comments
     * id	string	Unique id. Internal used
     * note	string	The remark
     * apiKey	string	Api key
     * readOnly	integer	0：Read and Write. 1：Read only
     * secret	string	Always ""
     * permissions	Object	The types of permission
     * &gt; ContractTrade	array	Permisson of contract trade
     * &gt; Spot	array	Permisson of spot
     * &gt; Wallet	array	Permisson of wallet
     * &gt; Options	array	Permission of USDC Contract. It supports trade option and usdc perpetual.
     * &gt; Derivatives	array	Permission of Unified account
     * &gt; CopyTrading	array	Permission of copytrade
     * &gt; BlockTrade	array	Permission of blocktrade. Not applicable to sub account, always []
     * &gt; Exchange	array	Permission of exchange
     * &gt; NFT	array	Permission of NFT. Not applicable to sub account, always []
     * ips	array	IP bound
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/v5/user/update-sub-api")
    Call<Object> modifySubApiKey(@Body ModifyApiKeyRequest modifysubApiKeyRequest);

    /**
     * Delete Master API Key
     * Delete the api key of master account. Use the api key pending to be delete to call the endpoint. Use master user's api key only.
     * <p>
     * TIP
     * The API key must have one of the below permissions in order to call this endpoint..
     * <p>
     * master API key: "Account Transfer", "Subaccount Transfer", "Withdrawal"
     * DANGER
     * BE CAREFUL! The API key used to call this interface will be invalid immediately.
     * <p>
     * https://bybit-exchange.github.io/docs/v5/user/rm-master-apikey
     *
     * @return Response Parameters
     * None
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/v5/user/delete-api")
    Call<Object> deleteMasterApiKey();

    /**
     * Delete Sub API Key
     * Delete the api key of sub account. Use the sub api key pending to be delete to call the endpoint or use the master api key to delete corresponding sub account api key
     * <p>
     * TIP
     * The API key must have one of the below permissions in order to call this endpoint.
     * <p>
     * sub API key: "Account Transfer", "Sub Member Transfer"
     * master API Key: "Account Transfer", "Sub Member Transfer", "Withdrawal"
     * DANGER
     * BE CAREFUL! The Sub account API key will be invalid immediately after calling the endpoint.
     * <p>
     * https://bybit-exchange.github.io/docs/v5/user/rm-sub-apikey#http-request
     *
     * @param deleteSubUidRequest apikey	false	string	Sub account api key
     *                            You must pass this param when you use master account manage sub account api key settings
     *                            If you use corresponding sub uid api key call this endpoint, apikey param cannot be passed, otherwise throwing an error
     * @return Response Parameters
     * None
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/v5/user/delete-sub-api")
    Call<Object> deleteSubApiKey(@Body ModifyApiKeyRequest deleteSubUidRequest);

    /**
     * Freeze Sub UID
     * Freeze Sub UID. Use master user's api key only.
     * <p>
     * TIP
     * The API key must have one of the below permissions in order to call this endpoint..
     * <p>
     * master API key: "Account Transfer", "Subaccount Transfer", "Withdrawal"
     * <p>
     * https://bybit-exchange.github.io/docs/v5/user/froze-subuid#http-request
     *
     * @param freezeSubUIDRquest subuid	true	integer	Sub user Id
     *                           frozen	true	integer	0：unfreeze, 1：freeze
     * @return Response Parameters
     * None
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/v5/user/frozen-sub-member")
    Call<Object> freezeSubMember(@Body FreezeSubUIDRquest freezeSubUIDRquest);

    // Position Data endpoints

    /**
     * Get Position Info
     * Query real-time position data, such as position size, cumulative realizedPNL.
     * <p>
     * Unified account covers: USDT perpetual / USDC contract / Inverse contract / Options
     * Classic account covers: USDT perpetual / Inverse contract
     * <p>
     * https://bybit-exchange.github.io/docs/v5/position
     *
     * @param category   true	string	Product type
     *                   Unified account: linear, inverse, option
     *                   Classic account: linear, inverse
     * @param symbol     false	string	Symbol name
     *                   If symbol passed, it returns data regardless of having position or not.
     *                   If symbol=null and settleCoin specified, it returns position size greater than zero.
     * @param baseCoin   false	string	Base coin. option only. Return all option positions if not passed
     * @param settleCoin false	string	Settle coin. For linear, either symbol or settleCoin is required. symbol has a higher priority
     * @param limit      false	integer	Limit for data size per page. [1, 200]. Default: 20
     * @param cursor     false	string	Cursor. Use the nextPageCursor token from the response to retrieve the next page of the result set
     * @return Response Parameters
     * Parameter	Type	Comments
     * category	string	Product type
     * list	array	Object
     * &gt; positionIdx	integer	Position idx, used to identify positions in different position modes
     * 0: One-Way Mode
     * 1: Buy side of both side mode
     * 2: Sell side of both side mode
     * &gt; riskId	integer	Risk limit ID. Note: for portfolio margin mode, this field returns 0, which means risk limit rules are invalid
     * &gt; riskLimitValue	string	Risk limit value. Note: for portfolio margin mode, this field returns 0, which means risk limit rules are invalid
     * &gt; symbol	string	Symbol name
     * &gt; side	string	Position side. Buy: long, Sell: short. Note: under one-way mode, it returns None if empty position
     * &gt; size	string	Position size
     * &gt; avgPrice	string	Average entry price
     * For USDC Perp and Futures, it indicates average entry price, and it will not be changed with 8-hour session settlement
     * &gt; positionValue	string	Position value
     * &gt; tradeMode	integer	Trade mode
     * Classic and UTA (inverse): 0: cross-margin, 1: isolated margin
     * UTA: depreciated, always 0
     * &gt; autoAddMargin	integer	Whether to add margin automatically. 0: false, 1: true. For UTA, it is meaningful only when UTA enables ISOLATED_MARGIN
     * &gt; positionStatus	String	Position status. Normal, Liq, Adl
     * &gt; leverage	string	Position leverage. Valid for contract. Note: for portfolio margin mode, this field returns "", which means leverage rules are invalid
     * &gt; markPrice	string	Last mark price
     * &gt; liqPrice	string	Position liquidation price
     * UTA (inverse) and UTA (isolated margin enabled) and Classic account: it is the real price for isolated and cross positions, and keeps "" when liqPrice &le; minPrice or liqPrice &ge; maxPrice
     * UTA (Cross margin mode): it is an estimated price for cross positions(because the unified mode controls the risk rate according to the account), and keeps "" when liqPrice &le; minPrice or liqPrice &ge; maxPrice
     * However, this field is empty for Portfolio Margin Mode, and no liquidation price will be provided
     * &gt; bustPrice	string	Bankruptcy price. Note: Unified mode returns "", no position bankruptcy price (exclude inverse trade under UTA)
     * &gt; positionIM	string	Initial margin. For portfolio margin mode, it returns ""
     * &gt; positionMM	string	Maintenance margin. For portfolio margin mode, it returns ""
     * &gt; positionBalance	string	Position margin. For portfolio margin mode, it returns ""
     * &gt; tpslMode	string	Depreciated, meaningless here, always "Full". Spot does not return this field. Option returns ""
     * &gt; takeProfit	string	Take profit price
     * &gt; stopLoss	string	Stop loss price
     * &gt; trailingStop	string	Trailing stop (The distance from market price)
     * &gt; unrealisedPnl	string	Unrealised PnL
     * &gt; cumRealisedPnl	string	Cumulative realised pnl
     * Futures and Perp: it is the all time cumulative realised  pnl
     * Option: it is the realised  pnl   when you hold that position
     * &gt; adlRankIndicator	integer	Auto-deleverage rank indicator. What is Auto-Deleveraging?
     * &gt; createdTime	string	Position created timestamp (ms)
     * &gt; updatedTime	string	Position updated timestamp (ms)
     * &gt; seq	long	Cross sequence, used to associate each fill and each position update
     * Different symbols may have the same seq, please use seq + symbol to check unique
     * Returns "-1" if the symbol has never been traded
     * Returns the seq updated by the last transaction when there are settings like leverage, risk limit
     * nextPageCursor	string	Refer to the cursor request parameter
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/v5/position/list")
    Call<Object> getPositionInfo(@Query("category") String category,
                                 @Query("symbol") String symbol,
                                 @Query("baseCoin") String baseCoin,
                                 @Query("settleCoin") String settleCoin,
                                 @Query("limit") Integer limit,
                                 @Query("cursor") String cursor);

    /**
     * Get Move Position History
     * You can query moved position data by master UID api key
     *
     * Unified account covers: USDT perpetual / USDC contract / Spot / Option
     * https://bybit-exchange.github.io/docs/v5/position/move-position-history
     * HTTP Request
     * GET /v5/position/move-history
     * @param category	false	string	Product type. linear, spot, option
     * @param symbol	false	string	Symbol name
     * @param startTime	false	number	The order creation start timestamp. The interval is 7 days
     * @param endTime	false	number	The order creation end timestamp. The interval is 7 days
     * @param status	false	string	Order status. Processing, Filled, Rejected
     * @param blockTradeId	false	string	Block trade ID
     * @param limit	false	string	Limit for data size per page. [1, 200]. Default: 20
     * @param cursor	false	string	Cursor. Use the nextPageCursor token from the response to retrieve the next page of the result set
     * @return Response Parameters
     * Parameter	Type	Comments
     * list	array	Object
     * &gt; blockTradeId	string	Block trade ID
     * &gt; category	string	Product type.Linear, spot, option
     * &gt; orderId	string	Bybit order ID
     * &gt; userId	integer	User ID
     * &gt; symbol	string	Symbol name
     * &gt; side	string	Order side from taker's perspective. Buy, Sell
     * &gt; price	string	Order price
     * &gt; qty	string	Order quantity
     * &gt; execFee	string	The fee for taker or maker in the base currency paid to the Exchange executing the block trade
     * &gt; status	string	Block trade status. Processing, Filled, Rejected
     * &gt; execId	string	The unique trade ID from the exchange
     * &gt; resultCode	integer	The result code of the order. 0 means success
     * &gt; resultMessage	string	The error message. "" when resultCode=0
     * &gt; createdAt	number	The timestamp (ms) when the order is created
     * &gt; updatedAt	number	The timestamp (ms) when the order is updated
     * &gt; rejectParty	string
     * "" means the status=Filled
     * Taker, Maker when status=Rejected
     * bybit means error is occurred on the Bybit side
     * nextPageCursor	string	Used to get the next page data
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/v5/position/move-history")
    Call<Object> getMovePositionHistory(@Query("category") String category,
                                        @Query("symbol") String symbol,
                                        @Query("startTime") Long startTime,
                                        @Query("endTime") Long endTime,
                                        @Query("status") String status,
                                        @Query("blockTradeId") String blockTradeId,
                                        @Query("limit") Integer limit,
                                        @Query("cursor") String cursor);

    /**
     * Move Position
     * You can move positions between sub-master, master-sub, or sub-sub UIDs when necessary
     *
     * Unified account covers: USDT perpetual / USDC contract / Spot / Option
     *
     * INFO
     * The endpoint can only be called by master UID api key
     * UIDs must be the same master-sub account relationship
     * The trades generated from move-position endpoint will not be displayed in the Recent Trade (Rest API and Websocket)
     * There is no trading fee
     * fromUid and toUid both should be Unified trading accounts, and they need to be one-way mode when moving the positions
     * Please note that once executed, you will get execType=MovePosition entry from Get Trade History, Get Closed Pnl, and stream from Execution.
     * HTTP Request
     * POST /v5/position/move-positions
     * https://bybit-exchange.github.io/docs/v5/position/move-position
     * @param batchMovePositionRequest fromUid	true	string	From UID
     *                                 Must be UTA
     *                                 Must be in one-way mode for Futures
     *                                 toUid	true	string	To UID
     *                                 Must be UTA
     *                                 Must be in one-way mode for Futures
     *                                 list	true	array	Object. Up to 25 legs per request
     *                                 &gt; category	true	string	Product type. linear, spot, option
     *                                 &gt; symbol	true	string	Symbol name
     *                                 &gt; price	true	string	Trade price
     *                                      linear: the price needs to be between [95% of mark price, 105% of mark price]
     *                                      spot and option: the price needs to follow the price rule from Instruments Info
     *                                 &gt; side	true	string	Trading side of fromUid
     *                                      For example, fromUid has a long position, when side=Sell, then once executed, the position of fromUid will be reduced or open a short position depending on qty input
     *                                 &gt; qty	true	string	Executed qty
     *                                  The value must satisfy the qty rule from Instruments Info, in particular, category=linear is able to input maxOrderQty * 5
     * @return Response Parameters
     * retCode    integer	Result code. 0 means request is successfully accepted
     * retMsg	string	Result message
     * result	map	Object
     * &gt; blockTradeId	string	Block trade ID
     * &gt; status	string	Status. Processing, Rejected
     * &gt; rejectParty	string
     * emtty string means initial validation is passed, please check the order status via Get Move Position History
     * Taker, Maker when status=Rejected
     * bybit means error is occurred on the Bybit side
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/v5/position/move-positions")
    Call<Object> batchMovePositions(
            @Body BatchMovePositionRequest batchMovePositionRequest);

    /**
     * Set Leverage
     * Set the leverage
     * <p>
     * Unified account covers: USDT perpetual / USDC contract / Inverse contract
     * Classic account covers: USDT perpetual / Inverse contract
     * <p>
     * https://bybit-exchange.github.io/docs/v5/position/leverage#http-request
     *
     * @param setLeverageRequest category	true	string	Product type
     *                           Unified account: linear, inverse
     *                           Classic account: linear, inverse. Please note that category is not involved with business logic
     *                           symbol	true	string	Symbol name
     *                           buyLeverage	true	string	[1, max leverage of corresponding risk limit]
     *                           Classic account: under one-way mode, buyLeverage must be the same as sellLeverage
     *                           Unified account: buyLeverage must be the same as sellLeverage all the time
     *                           sellLeverage	true	string	[1, max leverage of corresponding risk limit]
     *                           Classic account: under one-way mode, buyLeverage must be the same as sellLeverage
     *                           Unified account: buyLeverage must be the same as sellLeverage all the time
     * @return Response Parameters
     * None
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/v5/position/set-leverage")
    Call<Object> setPositionLeverage(
            @Body SetLeverageRequest setLeverageRequest);

    /**
     * Confirm New Risk Limit
     * It is only applicable when the user is marked as only reducing positions (please see the isReduceOnly field in the Get Position Info interface). After the user actively adjusts the risk level, this interface is called to try to calculate the adjusted risk level, and if it passes (retCode=0), the system will remove the position reduceOnly mark. You are recommended to call Get Position Info to check isReduceOnly field.
     * <p>
     * Unified account covers: USDT perpetual / USDC contract / Inverse contract
     * Classic account covers: USDT perpetual / Inverse contract
     * <p>
     * https://bybit-exchange.github.io/docs/v5/position/confirm-mmr
     *
     * @param confirmNewRiskLimitRequest category	true	string	Product type
     *                                   Unified account: linear, inverse
     *                                   Classic account: linear, inverse
     *                                   symbol	true	string	Symbol name
     * @return Response Parameters
     * None
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/v5/position/confirm-pending-mmr")
    Call<Object> confirmPositionRiskLimit(
            @Body ConfirmNewRiskLimitRequest confirmNewRiskLimitRequest);

    /**
     * Switch Cross/Isolated Margin
     * Select cross margin mode or isolated margin mode per symbol level
     * <p>
     * Unified account covers: Inverse contract
     * Classic account covers: USDT perpetual / Inverse contract
     * <p>
     * https://bybit-exchange.github.io/docs/v5/position/cross-isolate#http-request
     *
     * @param switchMarginRequest category	true	string	Product type
     *                            Unified account: inverse
     *                            Classic account: linear, inverse. Please note that category is not involved with business logic
     *                            symbol	true	string	Symbol name
     *                            tradeMode	true	integer	0: cross margin. 1: isolated margin
     *                            buyLeverage	true	string	The value must be equal to sellLeverage value
     *                            sellLeverage	true	string	The value must be equal to buyLeverage value
     * @return Response Parameters
     * None
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/v5/position/switch-isolated")
    Call<Object> swithMarginRequest(
            @Body SwitchMarginRequest switchMarginRequest);

    /**
     * Switch Position Mode
     * It supports to switch the position mode for USDT perpetual and Inverse futures. If you are in one-way Mode, you can only open one position on Buy or Sell side. If you are in hedge mode, you can open both Buy and Sell side positions simultaneously.
     * <p>
     * Unified account covers: USDT perpetual / Inverse Futures
     * Classic account covers: USDT perpetual / Inverse Futures
     * <p>
     * TIP
     * Priority for configuration to take effect: symbol &gt; coin &gt; system default
     * System default: one-way mode
     * If the request is by coin (settleCoin), then all symbols based on this setteCoin that do not have position and open order will be batch switched, and new listed symbol based on this settleCoin will be the same mode you set.
     * Example
     * System default	coin	symbol
     * Initial setting	one-way	never configured	never configured
     * Result	All USDT perpetual trading pairs are one-way mode
     * Change 1	-	-	Set BTCUSDT to hedge-mode
     * Result	BTCUSDT becomes hedge-mode, and all other symbols keep one-way mode
     * list new symbol ETHUSDT	ETHUSDT is one-way mode （inherit default rules）
     * Change 2	-	Set USDT to hedge-mode	-
     * Result	All current trading pairs with no positions or orders are hedge-mode, and no adjustments will be made for trading pairs with positions and orders
     * list new symbol SOLUSDT	SOLUSDT is hedge-mode (Inherit coin rule)
     * Change 3	-	-	Set ASXUSDT to one-mode
     * Take effect result	AXSUSDT is one-way mode, other trading pairs have no change
     * list new symbol BITUSDT	BITUSDT is hedge-mode (Inherit coin rule)
     * The position-switch ability for each contract
     * Classic account	                Unified account
     * USDT perpetual	  Support one-way and  hedge-mode	    Support one-way and  hedge-mode
     * USDC perpetual	  Support one-way only	            Support one-way only
     * Inverse perpetua   Support one-way only	            Support one-way only
     * Inverse future	  Support one-way and  hedge-mode	    Support one-way and  hedge-mode
     * <p>
     * https://bybit-exchange.github.io/docs/v5/position/position-mode#http-request
     *
     * @param switchPositionModeRequest category	true	string	Product type
     *                                  Unified account: linear, USDT Perp; inverse, Inverse Futures
     *                                  Classic account: linear, USDT Perp; inverse, Inverse Futures. Please note that category is not involved with business logic
     *                                  symbol	false	string	Symbol name. Either symbol or coin is required. symbol has a higher priority
     *                                  coin	false	string	Coin
     *                                  mode	true	integer	Position mode. 0: Merged Single. 3: Both Sides
     * @return Response Parameters
     * None
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/v5/position/switch-mode")
    Call<Object> switchPositionMode(
            @Body SwitchPositionModeRequest switchPositionModeRequest);

    /**
     * Set TP/SL Mode
     * TIP
     * To some extent, this endpoint is depreciated because now tpsl is based on order level. This API was used for position level change before.
     * <p>
     * However, you still can use it to set an implicit tpsl mode for a certain symbol because when you don't pass "tpslMode" in the place order or trading stop request, system will get the tpslMode by the default setting.
     * <p>
     * Set TP/SL mode to Full or Partial
     * <p>
     * Unified account covers: USDT perpetual / Inverse contract
     * Classic account covers: USDT perpetual / Inverse contract
     * <p>
     * INFO
     * For partial TP/SL mode, you can set the TP/SL size smaller than position size.
     * <p>
     * https://bybit-exchange.github.io/docs/v5/position/tpsl-mode#http-request
     *
     * @param setTpSlModeRequest category	true	string	Product type
     *                           Unified account: linear, inverse
     *                           Classic account: linear, inverse. Please note that category is not involved with business logic
     *                           symbol	true	string	Symbol name
     *                           tpSlMode	true	string	TP/SL mode. Full,Partial
     * @return Response Parameters
     * Parameter	Type	Comments
     * tpSlMode	string	Full,Partial
     */
    @Deprecated
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/v5/position/set-tpsl-mode")
    Call<Object> setTpslMode(@Body SetTpSlModeRequest setTpSlModeRequest);

    /**
     * Set Risk Limit
     * The risk limit will limit the maximum position value you can hold under different margin requirements. If you want to hold a bigger position size, you need more margin. This interface can set the risk limit of a single position. If the order exceeds the current risk limit when placing an order, it will be rejected. Click here to learn more about risk limit.
     * <p>
     * Unified account covers: USDT perpetual / USDC contract / Inverse contract
     * Classic account covers: USDT perpetual / Inverse contract
     * <p>
     * TIP
     * Set the risk limit of the position. You can get risk limit information for each symbol here.
     * <p>
     * https://bybit-exchange.github.io/docs/v5/position/set-risk-limit#http-request
     *
     * @param setRiskLimitRequest category	true	string	Product type
     *                            Unified account: linear, inverse
     *                            Classic account: linear, inverse. Please note that category is not involved with business logic
     *                            symbol	true	string	Symbol name
     *                            riskId	true	integer	Risk limit ID
     *                            positionIdx	false	integer	Used to identify positions in different position modes. For hedge mode, it is required
     *                            0: one-way mode
     *                            1: hedge-mode Buy side
     *                            2: hedge-mode Sell side
     * @return Response Parameters
     * Parameter	Type	Comments
     * category	string	Product type
     * riskId	integer	Risk limit ID
     * riskLimitValue	string	The position limit value corresponding to this risk ID
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/v5/position/set-risk-limit")
    @Deprecated
    Call<Object> setRiskLimit(
            @Body SetRiskLimitRequest setRiskLimitRequest);

    /**
     * Set Trading Stop
     * Set the take profit, stop loss or trailing stop for the position.
     * <p>
     * Unified account covers: USDT perpetual / USDC contract / Inverse contract
     * Classic account covers: USDT perpetual / Inverse contract
     * <p>
     * TIP
     * Passing these parameters will create conditional orders by the system internally. The system will cancel these orders if the position is closed, and adjust the qty according to the size of the open position.
     * <p>
     * INFO
     * New version of TP/SL function supports both holding entire position TP/SL orders and holding partial position TP/SL orders.
     * <p>
     * Full position TP/SL orders: This API can be used to modify the parameters of existing TP/SL orders.
     * Partial position TP/SL orders: This API can only add partial position TP/SL orders.
     * NOTE
     * Under the new version of Tp/SL function, when calling this API to perform one-sided take profit or stop loss modification on existing TP/SL orders on the holding position, it will cause the paired tp/sl orders to lose binding relationship. This means that when calling the cancel API through the tp/sl order ID, it will only cancel the corresponding one-sided take profit or stop loss order ID.
     * <p>
     * https://bybit-exchange.github.io/docs/v5/position/trading-stop#http-request
     *
     * @param tradingStopRequest category	true	string	Product type
     *                           Unified account: linear, inverse
     *                           Classic account: linear, inverse. Please note that category is not involved with business logic
     *                           symbol	true	string	Symbol name
     *                           takeProfit	false	string	Cannot be less than 0, 0 means cancel TP
     *                           stopLoss	false	string	Cannot be less than 0, 0 means cancel SL
     *                           trailingStop	false	string	Trailing stop by price distance. Cannot be less than 0, 0 means cancel TS
     *                           tpTriggerBy	false	string	Take profit trigger price type
     *                           slTriggerBy	false	string	Stop loss trigger price type
     *                           activePrice	false	string	Trailing stop trigger price. Trailing stop will be triggered when this price is reached only
     *                           tpslMode	false	string	TP/SL mode. Full: entire position TP/SL, Partial: partial position TP/SL. As each contract has an initial full TP/SL mode, if it has been modified before, it may be partial. Therefore, if not provided, the system will automatically retrieve the current TP/SL mode configuration for the contract.
     *                           tpSize	false	string	Take profit size. Valid in TP/SL partial mode. Note: the value of tpSize and slSize must equal
     *                           slSize	false	string	Stop loss size. Valid in TP/SL partial mode. Note: the value of tpSize and slSize must equal
     *                           tpLimitPrice	false	string	The limit order price when take profit price is triggered. Only works when tpslMode=Partial and tpOrderType=Limit
     *                           slLimitPrice	false	string	The limit order price when stop loss price is triggered. Only works when tpslMode=Partial and slOrderType=Limit
     *                           tpOrderType	false	string	The order type when take profit is triggered. Market(default), Limit. For tpslMode=Full, it only supports tpOrderType=Market
     *                           slOrderType	false	string	The order type when stop loss is triggered. Market(default), Limit. For tpslMode=Full, it only supports slOrderType=Market
     *                           positionIdx	true	integer	Used to identify positions in different position modes.
     *                           0: one-way mode
     *                           1: hedge-mode Buy side
     *                           2: hedge-mode Sell side
     * @return Response Parameters
     * None
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/v5/position/trading-stop")
    Call<Object> setTradingStop(
            @Body TradingStopRequest tradingStopRequest);

    /**
     * Set Auto Add Margin
     * Turn on/off auto-add-margin for isolated margin position
     * <p>
     * Unified account covers: USDT perpetual / USDC perpetual / USDC futures / Inverse contract
     * Classic account covers: USDT perpetual / Inverse contract
     * <p>
     * https://bybit-exchange.github.io/docs/v5/position/auto-add-margin#http-request
     *
     * @param setAutoAddMarginRequest category	true	string	Product type
     *                                Unified account: linear, inverse
     *                                Classic account: linear, inverse
     *                                symbol	true	string	Symbol name
     *                                autoAddMargin	true	integer	Turn on/off. 0: off. 1: on
     *                                positionIdx	false	integer	Used to identify positions in different position modes. For hedge mode position, this param is required
     *                                0: one-way mode
     *                                1: hedge-mode Buy side
     *                                2: hedge-mode Sell side
     * @return Response Parameters
     * None
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/v5/position/set-auto-add-margin")
    Call<Object> setAutoAddMargin(
            @Body SetAutoAddMarginRequest setAutoAddMarginRequest);

    /**
     * Add Or Reduce Margin
     * Manually add or reduce margin for isolated margin position
     * <p>
     * Unified account covers: USDT perpetual / USDC perpetual / USDC futures / Inverse contract
     * Classic account covers: USDT perpetual / Inverse contract
     * <p>
     * https://bybit-exchange.github.io/docs/v5/position/manual-add-margin#http-request
     *
     * @param modifyMarginRequest category	true	string	Product type
     *                            Unified account: linear, inverse
     *                            Classic account: linear, inverse
     *                            symbol	true	string	Symbol name
     *                            margin	true	string	Add or reduce. To add, then 10; To reduce, then -10. Support up to 4 decimal
     *                            positionIdx	false	integer	Used to identify positions in different position modes. For hedge mode position, this param is required
     *                            0: one-way mode
     *                            1: hedge-mode Buy side
     *                            2: hedge-mode Sell side
     * @return Response Parameters
     * Parameter	Type	Comments
     * category	string	Product type
     * symbol	string	Symbol name
     * positionIdx	integer	Position idx, used to identify positions in different position modes
     * 0: One-Way Mode
     * 1: Buy side of both side mode
     * 2: Sell side of both side mode
     * riskId	integer	Risk limit ID
     * riskLimitValue	string	Risk limit value
     * size	string	Position size
     * avgPrice	string	Average entry price
     * liqPrice	string	Liquidation price
     * bustPrice	string	Bankruptcy price
     * markPrice	string	Last mark price
     * positionValue	string	Position value
     * leverage	string	Position leverage
     * autoAddMargin	integer	Whether to add margin automatically. 0: false, 1: true
     * positionStatus	String	Position status. Normal, Liq, Adl
     * positionIM	string	Initial margin
     * positionMM	string	Maintenance margin
     * takeProfit	string	Take profit price
     * stopLoss	string	Stop loss price
     * trailingStop	string	Trailing stop (The distance from market price)
     * unrealisedPnl	string	Unrealised PnL
     * cumRealisedPnl	string	Cumulative realised pnl
     * createdTime	string	Position created timestamp (ms)
     * updatedTime	string	Position updated timestamp (ms)
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/v5/position/add-margin")
    Call<Object> modifyPositionMargin(
            @Body ModifyMarginRequest modifyMarginRequest);

    /**
     * Get Execution
     * Query users' execution records, sorted by execTime in descending order. However, for Classic spot, they are sorted by execId in descending order.
     * <p>
     * Unified account covers: Spot / USDT perpetual / USDC contract / Inverse contract / Options
     * Classic account covers: Spot / USDT perpetual / Inverse contract
     * <p>
     * TIP
     * Response items will have sorting issues When 'execTime' is the same. This issue is currently being optimized and will be released at the end of October. If you want to receive real-time execution information, Use the websocket stream (recommended).
     * You may have multiple executions in a single order.
     * You can query by symbol, baseCoin, orderId and orderLinkId, and if you pass multiple params, the system will process them according to this priority: orderId &gt; orderLinkId &gt; symbol &gt; baseCoin.
     * <p>
     * https://bybit-exchange.github.io/docs/v5/position/execution
     *
     * @param category    true	string	Product type
     *                    Unified account: spot, linear, inverse, option
     *                    Classic account: spot, linear, inverse
     * @param symbol      false	string	Symbol name
     * @param orderId     false	string	Order ID
     * @param orderLinkId false	string	User customised order ID. Classic account does not support this param
     * @param baseCoin    false	string	Base coin. Unified account - inverse and Classic account do not support this param
     * @param startTime   false	integer	The start timestamp (ms)
     * @param endTime     false	integer	The end timestamp (ms)
     * @param execType    false	string	Execution type. Classic spot is not supported
     * @param limit       false	integer	Limit for data size per page. [1, 100]. Default: 50
     * @param cursor      false	string	Cursor. Use the nextPageCursor token from the response to retrieve the next page of the result set
     * @return Response Parameters
     * Parameter	Type	Comments
     * category	string	Product type
     * list	array	Object
     * &gt; symbol	string	Symbol name
     * &gt; orderId	string	Order ID
     * &gt; orderLinkId	string	User customized order ID. Classic spot is not supported
     * &gt; side	string	Side. Buy,Sell
     * &gt; orderPrice	string	Order price
     * &gt; orderQty	string	Order qty
     * &gt; leavesQty	string	The remaining qty not executed. Classic spot is not supported
     * &gt; orderType	string	Order type. Market,Limit
     * &gt; stopOrderType	string	Stop order type. If the order is not stop order, any type is not returned. Classic spot is not supported
     * &gt; execFee	string	Executed trading fee. You can get spot fee currency instruction here
     * &gt; execId	string	Execution ID
     * &gt; execPrice	string	Execution price
     * &gt; execQty	string	Execution qty
     * &gt; execType	string	Executed type. Classic spot is not supported
     * &gt; execValue	string	Executed order value. Classic spot is not supported
     * &gt; execTime	string	Executed timestamp（ms）
     * &gt; isMaker	boolean	Is maker order. true: maker, false: taker
     * &gt; feeRate	string	Trading fee rate. Classic spot is not supported
     * &gt; tradeIv	string	Implied volatility. Valid for option
     * &gt; markIv	string	Implied volatility of mark price. Valid for option
     * &gt; markPrice	string	The mark price of the symbol when executing. Classic spot is not supported
     * &gt; indexPrice	string	The index price of the symbol when executing. Valid for option only
     * &gt; underlyingPrice	string	The underlying price of the symbol when executing. Valid for option
     * &gt; blockTradeId	string	Paradigm block trade ID
     * &gt; closedSize	string	Closed position size
     * &gt; seq	long	Cross sequence, used to associate each fill and each position update
     * The seq will be the same when conclude multiple transactions at the same time
     * Different symbols may have the same seq, please use seq + symbol to check unique
     * Classic account Spot trade does not have this field
     * nextPageCursor	string	Refer to the cursor request parameter
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/v5/execution/list")
    @Deprecated
    Call<Object> getExecutionList(@Query("category") String category,
                                  @Query("symbol") String symbol,
                                  @Query("orderId") String orderId,
                                  @Query("orderLinkId") String orderLinkId,
                                  @Query("baseCoin") String baseCoin,
                                  @Query("startTime") Long startTime,
                                  @Query("endTime") Long endTime,
                                  @Query("execType") String execType,
                                  @Query("limit") Integer limit,
                                  @Query("cursor") String cursor);

    /**
     * Get Closed PnL
     * Query user's closed profit and loss records. The results are sorted by createdTime in descending order.
     * <p>
     * Unified account covers: USDT perpetual / USDC contract / Inverse contract
     * Classic account covers: USDT perpetual / Inverse contract
     * <p>
     * https://bybit-exchange.github.io/docs/v5/position/close-pnl
     *
     * @param category  true	string	Product type
     *                  Unified account: linear, inverse
     *                  Classic account: linear, inverse. Please note that category is not involved with business logic
     * @param symbol    false	string	Symbol name
     * @param startTime false	integer	The start timestamp (ms)
     * @param endTime   false	integer	The end timestamp (ms)
     * @param limit     false	integer	Limit for data size per page. [1, 100]. Default: 50
     * @param cursor    false	string	Cursor. Use the nextPageCursor token from the response to retrieve the next page of the result set
     * @return Response Parameters
     * Parameter	Type	Comments
     * category	string	Product type
     * list	array	Object
     * &gt; symbol	string	Symbol name
     * &gt; orderId	string	Order ID
     * &gt; side	string	Buy, Sell
     * &gt; qty	string	Order qty
     * &gt; orderPrice	string	Order price
     * &gt; orderType	string	Order type. Market,Limit
     * &gt; execType	string	Exec type. Trade, BustTrade, SessionSettlePnL, Settle
     * &gt; closedSize	string	Closed size
     * &gt; cumEntryValue	string	Cumulated Position value
     * &gt; avgEntryPrice	string	Average entry price
     * &gt; cumExitValue	string	Cumulated exit position value
     * &gt; avgExitPrice	string	Average exit price
     * &gt; closedPnl	string	Closed PnL
     * &gt; fillCount	string	The number of fills in a single order
     * &gt; leverage	string	leverage
     * &gt; createdTime	string	The created time (ms)
     * &gt; updatedTime	string	The updated time (ms)
     * nextPageCursor	string	Refer to the cursor request parameter
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/v5/position/closed-pnl")
    Call<Object> getClosePnlList(@Query("category") String category,
                                 @Query("symbol") String symbol,
                                 @Query("startTime") Long startTime,
                                 @Query("endTime") Long endTime,
                                 @Query("limit") Integer limit,
                                 @Query("cursor") String cursor);

    // Pre upgrade data endpoints

    /**
     * Get Pre-upgrade Closed PnL
     * Query user's closed profit and loss records from before you upgraded the account to a Unified account. The results are sorted by createdTime in descending order.
     * <p>
     * For now, it only supports to query USDT perpetual, Inverse perpetual and futures.
     * <p>
     * https://bybit-exchange.github.io/docs/v5/pre-upgrade/close-pnl
     *
     * @param category  true	string	Product type linear, inverse
     * @param symbol    true	string	Symbol name
     * @param startTime false	integer	The start timestamp (ms)
     * @param endTime   false	integer	The end timestamp (ms)
     * @param limit     false	integer	Limit for data size per page. [1, 100]. Default: 50
     * @param cursor    false	string	Cursor. Use the nextPageCursor token from the response to retrieve the next page of the result set
     * @return Response Parameters
     * Parameter	Type	Comments
     * category	string	Product type
     * list	array	Object
     * &gt; symbol	string	Symbol name
     * &gt; orderId	string	Order ID
     * &gt; side	string	Buy, Side
     * &gt; qty	string	Order qty
     * &gt; orderPrice	string	Order price
     * &gt; orderType	string	Order type. Market,Limit
     * &gt; execType	string	Exec type. Trade, BustTrade, SessionSettlePnL, Settle
     * &gt; closedSize	string	Closed size
     * &gt; cumEntryValue	string	Cumulated Position value
     * &gt; avgEntryPrice	string	Average entry price
     * &gt; cumExitValue	string	Cumulated exit position value
     * &gt; avgExitPrice	string	Average exit price
     * &gt; closedPnl	string	Closed PnL
     * &gt; fillCount	string	The number of fills in a single order
     * &gt; leverage	string	leverage
     * &gt; createdTime	string	The created time (ms)
     * &gt; updatedTime	string	The updated time (ms)
     * nextPageCursor	string	Refer to the cursor request parameter
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/v5/pre-upgrade/position/closed-pnl")
    Call<Object> getPreUpgradeClosePnl(@Query("category") String category,
                                       @Query("symbol") String symbol,
                                       @Query("startTime") Long startTime,
                                       @Query("endTime") Long endTime,
                                       @Query("limit") Integer limit,
                                       @Query("cursor") String cursor);

    /**
     * Get Pre-upgrade Option Delivery Record
     * Query delivery records of Option before you upgraded the account to a Unified account, sorted by deliveryTime in descending order
     * <p>
     * https://bybit-exchange.github.io/docs/v5/pre-upgrade/delivery
     *
     * @param category true	string	Product type. option
     * @param symbol   false	string	Symbol name
     * @param expDate  false	string	Expiry date. 25MAR22. Default: return all
     * @param limit    false	integer	Limit for data size per page. [1, 50]. Default: 20
     * @param cursor   false	string	Cursor. Used for pagination
     * @return Response Parameters
     * Parameter	Type	Comments
     * category	string	Product type
     * list	array	Object
     * &gt; deliveryTime	number	Delivery time (ms)
     * &gt; symbol	string	Symbol name
     * &gt; side	string	Buy,Sell
     * &gt; position	string	Executed size
     * &gt; deliveryPrice	string	Delivery price
     * &gt; strike	string	Exercise price
     * &gt; fee	string	Trading fee
     * &gt; deliveryRpl	string	Realized PnL of the delivery
     * nextPageCursor	string	Cursor. Used for pagination
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/v5/pre-upgrade/asset/delivery-record")
    Call<Object> getPreUpgradeOptionDelivery(@Query("category") String category,
                                             @Query("symbol") String symbol,
                                             @Query("expDate") String expDate,
                                             @Query("limit") Integer limit,
                                             @Query("cursor") String cursor);

    /**
     * Get Pre-upgrade Order History
     * After the account is upgraded to a Unified account, you can get the orders which occurred before the upgrade.
     * <p>
     * INFO
     * can get all status in 7 days
     * can only get filled orders beyond 7 days
     * <p>
     * https://bybit-exchange.github.io/docs/v5/pre-upgrade/order-list
     *
     * @param category    true	string	Product type. linear, inverse, option
     * @param symbol      false	string	Symbol name.
     *                    If not passed, return settleCoin=USDT by default
     *                    To get USDC perp, please pass symbol
     * @param baseCoin    false	string	Base coin. Used for option query
     * @param orderId     false	string	Order ID
     * @param orderLinkId false	string	User customised order ID
     * @param orderFilter false	string	Order: active order, StopOrder: conditional order
     * @param orderStatus false	string	Order status. Not supported for spot category
     * @param startTime   false	integer	The start timestamp (ms)
     *                    startTime and endTime must be passed together
     *                    If not passed, query the past 7 days data by default
     * @param endTime     false	integer	The end timestamp (ms)
     * @param limit       false	integer	Limit for data size per page. [1, 50]. Default: 20
     * @param cursor      false	string	Cursor. Use the nextPageCursor token from the response to retrieve the next page of the result set
     * @return Response Parameters
     * Parameter	Type	Comments
     * category	string	Product type
     * list	array	Object
     * &gt; orderId	string	Order ID
     * &gt; orderLinkId	string	User customised order ID
     * &gt; blockTradeId	string	Block trade ID
     * &gt; symbol	string	Symbol name
     * &gt; price	string	Order price
     * &gt; qty	string	Order qty
     * &gt; side	string	Side. Buy,Sell
     * &gt; isLeverage	string	Useless field for those orders before upgraded
     * &gt; positionIdx	integer	Position index. Used to identify positions in different position modes
     * &gt; orderStatus	string	Order status
     * &gt; cancelType	string	Cancel type
     * &gt; rejectReason	string	Reject reason
     * &gt; avgPrice	string	Average filled price. If unfilled, it is ""
     * &gt; leavesQty	string	The remaining qty not executed
     * &gt; leavesValue	string	The estimated value not executed
     * &gt; cumExecQty	string	Cumulative executed order qty
     * &gt; cumExecValue	string	Cumulative executed order value
     * &gt; cumExecFee	string	Cumulative executed trading fee
     * &gt; timeInForce	string	Time in force
     * &gt; orderType	string	Order type. Market,Limit
     * &gt; stopOrderType	string	Stop order type
     * &gt; orderIv	string	Implied volatility
     * &gt; triggerPrice	string	Trigger price. If stopOrderType=TrailingStop, it is activate price. Otherwise, it is trigger price
     * &gt; takeProfit	string	Take profit price
     * &gt; stopLoss	string	Stop loss price
     * &gt; tpTriggerBy	string	The price type to trigger take profit
     * &gt; slTriggerBy	string	The price type to trigger stop loss
     * &gt; triggerDirection	integer	Trigger direction. 1: rise, 2: fall
     * &gt; triggerBy	string	The price type of trigger price
     * &gt; lastPriceOnCreated	string	Last price when place the order
     * &gt; reduceOnly	boolean	Reduce only. true means reduce position size
     * &gt; closeOnTrigger	boolean	Close on trigger. What is a close on trigger order?
     * &gt; placeType	string	Place type, option used. iv, price
     * &gt; smpType	string	SMP execution type
     * &gt; smpGroup	integer	Smp group ID. If the UID has no group, it is 0 by default
     * &gt; smpOrderId	string	The counterparty's orderID which triggers this SMP execution
     * &gt; createdTime	string	Order created timestamp (ms)
     * &gt; updatedTime	string	Order updated timestamp (ms)
     * nextPageCursor	string	Refer to the cursor request parameter
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/v5/pre-upgrade/order/history")
    Call<Object> getPreUpgradeOrderHistory(@Query("category") String category,
                                           @Query("symbol") String symbol,
                                           @Query("baseCoin") String baseCoin,
                                           @Query("orderId") String orderId,
                                           @Query("orderLinkId") String orderLinkId,
                                           @Query("orderFilter") String orderFilter,
                                           @Query("orderStatus") String orderStatus,
                                           @Query("startTime") Long startTime,
                                           @Query("endTime") Long endTime,
                                           @Query("limit") Integer limit,
                                           @Query("cursor") String cursor);

    /**
     * Get Pre-upgrade Trade History
     * Get users' execution records which occurred before you upgraded the account to a Unified account, sorted by execTime in descending order
     * <p>
     * For now, it supports to query USDT perpetual, USDC perpetual, Inverse perpetual and futures, Option.
     * <p>
     * TIP
     * Response items will have sorting issues When 'execTime' is the same. This issue is currently being optimized and will be released at the end of October. If you want to receive real-time execution information, Use the websocket stream (recommended).
     * You may have multiple executions in a single order.
     * You can query by symbol, baseCoin, orderId and orderLinkId, and if you pass multiple params, the system will process them according to this priority: orderId &gt; orderLinkId &gt; symbol &gt; baseCoin.
     * <p>
     * https://bybit-exchange.github.io/docs/v5/pre-upgrade/execution
     *
     * @param category    true	string	Product type linear, inverse, option
     * @param symbol      false	string	Symbol name
     * @param orderId     false	string	Order ID
     * @param orderLinkId false	string	User customised order ID
     * @param baseCoin    false	string	Base coin. Used for option
     * @param startTime   false	integer	The start timestamp (ms)
     * @param endTime     false	integer	The end timestamp (ms)
     * @param execType    false	string	Execution type
     * @param limit       false	integer	Limit for data size per page. [1, 100]. Default: 50
     * @param cursor      false	string	Cursor. Use the nextPageCursor token from the response to retrieve the next page of the result set
     * @return Response Parameters
     * Parameter	Type	Comments
     * category	string	Product type
     * list	array	Object
     * &gt; symbol	string	Symbol name
     * &gt; orderId	string	Order ID
     * &gt; orderLinkId	string	User customized order ID
     * &gt; side	string	Side. Buy,Sell
     * &gt; orderPrice	string	Order price
     * &gt; orderQty	string	Order qty
     * &gt; leavesQty	string	The remaining qty not executed
     * &gt; orderType	string	Order type. Market,Limit
     * &gt; stopOrderType	string	Stop order type. If the order is not stop order, any type is not returned
     * &gt; execFee	string	Executed trading fee
     * &gt; execId	string	Execution ID
     * &gt; execPrice	string	Execution price
     * &gt; execQty	string	Execution qty
     * &gt; execType	string	Executed type
     * &gt; execValue	string	Executed order value
     * &gt; execTime	string	Executed timestamp（ms）
     * &gt; isMaker	boolean	Is maker order. true: maker, false: taker
     * &gt; feeRate	string	Trading fee rate
     * &gt; tradeIv	string	Implied volatility
     * &gt; markIv	string	Implied volatility of mark price
     * &gt; markPrice	string	The mark price of the symbol when executing
     * &gt; indexPrice	string	The index price of the symbol when executing
     * &gt; underlyingPrice	string	The underlying price of the symbol when executing
     * &gt; blockTradeId	string	Paradigm block trade ID
     * &gt; closedSize	string	Closed position size
     * nextPageCursor	string	Refer to the cursor request parameter
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/v5/pre-upgrade/execution/list")
    Call<Object> getPreUpgradeTradeHistory(@Query("category") String category,
                                           @Query("symbol") String symbol,
                                           @Query("orderId") String orderId,
                                           @Query("orderLinkId") String orderLinkId,
                                           @Query("baseCoin") String baseCoin,
                                           @Query("startTime") Long startTime,
                                           @Query("endTime") Long endTime,
                                           @Query("execType") String execType,
                                           @Query("limit") Integer limit,
                                           @Query("cursor") String cursor);

    /**
     * Get Pre-upgrade Transaction Log
     * Query transaction logs which occurred in the USDC Derivatives wallet before the account was upgraded to a Unified account.
     * <p>
     * You can get USDC Perpetual, Option records.
     * <p>
     * https://bybit-exchange.github.io/docs/v5/pre-upgrade/transaction-log
     *
     * @param category  false	string	Product type. linear,option
     * @param baseCoin  false	string	BaseCoin. e.g., BTC of BTCPERP
     * @param type      false	string	Types of transaction logs
     * @param startTime false	integer	The start timestamp (ms) of creation
     * @param endTime   false	integer	The end timestamp (ms) of creation
     * @param limit     false	integer	Limit for data size per page. [1, 50]. Default: 20
     * @param cursor    false	string	Cursor. Used for pagination
     * @return Response Parameters
     * Parameter	Type	Comments
     * list	array	Object
     * &gt; symbol	string	Symbol name
     * &gt; category	string	Product type
     * &gt; side	string	Side. Buy,Sell,None
     * &gt; transactionTime	string	Transaction timestamp (ms)
     * &gt; type	string	Type
     * &gt; qty	string	Quantity
     * &gt; size	string	Size
     * &gt; currency	string	USDC USDT BTC ETH
     * &gt; tradePrice	string	Trade price
     * &gt; funding	string	Funding fee
     * Positive value means receiving funding fee
     * Negative value means deducting funding fee
     * &gt; fee	string	Trading fee
     * Positive fee value means expense
     * Negative fee value means rebates
     * &gt; cashFlow	string	Cash flow
     * &gt; change	string	Change
     * &gt; cashBalance	string	Cash balance
     * &gt; feeRate	string
     * When type=TRADE, then it is trading fee rate
     * When type=SETTLEMENT, it means funding fee rate. For side=Buy, feeRate=market fee rate; For side=Sell, feeRate= - market fee rate
     * &gt; bonusChange	string	The change of bonus
     * &gt; tradeId	string	Trade ID
     * &gt; orderId	string	Order ID
     * &gt; orderLinkId	string	User customised order ID
     * nextPageCursor	string	Cursor. Used for pagination
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/v5/pre-upgrade/account/transaction-log")
    Call<Object> getPreUpgradeTransaction(@Query("category") String category,
                                          @Query("baseCoin") String baseCoin,
                                          @Query("type") String type,
                                          @Query("startTime") Long startTime,
                                          @Query("endTime") Long endTime,
                                          @Query("limit") Integer limit,
                                          @Query("cursor") String cursor);

    /**
     * Get Pre-upgrade USDC Session Settlement
     * Query session settlement records of USDC perpetual before you upgrade the account to Unified account.
     * <p>
     * https://bybit-exchange.github.io/docs/v5/pre-upgrade/settlement
     *
     * @param category true	string	Product type. linear
     * @param symbol   false	string	Symbol name
     * @param limit    false	integer	Limit for data size per page. [1, 50]. Default: 20
     * @param cursor   false	string	Cursor. Used for pagination
     * @return Response Parameters
     * Parameter	Type	Comments
     * category	string	Product type
     * list	array	Object
     * &gt; symbol	string	Symbol name
     * &gt; side	string	Buy,Sell
     * &gt; size	string	Position size
     * &gt; sessionAvgPrice	string	Settlement price
     * &gt; markPrice	string	Mark price
     * &gt; realisedPnl	string	Realised PnL
     * &gt; createdTime	string	Created time (ms)
     * nextPageCursor	string	Cursor. Used for pagination
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/v5/pre-upgrade/asset/settlement-record")
    Call<Object> getPreUpgradeUsdcSettlement(@Query("category") String category,
                                             @Query("symbol") String symbol,
                                             @Query("limit") Integer limit,
                                             @Query("cursor") String cursor);

    // Account Data endpoints

    /**
     * Get Wallet Balance
     * Obtain wallet balance, query asset information of each currency, and account risk rate information. By default, currency information with assets or liabilities of 0 is not returned.
     * <p>
     * TIP
     * The trading of UTA inverse contracts is conducted through the CONTRACT wallet.
     * To get Funding wallet balance, please go to this endpoint
     * <p>
     * https://bybit-exchange.github.io/docs/v5/account/wallet-balance
     *
     * @param accountType true	string	Account type
     *                    Unified account: UNIFIED (trade spot/linear/options), CONTRACT(trade inverse)
     *                    Classic account: CONTRACT, SPOT
     * @param coin        false	string	Coin name
     *                    If not passed, it returns non-zero asset info
     *                    You can pass multiple coins to query, separated by comma. USDT,USDC
     * @return Response Parameters
     * Parameter	Type	Comments
     * list	array	Object
     * &gt; accountType	string	Account type
     * &gt; accountLTV	string	Account LTV: account total borrowed size / (account total equity + account total borrowed size). In non-unified mode and unified (inverse) and unified (isolated_margin), the field will be returned as an empty string.
     * &gt; accountIMRate	string	Initial Margin Rate: Account Total Initial Margin Base Coin / Account Margin Balance Base Coin. In non-unified mode and unified (inverse) and unified (isolated_margin), the field will be returned as an empty string.
     * &gt; accountMMRate	string	Maintenance Margin Rate: Account Total Maintenance Margin Base Coin / Account Margin Balance Base Coin. In non-unified mode and unified (inverse) and unified (isolated_margin), the field will be returned as an empty string.
     * &gt; totalEquity	string	Equity of account converted to usd：Account Margin Balance Base Coin + Account Option Value Base Coin. In non-unified mode and unified (inverse), the field will be returned as an empty string.
     * &gt; totalWalletBalance	string	Wallet Balance of account converted to usd：∑ Asset Wallet Balance By USD value of each asset。In non-unified mode and unified (inverse) and unified (isolated_margin), the field will be returned as an empty string.
     * &gt; totalMarginBalance	string	Margin Balance of account converted to usd：totalWalletBalance + totalPerpUPL. In non-unified mode and unified (inverse) and unified (isolated_margin), the field will be returned as an empty string.
     * &gt; totalAvailableBalance	string	Available Balance of account converted to usd：Regular mode：totalMarginBalance - totalInitialMargin. In non-unified mode and unified (inverse) and unified (isolated_margin), the field will be returned as an empty string.
     * &gt; totalPerpUPL	string	Unrealised  pnl   of Perpetuals and USDC Futures of account converted to usd：∑ Each Perp and USDC Futures upl by base coin. In non-unified mode and unified (inverse), the field will be returned as an empty string.
     * &gt; totalInitialMargin	string	Initial Margin of account converted to usd：∑ Asset Total Initial Margin Base Coin. In non-unified mode and unified (inverse) and unified (isolated_margin), the field will be returned as an empty string.
     * &gt; totalMaintenanceMargin	string	Maintenance Margin of account converted to usd: ∑ Asset Total Maintenance Margin Base Coin. In non-unified mode and unified (inverse) and unified (isolated_margin), the field will be returned as an empty string.
     * &gt; coin	array	Object
     * &gt; &gt; coin	string	Coin name, such as BTC, ETH, USDT, USDC
     * &gt; &gt; equity	string	Equity of current coin
     * &gt; &gt; usdValue	string	USD value of current coin. If this coin cannot be collateral, then it is 0
     * &gt; &gt; walletBalance	string	Wallet balance of current coin
     * &gt; &gt; free	string	Available balance for Spot wallet. This is a unique field for Classic SPOT
     * &gt; &gt; locked	string	Locked balance due to the Spot open order
     * &gt; &gt; borrowAmount	string	Borrow amount of current coin
     * &gt; &gt; availableToBorrow	string	Depreciated field, always return "" due to feature of main-sub UID sharing borrow quota. Please refer to availableToBorrow in the Get Collateral Info
     * &gt; &gt; availableToWithdraw	string	Available amount to withdraw of current coin
     * &gt; &gt; accruedInterest	string	Accrued interest
     * &gt; &gt; totalOrderIM	string	Pre-occupied margin for order. For portfolio margin mode, it returns ""
     * &gt; &gt; totalPositionIM	string	Sum of initial margin of all positions + Pre-occupied liquidation fee. For portfolio margin mode, it returns ""
     * &gt; &gt; totalPositionMM	string	Sum of maintenance margin for all positions. For portfolio margin mode, it returns ""
     * &gt; &gt; unrealisedPnl	string	Unrealised  pnl
     * &gt; &gt; cumRealisedPnl	string	Cumulative Realised  pnl
     * &gt; &gt; bonus	string	Bonus. This is a unique field for UNIFIED account
     * &gt; &gt; collateralSwitch	boolean	Whether it can be used as a margin collateral currency (platform)
     * When marginCollateral=false, then collateralSwitch is meaningless
     * This is a unique field for UNIFIED account
     * &gt; &gt; marginCollateral	boolean	Whether the collateral is turned on by user (user)
     * When marginCollateral=true, then collateralSwitch is meaningful
     * This is a unique field for UNIFIED account
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/v5/account/wallet-balance")
    Call<Object> getWalletBalance(@Query("accountType") String accountType,
                                  @Query("coin") String coin);

    /**
     * Upgrade to Unified Account
     * Upgrade Unified Account
     * <p>
     * UPGRADE GUIDANCE
     * Check your current account status by calling this Get Account Info
     * <p>
     * if unifiedMarginStatus=1, then it is classic account, you can call below upgrade endpoint to UTA Pro. Check Get Account Info after a while and if unifiedMarginStatus=4, then it is successfully upgraded to UTA Pro.
     * <p>
     * if unifiedMarginStatus=2, then it is UMA, you need to call below upgrade endpoint twice. The first call, your account will be upgraded to UTA, please make sure you call this Get Account Info and unifiedMarginStatus=3, then you can start the 2nd call, if you see unifiedMarginStatus=4, then it is UTA Pro.
     * <p>
     * if unifiedMarginStatus=3, then it is UTA, you need to call below upgrade endpoint to UTA Pro. Check Get Account Info after a while and if unifiedMarginStatus=4, then it is successfully upgraded to UTA Pro.
     * <p>
     * IMPORTANT
     * Banned / Express path users cannot upgrade the account to Unified Account for now.
     * <p>
     * INFO
     * You can upgrade the normal acct to unified acct without closing positions now, but please note belows:
     * <p>
     * Please avoid upgrading during these period:
     * every hour	50th minute to 5th minute of next hour
     * Please ensure:
     * No open order and debt in the Spot account
     * No open order and positions are either isolated or cross mode in the Derivatives account
     * No open order in the USDC Derivatives account
     * Cannot have TPSL order either
     * When the unifiedUpgradeProcess = PROCESS, it means that the system needs asynchronous verification processing, and the upgrade result cannot be returned in real time. You can check API Get Account Info after 3-5 minutes, check whether the upgrade is successful according to the "unifiedMarginStatus" field in the return.
     * During the account upgrade process, the data of Rest API/Websocket stream may be inaccurate due to the fact that the account-related asset data is in the processing state. It is recommended to query and use it after the upgrade is completed.
     * https://bybit-exchange.github.io/docs/v5/account/upgrade-unified-account
     *
     * @return Response Parameters
     * Parameter	Type	Comments
     * unifiedUpdateStatus	string	Upgrade status. FAIL,PROCESS,SUCCESS
     * unifiedUpdateMsg	Object	If PROCESS,SUCCESS, it returns null
     * &gt; msg	array	Error message array. Only FAIL will have this field
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/v5/account/upgrade-to-uta")
    Call<Object> upgradeAccountToUTA();

    /**
     * Get Borrow History
     * Get interest records, sorted in reverse order of creation time.
     * https://bybit-exchange.github.io/docs/v5/account/borrow-history
     *
     * @param currency  false	string	USDC,USDT,BTC,ETH
     * @param startTime false	integer	The start timestamp (ms)
     * @param endTime   false	integer	The end time. timestamp (ms)
     * @param limit     false	integer	Limit for data size per page. [1, 50]. Default: 20
     * @param cursor    false	string	Cursor. Use the nextPageCursor token from the response to retrieve the next page of the result set
     * @return Response Parameters
     * Parameter	Type	Comments
     * list	array	Object
     * &gt; currency	string	USDC,USDT,BTC,ETH
     * &gt; createdTime	integer	Created timestamp (ms)
     * &gt; borrowCost	string	Interest
     * &gt; hourlyBorrowRate	string	Hourly Borrow Rate
     * &gt; InterestBearingBorrowSize	string	Interest Bearing Borrow Size
     * &gt; costExemption	string	Cost exemption
     * &gt; borrowAmount	string	Total borrow amount
     * &gt; unrealisedLoss	string	Unrealised loss
     * &gt; freeBorrowedAmount	string	The borrowed amount for interest free
     * nextPageCursor	string	Refer to the cursor request parameter
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/v5/account/borrow-history")
    Call<Object> getAccountBorrowHistory(@Query("currency") String currency,
                                         @Query("startTime") Long startTime,
                                         @Query("endTime") Long endTime,
                                         @Query("limit") Integer limit,
                                         @Query("cursor") String cursor);

    /**
     * Set Collateral Coin
     * You can decide whether the assets in the Unified account needs to be collateral coins.
     * https://bybit-exchange.github.io/docs/v5/account/set-collateral#http-request
     *
     * @param setCollateralCoinRequest coin	true	string	Coin name
     *                                 You can get collateral coin from here
     *                                 USDT, USDC cannot be switched off
     *                                 collateralSwitch	true	string	ON: switch on collateral, OFF: switch off collateral
     * @return Response Parameters
     * None
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/v5/account/set-collateral-switch")
    Call<Object> setAccountCollateralCoin(@Body SetCollateralCoinRequest setCollateralCoinRequest);

    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/v5/account/set-collateral-switch-batch")
    Call<Object> batchSetAccountCollateralCoin(@Body BatchSetCollateralCoinRequest batchSetCollateralCoinRequest);

    /**
     * Set Spot Hedging
     * You can turn on/off Spot hedging feature in Portfolio margin for Unified account.
     * INFO
     * Only unified account is applicable
     * Only portfolio margin mode is applicable
     * Institutional lending account is not supported
     * https://bybit-exchange.github.io/docs/v5/account/set-spot-hedge
     *
     * @param setSpotHedgingRequest setHedgingMode	true	string	ON, OFF
     * @return Response Parameters
     * Parameter	Type	Comments
     * retCode	integer	Result code
     * retMsg	string	Result message
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/v5/account/set-hedging-mode")
    Call<Object> setAccountSpotHedging(@Body SetSpotHedgingRequest setSpotHedgingRequest);

    /**
     * Get Collateral Info
     * Get the collateral information of the current unified margin account, including loan interest rate, loanable amount, collateral conversion rate, whether it can be mortgaged as margin, etc.
     * https://bybit-exchange.github.io/docs/v5/account/collateral-info
     *
     * @param currency false	string	Asset currency of all current collateral
     * @return Response Parameters
     * Parameter	Type	Comments
     * list	array	Object
     * &gt; currency	string	Currency of all current collateral
     * &gt; hourlyBorrowRate	string	Hourly borrow rate
     * &gt; maxBorrowingAmount	string	Max borrow amount. This value is shared across main-sub UIDs
     * &gt; freeBorrowingAmount	string	Depreciated field, always return "", please refer to freeBorrowingLimit
     * &gt; freeBorrowingLimit	string	The maximum limit for interest-free borrowing
     * &gt; freeBorrowAmount	string	The amount of borrowing within your total borrowing amount that is exempt from interest charges
     * &gt; borrowAmount	string	Borrow amount
     * &gt; availableToBorrow	string	Available amount to borrow. This value is shared across main-sub UIDs
     * &gt; borrowable	boolean	Whether currency can be borrowed
     * &gt; borrowUsageRate	string	Borrow usage rate: borrowAmount/maxBorrowingAmount. It is an actual value between 0 and 1
     * &gt; marginCollateral	boolean	Whether it can be used as a margin collateral currency (platform)
     * When marginCollateral=false, then collateralSwitch is meaningless
     * &gt; collateralSwitch	boolean	Whether the collateral is turned on by user (user)
     * When marginCollateral=true, then collateralSwitch is meaningful
     * &gt; collateralRatio	string	Collateral ratio
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/v5/account/collateral-info")
    Call<Object> getAccountCollateralInfo(@Query("currency") String currency);

    /**
     * Get Coin Greeks
     * Get current account Greeks information
     * <p>
     * https://bybit-exchange.github.io/docs/v5/account/coin-greeks
     *
     * @param baseCoin false	string	Base coin. If not passed, all supported base coin greeks will be returned by default
     * @return Response Parameters
     * Parameter	Type	Comments
     * list	array	Object
     * &gt; baseCoin	string	Base coin. e.g.,BTC,ETH,SOL
     * &gt; totalDelta	string	Delta value
     * &gt; totalGamma	string	Gamma value
     * &gt; totalVega	string	Vega value
     * &gt; totalTheta	string	Theta value
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/v5/asset/coin-greeks")
    Call<Object> getAccountCoinGeeks(@Query("baseCoin") String baseCoin);

    /**
     * Get Fee Rate
     * Get the trading fee rate.
     * <p>
     * Covers: Spot / USDT perpetual / USDC perpetual / USDC futures / Inverse perpetual / Inverse futures / Options
     * <p>
     * https://bybit-exchange.github.io/docs/v5/account/fee-rate
     *
     * @param category true	string	Product type. spot, linear, inverse, option
     * @param symbol   false	string	Symbol name. Valid for linear, inverse, spot
     * @param baseCoin false	string	Base coin. SOL, BTC, ETH. Valid for option
     * @return Response Parameters
     * Parameter	Type	Comments
     * category	string	Product type. spot, option. Derivatives does not have this field
     * list	array	Object
     * &gt; symbol	string	Symbol name. Keeps "" for Options
     * &gt; baseCoin	string	Base coin. SOL, BTC, ETH
     * Derivatives does not have this field
     * Keeps "" for Spot
     * &gt; takerFeeRate	string	Taker fee rate
     * &gt; makerFeeRate	string	Maker fee rate
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/v5/account/fee-rate")
    Call<Object> getAccountFreeRate(@Query("category") String category,
                                    @Query("symbol") String symbol,
                                    @Query("baseCoin") String baseCoin);

    /**
     * Get Account Info
     * Query the margin mode configuration of the account.
     * <p>
     * ttps://bybit-exchange.github.io/docs/v5/account/account-info
     *
     * @return Request Parameters
     * None
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/v5/account/info")
    Call<Object> getAccountInfo();

    /**
     * Get Transaction Log
     * Query transaction logs in Unified account.
     * <p>
     * https://bybit-exchange.github.io/docs/v5/account/transaction-log
     *
     * @param accountType false	string	Account Type. UNIFIED
     * @param category    false	string	Product type. spot,linear,option
     * @param currency    false	string	Currency
     * @param baseCoin    false	string	BaseCoin. e.g., BTC of BTCPERP
     * @param type        false	string	Types of transaction logs
     * @param startTime   false	integer	The start timestamp (ms)
     * @param endTime     false	integer	The end timestamp (ms)
     * @param limit       false	integer	Limit for data size per page. [1, 50]. Default: 20
     * @param cursor      false	string	Cursor. Use the nextPageCursor token from the response to retrieve the next page of the result set
     * @return Response Parameters
     * Parameter	Type	Comments
     * list	array	Object
     * &gt; id	string	Unique id
     * &gt; symbol	string	Symbol name
     * &gt; category	string	Product type
     * &gt; side	string	Side. Buy,Sell,None
     * &gt; transactionTime	string	Transaction timestamp (ms)
     * &gt; type	string	Type
     * &gt; qty	string	Quantity. It is the quantity for each trade entry and it does not have direction
     * &gt; size	string	Size. The rest position size after the trade is executed, and it has direction, i.e., short with "-"
     * &gt; currency	string	USDC USDT BTC ETH
     * &gt; tradePrice	string	Trade price
     * &gt; funding	string	Funding fee
     * Positive value means receiving funding fee
     * Negative value means deducting funding fee
     * &gt; fee	string	Trading fee
     * Positive fee value means expense
     * Negative fee value means rebates
     * &gt; cashFlow	string	Cash flow, e.g., (1) close the position, and unRPL converts to RPL, (2) 8-hour session settlement for USDC Perp and Futures, (3) transfer in or transfer out. This does not include trading fee, funding fee
     * &gt; change	string	Change = cashFlow + funding - fee
     * &gt; cashBalance	string	Cash balance. This is the wallet balance after a cash change
     * &gt; feeRate	string
     * When type=TRADE, then it is trading fee rate
     * When type=SETTLEMENT, it means funding fee rate. For side=Buy, feeRate=market fee rate; For side=Sell, feeRate= - market fee rate
     * &gt; bonusChange	string	The change of bonus
     * &gt; tradeId	string	Trade ID
     * &gt; orderId	string	Order ID
     * &gt; orderLinkId	string	User customised order ID
     * nextPageCursor	string	Refer to the cursor request parameter
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/v5/account/transaction-log")
    Call<Object> getUtaTransactionLog(@Query("accountType") String accountType,
                                   @Query("category") String category,
                                   @Query("currency") String currency,
                                   @Query("baseCoin") String baseCoin,
                                   @Query("type") String type,
                                   @Query("startTime") Long startTime,
                                   @Query("endTime") Long endTime,
                                   @Query("limit") Integer limit,
                                   @Query("cursor") String cursor);

    /**
     * Get Transaction Log
     * Query transaction logs in Unified account.
     * <p>
     * https://bybit-exchange.github.io/docs/v5/account/transaction-log
     *
     * @param accountType false	string	Account Type. UNIFIED
     * @param category    false	string	Product type. spot,linear,option
     * @param currency    false	string	Currency
     * @param baseCoin    false	string	BaseCoin. e.g., BTC of BTCPERP
     * @param type        false	string	Types of transaction logs
     * @param startTime   false	integer	The start timestamp (ms)
     * @param endTime     false	integer	The end timestamp (ms)
     * @param limit       false	integer	Limit for data size per page. [1, 50]. Default: 20
     * @param cursor      false	string	Cursor. Use the nextPageCursor token from the response to retrieve the next page of the result set
     * @return Response Parameters
     * Parameter	Type	Comments
     * list	array	Object
     * &gt; id	string	Unique id
     * &gt; symbol	string	Symbol name
     * &gt; category	string	Product type
     * &gt; side	string	Side. Buy,Sell,None
     * &gt; transactionTime	string	Transaction timestamp (ms)
     * &gt; type	string	Type
     * &gt; qty	string	Quantity. It is the quantity for each trade entry and it does not have direction
     * &gt; size	string	Size. The rest position size after the trade is executed, and it has direction, i.e., short with "-"
     * &gt; currency	string	USDC USDT BTC ETH
     * &gt; tradePrice	string	Trade price
     * &gt; funding	string	Funding fee
     * Positive value means receiving funding fee
     * Negative value means deducting funding fee
     * &gt; fee	string	Trading fee
     * Positive fee value means expense
     * Negative fee value means rebates
     * &gt; cashFlow	string	Cash flow, e.g., (1) close the position, and unRPL converts to RPL, (2) 8-hour session settlement for USDC Perp and Futures, (3) transfer in or transfer out. This does not include trading fee, funding fee
     * &gt; change	string	Change = cashFlow + funding - fee
     * &gt; cashBalance	string	Cash balance. This is the wallet balance after a cash change
     * &gt; feeRate	string
     * When type=TRADE, then it is trading fee rate
     * When type=SETTLEMENT, it means funding fee rate. For side=Buy, feeRate=market fee rate; For side=Sell, feeRate= - market fee rate
     * &gt; bonusChange	string	The change of bonus
     * &gt; tradeId	string	Trade ID
     * &gt; orderId	string	Order ID
     * &gt; orderLinkId	string	User customised order ID
     * nextPageCursor	string	Refer to the cursor request parameter
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/v5/account/contract-transaction-log")
    Call<Object> getClassicalTransactionLog(@Query("accountType") String accountType,
                                   @Query("category") String category,
                                   @Query("currency") String currency,
                                   @Query("baseCoin") String baseCoin,
                                   @Query("type") String type,
                                   @Query("startTime") Long startTime,
                                   @Query("endTime") Long endTime,
                                   @Query("limit") Integer limit,
                                   @Query("cursor") String cursor);

    /**
     * Set Margin Mode
     * Default is regular margin mode
     * <p>
     * INFO
     * UTA account can be switched between these 3 kinds of margin modes, which is across UID level, working for USDT Perp, USDC Perp, USDC Futures and Options (Option does not support ISOLATED_MARGIN)
     * Classic account can be switched between REGULAR_MARGIN and PORTFOLIO_MARGIN, only work for USDC Perp and Options trading.
     * <p>
     * https://bybit-exchange.github.io/docs/v5/account/set-margin-mode#http-request
     *
     * @param setMarginMode setMarginMode	true	string	ISOLATED_MARGIN, REGULAR_MARGIN(i.e. Cross margin), PORTFOLIO_MARGIN
     * @return Response Parameters
     * Parameter	Type	Comments
     * reasons	array	Object. If requested successfully, it is an empty array
     * &gt; reasonCode	string	Fail reason code
     * &gt; reasonMsg	string	Fail reason msg
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/v5/account/set-margin-mode")
    Call<Object> setAccountMarginMode(@Body SetMarginModeRequest setMarginMode); // ISOLATED_MARGIN, REGULAR_MARGIN(i.e. Cross margin), PORTFOLIO_MARGIN

    /**
     * Set MMP
     * INFO
     * What is MMP?
     * Market Maker Protection (MMP) is an automated mechanism designed to protect market makers (MM) against liquidity risks and over-exposure in the market. It prevents simultaneous trade executions on quotes provided by the MM within a short time span. The MM can automatically pull their quotes if the number of contracts traded for an underlying asset exceeds the configured threshold within a certain time frame. Once MMP is triggered, any pre-existing MMP orders will be automatically canceled, and new orders tagged as MMP will be rejected for a specific duration — known as the frozen period — so that MM can reassess the market and modify the quotes.
     * <p>
     * How to enable MMP
     * Send an email to Bybit (financial.inst@bybit.com) or contact your business development (BD) manager to apply for MMP. After processed, the default settings are as below table:
     * <p>
     * Parameter	Type	Comments	Default value
     * baseCoin	string	Base coin	BTC
     * window	string	Time window (millisecond)	5000
     * frozenPeriod	string	Frozen period (millisecond)	100
     * qtyLimit	string	Quantity limit	100
     * deltaLimit	string	Delta limit	100
     * Applicable
     * Effective for options only. When you place an option order, set mmp=true, which means you mark this order as a mmp order.
     * <p>
     * https://bybit-exchange.github.io/docs/v5/account/set-mmp#http-request
     *
     * @param setMMPRequest baseCoin	true	string	Base coin
     *                      window	true	string	Time window (ms)
     *                      frozenPeriod	true	string	Frozen period (ms). "0" means the trade will remain frozen until manually reset
     *                      qtyLimit	true	string	Trade qty limit (positive and up to 2 decimal places)
     *                      deltaLimit	true	string	Delta limit (positive and up to 2 decimal places)
     * @return Response Parameters
     * None
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/v5/account/mmp-modify")
    Call<Object> modifyAccountMMP(@Body SetMMPRequest setMMPRequest);

    /**
     * Reset MMP
     * INFO
     * Once the mmp triggered, you can unfreeze the account by this endpoint, then qtyLimit and deltaLimit will be reset to 0.
     * If the account is not frozen, reset action can also remove previous accumulation, i.e., qtyLimit and deltaLimit will be reset to 0.
     * <p>
     * https://bybit-exchange.github.io/docs/v5/account/reset-mmp
     *
     * @param resetMMPRequest baseCoin	true	string	Base coin
     * @return Response Parameters
     * None
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/v5/account/mmp-reset")
    Call<Object> resetAccountMMP(@Body ResetMMPRequest resetMMPRequest);

    /**
     * Get MMP State
     * <p>
     * https://bybit-exchange.github.io/docs/v5/account/get-mmp-state
     *
     * @param baseCoin true	string	Base coin
     * @return Response Parameters
     * Parameter	Type	Comments
     * result	array	Object
     * &gt; baseCoin	string	Base coin
     * &gt; mmpEnabled	boolean	Whether the account is enabled mmp
     * &gt; window	string	Time window (ms)
     * &gt; frozenPeriod	string	Frozen period (ms)
     * &gt; qtyLimit	string	Trade qty limit
     * &gt; deltaLimit	string	Delta limit
     * &gt; mmpFrozenUntil	string	Unfreeze timestamp (ms)
     * &gt; mmpFrozen	boolean	Whether the mmp is triggered.
     * true: mmpFrozenUntil is meaningful
     * false: please ignore the value of mmpFrozenUntil
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/v5/account/mmp-state")
    Call<Object> getAccountMMPState(@Query("baseCoin") String baseCoin);

    /**
     * Get SMP Group ID
     * <p>
     * https://bybit-exchange.github.io/docs/v5/account/smp-group
     * Get SMP Group ID
     * Query the SMP group ID of self match prevention
     *
     * @return Response Parameters
     * Parameter	Type	Comments
     * result	array	Object
     * &gt; smpGroup	integer	Smp group ID. If the UID has no group, it is 0 by default
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/v5/account/smp-group")
    Call<Object> getAccountSMPGroupId();

    // Asset Endpoints

    /**
     * Get Coin Exchange Records
     * Query the coin exchange records.
     * <p>
     * INFO
     * This endpoint currently is not available to get data after 12 Mar 2023. We will make it fully available later.
     * <p>
     * CAUTION
     * You may have a long delay of this endpoint.
     * <p>
     * https://bybit-exchange.github.io/docs/v5/asset/exchange
     *
     * @param fromCoin false	string	The currency to convert from. e.g,BTC
     * @param toCoin   false	string	The currency to convert to. e.g,USDT
     * @param limit    false	integer	Limit for data size per page. [1, 50]. Default: 10
     * @param cursor   false	string	Cursor. Use the nextPageCursor token from the response to retrieve the next page of the result set
     * @return Response Parameters
     * Parameter	Type	Comments
     * nextPageCursor	string	Refer to the cursor request parameter
     * orderBody	array	Object
     * &gt; fromCoin	string	The currency to convert from
     * &gt; fromAmount	string	The amount to convert from
     * &gt; toCoin	string	The currency to convert to
     * &gt; toAmount	string	The amount to convert to
     * &gt; exchangeRate	string	Exchange rate
     * &gt; createdTime	string	Exchange created timestamp (sec)
     * &gt; exchangeTxId	string	Exchange transaction ID
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/v5/asset/exchange/order-record")
    Call<Object> getAssetCoinExchangeRecords(@Query("fromCoin") String fromCoin,
                                             @Query("toCoin") String toCoin,
                                             @Query("limit") Integer limit,
                                             @Query("cursor") String cursor);

    /**
     * Get Delivery Record
     * Query delivery records of USDC futures and Options, sorted by deliveryTime in descending order
     * <p>
     * https://bybit-exchange.github.io/docs/v5/asset/delivery
     *
     * @param category true	string	Product type. option, linear
     * @param symbol   false	string	Symbol name
     * @param expDate  false	string	Expiry date. 25MAR22. Default: return all
     * @param limit    false	integer	Limit for data size per page. [1, 50]. Default: 20
     * @param cursor   false	string	Cursor. Use the nextPageCursor token from the response to retrieve the next page of the result set
     * @return Response Parameters
     * Parameter	Type	Comments
     * category	string	Product type
     * list	array	Object
     * &gt; deliveryTime	number	Delivery time (ms)
     * &gt; symbol	string	Symbol name
     * &gt; side	string	Buy,Sell
     * &gt; position	string	Executed size
     * &gt; deliveryPrice	string	Delivery price
     * &gt; strike	string	Exercise price
     * &gt; fee	string	Trading fee
     * &gt; deliveryRpl	string	Realized PnL of the delivery
     * nextPageCursor	string	Refer to the cursor request parameter
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/v5/asset/delivery-record")
    Call<Object> getAssetDeliveryRecords(@Query("category") String category,
                                         @Query("symbol") String symbol,
                                         @Query("expDate") String expDate,
                                         @Query("limit") Integer limit,
                                         @Query("cursor") String cursor);

    /**
     * Get USDC Session Settlement
     * Query session settlement records of USDC perpetual and futures
     * <p>
     * Unified account covers: USDC perpetual / USDC futures
     * <p>
     * https://bybit-exchange.github.io/docs/v5/asset/settlement
     *
     * @param category true	string	Product type. linear
     * @param symbol   false	string	Symbol name
     * @param limit    false	integer	Limit for data size per page. [1, 50]. Default: 20
     * @param cursor   false	string	Cursor. Use the nextPageCursor token from the response to retrieve the next page of the result set
     * @return category    string	Product type
     * list	array	Object
     * &gt; symbol	string	Symbol name
     * &gt; side	string	Buy,Sell
     * &gt; size	string	Position size
     * &gt; sessionAvgPrice	string	Settlement price
     * &gt; markPrice	string	Mark price
     * &gt; realisedPnl	string	Realised PnL
     * &gt; createdTime	string	Created time (ms)
     * nextPageCursor	string	Refer to the cursor request parameter
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/v5/asset/settlement-record")
    Call<Object> getAssetUSDCSettlementRecords(@Query("category") String category,
                                               @Query("symbol") String symbol,
                                               @Query("limit") Integer limit,
                                               @Query("cursor") String cursor);

    /**
     * Get Asset Info
     * Query asset information
     * <p>
     * INFO
     * For now, it can query SPOT only.
     * <p>
     * https://bybit-exchange.github.io/docs/v5/asset/asset-info
     *
     * @param accountType true	string	Account type. SPOT
     * @param coin        false	string	Coin name
     * @return Response Parameters
     * Parameter	Type	Comments
     * spot	Object
     * &gt; status	string	account status. ACCOUNT_STATUS_NORMAL: normal, ACCOUNT_STATUS_UNSPECIFIED: banned
     * &gt; assets	array	Object
     * &gt; &gt; coin	string	Coin
     * &gt; &gt; frozen	string	Freeze amount
     * &gt; &gt; free	string	Free balance
     * &gt; &gt; withdraw	string	Amount in withdrawing
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/v5/asset/transfer/query-asset-info")
    Call<Object> getAssetInfo(@Query("accountType") String accountType,
                              @Query("coin") String coin);


    /**
     * Get All Coins Balance
     * You could get all coin balance of all account types under the master account, and sub account.
     * <p>
     * IMPORTANT
     * It is not allowed to get master account coin balance via sub account api key.
     * <p>
     * https://bybit-exchange.github.io/docs/v5/asset/all-balance
     *
     * @param accountType true	string	Account type
     * @param memberId    false	string	User Id. It is required when you use master api key to check sub account coin balance
     * @param coin        false	string	Coin name
     *                    Query all coins if not passed
     *                    Can query multiple coins, separated by comma. USDT,USDC,ETH
     * @param withBonus   false	string	Whether query bonus or not. 0(default)：false; 1：true
     * @return Response Parameters
     * Parameter	Type	Comments
     * accountType	string	Account type
     * memberId	string	UserID
     * balance	array	Object
     * &gt; coin	string	Currency type
     * &gt; walletBalance	string	Wallet balance
     * &gt; transferBalance	string	Transferable balance
     * &gt; bonus	string	The bonus
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/v5/asset/transfer/query-account-coins-balance")
    Call<Object> getAssetAllCoinsBalance(@Query("accountType") String accountType,
                                         @Query("memberId") String memberId,
                                         @Query("coin") String coin,
                                         @Query("withBonus") String withBonus);

    /**
     * Get Single Coin Balance
     * Query the balance of a specific coin in a specific account type. Supports querying sub UID's balance. Also, you can check the transferable amount from master to sub account, sub to master account or sub to sub account, especially for user who has INS loan.
     * <p>
     * INFO
     * Sub account cannot query master account balance
     * Sub account can only check its own balance
     * Master account can check its own and its sub UIDs balance
     * <p>
     * https://bybit-exchange.github.io/docs/v5/asset/account-coin-balance
     *
     * @param accountType               true	string	Account type
     * @param toAccountType             false	string	To account type. Required when querying the transferable balance between different account types
     * @param memberId                  false	string	UID. Required when querying sub UID balance with master api key
     * @param toMemberId                false	string	UID. Required when querying the transferable balance between different UIDs
     * @param coin                      true	string	Coin
     * @param withBonus                 false	integer	0: not query bonus. 1: query bonus
     * @param withTransferSafeAmount    false	integer	Whether query delay withdraw/transfer safe amount
     *                                  0(default)：false, 1：true
     *                                  What is delay withdraw amount?
     * @param withLtvTransferSafeAmount false	integer	For OTC loan users in particular, you can check the transferable amount under risk level
     *                                  0(default)：false, 1：true
     *                                  toAccountType is mandatory
     * @return Response Parameters
     * Parameter	Type	Comments
     * accountType	string	Account type
     * bizType	integer	Biz type
     * accountId	string	Account ID
     * memberId	string	Uid
     * balance	Object
     * &gt; coin	string	Coin
     * &gt; walletBalance	string	Wallet balance
     * &gt; transferBalance	string	Transferable balance
     * &gt; bonus	string	bonus
     * &gt; transferSafeAmount	string	Safe amount to transfer. Keep "" if not query
     * &gt; ltvTransferSafeAmount	string	Transferable amount for ins loan account. Keep "" if not query
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/v5/asset/transfer/query-account-coin-balance")
    Call<Object> getAssetSingleCoinBalance(@Query("accountType") String accountType,
                                           @Query("toAccountType") String toAccountType,
                                           @Query("memberId") String memberId,
                                           @Query("toMemberId") String toMemberId,
                                           @Query("coin") String coin,
                                           @Query("withBonus") Integer withBonus,
                                           @Query("withTransferSafeAmount") Integer withTransferSafeAmount,
                                           @Query("withLtvTransferSafeAmount") Integer withLtvTransferSafeAmount);

    /**
     * Get Transferable Coin
     * Query the transferable coin list between each account type
     * <p>
     * https://bybit-exchange.github.io/docs/v5/asset/transferable-coin
     *
     * @param fromAccountType true	string	From account type
     * @param toAccountType   true	string	To account type
     * @return Response Parameters
     * Parameter	Type	Comments
     * list	array	A list of coins (as strings)
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/v5/asset/transfer/query-transfer-coin-list")
    Call<Object> getAssetTransferableCoins(@Query("fromAccountType") String fromAccountType, @Query("toAccountType") String toAccountType);

    /**
     * Create Internal Transfer
     * Create the internal transfer between different account types under the same UID.
     * <p>
     * TIP
     * Each account type has its own acceptable coins, e.g, you cannot transfer USDC from SPOT to CONTRACT. Please refer to transferable coin list API to find out more.
     * <p>
     * https://bybit-exchange.github.io/docs/v5/asset/create-inter-transfer#http-request
     *
     * @param assetInternalTransferRequest transferId	true	string	UUID. Please manually generate a UUID
     *                                     coin	true	string	Coin
     *                                     amount	true	string	Amount
     *                                     fromAccountType	true	string	From account type
     *                                     toAccountType	true	string	To account type
     * @return Response Parameters
     * Parameter	Type	Comments
     * transferId	string	UUID
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/v5/asset/transfer/inter-transfer")
    Call<Object> createAssetInternalTransfer(@Body AssetInternalTransferRequest assetInternalTransferRequest);

    /**
     * Get Sub UID
     * Query the sub UIDs under a main UID
     * <p>
     * CAUTION
     * Can query by the master UID's api key only
     * <p>
     * https://bybit-exchange.github.io/docs/v5/asset/sub-uid-list
     *
     * @return Response Parameters
     * Parameter	Type	Comments
     * subMemberIds	array string	All sub UIDs under the main UID
     * transferableSubMemberIds	array string	All sub UIDs that have universal transfer enabled
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/v5/asset/transfer/query-sub-member-list")
    Call<Object> getAssetTransferSubUidList();

    /**
     * Create Universal Transfer
     * Transfer between sub-sub or main-sub.
     * <p>
     * CAUTION
     * Can use master or sub acct api key to request
     * To use sub acct api key, it must have "SubMemberTransferList" permission
     * When use sub acct api key, it can only transfer to main account
     * If you encounter errorCode: 131228 and msg: your balance is not enough, please go to Get Single Coin Balance to check transfer safe amount.
     * You can not transfer between the same UID
     * <p>
     * https://bybit-exchange.github.io/docs/v5/asset/unitransfer#http-request
     *
     * @param assetUniversalTransferRequest transferId	true	string	UUID. Please manually generate a UUID
     *                                      coin	true	string	Coin
     *                                      amount	true	string	Amount
     *                                      fromMemberId	true	integer	From UID
     *                                      toMemberId	true	integer	To UID
     *                                      fromAccountType	true	string	From account type
     *                                      toAccountType	true	string	To account type
     * @return Response Parameters
     * Parameter	Type	Comments
     * transferId	string	UUID
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/v5/asset/transfer/universal-transfer")
    Call<Object> createAssetUniversalTransfer(@Body AssetUniversalTransferRequest assetUniversalTransferRequest);

    /**
     * Get Internal Transfer Records
     * Query the internal transfer records between different account types under the same UID.
     * <p>
     * https://bybit-exchange.github.io/docs/v5/asset/inter-transfer-list
     *
     * @param transferId false	string	UUID. Use the one you generated in createTransfer
     * @param coin       false	string	Coin
     * @param status     false	string	Transfer status
     * @param startTime  false	integer	The start timestamp (ms) Note: the query logic is actually effective based on second level
     * @param endTime    false	integer	The end timestamp (ms) Note: the query logic is actually effective based on second level
     * @param limit      false	integer	Limit for data size per page. [1, 50]. Default: 20
     * @param cursor     false	string	Cursor. Use the nextPageCursor token from the response to retrieve the next page of the result set
     * @return Response Parameters
     * Parameter	Type	Comments
     * list	array	Object
     * &gt; transferId	string	Transfer ID
     * &gt; coin	string	Transferred coin
     * &gt; amount	string	Transferred amount
     * &gt; fromAccountType	string	From account type
     * &gt; toAccountType	string	To account type
     * &gt; timestamp	string	Transfer created timestamp (ms)
     * &gt; status	string	Transfer status
     * nextPageCursor	string	Refer to the cursor request parameter
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/v5/asset/transfer/query-inter-transfer-list")
    Call<Object> getAssetInternalTransferRecords(@Query("transferId") String transferId,
                                                 @Query("coin") String coin,
                                                 @Query("status") String status,
                                                 @Query("startTime") Long startTime,
                                                 @Query("endTime") Long endTime,
                                                 @Query("limit") Integer limit,
                                                 @Query("cursor") String cursor);

    /**
     * Get Universal Transfer Records
     * Query universal transfer records
     * <p>
     * TIP
     * Main acct api key or Sub acct api key are both supported
     * Main acct api key needs "SubMemberTransfer" permission
     * Sub acct api key needs "SubMemberTransferList" permission
     * <p>
     * https://bybit-exchange.github.io/docs/v5/asset/unitransfer-list
     *
     * @param transferId false	string	UUID. Use the one you generated in createTransfer
     * @param coin       false	string	Coin
     * @param status     false	string	Transfer status. SUCCESS,FAILED,PENDING
     * @param startTime  false	integer	The start timestamp (ms) Note: the query logic is actually effective based on second level
     * @param endTime    false	integer	The end timestamp (ms) Note: the query logic is actually effective based on second level
     * @param limit      false	integer	Limit for data size per page. [1, 50]. Default: 20
     * @param cursor     false	string	Cursor. Use the nextPageCursor token from the response to retrieve the next page of the result set
     * @return Response Parameters
     * Parameter	Type	Comments
     * list	array	Object
     * &gt; transferId	string	Transfer ID
     * &gt; coin	string	Transferred coin
     * &gt; amount	string	Transferred amount
     * &gt; fromMemberId	string	From UID
     * &gt; toMemberId	string	TO UID
     * &gt; fromAccountType	string	From account type
     * &gt; toAccountType	string	To account type
     * &gt; timestamp	string	Transfer created timestamp (ms)
     * &gt; status	string	Transfer status
     * nextPageCursor	string	Refer to the cursor request parameter
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/v5/asset/transfer/query-universal-transfer-list")
    Call<Object> getAssetUniversalTransferRecords(@Query("transferId") String transferId,
                                                  @Query("coin") String coin,
                                                  @Query("status") String status,
                                                  @Query("startTime") Long startTime,
                                                  @Query("endTime") Long endTime,
                                                  @Query("limit") Integer limit,
                                                  @Query("cursor") String cursor);

    /**
     * Get Allowed Deposit Coin Info
     * Query allowed deposit coin information. To find out paired chain of coin, please refer coin info api.
     * <p>
     * TIP
     * This is an endpoint that does not need authentication
     * <p>
     * https://bybit-exchange.github.io/docs/v5/asset/deposit-coin-spec
     *
     * @param coin   false	string	Coin. coin and chain must be paired if passed
     * @param chain  false	string	Chain. coin and chain must be paired if passed
     * @param limit  false	integer	Limit for data size per page. [1, 35]. Default: 10
     * @param cursor false	string	Cursor. Use the nextPageCursor token from the response to retrieve the next page of the result set
     * @return Response Parameters
     * Parameter	Type	Comments
     * configList	array	Object
     * &gt; coin	string	Coin
     * &gt; chain	string	Chain
     * &gt; coinShowName	string	Coin name
     * &gt; chainType	string	Chain type
     * &gt; blockConfirmNumber	integer	Deposit confirmation number
     * &gt; minDepositAmount	string	Minimum deposit amount
     * nextPageCursor	string	Refer to the cursor request parameter
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/v5/asset/deposit/query-allowed-list")
    Call<Object> getAssetAllowedDepositCoinInfo(
            @Query("coin") String coin,
            @Query("chain") String chain,
            @Query("limit") Integer limit,
            @Query("cursor") String cursor);


    /**
     * Set Deposit Account
     * Set auto transfer account after deposit. The same function as the setting for Deposit on web GUI
     * <p>
     * INFO
     * Your funds will be deposited into FUND wallet by default. You can set the wallet for auto-transfer after deposit by this API.
     * Only main UID can access.
     * TIP
     * Unified trading account has FUND, UNIFIED, CONTRACT(for inverse derivatives)
     * Unified margin account has FUND, UNIFIED, CONTRACT(for inverse derivatives), SPOT
     * Classic account has FUND, OPTION(USDC account), CONTRACT(for inverse derivatives and derivatives), SPOT
     * <p>
     * https://bybit-exchange.github.io/docs/v5/asset/set-deposit-acct
     *
     * @param setAssetDepositAccountRequest accountType	true	string	Account type
     *                                      UNIFIED
     *                                      SPOT
     *                                      OPTION
     *                                      CONTRACT
     *                                      FUND
     * @return Response Parameters
     * Parameter	Type	Comments
     * status	integer	Request result:
     * 1: SUCCESS
     * 0: FAIL
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/v5/asset/deposit/deposit-to-account")
    Call<Object> setAssetDepositAccount(@Body SetAssetDepositAccountRequest setAssetDepositAccountRequest);

    /**
     * Get Deposit Records (on-chain)
     * Query deposit records.
     * <p>
     * TIP
     * endTime - startTime should be less than 30 days. Query last 30 days records by default.
     * Can use main or sub UID api key to query deposit records respectively.
     * <p>
     * https://bybit-exchange.github.io/docs/v5/asset/deposit-record
     *
     * @param coin      false	string	Coin
     * @param startTime false	integer	The start timestamp (ms)
     * @param endTime   false	integer	The end timestamp (ms)
     * @param limit     false	integer	Limit for data size per page. [1, 50]. Default: 50
     * @param cursor    false	string	Cursor. Use the nextPageCursor token from the response to retrieve the next page of the result set
     * @return Response Parameters
     * Parameter	Type	Comments
     * rows	array	Object
     * &gt; coin	string	Coin
     * &gt; chain	string	Chain
     * &gt; amount	string	Amount
     * &gt; txID	string	Transaction ID
     * &gt; status	integer	Deposit status
     * &gt; toAddress	string	Deposit target address
     * &gt; tag	string	Tag of deposit target address
     * &gt; depositFee	string	Deposit fee
     * &gt; successAt	string	Last updated time
     * &gt; confirmations	string	Number of confirmation blocks
     * &gt; txIndex	string	Transaction sequence number
     * &gt; blockHash	string	Hash number on the chain
     * &gt; batchReleaseLimit	string	The deposit limit for this coin in this chain. "-1" means no limit
     * &gt; depositType	integer	The deposit type. 0: normal deposit, 10: the deposit reaches daily deposit limit, 20: abnormal deposit
     * nextPageCursor	string	Refer to the cursor request parameter
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/v5/asset/deposit/query-record")
    Call<Object> getAssetDepositRecords(
            @Query("coin") String coin,
            @Query("startTime") Long startTime,
            @Query("endTime") Long endTime,
            @Query("limit") Integer limit,
            @Query("cursor") String cursor);

    /**
     * Get Sub Deposit Records (on-chain)
     * Query subaccount's deposit records by main UID's API key.
     * <p>
     * TIP
     * endTime - startTime should be less than 30 days. Queries for the last 30 days worth of records by default.
     * <p>
     * https://bybit-exchange.github.io/docs/v5/asset/sub-deposit-record
     *
     * @param subMemberId true	string	Sub UID
     * @param coin        false	string	Coin
     * @param startTime   false	integer	The start timestamp (ms)
     * @param endTime     false	integer	The end timestamp (ms)
     * @param limit       false	integer	Limit for data size per page. [1, 50]. Default: 50
     * @param cursor      false	string	Cursor. Use the nextPageCursor token from the response to retrieve the next page of the result set
     * @return Response Parameters
     * Parameter	Type	Comments
     * rows	array	Object
     * &gt; coin	string	Coin
     * &gt; chain	string	Chain
     * &gt; amount	string	Amount
     * &gt; txID	string	Transaction ID
     * &gt; status	integer	Deposit status
     * &gt; toAddress	string	Deposit target address
     * &gt; tag	string	Tag of deposit target address
     * &gt; depositFee	string	Deposit fee
     * &gt; successAt	string	Last updated time
     * &gt; confirmations	string	Number of confirmation blocks
     * &gt; txIndex	string	Transaction sequence number
     * &gt; blockHash	string	Hash number on the chain
     * &gt; batchReleaseLimit	string	The deposit limit for this coin in this chain. "-1" means no limit
     * &gt; depositType	integer	The deposit type. 0: normal deposit, 10: the deposit reaches daily deposit limit, 20: abnormal deposit
     * nextPageCursor	string	Refer to the cursor request parameter
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/v5/asset/deposit/query-sub-member-record")
    Call<Object> getAssetSubMembersDepositRecords(@Query("subMemberId") String subMemberId,
                                                  @Query("coin") String coin,
                                                  @Query("startTime") Long startTime,
                                                  @Query("endTime") Long endTime,
                                                  @Query("limit") Integer limit,
                                                  @Query("cursor") String cursor);

    /**
     * Get Internal Deposit Records (off-chain)
     * Query deposit records within the Bybit platform. These transactions are not on the blockchain.
     * <p>
     * RULES
     * The maximum difference between the start time and the end time is 30 days.
     * Support to get deposit records by Master or Sub Member Api Key
     * <p>
     * https://bybit-exchange.github.io/docs/v5/asset/internal-deposit-record
     *
     * @param coin      false	string	Coin name: for example, BTC. Default value: all
     * @param startTime false	integer	Start time (ms). Default value: 30 days before the current time
     * @param endTime   false	integer	End time (ms). Default value: current time
     * @param limit     false	integer	Number of items per page, [1, 50]. Default value: 50
     * @param cursor    false	string	Cursor, used for pagination
     * @return Response Parameters
     * Parameter	Type	Comments
     * rows	array	Object
     * &gt; id	string	ID
     * &gt; type	integer	1: Internal deposit
     * &gt; coin	string	Deposit coin
     * &gt; amount	string	Deposit amount
     * &gt; status	integer
     * 1=Processing
     * 2=Success
     * 3=deposit failed
     * &gt; address	string	Email address or phone number
     * &gt; createdTime	string	Deposit created timestamp
     * nextPageCursor	string	cursor information: used for pagination. Default value: ""
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/v5/asset/deposit/query-internal-record")
    Call<Object> getAssetInternalDepositRecords(@Query("coin") String coin,
                                                @Query("startTime") Long startTime,
                                                @Query("endTime") Long endTime,
                                                @Query("limit") Integer limit,
                                                @Query("cursor") String cursor);

    /**
     * Get Master Deposit Address
     * Query the deposit address information of MASTER account.
     * <p>
     * https://bybit-exchange.github.io/docs/v5/asset/master-deposit-addr
     *
     * @param coin      true	string	Coin
     * @param chainType false	string	Chain, e.g.,ETH
     * @return Response Parameters
     * Parameter	Type	Comments
     * coin	string	Coin
     * chains	array	Object
     * &gt; chainType	string	Chain type
     * &gt; addressDeposit	string	The address for deposit
     * &gt; tagDeposit	string	Tag of deposit
     * &gt; chain	string	Chain
     * &gt; batchReleaseLimit	string	The deposit limit for this coin in this chain. "-1" means no limit
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/v5/asset/deposit/query-address")
    Call<Object> getAssetMasterDepositAddress(@Query("coin") String coin, @Query("chainType") String chainType);


    /**
     * Get Sub Deposit Address
     * Query the deposit address information of SUB account.
     * <p>
     * CAUTION
     * Can use master UID's api key only
     * <p>
     * https://bybit-exchange.github.io/docs/v5/asset/sub-deposit-addr
     *
     * @param coin        true	string	Coin
     * @param chainType   true	string	Chain, e.g.,ETH
     * @param subMemberId true	string	Sub user ID
     * @return Response Parameters
     * Parameter	Type	Comments
     * coin	string	Coin
     * chains	array	Object
     * &gt; chainType	string	Chain type
     * &gt; addressDeposit	string	The address for deposit
     * &gt; tagDeposit	string	Tag of deposit
     * &gt; chain	string	Chain
     * &gt; batchReleaseLimit	string	The deposit limit for this coin in this chain. "-1" means no limit
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/v5/asset/deposit/query-sub-member-address")
    Call<Object> getAssetSubMemberDepositAddress(@Query("coin") String coin,
                                                 @Query("chainType") String chainType,
                                                 @Query("subMemberId") String subMemberId);

    /**
     * Get Coin Info
     * Query coin information, including chain information, withdraw and deposit status.
     * <p>
     * https://bybit-exchange.github.io/docs/v5/asset/coin-info
     *
     * @param coin false	string	Coin
     * @return Response Parameters
     * Parameter	Type	Comments
     * rows	array	Object
     * &gt; name	integer	Coin name
     * &gt; coin	string	Coin
     * &gt; remainAmount	string	Remaining amount
     * &gt; chains	array	Object
     * &gt; &gt; chain	string	Chain
     * &gt; &gt; chainType	string	Chain type
     * &gt; &gt; confirmation	string	The number of confirmation for deposit
     * &gt; &gt; withdrawFee	string	withdraw fee. If withdraw fee is empty, It means that this coin does not support withdrawal
     * &gt; &gt; depositMin	string	Min. deposit
     * &gt; &gt; withdrawMin	string	Min. withdraw
     * &gt; &gt; minAccuracy	string	The precision of withdraw or deposit
     * &gt; &gt; chainDeposit	string	The chain status of deposit. 0: suspend. 1: normal
     * &gt; &gt; chainWithdraw	string	The chain status of withdraw. 0: suspend. 1: normal
     * &gt; &gt; withdrawPercentageFee	string	The withdraw fee percentage. It is a real figure, e.g., 0.022 means 2.2%
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/v5/asset/coin/query-info")
    Call<Object> getAssetCoinInfo(@Query("coin") String coin);

    /**
     * Get Withdrawable Amount
     * INFO
     * How can partial funds be subject to delayed withdrawal requests?
     * <p>
     * On-chain deposit: If the number of on-chain confirmations has not reached a risk-controlled level, a portion of the funds will be frozen for a period of time until they are unfrozen.
     * Buying crypto: If there is a risk, the funds will be frozen for a certain period of time and cannot be withdrawn.
     * <p>
     * https://bybit-exchange.github.io/docs/v5/asset/delay-amount
     *
     * @param coin true	string	Coin name
     * @return Response Parameters
     * Parameter	Type	Comments
     * limitAmountUsd	string	The frozen amount due to risk, in USD
     * withdrawableAmount	array	Object
     * &gt; SPOT	Object	Spot wallet, it is not returned if spot wallet is removed
     * &gt; &gt; coin	string	Coin name
     * &gt; &gt; withdrawableAmount	string	Amount that can be withdrawn
     * &gt; &gt; availableBalance	string	Available balance
     * &gt; FUND	Object	Funding wallet
     * &gt; &gt; coin	string	Coin name
     * &gt; &gt; withdrawableAmount	string	Amount that can be withdrawn
     * &gt; &gt; availableBalance	string	Available balance
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/v5/asset/withdraw/withdrawable-amount")
    Call<Object> getAssetWithdrawalAmount(@Query("coin") String coin);


    /**
     * Get Withdrawal Records
     * Query withdrawal records.
     * <p>
     * TIP
     * endTime - startTime should be less than 30 days. Query last 30 days records by default.
     * Can query by the master UID's api key only
     * <p>
     * https://bybit-exchange.github.io/docs/v5/asset/withdraw-record
     *
     * @param withdrawID   false	string	Withdraw ID
     * @param coin         false	string	Coin
     * @param withdrawType false	integer	Withdraw type. 0(default): on chain. 1: off chain. 2: all.
     * @param startTime    false	integer	The start timestamp (ms)
     * @param endTime      false	integer	The end timestamp (ms)
     * @param limit        false	integer	Limit for data size per page. [1, 50]. Default: 50
     * @param cursor       false	string	Cursor. Use the nextPageCursor token from the response to retrieve the next page of the result set
     * @return Response Parameters
     * Parameter	Type	Comments
     * rows	array	Object
     * &gt; withdrawId	string	Withdraw ID
     * &gt; txID	string	Transaction ID. It returns "" when withdrawal failed, withdrawal cancelled or internal transfer
     * &gt; withdrawType	string	Withdraw type. 0: on chain. 1: off chain
     * &gt; coin	string	Coin
     * &gt; chain	string	Chain
     * &gt; amount	string	Amount
     * &gt; withdrawFee	string	Withdraw fee
     * &gt; status	string	Withdraw status
     * &gt; toAddress	string	To withdrawal address. Shows an email or mobile number for internal transfers
     * &gt; tag	string	Tag
     * &gt; createTime	string	Withdraw created timestamp (ms)
     * &gt; updateTime	string	Withdraw updated timestamp (ms)
     * nextPageCursor	string	Cursor. Used for pagination
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/v5/asset/withdraw/query-record")
    Call<Object> getAssetWithdrawalRecords(
            @Query("withdrawID") String withdrawID,
            @Query("coin") String coin,
            @Query("withdrawType") Integer withdrawType,
            @Query("startTime") Long startTime,
            @Query("endTime") Long endTime,
            @Query("limit") Integer limit,
            @Query("cursor") String cursor);

    /**
     * Cancel Withdrawal
     * Cancel the withdrawal
     * <p>
     * CAUTION
     * Can query by the master UID's api key only
     * <p>
     * https://bybit-exchange.github.io/docs/v5/asset/cancel-withdraw#http-request
     *
     * @param assetCancelWithdrawRequest id	true	string	Withdrawal ID
     * @return Response Parameters
     * Parameter	Type	Comments
     * status	integer	0: fail. 1: success
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/v5/asset/withdraw/cancel")
    Call<Object> cancelAssetWithdraw(@Body AssetCancelWithdrawRequest assetCancelWithdrawRequest);

    /**
     * Withdraw
     * Withdraw assets from your Bybit account. You can make an off-chain transfer if the target wallet address is from Bybit. This means that no blockchain fee will be charged.
     * <p>
     * DANGER
     * UTA does not have SPOT account
     * How do I know if my account is a UTA account? Call this endpoint, and if uta=1, then it is a UTA account.
     * CAUTION
     * Make sure you have whitelisted your wallet address here
     * Can query by the master UID's api key only
     * FORMULA
     * feeType=0:
     * <p>
     * withdrawPercentageFee != 0: handlingFee = inputAmount / (1 - withdrawPercentageFee) * withdrawPercentageFee + withdrawFee
     * withdrawPercentageFee = 0: handlingFee = withdrawFee
     * feeType=1:
     * <p>
     * withdrawPercentageFee != 0: handlingFee = withdrawFee + (inputAmount - withdrawFee) * withdrawPercentageFee
     * withdrawPercentageFee = 0: handlingFee = withdrawFee
     * <p>
     * https://bybit-exchange.github.io/docs/v5/asset/withdraw#http-request
     *
     * @param assetWithdrawRequest coin	true	string	Coin, uppercase only
     *                             chain	false	string	Chain
     *                             forceChain=0 or 1: this field is required
     *                             forceChain=2: this field can be null
     *                             address	true	string
     *                             forceChain=0 or 1: fill wallet address, and make sure you add address in the address book first. Please note that the address is case sensitive, so use the exact same address added in address book
     *                             forceChain=2: fill Bybit UID, and it can only be another Bybit main account UID. Make sure you add UID in the address book first
     *                             tag	false	string	Tag
     *                             Required if tag exists in the wallet address list.
     *                             Note: please do not set a tag/memo in the address book if the chain does not support tag
     *                             amount	true	string	Withdraw amount
     *                             timestamp	true	integer	Current timestamp (ms). Used for preventing from withdraw replay
     *                             forceChain	false	integer	Whether or not to force an on-chain withdrawal
     *                             0(default): If the address is parsed out to be an internal address, then internal transfer
     *                             1: Force the withdrawal to occur on-chain
     *                             2: Use UID to withdraw
     *                             accountType	false	string	Select the wallet to be withdrawn from
     *                             SPOT：spot wallet (default)
     *                             FUND：Funding wallet
     *                             feeType	false	integer	Handling fee option
     *                             0(default): input amount is the actual amount received, so you have to calculate handling fee manually
     *                             1: input amount is not the actual amount you received, the system will help to deduct the handling fee automatically
     *                             requestId	false	string	Customised ID, globally unique, it is used for idempotent verification
     *                             A combination of letters (case sensitive) and numbers, which can be pure letters or pure numbers and the length must be between 1 and 32 digits
     *                             beneficiary	false	Object	Travel rule info, only required for kyc=KOR (korean) users
     *                             &gt; vaspEntityId	true	string	Receiver exchange entity Id. Please call this endpoint to get this ID
     *                             &gt; beneficiaryName	false	string	Receiver exchange user KYC name, like John Wilson or Wilson John
     *                             Please refer to target exchange kyc name
     *                             When vaspEntityId="others", this field can be null
     * @return Response Parameters
     * Parameter	Type	Comments
     * id	string	Withdrawal ID
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/v5/asset/withdraw/create")
    Call<Object> createAssetWithdraw(@Body AssetWithdrawRequest assetWithdrawRequest);

    // Asset Convert Endpoints

    /**
     * Get Convert Coin List
     * You can query the coin list of convert from (to).
     *
     * HTTP Request
     * GET /v5/asset/exchange/query-coin-list
     * https://bybit-exchange.github.io/docs/v5/asset/convert/convert-coin-list
     * @param coin  false	string	Coin, uppercase only
     * Convert from coin (coin to sell)
     * when side=0, coin field is ignored
     * @param side    false	integer	0: fromCoin list, the balance is given if you have it; 1: toCoin list (coin to buy)
     *   when side=1 and coin field is filled, it returns toCoin list based on coin field
     * @param accountType true	string	Wallet type
     *      * eb_convert_funding
     *      * eb_convert_uta
     *      * eb_convert_spot
     *      * eb_convert_contract
     *      * eb_convert_inverse
     * @return Response Parameters
     * Parameter	Type	Comments
     * coins	array object	Coin spec
     * &gt; coin	string	Coin
     * &gt; fullName	string	Full coin name
     * &gt; icon	string	Coin icon url
     * &gt; iconNight	string	Coin icon url (dark mode)
     * &gt; accuracyLength	integer	Coin precision
     * &gt; coinType	string	crypto
     * &gt; balance	string	Coin balance
     * Only when side=0, it checks balance, otherwise, it is ""
     * &gt; uBalance	string	Coin balance in USDT worth value
     * &gt; singleFromMinLimit	string	The minimum amount of fromCoin per transaction
     * &gt; singleFromMaxLimit	string	The maximum amount of fromCoin per transaction
     * &gt; disableFrom	boolean	true: the coin is disabled to be fromCoin, false: the coin is allowed to be fromCoin
     * &gt; disableTo	boolean	true: the coin is disabled to be toCoin, false: the coin is allowed to be toCoin
     * &gt; timePeriod	integer	Reserved field, ignored for now
     * &gt; singleToMinLimit	string	Reserved field, ignored for now
     * &gt; singleToMaxLimit	string	Reserved field, ignored for now
     * &gt; dailyFromMinLimit	string	Reserved field, ignored for now
     * &gt; dailyFromMaxLimit	string	Reserved field, ignored for now
     * &gt; dailyToMinLimit	string	Reserved field, ignored for now
     * &gt; dailyToMaxLimit	string	Reserved field, ignored for now
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/v5/asset/exchange/query-coin-list")
    Call<Object> getConvertCoinList(
            @Query("coin") String coin,
            @Query("side") Integer side,
            @Query("accountType") String accountType);

    /**
     * Get Convert Status
     * You can query the exchange result by sending quoteTxId. Make sure you input correct account type and quoteTxId, otherwise you cannot find it.
     *
     * HTTP Request
     * GET /v5/asset/exchange/convert-result-query
     * https://bybit-exchange.github.io/docs/v5/asset/convert/get-convert-result
     * @param quoteTxId	false	string	Quote tx ID
     * @param accountType	true	string	Wallet type
     * @return Response Parameters
     * Parameter	Type	Comments
     * result	object
     * &gt; accountType	string	Wallet type
     * &gt; exchangeTxId	string	Exchange tx ID, same as quote tx ID
     * &gt; userId	string	User ID
     * &gt; fromCoin	string	From coin
     * &gt; fromCoinType	string	From coin type. crypto
     * &gt; toCoin	string	To coin
     * &gt; toCoinType	string	To coin type. crypto
     * &gt; fromAmount	string	From coin amount (amount to sell)
     * &gt; toAmount	string	To coin amount (amount to buy according to exchange rate)
     * &gt; exchangeStatus	string	Exchange status
     * init
     * processing
     * success
     * failure
     * &gt; extInfo	object	Reserved field, ignored for now
     * &gt; convertRate	string	Exchange rate
     * &gt; createdAt	string	Quote created time
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/v5/asset/exchange/convert-result-query")
    Call<Object> getConvertCoinStatus(
            @Query("quoteTxId") String quoteTxId,
            @Query("accountType") String accountType);

    /**
     * Get Convert history
     * Those confirmed quotes no matter status are showns by this API.
     *
     * INFO
     * Only display the conversion history created through open API.
     *
     * HTTP Request
     * GET /v5/asset/exchange/query-convert-history
     * https://bybit-exchange.github.io/docs/v5/asset/convert/get-convert-history
     * @param accountType	false	string	Wallet type
     *  Supports passing multiple types, separated by comma e.g., eb_convert_funding,eb_convert_uta
     *  Return all wallet types data if not passed
     * @param index    false	integer	Page number
     * started from 1
     * 1st page by default
     * @param limit    false	integer	Page size
     * 20 records by default
     * up to 100 records, return 100 when exceeds 100
     * @return Response Parameters
     * Parameter	Type	Comments
     * list	array object	Array of quotes
     * &gt; accountType	string	Wallet type
     * &gt; exchangeTxId	string	Exchange tx ID, same as quote tx ID
     * &gt; userId	string	User ID
     * &gt; fromCoin	string	From coin
     * &gt; fromCoinType	string	From coin type. crypto
     * &gt; toCoin	string	To coin
     * &gt; toCoinType	string	To coin type. crypto
     * &gt; fromAmount	string	From coin amount (amount to sell)
     * &gt; toAmount	string	To coin amount (amount to buy according to exchange rate)
     * &gt; exchangeStatus	string	Exchange status
     * init
     * processing
     * success
     * failure
     * &gt; extInfo	object	Reserved field, ignored for now
     * &gt; convertRate	string	Exchange rate
     * &gt; createdAt	string	Quote created time
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/v5/asset/exchange/query-convert-history")
    Call<Object> getConvertCoinHistory(
            @Query("accountType") String accountType,
            @Query("index") Integer index,
            @Query("limit") Integer limit);

    /**
     * Request a Quote
     * HTTP Request
     * POST /v5/asset/exchange/quote-apply
     * https://bybit-exchange.github.io/docs/v5/asset/convert/apply-quote
     * Request Parameters
     * Parameter	Required	Type	Comments
     * fromCoin	true	string	Convert from coin (coin to sell)
     * toCoin	true	string	Convert to coin (coin to buy)
     * fromCoinType	false	string	crypto
     * toCoinType	false	string	crypto
     * requestCoin	true	string	Request coin, same as fromCoin
     * In the future, we may support requestCoin=toCoin
     * requestAmount	true	string	request coin amount (the amount you want to sell)
     * accountType	true	string	Wallet type
     * requestId	false	string	Customised request ID
     * a maximum length of 36
     * Generally it is useless, but it is convenient to track the quote request internally if you fill this field
     * @param assetQuoteRequest
     * @return Response Parameters
     * Parameter	Type	Comments
     * quoteTxId	string	Quote transaction ID. It is system generated, and it is used to confirm quote and query the result of transaction
     * exchangeRate	string	Exchange rate
     * fromCoin	string	From coin
     * fromCoinType	string	From coin type. crypto
     * toCoin	string	To coin
     * toCoinType	string	To coin type. crypto
     * fromAmount	string	From coin amount (amount to sell)
     * toAmount	string	To coin amount (amount to buy according to exchange rate)
     * expiredTime	string	The expiry time for this quote (15 seconds)
     * requestId	string	Customised request ID
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/v5/asset/exchange/quote-apply")
    Call<Object> requestQuote(@Body AssetQuoteRequest assetQuoteRequest);

    /**
     * Confirm a Quote
     * INFO
     * The exchange is async, please check the final status by calling query result API.
     * Make sure you confirm the quote before the quote is expired.
     * HTTP Request
     * POST /v5/asset/exchange/convert-execute
     * https://bybit-exchange.github.io/docs/v5/asset/convert/confirm-quote
     * @param quoteTxId	true	string	The quote tx ID from Request a Quote
     * @return Response Parameters
     * Parameter	Type	Comments
     * quoteTxId	string	Quote transaction ID
     * exchangeStatus	string	Exchange status
     * init
     * processing
     * success
     * failure
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/v5/asset/exchange/convert-execute")
    Call<Object> confirmQuote(@Body Map<String, String> quoteTxId);

    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/v5/asset/exchange/convert-execute")
    Call<Object> confirmQuote(@Body ConfirmQuoteRequest confirmQuoteRequest);
    
    // Institution Endpoints

    /**
     * Bind Or Unbind UID
     * For the institutional loan product, you can bind new UIDs to the risk unit or unbind UID from the risk unit.
     * <p>
     * INFO
     * Risk unit designated UID cannot be unbound
     * This endpoint can only be called by uids in the risk unit list
     * The UID must be upgraded to UTA Pro if you try to bind it.
     * https://bybit-exchange.github.io/docs/v5/otc/bind-uid
     *
     * @param updateInstitutionLoadUidRequest
     * @return Response Parameters
     * Parameter	Type	Comments
     * uid	string	UID
     * operate	string	0: bind, 1: unbind
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/v5/ins-loan/association-uid")
    Call<Object> updateInstitutionLoanUid(@Body UpdateInstitutionLoadUidRequest updateInstitutionLoadUidRequest);

    /**
     * Get Product Info
     * TIP
     * This endpoint can be queried without api key and secret, then it returns public product data
     * If your uid is bound with OTC loan product, then you can get your private product data by calling the endpoint with api key and secret
     * If your uid is not bound with OTC loan product but api key and secret are also passed, it will return public data only
     * <p>
     * https://bybit-exchange.github.io/docs/v5/otc/margin-product-info
     *
     * @param productId false	string	Product Id. If not passed, then return all products info
     * @return Response Parameters
     * Parameter	Type	Comments
     * marginProductInfo	array	Object
     * &gt; productId	string	Product Id
     * &gt; leverage	string	The maximum leverage for this loan product
     * &gt; supportSpot	integer	Whether to support Spot. 0:false; 1:true
     * &gt; supportContract	integer	Whether to support USDT Perpetual. 0:false; 1:true
     * &gt; supportMarginTrading	integer	Whether to support Spot margin trading. 0:false; 1:true
     * &gt; withdrawLine	string	Restrict line for withdrawal
     * &gt; transferLine	string	Restrict line for transfer
     * &gt; spotBuyLine	string	Restrict line for Spot buy
     * &gt; spotSellLine	string	Restrict line for Spot trading
     * &gt; contractOpenLine	string	Restrict line for USDT Perpetual open position
     * &gt; liquidationLine	string	Line for liquidation
     * &gt; stopLiquidationLine	string	Line for stop liquidation
     * &gt; contractLeverage	string	The allowed default leverage for USDT Perpetual
     * &gt; transferRatio	string	The transfer ratio for loan funds to transfer from Spot wallet to Contract wallet
     * &gt; spotSymbols	array	The whitelist of spot trading pairs
     * If supportSpot="0", then it returns "[]"
     * If empty array, then you can trade any symbols
     * If not empty, then you can only trade listed symbols
     * &gt; contractSymbols	array	The whitelist of contract trading pairs
     * If supportContract="0", then it returns "[]"
     * If empty array, then you can trade any symbols
     * If not empty, then you can only trade listed symbols
     * &gt; supportUSDCContract	integer	Whether to support USDC contract. '0':false; '1':true
     * &gt; supportUSDCOptions	integer	Whether to support Option. '0':false; '1':true
     * &gt; USDTPerpetualOpenLine	string	Restrict line to open USDT Perpetual position
     * &gt; USDCContractOpenLine	string	Restrict line to open USDC Contract position
     * &gt; USDCOptionsOpenLine	string	Restrict line to open Option position
     * &gt; USDTPerpetualCloseLine	string	Restrict line to trade USDT Perpetual
     * &gt; USDCContractCloseLine	string	Restrict line to trade USDC Contract
     * &gt; USDCOptionsCloseLine	string	Restrict line to trade Option
     * &gt; USDCContractSymbols	array	The whitelist of USDC contract trading pairs
     * If supportContract="0", then it returns "[]"
     * If no whitelist symbols, it is [], and you can trade any
     * If supportUSDCContract="0", it is []
     * &gt; USDCOptionsSymbols	array	The whitelist of Option symbols
     * If supportContract="0", then it returns "[]"
     * If no whitelisted, it is [], and you can trade any
     * If supportUSDCOptions="0", it is []
     * &gt; marginLeverage	string	The allowable maximum leverage for Spot margin trading. If supportMarginTrading=0, then it returns ""
     * &gt; USDTPerpetualLeverage	array	Object
     * If supportContract="0", it is []
     * If no whitelist USDT perp symbols, it returns all trading symbols and leverage by default
     * If there are whitelist symbols, it return those whitelist data
     * &gt; &gt; symbol	string	Symbol name
     * &gt; &gt; leverage	string	Maximum leverage
     * &gt; USDCContractLeverage	array	Object
     * If supportUSDCContract="0", it is []
     * If no whitelist USDC contract symbols, it returns all trading symbols and leverage by default
     * If there are whitelist symbols, it return those whitelist data
     * &gt; &gt; symbol	string	Symbol name
     * &gt; &gt; leverage	string	Maximum leverage
     */
    @GET("/v5/ins-loan/product-infos")
    Call<Object> getInsProductInfo(@Query("productId") String productId);

    /**
     * Get Margin Coin Info
     * TIP
     * This endpoint can be queried without api key and secret, then it returns public margin data
     * If your uid is bound with OTC loan product, then you can get your private margin data by calling the endpoint with api key and secret
     * If your uid is not bound with OTC loan product but api key and secret are also passed, it will return public data only
     * <p>
     * https://bybit-exchange.github.io/docs/v5/otc/margin-coin-convert-info
     *
     * @param productId false	string	ProductId. If not passed, then return all product margin coin. For spot, it returns coin that convertRation greater than 0.
     * @return Response Parameters
     * Parameter	Type	Comments
     * marginToken	array	Object
     * &gt; productId	string	Product Id
     * &gt; tokenInfo	array	Spot margin coin
     * &gt; &gt; token	string	Margin coin
     * &gt; &gt; convertRatioList	array	Margin coin convert ratio List
     * &gt; &gt; &gt; ladder	string	ladder
     * &gt; &gt; &gt; convertRatio	string	Margin coin convert ratio
     */
    @GET("/v5/ins-loan/ensure-tokens-convert")
    Call<Object> getInsMarginCoinInfo(@Query("productId") String productId);

    /**
     * Get Loan Orders
     * Get loan orders information
     * <p>
     * TIP
     * Get the past 2 years data by default
     * Get up to the past 2 years of data
     * <p>
     * https://bybit-exchange.github.io/docs/v5/otc/loan-info
     *
     * @param orderId   false	string	Loan order id. If not passed, then return all orders, sort by loanTime in descend
     * @param startTime false	integer	The start timestamp (ms)
     * @param endTime   false	integer	The end timestamp (ms)
     * @param limit     false	integer	Limit for data size. [1, 100], Default: 10
     * @return Response Parameters
     * Parameter	Type	Comments
     * loanInfo	array	Object
     * &gt; orderId	string	Loan order ID
     * &gt; orderProductId	string	Product ID
     * &gt; parentUid	string	The uid that used to bind OTC loan product
     * &gt; loanTime	string	Loan timestamp, in milliseconds
     * &gt; loanCoin	string	Loan coin
     * &gt; loanAmount	string	Loan amount
     * &gt; unpaidAmount	string	Unpaid principal
     * &gt; unpaidInterest	string	Unpaid interest
     * &gt; repaidAmount	string	Repaid principal
     * &gt; repaidInterest	string	Repaid interest
     * &gt; interestRate	string	Daily interest rate
     * &gt; status	string	1：outstanding; 2：paid off
     * &gt; leverage	string	The maximum leverage for this loan product
     * &gt; supportSpot	string	Whether to support spot. 0:false; 1:true
     * &gt; supportContract	string	Whether to support contract . 0:false; 1:true
     * &gt; withdrawLine	string	Restrict line for withdrawal
     * &gt; transferLine	string	Restrict line for transfer
     * &gt; spotBuyLine	string	Restrict line for SPOT buy
     * &gt; spotSellLine	string	Restrict line for SPOT sell
     * &gt; contractOpenLine	string	Restrict line for USDT Perpetual open position
     * &gt; liquidationLine	string	Line for liquidation
     * &gt; stopLiquidationLine	string	Line for stop liquidation
     * &gt; contractLeverage	string	The allowed default leverage for USDT Perpetual
     * &gt; transferRatio	string	The transfer ratio for loan funds to transfer from Spot wallet to Contract wallet
     * &gt; spotSymbols	array	The whitelist of spot trading pairs. If there is no whitelist, then "[]"
     * &gt; contractSymbols	array	The whitelist of contract trading pairs
     * If supportContract="0", then this is "[]"
     * If there is no whitelist, this is "[]"
     * &gt; supportUSDCContract	string	Whether to support USDC contract. "0":false; "1":true
     * &gt; supportUSDCOptions	string	Whether to support Option. "0":false; "1":true
     * &gt; supportMarginTrading	string	Whether to support Spot margin trading. "0":false; "1":true
     * &gt; USDTPerpetualOpenLine	string	Restrict line to open USDT Perpetual position
     * &gt; USDCContractOpenLine	string	Restrict line to open USDC Contract position
     * &gt; USDCOptionsOpenLine	string	Restrict line to open Option position
     * &gt; USDTPerpetualCloseLine	string	Restrict line to trade USDT Perpetual position
     * &gt; USDCContractCloseLine	string	Restrict line to trade USDC Contract position
     * &gt; USDCOptionsCloseLine	string	Restrict line to trade Option position
     * &gt; USDCContractSymbols	array	The whitelist of USDC contract trading pairs
     * If no whitelist symbols, it is [], and you can trade any
     * If supportUSDCContract="0", it is []
     * &gt; USDCOptionsSymbols	array	The whitelist of Option symbols
     * If no whitelisted, it is [], and you can trade any
     * If supportUSDCOptions="0", it is []
     * &gt; marginLeverage	string	The allowable maximum leverage for Spot margin
     * &gt; USDTPerpetualLeverage	array	Object
     * If supportContract="0", it is []
     * If no whitelist USDT perp symbols, it returns all trading symbols and leverage by default
     * If there are whitelist symbols, it return those whitelist data
     * &gt; &gt; symbol	string	Symbol name
     * &gt; &gt; leverage	string	Maximum leverage
     * &gt; USDCContractLeverage	array	Object
     * If supportUSDCContract="0", it is []
     * If no whitelist USDC contract symbols, it returns all trading symbols and leverage by default
     * If there are whitelist symbols, it return those whitelist data
     * &gt; &gt; symbol	string	Symbol name
     * &gt; &gt; leverage	string	Maximum leverage
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/v5/ins-loan/loan-order")
    Call<Object> getInsLoanOrders(@Query("orderId") String orderId,
                                  @Query("startTime") Long startTime,
                                  @Query("endTime") Long endTime,
                                  @Query("limit") Integer limit);

    /**
     * Get Repay Orders
     * Get repaid order information
     * <p>
     * TIP
     * Get the past 2 years data by default
     * Get up to the past 2 years of data
     * <p>
     * https://bybit-exchange.github.io/docs/v5/otc/repay-info
     *
     * @param startTime false	integer	The start timestamp (ms)
     * @param endTime   false	integer	The end timestamp (ms)
     * @param limit     false	integer	Limit for data size. [1, 100]. Default: 100
     * @return Response Parameters
     * Parameter	Type	Comments
     * repayInfo	array	Object
     * &gt; repayOrderId	string	Repaid order ID
     * &gt; repaidTime	string	Repaid timestamp (ms)
     * &gt; token	string	Repaid coin
     * &gt; quantity	string	Repaid principle
     * &gt; interest	string	Repaid interest
     * &gt; businessType	string	Repaid type. 1：normal repayment; 2：repaid by liquidation
     * &gt; status	string	1：outstanding; 2：paid off
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/v5/ins-loan/repaid-history")
    Call<Object> getInsRepayOrders(@Query("startTime") Long startTime,
                                   @Query("endTime") Long endTime,
                                   @Query("limit") Integer limit);

    /**
     * Get LTV
     * Get LTV
     * <p>
     * https://bybit-exchange.github.io/docs/v5/otc/ltv-convert
     *
     * @return Response Parameters
     * Parameter	Type	Comments
     * ltvInfo	array	Object
     * &gt; ltv	string	Risk rate
     * &gt; parentUid	string	The uid that used to bind OTC loan product
     * &gt; subAccountUids	array	Bound user id
     * &gt; unpaidAmount	string	Total debt(USDT)
     * &gt; unpaidInfo	array	Debt details
     * &gt; &gt; token	string	coin
     * &gt; &gt; unpaidQty	string	Unpaid principle
     * &gt; &gt; unpaidInterest	string	Useless field, please ignore this for now
     * &gt; balance	string	Total asset. (margin coins converted to USDT). Please read here to understand the calculation
     * &gt; balanceInfo	array	Asset details
     * &gt; &gt; token	string	Margin coin
     * &gt; &gt; price	string	Margin coin price
     * &gt; &gt; qty	string	Margin coin quantity
     * &gt; &gt; convertedAmount	string	Margin conversion amount
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/v5/ins-loan/ltv-convert")
    Call<Object> getInsLoanToValue();

    // Spot Data endpoints
    // Spot Leverage

    /**
     * Get Leverage Token Info
     * Query leverage token information
     * <p>
     * https://bybit-exchange.github.io/docs/v5/lt/leverage-token-info#http-request
     *
     * @param ltCoin false	string	Abbreviation of the LT, such as BTC3L
     * @return Response Parameters
     * Parameter	Type	Comments
     * list	array	Object
     * &gt; ltCoin	string	Abbreviation
     * &gt; ltName	string	Full name of leveraged token
     * &gt; maxPurchase	string	Single maximum purchase amount
     * &gt; minPurchase	string	Single minimum purchase amount
     * &gt; maxPurchaseDaily	string	Maximum purchase amount in a single day
     * &gt; maxRedeem	string	Single Maximum redemption quantity
     * &gt; minRedeem	string	Single Minimum redemption quantity
     * &gt; maxRedeemDaily	string	Maximum redemption quantity in a single day
     * &gt; purchaseFeeRate	string	Purchase fee rate
     * &gt; redeemFeeRate	string	Redeem fee rate
     * &gt; ltStatus	string	Whether the leverage token can be purchased or redeemed
     * &gt; fundFee	string	Funding fee charged daily for users holding leveraged token
     * &gt; fundFeeTime	string	The time to charge funding fee
     * &gt; manageFeeRate	string	Management fee rate
     * &gt; manageFeeTime	string	The time to charge management fee
     * &gt; value	string	Nominal asset value
     * &gt; netValue	string	Net value
     * &gt; total	string	Total purchase upper limit
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/v5/spot-lever-token/info")
    Call<Object> getSpotLeverageTokenInfo(@Query("ltCoin") String ltCoin);

    /**
     * Get Leveraged Token Market
     * Get leverage token market information
     * <p>
     * https://bybit-exchange.github.io/docs/v5/lt/leverage-token-reference
     *
     * @param ltCoin true	string	Abbreviation of the LT, such as BTC3L
     * @return Response Parameters
     * Parameter	Type	Comments
     * ltCoin	string	Abbreviation of the LT, such as BTC3L
     * nav	string	net value
     * navTime	string	Update time for net asset value (in milliseconds and UTC time zone)
     * circulation	string	Circulating supply in the secondary market
     * basket	string	basket
     * leverage	string	Real leverage calculated by last traded price
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/v5/spot-lever-token/reference")
    Call<Object> getSpotLeverageTokenMarket(@Query("ltCoin") String ltCoin);

    /**
     * Purchase
     * Purchase levearge token
     * <p>
     * https://bybit-exchange.github.io/docs/v5/lt/purchase
     *
     * @param spotLeverageTokenRequest ltCoin	true	string	Abbreviation of the LT, such as BTC3L
     *                                 ltAmount	true	string	Purchase amount
     *                                 serialNo	false	string	Serial number
     * @return Response Parameters
     * Parameter	Type	Comments
     * ltCoin	string	Abbreviation of the LT, such as BTC3L
     * ltOrderStatus	string	Order status. 1: completed, 2: in progress, 3: failed
     * execQty	string	Executed qty of LT
     * execAmt	string	Executed amount of LT
     * amount	string	Purchase amount
     * purchaseId	string	Order ID
     * serialNo	string	Serial number, customised order ID
     * valueCoin	string	Quote coin
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/v5/spot-lever-token/purchase")
    Call<Object> purchaseSpotLeverageToken(@Body SpotLeverageTokenRequest spotLeverageTokenRequest);

    /**
     * Redeem
     * Redeem leverage token
     * <p>
     * https://bybit-exchange.github.io/docs/v5/lt/redeem
     *
     * @param spotLeverageTokenRequest ltCoin	true	string	Abbreviation of the LT, such as BTC3L
     *                                 quantity	ture	string	Redeem quantity of LT
     *                                 serialNo	false	string	Serial number
     * @return Response Parameters
     * Parameter	Type	Comments
     * ltCoin	string	Abbreviation of the LT
     * ltOrderStatus	string	Order status. 1: completed, 2: in progress, 3: failed
     * quantity	string	Quantity
     * execQty	string	LT quantity
     * execAmt	string	Executed amount of LT
     * redeemId	string	Order ID
     * serialNo	string	Serial number
     * valueCoin	string	Quote coin
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/v5/spot-lever-token/redeem")
    Call<Object> redeemSpotLeverageToken(@Body SpotLeverageTokenRequest spotLeverageTokenRequest);

    /**
     * Get Purchase/Redemption Records
     * Get purchase or redeem history
     * <p>
     * https://bybit-exchange.github.io/docs/v5/lt/order-record
     *
     * @param ltCoin      false	string	Abbreviation of the LT, such as BTC3L
     * @param orderId     false	string	Order ID
     * @param startTime   false	integer	The start timestamp (ms)
     * @param endTime     false	integer	The end timestamp (ms)
     * @param limit       false	integer	Limit for data size per page. [1, 500]. Default: 100
     * @param ltOrderType false	integer	LT order type. 1: purchase, 2: redemption
     * @param serialNo    false	string	Serial number
     * @return Response Parameters
     * Parameter	Type	Comments
     * list	array	Object
     * &gt; ltCoin	string	Abbreviation of the LT, such as BTC3L
     * &gt; orderId	string	Order ID
     * &gt; ltOrderType	integer	LT order type. 1: purchase, 2: redeem
     * &gt; orderTime	number	Order time
     * &gt; updateTime	number	Last update time of the order status
     * &gt; ltOrderStatus	string	Order status. 1: completed, 2: in progress, 3: failed
     * &gt; fee	string	Trading fees
     * &gt; amount	string	Order quantity of the LT
     * &gt; value	string	Filled value
     * &gt; valueCoin	string	Quote coin
     * &gt; serialNo	string	Serial number
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/v5/spot-lever-token/order-record")
    Call<Object> getSpotLeverageRecords(@Query("ltCoin") String ltCoin,
                                        @Query("orderId") String orderId,
                                        @Query("startTime") Long startTime,
                                        @Query("endTime") Long endTime,
                                        @Query("limit") Integer limit,
                                        @Query("ltOrderType") Integer ltOrderType,
                                        @Query("serialNo") String serialNo);

    // Spot Margin UTA

    /**
     * Get VIP Margin Data
     * This margin data is for Unified account in particular.
     * <p>
     * INFO
     * Do not need authentication
     * <p>
     * https://bybit-exchange.github.io/docs/v5/spot-margin-uta/vip-margin
     *
     * @param vipLevel false	string	Vip level
     * @param currency false	string	Coin name
     * @return Response Parameters
     * Parameter	Type	Comments
     * vipCoinList	array	Object
     * &gt; list	array	Object
     * &gt; &gt; borrowable	boolean	Whether it is allowed to be borrowed
     * &gt; &gt; collateralRatio	string	Collateral ratio
     * &gt; &gt; currency	string	Coin name
     * &gt; &gt; hourlyBorrowRate	string	Borrow interest rate per hour
     * &gt; &gt; liquidationOrder	string	Liquidation order
     * &gt; &gt; marginCollateral	boolean	Whether it can be used as a margin collateral currency
     * &gt; &gt; maxBorrowingAmount	string	Max borrow amount
     * &gt; vipLevel	string	Vip level
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/v5/spot-margin-trade/data")
    Call<Object> getUtaVipSpotMarginTradeData(@Query("vipLevel") String vipLevel,
                                              @Query("currency") String currency);

    /**
     * Toggle Margin Trade
     * Turn on / off spot margin trade
     * <p>
     * Covers: Margin trade (Unified Account)
     * <p>
     * CAUTION
     * Your account needs to activate spot margin first; i.e., you must have finished the quiz on web / app.
     * <p>
     * https://bybit-exchange.github.io/docs/v5/spot-margin-uta/switch-mode
     *
     * @param spotMarginMode spotMarginMode	true	string	1: on, 0: off
     * @return Response Parameters
     * Parameter	Type	Comments
     * spotMarginMode	string	Spot margin status. 1: on, 0: off
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/v5/spot-margin-trade/switch-mode")
    Call<Object> setUTASpotMarginTrade(@Body Map<String, String> spotMarginMode);

    /**
     * Set Leverage
     * Set the user's maximum leverage in spot cross margin
     * <p>
     * Covers: Margin trade (Unified Account)
     * <p>
     * CAUTION
     * Your account needs to activate spot margin first; i.e., you must have finished the quiz on web / app.
     * <p>
     * https://bybit-exchange.github.io/docs/v5/spot-margin-uta/set-leverage
     *
     * @param leverage leverage	true	string	Leverage. [2, 10].
     * @return Response Parameters
     * None
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/v5/spot-margin-trade/set-leverage")
    Call<Object> setUTASpotMarginTradeLeverage(@Body Map<String, String> leverage);

    /**
     * Get Status And Leverage
     * Query the Spot margin status and leverage of Unified account
     * <p>
     * Covers: Margin trade (Unified Account)
     * <p>
     * https://bybit-exchange.github.io/docs/v5/spot-margin-uta/status
     *
     * @return Response Parameters
     * Parameter	Type	Comments
     * spotLeverage	string	Spot margin leverage. Returns "" if the margin trade is turned off
     * spotMarginMode	string	Spot margin status. 1: on, 0: off
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/v5/spot-margin-trade/state")
    Call<Object> getUTASpotMarginTradeLeverageState();

    // Spot Margin Normal

    /**
     * Get VIP Margin Data
     * This margin data is for Classic account in particular.
     * <p>
     * INFO
     * Do not need authentication
     * <p>
     * https://bybit-exchange.github.io/docs/v5/spot-margin-normal/vip-margin#http-request
     *
     * @param vipLevel false	string	Vip level
     * @param currency false	string	Coin name
     * @return Response Parameters
     * Parameter	Type	Comments
     * vipCoinList	array	Object
     * &gt; list	array	Object
     * &gt; &gt; borrowable	boolean	Whether it is allowed to be borrowed
     * &gt; &gt; collateralRatio	string	Collateral ratio
     * &gt; &gt; currency	string	Coin name
     * &gt; &gt; hourlyBorrowRate	string	Borrow interest rate per hour
     * &gt; &gt; liquidationOrder	string	Liquidation order
     * &gt; &gt; marginCollateral	boolean	Whether it can be used as a margin collateral currency
     * &gt; &gt; maxBorrowingAmount	string	Max borrow amount
     * &gt; vipLevel	string	Vip level
     */
    @Deprecated
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/v5/spot-cross-margin-trade/data")
    Call<Object> getNormalVipSpotMarginTradeData(@Query("vipLevel") String vipLevel,
                                                 @Query("currency") String currency);

    /**
     * Get Margin Coin Info
     * INFO
     * Do not need authentication
     * <p>
     * https://bybit-exchange.github.io/docs/v5/spot-margin-normal/margin-data#http-request
     *
     * @param coin false	string	Coin name
     * @return Response Parameters
     * Parameter	Type	Comments
     * list	array	Object
     * &gt; coin	string	Coin name
     * &gt; conversionRate	string	Convert ratio
     * &gt; liquidationOrder	integer	Liquidation order
     */
    @Deprecated
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/v5/spot-cross-margin-trade/pledge-token")
    Call<Object> getNormalSpotMarginTradeCoinInfo(@Query("coin") String coin);

    /**
     * Get Borrowable Coin Info
     * INFO
     * Do not need authentication
     * <p>
     * https://bybit-exchange.github.io/docs/v5/spot-margin-normal/borrowable-data
     *
     * @param coin false	string	Coin name
     * @return Request Parameters
     * Parameter	Required	Type	Comments
     * coin	false	string	Coin name
     * Response Parameters
     * Parameter	Type	Comments
     * list	array	Object
     * &gt; coin	string	Coin name
     * &gt; borrowingPrecision	integer	Accuracy of loan amount
     * &gt; repaymentPrecision	integer	Accuracy of repayment amount
     */
    @Deprecated
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/v5/spot-cross-margin-trade/borrow-token")
    Call<Object> getNormalSpotMarginTradeBorrowCoinInfo(@Query("coin") String coin);

    /**
     * Get Interest and  Quota
     * Covers: Margin trade (Classic Account)
     * <p>
     * https://bybit-exchange.github.io/docs/v5/spot-margin-normal/interest-quota#http-request
     *
     * @param coin true	string	Coin name
     * @return Response Parameters
     * Parameter	Type	Comments
     * coin	string	Coin name
     * interestRate	string	Daily interest rate
     * loanAbleAmount	string	The estimated amount can be loaned
     * maxLoanAmount	string	The fixed loanable amount per user on platform
     */
    @Deprecated
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/v5/spot-cross-margin-trade/loan-info")
    Call<Object> getNormalSpotMarginTradeInterestQuota(@Query("coin") String coin);

    /**
     * Get Loan Account Info
     * Covers: Margin trade (Classic Account)
     * <p>
     * https://bybit-exchange.github.io/docs/v5/spot-margin-normal/account-info
     *
     * @return Response Parameters
     * Parameter	Type	Comments
     * acctBalanceSum	string	Total equity (BTC)
     * debtBalanceSum	string	Total liability (BTC)
     * loanAccountList	array	Object
     * &gt; free	string	Available balance
     * &gt; interest	string	Outstanding interest
     * &gt; loan	string	Outstanding principle
     * &gt; remainAmount	string	Remaining debt = interest + loan
     * &gt; locked	string	Locked amount
     * &gt; tokenId	string	Coin name
     * &gt; total	string	Total
     * riskRate	string	Risk rate
     * status	integer	Loan account status
     * 1: normal
     * 2: withdrawal/transfer restricted
     * 3: liquidation alert triggered
     * 4: liquidated
     * switchStatus	integer	0: margin trade off, 1: margin trade on
     */
    @Deprecated
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/v5/spot-cross-margin-trade/account")
    Call<Object> getNormalSpotMarginTradeAccountInfo();

    /**
     * Toggle Margin Trade
     * Turn on / off spot margin trade
     * <p>
     * Covers: Margin trade (Classic Account)
     * <p>
     * https://bybit-exchange.github.io/docs/v5/spot-margin-normal/switch-mode#http-request
     *
     * @param switchStatus switch	true	integer	1: on, 0: off
     * @return Response Parameters
     * Parameter	Type	Comments
     * switchStatus	integer	Margin trade status. 1: on, 0: off
     */
    @Deprecated
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/v5/spot-cross-margin-trade/switch")
    Call<Object> setNormalSpotToggleMarginTrade(@Body int switchStatus);

    /**
     * Borrow
     * Covers: Margin trade (Classic Account)
     * <p>
     * https://bybit-exchange.github.io/docs/v5/spot-margin-normal/borrow#http-request
     *
     * @param spotMarginTradeBorrowRequest coin	true	string	Coin name
     *                                     qty	true	string	Amount to borrow
     * @return Response Parameters
     * Parameter	Type	Comments
     * transactId	string	Borrow transaction ID
     */
    @Deprecated
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/v5/spot-cross-margin-trade/loan")
    Call<Object> loanNormalSpotMarginTrade(@Body SpotMarginTradeBorrowRequest spotMarginTradeBorrowRequest);

    /**
     * Repay
     * Covers: Margin trade (Classic Account)
     * <p>
     * https://bybit-exchange.github.io/docs/v5/spot-margin-normal/repay#http-request
     *
     * @param spotMarginTradeRePayRequest coin	true	string	Coin name
     *                                    qty	false	string	Amount to repay
     *                                    qty is required when completeRepayment=0
     *                                    qty is invalid when completeRepayment=1
     *                                    completeRepayment	false	integer	Whether to pay off all debts. 0(default): false, 1: true
     * @return Response Parameters
     * Parameter	Type	Comments
     * repayId	string	Repayment transaction ID
     */
    @Deprecated
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/v5/spot-cross-margin-trade/repay")
    Call<Object> repayNormalSpotMarginTrade(@Body SpotMarginTradeRePayRequest spotMarginTradeRePayRequest);

    /**
     * Get Borrow Order Detail
     * Covers: Margin trade (Classic Account)
     * <p>
     * https://bybit-exchange.github.io/docs/v5/spot-margin-normal/borrow-order#http-request
     *
     * @param startTime false	long	The start timestamp (ms)
     * @param endTime   false	long	The end timestamp (ms)
     * @param coin      false	string	Coin name
     * @param status    false	integer	Status
     *                  0(default)：get all kinds of status
     *                  1：uncleared
     *                  2：cleared
     * @param limit     false	integer	Limit for data size per page. [1, 500]. Default: 500
     * @return Response Parameters
     * Parameter	Type	Comments
     * list	array	Object
     * &gt; accountId	string	Account ID
     * &gt; coin	string	Coin name
     * &gt; createdTime	number	Borrow order created timestamp (ms)
     * &gt; id	string	Borrow order ID
     * &gt; interestAmount	string	Total interest
     * &gt; interestBalance	string	Outstanding interest
     * &gt; loanAmount	string	Principal amount
     * &gt; loanBalance	string	Outstanding principal
     * &gt; remainAmount	string	Remaining debt = interestBalance + loanBalance
     * &gt; status	integer	Status 1：uncleared, 2：cleared
     * &gt; type	integer	Order Type 1: manual loan, 2: auto loan
     */
    @Deprecated
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/v5/spot-cross-margin-trade/orders")
    Call<Object> getNormalMarginTradeBorrowOrders(@Query("startTime") Long startTime,
                                                  @Query("endTime") Long endTime,
                                                  @Query("coin") String coin,
                                                  @Query("status") Integer status,
                                                  @Query("limit") Integer limit);

    /**
     * Get Repayment Order Detail
     * Covers: Margin trade (Classic Account)
     * <p>
     * https://bybit-exchange.github.io/docs/v5/spot-margin-normal/repay-order#http-request
     *
     * @param startTime false	long	The start timestamp (ms)
     * @param endTime   false	long	The end timestamp (ms)
     * @param coin      false	string	Coin name
     * @param limit     false	integer	Limit for data size per page. [1, 500], Default: 500
     * @return Response Parameters
     * Parameter	Type	Comments
     * list	array	Object
     * &gt; accountId	string	Account ID
     * &gt; coin	string	Coin name
     * &gt; repaidAmount	string	Repaid amount
     * &gt; repayId	string	Repay ID
     * &gt; repayMarginOrderId	string	Repay margin order ID
     * &gt; repayTime	string	Repay timestamp (ms)
     * &gt; transactIds	array	Object
     * &gt; &gt; repaidInterest	string	Interest repaid
     * &gt; &gt; repaidPrincipal	string	Principal repaid
     * &gt; &gt; repaidSerialNumber	string	Repayment No. (Borrowing Order)
     * &gt; &gt; transactId	string	Borrowing transaction ID
     */
    @Deprecated
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/v5/spot-cross-margin-trade/repay-history")
    Call<Object> getNormalMarginTradeRepayOrders(@Query("startTime") Long startTime,
                                                 @Query("endTime") Long endTime,
                                                 @Query("coin") String coin,
                                                 @Query("limit") Integer limit);

    // Broker Endpoints

    /**
     * Get Broker Earning
     * INFO
     * Use exchange broker master account to query
     * The data can support up to past 6 months until T-1
     * startTime and  endTime are either entered at the same time or not entered
     * <p>
     * https://bybit-exchange.github.io/docs/v5/broker/earning
     *
     * @param bizType   false	string	Business type. SPOT, DERIVATIVES, OPTIONS
     * @param startTime false	integer	The start timestamp(ms)e
     * @param endTime   false	integer	The end timestamp(ms)
     * @param limit     false	integer	Limit for data size per page. [1, 1000]. Default: 1000
     * @param cursor    false	string	Cursor. Use the nextPageCursor token from the response to retrieve the next page of the result set
     * @return Response Parameters
     * Parameter	Type	Comments
     * list	array	Object
     * &gt; userId	string	UID
     * &gt; bizType	string	Business type
     * &gt; symbol	string	Symbol name
     * &gt; coin	string	Coin name. The currency of earning
     * &gt; earning	string	Earning
     * &gt; orderId	string	Order ID
     * &gt; execTime	string	Execution timestamp (ms)
     * nextPageCursor	string	Refer to the cursor request parameter
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/v5/broker/earnings-info")
    Call<Object> getBrokerEarningData(@Query("bizType") String bizType,
                                      @Query("startTime") Long startTime,
                                      @Query("endTime") Long endTime,
                                      @Query("limit") Integer limit,
                                      @Query("cursor") String cursor);

    /**
     * Get Sub Account Deposit Records
     * Exchange broker can query subaccount's deposit records by main UID's API key without specifying uid.
     * API rate limit: 300 req / min
     * TIP
     * endTime - startTime should be less than 30 days. Queries for the last 30 days worth of records by default.
     * HTTP Request
     * GET /v5/broker/asset/query-sub-member-deposit-record
     *
     * @param subMemberId   false	Sub UID
     * @param coin false String Coin, uppercase only
     * @param startTime   false	integer	The start  timestamp(ms)
     * @param endTime   false	integer	The end timestamp(ms)
     * @param limit     false	integer	Limit for data size per page. [1, 50]. Default: 50
     * @param cursor    false	string	Cursor. Use the nextPageCursor token from the response to retrieve the next page of the result set
     * @return Response Parameters
     * Parameter	Type	Comments
     * rows	array	Object
     * &gt; subMemberId	string	Sub account user ID
     * &gt; coin	string	Coin
     * &gt; chain	string	Chain
     * &gt; amount	string	Amount
     * &gt; txID	string	Transaction ID
     * &gt; status	integer	Deposit status
     * &gt; toAddress	string	Deposit target address
     * &gt; tag	string	Tag of deposit target address
     * &gt; depositFee	string	Deposit fee
     * &gt; successAt	string	Last updated time
     * &gt; confirmations	string	Number of confirmation blocks
     * &gt; txIndex	string	Transaction sequence number
     * &gt; blockHash	string	Hash number on the chain
     * &gt; batchReleaseLimit	string	The deposit limit for this coin in this chain. "-1" means no limit
     * &gt; depositType	string	The deposit type. 0: normal deposit, 10: the deposit reaches daily deposit limit, 20: abnormal deposit
     * nextPageCursor	string	Refer to the cursor request parameter
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/v5/broker/asset/query-sub-member-deposit-record")
    Call<Object> getBrokerSubDeposits(@Query("subMemberId") String subMemberId,
                                      @Query("coin") String coin,
                                      @Query("startTime") Long startTime,
                                      @Query("endTime") Long endTime,
                                      @Query("limit") Integer limit,
                                      @Query("cursor") String cursor);

    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/v5/broker/asset/query-sub-member-deposit-record")
    Call<Object> getBrokerSubDeposits();

    /**
     * Get Exchange Broker Account Info
     * INFO
     * Use exchange broker master account to query
     * API rate limit: 10 req / sec
     * https://bybit-exchange.github.io/docs/v5/broker/account-info
     *
     * @return Response Parameters
     * Parameter	Type	Comments
     * subAcctQty	string	The qty of subaccount has been created
     * maxSubAcctQty	string	The max limit of subaccount can be created
     * baseFeeRebateRate	Object	Rebate percentage of the base fee
     * &gt; spot	string	Rebate percentage of the base fee for spot, e.g., 10.00%
     * &gt; derivatives	string	Rebate percentage of the base fee for derivatives, e.g., 10.00%
     * markupFeeRebateRate	Object	Rebate percentage of the mark-up fee
     * &gt; spot	string	Rebate percentage of the mark-up fee for spot, e.g., 10.00%
     * &gt; derivatives	string	Rebate percentage of the mark-up fee for derivatives, e.g., 10.00%
     * ts	string	System timestamp (ms)
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/v5/broker/account-info")
    Call<Object> getBrokerAccountInfo();

    /**
     * Query Voucher Spec
     * HTTP Request
     * POST /v5/broker/award/info
     *
     * https://bybit-exchange.github.io/docs/v5/broker/reward/voucher
     *
     * @param voucherSpecRequest id	true	string	Voucher ID
     * @return Response Parameters
     * Parameter	Type	Comments
     * id	string	Voucher ID
     * coin	string	Coin
     * amountUnit	string
     * AWARD_AMOUNT_UNIT_USD
     * AWARD_AMOUNT_UNIT_COIN
     * productLine	string	Product line
     * subProductLine	string	Sub product line
     * totalAmount	Object	Total amount of voucher
     * usedAmount	string	Used amount of voucher
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/v5/broker/award/info")
    Call<Object> getVoucherSpec(@Body BrokerVoucherSpecRequest voucherSpecRequest);

    /**
     * Issue Voucher
     * HTTP Request
     * POST /v5/broker/award/distribute-award
     * https://bybit-exchange.github.io/docs/v5/broker/reward/issue-voucher
     * @param issueVoucherRequest   accountId	true	string	User ID
     *                              awardId	true	string	Voucher ID
     *                              specCode	true	string	Customised unique spec code, up to 8 characters
     *                              amount	true	string	Issue amount
     *                              Spot airdrop supports up to 16 decimals
     *                              Other types supports up to 4 decimals
     *                              brokerId	true	string	Broker ID
     * @return None
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/v5/broker/award/distribute-award")
    Call<Object> issueVoucher(@Body BrokerIssueVoucherRequest issueVoucherRequest);

    /**
     * Query Issued Voucher
     * HTTP Request
     * POST /v5/broker/award/distribution-record
     * https://bybit-exchange.github.io/docs/v5/broker/reward/get-issue-voucher
     * @param getIssuedVoucherRequest accountId	true	string	User ID
     *                                  awardId	true	string	Voucher ID
     *                                  specCode	true	string	Customised unique spec code, up to 8 characters
     *                                  withUsedAmount	false	boolean	Whether to return the amount used by the user
     * @return Response Parameters
     * Parameter	Type	Comments
     * accountId	string	User ID
     * awardId	string	Voucher ID
     * specCode	string	Spec code
     * amount	string	Amount of voucher
     * isClaimed	boolean	true, false
     * startAt	string	Claim start timestamp (sec)
     * endAt	string	Claim end timestamp (sec)
     * effectiveAt	string	Voucher effective timestamp (sec) after claimed
     * ineffectiveAt	string	Voucher inactive timestamp (sec) after claimed
     * usedAmount	string	Amount used by the user
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/v5/broker/award/distribution-record")
    Call<Object> getIssuedVoucher(@Body BrokerGetIssuedVoucherRequest getIssuedVoucherRequest);

    // C2C Endpoints

    /**
     * Get the basic information of lending coins
     * <p>
     * INFO
     * All v5/lending APIs need SPOT permission.
     * <p>
     * https://bybit-exchange.github.io/docs/v5/c2c-lend/coin-info
     *
     * @param coin false	string	Coin name. Return all currencies by default
     * @return Response Parameters
     * Parameter	Type	Comments
     * list	array	Object
     * &gt; coin	string	Coin name
     * &gt; maxRedeemQty	string	The maximum redeemable qty per day (measured from 0 - 24 UTC)
     * &gt; minPurchaseQty	string	The minimum qty that can be deposited per request
     * &gt; precision	string	Deposit quantity accuracy
     * &gt; rate	string	Annualized interest rate. e.g. 0.0002 means 0.02%
     * &gt; loanToPoolRatio	string	Capital utilization rate. e.g. 0.0004 means 0.04%
     * &gt; actualApy	string	The actual annualized interest rate
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/v5/lending/info")
    @Deprecated
    Call<Object> getC2CLendingCoinInfo(@Query("coin") String coin);

    /**
     * Deposit Funds
     * Lending funds to Bybit asset pool
     * <p>
     * INFO
     * normal and  UMA account: deduct funds from Spot wallet
     * UTA account: deduct funds from Unified wallet
     * <p>
     * https://bybit-exchange.github.io/docs/v5/c2c-lend/deposit
     *
     * @param depositFundRequest coin	true	string	Coin name
     *                           quantity	true	string	Deposit quantity
     *                           serialNo	false	string	Customised ID. If not passed, system will create one by default
     * @return Response Parameters
     * Parameter	Type	Comments
     * coin	string	Coin name
     * createdTime	string	Created timestamp (ms)
     * orderId	string	Order ID
     * quantity	string	Deposit quantity
     * serialNo	string	Serial No
     * status	string	Order status. 0: Initial, 1: Processing, 2: Success, 10: Failed
     * updatedTime	string	Updated timestamp (ms)
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/v5/lending/purchase")
    @Deprecated
    Call<Object> C2cLendingDepositFunds(@Body ClientLendingFundsRequest depositFundRequest);

    /**
     * Withdraw funds from the Bybit asset pool.
     * <p>
     * TIP
     * There will be two redemption records: one for the redeemed quantity, and the other one is for the total interest occurred.
     * <p>
     * https://bybit-exchange.github.io/docs/v5/c2c-lend/redeem
     *
     * @param depositFundRequest coin	true	string	Coin name
     *                           quantity	ture	string	Redemption quantity
     *                           serialNo	false	string	Serial no. A customised ID, and it will automatically generated if not passed
     * @return Response Parameters
     * Parameter	Type	Comments
     * coin	string	Coin name
     * createdTime	string	Created timestamp (ms)
     * orderId	string	Order ID
     * principalQty	string	Redemption quantity
     * serialNo	string	Serial No
     * status	string	Order status. 0: Initial, 1: Processing, 2: Success, 10: Failed
     * updatedTime	string	Updated timestamp (ms)
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/v5/lending/redeem")
    @Deprecated
    Call<Object> C2cLendingRedeemFunds(@Body ClientLendingFundsRequest depositFundRequest);

    /**
     * Cancel Redeem
     * Cancel the withdrawal operation.
     * <p>
     * https://bybit-exchange.github.io/docs/v5/c2c-lend/cancel-redeem
     *
     * @param depositFundRequest coin	false	string	Coin name
     *                           orderId	false	string	The order ID of redemption
     *                           serialNo	false	string	Serial no. The customised ID of redemption
     * @return Response Parameters
     * Parameter	Type	Comments
     * orderId	string	Order ID
     * serialNo	string	Serial No
     * updatedTime	string	Updated timestamp (ms)
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/v5/lending/redeem-cancel")
    @Deprecated
    Call<Object> C2cLendingRedeemCancel(@Body ClientLendingFundsRequest depositFundRequest);

    /**
     * Get Order Records
     * Get lending or redeem history
     * <p>
     * https://bybit-exchange.github.io/docs/v5/c2c-lend/order-record
     *
     * @param coin      false	string	Coin name
     * @param orderId   false	string	Order ID
     * @param startTime false	long	The start timestamp (ms)
     * @param endTime   false	long	The end timestamp (ms)
     * @param limit     false	integer	Limit for data size per page. [1, 500]. Default: 50
     * @param orderType false	string	Order type. 1: deposit, 2: redemption, 3: Payment of proceeds
     * @return Response Parameters
     * Parameter	Type	Comments
     * list	array	Object
     * &gt; coin	string	Coin name
     * &gt; createdTime	string	Created timestamp (ms)
     * &gt; orderId	string	Order ID
     * &gt; quantity	string	quantity
     * &gt; serialNo	string	Serial No
     * &gt; status	string	Order status. 0: Initial, 1: Processing, 2: Success, 10: Failed, 11: Cancelled
     * &gt; updatedTime	string	Updated timestamp (ms)
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/v5/lending/history-order")
    @Deprecated
    Call<Object> getC2cOrdersRecords(@Query("coin") String coin,
                                     @Query("orderId") String orderId,
                                     @Query("startTime") Long startTime,
                                     @Query("endTime") Long endTime,
                                     @Query("limit") Integer limit,
                                     @Query("orderType") String orderType);

    /**
     * Get Lending Account Info
     * <p>
     * https://bybit-exchange.github.io/docs/v5/c2c-lend/account-info
     *
     * @param coin true	string	Coin name
     * @return Response Parameters
     * Parameter	Type	Comments
     * coin	string	Coin name
     * principalInterest	string	User Redeemable interest
     * principalQty	string	Leftover quantity you can redeem for today (measured from 0 - 24 UTC), formula: min(the rest amount of principle, the amount that the user can redeem on the day)
     * principalTotal	string	Total amount redeemable by user
     * quantity	string	Current deposit quantity
     */
    @Headers(BybitApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/v5/lending/account")
    @Deprecated
    Call<Object> getC2CLendingAccountInfo(@Query("coin") String coin);

    // Announcement

    /**
     * Get Announcement
     * <p>
     * https://bybit-exchange.github.io/docs/v5/announcement#http-request
     *
     * @param locale true	string	Language symbol
     * @param type   false	string	Announcement type
     * @param tag    false	string	Announcement tag
     * @param page   false	integer	Page number. Default: 1
     * @param limit  false	integer	Limit for data size per page. Default: 20
     * @return Response Parameters
     * Parameter	Type	Comments
     * total	integer	Total records
     * list	array	Object
     * &gt; title	string	Announcement title
     * &gt; description	string	Announcement description
     * &gt; type	Object
     * &gt; &gt; title	string	The title of announcement type
     * &gt; &gt; key	string	The key of announcement type
     * &gt; tags	array string	The tag of announcement
     * &gt; url	string	Announcement url
     * &gt; dateTimestamp	number	Publish timestamp (ms) of announcement
     * &gt; startDataTimestamp	number	The start timestamp (ms) of the event, only valid when list.type.key == "latest_activities"
     * &gt; endDataTimestamp	number	The end timestamp (ms) of the event, only valid when list.type.key == "latest_activities"
     */
    @GET("/v5/announcements/index")
    Call<Object> getAnouncementInfo(
            @Query("locale") String locale,
            @Query("type") String type,
            @Query("tag") String tag,
            @Query("page") Integer page,
            @Query("limit") Integer limit);
}
