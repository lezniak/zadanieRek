package com.example.zadanierek.infrastructure.remote

import com.example.zadanierek.infrastructure.model.dao.UserPackRemoteDaily
import com.example.zadanierek.infrastructure.model.dao.UserRemoteItemDaily
import retrofit2.Response
import retrofit2.http.GET

interface ApiSecond {
    @GET("users")
    suspend fun getUsersSecondSource(): Response<UserPackRemoteDaily>
}