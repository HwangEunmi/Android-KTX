package com.kakaovx.android_ktx.viewmodel_ktx

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import com.kakaovx.android_ktx.R

class SampleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // (1) ViewModelProvider로 생성하기
        val viewModel = ViewModelProvider(this).get(SampleViewModel::class.java)

        // (2) Android KTX를 이용한 ViewModel 초기화
        //  implementation "androidx.activity:activity-ktx:1.2.0"
        val viewModel2: SampleViewModel by viewModels()

        supportFragmentManager.beginTransaction()
            .add(R.id.layout, SampleFragment())
            .commit()
    }
}