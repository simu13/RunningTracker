package com.example.runningtracker.db

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface RunDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRun(run : Run)
    @Delete
    suspend fun deleteRun(run : Run)
    @Query("SELECT * FROM running_table ORDER BY timeStamp DESC")
    fun getAllListByDate():LiveData<List<Run>>
    @Query("SELECT * FROM running_table ORDER BY timeInMillis DESC")
    fun getAllListBtTime():LiveData<List<Run>>
    @Query("SELECT * FROM running_table ORDER BY caloriesBurned DESC")
    fun getAllListByCalories():LiveData<List<Run>>
    @Query("SELECT * FROM running_table ORDER BY avgSpeedInKMPH DESC")
    fun getAllListByAvgSpeed():LiveData<List<Run>>
    @Query("SELECT * FROM running_table ORDER BY distanceInMeters DESC")
    fun getAllListByDistance():LiveData<List<Run>>

    @Query("SELECT SUM(timeInMillis) FROM running_table")
    fun getTotalTimeRun():LiveData<Long>

    @Query("SELECT SUM(caloriesBurned) FROM running_table")
    fun getTotalCaloriesBurned():LiveData<Int>

    @Query("SELECT SUM(distanceInMeters) FROM running_table")
    fun getTotalDistanceInMeters():LiveData<Int>

    @Query("SELECT AVG(avgSpeedInKMPH) FROM running_table")
    fun getTotalAvgSpeed():LiveData<Float>
}