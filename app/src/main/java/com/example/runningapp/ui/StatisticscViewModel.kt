package com.example.runningapp.ui

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.example.runningapp.data.Repo

class StatisticscViewModel @ViewModelInject constructor (private val repo: Repo):ViewModel() {


    val totalTimeRun = repo.getTotalTimeInMillis()
    val totalDistance = repo.getTotalDistance()
    val totalCaloriesBurned = repo.getTotalCaloriesBurned()
    val totalAvgSpeed = repo.getTotalAvgSpeed()

    val runsSortedByDate = repo.getAllRunsSortedByDate()
}