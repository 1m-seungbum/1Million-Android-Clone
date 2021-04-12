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

        // 이름 입력
        name_input.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {

                if (s != null) {
                    if (s.isEmpty()) { // 입력 받지 못했을시 helper 보여줌
                        name_layout.isHelperTextEnabled = true
                        name_layout.helperText = "이름을 입력해주세요."
                    } else { // 입력 받았을시 helper 삭제
                        name_layout.isHelperTextEnabled = false
                    }
                }

            }

        })

        // 이메일 입력
        mail_input.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                if (s != null) {
                    if (s.isEmpty()) { // 입력을 받지 못했을시 helper 표시
                        mail_layout.isHelperTextEnabled = true
                        mail_layout.helperText = "이메일을 입력해주세요."
                    } else if (!isValidMail(s.toString())) { // 이메일 형식에 맞지 않는 입력일시 helper 표시
                        mail_layout.isHelperTextEnabled = true
                        mail_layout.helperText = "이메일 형식이 아닙니다."
                    } else { // 제대로된 입력을 받았을시 helper 삭제
                        mail_layout.isHelperTextEnabled = false
                    }
                }
            }
        })

        // 비밀번호 입력
        pwd_input.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                if (s != null) {
                    if (s.isEmpty()) { // 입력을 받지 못했을시 helper 표시
                        pwd_layout.isHelperTextEnabled = true
                        pwd_layout.helperText = "비밀번호를 입력해주세요."
                    } else if (!isValidPwd(s.toString())) { // 이메일 형식에 맞지 않는 입력일시 helper 표시
                        pwd_layout.isHelperTextEnabled = true
                        pwd_layout.helperText = "비밀번호 형식이 아닙니다."
                    } else { // 제대로된 입력을 받았을시 helper 삭제
                        pwd_layout.isHelperTextEnabled = false
                    }
                }
            }
        })

        // 비밀번호 확인 입
        pwd_confirm_input.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                if (s != null) {
                    if (s.isEmpty()) { // 새비밀번호 입력을 안받았을시 helepr 표시
                        pwd_confirm_layout.isHelperTextEnabled = true
                        pwd_confirm_layout.helperText = "새 비밀번호 확인을 입력해주세요."
                    } else if (pwd_input.length() == 0) { // 비밀번호 입력을 안받았을시 helper 표시
                        pwd_confirm_layout.isHelperTextEnabled = true
                        pwd_confirm_layout.helperText = "비밀번호를 입력해주세요."
                    } else if (!isValidPwdConfirm(s.toString())) { // 비밀번호와 새 비밀번호가 같지 않을시 helper 표시
                        pwd_confirm_layout.isHelperTextEnabled = true
                        pwd_confirm_layout.helperText = "새비밀번호와 일치하지 않습니다."
                    } else { // 비밀번호랑 같은 입력을 받았을시 helper 삭제
                        pwd_confirm_layout.isHelperTextEnabled = false
                    }
                }
            }
        })

    }

    // 새비밀번호와 비밀번호가 같은지 검사
    private fun isValidPwdConfirm(pwdConfirm: String): Boolean {
        return pwdConfirm == pwd_input.text.toString()
    }

    // 비밀번호 유효성 검사 숫자, 문자가 있는지 8글자 이상인지
    private fun isValidPwd(pwd: String): Boolean {

        val regexLetter = "\\w+[a-zA-Z]\\w+"
        val regexDigit = "\\w+[0-9]\\w+"

        return regexLetter.toRegex().matches(pwd) && regexDigit.toRegex().matches(pwd) && pwd.length >= 8
    }

    // 이메일 유효성 검사
    private fun isValidMail(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }


    // 이용약관 선택, 필수 all 처리 이벤트
    private fun onCheckChanged(compoundButton: CompoundButton) {
        when (compoundButton.id) {
            //all 선택시
            R.id.person_all -> {
                // all ture 일시 모두 tre
                if (person_all.isChecked) {
                    person_all.isChecked = true
                    person_option.isChecked = true
                    person_required.isChecked = true
                } else { // all 해제시 모두 false
                    person_all.isChecked = false
                    person_option.isChecked = false
                    person_required.isChecked = false
                }
            }
            else -> { // 선택과 옵션 두개 모두 선택했을시 all true
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