
fun main() {
    println("Welcome")
    println("Please follow the instructions in Lesson1.kt, Lesson2.kt, Lesson2b.kt, Lesson3.kt")

    val greeting = "Hello, World!"
    var greeting2 = "Hello, World!"

    println(greeting)
    println(greeting2)

    // greeting = "Hello, Kotlin!" // Erreur: Val cannot be reassigned
    greeting2 = "Hello, Kotlin!"

    println(greeting)
    println(greeting2)

    val instruments = listOf("Guitar", "Piano", "Drums", "Violin")
    val instruments2 = mutableListOf("Guitar", "Piano", "Drums", "Violin")
    val instruments3 = listOf("Guitar", "Piano", "Drums", "Violin")
    val instruments4 = mutableListOf("Guitar", "Piano", "Drums", "Violin")
    println("Here are some musical instruments:")



    // instruments.add("Flute") // Erreur: Unresolved reference: add
    instruments2.add("Flute")
    // instruments3.add("Flute") // Erreur: Unresolved reference: add
    instruments4.add("Flute")
    println(instruments)
    println(instruments2)


    val int = instruments4[0].length
    println("The length of the first instrument is: $int")
}