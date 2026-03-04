package com.kotlin.one.battle_arena

import java.util.List


class Player(
    val name: String,
    val team: MutableList<Character>
) {
    fun isDefeated(): Boolean {
        return team.stream().noneMatch { obj: Character? -> obj!!.isAlive() }
    }

    fun aliveCount(): Int {
        return team.stream().filter { obj: Character? -> obj!!.isAlive() }.count().toInt()
    }

    fun aliveMembers(): MutableList<Character?> {
        return team.stream().filter { obj: Character? -> obj!!.isAlive() }.toList()
    }

    fun hasType(typeName: String?): Boolean {
        return team.stream().anyMatch { c: Character? -> c!!.getTypeName() == typeName }
    }

    fun findByName(characterName: String?): Character? {
        return team.stream().filter { c: Character? -> c!!.name == characterName }.findFirst().orElse(null)
    }

    override fun toString(): String {
        return this.name
    }

    fun teamStat(): MutableList<String?> {
        val stats: MutableList<String?> = ArrayList<String?>()
        for (character in this.team) stats.add(character.toString())
        return stats
    }



    private fun validateTeam(team: MutableList<Character>) {
        require(team.size == 3) { "team must contain exactly 3 characters (got " + team.size + ")" }
        for (i in team.indices) {
            requireNotNull(team.get(i)) { "team contains a null character at index " + i }
            require(team.get(i).isAlive()) { "character at index " + i + " is not alive at start" }
        }
        validateUniqueTypes(team)
    }

    private fun validateUniqueTypes(team: MutableList<Character>) {
        val seen: MutableSet<String?> = HashSet<String?>()
        for (c in team) {
            val type = c.getTypeName()
            require(!(type == null || type.isBlank())) { "character type name must be non-blank" }
            require(seen.add(type)) { "duplicate character type in team: " + type }
        }
    }
}