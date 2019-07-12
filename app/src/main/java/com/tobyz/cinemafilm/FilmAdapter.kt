package com.tobyz.cinemafilm

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class FilmAdapter( context: Context, private val dataSource: ArrayList<Film>) : BaseAdapter() {

    private val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getCount(): Int {
        return dataSource.size
    }

    override fun getItem(position: Int): Any {
        return dataSource[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view: View
        val holder: ViewHolder

        if (convertView == null) {
            view = inflater.inflate(R.layout.list_film, parent, false)

            holder = ViewHolder()
            holder.posterImageView = view.findViewById(R.id.PosterID) as ImageView
            holder.judulTextView  = view.findViewById(R.id.Judul) as TextView
            holder.ratingTextView = view.findViewById(R.id.Rating) as TextView
            holder.genreTextView = view.findViewById(R.id.Genre) as TextView
            holder.plotTextView = view.findViewById(R.id.Plot) as TextView

            view.tag = holder
        } else {
            view = convertView
            holder = convertView.tag as ViewHolder
        }

        val judulTextView = holder.judulTextView
        val genreTextView = holder.genreTextView
        val plotTextView = holder.plotTextView
        val posterImageView = holder.posterImageView
        val ratingTextView = holder.ratingTextView

        val film = getItem(position) as Film

        judulTextView.text = film.Judul +" (" +film.Tahun +")"
        ratingTextView.text = film.Rating
        genreTextView.text = film.Genre
        plotTextView.text = film.Plot

        Picasso.get().load(film.Poster).placeholder(R.mipmap.ic_launcher).into(posterImageView)

        return view
    }

    private class ViewHolder {
        lateinit var judulTextView: TextView
        lateinit var genreTextView: TextView
        lateinit var plotTextView: TextView
        lateinit var posterImageView: ImageView
        lateinit var ratingTextView: TextView
    }
}
