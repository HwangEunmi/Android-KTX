package com.kakaovx.android_ktx.lifecycle_ktx

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.*
import com.kakaovx.android_ktx.R
import kotlinx.coroutines.launch

class SampleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // LifecycleObserver를 등록한다. (SampleActivity의 Lifecycle에 맞춰진)
        lifecycle.addObserver(SampleLifecycleObserver())
    }

    private fun launchCoroutineScope() {
        // (1) Lifecycle의 CoroutineScope를 만드는 방법
        lifecycle.coroutineScope.launch {
            // ...
        }
        // (2) Lifecycle의 CoroutineScope를 만드는 방법 2
        lifecycleScope.launch {
            // ...
        }
    }

    private fun flowWithLifecycle() {
        val viewModel: SampleViewModel by viewModels()
        // (3) Flow.flowWithLifecycle 사용하기 (Flow 1개일 경우)
        lifecycleScope.launch {
            viewModel.value
                .flowWithLifecycle(lifecycle, Lifecycle.State.RESUMED)
                .collect {
                    // ...
                }
        }

        // (4) repeatOnLifecycle 사용하기 (Flow가 2개 이상일 경우)
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.RESUMED) {
                launch {
                    viewModel.value.collect {
                        // ...
                    }
                }

                launch {
                    viewModel.value.collect {
                        // ...
                    }
                }
            }
        }
    }

    private fun launchByLifecycle() {
        val viewModel: SampleViewModel by viewModels()
        // (5) launchWhenResumed 사용하기 (Lifecycle 중 딱 한번만 호출)
        lifecycleScope.launchWhenResumed {
            viewModel.value.collect {
                Log.d("THEEND", "1 launchWhenResumed: $it")
            }
        }

        // (6) repeatOnLifecycle 사용하기 (해당 Lifecycle State 일때마다 호출)
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.RESUMED) {
                viewModel.value.collect {
                    Log.d("THEEND", "2 repeatOnLifecycle: $it")
                }
            }
        }
    }

    private fun whenAndWithStateAtLeast() {
        val viewModel: SampleViewModel by viewModels()
        // [7] whenStateAtLeast 사용하기 (launchWhenXXX 함수 내부에 구현되어있다) (일시중단 블록을 해당 Lifecycle State에 한번만 호출해준다)
        lifecycleScope.launch {
            lifecycle.whenStateAtLeast(Lifecycle.State.RESUMED) {
                // ...
            }
//            lifecycleScope.launchWhenResumed {
//                viewModel.value.collect {
//                    Log.d("THEEND", "1 launchWhenResumed: $it")
//                }
//            }

            // [8] withStateAtLeast 사용하기 (일반함수 블록을 해당 Lifecycle State에 한번만 호출해준다)
            lifecycle.withStateAtLeast(Lifecycle.State.RESUMED) {
                // ...
            }
        }
    }

}