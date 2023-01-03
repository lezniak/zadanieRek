package com.example.zadanierek.infrastructure.remote.implementation

import com.example.zadanierek.data.repository.ApiRepository
import com.example.zadanierek.infrastructure.model.remote.UserRemoteItemGit
import com.example.zadanierek.infrastructure.remote.Api
import retrofit2.Response
import javax.inject.Inject

class ApiRepositoryImpl @Inject constructor(private val api: Api):ApiRepository {
    override suspend fun getUsersFirstSource(): Response<ArrayList<UserRemoteItemGit>> {
        return api.getUsersFirstSource()
    }

}