package com.android.com.kotlin.one

fun main() {

    println("👋 Welcome to the Kotlin Playground!")
    println("Let's start learning step by step.\n")


    // ✅ EXERCISE 1 Variables:
    // Create two variables: `city` (String) and `temperature` (Double)
    // Then print: "It is {temperature}°C in {city}"
    // Enforce `city` to be immutable and `temperature` mutable
    // Then print the sentence again after changing `temperature`


    val city = "Haiti"
    var temperature = 30.5
    println("It is $temperature°C in $city")
    temperature = 26.5
    println("It will be $temperature°C in $city tonight")




    // ✅ EXERCISE 2 Conditionals:
    // Create a variable `score` (Int)
    // Handle the following cases:
    // - If score is exactly 100, print "Perfect score!"
    // - If score is below 0 or above 100, print "Invalid score"
    // - If score between 0 and 49, print "You failed!"
    // - If score between 50 and 60, print "Just passed!"
    // - If score between 61 and 99, print "Well done!"

    val score = 60;

    when(score) {
        100 -> println("Perfect score!")
        in 0..49 -> println("You failed!")
        in 50..60 -> println("Just passed!")
        in 61..99 -> println("Well done!")
        else -> println("Invalid score")
    }

    // ✅ EXERCISE 3 list and Loops:
    // Create a list of your favorite fruits
    // Loop through the list and print each fruit in uppercase
    // Then, print the total number of fruits in the list
    // Ask the user to enter a fruit name and check if it's in the list

    val fruits = listOf("Apple","Banana","Mango","Pineapple","Grapes")
    for (fruit in fruits) {
        println(fruit.uppercase())
    }
    val totalFruits = fruits.size
    println("Total number of fruits: $totalFruits")
        println("Please enter a fruit name:")
    val userInput = readlnOrNull()
    if (userInput != null && userInput.isNotEmpty()) {
        if (fruits.contains(userInput)) {
            println("$userInput is in the list of favorite fruits!")
        } else {
            println("$userInput is not in the list of favorite fruits.")
        }
    }else {
        println("No input provided.")
    }

    // ✅EXERCISE 4 Elvis Operator:
    // Create a nullable variable `nickname` of type String? and assign it null
    // Print the number of characters in `nickname`
    // Print the nickname or "No nickname provided" if it's null using the Elvis operator

    val nickname: String? = null
    val nicknameLength = nickname?.length ?: 0
    println("Number of characters in nickname: $nicknameLength")
    val displayNickname = nickname ?: "No nickname provided"
    println(displayNickname)

}

