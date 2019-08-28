package com.example.bmi_calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val weightTypes = arrayOf("kg","lb")
        val heightTypes = arrayOf("cm","ft")
        var weightT = "kg"
        var heightT = "cm"

        weightType.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, weightTypes)
        heightType.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, heightTypes)

        weightType.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                weightT = weightTypes[p2]
            }

        }

        heightType.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                heightT = heightTypes[p2]
            }

        }

        calculate.setOnClickListener{



        }
    }
}
