package project.dungeonApi.services.Personnage

import org.springframework.stereotype.Service
import project.dungeonApi.dto.PersonnageDto
import project.dungeonApi.dto.SalleDto
import project.dungeonApi.entities.Personnage
import project.dungeonApi.entities.ResponseAttack
import project.dungeonApi.entities.Salle
import project.dungeonApi.enums.Direction
import project.dungeonApi.enums.DirectionDto
import project.dungeonApi.exceptions.DeadException
import project.dungeonApi.exceptions.NotSameRoomException
import project.dungeonApi.exceptions.WallException
import project.dungeonApi.mappers.PersonnageMapper
import project.dungeonApi.repositories.PersonnageRepository
import project.dungeonApi.services.Salle.SalleService
import java.util.*
import kotlin.collections.ArrayList

@Service
class PersonnageService(var personnageRepository: PersonnageRepository, var salleService: SalleService) {

    private val personnageMapper = PersonnageMapper()

    fun getAll(): MutableList<Personnage> = personnageRepository.findAll()


    fun look(id: UUID): SalleDto { // TODO gestion des erreurs
        var salleCourante =  personnageRepository.findById(id).get().salleCourante
        var idPersoInSalle : List<UUID> = findIdPersoInSalle(salleCourante)

        return salleService.look(salleCourante.id, idPersoInSalle)
    }

    fun startGame() : PersonnageDto {

        var newPlayer = Personnage(salleService.getFisrtRoom())
        return personnageMapper.convertToDto(newPlayer)
    }

    fun move(id: UUID, direction: DirectionDto): SalleDto {
        var player = personnageRepository.findById(id).get()
        var destination : Salle? = null

        when(direction.direction){
            Direction.N -> destination = player.salleCourante.nord
            Direction.S -> destination = player.salleCourante.sud
            Direction.E ->  destination = player.salleCourante.est
            Direction.W ->  destination = player.salleCourante.west
        }
        if (destination != null) {
            var idPersoInSalle = findIdPersoInSalle(destination)
            player.salleCourante = destination
            personnageRepository.save(player)
            return salleService.move(destination, idPersoInSalle)
        }else
            throw WallException("mur")
    }

    fun examine(id: UUID, targetId: UUID): PersonnageDto {
        var salleJoueur =  personnageRepository.findById(id).get().salleCourante
        var target = personnageRepository.findById(targetId).get()

        if(salleJoueur === target.salleCourante)
            return personnageMapper.convertToDto(target)
        else
            throw NotSameRoomException("Oups, ce perso n'est pas dans la même salle que toi")
    }

    fun hit(id: UUID, targetId: UUID): ResponseAttack {
        var player = personnageRepository.findById(id).get()
        var target = personnageRepository.findById(targetId).get()

        if (player.salleCourante === target.salleCourante){
             //attaque du joueur
            target.vie -= player.force
            if(target.vie <= 0)
               personnageRepository.delete(target)
            else
                personnageRepository.save(target)

             //riposte de la target
            player.vie -= target.force
            if(player.vie <= 0){
                throw DeadException()
            }
            personnageRepository.save(player)
            return personnageMapper.convertToAttack(player, target)
        }
        else
            throw NotSameRoomException("Oups, ce perso n'est pas dans la même salle que toi")
    }

    private fun findIdPersoInSalle(salle :Salle): List<UUID>{
        var personnages = personnageRepository.findBySalleCourante(salle)

        var list :ArrayList<UUID> = arrayListOf()
        for(personnage in personnages){
            list.add(personnage.id)
        }
        return list
    }
}