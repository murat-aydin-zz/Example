package com.murataydin.app.kotlinmovielist.ui.main

import android.content.Intent
import android.content.res.Configuration
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.murataydin.app.kotlinmovielist.BuildConfig
import com.murataydin.app.kotlinmovielist.R
import com.murataydin.app.kotlinmovielist.core.BaseActivity
import com.murataydin.app.kotlinmovielist.core.Resource
import com.murataydin.app.kotlinmovielist.databinding.ActivityMainBinding
import com.murataydin.app.kotlinmovielist.service.response.MovieResponse
import com.murataydin.app.kotlinmovielist.ui.MovieAdapter

class MainActivity : BaseActivity<MainActivityViewModel, ActivityMainBinding>(MainActivityViewModel::class.java) {
    override fun initViewModel(viewModel: MainActivityViewModel) {
        binding.viewModel = viewModel
    }

    override fun getLayoutRes() = R.layout.activity_main

    override fun init() {
        super.init()

        binding.searchView.setOnQueryChangeListener { selam, newQuery ->
            binding.rvMovies!!.smoothScrollToPosition(0)
            if (newQuery.isNotEmpty()){
                getMovies(newQuery)
            }else{
               setVisibility(true,getString(R.string.search_text))
            }

        }
    }



    private fun getMovies(newQuery: String?) {
        viewModel.searchMovies(newQuery)

        if (viewModel.getMoviesLiveData.hasActiveObservers())
        viewModel.getMoviesLiveData.removeObservers(this)

        val adapter =
                MovieAdapter { item, position ->
                }


        binding.rvMovies.adapter = adapter


        viewModel.getMoviesLiveData.observe(this@MainActivity, Observer<Resource<MovieResponse>> {
            it.let {
                val list = mutableListOf<MovieResponse>()
                list.add(it.data!!)
                (binding.rvMovies.adapter as MovieAdapter).submitList(list as List<MovieResponse?>?)
            }
        })

        viewModel.tvAlertLiveData.observe(this@MainActivity, Observer<Boolean> {
            it.let {
                setVisibility(it,getString(R.string.alert_movie))
            }
        })

    }

    private fun setVisibility(it: Boolean, string: String) {
        if (it){
            binding.flAlert.visibility = View.VISIBLE
            binding.tvAlertText.text= string
        }else{
            binding.flAlert.visibility = View.GONE

        }
    }

}
