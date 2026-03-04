package com.kotlin.one.battle_arena

import java.util.Scanner

class Game(private val player1: Player, private val player2: Player) {

    private val input = Scanner(System.`in`)

    init {
        // En Kotlin, le bloc init est l'équivalent du corps du constructeur
        println("Beginning the game")
        play()
    }

    private fun play() {
        var round = 0

        while (!player1.isDefeated() && !player2.isDefeated()) {
            println(stat())

            // Détermination de l'attaquant et de la cible
            var actor = if (round % 2 == 0) player1 else player2
            var sufferer = if (round % 2 == 0) player2 else player1

            var action = "attack"

            val actorCharacter = choosingACharacter(actor)

            // Logique spécifique au MAGUS
            if (actorCharacter.getTypeName() == "MAGUS") {
                action = "heal"
                sufferer = actor // Il soigne son équipe
            }

            println("Select whom $actorCharacter should $action")

            val suffererCharacter = choosingACharacter(sufferer)

            // Exécution de l'action ( Polymorphisme )
            actorCharacter.action(suffererCharacter)

            round++
        }

        // Fin de partie
        val winner = if (player1.isDefeated()) player2 else player1
        println("$winner won in ${round / 2} rounds")

        println(stat())
    }

    private fun choosingACharacter(player: Player): Character {
        var chosenName: String
        var playingCharacter: Character? = null

        while (playingCharacter == null) {
            println("Select a member of $player : ")
            println(player.aliveMembers()) // On suppose que cela renvoie une liste lisible

            chosenName = input.next().uppercase().trim()

            // Utilisation de find pour simplifier la recherche
            playingCharacter = player.aliveMembers().find { it?.name == chosenName }

            if (playingCharacter == null) {
                println("Character not found or dead. Try again.")
            }
        }

        return playingCharacter
    }

    private fun stat(): String {
        val p1Stats = player1.teamStat() // On suppose que c'est une List<String>
        val p2Stats = player2.teamStat()

        // Utilisation des triple quotes pour un formatage multiligne plus propre
        return """
            $player1                      $player2
            -------                      -------
            ${p1Stats.getOrNull(0) ?: ""}          ${p2Stats.getOrNull(0) ?: ""}
            ${p1Stats.getOrNull(1) ?: ""}          ${p2Stats.getOrNull(1) ?: ""}
            ${p1Stats.getOrNull(2) ?: ""}          ${p2Stats.getOrNull(2) ?: ""}
        """.trimIndent()
    }
}