package com.example.terminalia.models

import android.media.Image

data class Airport(val name:String,
                   val location:String,
                   val photo:Image,
                    val flights: List<Flight>)
