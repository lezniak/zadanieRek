package com.example.zadanierek.infrastructure.model.remote

import com.example.zadanierek.infrastructure.model.User

data class UserRemoteItemDaily(
    val id: String,
    val screenname: String
)

fun UserRemoteItemDaily.toUser(): User{
    return User(nickname = screenname, photo = "Brak", api = 1)
}