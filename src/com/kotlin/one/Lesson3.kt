package com.kotlin.one.battle_arena
import java.util.*

val input = Scanner(System.`in`)


fun main(args: Array<String>) {
    menuPrincipal()
}

fun menuPrincipal() {
    var choice = 0
    println("Welcome to Battle Arena!")
    while (choice != 2) {
        println("What would you like to do ? \n \t 1. Play a game \n \t 2. Quit")
        // Gestion d'erreur simple si l'input n'est pas un entier
        choice = try { input.nextInt() } catch (e: Exception) { 0 }

        if (choice == 1) {
            createGame()
        }
    }
}

fun createGame() {
    val playerNames = mutableListOf("", "")
    val players = arrayOfNulls<Player>(2)
    val allCharacters = arrayOfNulls<Character>(6)

    for (i in 0 until 2) {
        var nameIsUnique = false
        while (!nameIsUnique) {
            print("Player ${i + 1} name (unique) : ")
            val name = input.next().uppercase().trim()

            if (i == 1 && name == playerNames[0]) {
                println("Name already taken by Player 1!")
            } else {
                playerNames[i] = name
                nameIsUnique = true
            }
        }

        println("Choosing character for ${playerNames[i]}")
        choosingCharacter(allCharacters, i)

        // On récupère les 3 personnages créés pour ce joueur
        val startIndex = i * 3
        val playerChars = allCharacters.slice(startIndex until startIndex + 3).filterNotNull().toMutableList()

        players[i] = Player(playerNames[i], playerChars)
    }

    // Démarrage du jeu (en supposant que Game prend deux Player non-nulls)
    if (players[0] != null && players[1] != null) {
        Game(players[0]!!, players[1]!!)
    }
}

fun choosingCharacter(alreadyPresent: Array<Character?>, playerPosition: Int) {
    val availableTypes = mutableListOf("WARRIOR", "MAGUS", "COLOSSUS", "DWARF")

    for (i in 0 until 3) {
        var chosenName = ""
        var uniqueNameFound = false

        // Boucle pour le nom unique
        while (!uniqueNameFound) {
            print("Character name (unique) no ${i + 1}: ")
            chosenName = input.next().uppercase().trim()

            // Vérifie si le nom existe déjà dans le tableau global
            val nameExists = alreadyPresent.any { it?.name == chosenName }
            if (nameExists) {
                println("This name is already taken!")
            } else {
                uniqueNameFound = true
            }
        }

        println("Available Types: ${availableTypes.joinToString(", ")}")

        var chosenType = ""
        do {
            print("$chosenName type : ")
            chosenType = input.next().uppercase().trim()
        } while (!availableTypes.contains(chosenType))

        availableTypes.remove(chosenType)

        val character = when (chosenType) {
            "WARRIOR"  -> Warrior(chosenName)
            "COLOSSUS" -> Colossus(chosenName)
            "MAGUS"    -> Magus(chosenName)
            "DWARF"    -> Dwarf(chosenName)
            else       -> throw IllegalArgumentException("Unknown Type: $chosenType")
        }

        alreadyPresent[playerPosition * 3 + i] = character
    }
}

