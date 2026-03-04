package com.kotlin.one.battle_arena.enums

enum class Level (val power: Int, val hp: Int){
    LOW(30, 40),
    MEDIUM(40, 60),
    HIGH(50, 80),
    VERY_HIGH(60, 100)
}

enum class ActionType {
    ATTACK,
    HEALER
}

fun powerFor(level: Level): Int = level.power

fun hpFor(level: Level): Int = level.hp