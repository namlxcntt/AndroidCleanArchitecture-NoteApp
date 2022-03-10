package com.nlx.noteappkotlin.features.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.lxn.domain.model.Note
import com.lxn.domain.usecase.GetAllNotes
import com.lxn.platform.core.viewmodel.BaseViewModel
import com.lxn.platform.usecase.UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Created by @Author: Nam_Lx
 * Project : NoteAppKotlin
 * Create Time : 11:48 - 09/03/2022
 * For all issue contact me : namlxcntt@gmail.com
 */
@HiltViewModel
class MainViewModel @Inject constructor(
    private val getAllNotes: GetAllNotes
) : BaseViewModel() {
    private val _listNotes: MutableLiveData<List<Note>> by lazy { MutableLiveData(ArrayList()) }

    val listNotes: LiveData<List<Note>> get() = _listNotes

    fun loadNotes() = getAllNotes(UseCase.None(), viewModelScope) { it.fold(::handleFailure, ::handleNotesList) }

    private fun handleNotesList(notes: List<Note>) {
        _listNotes.value = notes
    }

    override fun onDidBindViewModel() {
    }

}