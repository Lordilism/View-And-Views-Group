package com.example.kotlinbasic

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_view_groups.*

class ViewGroupsActivity : AppCompatActivity() {
    companion object{
        fun intent(context: Context): Intent {
            return Intent(context,ViewGroupsActivity::class.java)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_groups)
        btnShare.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND).putExtra(Intent.EXTRA_SUBJECT,"Hello My Friend")
            intent.putExtra(Intent.EXTRA_TEXT,"Be strong my fri")
            intent.type="text/plain"
            startActivity(Intent.createChooser(intent,"How do you want to Share?"))



        }

    }
}