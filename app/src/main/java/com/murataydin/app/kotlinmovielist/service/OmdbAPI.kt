package com.murataydin.app.kotlinmovielist.service

import com.murataydin.app.kotlinmovielist.service.response.MovieResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface OmdbAPI  {


    @GET("?type=movie")
    fun searchMovies(
        @Query("apikey") API_KEY: String,@Query(
            "t"
        ) title: String
    ): Observable<MovieResponse>

}
