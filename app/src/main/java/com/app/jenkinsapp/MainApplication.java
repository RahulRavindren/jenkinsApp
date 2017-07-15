package com.app.jenkinsapp;

import android.app.Application;

import com.app.jenkins_common.dagger.MainComponent;
import com.app.jenkins_common.dagger.MainModule;
import com.app.jenkinsapp.dependencies.DaggerMainComponent;

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
