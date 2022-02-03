package com.example.terminalia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.*

class SignUp : AppCompatActivity() {
   private var auth : FirebaseAuth = FirebaseAuth.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up2)
        getSupportActionBar()?.hide()
        var mail= findViewById<EditText>(R.id.editTextTextEmailAddress).text
        var password = findViewById<EditText>(R.id.editTextTextPassword2).text
        val signUpbutton = findViewById<Button>(R.id.button3)
        signUpbutton.setOnClickListener{
            auth.createUserWithEmailAndPassword(mail.toString().trim(),password.toString().trim())
            }
        }
    }

