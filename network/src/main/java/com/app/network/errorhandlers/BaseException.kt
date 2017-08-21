package com.app.network.errorhandlers

import android.text.TextUtils
import java.io.IOException

open class BaseException : IOException {
    constructor() : super()
    constructor(message: String?) : super(message) {
        assertMessageEmpty(message)
    }

    constructor(message: String?, cause: Throwable?) : super(message, cause) {
        assertMessageEmpty(message)
        assertThrowable(cause)
    }

    constructor(cause: Throwable?) : super(cause) {
        assertThrowable(cause)
    }

    private fun assertMessageEmpty(message: String?): Boolean {
        return TextUtils.isEmpty(message)
    }

    private fun assertThrowable(throwable: Throwable?): Boolean {
        return throwable != null
    }

}