package com.example.a1million_android_clone

import android.content.DialogInterface
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_signup.*
import kotlinx.android.synthetic.main.fragment_dialog_profile.*
import kotlinx.android.synthetic.main.fragment_dialog_profile.view.*


class SignUpActivity : AppCompatActivity(), ProfileFragmentDialog.OnFragmentInteractionListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // 성별 spinner
        gender_input.setOnClickListener {
            ArrayAdapter.createFromResource(
                this,
                R.array.gender_spinner_list,
                android.R.layout.simple_spinner_item
            ).also { adapter ->
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                spinner.adapter = adapter
            }
            spinner.performClick()
        }

        spinner.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View?,
                position: Int,
                id: Long
            ) {
                gender_input.setText(parent.adapter.getItem(position).toString())
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        val profileDialog = ProfileFragmentDialog()

        //supportFragmentManager.beginTransaction().add(R.id.profile_dialog_content1,profileDialog).commit()

        profile_image.setOnClickListener{
            profileDialog.show(supportFragmentManager, "profile_dialog")

        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item?.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
            else -> {
                return super.onOptionsItemSelected(item)
            }
        }
    }

    override fun onFragmentInteraction(msg: Uri) {
        profile_image.setImageURI(msg)
    }
}