package project.dungeonApi.mappers

import project.dungeonApi.dto.PersonnageDto
import project.dungeonApi.dto.SalleDto
import project.dungeonApi.entities.Attaque
import project.dungeonApi.entities.Personnage
import project.dungeonApi.entities.ResponseAttack
import project.dungeonApi.entities.Salle

class PersonnageMapper {

    var salleMapper = SalleMapper()

    fun convertToDto( personnage: Personnage ): PersonnageDto {
        return PersonnageDto(personnage.description, personnage.type, personnage.vie, personnage.totalVie)
    }

    fun convertToAttack(player:Personnage, target : Personnage): ResponseAttack{
        var attaquant = Attaque(player.id, target.force, player.vie)
        var attaque = Attaque(target.id, player.force, target.vie)

        return ResponseAttack(attaquant, attaque)
    }


//    fun connectedPlayerDto(personnage : Personnage) : PersonnageDto{
//
//        return PersonnageDto(personnage.description, personnage.totalVie, null, salleMapper.convertToDto(personnage.salleCourante) )
//    }

}