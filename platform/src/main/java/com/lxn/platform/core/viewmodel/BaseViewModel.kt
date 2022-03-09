package com.lxn.platform.core.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * Created by @Author: Nam_Lx
 * Project : NoteAppKotlin
 * Create Time : 11:20 - 09/03/2022
 * For all issue contact me : namlxcntt@gmail.com
 */
abstract class BaseViewModel : ViewModel() {

    open val errorState = MutableLiveData<String>()
    open val loadingState = MutableLiveData<Boolean>()

    fun setLoading(isLoading: Boolean) {
        loadingState.value = isLoading
    }

    fun setError(error: Throwable) {
        errorState.value = error.message
    }

    abstract fun onDidBindViewModel()
}