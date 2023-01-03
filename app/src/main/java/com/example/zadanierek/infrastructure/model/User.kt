package com.example.zadanierek.infrastructure.model

import androidx.room.Dao
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class User(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val nickname: String,
    val photo: String,
    val api: Int
)
