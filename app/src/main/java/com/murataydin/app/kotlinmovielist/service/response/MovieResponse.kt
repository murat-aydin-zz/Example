package com.murataydin.app.kotlinmovielist.service.response

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class MovieResponse(

        @field:SerializedName("Metascore")
        val metascore: String? = null,

        @field:SerializedName("BoxOffice")
        val boxOffice: String? = null,

        @field:SerializedName("Website")
        val website: String? = null,

        @field:SerializedName("imdbRating")
        val imdbRating: String? = null,

        @field:SerializedName("imdbVotes")
        val imdbVotes: String? = null,

        @field:SerializedName("Runtime")
        val runtime: String? = null,

        @field:SerializedName("Language")
        val language: String? = null,

        @field:SerializedName("Rated")
        val rated: String? = null,

        @field:SerializedName("Production")
        val production: String? = null,

        @field:SerializedName("Released")
        val released: String? = null,

        @field:SerializedName("imdbID")
        val imdbID: String? = null,

        @field:SerializedName("Plot")
        val plot: String? = null,

        @field:SerializedName("Director")
        val director: String? = null,

        @field:SerializedName("Title")
        val title: String? = "",

        @field:SerializedName("Actors")
        val actors: String? = null,

        @field:SerializedName("Response")
        val response: String? = null,

        @field:SerializedName("Type")
        val type: String? = null,

        @field:SerializedName("Awards")
        val awards: String? = null,

        @field:SerializedName("DVD")
        val dVD: String? = null,

        @field:SerializedName("Year")
        val year: String? = null,

        @field:SerializedName("Poster")
        val poster: String? = "",

        @field:SerializedName("Country")
        val country: String? = null,

        @field:SerializedName("Genre")
        val genre: String? = null,

        @field:SerializedName("Writer")
        val writer: String? = null
):Parcelable {
        constructor(parcel: Parcel) : this(
                parcel.readString(),
                parcel.readString(),
                parcel.readString(),
                parcel.readString(),
                parcel.readString(),
                parcel.readString(),
                parcel.readString(),
                parcel.readString(),
                parcel.readString(),
                parcel.readString(),
                parcel.readString(),
                parcel.readString(),
                parcel.readString(),
                parcel.readString(),
                parcel.readString(),
                parcel.readString(),
                parcel.readString(),
                parcel.readString(),
                parcel.readString(),
                parcel.readString(),
                parcel.readString(),
                parcel.readString(),
                parcel.readString(),
                parcel.readString()) {
        }

        override fun writeToParcel(parcel: Parcel, flags: Int) {
                parcel.writeString(metascore)
                parcel.writeString(boxOffice)
                parcel.writeString(website)
                parcel.writeString(imdbRating)
                parcel.writeString(imdbVotes)
                parcel.writeString(runtime)
                parcel.writeString(language)
                parcel.writeString(rated)
                parcel.writeString(production)
                parcel.writeString(released)
                parcel.writeString(imdbID)
                parcel.writeString(plot)
                parcel.writeString(director)
                parcel.writeString(title)
                parcel.writeString(actors)
                parcel.writeString(response)
                parcel.writeString(type)
                parcel.writeString(awards)
                parcel.writeString(dVD)
                parcel.writeString(year)
                parcel.writeString(poster)
                parcel.writeString(country)
                parcel.writeString(genre)
                parcel.writeString(writer)
        }

        override fun describeContents(): Int {
                return 0
        }

        companion object CREATOR : Parcelable.Creator<MovieResponse> {
                override fun createFromParcel(parcel: Parcel): MovieResponse {
                        return MovieResponse(parcel)
                }

                override fun newArray(size: Int): Array<MovieResponse?> {
                        return arrayOfNulls(size)
                }
        }
}