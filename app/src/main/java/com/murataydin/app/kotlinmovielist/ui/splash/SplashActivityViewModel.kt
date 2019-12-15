package com.murataydin.app.kotlinmovielist.ui.splash

import android.app.Application
import androidx.databinding.ObservableField
import com.murataydin.app.kotlinmovielist.db.AppDatabase
import com.murataydin.app.kotlinmovielist.R
import com.murataydin.app.kotlinmovielist.App
import com.murataydin.app.kotlinmovielist.core.BaseViewModel
import javax.inject.Inject

class SplashActivityViewModel(app: Application) : BaseViewModel(app) {
    // private var examples: LiveData<List<Example>>? = null

    @Inject
    lateinit var db: AppDatabase

    init {
        (app as? App)?.component?.inject(this)
    }

    var appName = ObservableField<String>()



}