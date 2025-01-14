package com.example.vanocniaplikace

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val filmData = listOf(
            Film("Sám doma", "Komedie, Rodinný", 1990, "Klasická komedie o chlapci, který zůstane sám doma.", R.drawable.ic_launcher_background),
            Film("Polární expres", "Animovaný, Dobrodružný", 2004, "Dobrodružství o víře v ducha Vánoc.", R.drawable.ic_launcher_background)
            // Přidej zde další filmy až do 24
        )

        for (den in 1..24) {
            val resId = resources.getIdentifier("den$den", "id", packageName)
            val button = findViewById<Button>(resId)
            button.setOnClickListener {
                val intent = Intent(this, DetailActivity::class.java)
                intent.putExtra("FILM_DATA", filmData[den - 1])
                startActivity(intent)
            }
        }
    }
}