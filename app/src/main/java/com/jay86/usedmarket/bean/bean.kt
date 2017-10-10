package com.jay86.usedmarket.bean

/**
 * bean表
 * Created by Jay on 2017/10/10.
 */
data class ApiWrapper<out T>(
        val code: Int,
        val data: T
)

data class User(val id: String)