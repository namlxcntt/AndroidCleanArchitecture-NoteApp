package com.nlx.noteappkotlin.features.addnote

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.lxn.domain.model.Note
import com.lxn.domain.usecase.AddNote
import com.lxn.platform.core.viewmodel.BaseViewModel
import com.lxn.platform.functional.onSuccess
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Created by @Author: Nam_Lx
 * Project : NoteAppKotlin
 * Create Time : 01:23 - 11/03/2022
 * For all issue contact me : namlxcntt@gmail.com
 */
@HiltViewModel
class AddNoteViewModel
@Inject constructor(
    private val addNote: AddNote
) : BaseViewModel() {

    fun addNotes(note: Note) = addNote(params = note, viewModelScope) {
        it.onSuccess {
            handleAddNote()
        }
    }

    private fun handleAddNote() {
        Log.e("Namlxcntt", "Add success")
    }

    override fun onDidBindViewModel() {

    }
}