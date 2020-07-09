package com.example.runningtracker.repository

import com.example.runningtracker.db.Run
import com.example.runningtracker.db.RunDAO
import javax.inject.Inject

class MainRepository @Inject constructor(
    val runDAO: RunDAO
) {
    suspend fun insertRun(run:Run)=runDAO.insertRun(run)

    suspend fun deleteRun(run:Run)=runDAO.deleteRun(run)

    fun getAllRunSortedByDate()=runDAO.getAllListByDate()

    fun getAllRunSortedBySpeed()=runDAO.getAllListByAvgSpeed()

    fun getAllRunSortedByCalories()=runDAO.getAllListByCalories()

    fun getAllRunSortedByDistance()=runDAO.getAllListByDistance()

    fun getAllRunSortedByTime()=runDAO.getAllListBtTime()

    fun getTotalSpeed()=runDAO.getTotalAvgSpeed()

    fun getTotalDistance()=runDAO.getTotalDistanceInMeters()

    fun getTotalCaloriesBurned()=runDAO.getTotalCaloriesBurned()

    fun getTotalTime()=runDAO.getTotalTimeRun()
}