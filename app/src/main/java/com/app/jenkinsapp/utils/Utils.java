package com.app.jenkinsapp.utils;


import android.app.Application;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;

public final class Utils {
  private volatile Utils instance;
  private Application application;
  private Context context;

  //private
  private Utils() {
  }

  /*
  * single instance
  */
  public Utils getInstance(final Application application) {
    if (instance == null) {
      synchronized (this) {
        if (instance == null) {
          instance = new Utils();
          this.application = application;
          this.context = application.getApplicationContext();
        }
      }
    }
    return instance;
  }

  /**
   * convert pixel to DP
   * @param pixel - pixel value
   * @return - int DP
   */
  public int getDpFromPixels(final int pixel) {
    final float scale = context.getResources().getDisplayMetrics().density;
    return (int) (pixel / scale);
  }

  /**
   * convert DP to pixel
   * @param dp - DP value
   * @return - int pixel
   */
  public int getPixelFromDp(final int dp) {
    final float scale = context.getResources().getDisplayMetrics().density;
    return (int) (dp * scale);
  }

  /**
   * get device screen width
   * @return - int
   */
  public int getDeviceScreenWidth() {
    if (application == null || application.getResources() == null ||
            application.getResources().getDisplayMetrics() == null) {
      return 0;
    }
    return application.getResources().getDisplayMetrics().widthPixels;
  }

  /**
   * get device screen height
   * @return - int
   */
  public int getDeviceScreenHeight() {
    if (application == null || application.getResources() == null ||
            application.getResources().getDisplayMetrics() == null) {
      return 0;
    }
    return application.getResources().getDisplayMetrics().heightPixels;
  }

  /**
   * get device screen density
   * @return - int
   */
  public int getDeviceDensity() {
    if (application == null || application.getResources() == null ||
            application.getResources().getDisplayMetrics() == null) {
      return 0;
    }
    return (int) application.getResources().getDisplayMetrics().density;
  }

  /**
   * get device screen width in DP
   * @return - int
   */
  public int getDeviceScreenWidthDP() {
    float density = getDeviceDensity();
    if (density == 0) {
      density = 1;
    }
    return (int) (getDeviceScreenWidth() / density);
  }

  /**
   * get device screen height in DP
   * @return - int
   */
  public int getDeviceScreenHeightDP() {
    float density = getDeviceDensity();
    if (density == 0) {
      density = 1;
    }
    return (int) (getDeviceScreenHeight() / density);
  }

  /**
   * Drawable from resId
   * @param resId - int drawable resId
   * @return - Drawable
   */
  public Drawable getDrawable(@DrawableRes final int resId) {
    if (Build.VERSION.SDK_INT < 21) {
      return context.getResources().getDrawable(resId);
    } else {
      return context.getDrawable(resId);
    }
  }

  /**
   * get string from resources
   * @param args  - args
   * @param resId - int string resId
   * @return - String
   */
  public String getString(@StringRes final int resId, final Object... args) {
    return application.getString(resId, args);
  }

  /**
   * @param resId    - int string resId
   * @param args     - args
   * @param quantity - quantity field
   * @return - String
   */
  public String getQuantifiedString(final int resId,
                                    final int quantity,
                                    final Object... args) {
    return application.getResources().getQuantityString(resId, quantity, args);
  }

  /**
   * get string array from resources
   * @param resId - int string-array resId
   * @return - String array
   */
  public String[] getStringArray(final int resId) {
    return application.getResources().getStringArray(resId);
  }


}
