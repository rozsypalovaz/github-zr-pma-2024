package com.example.vanocniaplikace

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FilmAdapter(private val filmy: List<Film>, private val kliknutiNaFilm: (Film) -> Unit) : RecyclerView.Adapter<FilmAdapter.FilmViewHolder>() {

    inner class FilmViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nazev: TextView = view.findViewById(R.id.nazevFilmu)
        val obrazek: ImageView = view.findViewById(R.id.obrazekFilmu)

        fun bind(film: Film) {
            nazev.text = film.nazev
            obrazek.setImageResource(film.obrazek)
            itemView.setOnClickListener { kliknutiNaFilm(film) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.film_polozka, parent, false)
        return FilmViewHolder(view)
    }

    override fun onBindViewHolder(holder: FilmViewHolder, position: Int) {
        holder.bind(filmy[position])
    }

    override fun getItemCount() = filmy.size
}