package com.example.zadanierek.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.zadanierek.data.useCase.GetUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(getUserUseCase: GetUserUseCase) : ViewModel() {
    val allUsersFromDb = getUserUseCase.usersList.asLiveData()

}