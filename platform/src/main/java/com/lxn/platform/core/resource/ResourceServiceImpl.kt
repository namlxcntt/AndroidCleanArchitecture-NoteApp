package com.lxn.platform.core.resource

import android.content.Context
import androidx.core.content.res.ResourcesCompat
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

/**
 * Created by @Author: Nam_Lx
 * Project : NoteAppKotlin
 * Create Time : 10:56 - 09/03/2022
 * For all issue contact me : namlxcntt@gmail.com
 */
class ResourceServiceImpl @Inject constructor(
    @ApplicationContext private val context : Context
) : ResourceService {
    override fun getString(key: String): String {
        val identifier = context.resources.getIdentifier(key, "string", context.packageName)
        return if (identifier == 0) key else context.resources.getString(identifier)
    }

    override fun getString(key: String, vararg args: Any): String {
        val identifier = context.resources.getIdentifier(key, "string", context.packageName)
        return if (identifier == 0) key else context.resources.getString(identifier, *args)
    }

    override fun getString(key: Int, vararg args: Any): String {
        return context.resources.getString(key, *args)
    }

    override fun getColor(colorId: Int): Int {
        return ResourcesCompat.getColor(context.resources, colorId, context.resources.newTheme())
    }
}