package com.nlx.noteappkotlin

import android.app.Application
import android.util.Log
import com.lxn.data.User
import com.lxn.data.UserDatabase
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@HiltAndroidApp
class NoteApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        val db = UserDatabase.getInstance(this)

        GlobalScope.launch(Dispatchers.IO) {
            db.userDao.insertAll(User(1,"Nam","Luong xuan"))
        }

    }
}