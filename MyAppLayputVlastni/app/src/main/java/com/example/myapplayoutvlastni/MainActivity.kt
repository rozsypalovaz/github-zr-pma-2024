package com.example.myapplayoutvlastni

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import com.example.myapplayoutvlastni.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Nalezení prvků v layoutu
        val textovePole: EditText = findViewById(R.id.textovePole)
        val spinnerBarva: Spinner = findViewById(R.id.spinnerBarva)
        val tlacitkoZobrazit: Button = findViewById(R.id.tlacitkoZobrazit)
        val zobrazeniTextu: TextView = findViewById(R.id.zobrazeniTextu)

        // Nastavení možností pro Spinner
        val barvy = arrayOf("Červená", "Zelená", "Modrá")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, barvy)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerBarva.adapter = adapter

        // Nastavení onClickListener na tlačítko
        tlacitkoZobrazit.setOnClickListener {
            // Načtení textu z EditText
            val vstupniText = textovePole.text.toString()
            // Zobrazení textu v TextView
            zobrazeniTextu.text = vstupniText

            // Nastavení barvy podle výběru ze Spinner
            val vybranaBarva = spinnerBarva.selectedItem.toString()
            zobrazeniTextu.setTextColor(
                when (vybranaBarva) {
                    "Červená" -> Color.RED
                    "Zelená" -> Color.GREEN
                    "Modrá" -> Color.BLUE
                    else -> Color.BLACK
                }
            )
        }
    }
}
