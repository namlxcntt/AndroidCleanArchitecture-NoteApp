package com.lxn.domain.usecase

import com.lxn.domain.mapper.NoteMapper
import com.lxn.domain.model.Note
import com.lxn.domain.repository.NoteRepository
import com.lxn.platform.exception.Failure
import com.lxn.platform.functional.Either
import com.lxn.platform.usecase.UseCase
import javax.inject.Inject

/**
 * Created by @Author: Nam_Lx
 * Project : NoteAppKotlin
 * Create Time : 01:25 - 11/03/2022
 * For all issue contact me : namlxcntt@gmail.com
 */
class AddNote @Inject constructor(private val noteRepository: NoteRepository, private val noteMapper: NoteMapper) : UseCase<Unit, Note>() {
    override suspend fun run(params: Note): Either<Failure, Unit> {
        return try {
            Either.Right(noteRepository.addNote(noteMapper.mapToEntity(params)))
        } catch (exception: Exception) {
            Either.Left(Failure.DataBaseError)
        }
    }


}