package com.example.zadanierek.infrastructure.remote

import com.example.zadanierek.infrastructure.model.remote.UserPackRemoteDaily
import retrofit2.Response
import retrofit2.http.GET

interface ApiSecond {
    @GET("users")
    suspend fun getUsersSecondSource(): Response<UserPackRemoteDaily>
}