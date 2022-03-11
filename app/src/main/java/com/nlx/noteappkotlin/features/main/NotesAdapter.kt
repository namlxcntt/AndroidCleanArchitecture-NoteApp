package com.nlx.noteappkotlin.features.main

import android.annotation.SuppressLint
import android.graphics.Rect
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lxn.domain.model.Note
import com.lxn.platform.utils.DateUtils
import com.lxn.platform.utils.toViewBinding
import com.nlx.noteappkotlin.databinding.ItemNoteBinding
import javax.inject.Inject

/**
 * Created by @Author: Nam_Lx
 * Project : NoteAppKotlin
 * Create Time : 00:29 - 11/03/2022
 * For all issue contact me : namlxcntt@gmail.com
 */
class NotesAdapter @Inject constructor() : RecyclerView.Adapter<NotesAdapter.NoteViewHolder>() {
    private val listNotes: ArrayList<Note> = ArrayList()

    @SuppressLint("NotifyDataSetChanged")
    fun submitList(list: List<Note>) {
        listNotes.clear()
        listNotes.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        return NoteViewHolder(parent.toViewBinding())
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.bindData(position)
    }

    override fun getItemCount(): Int {
        return listNotes.size
    }

    inner class NoteViewHolder(private val itemNoteBinding: ItemNoteBinding) : RecyclerView.ViewHolder(itemNoteBinding.root) {
        fun bindData(position: Int) {
            val data = listNotes[position]
            itemNoteBinding.apply {
                tvTitle.text = data.title
                tvDays.text = DateUtils.getCurrentDate(data.date ?: System.currentTimeMillis())
                tvDescription.text = data.description
            }
        }
    }
}

class GridItemDecoration(
    private val spacing: Int,
    private val spanCount: Int,
    private val includeEdge: Boolean
) :
    RecyclerView.ItemDecoration() {

    /**
     * Applies padding to all sides of the [Rect], which is the container for the view
     */
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        val position = parent.getChildAdapterPosition(view) // item position
        val column = position % spanCount // item column
        if (includeEdge) {
            outRect.left =
                spacing - column * spacing / spanCount // spacing - column * ((1f / spanCount) * spacing)
            outRect.right =
                (column + 1) * spacing / spanCount // (column + 1) * ((1f / spanCount) * spacing)
            if (position < spanCount) { // top edge
                outRect.top = spacing
            }
            outRect.bottom = spacing // item bottom
        } else {
            outRect.left =
                column * spacing / spanCount // column * ((1f / spanCount) * spacing)
            outRect.right =
                spacing - (column + 1) * spacing / spanCount // spacing - (column + 1) * ((1f /    spanCount) * spacing)
            if (position >= spanCount) {
                outRect.top = spacing // item top
            }
        }
    }
}