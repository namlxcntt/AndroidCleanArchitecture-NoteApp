package com.nlx.noteappkotlin.di

import com.lxn.platform.core.resource.ResourceService
import com.lxn.platform.core.resource.ResourceServiceImpl
import com.lxn.platform.core.resource.sharepref.AppPreference
import com.lxn.platform.core.resource.sharepref.AppPreferenceImpl
import com.nlx.noteappkotlin.R
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.github.inflationx.calligraphy3.CalligraphyConfig
import javax.inject.Singleton

/**
 * Created by @Author: Nam_Lx
 * Project : NoteAppKotlin
 * Create Time : 12:04 - 09/03/2022
 * For all issue contact me : namlxcntt@gmail.com
 */
@InstallIn(SingletonComponent::class)
@Module
object AppModule {
    @Provides
    @Singleton
    fun providerAppPreference(appPreferenceImpl: AppPreferenceImpl): AppPreference {
        return appPreferenceImpl
    }

    @Provides
    @Singleton
    fun provideCalligraphyDefaultConfig(): CalligraphyConfig {
        return CalligraphyConfig.Builder()
            .setDefaultFontPath("fonts/nunito_regular.ttf")
            .setFontAttrId(R.attr.fontPath)
            .build()
    }

    @Provides
    @Singleton
    fun providerResourceServices(resourcesServiceImpl: ResourceServiceImpl): ResourceService {
        return resourcesServiceImpl
    }
}