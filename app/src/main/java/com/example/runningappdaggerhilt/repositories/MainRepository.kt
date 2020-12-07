package com.example.runningappdaggerhilt.repositories

import com.example.runningappdaggerhilt.db.Run
import com.example.runningappdaggerhilt.db.RunDAO
import javax.inject.Inject

class MainRepository @Inject constructor(
    val runDao: RunDAO
) {

    suspend fun insertRun(run: Run) = runDao.insertRun(run)

    suspend fun deleteRun(run: Run) = runDao.deleteRun(run)

    fun getAllRunsByDate() = runDao.getAllRunsByDate()

    fun getAllRunsByAvgSpeed() = runDao.getAllRunsByAvgSpeed()

    fun getAllRunsByCaloriesBurned() = runDao.getAllRunsByCaloriesBurned()

    fun getAllRunsByTimeInMillis() = runDao.getAllRunsByMillis()

    fun getAllRunsByDistance() = runDao.getAllRunsByDistance()

    fun getAvgSpeed() = runDao.getAverageSpeed()

    fun getTotalCaloriesBurned() = runDao.getTotalCaloriesBurned()

    fun getTotalDistance() = runDao.getTotalDistance()

    fun getTotalTimeInMillis() = runDao.getTotalTimeInMillis()

}