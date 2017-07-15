package com.app.jenkins_common.lib;


public interface SharedPreferenceType<T> extends PreferenceType<T> {
  boolean notNullPref();
}
