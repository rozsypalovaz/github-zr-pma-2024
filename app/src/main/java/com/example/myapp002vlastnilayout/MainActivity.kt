package com.example.myapp002vlastnilayout

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Nalezení prvků v layoutu
        val editTextInput: EditText = findViewById(R.id.editTextInput)
        val spinnerColor: Spinner = findViewById(R.id.spinnerColor)
        val buttonShow: Button = findViewById(R.id.buttonShow)
        val textViewDisplay: TextView = findViewById(R.id.textViewDisplay)

        // Nastavení možností pro Spinner
        val colors = arrayOf("Červená", "Zelená", "Modrá")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, colors)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerColor.adapter = adapter

        // Nastavení onClickListener na tlačítko
        buttonShow.setOnClickListener {
            // Načtení textu z EditText
            val inputText = editTextInput.text.toString()
            // Zobrazení textu v TextView
            textViewDisplay.text = inputText

            // Nastavení barvy podle výběru ze Spinner
            val selectedColor = spinnerColor.selectedItem.toString()
            textViewDisplay.setTextColor(
                when (selectedColor) {
                    "Červená" -> Color.RED
                    "Zelená" -> Color.GREEN
                    "Modrá" -> Color.BLUE
                    else -> Color.BLACK
                }
            )
        }
    }
}
