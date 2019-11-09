package com.ceres.api.service;

import com.ceres.api.exception.CoinceresApiError;
import com.ceres.api.exception.CoinceresApiException;
import com.ceres.api.security.AuthenticationInterceptor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.Dispatcher;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import org.apache.commons.lang3.StringUtils;
import retrofit2.Call;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.concurrent.TimeUnit;

/**
 * @author LMT
 * @date 2019/01/30
 */
public class CoinceresApiServiceGenerator {

    private static final OkHttpClient sharedClient;
    private static final Converter.Factory converterFactory = JacksonConverterFactory.create(buildObjectMapper());

    static {
        Dispatcher dispatcher = new Dispatcher();
        dispatcher.setMaxRequestsPerHost(500);
        dispatcher.setMaxRequests(500);
        sharedClient = new OkHttpClient.Builder()
                .dispatcher(dispatcher)
                /** 设置网络超时，方便调试 */
                .connectTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build();
    }

    private static ObjectMapper buildObjectMapper(){
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return objectMapper;
    }

    private static final Converter<ResponseBody, CoinceresApiError> errorBodyConverter =
            (Converter<ResponseBody, CoinceresApiError>)converterFactory.responseBodyConverter(
                    CoinceresApiError.class, new Annotation[0], null);

    public static <S> S createService(String endPoint,Class<S> serviceClass, String apiKey, String secret) {
        Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
                .baseUrl(endPoint)
                .addConverterFactory(converterFactory)
                ;

        if (StringUtils.isEmpty(apiKey) || StringUtils.isEmpty(secret)) {
            retrofitBuilder.client(sharedClient);
        } else {
            // `adaptedClient` will use its own interceptor, but share thread pool etc with the 'parent' client
            AuthenticationInterceptor interceptor = new AuthenticationInterceptor(apiKey, secret);
            OkHttpClient adaptedClient = sharedClient.newBuilder()
                    .addInterceptor(interceptor)
                    .build();
            retrofitBuilder.client(adaptedClient);
        }
        Retrofit retrofit = retrofitBuilder.build();
        return retrofit.create(serviceClass);
    }

    public static <S> S createService(String endPoint,Class<S> serviceClass) {
        return createService(endPoint,serviceClass, null, null);
    }

    /**
     * Execute a REST call and block until the response is received.
     */
    @SuppressWarnings("all")
    public static <T> T executeSync(Call<T> call) {
        try {
            Response<T> response = call.execute();
            if (response.isSuccessful()) {
                return response.body();
            } else {
//                CoinceresApiError apiError = getCoinceresApiError(response);
                okhttp3.Response raw = response.raw();
                CoinceresApiError coinceresApiError = new CoinceresApiError();
                coinceresApiError.setCode(raw.code());
                coinceresApiError.setMessage(raw.message());
                throw new CoinceresApiException(coinceresApiError);
            }
        } catch (IOException e) {
            throw new CoinceresApiException(e);
        }
    }

    /**
     * Extracts and converts the response error body into an object.
     */
    public static CoinceresApiError getCoinceresApiError(Response<?> response) throws IOException, CoinceresApiException {
        return errorBodyConverter.convert(response.errorBody());
    }

    /**
     * Returns the shared OkHttpClient instance.
     */
    public static OkHttpClient getSharedClient() {
        return sharedClient;
    }
}
