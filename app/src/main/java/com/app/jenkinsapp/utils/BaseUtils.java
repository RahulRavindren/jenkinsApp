package com.app.jenkinsapp.utils;


import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class BaseUtils {
  private static final String EMPTY_STRING = "";
  private static volatile BaseUtils instance;

  private BaseUtils() {
  }

  public static BaseUtils getInstance() {
    if (instance == null) {
      synchronized (BaseUtils.class) {
        instance = new BaseUtils();
      }
    }
    return instance;
  }

  public boolean isEmpty(final String str) {
    return str == null || str.trim().equals(EMPTY_STRING);
  }

  public boolean isEmpty(final Collection collection) {
    return collection == null || collection.isEmpty();
  }

  public boolean isEmpty(final Object[] array) {
    return array == null || array.length == 0;
  }

  public boolean isEmpty(final Map map) {
    return map == null || map.isEmpty();
  }

  public <T, V> Map<T, V> copyAll(final Map<T, V> destinationMap, final Map<T, V> sourceMap) {
    if (isEmpty(sourceMap)) {
      return destinationMap;
    }
    if (destinationMap == null) {
      final Map<T, V> duplicateMap = new HashMap<T, V>(sourceMap);
      return duplicateMap;
    }

    destinationMap.putAll(sourceMap);
    return destinationMap;
  }

  public boolean equals(final Object a, final Object b) {
    return (a == null) ? (b == null) : (b != null && a.equals(b));
  }

  public boolean equalsIgnoreCase(final String a, final String b) {
    return (a == null) ? (b == null) : (b != null && a.equalsIgnoreCase(b));
  }

  public boolean isValidInteger(final String str) {
    return !isEmpty(str) && str.matches("[0-9]+");
  }

  public boolean isEmptyWithoutTrim(final String str) {
    return !(str != null && (str.length() > 0));
  }

  public boolean equalsList(final List<?> firstList, final List<?> secondList) {
    if (isEmpty(firstList) || isEmpty(secondList)) {
      return false;
    }
    if (firstList.size() != secondList.size()) {
      return false;
    }

    for (int i = 0; i < firstList.size(); i++) {
      if (!equals(firstList.get(i), secondList.get(i))) {
        return false;
      }
    }

    return true;
  }

  public <T> boolean isWeakReferenceObjectAvailable(final WeakReference<T> weakReference) {
    try {
      return weakReference != null && weakReference.get() != null;
    } catch (NullPointerException e) {
      throw new NullPointerException();
    }
  }

}
