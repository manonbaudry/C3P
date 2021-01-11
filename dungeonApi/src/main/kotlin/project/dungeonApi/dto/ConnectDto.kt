package project.dungeonApi.dto

import project.dungeonApi.enums.TypePersonnage

data class ConnectDto (
    var description: String,
    var totalVie: Int,
    var force : Int,
    var salle : SalleDto
)