package com.kotlin.one.battle_arena

import com.kotlin.one.battle_arena.enums.Level
import com.kotlin.one.battle_arena.enums.hpFor
import com.kotlin.one.battle_arena.enums.powerFor

class Warrior(name: String) : Character(
    name,
    maxHp = hpFor(Level.MEDIUM),
    weapon = Weapon("Axe", powerFor(Level.MEDIUM))) {
    override fun getTypeName(): String {
        return "WARRIOR"
    }

    override fun getTypeDescription(): String {
        return  "Attaquant équilibré"
    }

    override fun action(character: Character) {
        attack(character)
        return
    }
}