package com.app.network.errorhandlers

import java.io.IOException


class OfflineException : IOException {
    private val throwable: Throwable

    constructor(throwable: Throwable) : super("") {
        this.throwable = throwable
    }

    constructor(message: String, throwable: Throwable) : super(message) {
        this.throwable = throwable
    }


}
