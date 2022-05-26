package com.example.terminalia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.Sampler
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RestrictTo
import androidx.recyclerview.widget.RecyclerView
import com.example.terminalia.adapters.AirportAdapter
import com.example.terminalia.models.Airport
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Search : AppCompatActivity() {
    private var auth : FirebaseAuth = FirebaseAuth.getInstance()
    private var database = FirebaseDatabase.getInstance()
    private var ref = database.getReference("Airports")
    private var airportList = ArrayList<Airport>()
    private var rvAirport = findViewById<RecyclerView>(R.id.recyclerFligt)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        var logoutButton = findViewById<Button>(R.id.button4)
        var userDisplayText = findViewById<TextView>(R.id.textView5)
        userDisplayText.setText(auth.currentUser?.email.toString())
        logoutButton.setOnClickListener{
            Toast.makeText(this,"Выход...",Toast.LENGTH_SHORT).show()
            auth.signOut()
            Intent(this,Login::class.java).also{
                startActivity(it)
            }
        }
        CoroutineScope(Dispatchers.IO).launch {
            getAirports()
        }

    }

    suspend fun getAirports()
    {
        ref.addValueEventListener(object: ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists())
                {
                    for (airports in snapshot.children)
                    {
                        val airport = airports.getValue(Airport::class.java)
                        airportList.add(airport!!)
                        rvAirport.adapter = AirportAdapter(airportList)
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@Search,"Невозможно загрузить данные",Toast.LENGTH_SHORT).show()
            }
        })
    }

}