package com.example.myapp012aimagetoapp

import android.graphics.Bitmap
import android.graphics.ColorMatrix
import android.graphics.ColorMatrixColorFilter
import android.graphics.drawable.BitmapDrawable
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.myapp012aimagetoapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inicializace pro viewBinding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val getContent = registerForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
            binding.ivImage.setImageURI(uri)
        }

        binding.btnTakeImage.setOnClickListener {
            getContent.launch("image/*")
        }

        binding.btnBlackWhite.setOnClickListener {
            if (binding.ivImage.drawable == null) {
                Toast.makeText(this, "Nebyl nahrán žádný obrázek!", Toast.LENGTH_SHORT).show()
            } else {
                convertToBlackWhite()
            }
        }
    }

    private fun convertToBlackWhite() {
        val drawable = binding.ivImage.drawable as BitmapDrawable
        val bitmap = drawable.bitmap

        val colorMatrix = ColorMatrix()
        colorMatrix.setSaturation(0f)
        val filter = ColorMatrixColorFilter(colorMatrix)

        val blackWhiteDrawable = BitmapDrawable(resources, Bitmap.createBitmap(bitmap))
        blackWhiteDrawable.colorFilter = filter

        binding.ivImage.setImageDrawable(blackWhiteDrawable)
    }
}
