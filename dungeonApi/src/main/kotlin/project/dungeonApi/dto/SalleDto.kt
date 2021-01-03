package project.dungeonApi.dto

import java.util.*

data class SalleDto(
        var description : String,
        var passage : List<String>,
        var entites: List<UUID>,
)
