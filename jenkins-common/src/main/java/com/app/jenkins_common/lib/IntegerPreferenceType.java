package com.app.jenkins_common.lib;


import android.content.SharedPreferences;

public final class IntegerPreferenceType implements SharedPreferenceType<Integer>{
  private final SharedPreferences sharedPreferences;
  private final int defaultValue = -1;

  public IntegerPreferenceType(SharedPreferences sharedPreferences) {
    this.sharedPreferences = sharedPreferences;
  }

  @Override
  public boolean notNullPref() {
    return sharedPreferences != null;
  }

  @Override
  public Integer get(String key) {
    if (notNullPref()){
      return sharedPreferences.getInt(key,defaultValue);
    } else {
      return defaultValue;
    }
  }

  @Override
  public boolean isSet(String key) {
    return sharedPreferences.contains(key);
  }

  @Override
  public void set(String key, Integer value) {
    if (notNullPref()) {
      final SharedPreferences.Editor editor = sharedPreferences.edit();
      editor.putInt(key,value);
      editor.apply();
    }

  }

  @Override
  public void delete(String key) {
    if (notNullPref()){
      sharedPreferences.edit().remove(key).commit();
    }
  }
}
