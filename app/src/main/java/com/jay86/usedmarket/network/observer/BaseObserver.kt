package com.jay86.usedmarket.network.observer

import com.jay86.usedmarket.utils.LogUtils
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

/**
 * Created by Jay on 2017/10/10.
 */

abstract class BaseObserver<T> : Observer<T> {
    override fun onSubscribe(d: Disposable) = Unit

    override fun onNext(t: T) = Unit

    override fun onComplete() = Unit

    override fun onError(e: Throwable) {
        LogUtils.e("", e.message.orEmpty(), e)
    }
}