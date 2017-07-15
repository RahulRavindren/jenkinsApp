package com.app.jenkins_common.lib;


public interface PreferenceType<V> {
  V get(String key);

  boolean isSet(String key);

  void set(String key, V value);

  void delete(String key);
}
