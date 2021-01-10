package project.dungeonApi.controllers

import org.springframework.web.bind.annotation.*
import project.dungeonApi.dto.PersonnageDto
import project.dungeonApi.dto.SalleDto
import project.dungeonApi.entities.Personnage
import project.dungeonApi.entities.ResponseAttack
import project.dungeonApi.enums.DirectionDto
import project.dungeonApi.services.PersonnageService
import java.util.*


@RestController
class PersonnageController(val personnageService: PersonnageService) {

    /***
     * Lists all the characters in the game (monsters and players)
     */
    @GetMapping("/personnages")
    fun getAll(): MutableList<Personnage> = personnageService.getAll()

    /**
     * initialize a player, place him in the first room and initialize his strength randomly
     *
     * response :
     *   "guid": <guid>
     *  "totalvie": <integer>
     */
    @PostMapping("/connect")
    fun startGame() : PersonnageDto {
        return personnageService.startGame()
    }

    /**
     * examines the content of the room. It may contain other players and/or monsters.
     * Returns the existing doors and GUIDs of the characters present.
     *
     * response :
     *  "description": <description (string)>
     *  "passages": [ "N", "E", ... ]
     *  "entites": [ <guid1>, <guid2>, <guid3>, ...]
     */
    @GetMapping("{id}/regarder")
    fun look(@PathVariable("id") id: UUID)  : SalleDto {
        return personnageService.look(id)
    }

    /**
     * moves the player from one piece to another.
     * returns the description of the new room
     *
     * response :
     *  "description": <description (string)>
     *  "passages": [ "N", "E", ... ]
     *  "entites": [ <guid1>, <guid2>, <guid3>, ...]
     */
    @PostMapping("/{id}/deplacement")
    fun move(@PathVariable("id")id : UUID, @RequestBody direction : DirectionDto) : SalleDto {
        return personnageService.move(id, direction)
    }

    /**
     * examines a character, returns the description of it
     *
     * response :
     *  "description": <description>
     *  "type" : "JOUEUR" | "MONSTRE"
     *  "vie": <integer>
     *  "totalvie": <integer>
     */
    @GetMapping("/{id}/examiner/{targetId}")
    fun examine(@PathVariable("id")id : UUID, @PathVariable("targetId") targetId : UUID) : PersonnageDto{
        return personnageService.examine(id, targetId)
    }

    /**
     * hits a target (character)
     * the target strikes back
     * the character loses as many life points as the attacker's strength
     *
     * response :
     *   "attaquant": {
            "guid": <guid>
            "degats": <integer>
            "vie": <integer>
        }
        "attaque": {
            "guid": <guid>
            "degats": <integer>
            "vie": <integer>
        }
     */
    @PostMapping("/{id}/taper/{targetId}")
    fun hit(@PathVariable("id")id : UUID,  @PathVariable("targetId") targetId : UUID) :  ResponseAttack  {
        return personnageService.hit(id, targetId)
    }
}