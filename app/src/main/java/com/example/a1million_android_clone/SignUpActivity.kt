package com.example.a1million_android_clone

import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_signup.*


class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

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



/*
        spinner.setOnItemClickListener { parent, view, position, id ->
            Log.d("asdf", parent.adapter.getItem(position).toString())


            //var genderText = parent.getAdapter().getItem(position)
           // gender_input.text = genderText as Editable?

        //gender_input.text = parent.adapter.getItem(position) as Editable?
        }


 */

        
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
}