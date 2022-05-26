package com.example.terminalia.adapters

import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.terminalia.R
import com.example.terminalia.models.Flight
import com.google.firebase.database.FirebaseDatabase

class FlightAdapter (private val list: List<Flight>) : RecyclerView.Adapter<FlightAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val database = FirebaseDatabase.getInstance()
        val reference = database.getReference("Airports").child("flights")
        val flightCode = view.findViewById<TextView>(R.id.textView25)
        val flightFrom = view.findViewById<TextView>(R.id.textView27)
        val flightTo = view.findViewById<TextView>(R.id.textView29)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlightAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.flight_layout,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: FlightAdapter.ViewHolder, position: Int) {
       holder.flightCode.text = list[position].Number
        holder.flightFrom.text = list[position].From
        holder.flightTo.text = list[position].To
    }

    override fun getItemCount(): Int = list.size
}
