package com.lxn.data.local.dao

import androidx.room.*
import com.lxn.data.local.model.NoteCacheEntity

@Dao
interface NoteDao {
    @Query("SELECT * FROM note_cache")
    suspend fun getAll(): List<NoteCacheEntity>

//    @Query("SELECT * FROM note_cache WHERE uid IN (:idNotes)")
//    fun loadAllByIds(idNotes: IntArray): List<NoteCacheEntity>
//
//    @Query("SELECT * FROM note_cache WHERE first_name LIKE :first AND " + "last_name LIKE :last LIMIT 1")
//    fun findByName(first: String, last: String): NoteCacheEntity

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertNote(notes: NoteCacheEntity)

    @Delete
    suspend fun delete(note: NoteCacheEntity)
}