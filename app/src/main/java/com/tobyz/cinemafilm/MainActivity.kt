package com.tobyz.cinemafilm

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val listVFilm = findViewById<ListView>(R.id.listFilm)
        listVFilm.adapter = AdapterFilm(this)
    }


    private class AdapterFilm(context: Context):BaseAdapter(){
        private val mContext: Context

        private val poster = arrayListOf<Int>(
            R.drawable.image,
            R.drawable.image2
        )
        private val judul = arrayListOf<String>(
            "Avatar",
            "I Am Legend"
        )
        private val tahun = arrayListOf<String>(
            "2009",
            "2007"
        )
        private val rating = arrayListOf<String>(
            "7.9",
            "7.2"
        )
        private val genre = arrayListOf<String>(
            "Action, Adventure, Fantasy",
            "Drama, Horror, Sci-F"
        )
        private val deskripsi = arrayListOf<String>(
            "A paraplegic marine dispatched to the moon Pandora on a unique mission becomes torn between following his orders and protecting the world he feels is his home.",
            "Years after a plague kills most of humanity and transforms the rest into monsters, the sole survivor in New York City struggles valiantly to find a cure."
        )



        init{
            mContext = context
        }

        override fun getCount(): Int {
            return judul.size
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getItem(position: Int): Any {
            return "FILM Test"
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val layoutInflater = LayoutInflater.from(mContext)
            val rowList = layoutInflater.inflate(R.layout.list_film, parent, false)

            val posterImageView = rowList.findViewById<ImageView>(R.id.PosterID)
            posterImageView.setImageResource(poster.get(position))

            val judulTextView = rowList.findViewById<TextView>(R.id.Judul)
            judulTextView.text = judul.get(position)+" ("+tahun.get(position)+")"

            val ratingTextView = rowList.findViewById<TextView>(R.id.Rating)
            ratingTextView.text = rating.get(position)

            val genreTextView = rowList.findViewById<TextView>(R.id.Genre)
            genreTextView.text = genre.get(position)

            val deskripsiTextView = rowList.findViewById<TextView>(R.id.Deskripsi)
            deskripsiTextView.text = deskripsi.get(position)

            return  rowList
//            textView.text = "TestFilm"
//            return textView
        }
    }

}
