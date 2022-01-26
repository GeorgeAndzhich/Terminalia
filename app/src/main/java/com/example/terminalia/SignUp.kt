package com.example.terminalia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Looper
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class SignUp : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        getSupportActionBar()?.hide()
        var mail= findViewById<EditText>(R.id.editTextTextEmailAddress).text.toString()
        var password = findViewById<EditText>(R.id.editTextTextPassword).text.toString()
        val signUpbutton = findViewById<Button>(R.id.button3)
        signUpbutton.setOnClickListener{
            GlobalScope.launch(Dispatchers.Main) {
                SignUp(mail,password)
            }
        }
    }
    suspend fun  SignUp(mail:String,password:String){
            auth.createUserWithEmailAndPassword(mail,password).addOnCompleteListener{
                if (it.isSuccessful){
                    Toast.makeText(baseContext,"User registered sucessfully!",Toast.LENGTH_LONG).show()
                    finish()
            } else {
                    Toast.makeText(baseContext,"User  not registered due to ${it.exception}",Toast.LENGTH_LONG).show()
                }
            }
    }
}