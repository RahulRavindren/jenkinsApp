package com.app.network;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ResponseCallBack<T> implements Callback<T> {
  @Override
  public void onResponse(final Call<T> call, final Response<T> response) {

  }

  @Override
  public void onFailure(final Call<T> call, final Throwable t) {

  }
}
