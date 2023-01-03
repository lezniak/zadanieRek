package com.example.zadanierek.ui.main

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.zadanierek.data.repository.ApiRepository
import com.example.zadanierek.data.useCase.GetUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val getUserUseCase: GetUserUseCase) : ViewModel() {

    fun test(){
        viewModelScope.launch(Dispatchers.IO) {
            getUserUseCase.invoke().collect(){
                Log.d("tdas",it.toString())
            }
        }
    }
}