package com.bybit.api.client.service;


import com.bybit.api.client.impl.*;
import com.bybit.api.client.log.LogOption;
import com.bybit.api.client.restApi.*;
import com.bybit.api.client.websocket.httpclient.WebsocketStreamClient;
import com.bybit.api.client.websocket.impl.WebsocketStreamClientImpl;
import com.bybit.api.client.websocket.callback.WebSocketMessageCallback;

import static com.bybit.api.client.config.BybitApiConfig.MAINNET_DOMAIN;
import static com.bybit.api.client.constant.BybitApiConstants.*;

/**
 * A factory for creating BybitApi client objects.
 */
public class BybitApiClientFactory {

    /**
     * API Key
     */
    private final String apiKey;

    /**
     * Secret.
     */
    private final String secret;

    /**
     * BaseUrl
     */
    private final String baseUrl;

    /**
     * DebugMode to print request and response header
     */
    private final Boolean debugMode;

    /**
     * DebugMode log option to print request and response header
     */
    private final String logOption;

    /**
     * recvWindow to print request and response header
     */
    private final Long recvWindow;

    /**
     * broker referer code
     */
    private final String referer;

    /**
     * Instantiates a new Bybit api client factory.
     *
     * @param apiKey    api key
     * @param secret    api secret
     * @param baseUrl   base url
     * @param debugMode debugMode
     */
    private BybitApiClientFactory(String apiKey, String secret, String baseUrl, boolean debugMode, long recvWindow, String logOption, String referer) {
        this.apiKey = apiKey;
        this.secret = secret;
        this.baseUrl = baseUrl;
        this.debugMode = debugMode;
        this.recvWindow = recvWindow;
        this.logOption = logOption;
        this.referer = referer;
    }

    /**
     * New instance of Api Mainnet Client
     *
     * @param apiKey the API key
     * @param secret the Secret
     * @return the Bybit api client factory
     */
    public static BybitApiClientFactory newInstance(String apiKey, String secret) {
        return new BybitApiClientFactory(apiKey, secret, MAINNET_DOMAIN, false, DEFAULT_RECEIVING_WINDOW, LogOption.SLF4J.getLogOptionType(), "");
    }


    /**
     * New instance of Api Mainnet Client with url
     *
     * @param apiKey  the API key
     * @param secret  the Secret
     * @param baseUrl the baseUrl
     * @return the Bybit api client factory.
     */
    public static BybitApiClientFactory newInstance(String apiKey, String secret, String baseUrl) {
        return new BybitApiClientFactory(apiKey, secret, baseUrl, false, DEFAULT_RECEIVING_WINDOW, LogOption.SLF4J.getLogOptionType(), "");
    }

    /**
     *
     * New instance of Api Mainnet Client with receive windows
     *
     * @param apiKey
     * @param secret
     * @param recvWindow
     * @return
     */
    public static BybitApiClientFactory newInstance(String apiKey, String secret, long recvWindow) {
        return new BybitApiClientFactory(apiKey, secret, MAINNET_DOMAIN, false, recvWindow, LogOption.SLF4J.getLogOptionType(), "");
    }

    /**
     * New instance of Api Mainnet Client with debug mode
     *
     * @param apiKey    the API key
     * @param secret    the Secret
     * @param debugMode to print request and response header
     * @return the Bybit api client factory.
     */
    public static BybitApiClientFactory newInstance(String apiKey, String secret, boolean debugMode) {
        return new BybitApiClientFactory(apiKey, secret, MAINNET_DOMAIN, debugMode, DEFAULT_RECEIVING_WINDOW, LogOption.SLF4J.getLogOptionType(), "");
    }

    /**
     * New instance of Api Mainnet Client with broker referer code
     *
     * @param apiKey    the API key
     * @param secret    the Secret
     * @param referer Broker referer code
     * @return the Bybit api client factory.
     */
    public static BybitApiClientFactory newInstance(String apiKey, String secret, String baseUrl, String referer) {
        return new BybitApiClientFactory(apiKey, secret, baseUrl, false, DEFAULT_RECEIVING_WINDOW, LogOption.SLF4J.getLogOptionType(), referer);
    }

    /**
     * New instance of Api Mainnet Client with debug mode and log option
     *
     * @param apiKey
     * @param secret
     * @param debugMode
     * @param logOption
     * @return
     */
    public static BybitApiClientFactory newInstance(String apiKey, String secret, boolean debugMode, String logOption) {
        return new BybitApiClientFactory(apiKey, secret, MAINNET_DOMAIN, debugMode, DEFAULT_RECEIVING_WINDOW, logOption, "");
    }

    public static BybitApiClientFactory newInstance(String apiKey, String secret, boolean debugMode, long recvWindow) {
        return new BybitApiClientFactory(apiKey, secret, MAINNET_DOMAIN, debugMode, recvWindow, LogOption.SLF4J.getLogOptionType(), "");
    }

    public static BybitApiClientFactory newInstance(String apiKey, String secret, boolean debugMode, long recvWindow, String logOption) {
        return new BybitApiClientFactory(apiKey, secret, MAINNET_DOMAIN, debugMode, recvWindow, logOption,  "");
    }

    /**
     *
     * new instance set url with debug mode
     *
     * @param apiKey
     * @param secret
     * @param baseUrl
     * @param debugMode
     * @return
     */
    public static BybitApiClientFactory newInstance(String apiKey, String secret, String baseUrl, boolean debugMode) {
        return new BybitApiClientFactory(apiKey, secret, baseUrl, debugMode, DEFAULT_RECEIVING_WINDOW, LogOption.SLF4J.getLogOptionType(), "");
    }

    /**
     *
     * new instance with base url and receive windows
     *
     * @param apiKey
     * @param secret
     * @param baseUrl
     * @param recvWindow
     * @return
     */
    public static BybitApiClientFactory newInstance(String apiKey, String secret, String baseUrl, long recvWindow) {
        return new BybitApiClientFactory(apiKey, secret, baseUrl, false, recvWindow, LogOption.SLF4J.getLogOptionType(), "");
    }


    /**
     * New instance without authentication.
     *
     * @return the Bybit api client factory
     */
    public static BybitApiClientFactory newInstance() {
        return new BybitApiClientFactory(null, null, MAINNET_DOMAIN, false, DEFAULT_RECEIVING_WINDOW, LogOption.SLF4J.getLogOptionType(), "");
    }

    public static BybitApiClientFactory newInstance(long recvWindow) {
        return new BybitApiClientFactory(null, null, MAINNET_DOMAIN, false, recvWindow, LogOption.SLF4J.getLogOptionType(), "");
    }

    /**
     * New instance without authentication and with optional url
     *
     * @param baseUrl base url
     * @return the Bybit api client factory.
     */
    public static BybitApiClientFactory newInstance(String baseUrl) {
        return new BybitApiClientFactory(null, null, baseUrl, false, DEFAULT_RECEIVING_WINDOW, LogOption.SLF4J.getLogOptionType(), "");
    }

    /**
     * New instance without authentication and with optional debug mode
     *
     * @param debugMode debug mode
     * @return the Bybit api client factory.
     */
    public static BybitApiClientFactory newInstance(boolean debugMode) {
        return new BybitApiClientFactory(null, null, MAINNET_DOMAIN, debugMode, DEFAULT_RECEIVING_WINDOW, LogOption.SLF4J.getLogOptionType(), "");
    }

    public static BybitApiClientFactory newInstance(boolean debugMode, String logOption) {
        return new BybitApiClientFactory(null, null, MAINNET_DOMAIN, debugMode, DEFAULT_RECEIVING_WINDOW, logOption, "");
    }

    /**
     * New instance without authentication and with optional base url and debug mode
     *
     * @param baseUrl   base url
     * @param debugMode debug mode
     * @return the Bybit api client factory.
     */
    public static BybitApiClientFactory newInstance(String baseUrl, boolean debugMode, String logOption) {
        return new BybitApiClientFactory(null, null, baseUrl, debugMode, DEFAULT_RECEIVING_WINDOW, logOption, "");
    }

    public static BybitApiClientFactory newInstance(String baseUrl, boolean debugMode) {
        return new BybitApiClientFactory(null, null, baseUrl, debugMode, DEFAULT_RECEIVING_WINDOW, LogOption.SLF4J.getLogOptionType(), "");
    }

    /**
     * Creates a new synchronous/blocking REST client to spot leverage token and spot margin endpoints.
     */
    public BybitApiSpotMarginRestClient newSpotMarginRestClient() {
        return new BybitApiSpotMarginRestClientImpl(apiKey, secret, baseUrl, debugMode, recvWindow, logOption);
    }


    public BybitApiAsyncSpotMarginRestClient newSpotMarginAsyncRestClient() {
        return new BybitApiAsyncSpotMarginRestClientImpl(apiKey, secret, baseUrl, debugMode, recvWindow, logOption);
    }

    /**
     * Creates a new synchronous/blocking REST client.
     */
    public BybitApiUserRestClient newUserRestClient() {
        return new BybitApiUserRestClientImpl(apiKey, secret, baseUrl, debugMode, recvWindow, logOption);
    }

    /**
     * Creates a new asynchronous/non-blocking REST client to User and upgrade endpoints.
     */
    public BybitApiAsyncUserRestClient newAsyncUserRestClient() {
        return new BybitApiAsyncUserRestClientImpl(apiKey, secret, baseUrl, debugMode, recvWindow, logOption);
    }

    /**
     * Creates a new synchronous/blocking REST client to Market Data Endpoints
     */
    public BybitApiMarketRestClient newMarketDataRestClient() {
        return new BybitApiMarketRestClientImpl(baseUrl, debugMode, recvWindow, logOption);
    }

    /**
     * Creates a new asynchronous/non-blocking client to Market Data Endpoints
     */
    public BybitApiAsyncMarketDataRestClient newAsyncMarketDataRestClient() {
        return new BybitApiMarketAsyncRestClientImpl(baseUrl, debugMode, recvWindow, logOption);
    }

    /**
     * Creates a new synchronous/blocking REST client to Institution and Broker Endpoints
     */
    public BybitApiLendingRestClient newLendingRestClient() {
        return new BybitApiLendingRestClientImpl(apiKey, secret, baseUrl, debugMode, recvWindow, logOption);
    }

    /**
     * Creates a new asynchronous/non-blocking REST client to Institution Lending Endpoints
     */
    public BybitApiAsyncLendingRestClient newAsyncLendingRestClient() {
        return new BybitApiAsyncLendingRestClientImpl(apiKey, secret, baseUrl, debugMode, recvWindow, logOption);
    }

    /**
     * Creates a new synchronous/blocking REST client to trading
     */
    public BybitApiTradeRestClient newTradeRestClient() {
        return new BybitApiTradeRestClientImpl(apiKey, secret, baseUrl, debugMode, recvWindow, logOption, referer);
    }

    /**
     * Creates a new asynchronous/non-blocking REST client to trading
     */
    public BybitApiAsyncTradeRestClient newAsyncTradeRestClient() {
        return new BybitApiTradeAsyncRestClientImpl(apiKey, secret, baseUrl, debugMode, recvWindow, logOption, referer);
    }

    /**
     * Creates a new synchronous/blocking REST client to position data
     */
    public BybitApiPositionRestClient newPositionRestClient() {
        return new BybitApiPositionRestClientImpl(apiKey, secret, baseUrl, debugMode, recvWindow, logOption);
    }

    /**
     * Creates a new asynchronous/non-blocking client to position data
     */
    public BybitApiAsyncPositionRestClient newAsyncPositionRestClient() {
        return new BybitApiAsyncPositionRestClientImpl(apiKey, secret, baseUrl, debugMode, recvWindow, logOption);
    }

    /**
     * Creates a new synchronous/blocking REST client to Account data
     */
    public BybitApiAccountRestClient newAccountRestClient() {
        return new BybitApiAccountRestClientImpl(apiKey, secret, baseUrl, debugMode, recvWindow, logOption);
    }

    /**
     * Creates a new asynchronous/non-blocking client to Account data
     */
    public BybitApiAsyncAccountRestClient newAsyncAccountRestClient() {
        return new BybitApiAsyncAccountRestClientImpl(apiKey, secret, baseUrl, debugMode, recvWindow, logOption);
    }

    /**
     * Creates a new synchronous/blocking REST client to Asset data
     */
    public BybitApiAssetRestClient newAssetRestClient() {
        return new BybitApiAssetRestClientImpl(apiKey, secret, baseUrl, debugMode, recvWindow, logOption);
    }

    /**
     * Creates a new asynchronous/non-blocking client to Asset data
     */
    public BybitApiAsyncAssetRestClient newAsyncAssetRestClient() {
        return new BybitApiAsyncAssetRestClientImpl(apiKey, secret, baseUrl, debugMode, recvWindow, logOption);
    }

    /**
     * Creates a new synchronous/blocking REST client to Broker earning data
     */
    public BybitApiBrokerRestClient newBrokerRestClient() {
        return new BybitApiBrokerRestClientImpl(apiKey, secret, baseUrl, debugMode, recvWindow, logOption);
    }

    /**
     * Creates a new asynchronous/non-blocking client to Broker earning data
     */
    public BybitApiAsyncBrokerRestClient newAsyncBrokerRestClient() {
        return new BybitApiAsyncBrokerRestClientImpl(apiKey, secret, baseUrl, debugMode, recvWindow, logOption);
    }

    /**
     * Creates a new synchronous/blocking REST client to Crypto Loan data
     */
    public BybitApiLoanRestClient newCryptoLoanRestClient() {
        return new BybitApiLoanRestClientImpl(apiKey, secret, baseUrl, debugMode, recvWindow, logOption);
    }

    /**
     * Creates a new asynchronous/non-blocking client to Crypto Loan data
     */
    public BybitApiAsyncLoanRestClient newAsyncCryptoLoanRestClient() {
        return new BybitApiAsyncLoanRestClientImpl(apiKey, secret, baseUrl, debugMode, recvWindow, logOption);
    }

    /**
     * Access to public websocket
     */
    public WebsocketStreamClient newWebsocketClient() {
        return new WebsocketStreamClientImpl(apiKey, secret, baseUrl, DEFAULT_PING_INTERVAL, DEFAULT_MAX_ALIVE_TIME, debugMode, logOption, System.out::println);
    }

    public WebsocketStreamClient newWebsocketClient(int pingInterval) {
        return new WebsocketStreamClientImpl(apiKey, secret, baseUrl, pingInterval, DEFAULT_MAX_ALIVE_TIME, debugMode, logOption, System.out::println);
    }

    public WebsocketStreamClient newWebsocketClient(String maxAliveTime) {
        return new WebsocketStreamClientImpl(apiKey, secret, baseUrl, DEFAULT_PING_INTERVAL, maxAliveTime, debugMode, logOption, System.out::println);
    }

    public WebsocketStreamClient newWebsocketClient(WebSocketMessageCallback messageHandler) {
        return new WebsocketStreamClientImpl(apiKey, secret, baseUrl, DEFAULT_PING_INTERVAL, DEFAULT_MAX_ALIVE_TIME, debugMode, logOption, messageHandler);
    }

    public WebsocketStreamClient newWebsocketClient(int pingInterval, WebSocketMessageCallback messageHandler) {
        return new WebsocketStreamClientImpl(apiKey, secret, baseUrl, pingInterval, DEFAULT_MAX_ALIVE_TIME, debugMode, logOption, messageHandler);
    }
    public WebsocketStreamClient newWebsocketClient(int pingInterval, String maxAliveTime) {
        return new WebsocketStreamClientImpl(apiKey, secret, baseUrl, pingInterval, maxAliveTime, debugMode, logOption, System.out::println);
    }

    public WebsocketStreamClient newWebsocketClient(String maxAliveTime, WebSocketMessageCallback messageHandler) {
        return new WebsocketStreamClientImpl(apiKey, secret, baseUrl, DEFAULT_PING_INTERVAL, maxAliveTime, debugMode, logOption, System.out::println);
    }

    public WebsocketStreamClient newWebsocketClient(int pingInterval, String maxAliveTime, WebSocketMessageCallback messageHandler) {
        return new WebsocketStreamClientImpl(apiKey, secret, baseUrl, pingInterval, maxAliveTime, debugMode, logOption, messageHandler);
    }

    public BybitApiSpreadRestClient newSpreadRestClient() {
        return new BybitApiSpreadRestClientImpl(apiKey, secret, baseUrl, debugMode, recvWindow, logOption, referer);
    }

    public BybitApiRfqRestClient newRfqRestClient() {
        return new BybitApiRfqRestClientImpl(apiKey, secret, baseUrl, debugMode, recvWindow, logOption, referer);
    }

    public BybitApiAffiliateRestClient newAffiliateRestClient() {
        return new BybitApiAffiliateRestClientImpl(apiKey, secret, baseUrl, debugMode, recvWindow, logOption, referer);
    }

    public BybitApiAsyncSpreadRestClient newAsyncSpreadRestClient() {
        return new BybitApiAsyncSpreadRestClientImpl(apiKey, secret, baseUrl, debugMode, recvWindow, logOption, referer);
    }

    public BybitApiAsyncRfqRestClient newAsyncRfqRestClient() {
        return new BybitApiAsyncRfqRestClientImpl(apiKey, secret, baseUrl, debugMode, recvWindow, logOption, referer);
    }

    public BybitApiAsyncAffiliateRestClient newAsyncAffiliateRestClient() {
        return new BybitApiAsyncAffiliateRestClientImpl(apiKey, secret, baseUrl, debugMode, recvWindow, logOption, referer);
    }

    /**
     * Creates a new synchronous/blocking REST client to Earn endpoints
     */
    public BybitApiEarnRestClient newEarnRestClient() {
        return new BybitApiEarnRestClientImpl(apiKey, secret, baseUrl, debugMode, recvWindow, logOption, referer);
    }

    /**
     * Creates a new asynchronous/non-blocking client to Earn endpoints
     */
    public BybitApiAsyncEarnRestClient newAsyncEarnRestClient() {
        return new BybitApiAsyncEarnRestClientImpl(apiKey, secret, baseUrl, debugMode, recvWindow, logOption, referer);
    }

    /**
     * Creates a new synchronous/blocking REST client to Fiat endpoints
     */
    public BybitApiFiatRestClient newFiatRestClient() {
        return new BybitApiFiatRestClientImpl(apiKey, secret, baseUrl, debugMode, recvWindow, logOption, referer);
    }

    /**
     * Creates a new asynchronous/non-blocking client to Fiat endpoints
     */
    public BybitApiAsyncFiatRestClient newAsyncFiatRestClient() {
        return new BybitApiAsyncFiatRestClientImpl(apiKey, secret, baseUrl, debugMode, recvWindow, logOption, referer);
    }

    /**
     * Creates a new synchronous/blocking REST client to P2P endpoints
     */
    public BybitApiP2pRestClient newP2pRestClient() {
        return new BybitApiP2pRestClientImpl(apiKey, secret, baseUrl, debugMode, recvWindow, logOption, referer);
    }

    /**
     * Creates a new asynchronous/non-blocking client to P2P endpoints
     */
    public BybitApiAsyncP2pRestClient newAsyncP2pRestClient() {
        return new BybitApiAsyncP2pRestClientImpl(apiKey, secret, baseUrl, debugMode, recvWindow, logOption, referer);
    }
}
