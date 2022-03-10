package com.lxn.domain.mapper

import com.lxn.data.local.model.NoteCacheEntity
import com.lxn.domain.model.Note
import com.lxn.platform.utils.EntityMapper
import javax.inject.Inject

/**
 * Created by @Author: Nam_Lx
 * Project : NoteAppKotlin
 * Create Time : 00:31 - 11/03/2022
 * For all issue contact me : namlxcntt@gmail.com
 */
class NoteMapper @Inject constructor() : EntityMapper<NoteCacheEntity, Note> {
    override fun mapFromEntity(entity: NoteCacheEntity): Note {
        return Note(uid = entity.uid, date = entity.date, title = entity.title, description = entity.description)
    }

    override fun mapToEntity(domainModel: Note): NoteCacheEntity {
        return NoteCacheEntity(uid = domainModel.uid, date = domainModel.date, title = domainModel.title, description = domainModel.description)
    }

    fun mapListNotes(listEntity: List<NoteCacheEntity>): List<Note> {
        return listEntity.map {
            mapFromEntity(it)
        }
    }
}