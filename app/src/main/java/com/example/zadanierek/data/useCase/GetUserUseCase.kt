package com.example.zadanierek.data.useCase

import android.util.Log
import android.widget.Switch
import com.example.zadanierek.data.repository.ApiRepository
import com.example.zadanierek.data.repository.ApiRepositoryDaily
import com.example.zadanierek.infrastructure.model.dao.UserPackRemoteDaily
import com.example.zadanierek.infrastructure.model.dao.UserRemoteItemGit
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
val TAG = "GETUSERUSECASE"
class GetUserUseCase @Inject constructor(private val apiRepository: ApiRepository,
                                        private val apiRepositoryDaily: ApiRepositoryDaily) {

    operator fun invoke() = flow<ArrayList<UserRemoteItemGit>> {
        try {
            val result = apiRepository.getUsersFirstSource()
            val result2 = apiRepositoryDaily.getUsersSecondSource()
            Log.d("Test",result2.body().toString())
        }catch (ex:Exception){
            Log.e(TAG,ex.stackTraceToString())
        }
    }
    private fun cacheDailyData(data:UserPackRemoteDaily){

    }
}