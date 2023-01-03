package com.example.zadanierek.infrastructure.remote.implementation

import com.example.zadanierek.data.repository.ApiRepositoryDaily
import com.example.zadanierek.infrastructure.model.remote.UserPackRemoteDaily
import com.example.zadanierek.infrastructure.remote.ApiSecond
import retrofit2.Response
import javax.inject.Inject

class ApiRepositoryDailyImpl @Inject constructor(private val api: ApiSecond): ApiRepositoryDaily {
    override suspend fun getUsersSecondSource(): Response<UserPackRemoteDaily> {
        return api.getUsersSecondSource()
    }
}