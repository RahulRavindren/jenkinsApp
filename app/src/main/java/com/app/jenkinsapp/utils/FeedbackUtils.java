package com.app.jenkinsapp.utils;


import android.os.Build;
import android.support.annotation.StringRes;
import android.support.design.widget.Snackbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

public final class FeedbackUtils {
  private static boolean showToast = Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP;

  private FeedbackUtils() {
  }

  public static void showFeedBack(final View view, final @StringRes int resId) {
    showFeedBack(view, view.getContext().getString(resId));
  }

  public static void showFeedBack(final View view, final String message) {
    showFeedBack(view, message, null, false);
  }

  public static void showFeedBack(final View view,
                                  final String message,
                                  final View.OnClickListener listener,
                                  final boolean indefinite) {
    if (view == null) {
      throw new RuntimeException("View is null.");
    }

    if (!TextUtils.isEmpty(message)) {
      if (showToast) {
        final Toast toast = Toast.makeText(view.getContext(), message,
                indefinite ? Toast.LENGTH_LONG : Toast.LENGTH_SHORT);
        toast.show();
      } else {
        final Snackbar snackbar = Snackbar.make(view, message,
                indefinite ? Snackbar.LENGTH_INDEFINITE : Snackbar.LENGTH_SHORT);
        snackbar.show();
      }
    }
  }

}
