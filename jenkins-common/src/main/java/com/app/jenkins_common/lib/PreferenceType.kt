package com.app.jenkins_common.lib


interface PreferenceType<V> {
    operator fun get(key: String): V

    fun isSet(key: String): Boolean

    operator fun set(key: String, value: V)

    fun delete(key: String)
}
