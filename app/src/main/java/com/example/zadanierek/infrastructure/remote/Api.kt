package com.example.zadanierek.infrastructure.remote

import com.example.zadanierek.infrastructure.model.dao.UserDaoItem
import retrofit2.Response
import retrofit2.http.GET

interface Api {
    @GET("users")
    suspend fun getUsersFirstSource(): Response<ArrayList<UserDaoItem>>
}