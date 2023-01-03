package com.example.zadanierek.infrastructure.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.zadanierek.infrastructure.model.User

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class database: RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object{
        @Volatile
        private var INSTANCE: database? = null

        @Synchronized
        fun getInstance(context: Context): database{
            synchronized(this){
                var instance = INSTANCE

                if(instance == null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        database::class.java,
                        "database")
                        .build()
                }
                INSTANCE = instance
                return instance
            }
        }
    }
}