package com.app.jenkinsapp;

import android.app.Application;
import android.support.compat.BuildConfig;

import com.app.jenkinsapp.components.DaggerMainComponent;
import com.app.jenkinsapp.components.MainComponent;
import com.app.jenkinsapp.components.MainModule;

import timber.log.Timber;


public class MainApplication extends Application {
  private MainComponent mainComponent;

  @Override
  public void onCreate() {
    super.onCreate();

    if (BuildConfig.DEBUG) {
      Timber.plant(new Timber.DebugTree());
    }

    //dagger

    mainComponent = DaggerMainComponent.builder()
            .mainModule(new MainModule(this)).build();
  }

  public MainComponent getMainComponent() {
    return mainComponent;
  }
}
