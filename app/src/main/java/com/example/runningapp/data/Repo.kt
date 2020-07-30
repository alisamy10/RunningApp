package com.example.runningapp.data

import androidx.lifecycle.LiveData
import javax.inject.Inject

class Repo @Inject constructor ( private val dao: RunDao) :RunDao {
    override suspend fun insertRun(run: RunEntity) =dao.insertRun(run)

    override suspend fun deleteRun(run: RunEntity) = dao.deleteRun(run)

    override fun getAllRunsSortedByDate(): LiveData<List<RunEntity>> = dao.getAllRunsSortedByDate()

    override fun getAllRunsSortedByTimeInMillis(): LiveData<List<RunEntity>> =dao.getAllRunsSortedByTimeInMillis()

    override fun getAllRunsSortedByCaloriesBurned(): LiveData<List<RunEntity>> =dao.getAllRunsSortedByCaloriesBurned()

    override fun getAllRunsSortedByAvgSpeed(): LiveData<List<RunEntity>> =dao.getAllRunsSortedByAvgSpeed()

    override fun getAllRunsSortedByDistance(): LiveData<List<RunEntity>> =dao.getAllRunsSortedByDistance()

    override fun getTotalTimeInMillis(): LiveData<Long> =dao.getTotalTimeInMillis()

    override fun getTotalCaloriesBurned(): LiveData<Int> =dao.getTotalCaloriesBurned()

    override fun getTotalDistance(): LiveData<Int> =dao.getTotalDistance()

    override fun getTotalAvgSpeed(): LiveData<Float> =dao.getTotalAvgSpeed()
}