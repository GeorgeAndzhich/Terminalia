package com.example.terminalia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.terminalia.adapters.FlightAdapter
import com.example.terminalia.models.Airport
import com.example.terminalia.models.Flight
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Flights : AppCompatActivity() {
    private var database = FirebaseDatabase.getInstance()
    private var ref = database.getReference("Airports").child("flights")
    private var flightsList = ArrayList<Flight>()
    private var rvFlights = findViewById<RecyclerView>(R.id.rvFlights)
    private var flightBtn = findViewById<Button>(R.id.button6)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flights)
        CoroutineScope(Dispatchers.IO).launch {
            getFlightList()
        }
        flightBtn.setOnClickListener {
           Intent(this,Confirm::class.java).putExtra("Flight",flightsList[flight]).also{
               startActivity(it)
           }
        }
    }

    private suspend fun getFlightList() {
        ref.addValueEventListener(object: ValueEventListener
            {
                override fun onDataChange(snapshot: DataSnapshot) {
                   if (snapshot.exists())
                   {
                       for (flights in snapshot.children)
                       {
                           val flight = flights.getValue(Flight::class.java)
                           flightsList.add(flight!!)
                           rvFlights.adapter = FlightAdapter(flightsList)
                       }
                   }
                }

                override fun onCancelled(error: DatabaseError) {
                    Toast.makeText(this@Flights,"Невозможно загрузить данные", Toast.LENGTH_SHORT).show()
                }

            }
        )
    }

}