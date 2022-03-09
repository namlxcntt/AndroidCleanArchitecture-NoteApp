package com.lxn.platform.core.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.lxn.platform.core.resource.ResourceService
import com.lxn.platform.core.resource.sharepref.AppPreference
import com.lxn.platform.core.viewmodel.BaseViewModel
import javax.inject.Inject

/**
 * Created by @Author: Nam_Lx
 * Project : NoteAppKotlin
 * Create Time : 00:23 - 09/03/2022
 * For all issue contact me : namlxcntt@gmail.com
 */
abstract class BaseFragment<VB : ViewBinding, VM : BaseViewModel>(val bindingFactory: (LayoutInflater) -> VB) : Fragment(), BaseBehavior {
    lateinit var binding: VB

    abstract val viewModel: VM

    @Inject
    lateinit var resourceService: ResourceService

    @Inject
    lateinit var appPreference: AppPreference


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = bindingFactory(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addViewListener()
        addDataObserver()
    }

    override fun onError() {

    }

    override fun onLoading() {

    }

    override fun addViewListener() {

    }

    override fun addDataObserver() {

    }
}