package project.dungeonApi.entities

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Attaque(
        @Id
        @GeneratedValue
        var id: String,
        var cible : String,
        var degats : Int,
        var vie : Int
)
