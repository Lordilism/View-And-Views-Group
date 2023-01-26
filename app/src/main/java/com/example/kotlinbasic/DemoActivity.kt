package com.example.kotlinbasic

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

import kotlinx.android.synthetic.main.activity_demo.*
import java.time.format.DateTimeFormatter
import java.util.*

class DemoActivity : AppCompatActivity() {
    companion object{
        fun newIntent(context: Context):Intent{
            return Intent(context,DemoActivity::class.java)
        }

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_demo)
        btn_back.setOnClickListener {
            finish()
        }
        tb_guest_room_light.setOnCheckedChangeListener { _, isChecked ->
            when{
                isChecked->Toast.makeText(this,"light on!",Toast.LENGTH_SHORT).show()
                else->Toast.makeText(this,"light off!", Toast.LENGTH_SHORT).show()

            }
        }
        swt_night_mode.setOnCheckedChangeListener { _, isChecked ->
            when{
                isChecked->Toast.makeText(this,"Night mode On!",Toast.LENGTH_SHORT).show()
                else-> Toast.makeText(this,"Night mode off!",Toast.LENGTH_SHORT).show()
            }
        }


        sb_sound_volume.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                val str= progress.toString()
                tvVolume.text= "$str %"

            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }

        })
        rt_star.setOnRatingBarChangeListener(object :RatingBar.OnRatingBarChangeListener{
            override fun onRatingChanged(ratingBar: RatingBar?, rating: Float, fromUser: Boolean) {
                tvRatingBar.text=rating.toString()
            }

        })

        val carAdapter: ArrayAdapter<Any?> = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_dropdown_item,
            resources.getStringArray(R.array.westCarBrands)

        )
        acCarsSelection.setAdapter(carAdapter)

        btnSelectDate.setOnClickListener {
            val calendar =Calendar.getInstance()
            val day =calendar[Calendar.DAY_OF_MONTH]
            val month =calendar[Calendar.MONTH]
            val year =calendar[Calendar.YEAR]


            val picker = DatePickerDialog(this,DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                    tvSelectedDate.text = "$dayOfMonth/${month+1}/$year"

                 },year,month,day)
            picker.show()
        }

        btnSelectTime.setOnClickListener {
            val calendar =Calendar.getInstance()
            val hour= calendar[Calendar.HOUR_OF_DAY]
            val minute= calendar[Calendar.MINUTE]
            val dateTime= DateTimeFormatter.ofPattern("h:MM a")
             TimePickerDialog(this,TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->
                tvSetTime.text="$hourOfDay:$minute"

            },hour,minute,false).show()

        }
        btnExercise.setOnClickListener {
            startActivity(Intent(MainActivity.intent(this)))
        }
        btnViewGroups.setOnClickListener {
            startActivity(Intent(ViewGroupsActivity.intent(this)))
        }



    }
}