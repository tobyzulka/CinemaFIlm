package com.tobyz.cinemafilm

import android.os.Parcel
import android.os.Parcelable
import android.content.Context
import org.json.JSONException
import org.json.JSONObject

class Film(
    val Judul: String,
    val Tahun: String,
    val Release: String,
    val Genre: String,
    val Direktur: String,
    val Penulis: String,
    val Aktor: String,
    val Plot: String,
    val Poster: String,
    val Rating: String
) : Parcelable {
    constructor(source: Parcel) : this(
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(Judul)
        writeString(Tahun)
        writeString(Release)
        writeString(Genre)
        writeString(Direktur)
        writeString(Penulis)
        writeString(Aktor)
        writeString(Plot)
        writeString(Poster)
        writeString(Rating)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Film> = object : Parcelable.Creator<Film> {
            override fun createFromParcel(source: Parcel): Film = Film(source)
            override fun newArray(size: Int): Array<Film?> = arrayOfNulls(size)
        }

        fun getFilmFromFile(filename: String, context: Context): ArrayList<Film> {
            val filmList = ArrayList<Film>()

            try {
                val jsonString = loadJsonFromAsset("film.json", context)
                val json = JSONObject(jsonString)
                val film = json.getJSONArray("film")

                (0 until film.length()).mapTo(filmList) {
                    Film(film.getJSONObject(it).getString("judul"),
                        film.getJSONObject(it).getString("tahun"),
                        film.getJSONObject(it).getString("release"),
                        film.getJSONObject(it).getString("genre"),
                        film.getJSONObject(it).getString("direktur"),
                        film.getJSONObject(it).getString("penulis"),
                        film.getJSONObject(it).getString("aktor"),
                        film.getJSONObject(it).getString("plot"),
                        film.getJSONObject(it).getString("poster"),
                        film.getJSONObject(it).getString("rating"))
                }
            } catch (e: JSONException) {
                e.printStackTrace()
            }

            return filmList
        }


        private fun loadJsonFromAsset(filename: String, context: Context): String? {
            var json: String? = null

            try {
                val inputStream = context.assets.open(filename)
                val size = inputStream.available()
                val buffer = ByteArray(size)
                inputStream.read(buffer)
                inputStream.close()
                json = String(buffer, Charsets.UTF_8)
            } catch (ex: java.io.IOException) {
                ex.printStackTrace()
                return null
            }

            return json
        }
    }
}
