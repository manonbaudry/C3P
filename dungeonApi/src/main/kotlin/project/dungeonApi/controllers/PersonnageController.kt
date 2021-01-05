package project.dungeonApi.controllers

import org.springframework.data.domain.Sort
import org.springframework.web.bind.annotation.*
import project.dungeonApi.dto.PersonnageDto
import project.dungeonApi.dto.SalleDto
import project.dungeonApi.entities.Personnage
import project.dungeonApi.entities.ResponseAttack
import project.dungeonApi.enums.Direction
import project.dungeonApi.enums.DirectionDto
import project.dungeonApi.services.Personnage.PersonnageService
import java.util.*

@RestController
class PersonnageController(val personnageService: PersonnageService) {
    @GetMapping("/joueurs")
    fun getAll(): MutableList<Personnage> = personnageService.getAll()

    @PostMapping("/connect")
    fun startGame() : PersonnageDto {
        return personnageService.startGame()
    }

    @GetMapping("{id}/regarder")
    fun look(@PathVariable("id") id: UUID)  : SalleDto {
        return personnageService.look(id)
    }

    @PostMapping("/{id}/deplacement")
    fun move(@PathVariable("id")id : UUID, @RequestBody direction : DirectionDto) : SalleDto {
        return personnageService.move(id, direction)
    }

    @GetMapping("/{id}/examiner/{targetId}")
    fun examine(@PathVariable("id")id : UUID, @PathVariable("targetId") targetId : UUID) : PersonnageDto{
        return personnageService.examine(id, targetId)
    }

    @PostMapping("/{id}/taper/{targetId}")
    fun hit(@PathVariable("id")id : UUID,  @PathVariable("targetId") targetId : UUID) :  ResponseAttack  {
        return personnageService.hit(id, targetId)
    }
}