package com.example.zadanierek.infrastructure.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.zadanierek.infrastructure.model.User

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class RoomDb: RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object{
        @Volatile
        private var INSTANCE: RoomDb? = null

        @Synchronized
        fun getInstance(context: Context): RoomDb{
            synchronized(this){
                var instance = INSTANCE

                if(instance == null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        RoomDb::class.java,
                        "database")
                        .build()
                }
                INSTANCE = instance
                return instance
            }
        }
    }
}