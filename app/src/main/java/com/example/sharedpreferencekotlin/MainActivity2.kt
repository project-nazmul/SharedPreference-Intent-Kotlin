package com.example.sharedpreferencekotlin

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        var sharedPreference =  getSharedPreferences("PREFERENCE_NAME", Context.MODE_PRIVATE)

        var text = findViewById<TextView>(R.id.textView)
        var button =findViewById<Button>(R.id.button)

        var bundle = intent.extras
        if (bundle != null) {
            var name = bundle.getString("name")
            text.text=name
        }

        button.setOnClickListener {
            var data = sharedPreference.getString("username","")
            Toast.makeText(this, data.toString(), Toast.LENGTH_SHORT).show()
        }
    }
}