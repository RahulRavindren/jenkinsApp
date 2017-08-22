package com.app.jenkins_common.model


abstract class BaseModel(private val serialId: Long) {
    val serializableID: Long = serialId
        get() = field ?: serializableID

    abstract fun className(): String
}
