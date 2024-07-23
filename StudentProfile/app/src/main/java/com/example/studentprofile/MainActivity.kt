package com.example.studentprofile

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.math.round

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        var sub1: EditText = findViewById(R.id.sub1)
        var sub2: EditText = findViewById(R.id.sub2)
        var sub3: EditText = findViewById(R.id.sub3)
        var spinner: Spinner = findViewById(R.id.spinner)
        var calcbtn: Button = findViewById(R.id.calcbtn)
        var result: TextView = findViewById(R.id.result)

        var options = arrayOf("Total Marks","Percentage","Grade")
        spinner.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,options)

        var flag="Total Marks"
        spinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long){
                flag = options.get(p2)
            }

            override fun onNothingSelected(p0: AdapterView<*>?){

            }
        }

        calcbtn.setOnClickListener{

            var s1 = sub1.text.toString().toDouble()
            var s2 = sub2.text.toString().toDouble()
            var s3 = sub3.text.toString().toDouble()
            var tmarks = 0.0
            var per = ""
            var gr = ""

            if(flag=="Total Marks"){

                tmarks = s1+s2+s3
                result.text = "Total Marks(Out of 300): " + tmarks.toString()
            }
            else if(flag=="Percentage"){

                tmarks = round(((s1+s2+s3)/300)*100 *1000)/1000
                result.text = "Percentage: " + tmarks.toString() + "%"

            }
            else{
                tmarks = ((s1+s2+s3)/300)*100
                if(tmarks>90.0){
                    result.text = "Grade: A"
                }
                else if(tmarks>80.0 && tmarks<90.0 ){
                    result.text = "Grade: B"
                }
                else if(tmarks>70.0 && tmarks<80.0 ){
                    result.text = "Grade: C"
                }
                else{
                    result.text = "Grade: F"
                }

            }


        }

    }
}