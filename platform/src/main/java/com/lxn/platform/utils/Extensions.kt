package com.lxn.platform.utils

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding

/**
 * Created by @Author: Nam_Lx
 * Project : NoteAppKotlin
 * Create Time : 00:52 - 11/03/2022
 * For all issue contact me : namlxcntt@gmail.com
 */
/**
 * Inflate Layout View Binding with Base RecycleView 2
 */
inline fun <reified V : ViewBinding> ViewGroup.toViewBinding(): V {
    return V::class.java.getMethod(
        "inflate",
        LayoutInflater::class.java,
        ViewGroup::class.java,
        Boolean::class.java
    ).invoke(null, LayoutInflater.from(context), this, false) as V
}
