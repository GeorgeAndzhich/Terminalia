package com.example.terminalia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.button2)
        val db = Firebase.database
        val ref = db.reference
        ref.setValue("Connection sucessfull!")
        button.setOnClickListener{
            Intent(this,Login::class.java).also {
                startActivity(it)

            }
        }
    }
}