package com.nlx.noteappkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.lxn.data.UserDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val db = UserDatabase.getInstance(this)

        GlobalScope.launch(Dispatchers.IO) {
            val data=  db.userDao.getAll()
            Log.e("Hello", "onCreate: ${data.toString()}", )
        }



    }
}