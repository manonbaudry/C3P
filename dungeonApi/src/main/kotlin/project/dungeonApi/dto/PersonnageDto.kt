package project.dungeonApi.dto

import project.dungeonApi.enums.TypePersonnage

data class PersonnageDto (
        var id: String,
        var nom: String,
        var force: Int = 10,
        var totalVie: Int = 20,
        var type : TypePersonnage
        )