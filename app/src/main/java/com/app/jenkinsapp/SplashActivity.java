package com.app.jenkinsapp;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.app.jenkins_common.activities.BaseActivity;

public class SplashActivity extends BaseActivity {

  @Override
  protected void onCreate(final @Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    DataBindingUtil.setContentView(this, R.layout.activity_splash);
  }
}
