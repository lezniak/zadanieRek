package com.example.zadanierek.data.useCase

import android.util.Log
import com.example.zadanierek.data.repository.ApiRepository
import com.example.zadanierek.infrastructure.model.dao.UserDaoItem
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
val TAG = "GETUSERUSECASE"
class GetUserUseCase @Inject constructor(private val apiRepository: ApiRepository) {
    operator fun invoke() = flow<ArrayList<UserDaoItem>> {
        try {
            val result = apiRepository.getUsersFirstSource()
            emit(result.body()!!)
        }catch (ex:Exception){
            Log.e(TAG,ex.stackTraceToString())
        }

    }
}