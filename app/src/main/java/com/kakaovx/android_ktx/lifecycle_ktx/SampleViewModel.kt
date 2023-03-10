package com.kakaovx.android_ktx.lifecycle_ktx

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SampleViewModel : ViewModel() {

    private val _value = MutableStateFlow(0)
    val value: StateFlow<Int> = _value.asStateFlow()

    init {
        viewModelScope.launch {
//            for (i in 0..100) {
                _value.value = 1
//                delay(1000)
            }
        }
    // }
}