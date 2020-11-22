package com.example.runningtracker

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.example.runningtracker.repository.MainRepository
import javax.inject.Inject

class StaticsViewModel @ViewModelInject constructor(
    val mainRepository: MainRepository
):ViewModel() {

    val totalTimeRun = mainRepository.getTotalTime()
    val totalDistance = mainRepository.getTotalDistance()
    val totalCaloriesBurned = mainRepository.getTotalCaloriesBurned()
    val totalAvgSpeed = mainRepository.getTotalSpeed()
    val runSorted = mainRepository.getAllRunSortedByDate()

}