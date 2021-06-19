package com.ravi.examassist

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class ExamAssistApp: Application() {
    override fun onCreate() {
        super.onCreate()
        // Required initialization logic here!
    }
}