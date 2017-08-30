package com.app.jenkins_common.utils


import android.app.Application
import android.content.Context
import android.graphics.drawable.Drawable
import android.os.Build
import android.support.annotation.DrawableRes
import android.support.annotation.StringRes
import javax.inject.Singleton

@Singleton
class Utils private constructor() {
    @Volatile private var instance: Utils? = null
    private var application: Application? = null
    private var context: Context? = null

    /*
  * single instance
  */
    fun getInstance(application: Application): Utils? {
        if (instance == null) {
            synchronized(this) {
                if (instance == null) {
                    instance = Utils()
                    this.application = application
                    this.context = application.applicationContext
                }
            }
        }
        return instance
    }

    /**
     * convert pixel to DP
     * @param pixel - pixel value
     * @return - int DP
     */
    fun getDpFromPixels(pixel: Int): Int {
        val scale = context!!.resources.displayMetrics.density
        return (pixel / scale).toInt()
    }

    /**
     * convert DP to pixel
     * @param dp - DP value
     * @return - int pixel
     */
    fun getPixelFromDp(dp: Int): Int {
        val scale = context!!.resources.displayMetrics.density
        return (dp * scale).toInt()
    }

    /**
     * get device screen width
     * @return - int
     */
    val deviceScreenWidth: Int
        get() = if (application == null || application!!.resources == null ||
                application!!.resources.displayMetrics == null) {
            0
        } else application!!.resources.displayMetrics.widthPixels

    /**
     * get device screen height
     * @return - int
     */
    val deviceScreenHeight: Int
        get() = if (application == null || application!!.resources == null ||
                application!!.resources.displayMetrics == null) {
            0
        } else application!!.resources.displayMetrics.heightPixels

    /**
     * get device screen density
     * @return - int
     */
    val deviceDensity: Int
        get() = if (application == null || application!!.resources == null ||
                application!!.resources.displayMetrics == null) {
            0
        } else application!!.resources.displayMetrics.density.toInt()

    /**
     * get device screen width in DP
     * @return - int
     */
    val deviceScreenWidthDP: Int
        get() {
            var density = deviceDensity.toFloat()
            if (density == 0f) {
                density = 1f
            }
            return (deviceScreenWidth / density).toInt()
        }

    /**
     * get device screen height in DP
     * @return - int
     */
    val deviceScreenHeightDP: Int
        get() {
            var density = deviceDensity.toFloat()
            if (density == 0f) {
                density = 1f
            }
            return (deviceScreenHeight / density).toInt()
        }

    /**
     * Drawable from resId
     * @param resId - int drawable resId
     * @return - Drawable
     */
    fun getDrawable(@DrawableRes resId: Int): Drawable? {
        return if (Build.VERSION.SDK_INT < 21) {
            context!!.resources.getDrawable(resId)
        } else {
            context!!.getDrawable(resId)
        }
    }

    /**
     * get string from resources
     * @param args  - args
     * @param resId - int string resId
     * @return - String
     */
    fun getString(@StringRes resId: Int, vararg args: Any): String {
        return application!!.getString(resId, *args)
    }

    /**
     * @param resId    - int string resId
     * @param args     - args
     * @param quantity - quantity field
     * @return - String
     */
    fun getQuantifiedString(resId: Int,
                            quantity: Int,
                            vararg args: Any): String {
        return application!!.resources.getQuantityString(resId, quantity, *args)
    }

    /**
     * get string array from resources
     * @param resId - int string-array resId
     * @return - String array
     */
    fun getStringArray(resId: Int): Array<String> {
        return application!!.resources.getStringArray(resId)
    }


}
