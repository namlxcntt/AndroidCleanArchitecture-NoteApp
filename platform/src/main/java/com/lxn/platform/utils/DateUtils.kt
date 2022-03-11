package com.lxn.platform.utils

import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by @Author: Nam_Lx
 * Project : NoteAppKotlin
 * Create Time : 10:47 - 11/03/2022
 * For all issue contact me : namlxcntt@gmail.com
 */
object DateUtils {
    fun getCurrentDate(currentTime: Long): String? {
        return SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(currentTime)
    }
}