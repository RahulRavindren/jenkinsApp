package com.app.jenkins_common.lib


import android.content.SharedPreferences

class IntegerPreferenceType(private val sharedPreferences: SharedPreferences?) : SharedPreferenceType<Int> {
    private val defaultValue = -1

    override fun notNullPref(): Boolean {
        return sharedPreferences != null
    }

    override fun get(key: String): Int {
        return if (notNullPref()) {
            sharedPreferences!!.getInt(key, defaultValue)
        } else {
            defaultValue
        }
    }

    override fun isSet(key: String): Boolean {
        return sharedPreferences!!.contains(key)
    }

    override fun set(key: String, value: Int) {
        if (notNullPref()) {
            val editor = sharedPreferences!!.edit()
            editor.putInt(key, value!!)
            editor.apply()
        }
    }

    override fun delete(key: String) {
        if (notNullPref()) {
            sharedPreferences!!.edit().remove(key).commit()
        }
    }
}
