package com.example.zadanierek.data.useCase

import android.util.Log
import com.example.zadanierek.data.repository.ApiRepository
import com.example.zadanierek.data.repository.ApiRepositoryDaily
import com.example.zadanierek.infrastructure.db.RoomDb
import com.example.zadanierek.infrastructure.db.UserDao
import com.example.zadanierek.infrastructure.model.remote.toUser
import com.example.zadanierek.infrastructure.model.remote.toUserList
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.launch
import javax.inject.Inject

class GetRemoteUserUseCase @Inject  constructor(private val apiRepository: ApiRepository,
                           private val apiRepositoryDaily: ApiRepositoryDaily,
                           private val roomDb: RoomDb
) {
    private var userDao: UserDao = roomDb.userDao()
    operator fun invoke(){
        CoroutineScope(Dispatchers.Main).launch{
            try {
                val list = userDao.getAllUsers().firstOrNull()
                if (list.isNullOrEmpty()){
                    getAndCacheDataDaily()
                    getAndCacheDataGit()
                }
            }catch (ex:Exception){
                Log.e(TAG,ex.stackTraceToString())
            }finally {
                Log.d(TAG,"POBRANO WSZYSTKICH USEROW - REMOTE")
            }
        }
    }

    private fun getAndCacheDataDaily(){
        CoroutineScope(Dispatchers.IO).launch {
            val result = apiRepositoryDaily.getUsersSecondSource().body()?.toUserList()

            result?.forEach {
                userDao.insertUser(it)
            }
        }
    }

    private fun getAndCacheDataGit(){
        CoroutineScope(Dispatchers.IO).launch {
            apiRepository.getUsersFirstSource().body()?.forEach {
                userDao.insertUser(it.toUser())
            }
        }
    }
}