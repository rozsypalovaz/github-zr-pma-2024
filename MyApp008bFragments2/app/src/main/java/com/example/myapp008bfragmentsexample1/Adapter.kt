package com.example.myapp008bfragmentsexample1

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class Adapter(private val context: Context, private val books: List<ListFragment.Book>) : BaseAdapter() {

    override fun getCount(): Int {
        return books.size
    }

    override fun getItem(position: Int): Any {
        return books[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View = convertView ?: LayoutInflater.from(context).inflate(R.layout.item, parent, false)

        val book = books[position]
        val bookTitle = view.findViewById<TextView>(R.id.bookTitle)

        bookTitle.text = book.title

        return view
    }
}
