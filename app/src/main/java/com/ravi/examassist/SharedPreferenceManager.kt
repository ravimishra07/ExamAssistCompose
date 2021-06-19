package com.ravi.examassist

import android.content.Context
import android.content.SharedPreferences
import android.content.SharedPreferences.Editor


class SharedPreferenceManager(context: Context) {
    var pref: SharedPreferences
    var editor: Editor
    var privateMode = 0
    private val prefName = "ExamAssist"
    private val isFirstLaunch = "IsFirstTimeLaunch"

    init {
        pref = context.getSharedPreferences(prefName, privateMode);
        editor = pref.edit()
    }

    fun setFirstTimeLaunch(isFirstTime: Boolean) {
        editor.putBoolean(isFirstLaunch, isFirstTime)
        editor.commit()
    }

    fun isFirstTimeLaunch(): Boolean {
        return pref.getBoolean(isFirstLaunch, true)
    }
}