package com.tobyz.cinemafilm

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class DetailFilmActivity : AppCompatActivity() {

    private lateinit var Judul: TextView
    private lateinit var Release: TextView
    private lateinit var Rating: TextView
    private lateinit var Poster: ImageView
    private lateinit var Direktur: TextView
    private lateinit var Penulis: TextView
    private lateinit var Plot: TextView
    private lateinit var Genre: TextView
    private lateinit var Aktor: TextView


    companion object {
        const val EXTRA_JUDUL= "judul"
        const val EXTRA_TAHUN= "tahun"
        const val EXTRA_RELEASE= "release"
        const val EXTRA_RATING = "rating"
        const val EXTRA_DIREKTUR= "direktur"
        const val EXTRA_POSTER = "poster"
        const val EXTRA_PENULIS= "penulis"
        const val EXTRA_PLOT = "plot"
        const val EXTRA_GENRE = "genre"
        const val EXTRA_AKTOR = "aktor"

        fun newIntent(context: Context, film: Film): Intent {
            val detailIntent = Intent(context, DetailFilmActivity::class.java)

            detailIntent.putExtra(EXTRA_JUDUL, film.Judul)
            detailIntent.putExtra(EXTRA_TAHUN, film.Tahun)
            detailIntent.putExtra(EXTRA_RELEASE, film.Release)
            detailIntent.putExtra(EXTRA_RATING, film.Rating)
            detailIntent.putExtra(EXTRA_DIREKTUR, film.Direktur)
            detailIntent.putExtra(EXTRA_PENULIS, film.Penulis)
            detailIntent.putExtra(EXTRA_PLOT, film.Plot)
            detailIntent.putExtra(EXTRA_POSTER, film.Poster)
            detailIntent.putExtra(EXTRA_GENRE, film.Genre)
            detailIntent.putExtra(EXTRA_AKTOR, film.Aktor)

            return detailIntent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_film)
        //navbar Kemabli
        val actionBar = supportActionBar
        actionBar!!.title = intent.extras.getString(EXTRA_JUDUL)
        actionBar.setDisplayHomeAsUpEnabled(true)

        Judul = findViewById(R.id.Judul)
        Judul.setText(intent.extras.getString(EXTRA_JUDUL) + " ("+ intent.extras.getString(EXTRA_TAHUN) +")")

        Release = findViewById(R.id.Release)
        Release.setText(intent.extras.getString(EXTRA_RELEASE))

        Rating = findViewById(R.id.Rating)
        Rating.setText(intent.extras.getString(EXTRA_RATING))

        Direktur = findViewById(R.id.Direktur)
        Direktur.setText(intent.extras.getString(EXTRA_DIREKTUR))

        Penulis = findViewById(R.id.Penulis)
        Penulis.setText(intent.extras.getString(EXTRA_PENULIS))

        Plot = findViewById(R.id.Plot)
        Plot.setText(intent.extras.getString(EXTRA_PLOT))

        Poster = findViewById(R.id.Poster)
        Picasso.get().load(intent.extras.getString(EXTRA_POSTER)).into(Poster)

        Genre = findViewById(R.id.Genre)
        Genre.setText(intent.extras.getString(EXTRA_GENRE))

        Aktor = findViewById(R.id.Aktor)
        Aktor.setText(intent.extras.getString(EXTRA_AKTOR))
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
