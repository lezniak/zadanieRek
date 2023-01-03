package com.example.zadanierek.data.repository

import com.example.zadanierek.infrastructure.model.remote.UserPackRemoteDaily
import retrofit2.Response

interface ApiRepositoryDaily {
    suspend fun getUsersSecondSource(): Response<UserPackRemoteDaily>
}