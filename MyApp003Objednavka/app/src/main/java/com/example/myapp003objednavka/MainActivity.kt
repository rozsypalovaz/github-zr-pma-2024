package com.example.myapp003objednavka

import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapp003objednavka.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.radioGroup.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.radio1 -> binding.obrazek.setImageResource(R.drawable.d780)
                R.id.radio2 -> binding.obrazek.setImageResource(R.drawable.d3400)
                R.id.radio3 -> binding.obrazek.setImageResource(R.drawable.d5600)
            }
        }

        binding.btnObjednat.setOnClickListener {
            val vybranyObjektiv = when (binding.radioGroup.checkedRadioButtonId) {
                R.id.radio1 -> "D780"
                R.id.radio2 -> "D3400"
                R.id.radio3 -> "D5600"
                else -> "Žádná položka"
            }

            val moznost1 = if (binding.checkbox1.isChecked) "NIKKOR 35mm f/1.8 AF-S DX" else ""
            val moznost2 = if (binding.checkbox2.isChecked) "Nikon 10-20mm f/4.5-5.6 G AF-P DX VR" else ""
            val moznost3 = if (binding.checkbox3.isChecked) "7Artisans AF 50mm f/1,8" else ""

            val souhrn = "Vybrané tělo: $vybranyObjektiv\nVaše objektivy: $moznost1 $moznost2 $moznost3"
            binding.textViewSouhrn.text = souhrn
        }
    }
}
