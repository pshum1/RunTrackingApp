package com.example.runningappdaggerhilt.ui.viewmodels

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.example.runningappdaggerhilt.repositories.MainRepository

class StatisticsViewModel @ViewModelInject constructor(
    var mainRepository: MainRepository
): ViewModel(){

}