package com.example.vanocniaplikace

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val film = intent.getParcelableExtra<Film>("FILM_DATA")

        if (film != null) {
            findViewById<TextView>(R.id.nazevFilmu).text = film.nazev
            findViewById<TextView>(R.id.zanrFilmu).text = film.zanr
            findViewById<TextView>(R.id.rokVydani).text = film.rok.toString()
            findViewById<TextView>(R.id.popisFilmu).text = film.popis
            findViewById<ImageView>(R.id.obrazekFilmu).setImageResource(film.obrazek)
        }
    }
}
