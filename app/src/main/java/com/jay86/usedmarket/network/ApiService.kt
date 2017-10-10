package com.jay86.usedmarket.network

import com.jay86.usedmarket.bean.ApiWrapper
import com.jay86.usedmarket.bean.User
import com.jay86.usedmarket.config.LOGIN
import com.jay86.usedmarket.config.REGISTER
import io.reactivex.Observable
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

/**
 * Created by Jay on 2017/10/10.
 */

interface ApiService {
    @FormUrlEncoded
    @POST(REGISTER)
    fun register(email: String, password: String): Observable<ApiWrapper<User>>

    @FormUrlEncoded
    @POST(LOGIN)
    fun login(email: String, password: String): Observable<ApiWrapper<User>>
}