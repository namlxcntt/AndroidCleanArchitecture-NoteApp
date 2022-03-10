package com.nlx.noteappkotlin.features.addnote

import androidx.activity.viewModels
import com.lxn.domain.model.Note
import com.lxn.platform.core.view.BaseActivity
import com.nlx.noteappkotlin.databinding.ActivityAddNoteBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddNoteActivity : BaseActivity<ActivityAddNoteBinding, AddNoteViewModel>(ActivityAddNoteBinding::inflate) {
    override val viewModel: AddNoteViewModel by viewModels()

    override fun addViewListener() {
        super.addViewListener()
        viewModel.addNotes(Note(155,"11/3/2022","Namlxcntt","Namlxcntt"))
    }

    override fun onViewLoaded() {
        super.onViewLoaded()
    }

    override fun addDataObserver() {
        super.addDataObserver()
    }


}