package com.example.zadanierek.data.repository

import com.example.zadanierek.infrastructure.model.dao.UserPackRemoteDaily
import retrofit2.Response

interface ApiRepositoryDaily {
    suspend fun getUsersSecondSource(): Response<UserPackRemoteDaily>
}