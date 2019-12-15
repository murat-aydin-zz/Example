package com.murataydin.app.kotlinmovielist

import com.google.firebase.FirebaseApp
import com.murataydin.app.kotlinmovielist.di.component.DaggerApplicationComponent
import com.murataydin.app.kotlinmovielist.di.module.ApplicationModule

class App : android.app.Application() {

    val component by lazy {
        DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this))
                .build()
    }

    override fun onCreate() {
        super.onCreate()
        FirebaseApp.initializeApp(this)
    }
}

