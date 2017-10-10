package com.jay86.usedmarket

import android.app.Application
import android.content.Context

/**
 * Created by Jay on 2017/10/10.
 */

class App : Application() {
    companion object {
        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()
        context = this
    }
}