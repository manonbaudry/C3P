package project.dungeonApi.entities

import org.hibernate.annotations.NotFound
import org.hibernate.annotations.NotFoundAction
import project.dungeonApi.enums.TypePersonnage
import java.util.*
import javax.persistence.*
import kotlin.random.Random

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
        constructor(id: UUID, description: String, type: TypePersonnage, salle: Salle) : this(id, Random.nextInt(15, 30), description,  100,  type, 100, salle)
        constructor(salle: Salle) : this(UUID.randomUUID(), Random.nextInt(15, 30), "Je suis un joueur",  100,  TypePersonnage.JOUEUR, 100, salle)
        constructor(description: String, vie: Int,type: TypePersonnage,  salle: Salle) : this(UUID.randomUUID(), Random.nextInt(5, 25), description,  vie, type, vie, salle)

}
