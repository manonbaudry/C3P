package project.dungeonApi.dto

import project.dungeonApi.entities.Personnage
import java.util.*
import javax.persistence.OneToMany

data class SalleDto(
        var description : String,
        var passage : List<String>,
        var entites: List<UUID>,
)
