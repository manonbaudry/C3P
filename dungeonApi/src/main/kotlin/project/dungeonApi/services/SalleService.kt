package project.dungeonApi.services

import org.springframework.stereotype.Service
import project.dungeonApi.dto.SalleDto
import project.dungeonApi.entities.Salle
import project.dungeonApi.mappers.SalleMapper
import project.dungeonApi.repositories.SalleRepository
import project.dungeonApi.utils.Constant
import java.util.*

@Service
class SalleService(val salleRepository: SalleRepository){

    private val mapper = SalleMapper()

    fun look(id: UUID, personnages: List<UUID>): SalleDto {
        var salle = salleRepository.getOne(id)
        return mapper.convertToDto(salle, personnages)
    }

    fun move(destination: Salle, personnages: List<UUID>): SalleDto {
        return mapper.convertToDto(destination, personnages)
    }

    fun getFisrtRoom() : Salle {
        return salleRepository.getOne(Constant.ID_FIRST_ROOM)
    }
}