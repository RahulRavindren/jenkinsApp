package com.app.jenkins_common.utils;


import android.content.Intent;
import android.net.ConnectivityManager;

public class NetworkUtils {
  private Intent intent;

  public NetworkUtils(final Intent intent) {
    this.intent = intent;
    init();
  }

  private void init() {
    if (intent != null) {
      final String action = intent.getAction();
      if (action.equals(ConnectivityManager.CONNECTIVITY_ACTION)) {
        final boolean isOnline = isOnline();

      }
    }
  }

  private boolean isOnline() {
    return false;
  }
}
