package com.lxn.domain.repository

import com.lxn.data.local.model.NoteCacheEntity
import com.lxn.domain.model.Note

/**
 * Created by @Author: Nam_Lx
 * Project : NoteAppKotlin
 * Create Time : 23:16 - 10/03/2022
 * For all issue contact me : namlxcntt@gmail.com
 */
interface NoteRepository {
    suspend fun getAllNotes(): List<NoteCacheEntity>
    suspend fun addNote(note: NoteCacheEntity)

}