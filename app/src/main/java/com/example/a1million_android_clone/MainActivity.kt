package com.example.a1million_android_clone

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 초기화면
        replaceFragment(HomeFragment())

        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when(item.itemId) {
                R.id.page_home -> {
                    replaceFragment(HomeFragment())


                    return@setOnNavigationItemSelectedListener true
                }

                R.id.page_calendar -> {
                    replaceFragment(CalendarFragment())
                    return@setOnNavigationItemSelectedListener true
                }

                R.id.page_streaming -> {
                    replaceFragment(StreamingFragment())
                    return@setOnNavigationItemSelectedListener true
                }

                R.id.page_account -> {
                    replaceFragment(AccountFragment())
                    return@setOnNavigationItemSelectedListener true
                }

                else -> return@setOnNavigationItemSelectedListener false
            }
        }

    }


    private fun replaceFragment(fragment: Fragment) {
        val fragmentTransaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.mainFramelayout, fragment)
        fragmentTransaction.commit()
    }
}