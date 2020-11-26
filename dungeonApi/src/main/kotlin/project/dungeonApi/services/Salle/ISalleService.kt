package project.dungeonApi.services.Salle

import org.springframework.context.annotation.Bean
import project.dungeonApi.dto.SalleDto
import project.dungeonApi.entities.Salle
import java.util.*

interface ISalleService {
    fun getAll(): MutableList<Salle>
    fun look(id: UUID) : SalleDto
}