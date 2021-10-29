package com.example.terminalia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val linkText = findViewById<TextView>(R.id.textView4)
        linkText.setOnClickListener{
           // Toast.makeText(this,"Link has been clicked!",Toast.LENGTH_SHORT).show()
            Intent(this,SignUp::class.java).also {
                startActivity(it)
            }
        }
    }
}