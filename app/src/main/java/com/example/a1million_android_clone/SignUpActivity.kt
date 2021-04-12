package com.example.a1million_android_clone

import android.content.DialogInterface
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.activity_signup.*
import kotlinx.android.synthetic.main.fragment_dialog_profile.*
import kotlinx.android.synthetic.main.fragment_dialog_profile.view.*


class SignUpActivity : AppCompatActivity(), ProfileFragmentDialog.OnProfileFragmentInteractionListener, GenderFragmentDialog.OnGenderFragmentInteractionListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        val profileDialog = ProfileFragmentDialog()
        val genderDialog = GenderFragmentDialog()

        gender_input.setOnClickListener {
            genderDialog.show(supportFragmentManager, "gender_dialog")
        }

        profile_image.setOnClickListener{
            profileDialog.show(supportFragmentManager, "profile_dialog")
        }

    }

     override fun onProfileFragmentInteraction(msg: Uri) {
        //글라이드 커스텀 이미지뷰
        Glide.with(this).load(msg).apply(RequestOptions().circleCrop()).into(profile_image)
    }

    override fun onGenderFragmentInteraction(msg: String) {

        gender_input.setText(msg)
    }
}