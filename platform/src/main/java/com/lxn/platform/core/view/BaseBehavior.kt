package com.lxn.platform.core.view

/**
 * Created by @Author: Nam_Lx
 * Project : NoteAppKotlin
 * Create Time : 23:58 - 08/03/2022
 * For all issue contact me : namlxcntt@gmail.com
 */
interface BaseBehavior {
    fun addViewListener()
    fun addDataObserver()
    fun onViewLoaded()
    fun onLoading()
    fun onError()
    fun darkModeOff()
    fun darkModeOn()
}