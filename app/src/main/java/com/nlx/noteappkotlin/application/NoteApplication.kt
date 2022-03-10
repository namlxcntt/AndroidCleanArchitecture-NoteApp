package com.nlx.noteappkotlin.application

import android.app.Application
import com.lxn.data.local.database.NoteAppDatabase
import com.lxn.data.local.model.NoteCacheEntity
import dagger.hilt.android.HiltAndroidApp
import io.github.inflationx.calligraphy3.CalligraphyConfig
import io.github.inflationx.calligraphy3.CalligraphyInterceptor
import io.github.inflationx.viewpump.ViewPump
import kotlinx.coroutines.*
import javax.inject.Inject

@HiltAndroidApp
class NoteApplication : Application() {

    @Inject
    lateinit var calligraphyConfig : CalligraphyConfig

    @Inject
    lateinit var database: NoteAppDatabase

    override fun onCreate() {
        super.onCreate()
        ViewPump.init(
            ViewPump.builder()
                .addInterceptor(CalligraphyInterceptor(calligraphyConfig))
                .build()
        )
        runBlocking {
            database.noteDao.insertNote(NoteCacheEntity(1,"10/3/2022","Hello","World"),)
            database.noteDao.insertNote(NoteCacheEntity(2,"10/3/2022","Hello","World"),)
            database.noteDao.insertNote(NoteCacheEntity(3,"10/3/2022","Hello","World"),)
        }
    }
}