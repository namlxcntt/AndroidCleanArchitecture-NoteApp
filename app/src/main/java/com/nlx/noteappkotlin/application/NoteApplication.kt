package com.nlx.noteappkotlin.application

import android.app.Application
import com.lxn.data.local.database.NoteAppDatabase
import com.lxn.data.local.model.NoteCacheEntity
import dagger.hilt.android.HiltAndroidApp
import io.github.inflationx.calligraphy3.CalligraphyConfig
import io.github.inflationx.calligraphy3.CalligraphyInterceptor
import io.github.inflationx.viewpump.ViewPump
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@HiltAndroidApp
class NoteApplication : Application() {

    @Inject
    lateinit var calligraphyConfig: CalligraphyConfig

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
            database.noteDao.insertNote(
                NoteCacheEntity(
                    1, 1646970653026, "Hello", "Today’s Shoppng List\n" +
                            "Ticket App Travel Website\n" +
                            "Digital marketing Website.\n" +
                            "Apple Cuo noodles\n" +
                            "Nannn efefefefefef"
                ),
            )
            database.noteDao.insertNote(NoteCacheEntity(2, 1646845200000, "Kotlin", "Kotlin Android "))
            database.noteDao.insertNote(
                NoteCacheEntity(
                    3, 1646758800000, "Clean Architecture", "Today’s Shoppng List\n" +
                            "Ticket App Travel Website\n" +
                            "Digital marketing Website.\n" +
                            "Apple Cuo noodles\n"
                )
            )
        }
    }
}