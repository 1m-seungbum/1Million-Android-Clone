package com.example.a1million_android_clone

import android.content.DialogInterface
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.CompoundButton
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.activity_signup.*
import kotlinx.android.synthetic.main.fragment_dialog_profile.*
import kotlinx.android.synthetic.main.fragment_dialog_profile.view.*


class SignUpActivity : AppCompatActivity(), ProfileFragmentDialog.OnProfileFragmentInteractionListener,
    GenderFragmentDialog.OnGenderFragmentInteractionListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        val profileDialog = ProfileFragmentDialog()
        val genderDialog = GenderFragmentDialog()

        gender_input.setOnClickListener {
            genderDialog.show(supportFragmentManager, "gender_dialog")
        }

        profile_image.setOnClickListener {
            profileDialog.show(supportFragmentManager, "profile_dialog")
        }

        required_text_first.setOnClickListener {
            // 이용약간 화면 띄우기
        }

        required_text_third.setOnClickListener {
            // 개인정보수집이용 화면 띄우기
        }

        person_all.setOnClickListener { onCheckChanged(person_all) }
        person_option.setOnClickListener { onCheckChanged(person_option) }
        person_required.setOnClickListener { onCheckChanged(person_required) }

        name_input.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {

                if (s != null) {
                    if (s.isEmpty()) {
                        name_layout.isHelperTextEnabled = true
                        name_layout.helperText = "이름을 입력해주세요."
                    } else {
                        name_layout.isHelperTextEnabled = false
                    }
                }

            }

        })



    }

    private fun onCheckChanged(compoundButton: CompoundButton) {
        when (compoundButton.id) {
            R.id.person_all -> {
                if (person_all.isChecked) {
                    person_all.isChecked = true
                    person_option.isChecked = true
                    person_required.isChecked = true
                } else {
                    person_all.isChecked = false
                    person_option.isChecked = false
                    person_required.isChecked = false
                }
            }
            else -> {
                person_all.isChecked = (person_option.isChecked && person_required.isChecked)
            }
        }
    }

    override fun onProfileFragmentInteraction(msg: Uri) {
        Glide.with(this).load(msg).apply(RequestOptions().circleCrop()).into(profile_image)
    }

    override fun onGenderFragmentInteraction(msg: String) {
        gender_input.setText(msg)
    }
}