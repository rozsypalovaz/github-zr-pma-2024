package com.example.myapp008bfragmentsexample1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

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
    fun onBookSelected(title: String, author: String, genre: String, year: String, imageResId: Int) {
        val detailFragment = DetailFragment()

        val bundle = Bundle().apply {
            putString("title", title)
            putString("author", author)
            putString("genre", genre)
            putString("year", year)
            putInt("imageResId", imageResId)
        }
        detailFragment.arguments = bundle

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container_detail, detailFragment)
            .commit()
    }
}
