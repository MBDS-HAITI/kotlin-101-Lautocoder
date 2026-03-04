package com.kotlin.one.battle_arena

import com.kotlin.one.battle_arena.enums.Level
import com.kotlin.one.battle_arena.enums.hpFor
import com.kotlin.one.battle_arena.enums.powerFor

class Dwarf(name: String) : Character(
    name,
    maxHp = hpFor(Level.LOW),
    weapon = Weapon("Axe", powerFor(Level.VERY_HIGH))) {
    override fun getTypeName(): String {
        return "DWARF"
    }

    override fun getTypeDescription(): String {
        return "Très fort mais fragile"
    }

    override fun action(character: Character) {
        attack(character)
        return
    }
}