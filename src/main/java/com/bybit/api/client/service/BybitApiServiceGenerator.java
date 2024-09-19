package com.bybit.api.client.service;

import com.bybit.api.client.restApi.BybitApiService;
import com.bybit.api.client.exception.BybitApiError;
import com.bybit.api.client.exception.BybitApiException;
import com.bybit.api.client.security.AuthenticationInterceptor;
import lombok.Getter;
import okhttp3.Dispatcher;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.Nullable;
import retrofit2.Call;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.concurrent.TimeUnit;

import static com.bybit.api.client.log.Slf4jLoggingInterceptor.HandleLoggingInterceptor;

/**
 * Generates a Bybit API implementation based on @see {@link BybitApiService}.
 */
public class BybitApiServiceGenerator {
    /**
     * -- GETTER --
     * Returns the shared OkHttpClient instance.
     */
    @Getter
    private static final OkHttpClient sharedClient;
    private static final Converter.Factory converterFactory = JacksonConverterFactory.create();

    static {
        Dispatcher dispatcher = new Dispatcher();
        dispatcher.setMaxRequestsPerHost(1000);
        dispatcher.setMaxRequests(1000);
        sharedClient = new OkHttpClient.Builder()
                .dispatcher(dispatcher)
                .pingInterval(20, TimeUnit.SECONDS)
                .build();
    }


    @SuppressWarnings("unchecked")
    @Nullable
    private static final Converter<ResponseBody, BybitApiError> errorBodyConverter =
            (Converter<ResponseBody, BybitApiError>) converterFactory.responseBodyConverter(
                    BybitApiError.class, new Annotation[0], null);

    public static <S> S createService(Class<S> serviceClass, String baseUrl, boolean debugMode, long recvWindow, String logOption, String referer) {
        return createService(serviceClass, null, null, baseUrl, debugMode, recvWindow, logOption, referer);
    }

    public static <S> S createService(Class<S> serviceClass, String baseUrl, boolean debugMode, long recvWindow, String logOption) {
        return createService(serviceClass, null, null, baseUrl, debugMode, recvWindow, logOption, "");
    }

    /**
     * Create a Bybit API service.
     *
     * @param serviceClass the type of service.
     * @param apiKey       Bybit API key.
     * @param secret       Bybit secret.
     * @return a new implementation of the API endpoints for the Bybit API service.
     */
    public static <S> S createService(Class<S> serviceClass, String apiKey, String secret, String baseUrl, boolean debugMode, long recvWindow, String logOption, String referer) {
        Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(converterFactory);
        OkHttpClient.Builder clientBuilder = sharedClient.newBuilder();
        if (!StringUtils.isEmpty(apiKey) && !StringUtils.isEmpty(secret)) {
            AuthenticationInterceptor interceptor = new AuthenticationInterceptor(apiKey, secret, recvWindow, referer);
            clientBuilder.addInterceptor(interceptor);
        }
        if (debugMode) {
            HandleLoggingInterceptor(clientBuilder, logOption);
        }
        retrofitBuilder.client(clientBuilder.build());
        Retrofit retrofit = retrofitBuilder.build();
        return retrofit.create(serviceClass);
    }


    /**
     * Execute a REST call and block until the response is received.
     */
    public static <T> T executeSync(Call<T> call) {
        try {
            var response = call.execute();
            if (response.isSuccessful()) {
                return response.body();
            } else {
                BybitApiError apiError = getBybitApiError(response);
                throw new BybitApiException(apiError);
            }
        } catch (IOException e) {
            throw new BybitApiException(e);
        }
    }

    /**
     * Extracts and converts the response error body into an object.
     */
    public static BybitApiError getBybitApiError(Response<?> response) throws IOException, BybitApiException {
        ResponseBody errorBody = response.errorBody();
        if (errorBody != null && errorBodyConverter != null) {
            return errorBodyConverter.convert(errorBody);
        }
        // Handle the case where there is no error converter or error body.
        throw new BybitApiException("Response error body was null or couldn't be converted.");
    }
}
