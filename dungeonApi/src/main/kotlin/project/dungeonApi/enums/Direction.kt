package project.dungeonApi.enums

import com.fasterxml.jackson.annotation.JsonProperty

enum class Direction {
    N, S, E, W
}

class DirectionDto {

    @JsonProperty
    val direction : Direction? = null

    constructor() {
    }
}