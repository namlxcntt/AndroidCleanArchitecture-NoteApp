package com.nlx.noteappkotlin.features.addnote

import android.app.Activity
import androidx.activity.viewModels
import com.lxn.domain.model.Note
import com.lxn.platform.core.view.BaseActivity
import com.lxn.platform.utils.observe
import com.nlx.noteappkotlin.databinding.ActivityAddNoteBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddNoteActivity : BaseActivity<ActivityAddNoteBinding, AddNoteViewModel>(ActivityAddNoteBinding::inflate) {

    override val viewModel: AddNoteViewModel by viewModels()

    override fun addViewListener() {
        super.addViewListener()
        binding.btnDone.setOnClickListener {
            viewModel.addNotes(
                Note(
                    title = binding.edtTitle.text.toString(),
                    date = System.currentTimeMillis(),
                    description = binding.edtDescription.text.toString()
                )
            )
        }
    }

    override fun addDataObserver() {
        super.addDataObserver()
        with(viewModel) {
            observe(addNoteSuccess, ::handleAddNoteSuccess)
        }
    }

    private fun handleAddNoteSuccess(boolean: Boolean?) {
        setResult(Activity.RESULT_OK)
        finish()
    }


}