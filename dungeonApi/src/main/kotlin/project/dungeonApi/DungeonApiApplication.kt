package project.dungeonApi

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import project.dungeonApi.entities.Personnage
import project.dungeonApi.entities.Salle
import project.dungeonApi.enums.TypePersonnage
import project.dungeonApi.repositories.PersonnageRepository
import project.dungeonApi.repositories.SalleRepository
import project.dungeonApi.utils.Constant
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2
import java.util.*
import kotlin.random.Random

@SpringBootApplication
class DungeonApiApplication{

	@Bean
	fun init(personnageRepository: PersonnageRepository, salleRepository: SalleRepository)  = CommandLineRunner {

		var hall = Salle(Constant.ID_FIRST_ROOM ," Vous êtes dans le  hall d'entrée", null, null, null, null )
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

		var p1 = Personnage(UUID.fromString("123e4567-e89b-42d3-a456-556642440011"), "Je suis un joueur", TypePersonnage.JOUEUR, hall)
		personnageRepository.save(p1)

		var p2 = Personnage(UUID.fromString("c7c9e91a-6013-43e2-b5e5-9c29d6885f2c"), "Je suis un joueur", TypePersonnage.JOUEUR, hall)
		personnageRepository.save(p2)

		var monsterDescription = "Je suis un monstre"

		var m1 = Personnage(UUID.fromString("123e4567-e89b-42d3-a456-556642440022"), monsterDescription, TypePersonnage.MONSTRE, salon)
		personnageRepository.save(m1)

		var vie = Random.nextInt(15, 30)
		var m2 = Personnage(monsterDescription, vie, TypePersonnage.MONSTRE, bureau);
		personnageRepository.save(m2)

		vie = Random.nextInt(15, 30)
		var m3 = Personnage(monsterDescription, vie, TypePersonnage.MONSTRE, salleAManger);
		personnageRepository.save(m3)


		vie = Random.nextInt(15, 30)
		var m4 = Personnage(monsterDescription, vie, TypePersonnage.MONSTRE, cuisine);
		personnageRepository.save(m4)

	}
}

fun main(args: Array<String>) {
	runApplication<DungeonApiApplication>(*args)
}

//Configuration for Swagger

@Configuration
@EnableSwagger2
class SpringFoxConfig {
	@Bean
	fun api(): Docket {
		return Docket(DocumentationType.SWAGGER_2)
			.select()
			.apis(RequestHandlerSelectors.any())
			.paths(PathSelectors.any())
			.build()
	}
}
