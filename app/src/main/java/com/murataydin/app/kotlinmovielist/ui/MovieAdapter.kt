package com.murataydin.app.kotlinmovielist.ui

import android.app.Activity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import android.view.LayoutInflater
import android.view.ViewGroup
import com.murataydin.app.kotlinmovielist.R
import com.murataydin.app.kotlinmovielist.core.BaseAdapter
import com.murataydin.app.kotlinmovielist.databinding.RvMovieItemBinding
import com.murataydin.app.kotlinmovielist.service.response.MovieResponse
import com.murataydin.app.kotlinmovielist.ui.main.MainActivityViewModel


class MovieAdapter(private val callback: (MovieResponse, Int) -> Unit) : BaseAdapter<MovieResponse?>(object : DiffUtil.ItemCallback<MovieResponse?>() {
    override fun areContentsTheSame(oldItem: MovieResponse, newItem: MovieResponse): Boolean {
        return oldItem == newItem
    }

    override fun areItemsTheSame(oldItem: MovieResponse, newItem: MovieResponse): Boolean {
        return oldItem == newItem
    }

}) {
    override fun createBinding(parent: ViewGroup, viewType: Int): ViewDataBinding {
        val mBinding = DataBindingUtil.inflate<RvMovieItemBinding>(
            LayoutInflater.from(parent.context),
            R.layout.rv_movie_item,
            parent,
            false
        )
        val viewModel =
            MainActivityViewModel((parent.context as Activity).application)


        mBinding.viewModel = viewModel


        return mBinding
    }

    override fun bind(binding: ViewDataBinding, position: Int) {

        getItem(position)?.let { (binding as RvMovieItemBinding).viewModel?.setModel(it, position) }
        binding.executePendingBindings()
    }
}