package com.app.jenkins_common.lib


import android.content.SharedPreferences


class StringPreferenceType(private val sharedPreferences: SharedPreferences?) : SharedPreferenceType<String> {
    private val defaultValue = ""

    override fun notNullPref(): Boolean {
        return sharedPreferences != null
    }

    override fun get(key: String): String {
        return if (notNullPref()) {
            sharedPreferences!!.getString(key, defaultValue)
        } else {
            defaultValue
        }
    }

    override fun isSet(key: String): Boolean {
        return sharedPreferences!!.contains(key)
    }

    @Synchronized override fun set(key: String, value: String) {
        if (notNullPref()) {
            val editor = sharedPreferences!!.edit()
            editor.putString(key, value)
            editor.apply()
        }
    }

    @Synchronized override fun delete(key: String) {
        if (notNullPref()) {
            sharedPreferences!!.edit().remove(key).commit()
        }
    }
}
