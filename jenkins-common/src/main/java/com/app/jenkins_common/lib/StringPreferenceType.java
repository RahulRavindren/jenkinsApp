package com.app.jenkins_common.lib;


import android.content.SharedPreferences;


public final class StringPreferenceType implements SharedPreferenceType<String> {
  private final SharedPreferences sharedPreferences;
  private String defaultValue = "";

  public StringPreferenceType(final SharedPreferences sharedPreferences) {
    this.sharedPreferences = sharedPreferences;
  }

  @Override
  public boolean notNullPref() {
    return sharedPreferences != null;
  }

  @Override
  public synchronized String get(final String key) {
    if (notNullPref()) {
      return sharedPreferences.getString(key, defaultValue);
    } else {
      return defaultValue;
    }
  }

  @Override
  public boolean isSet(final String key) {
    return sharedPreferences.contains(key);
  }

  @Override
  public synchronized void set(final String key, final String value) {
    if (notNullPref()) {
      final SharedPreferences.Editor editor = sharedPreferences.edit();
      editor.putString(key, value);
      editor.apply();
    }
  }

  @Override
  public synchronized void delete(final String key) {
    if (notNullPref()) {
      sharedPreferences.edit().remove(key).apply();
    }
  }
}
