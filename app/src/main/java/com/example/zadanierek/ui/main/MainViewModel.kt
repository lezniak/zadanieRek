package com.example.zadanierek.ui.main

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.zadanierek.data.useCase.GetRemoteUserUseCase
import com.example.zadanierek.infrastructure.db.RoomDb
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

const val TAG = "MAIN_VIEW_MODEL"
@HiltViewModel
class MainViewModel @Inject constructor(private val roomDb: RoomDb,private val getRemoteUserUseCase: GetRemoteUserUseCase) : ViewModel() {
    fun fetchNewData(){
        CoroutineScope(Dispatchers.Default).launch {
            roomDb.userDao().clearTable()
            Log.d(TAG,"Wyczyszczono baze")
            getRemoteUserUseCase.invoke()
        }
    }
}