package com.example.terminalia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class Search : AppCompatActivity() {
    private var auth : FirebaseAuth = FirebaseAuth.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        var logoutButton = findViewById<Button>(R.id.button4)
        var userDisplayText = findViewById<TextView>(R.id.textView5)
        userDisplayText.setText(auth.currentUser?.displayName.toString())

        logoutButton.setOnClickListener{
            Toast.makeText(this,"Выход...",Toast.LENGTH_SHORT).show()
            auth.signOut()
            Intent(this,Login::class.java).also{
                startActivity(it)
            }
        }

    }
}