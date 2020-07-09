package com.example.runningtracker

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.example.runningtracker.repository.MainRepository
import javax.inject.Inject

class MainViewModel @ViewModelInject constructor(
    val mainRepository: MainRepository
):ViewModel() {
}