package com.example.zadanierek.infrastructure.model

import android.os.Parcelable
import androidx.room.Dao
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "users")
@Parcelize
data class User(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val nickname: String,
    val photo: String,
    val api: Int
) : Parcelable
