package com.kotlin.one.battle_arena

import com.kotlin.one.battle_arena.enums.Level
import com.kotlin.one.battle_arena.enums.hpFor
import com.kotlin.one.battle_arena.enums.powerFor

class Magus(name: String) : Character (
    name,
    maxHp = hpFor(Level.HIGH),
    weapon = Weapon("Staff", powerFor(Level.LOW))), Healer {
    override fun getTypeName(): String {
        return "MAGUS"
    }

    override fun getTypeDescription(): String {
        return "Peut soigner ses alliés";
    }

    override fun action(character: Character) {
        attack(character)
        return
    }

    override fun heal(ally: Character) {
        // Can not heal if ally dead or hp =maxHp
        println("${this.name} is healing ${ally.name}")
        if (ally.hp <= 0 || ally.hp == ally.maxHp) return
        ally.receiveHeal(weapon.power)
    }
}