package com.example.myapp008bfragmentsexample1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.GridView

class ListFragment : Fragment() {

    private lateinit var gridView: GridView

    // Definujeme data class pro knihu
    data class Book(val title: String, val author: String, val genre: String, val year: Int)

    // Seznam knih
    private val books = listOf(
        Book("Book 1", "Author 1", "Genre 1", 2021),
        Book("Book 2", "Author 2", "Genre 2", 2020),
        Book("Book 3", "Author 3", "Genre 3", 2019),
        // Přidejte další knihy až do celkového počtu 24
        // ...
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_list, container, false)
        gridView = view.findViewById(R.id.gridViewBooks)

        val adapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_list_item_1,
            books.map { it.title }
        )
        gridView.adapter = adapter

        // Při kliknutí na položku zavoláme metodu aktivity s více argumenty
        gridView.setOnItemClickListener { _, _, position, _ ->
            val selectedBook = books[position]
            (activity as? MainActivity)?.onBookSelected(
                selectedBook.title,
                selectedBook.author,
                selectedBook.genre,
                selectedBook.year.toString()
            )
        }
        return view
    }
}
