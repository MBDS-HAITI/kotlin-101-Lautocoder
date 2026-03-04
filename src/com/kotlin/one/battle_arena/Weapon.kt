package com.kotlin.one.battle_arena

class Weapon(
    val name: String,
    val power: Int
) {
    override fun toString(): String {
        return "$name ($power)"
    }
}
