package com.example.myapp008bfragmentsexample1

import DetailFragment
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Přidáme ListFragment, pokud ještě neexistuje
        if (savedInstanceState == null) {
            val listFragment = ListFragment()
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container_list, listFragment)
                .commit()
        }
    }

    // Voláno při výběru knihy
    fun onBookSelected(title: String, author: String, genre:String, year:String) {
        // Vytvoření nového DetailFragment a nastavení argumentů
        val detailFragment = DetailFragment()

        val bundle = Bundle().apply {
            putString("title", title)
            putString("author", author)
            putString("genre", genre)
            putString("year", year)

        }
        detailFragment.arguments = bundle

        // Nahradíme starý fragment novým a commitneme transakci
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container_detail, detailFragment)
            .commit()
    }
}
