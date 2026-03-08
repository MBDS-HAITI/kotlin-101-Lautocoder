package com.android.com.kotlin.one

// Exercise 1
fun immutableList(): List<Int> {
    // TODO("Return an immutable list of integers from 1 to 5.")
    return listOf(1, 2, 3, 4, 5)
}

// Exercise  2
fun mutableList(): MutableList<String> {
    // TODO("Return a mutable list of strings containing the names of three cities.")
    val cities = mutableListOf("Port-au-Prince", "Delmas", "Pétion-Ville")
    cities.add("Tabarre")
    return cities
}

// Exercise 3
fun filterEvenNumbers(): List<Int> {
    // TODO("Return a list of even numbers from 1 to 10.")
    return (1..10).filter { it % 2 == 0 }
}

// Exercise 4
fun filterAndMapAges(ages: List<Int>): List<String> {
    // TODO("Given a list of ages, return a list of strings indicating whether each age is 'Minor' (under 18) or 'Adult' (18 and over).")
    return ages.filter { it >=18}.map { "Adult: $it" }
}

// Exercise 5
fun flattenList(): List<Int>{
    // TODO("Given a list of lists of integers, return a single flattened list of integers.")
    val listOfLists = listOf(
        listOf(1, 2),
        listOf(3, 4),
        listOf(5)
    )
    return listOfLists.flatten()
}

// Exercise 6
fun flatMapWords(): List<String> {

    val sentences = listOf(
        "Kotlin is fun",
        "I love lists"
    )
    val words = sentences.flatMap { it.split(" ") }
    return words
}

// Exercise 7
fun eagerProcessing(): List<Int> {
    val start = System.currentTimeMillis()

    val result = (1..1_000_000)
        .filter { it % 3 == 0 }
        .map { it * it }
        .take(5)

    val end = System.currentTimeMillis()
    println("⏱ Eager  time: ${end - start} ms")

    return result
}

// Exercise 8
fun lazyProcessing(): List<Int> {
    val start = System.currentTimeMillis()

    val result = (1..1_000_000)
        .asSequence()
        .filter { it % 3 == 0 }
        .map { it * it }
        .take(5)
        .toList()

    val end = System.currentTimeMillis()
    println("⏱ Lazy   time: ${end - start} ms")

    return result
}

// Exercise 9
fun filterAndSortNames(names: List<String>): List<String> {
    return names
        .filter { it.startsWith("A") }
        .map { it.uppercase() }
        .sorted()
}

fun main() {
//    TODO("Pour cette leçon, suivez les instructions dans le fichier README_02.md")

        println("🔍 Running Kotlin List Processing Tests...\n")

        var passed = 0
        var failed = 0

        fun verify(name: String, block: () -> Boolean) {
            try {
                check(block()) { "Test failed: $name" }
                println("✅ $name")
                passed++
            } catch (e: Throwable) {
                println("❌ $name → ${e.message}")
                failed++
            }
        }

        // Exercise 1
        verify("ex1 — immutableList has 5 elements") {
            immutableList() == listOf(1, 2, 3, 4, 5)
        }
        verify("ex1 — immutableList is a List (immutable)") {
            immutableList() is List<*>
        }

        // Exercise 2
        verify("ex2 — mutableList has 4 elements") {
            mutableList().size == 4
        }
        verify("ex2 — mutableList is MutableList") {
            mutableList() is MutableList<*>
        }

        // Exercise 3
        verify("ex3 — filterEvenNumbers returns [2,4,6,8,10]") {
            filterEvenNumbers() == listOf(2, 4, 6, 8, 10)
        }

        // Exercise 4
        verify("ex4 — filterAndMapAges keeps adults only") {
            filterAndMapAges(listOf(15, 18, 20, 10, 25)) == listOf("Adult: 18", "Adult: 20", "Adult: 25")
        }
        verify("ex4 — filterAndMapAges with no adults returns empty") {
            filterAndMapAges(listOf(10, 12, 16)) == emptyList<String>()
        }

        // Exercise 5
        verify("ex5 — flattenList returns [1,2,3,4,5]") {
            flattenList() == listOf(1, 2, 3, 4, 5)
        }

        // Exercise 6
        verify("ex6 — flatMapWords splits sentences into words") {
            flatMapWords() == listOf("Kotlin", "is", "fun", "I", "love", "lists")
        }

        // Exercise 7
        verify("ex7 — eagerProcessing returns first 5 squares of multiples of 3") {
            // multiples of 3: 3,6,9,12,15 → squares: 9,36,81,144,225
            eagerProcessing() == listOf(9, 36, 81, 144, 225)
        }

        // Exercise 8
        verify("ex8 — lazyProcessing returns same result as eager") {
            lazyProcessing() == listOf(9, 36, 81, 144, 225)
        }
        verify("ex8 — eager and lazy produce identical results") {
            eagerProcessing() == lazyProcessing()
        }

        // Exercise 9
        verify("ex9 — filterAndSortNames filters 'A', uppercases, sorts") {
            val names = listOf("Alice", "Bob", "Anna", "Charlie", "Alex", "Diana")
            filterAndSortNames(names) == listOf("ALEX", "ALICE", "ANNA")
        }
        verify("ex9 — filterAndSortNames with no 'A' names returns empty") {
            filterAndSortNames(listOf("Bob", "Charlie")) == emptyList<String>()
        }

        println("\n🎯 TEST SUMMARY: $passed passed, $failed failed.")
        if (failed == 0) println("🎉 All tests passed! Great job!")
        else println("⚠️  Some tests failed. Keep debugging!")
    }
