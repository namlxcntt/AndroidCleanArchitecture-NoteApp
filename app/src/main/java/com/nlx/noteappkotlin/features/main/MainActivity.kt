package com.nlx.noteappkotlin.features.main

import android.content.res.ColorStateList
import androidx.activity.viewModels
import com.lxn.platform.core.view.BaseActivity
import com.lxn.platform.utils.ThemeHelper
import com.nlx.noteappkotlin.R
import com.nlx.noteappkotlin.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(ActivityMainBinding::inflate) {

    override val viewModel: MainViewModel by viewModels()

    override fun addViewListener() {
    }

    override fun onViewLoaded() {
//        ThemeHelper.applyTheme(ThemeHelper.DARK_MODE)
    }

    override fun darkModeOn() {
        binding.fabAddNote.imageTintList = ColorStateList.valueOf(resourceService.getColor(R.color.white))
    }

    override fun darkModeOff() {
        binding.fabAddNote.imageTintList = ColorStateList.valueOf(resourceService.getColor(R.color.black))
    }

    override fun addDataObserver() {

    }

}