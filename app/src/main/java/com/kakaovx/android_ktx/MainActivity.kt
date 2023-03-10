package com.kakaovx.android_ktx

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.kakaovx.android_ktx.lifecycle_ktx.SampleViewModel
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel: SampleViewModel by viewModels()
        lifecycleScope.launchWhenResumed {
            viewModel.value.collect {
                Log.d("THEEND", "1 launchWhenResumed: $it")
            }
        }

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.RESUMED) {
                viewModel.value.collect {
                    Log.d("THEEND", "2 repeatOnLifecycle: $it")
                }
            }
        }
    }
}