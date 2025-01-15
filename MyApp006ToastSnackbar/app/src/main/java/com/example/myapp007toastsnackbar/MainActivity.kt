package com.example.myapp007toastsnackbar

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapp007toastsnackbar.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Inicializace ViewBinding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCalculate.setOnClickListener {
            calculateGraduationYear()
        }
    }

    private fun calculateGraduationYear() {
        val name = binding.editTextName.text.toString()
        val ageStr = binding.editTextAge.text.toString()
        val yearsLeftStr = binding.editTextYearsLeft.text.toString()

        if (name.isEmpty() || ageStr.isEmpty() || yearsLeftStr.isEmpty()) {
            Toast.makeText(this, "Prosím vyplňte všechny údaje.", Toast.LENGTH_SHORT).show()
            return
        }

        val age = ageStr.toInt()
        val yearsLeft = yearsLeftStr.toInt()
        val currentYear = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR)
        val graduationYear = currentYear + yearsLeft
        val ageAtGraduation = age + yearsLeft

        val resultMessage = "$name dostuduje v roce $graduationYear ve věku $ageAtGraduation let."
        binding.textViewResult.text = resultMessage
        binding.textViewResult.visibility = android.view.View.VISIBLE

        if (ageAtGraduation >= 26) {
            Snackbar.make(binding.root, "Ohlídej si platbu zdravotního a sociálního pojištění.", Snackbar.LENGTH_LONG)
                .setAction("OK") { }
                .show()
        }
    }
}
