package com.example.zadanierek.data.useCase

import android.util.Log
import androidx.lifecycle.asLiveData
import com.example.zadanierek.data.repository.ApiRepository
import com.example.zadanierek.data.repository.ApiRepositoryDaily
import com.example.zadanierek.infrastructure.db.UserDao
import com.example.zadanierek.infrastructure.db.RoomDb
import com.example.zadanierek.infrastructure.model.User
import com.example.zadanierek.infrastructure.model.remote.toUser
import com.example.zadanierek.infrastructure.model.remote.toUserList
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.delayFlow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject
const val TAG = "GET_USER_USE_CASE"
class GetUserUseCase @Inject constructor(private val apiRepository: ApiRepository,
                                         private val apiRepositoryDaily: ApiRepositoryDaily,
                                         private val roomDb: RoomDb) {
    private var userDao: UserDao = roomDb.userDao()
    var usersList = userDao.getAllUsers().onStart { delay(2000) }

}