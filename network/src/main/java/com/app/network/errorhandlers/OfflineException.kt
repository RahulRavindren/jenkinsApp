package com.app.network.errorhandlers

import com.app.jenkins_common.model.BaseModel
import com.app.jenkins_common.utils.EventBus
import com.squareup.otto.ThreadEnforcer


class OfflineException(private val throwable: Throwable) : BaseException(throwable) {

    private fun broadcastEvent() {
        EventBus.getInstance(ThreadEnforcer.ANY)
                .getBus()?.post(OfflineEvent(throwable.message, throwable.cause))
    }

    data class OfflineEvent(var message: String?, var throwable: Throwable?) : BaseModel(-1) {
        override fun className(): String {
            return this.className();
        }
    }
}
