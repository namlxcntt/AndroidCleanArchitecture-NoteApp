package com.nlx.noteappkotlin.features.main

import android.util.Log
import androidx.activity.viewModels
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.lxn.domain.model.Note
import com.lxn.platform.core.view.BaseActivity
import com.lxn.platform.utils.observe
import com.nlx.noteappkotlin.databinding.ActivityMainBinding
import com.nlx.noteappkotlin.features.addnote.AddNoteActivity
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(ActivityMainBinding::inflate) {

    @Inject
    lateinit var notesAdapter: NotesAdapter

    override val viewModel: MainViewModel by viewModels()

    override fun addViewListener() {
        binding.apply {
            rcvNotes.apply {
                layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
                addItemDecoration(GridItemDecoration(24, 2, true))
                adapter = notesAdapter
            }
            fabAddNote.setOnClickListener {
                openActivity(AddNoteActivity::class.java)
            }
        }
    }

    override fun onViewLoaded() {
        with(viewModel) {
            observe(listNotes, ::handleNotesList)
        }
        viewModel.loadNotes()
    }

    private fun handleNotesList(list: List<Note>?) {
        if (list != null) {
            notesAdapter.submitList(list)
        }
        Log.e("Namlxcntt", "$list")
    }

    override fun addDataObserver() {

    }

}