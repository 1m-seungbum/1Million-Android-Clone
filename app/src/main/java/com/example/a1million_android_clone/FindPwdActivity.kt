package com.example.a1million_android_clone

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_find_pwd.*

class FindPwdActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_find_pwd)

        find_pwd_button.setOnClickListener {
            // 메일로 변경된 비밀번호 보내주기
        }
    }
}