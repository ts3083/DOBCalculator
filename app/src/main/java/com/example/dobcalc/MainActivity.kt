package com.example.dobcalc

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    private var tvSelectedDate : TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val Calculate_Date: Button = findViewById(R.id.btnDatePicker)
        tvSelectedDate = findViewById(R.id.tvSelectedDate)

        Calculate_Date.setOnClickListener {
            clickDatePicker()
        }

    }

    fun clickDatePicker() {
        val myCalendar = Calendar.getInstance() // myCalendar는 Calender클래스의 객체
        val year = myCalendar.get(Calendar.YEAR)
        val month = myCalendar.get(Calendar.MONTH)
        val day = myCalendar.get(Calendar.DAY_OF_MONTH)
        DatePickerDialog(
            this,
            DatePickerDialog.OnDateSetListener { view, selectedyear, selectedmonth, selectedday ->
                val selectedDate = "$selectedyear/${selectedmonth + 1}/$selectedday"
                Toast.makeText(this, // month는 0부터 세기 때문에 +1해주어야 함
                    "Year seleccted $selectedDate", Toast.LENGTH_LONG).show()
                tvSelectedDate?.text = selectedDate

                val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
                val theDate = sdf.parse(selectedDate) // 위쪽 날짜 형식을 사용하고 싶은 형태로 바꿈

            },
            year,
            month,
            day
            ).show()
    }
}