package com.example.zadanierek.data.useCase

import com.example.zadanierek.infrastructure.db.RoomDb
import com.example.zadanierek.infrastructure.db.UserDao
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

const val TAG = "GET_USER_USE_CASE"
class GetUserUseCase @Inject constructor(
    roomDb: RoomDb
) {
    private var userDao: UserDao = roomDb.userDao()
    var usersList = userDao.getAllUsers().onStart { delay(2000) }

}