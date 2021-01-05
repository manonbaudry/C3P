package project.dungeonApi.mappers

import project.dungeonApi.dto.SalleDto
import project.dungeonApi.entities.Salle
import project.dungeonApi.enums.Direction
import java.util.*
import kotlin.collections.ArrayList

class SalleMapper {

    fun convertToDto(salle: Salle, personnages: List<UUID>, ): SalleDto{
        var doors = listDoors(salle)
        return SalleDto(salle.description, doors, personnages)
    }

    private fun listDoors(salle: Salle): ArrayList<String> {
        var directions : ArrayList<String> = arrayListOf()

        if(salle.nord != null)
            directions.add(Direction.N.toString())
        if(salle.sud != null)
            directions.add(Direction.S.toString())
        if(salle.est != null)
            directions.add(Direction.E.toString())
        if(salle.west != null)
            directions.add(Direction.W.toString())

        return directions
    }
}