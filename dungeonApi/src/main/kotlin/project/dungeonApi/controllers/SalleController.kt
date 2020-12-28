package project.dungeonApi.controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import project.dungeonApi.dto.SalleDto
import project.dungeonApi.entities.Salle
import project.dungeonApi.services.Salle.SalleService
import java.util.*

@RestController
class SalleController(val salleService: SalleService) {


}