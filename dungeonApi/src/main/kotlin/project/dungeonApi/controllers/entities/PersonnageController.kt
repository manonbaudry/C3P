package project.dungeonApi.controllers.entities

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import project.dungeonApi.entities.Personnage
import project.dungeonApi.repositories.PersonnageRepository

@RestController
class PersonnageController(val personnageRepository : PersonnageRepository) {
    @GetMapping("/joueurs")
    fun getAll(): MutableList<Personnage> = personnageRepository.findAll()
}