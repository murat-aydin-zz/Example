package com.murataydin.app.kotlinmovielist.ui.main

import android.app.Application
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import com.murataydin.app.kotlinmovielist.db.AppDatabase
import com.murataydin.app.kotlinmovielist.App
import com.murataydin.app.kotlinmovielist.BuildConfig
import com.murataydin.app.kotlinmovielist.core.BaseViewModel
import com.murataydin.app.kotlinmovielist.core.Resource
import com.murataydin.app.kotlinmovielist.core.Status
import com.murataydin.app.kotlinmovielist.service.response.MovieResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject

class MainActivityViewModel(app: Application) : BaseViewModel(app) {

    init {
        (app as? App)?.component?.inject(this)
    }
    val getMoviesLiveData = MutableLiveData<Resource<MovieResponse>>()
    val tvAlertLiveData = MutableLiveData<Boolean>()

    val item = ObservableField<MovieResponse>()

    var position = -1

    fun setModel(item: MovieResponse, position: Int) {
        this.item.set(item)
        this.position = position
    }



    fun searchMovies(query: String?) {
        disposable.add(baseApi.searchMovies(BuildConfig.API_TOKEN, query!!)
                .subscribeOn(Schedulers.io())
                .map { Resource.success(it) }
                .onErrorReturn { Resource.error(it) }
                .doOnSubscribe { progressLiveData.postValue(true) }
                .doOnTerminate { progressLiveData.postValue(false) }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    if (!it.data?.response.equals("False")){
                        getMoviesLiveData.postValue(it)
                        tvAlertLiveData.postValue(false)
                    }else{
                        tvAlertLiveData.postValue(true)
                    }
                })
    }
}