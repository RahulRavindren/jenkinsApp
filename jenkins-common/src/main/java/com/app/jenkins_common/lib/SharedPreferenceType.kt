package com.app.jenkins_common.lib


interface SharedPreferenceType<T> : PreferenceType<T> {
    fun notNullPref(): Boolean
}
