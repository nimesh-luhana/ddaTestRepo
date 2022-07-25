package com.dda

import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit
import java.util.concurrent.TimeoutException

fun <T> LiveData<T>.getValueOrAwait(): T {
    var data: T? = null
    val latch = CountDownLatch(1)

    val observer = object : Observer<T> {
        override fun onChanged(t: T) {
            data = t
            this@getValueOrAwait.removeObserver(this)
            latch.countDown()
        }
    }
    this.observeForever(observer)
    try {
        if (!latch.await(2, TimeUnit.SECONDS)) {
            throw TimeoutException("Livedata did not receive the value")
        }
    } finally {
        this.removeObserver(observer)
    }

    return data as T

}