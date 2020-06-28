package com.example.runningtracker.db

import android.graphics.Bitmap
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "running_table")
data class Run(var img: Bitmap?=null,
val timeStamp:Long=0L,
val avgSpeedInKMPH:Float=0f,
val distanceInMeters:Int=0,
val timeInMillis:Long=0L,
val caloriesBurned:Int=0)
{
    @PrimaryKey(autoGenerate = true)
    var id:Int?=null
}