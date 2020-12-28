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

		var hall = Salle("Vous êtes dans le  hall d'entrée", null, null, null, null )
		salleRepository.save(hall)

		var salon = Salle("Vous êtes dans le  salon", null, null, hall, null)
		salleRepository.save(salon)

		hall.west = salon
		salleRepository.save(hall)

		//Initialize Dungeon
		var bureau = Salle("Vous êtes dans le  bureau", null, null, null, hall)
		var salleAManger = Salle( "Vous êtes dans la salle à manger", null, salon, null, null )
		var cuisine = Salle("Vous êtes dans la cuisine", null, hall, null, salleAManger )
		var chambre1 = Salle("Vous êtes dans une chambre", null, null, null, null )
		var chambre2 = Salle("Vous êtes dans une chambre", null, salleAManger, null, null )
		var salleDeBain = Salle("Vous êtes dans la salle de bain", null, null, null, null )
		var garage = Salle("Vous êtes dans le garage", null, salleDeBain, null, chambre1 )

		//adding characters in dungeon

		//Initialize Players
		var p1 = Personnage(UUID.fromString("123e4567-e89b-42d3-a456-556642440011"), "Je suis un joueur", TypePersonnage.JOUEUR, hall)
		personnageRepository.save(p1)

		var p2 = Personnage(UUID.fromString("c7c9e91a-6013-43e2-b5e5-9c29d6885f2c"), "Je suis un joueur", TypePersonnage.JOUEUR, salon)
		personnageRepository.save(p2)

		// TODO Initialize Monsters
		// 8 monsters
		var m1 = Personnage(UUID.fromString("123e4567-e89b-42d3-a456-556642440022"), "Je suis un monstre", TypePersonnage.MONSTRE, salon)
		personnageRepository.save(m1)
	}
}

fun main(args: Array<String>) {
	runApplication<DungeonApiApplication>(*args)
}
