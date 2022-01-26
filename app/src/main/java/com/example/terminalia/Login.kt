package com.example.terminalia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.w3c.dom.Text

class Login : AppCompatActivity() {
    private lateinit var auth:FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        getSupportActionBar()?.hide()
        val linkText = findViewById<TextView>(R.id.textView4)
        val logInButton = findViewById<Button>(R.id.button)
        var mail = findViewById<EditText>(R.id.editTextTextEmailAddress2).text.toString()
        var password = findViewById<EditText>(R.id.editTextTextPassword).text.toString()
        linkText.setOnClickListener{
           // Toast.makeText(this,"Link has been clicked!",Toast.LENGTH_SHORT).show()
            Intent(this,SignUp::class.java).also {
                startActivity(it)
            }
        }
        logInButton.setOnClickListener{
            GlobalScope.launch(Dispatchers.IO) {
                logIn(mail,password)
            }
        }
    }
    suspend fun  logIn(mail:String,password:String){
        auth.signInWithEmailAndPassword(mail,password).addOnCompleteListener{
            if (it.isSuccessful){
                Toast.makeText(baseContext,"User registered sucessfully!",Toast.LENGTH_LONG).show()
                finish()
            } else {
                Toast.makeText(baseContext,"User  not registered due to ${it.exception}",Toast.LENGTH_LONG).show()
            }
        }
    }
}