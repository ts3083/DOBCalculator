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
    private var tvAgeInMinutes : TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val Calculate_Date: Button = findViewById(R.id.btnDatePicker)
        tvSelectedDate = findViewById(R.id.tvSelectedDate)
        tvAgeInMinutes = findViewById(R.id.tvAgeInMinutes)

        Calculate_Date.setOnClickListener {
            clickDatePicker()
        }

    }

    fun clickDatePicker() {
        val myCalendar = Calendar.getInstance() // myCalendar는 Calender클래스의 객체
        val year = myCalendar.get(Calendar.YEAR)
        val month = myCalendar.get(Calendar.MONTH)
        val day = myCalendar.get(Calendar.DAY_OF_MONTH)
        val dpd = DatePickerDialog(
            this,
            DatePickerDialog.OnDateSetListener { view, selectedyear, selectedmonth, selectedday ->
                val selectedDate = "$selectedyear/${selectedmonth + 1}/$selectedday"
                Toast.makeText(this, // month는 0부터 세기 때문에 +1해주어야 함
                    "Date seleccted $selectedDate", Toast.LENGTH_LONG).show()
                tvSelectedDate?.text = selectedDate

                val sdf = SimpleDateFormat("yyyy/MM/dd", Locale.KOREA)
                val theDate = sdf.parse(selectedDate) // 위쪽 날짜 형식을 사용하고 싶은 형태로 바꿈

                val selectedDateInMinutes = theDate.time / 60000 // 1970/01/01부터 선택한 날짜까지 시간을 분 단위로

                val currentDate = sdf.parse(sdf.format(System.currentTimeMillis())) // 1970/01/01부터 현재까지 시간을 ms로
                val currentDateInMinutes = currentDate.time / 60000

                val differenceInMinutes = currentDateInMinutes - selectedDateInMinutes // 두 날짜 사이의 차이를 분으로 나타냄
                tvAgeInMinutes?.text = differenceInMinutes.toString()
            },
            year,
            month,
            day
        )
        dpd.datePicker.maxDate = System.currentTimeMillis() - 86400000
        dpd.show()

    }
}