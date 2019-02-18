package com.ceres.api.service;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.IOException;

/**
 * @author xiaotian.huang
 * @date 2019/01/30
 */
@FunctionalInterface
public interface CoinceresApiCallback<T> {

    void onResponse(T response) throws IOException;

    default void onFailure(Throwable cause) {}
}
