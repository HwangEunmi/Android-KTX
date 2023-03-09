package com.kakaovx.android_ktx.viewmodel_ktx

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.kakaovx.android_ktx.R

class SampleFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_sample, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // (1) ViewModelProvider로 생성하기
        val viewModel = ViewModelProvider(this).get(SampleViewModel::class.java)
        // (2) Android KTX를 이용한 ViewModel 초기화
        //  implementation "androidx.fragment:fragment-ktx:1.5.5"
        val viewModel2: SampleViewModel by viewModels()
    }
}