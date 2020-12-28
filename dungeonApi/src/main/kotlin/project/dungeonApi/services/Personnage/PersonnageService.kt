package project.dungeonApi.services.Personnage

import org.springframework.stereotype.Service
import project.dungeonApi.dto.PersonnageDto
import project.dungeonApi.dto.SalleDto
import project.dungeonApi.entities.Personnage
import project.dungeonApi.entities.Salle
import project.dungeonApi.enums.Direction
import project.dungeonApi.exceptions.NotSameRoomException
import project.dungeonApi.exceptions.WallException
import project.dungeonApi.mappers.PersonnageMapper
import project.dungeonApi.mappers.SalleMapper
import project.dungeonApi.repositories.PersonnageRepository
import project.dungeonApi.services.Salle.SalleService
import java.util.*
import kotlin.collections.ArrayList

@Service
class PersonnageService(var personnageRepository: PersonnageRepository, var salleService: SalleService) {

    private val personnageMapper = PersonnageMapper()
    private val salleMapper = SalleMapper()

    fun getAll(): MutableList<Personnage> = personnageRepository.findAll()


    fun look(id: UUID): SalleDto { // TODO gestion des erreurs
        var salleCourante =  personnageRepository.findById(id).get().salleCourante
        var idPersoInSalle : List<UUID> = findIdBySalleCourante(salleCourante)

        return salleService.look(salleCourante.id, idPersoInSalle)
    }

    fun startGame(personnage: Personnage) : PersonnageDto {
        throw NotImplementedError()
    }

    fun move(id: UUID, direction: Direction): SalleDto {
        var salleCourante =  personnageRepository.findById(id).get().salleCourante
        var idPersoInSalle = findIdBySalleCourante(salleCourante)

        var destination : Salle?

        when(direction){
            Direction.N -> destination = salleCourante.nord
            Direction.S -> destination = salleCourante.sud
            Direction.E ->  destination = salleCourante.est
            Direction.W ->  destination = salleCourante.west
        }

        if (destination != null)
            return salleMapper.convertToDto(destination, idPersoInSalle)
        else
            throw WallException("Oups, c'était un mur")
    }

    fun examine(id: UUID, targetId: UUID): PersonnageDto {
        var salleJoueur =  personnageRepository.findById(id).get().salleCourante
        var target = personnageRepository.findById(targetId).get()

        if(salleJoueur === target.salleCourante)
            return personnageMapper.convertToDto(target)
        else
            throw NotSameRoomException("Oups, ce perso n'est pas dans la même salle que toi")
    }

    fun hit(id: UUID, targetId: UUID): MutableList<PersonnageDto> {
        throw NotImplementedError()
    }


    private fun findIdBySalleCourante(salle :Salle): List<UUID>{
        var personnages = personnageRepository.findBySalleCourante(salle)

        var list :ArrayList<UUID> = arrayListOf()
        for(personnage in personnages){
            list.add(personnage.id)
        }
        return list
    }
}