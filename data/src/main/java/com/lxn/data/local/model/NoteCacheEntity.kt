package com.lxn.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by @Author: Nam_Lx
 * Project : NoteAppKotlin
 * Create Time : 23:46 - 09/03/2022
 * For all issue contact me : namlxcntt@gmail.com
 */
@Entity(tableName = "note_cache")
data class NoteCacheEntity(
    @PrimaryKey(autoGenerate = true) var uid: Int,
    @ColumnInfo(name = "date") var date: Long?,
    @ColumnInfo(name = "title") var title: String?,
    @ColumnInfo(name = "description") var description: String?,
)