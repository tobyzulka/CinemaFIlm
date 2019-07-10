package com.tobyz.cinemafilm

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.content.Intent

class MainActivity : AppCompatActivity() {

    private lateinit var listView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView = findViewById<ListView>(R.id.listFilm)

        val filmList = Film.getFilmFromFile("film.json", this)

        val adapter = FilmAdapter(this, filmList)
        listView.adapter = adapter

        val context = this
        listView.setOnItemClickListener { _, _, position, _ ->
            val selectedFilm = filmList[position]
            val detailIntent = DetailFilmActivity.newIntent(context, selectedFilm)

            startActivity(detailIntent)
        }
    }
}
