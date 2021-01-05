package project.dungeonApi.entities

import java.util.*


data class ResponseAttack(
        val attaque: Attaque,
        val attaquant: Attaque
)

data class Attaque(
        var id: UUID,
        var degats : Int,
        var vie : Int
)
