package com.example.bmi_calculator

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.media.MediaPlayer
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var song: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val weightTypes = arrayOf("kg","lb")
        val heightTypes = arrayOf("cm","ft")

        var weightT = "kg"
        var heightT = "cm"

        song = MediaPlayer.create(this, R.raw.ohmygod)

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

            if(height.length() > 0 && weight.length() > 0) {

                var w = weight.text.toString().toDouble()
                var h = height.text.toString().toDouble()
                var bmi = 0.0

                heightType.visibility = View.GONE
                weightType.visibility = View.GONE
                height.visibility = View.GONE
                weight.visibility = View.GONE
                calculate.visibility = View.GONE

                back.visibility = View.VISIBLE
                bmiLabel.visibility = View.VISIBLE
                bmiVal.visibility = View.VISIBLE

                if(weightT == "lb"){

                    //pounds to kilograms
                    w *= 0.453592

                }

                if(heightT == "ft"){

                    //feet to centimeters
                    h *= 30.48

                }

                //centimeters to meters
                h *= 0.01

                bmi = w / (h * h)

                //bmiVal.text = bmi.toString()
                bmiVal.text = "%.1f".format(bmi)

                if(bmi < 18.5){
                    //Underweight
                    bmiVal.setTextColor(Color.parseColor("#fff033"))
                }else if(bmi < 24.9){
                    //Normal weight
                    bmiVal.setTextColor(Color.parseColor("#74ff33"))
                }else if(bmi < 29.9){
                    //Overweight
                    bmiVal.setTextColor(Color.parseColor("#ffa833"))
                }else{
                    //Obesity
                    bmiVal.setTextColor(Color.parseColor("#ff3333"))
                    pasta.visibility = View.VISIBLE
                    bowl.visibility = View.VISIBLE
                    song?.start()
                }

            }

        }

        back.setOnClickListener{

            heightType.visibility = View.VISIBLE
            weightType.visibility = View.VISIBLE
            height.visibility = View.VISIBLE
            weight.visibility = View.VISIBLE
            calculate.visibility = View.VISIBLE

            back.visibility = View.GONE
            bmiLabel.visibility = View.GONE
            bmiVal.visibility = View.GONE

            pasta.visibility = View.GONE
            bowl.visibility = View.GONE

        }
    }
}
