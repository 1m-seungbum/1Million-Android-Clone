package com.example.a1million_android_clone

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.toolbar_back.*

class TermsServiceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_terms_service)

        // 툴바 뒤로가기 버튼
        toolbar_back_button.setOnClickListener {
            finish()
        }
    }
}