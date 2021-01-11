package project.dungeonApi.dto

import project.dungeonApi.enums.TypePersonnage
import java.util.*

data class PersonnageDto (
        var id : UUID,
        var description: String,
        var type : TypePersonnage?,
        var vie : Int,
        var totalVie: Int,
        var force : Int
)