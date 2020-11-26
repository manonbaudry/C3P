package project.dungeonApi

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import project.dungeonApi.entities.Personnage
import project.dungeonApi.entities.Salle
import project.dungeonApi.enums.TypePersonnage
import project.dungeonApi.repositories.PersonnageRepository
import project.dungeonApi.repositories.SalleRepository
import java.util.*

@SpringBootApplication
class DungeonApiApplication{

	@Bean
	fun init(personnageRepository: PersonnageRepository, salleRepository: SalleRepository)  = CommandLineRunner {

		var p1 = Personnage(UUID.randomUUID(), "Jojo", 10, 20, TypePersonnage.JOUEUR)
		personnageRepository.save(p1)

		var p2 = Personnage(UUID.randomUUID(), "Manou", 10, 20, TypePersonnage.JOUEUR)
		personnageRepository.save(p2)

		var hall = Salle(UUID.randomUUID(), "Entrée", listOf(p1), "Vous êtes dans le  hall d'entrée", null, null, null, null )
		salleRepository.save(hall)

//		var salon = Salle(UUID.fromString("123e4567-e89b-42d3-a456-556642440011"), "Salon", arrayListOf(p1), "Vous êtes dans le  salon", null, null, null, null )
//		salleRepository.save(salon)

	}

}

fun main(args: Array<String>) {
	runApplication<DungeonApiApplication>(*args)
}
