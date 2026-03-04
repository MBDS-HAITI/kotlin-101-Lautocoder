package com.kotlin.one.battle_arena

import com.kotlin.one.battle_arena.enums.Level
import com.kotlin.one.battle_arena.enums.hpFor
import com.kotlin.one.battle_arena.enums.powerFor

class Colossus(name: String) : Character(
    name,
    maxHp = hpFor(Level.VERY_HIGH),
    weapon = Weapon("Sword", powerFor(Level.MEDIUM))) {
    override fun getTypeName(): String {
        return "COLOSSUS"
    }

    override fun getTypeDescription(): String {
        return "Très résistant"
    }

    override fun action(character: Character) {
        attack(character)
        return
    }
}