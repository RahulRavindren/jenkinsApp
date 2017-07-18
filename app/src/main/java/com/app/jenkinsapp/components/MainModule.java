package com.app.jenkinsapp.components;


import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.app.jenkins_common.lib.StringPreferenceType;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


@Module
public final class MainModule {
  private final Application application;

  public MainModule(final Application application) {
    this.application = application;
  }

  @Singleton
  @Provides
  SharedPreferences providesSharedPreference() {
    return PreferenceManager.getDefaultSharedPreferences(application);
  }

  @Singleton
  @Provides
  StringPreferenceType providesStringPreferenceType(final SharedPreferences sharedPreferences) {
    return new StringPreferenceType(sharedPreferences);
  }
}
