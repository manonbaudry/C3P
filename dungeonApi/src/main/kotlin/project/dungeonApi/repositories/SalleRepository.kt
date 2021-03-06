package project.dungeonApi.repositories

import org.springframework.data.jpa.repository.JpaRepository
import project.dungeonApi.entities.Personnage
import project.dungeonApi.entities.Salle
import java.util.*

interface SalleRepository : JpaRepository<Salle, UUID> {
}