package com.example.dobcalc

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val Calculate_Date: Button = findViewById(R.id.btnDatePicker)

        Calculate_Date.setOnClickListener {
            clickDatePicker()
        }

    }

    fun clickDatePicker() {
        Toast.makeText(this,
            "btnDatePicker pressed", Toast.LENGTH_LONG).show()

        val myCalendar = Calendar.getInstance() // myCalendar는 Calender클래스의 객체
        val year = myCalendar.get(Calendar.YEAR)
        val month = myCalendar.get(Calendar.MONTH)
        val day = myCalendar.get(Calendar.DAY_OF_MONTH)
        val listener = DatePickerDialog.OnDateSetListener { view, year, month, day ->  }
        DatePickerDialog(this, listener, year, month, day)
    }
}