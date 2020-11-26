package project.dungeonApi.controllers.entities

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import project.dungeonApi.dto.SalleDto
import project.dungeonApi.entities.Salle
import project.dungeonApi.services.Salle.ISalleService
import java.util.*

@RestController
class SalleController(val salleService: ISalleService) {
    @GetMapping("/salles")
    fun getAll(): MutableList<Salle> = salleService.getAll()

    @GetMapping("{id}/regarder")
    fun look(@PathVariable("id") id: UUID)  : SalleDto {
        return salleService.look(id)
    }


}