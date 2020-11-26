package project.dungeonApi.mappers

import project.dungeonApi.dto.SalleDto
import project.dungeonApi.entities.Personnage
import project.dungeonApi.entities.Salle
import java.util.*
import kotlin.collections.ArrayList

class SalleMapper {

    fun convertToDto(salle : Salle): SalleDto{
        var salles = listDoors(salle)
        var entites = listEntities(salle.entites)
        return SalleDto(salle.id, salle.nom, entites, salle.description, salles)

    }

    private fun listEntities(joueurs: List<Personnage>): ArrayList<UUID> {
        var entites : ArrayList<UUID> = arrayListOf()
        for(joueur in joueurs)
            entites.add(joueur.id)
        return entites
    }

    private fun listDoors(salle: Salle): ArrayList<String> {
        var directions : ArrayList<String> = arrayListOf()

        directions?.add(salle.nord.toString())
        directions?.add(salle.sud.toString())
        directions?.add(salle.est.toString())
        directions?.add(salle.ouest.toString())

        return directions
    }

}