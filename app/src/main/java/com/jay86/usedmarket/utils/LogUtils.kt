package com.jay86.usedmarket.utils

import android.util.Log
import com.jay86.usedmarket.BuildConfig
import kotlin.experimental.and

/**
 * Created by Jay on 2017/10/10.
 */

object LogUtils {
    private val DEBUG = BuildConfig.DEBUG
    private val SHOW_LOG: Byte
    private val VERBOSE_MASK: Byte = 0x1
    private val DEBUG_MASK: Byte = 0x2
    private val INFO_MASK: Byte = 0x4
    private val WARN_MASK: Byte = 0x8
    private val ERROR_MASK: Byte = 0x10

    init {
        SHOW_LOG = if (DEBUG) 0x1F else 0x10
    }

    fun v(tag: String, msg: String, throwable: Throwable? = null) {
        if (SHOW_LOG and VERBOSE_MASK == VERBOSE_MASK)
            Log.v(tag, msg, throwable)
    }

    fun d(tag: String, msg: String, throwable: Throwable? = null) {
        if (SHOW_LOG and DEBUG_MASK == DEBUG_MASK)
            Log.d(tag, msg, throwable)
    }

    fun i(tag: String, msg: String, throwable: Throwable? = null) {
        if (SHOW_LOG and INFO_MASK == INFO_MASK)
            Log.i(tag, msg, throwable)
    }

    fun w(tag: String, msg: String, throwable: Throwable? = null) {
        if (SHOW_LOG and WARN_MASK == WARN_MASK)
            Log.w(tag, msg, throwable)
    }

    fun e(tag: String, msg: String, throwable: Throwable? = null) {
        if (SHOW_LOG and ERROR_MASK == ERROR_MASK)
            Log.e(tag, msg, throwable)
    }
}
