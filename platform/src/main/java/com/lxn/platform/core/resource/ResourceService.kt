package com.lxn.platform.core.resource

/**
 * Created by @Author: Nam_Lx
 * Project : NoteAppKotlin
 * Create Time : 10:56 - 09/03/2022
 * For all issue contact me : namlxcntt@gmail.com
 */
interface ResourceService {
    fun getString(key: String): String
    fun getString(key: String, vararg args: Any): String
    fun getString(key: Int, vararg args: Any): String
    fun getColor(colorId: Int): Int
}