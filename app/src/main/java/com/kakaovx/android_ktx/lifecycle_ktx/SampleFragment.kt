package com.kakaovx.android_ktx.lifecycle_ktx

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.kakaovx.android_ktx.R
import kotlinx.coroutines.launch

class SampleFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_sample, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Fragment의 Lifecycle의 CoroutineScope에 접근한다.
        // launch 메소드를 사용하여 새로운 코루틴을 실행한다.
        viewLifecycleOwner.lifecycleScope.launch {
            // ...
        }
    }
}