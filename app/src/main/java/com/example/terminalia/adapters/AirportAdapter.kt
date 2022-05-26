package com.example.terminalia.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.terminalia.Flights
import com.example.terminalia.R
import com.example.terminalia.Search
import com.example.terminalia.models.Airport
import com.example.terminalia.models.Flight
import com.google.firebase.database.FirebaseDatabase
import kotlin.coroutines.coroutineContext

class AirportAdapter(private val list: List<Airport>) : RecyclerView.Adapter<AirportAdapter.ViewHolder>() {
   inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val database = FirebaseDatabase.getInstance()
        val reference = database.getReference("Airports")
        val airportName = view.findViewById<TextView>(R.id.textView2)
        val airportLocation = view.findViewById<TextView>(R.id.textView7)
        val airportImage = view.findViewById<ImageView>(R.id.imageView)

    }

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): AirportAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.airport_layout,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: AirportAdapter.ViewHolder, position: Int) {
        holder.airportName.text = list[position].name
        holder.airportLocation.text = list[position].location
        //holder.airportImage.setImageURI() ovo moramo da pogledamo ili preko cloud storage ili URI
    }

    override fun getItemCount(): Int = list.size
}
