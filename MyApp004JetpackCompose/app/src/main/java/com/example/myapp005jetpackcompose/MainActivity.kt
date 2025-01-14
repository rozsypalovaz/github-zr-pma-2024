package com.example.myapp005jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapp005jetpackcompose.ui.theme.MyApp005JetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePerson()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ComposePerson() {

    // Stavy pro jednotlivé textové vstupy
    var name by remember { mutableStateOf("") } // Uchovává jméno
    var surname by remember { mutableStateOf("") } // Uchovává příjmení
    var age by remember { mutableStateOf("") } // Uchovává věk
    var place by remember { mutableStateOf("") } // Uchovává bydliště
    var resultText by remember { mutableStateOf("") } // Uchovává text výsledku

    // Scaffold poskytuje rozvržení s horním panelem
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Moje Aplikace - Osoba", color = Color.White) }, // Nastaví barvu textu na bílou
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color.DarkGray,  // Nastaví pozadí na černé
                )
            )
        }
    ) { innerPadding ->

        // Obsah aplikace je uspořádán v sloupci s paddingem
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp), // Padding okolo obsahu
            verticalArrangement = Arrangement.spacedBy(16.dp) // Vertikální rozestupy mezi prvky
        ) {

            // Textová pole pro vstupy
            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                label = { Text("Jméno") },
                modifier = Modifier.fillMaxWidth() // Textové pole vyplní šířku rodiče
            )

            OutlinedTextField(
                value = surname,
                onValueChange = { surname = it },
                label = { Text("Příjmení") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = age,
                onValueChange = {
                    // Omezíme vstup na číslice a kontrolujeme, že číslo není větší než 123
                    if (it.all { char -> char.isDigit() } && it.toIntOrNull()?.let { it <= 123 } == true) {
                        age = it
                    }
                },
                label = { Text("Věk (hodnota menší než 123)") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = place,
                onValueChange = { place = it },
                label = { Text("Bydliště") },
                modifier = Modifier.fillMaxWidth()
            )

            // Tlačítka Odeslat a Vymazat uspořádaná vedle sebe v řádku
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp) // Horizontální rozestupy mezi tlačítky
            ) {

                Button(
                    onClick = {
                        // Akce pro tlačítko Odeslat
                        resultText = "Jmenuji se $name $surname. Je mi $age let a moje bydliště je $place."
                    },
                    modifier = Modifier.weight(1f) // Tlačítko zabere 1/2 šířky řádku
                ) {
                    Text("Odeslat")
                }

                Button(
                    onClick = {
                        // Akce pro tlačítko Vymazat
                        name = ""
                        surname = ""
                        age = ""
                        place = ""
                        resultText = ""
                    },
                    modifier = Modifier.weight(1f), // Tlačítko zabere 1/2 šířky řádku
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFB71C1C),  // Barva pozadí tlačítka
                        contentColor = Color.White  // Barva textu tlačítka
                    )
                ) {
                    Text("Vymazat")
                }
            }

            // Výsledek, pokud není prázdný, zobrazí se jako text
            if (resultText.isNotEmpty()) {
                Text(
                    text = resultText,
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(top = 16.dp) // Padding nad textem výsledku
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposePerson()
}
