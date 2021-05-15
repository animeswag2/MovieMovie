package com.learn.personal.moviet.utils

import androidx.test.espresso.idling.CountingIdlingResource

class EspressoIdlingResource {
    companion object {
        private const val RESOURCE = "GLOBAL"
        val testIdlingResource = CountingIdlingResource(RESOURCE)

        fun increment() {
            testIdlingResource.increment()
        }

        fun decrement() {
            testIdlingResource.decrement()
        }
    }
}