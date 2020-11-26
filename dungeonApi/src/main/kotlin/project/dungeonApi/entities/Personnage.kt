package project.dungeonApi.entities

import project.dungeonApi.enums.TypePersonnage
import java.util.*
import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class Personnage(
        @Id
        var id: UUID,
        var nom: String,
        var force: Int = 10,
        var totalVie: Int = 20,
        var type : TypePersonnage
)