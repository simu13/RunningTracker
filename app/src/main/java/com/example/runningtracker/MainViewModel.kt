package com.example.runningtracker

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.runningtracker.db.Run
import com.example.runningtracker.other.SortType
import com.example.runningtracker.repository.MainRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @ViewModelInject constructor(
    var mainRepository: MainRepository
):ViewModel() {

   private val runSortedByDate = mainRepository.getAllRunSortedByDate()
   private val runSortedByDistance = mainRepository.getAllRunSortedByDistance()
   private val runSortedByCaloriesBurned = mainRepository.getAllRunSortedByCalories()
   private val runSortedByTime = mainRepository.getAllRunSortedByTime()
   private val runSortedByAvgSpeed = mainRepository.getAllRunSortedBySpeed()

    val runs = MediatorLiveData<List<Run>>()

    var sortType = SortType.DATE

    init {
        runs.addSource(runSortedByDate){result->
            if (sortType == SortType.DATE)
            {
                result?.let { runs.value = it }
            }
        }
        runs.addSource(runSortedByDistance){result->
            if (sortType == SortType.DISTANCE)
            {
                result?.let { runs.value = it }
            }
        }
        runs.addSource(runSortedByCaloriesBurned){result->
            if (sortType == SortType.CALORIES_BURNED)
            {
                result?.let { runs.value = it }
            }
        }
        runs.addSource(runSortedByTime){result->
            if (sortType == SortType.RUNNING_TIME)
            {
                result?.let { runs.value = it }
            }
        }
        runs.addSource(runSortedByAvgSpeed){result->
            if (sortType == SortType.AVG_SPEED)
            {
                result?.let { runs.value = it }
            }
        }
    }

    fun sortRuns(sortType: SortType) = when(sortType){
        SortType.DATE ->runSortedByDate.value?.let { runs.value = it }
        SortType.DISTANCE ->runSortedByDistance.value?.let { runs.value = it }
        SortType.CALORIES_BURNED ->runSortedByCaloriesBurned.value?.let { runs.value = it }
        SortType.RUNNING_TIME ->runSortedByTime.value?.let { runs.value = it }
        SortType.AVG_SPEED ->runSortedByAvgSpeed.value?.let { runs.value = it }
    }.also { this.sortType = sortType }



    fun insertRun(run:Run) = viewModelScope.launch {
        mainRepository.insertRun(run)
    }
}