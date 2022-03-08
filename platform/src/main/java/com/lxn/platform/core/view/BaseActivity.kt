package com.lxn.platform.core.view

import androidx.appcompat.app.AppCompatActivity


/**
 * Created by @Author: Nam_Lx
 * Project : NoteAppKotlin
 * Create Time : 23:58 - 08/03/2022
 * For all issue contact me : namlxcntt@gmail.com
 */
abstract class BaseActivity : AppCompatActivity(), BaseBehavior {
    override fun onError() {
    }

    override fun onLoading() {

    }

    override fun addViewListener() {

    }

    override fun addDataObserver() {

    }
}