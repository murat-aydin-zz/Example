package com.murataydin.app.kotlinmovielist.core

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.murataydin.app.kotlinmovielist.service.OmdbAPI
import javax.inject.Inject

open class BaseViewModel(app: Application) : RxAwareViewModel(app) {

    var progressLiveData = MutableLiveData<Boolean>()

    @Inject
    lateinit var baseApi: OmdbAPI
}

