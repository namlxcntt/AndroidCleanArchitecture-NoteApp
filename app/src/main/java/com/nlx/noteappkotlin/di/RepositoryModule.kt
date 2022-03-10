package com.nlx.noteappkotlin.di

import com.lxn.domain.repository.NoteRepository
import com.lxn.domain.repository.NoteRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * Created by @Author: Nam_Lx
 * Project : NoteAppKotlin
 * Create Time : 23:22 - 10/03/2022
 * For all issue contact me : namlxcntt@gmail.com
 */

@InstallIn(SingletonComponent::class)
@Module
interface RepositoryModule {

    @Binds
    fun providerNoteRepository(noteRepositoryImpl: NoteRepositoryImpl) : NoteRepository
}