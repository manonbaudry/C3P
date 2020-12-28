package project.dungeonApi.entities

import java.util.*
import javax.persistence.*

@Entity
data class Salle(
        @Id
        var id: UUID,
        var description : String,

        @OneToOne(fetch = FetchType.LAZY, optional = true)
        var nord : Salle?,
        @OneToOne(fetch = FetchType.LAZY, optional = true)
        var sud : Salle?,
        @OneToOne(fetch = FetchType.LAZY, optional = true)
        var est : Salle?,
        @OneToOne(fetch = FetchType.LAZY, optional = true)
        var west: Salle?
){
        constructor(description: String, nord: Salle?, sud: Salle?, est: Salle?, ouest: Salle?)
                : this(UUID.randomUUID(), description, nord, sud, est, ouest)
}