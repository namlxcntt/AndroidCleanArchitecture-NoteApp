package com.lxn.data.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.lxn.data.local.dao.NoteDao
import com.lxn.data.local.model.NoteCacheEntity

@Database(entities = [NoteCacheEntity::class], version = 1, exportSchema = false)
abstract class NoteAppDatabase : RoomDatabase() {

    abstract val noteDao: NoteDao

    companion object {

        @Volatile
        private var INSTANCE: NoteAppDatabase? = null

        fun getInstance(context: Context): NoteAppDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        NoteAppDatabase::class.java,
                        "user_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}