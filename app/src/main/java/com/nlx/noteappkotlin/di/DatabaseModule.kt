package com.nlx.noteappkotlin.di

import android.content.Context
import androidx.room.Room
import com.lxn.data.local.database.NoteAppDatabase
import com.nlx.noteappkotlin.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created by @Author: Nam_Lx
 * Project : NoteAppKotlin
 * Create Time : 11:42 - 09/03/2022
 * For all issue contact me : namlxcntt@gmail.com
 */
@InstallIn(SingletonComponent::class)
@Module
object DatabaseModule {

    @Provides
    @Singleton
    fun provideLocalDatabase(@ApplicationContext context: Context): NoteAppDatabase {
        return Room.databaseBuilder(context, NoteAppDatabase::class.java, BuildConfig.DATABASE_NAME).build()
    }

}