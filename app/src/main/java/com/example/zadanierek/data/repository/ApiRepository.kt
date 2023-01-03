package com.example.zadanierek.data.repository

import com.example.zadanierek.infrastructure.model.remote.UserRemoteItemGit
import retrofit2.Response

interface ApiRepository {
    suspend fun getUsersFirstSource(): Response<ArrayList<UserRemoteItemGit>>
}