import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.myapp008bfragmentsexample1.R

class DetailFragment : Fragment() {

    private lateinit var textViewTitle: TextView
    private lateinit var textViewAuthor: TextView
    private lateinit var textViewGenre: TextView
    private lateinit var textViewYear: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_detail, container, false)
        textViewTitle = view.findViewById(R.id.textViewTitle)
        textViewAuthor = view.findViewById(R.id.textViewAuthor)
        textViewGenre = view.findViewById(R.id.textViewGenre)
        textViewYear = view.findViewById(R.id.textViewYear)

        // Načtení argumentů a aktualizace textových polí
        arguments?.let {
            val title = it.getString("title")
            val author = it.getString("author")
            val genre = it.getString("genre")
            val year = it.getString("year")
            updateDetails(title ?: "Unknown", author ?: "Unknown", genre ?: "Unknown", year ?: "Unknown")
        }

        return view
    }

    // Metoda pro aktualizaci zobrazení detailů
    fun updateDetails(title: String, author: String, genre: String, year: String) {
        textViewTitle.text = title
        textViewAuthor.text = author
        textViewGenre.text = genre
        textViewYear.text = year
    }
}
