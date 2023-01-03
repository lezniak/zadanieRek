package com.example.zadanierek.infrastructure.model.remote

import com.example.zadanierek.infrastructure.model.User

data class UserPackRemoteDaily(
    val list: List<UserRemoteItemDaily>,
)

fun UserPackRemoteDaily.toUserList():ArrayList<User>{
    val listNew =  ArrayList<User>()
    list.forEach {
        listNew.add(it.toUser())
    }
    return listNew
}