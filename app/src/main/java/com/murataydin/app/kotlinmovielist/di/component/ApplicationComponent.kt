package com.murataydin.app.kotlinmovielist.di.component

import android.content.Context
import android.content.SharedPreferences
import com.murataydin.app.kotlinmovielist.App
import com.murataydin.app.kotlinmovielist.di.module.ApplicationModule
import com.murataydin.app.kotlinmovielist.di.module.DatabaseModule
import com.murataydin.app.kotlinmovielist.ui.main.MainActivityViewModel

import com.murataydin.app.kotlinmovielist.di.module.NetModule
import com.murataydin.app.kotlinmovielist.ui.splash.SplashActivityViewModel

import dagger.Component
import javax.inject.Singleton


@Singleton

@Component(modules = arrayOf(ApplicationModule::class,NetModule::class,DatabaseModule::class))


interface ApplicationComponent {
    fun app(): App


    fun context(): Context

    fun preferences(): SharedPreferences

    fun inject(mainActivityViewModel: MainActivityViewModel)
    fun inject(splashActivityViewModel: SplashActivityViewModel)
}
