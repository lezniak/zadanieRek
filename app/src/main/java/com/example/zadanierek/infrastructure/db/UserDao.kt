package com.example.zadanierek.infrastructure.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.zadanierek.infrastructure.model.User
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Query("Select * from users")
    fun getAllUsers() : Flow<List<User>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertUser(user:User)

    @Query("Select * from  users where id = :id")
    fun getUser(id:Int) : Flow<User>

    @Query("DELETE FROM users")
    fun clearTable()
}