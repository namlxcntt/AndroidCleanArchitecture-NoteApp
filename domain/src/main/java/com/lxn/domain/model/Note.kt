package com.lxn.domain.model

/**
 * Created by @Author: Nam_Lx
 * Project : NoteAppKotlin
 * Create Time : 00:31 - 11/03/2022
 * For all issue contact me : namlxcntt@gmail.com
 */
data class Note(
    var uid: Int = 0,
    var date: Long?,
    var title: String?,
    var description: String?,
)