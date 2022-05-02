package com.example.terminalia.models

import java.sql.Time

data class Flight(val Number: String,
                  val Destination: String,
                  val DepartureTime: Time,
                  val ArrivalTime: Time )
