package com.kotlin.one.battle_arena

import kotlin.math.max
import kotlin.math.min

abstract class Character(
    val name: String,
    val maxHp: Int,
    var hp: Int = maxHp,
    val weapon: Weapon
) : Attacker {

    abstract fun getTypeName(): String

    abstract fun getTypeDescription(): String

    abstract fun action(character: Character)

    override fun attack(target: Character) {
        println("${this.name} is attaking ${target.name}")
        val power = max(0, weapon.power) // Weapon API kept minimal
        if (power == 0) return
        target.receiveDamage(power)
    }

    fun isAlive() : Boolean {
        return hp > 0
    }

    fun receiveDamage(amount: Int) {
        // Cannot take damage if dead; amount must be > 0
        if (!isAlive() || amount <= 0) return
        val before = hp
        // hp >=0
        hp = max(0, hp - amount)
    }

     fun receiveHeal(amount: Int) {
        // Cannot receive healing if dead; amount must be > 0
        if (!isAlive() || amount <= 0) return
        val before = hp
        // hp <= maxHp
        hp = min(maxHp, hp + amount)
    }
    override fun toString(): String {
        if (hp > 0) return name + "  [" + getTypeName() + "] " + hp + "/" + maxHp + " (" + weapon + ")"
        else return name + "  [" + getTypeName() + "] Dead  (" + weapon + ")"
    }
}