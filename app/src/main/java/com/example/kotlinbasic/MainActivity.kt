package com.example.kotlinbasic

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    companion object{
        fun intent(context: Context):Intent{
            return Intent(context,MainActivity::class.java)

        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageView.setImageResource(R.drawable.image1)
        btnGreeting.setOnClickListener {
            val name= edtName.text.toString()
            Toast.makeText(this, "Hello, $name",Toast.LENGTH_SHORT).show()

        }



    }
}