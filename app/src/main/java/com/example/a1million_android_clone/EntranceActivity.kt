package com.example.a1million_android_clone

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_entrance.*


class EntranceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_entrance)

        log_in.setOnClickListener {
            // 페이지 이동
            val intent = Intent(this, LogInActivity::class.java)
            startActivity(intent)
        }

        sign_up.setOnClickListener {
            // 페이지 이동
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }

    }
/*
    fun getVersion(context: Context): String? {

        var versionName = ""
        try {
            val packageManger = context.packageManager.getPackageInfo(context.packageName, 0)
            versionName = packageManger.versionName
        } catch (e: Exception) {

        }

        return versionName
    }

 */
}