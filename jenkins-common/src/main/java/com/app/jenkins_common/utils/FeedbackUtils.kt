package com.app.jenkins_common.utils


import android.os.Build
import android.support.annotation.StringRes
import android.support.design.widget.Snackbar
import android.text.TextUtils
import android.view.View
import android.widget.Toast

object FeedbackUtils {
    private val showToast = Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP

    fun showFeedBack(view: View, @StringRes resId: Int) {
        showFeedBack(view, view.context.getString(resId))
    }

    @JvmOverloads
    fun showFeedBack(view: View?,
                     message: String,
                     listener: View.OnClickListener? = null,
                     indefinite: Boolean = false) {
        if (view == null) {
            throw RuntimeException("View is null.")
        }

        if (!TextUtils.isEmpty(message)) {
            if (showToast) {
                val toast = Toast.makeText(view.context, message,
                        if (indefinite) Toast.LENGTH_LONG else Toast.LENGTH_SHORT)
                toast.show()
            } else {
                val snackbar = Snackbar.make(view, message,
                        if (indefinite) Snackbar.LENGTH_INDEFINITE else Snackbar.LENGTH_SHORT)
                snackbar.show()
            }
        }
    }

}
