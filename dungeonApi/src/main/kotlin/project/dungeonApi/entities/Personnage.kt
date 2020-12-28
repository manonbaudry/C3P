package project.dungeonApi.entities

import org.hibernate.annotations.NotFound
import org.hibernate.annotations.NotFoundAction
import project.dungeonApi.enums.TypePersonnage
import java.util.*
import javax.persistence.*

@Entity
data class Personnage(
        @Id
        var id: UUID,
        var force: Int,
        var description: String,
        var vie: Int,
        var type: TypePersonnage,
        val totalVie : Int = 100,

        @ManyToOne(fetch = FetchType.LAZY, optional = true)
        @NotFound(action = NotFoundAction.IGNORE)
        var salleCourante: Salle
) {
        constructor(id: UUID, description: String, type: TypePersonnage, salle: Salle) : this(id, 10, description,  100,  type, 100, salle)
}
