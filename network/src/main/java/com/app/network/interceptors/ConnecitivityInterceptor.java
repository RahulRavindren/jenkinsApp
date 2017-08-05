package com.app.network.interceptors;


import com.app.jenkins_common.utils.NetworkUtils;

import java.io.IOException;

import javax.inject.Inject;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public final class ConnecitivityInterceptor implements Interceptor {
  private final NetworkUtils connectivityManager;

  @Inject
  public ConnecitivityInterceptor(final NetworkUtils networkUtils) {
    this.connectivityManager = networkUtils;
  }


  @Override
  public Response intercept(final Chain chain) throws IOException {
    if (connectivityManager.isOnline()) {
      return null;
    }
    final Request.Builder builder = chain.request().newBuilder();
    return chain.proceed(builder.build());
  }
}
