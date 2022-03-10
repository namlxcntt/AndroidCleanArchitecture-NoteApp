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
 * Create Time : 23:17 - 10/03/2022
 * For all issue contact me : namlxcntt@gmail.com
 */
class GetAllNotes @Inject constructor(private val noteRepository: NoteRepository, private val noteMapper: NoteMapper) : UseCase<List<Note>, UseCase.None>() {

    override suspend fun run(params: None): Either<Failure, List<Note>> {
        return try {
            Either.Right(noteMapper.mapListNotes(noteRepository.getAllNotes()))
        } catch (exception: Throwable) {
            Either.Left(Failure.DataBaseError)
        }
    }
}