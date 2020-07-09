package com.example.runningtracker.ui.fragment

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.runningtracker.R
import com.example.runningtracker.StaticsViewModel

class StaticsFragment:Fragment(R.layout.fragment_statistics) {
    private val viewModel:StaticsViewModel by viewModels()
}