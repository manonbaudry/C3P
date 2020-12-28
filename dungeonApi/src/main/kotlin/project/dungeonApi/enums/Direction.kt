package project.dungeonApi.enums

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.databind.annotation.JsonDeserialize


@JsonDeserialize
enum class Direction {
    N, S, E, W
}