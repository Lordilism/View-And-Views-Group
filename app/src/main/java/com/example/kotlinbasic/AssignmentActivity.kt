package com.example.kotlinbasic

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CompoundButton
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_assignment.*


class AssignmentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_assignment)
        val imageResource = listOf<Int>(R.drawable.image1,
                                        R.drawable.image2,
                                        R.drawable.image3,
                                        R.drawable.image4,
                                        R.drawable.image5,
                                        R.drawable.image6,
                                        R.drawable.image7,
                                        R.drawable.image8,
                                        R.drawable.image9,
                                        R.drawable.image10)
        btRandom.setOnClickListener {
            ivRandom.setImageResource(imageResource.random())
        }

        btnDone.setOnClickListener {
            var seletedItem:String=""
            if (cbPortrait.isChecked){
                seletedItem+= getString(R.string.portrait)
            }
            if (cbLandscape.isChecked){
                seletedItem+= getString(R.string.landscape)
            }
            if (cbSeascape.isChecked){
                seletedItem += getString(R.string.seascape)
            }

            val alertDialog = AlertDialog.Builder(this).create()
            alertDialog.setTitle(getString(R.string.notice))
            alertDialog.setMessage(seletedItem)
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL,"OK",DialogInterface.OnClickListener{dialog, which -> dialog.dismiss() })
            alertDialog.show()
        }
        btn_next.setOnClickListener {
            startActivity(Intent(DemoActivity.newIntent(this)))
        }




    }

    fun onRaioButtonClicked(view: View) {
        if (view is RadioButton){
            val checked = view.isChecked
            when(view.getId()){
                R.id.rbMale->
                    if (checked){
                        Toast.makeText(this,R.string.rb_male,Toast.LENGTH_SHORT).show()
                    }
                R.id.rbFemale->if (checked){
                    Toast.makeText(this,R.string.rb_female,Toast.LENGTH_SHORT).show()}
            }
        }
    }
}