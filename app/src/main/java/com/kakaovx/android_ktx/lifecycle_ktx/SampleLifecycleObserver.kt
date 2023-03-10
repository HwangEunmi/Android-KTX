package com.kakaovx.android_ktx.lifecycle_ktx

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner

// LifecycleObserver를 구현한다.
class SampleLifecycleObserver: DefaultLifecycleObserver {
    // 필요한 메소드를 구현한다.
    override fun onCreate(owner: LifecycleOwner) {
        super.onCreate(owner)
    }

    override fun onResume(owner: LifecycleOwner) {
        super.onResume(owner)
    }

    override fun onPause(owner: LifecycleOwner) {
        super.onPause(owner)
    }
}