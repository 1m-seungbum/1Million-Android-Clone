package com.example.a1million_android_clone

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_entrance.*

class EntranceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_entrance)

        // 바탕 이미지 glide 처리
        Glide.with(this.applicationContext)
            .load(R.drawable.bg_entrance)
            .centerCrop()
            .into(entrance_background)

        entrance_login.setOnClickListener {
            // 페이지 이동
            val intent = Intent(this, LogInActivity::class.java)
            startActivity(intent)
        }

        entrance_signup.setOnClickListener {
            // 페이지 이동
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }

    }
}