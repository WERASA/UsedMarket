package com.jay86.usedmarket.network

import com.jay86.usedmarket.BuildConfig
import com.jay86.usedmarket.bean.User
import com.jay86.usedmarket.config.BASE_URL
import com.jay86.usedmarket.config.DEFAULT_TIME_OUT
import com.jay86.usedmarket.network.observer.BaseObserver
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * 网络请求框架
 * Created by Jay on 2017/10/10.
 */
object RequestManager {
    private val apiService: ApiService

    init {
        val client = configureOkHttp(OkHttpClient.Builder())
        val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
        apiService = retrofit.create(ApiService::class.java)
    }

    private fun configureOkHttp(builder: OkHttpClient.Builder): OkHttpClient {
        builder.connectTimeout(DEFAULT_TIME_OUT.toLong(), TimeUnit.SECONDS)

        if (BuildConfig.DEBUG) {
            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY
            builder.addInterceptor(logging)
        }
        return builder.build()
    }

    private fun <T> subscriber(observer: BaseObserver<T>, observable: Observable<T>) {
        observable.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer)
    }

    fun register(email: String, password: String, observer: BaseObserver<User>) {
        val observable: Observable<User> = apiService.register(email, password)
                .map { it.data }
        subscriber(observer, observable)
    }

    fun login(email: String, password: String, observer: BaseObserver<User>) {
        val observable: Observable<User> = apiService.login(email, password)
                .map { it.data }
        subscriber(observer, observable)
    }
}