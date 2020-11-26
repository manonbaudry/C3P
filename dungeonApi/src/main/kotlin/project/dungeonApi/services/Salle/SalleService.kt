package project.dungeonApi.services.Salle

import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.Mapping
import project.dungeonApi.dto.SalleDto
import project.dungeonApi.entities.Salle
import project.dungeonApi.mappers.SalleMapper
import project.dungeonApi.repositories.SalleRepository
import java.util.*

@Service
class SalleService(val salleRepository: SalleRepository) : ISalleService {

    val mapper = SalleMapper()

    override fun getAll(): MutableList<Salle> {
        return salleRepository.findAll()
    }

    override fun look(id: UUID): SalleDto {
        var salle = salleRepository.getOne(id)
        return mapper.convertToDto(salle)
    }
}