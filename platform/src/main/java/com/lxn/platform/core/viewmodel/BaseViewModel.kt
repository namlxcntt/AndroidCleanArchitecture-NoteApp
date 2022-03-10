package com.lxn.platform.core.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lxn.platform.exception.Failure

/**
 * Created by @Author: Nam_Lx
 * Project : NoteAppKotlin
 * Create Time : 11:20 - 09/03/2022
 * For all issue contact me : namlxcntt@gmail.com
 */
abstract class BaseViewModel : ViewModel() {

    open val errorState = MutableLiveData<String>()
    open val loadingState = MutableLiveData<Boolean>()

    private val _failure: MutableLiveData<Failure> = MutableLiveData()
    val failure: LiveData<Failure> = _failure

    fun setLoading(isLoading: Boolean) {
        loadingState.value = isLoading
    }

    fun setError(error: Throwable) {
        errorState.value = error.message
    }
    protected fun handleFailure(failure: Failure) {
        _failure.value = failure
    }
    abstract fun onDidBindViewModel()
}