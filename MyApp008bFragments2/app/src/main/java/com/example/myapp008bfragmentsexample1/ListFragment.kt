package com.example.myapp008bfragmentsexample1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridView

class ListFragment : Fragment() {

    private lateinit var gridView: GridView

    data class Book(val title: String, val author: String, val genre: String, val year: Int, val imageResId: Int)

    private val books = listOf(
        Book("1", "Sám doma", "Komedie", 1990, R.drawable.sam_doma),
        Book("2", "Sám doma 2: Ztracen v New Yorku", "Komedie", 1992, R.drawable.sam_doma_2),
        Book("3", "Tři oříšky pro Popelku", "Pohádka", 1973, R.drawable.tri_orisky_pro_popelku),
        Book("4", "Vánoční koleda", "Animovaný", 2009, R.drawable.vanocni_koleda),
        Book("5", "Láska nebeská", "Romantický", 2003, R.drawable.laska_nebeska),
        Book("6", "Grinch", "Rodinný", 2000, R.drawable.grinch),
        Book("7", "Veselé Vánoce přejí chobotnice", "Animovaný", 2007, R.drawable.vesele_vanoce_preji_chobotnice),
        Book("8", "Ledové království", "Animovaný", 2013, R.drawable.ledove_kralovstvi),
        Book("9", "Vánoční princ", "Romantický", 2017, R.drawable.vanocni_princ),
        Book("10", "Anděl Páně", "Pohádka", 2005, R.drawable.andel_pane),
        Book("11", "Anděl Páně 2", "Pohádka", 2016, R.drawable.andel_pane_2),
        Book("12", "Klaus", "Animovaný", 2019, R.drawable.klaus),
        Book("13", "Polární expres", "Animovaný", 2004, R.drawable.polarni_expres),
        Book("14", "Šťastný nový rok", "Romantický", 2019, R.drawable.stastny_novy_rok),
        Book("15", "Přežít Vánoce", "Komedie", 2004, R.drawable.prezit_vanoce),
        Book("16", "Sněženky a machři", "Komedie", 1982, R.drawable.snezenky_a_machri),
        Book("17", "Šťastný a veselý Madagaskar", "Animovaný", 2009, R.drawable.stastny_a_vesely_madagaskar),
        Book("18", "Jack Frost", "Rodinný", 1998, R.drawable.jack_frost),
        Book("19", "Vánoční příběh", "Komedie", 1983, R.drawable.vanocni_pribeh),
        Book("20", "Doktor Živago", "Drama", 2002, R.drawable.doktor_zivago),
        Book("21", "Sněhulák", "Thriller", 2017, R.drawable.snehulak),
        Book("22", "Kronika Vánoc", "Rodinný", 2018, R.drawable.kronika_vanoc),
        Book("23", "Vánoční návštěvníci", "Komedie", 2016, R.drawable.vanocni_navstevnici),
        Book("24", "Pelíšky", "Komedie", 1999, R.drawable.pelisky)
    )


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_list, container, false)
        gridView = view.findViewById(R.id.gridViewBooks)

        // Nastavení adaptéru
        val adapter = Adapter(requireContext(), books)
        gridView.adapter = adapter

        gridView.setOnItemClickListener { _, _, position, _ ->
            val selectedBook = books[position]
            (activity as? MainActivity)?.onBookSelected(
                selectedBook.title,
                selectedBook.author,
                selectedBook.genre,
                selectedBook.year.toString(),
                selectedBook.imageResId
            )
        }

        return view
    }
}
