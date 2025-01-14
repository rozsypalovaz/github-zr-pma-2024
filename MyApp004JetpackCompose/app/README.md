Jetpack Compose v Kotlinu
nástroj pro tvorbu uživatelského rozhraní (UI) v Android aplikacích

místo tradičních XML layoutů -> kompozice jako Column, Row a Box

Column {
Text("Ahoj!")
Button(onClick = { /* akce */ }) {
Text("Klikni na mě")}
}

Scaffold slouží jako kontejner pro rozvržení aplikace s topBar pro zobrazení horního panelu

Scaffold(
topBar = {
TopAppBar(
title = { Text("Moje Aplikace - Osoba") }
)}
) {// další obsah Scaffold}
@Composable - kompozice, definují části uživatelského rozhraní

remember - funkce v Jetpack Compose, která slouží k uchování hodnoty přes recompositions (tedy opakované vykreslování)

mutableStateOf je funkce, která vytváří stavovou proměnnou a zajišťuje, že změny této proměnné vedou k opakovanému vykreslení

Příklad celého kódu:
@Composable
fun Greeting() {
var name by remember { mutableStateOf("Světe") }

      Column {
          Text(text = "Ahoj, $name!")
          Button(onClick = { name = "Příteli" }) {
              Text("Změnit jméno")}
      }
}