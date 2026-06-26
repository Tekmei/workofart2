package com.example.allittakes.data.models.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.allittakes.data.models.local.dao.UserDao
import com.example.allittakes.data.models.local.db.Converters
import com.example.allittakes.data.models.local.db.UserEntity


@Database(
    entities = [
        UserEntity::class
    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao
}