package com.lxn.domain.repository

import com.lxn.data.local.database.NoteAppDatabase
import com.lxn.data.local.model.NoteCacheEntity
import javax.inject.Inject

/**
 * Created by @Author: Nam_Lx
 * Project : NoteAppKotlin
 * Create Time : 23:16 - 10/03/2022
 * For all issue contact me : namlxcntt@gmail.com
 */
class NoteRepositoryImpl @Inject constructor(private val noteAppDatabase: NoteAppDatabase) : NoteRepository {
    override suspend fun getAllNotes(): List<NoteCacheEntity> {
        return noteAppDatabase.noteDao.getAll()
    }

    override suspend fun addNote(note: NoteCacheEntity) {
        noteAppDatabase.noteDao.insertNote(notes = note)
    }

}