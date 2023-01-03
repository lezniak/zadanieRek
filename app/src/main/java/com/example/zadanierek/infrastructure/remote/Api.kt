package com.example.zadanierek.infrastructure.remote

import com.example.zadanierek.infrastructure.model.remote.UserRemoteItemGit
import retrofit2.Response
import retrofit2.http.GET

interface Api {
    @GET("users")
    suspend fun getUsersFirstSource(): Response<ArrayList<UserRemoteItemGit>>

}