package com.app.jenkins_common.utils

import com.squareup.otto.Bus
import com.squareup.otto.ThreadEnforcer

class EventBus {
    private var bus: Bus? = null;

    private constructor(threadEnforcer: ThreadEnforcer?) {
        bus = Bus(threadEnforcer);
    }

    companion object {
        private var INSTANCE: EventBus? = null

        fun getInstance(threadEnforcer: ThreadEnforcer?): EventBus {
            if (INSTANCE == null) {
                INSTANCE = EventBus(threadEnforcer)
            }
            return INSTANCE!!
        }

        fun getInstance(): EventBus {
            if (INSTANCE == null) {
                INSTANCE = EventBus(ThreadEnforcer.ANY)
            }
            return INSTANCE!!
        }
    }

    fun getBus(): Bus? {
        return bus
    }
}