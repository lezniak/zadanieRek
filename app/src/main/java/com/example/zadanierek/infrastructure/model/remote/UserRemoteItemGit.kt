package com.example.zadanierek.infrastructure.model.remote

import com.example.zadanierek.infrastructure.model.User

data class UserRemoteItemGit(
    val avatar_url: String,
    val login: String,
)

fun UserRemoteItemGit.toUser():User{
    return User(nickname = login, photo = avatar_url, api = 2)
}