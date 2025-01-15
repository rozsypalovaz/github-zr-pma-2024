package com.example.myapp008bfragmentsexample1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

class DetailFragment : Fragment() {

    private lateinit var textViewTitle: TextView
    private lateinit var textViewAuthor: TextView
    private lateinit var textViewGenre: TextView
    private lateinit var textViewYear: TextView
    private lateinit var imageViewBook: ImageView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_detail, container, false)
        textViewTitle = view.findViewById(R.id.textViewTitle)
        textViewAuthor = view.findViewById(R.id.textViewAuthor)
        textViewGenre = view.findViewById(R.id.textViewGenre)
        textViewYear = view.findViewById(R.id.textViewYear)
        imageViewBook = view.findViewById(R.id.imageViewBook)

        // Načtení argumentů a aktualizace textových polí
        arguments?.let {
            val title = it.getString("title")
            val author = it.getString("author")
            val genre = it.getString("genre")
            val year = it.getString("year")
            val imageResId = it.getInt("imageResId")
            updateDetails(title ?: "Unknown", author ?: "Unknown", genre ?: "Unknown", year ?: "Unknown", imageResId)
        }

        return view
    }

    // Metoda pro aktualizaci zobrazení detailů
    fun updateDetails(title: String, author: String, genre: String, year: String, imageResId: Int) {
        textViewTitle.text = title
        textViewAuthor.text = author
        textViewGenre.text = genre
        textViewYear.text = year
        imageViewBook.setImageResource(imageResId)
    }
}
