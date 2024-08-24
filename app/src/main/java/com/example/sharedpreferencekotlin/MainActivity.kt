package com.example.sharedpreferencekotlin

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var sharedPreference =  getSharedPreferences("PREFERENCE_NAME", Context.MODE_PRIVATE)

        var setData = findViewById<Button>(R.id.set)
        var readData = findViewById<Button>(R.id.read)
        var deleteData = findViewById<Button>(R.id.delete)


        setData.setOnClickListener {
            var editor = sharedPreference.edit()
            editor.putString("username","Anupam")
            editor.apply()
        }

        readData.setOnClickListener {
            var data = sharedPreference.getString("username","")
            if (data != null) {
                if(data.isNotEmpty()){
                    val i = Intent(this,MainActivity2::class.java)
                    i.putExtra("name",data.toString())
                    startActivity(i)
                }else{
                    Toast.makeText(this, "No Data Found", Toast.LENGTH_SHORT).show()
                }
            }

        }

        deleteData.setOnClickListener {
            var editor = sharedPreference.edit()
            editor.clear()
            editor.apply()
            //editor.remove("username")
        }


    }
}