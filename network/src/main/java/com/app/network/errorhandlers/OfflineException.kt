package com.app.network.errorhandlers


class OfflineException(private val throwable: Throwable) : BaseException(throwable) {

}
