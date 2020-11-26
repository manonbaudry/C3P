package project.dungeonApi.entities

import java.util.*
import javax.persistence.*

@Entity
data class Salle(
        @Id
        @GeneratedValue
        var id: UUID,
        var nom: String,
        @OneToMany
        var entites: List<Personnage>,
        var description : String,
        @OneToOne
        var nord : Salle?,
        @OneToOne
        var sud : Salle?,
        @OneToOne
        var est : Salle?,
        @OneToOne
        var ouest : Salle?
)
